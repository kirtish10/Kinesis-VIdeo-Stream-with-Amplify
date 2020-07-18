package com.example.myapplication;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.kinesisvideo.client.KinesisVideoClient;
import com.amazonaws.kinesisvideo.client.mediasource.CameraMediaSourceConfiguration;
import com.amazonaws.kinesisvideo.common.exception.KinesisVideoException;
import com.amazonaws.kinesisvideo.producer.StreamInfo;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobileconnectors.kinesisvideo.client.KinesisVideoAndroidClientFactory;
import com.amazonaws.mobileconnectors.kinesisvideo.data.MimeType;
import com.amazonaws.mobileconnectors.kinesisvideo.mediasource.android.AndroidCameraMediaSourceConfiguration;
import com.amazonaws.regions.Regions;
import com.example.myapplication.ui.adapter.ToStrings;
import com.example.myapplication.ui.widget.StringSpinnerWidget;

import java.util.HashMap;

import static com.amazonaws.mobileconnectors.kinesisvideo.util.CameraUtils.getCameras;
import static com.amazonaws.mobileconnectors.kinesisvideo.util.CameraUtils.getSupportedResolutions;
import static com.amazonaws.mobileconnectors.kinesisvideo.util.VideoEncoderUtils.getSupportedMimeTypes;

public class StreamConfigurationFragment extends Fragment {
    private static final String TAG = StreamConfigurationFragment.class.getSimpleName();
    private static final Size RESOLUTION_320x240 = new Size(320, 240);
    private static final int FRAMERATE_20 = 20;
    private static final int FRAMERATE_7 = 7;

    private static final int BITRATE_384_KBPS = 384 * 1024;
    private static final int BITRATE_500_KBPS = 500 * 1024;

    private static final int RETENTION_PERIOD_48_HOURS = 2 * 24;


    private Button mStartStreamingButton;
    //    private EditText mStreamName;
    private KinesisVideoClient mKinesisVideoClient;
    private StringSpinnerWidget<CameraMediaSourceConfiguration> mCamerasDropdown;
    private StringSpinnerWidget<Size> mResolutionDropdown;
    private StringSpinnerWidget<MimeType> mMimeTypeDropdown;

    private App_video_activity navActivity;

//    CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
//            getContext(),
//            AWSMobileClient.getInstance().getIdentityId(), // Identity pool ID
//            Regions.US_EAST_2 // Region
//    );

    String idToken = "";


    public static StreamConfigurationFragment newInstance(App_video_activity navActivity) {
        StreamConfigurationFragment s = new StreamConfigurationFragment();
        s.navActivity = navActivity;
        return s;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final ViewGroup container,
                             final Bundle savedInstanceState) {
        if (ContextCompat.checkSelfPermission(this.getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this.getActivity(), new String[]{Manifest.permission.CAMERA}, 9393);
        }

        getActivity().setTitle(getActivity().getString(R.string.title_fragment_stream));

//        HashMap<String,String> login_details = new HashMap<>();
//        login_details.put("cognito-idp.ap-south-1.amazonaws.com/ap-south-1_ZcUfBkAlq",idToken);
//        credentialsProvider.setLogins(login_details);

        final View view = inflater.inflate(R.layout.fragment_stream_configuration, container, false);

        try {
            mKinesisVideoClient = KinesisVideoAndroidClientFactory.createKinesisVideoClient(
                    getActivity(),
                    KinesisVideoDemoApp.KINESIS_VIDEO_REGION, AWSMobileClient.getInstance()) ;   // at this point
        } catch (KinesisVideoException e) {
            Log.e(TAG, "Failed to create Kinesis Video client", e);
        }

        mCamerasDropdown = new StringSpinnerWidget<>(
                getActivity(),
                view,
                R.id.cameras_spinner,
                ToStrings.CAMERA_DESCRIPTION,
                getCameras(mKinesisVideoClient));

        mCamerasDropdown.setItemSelectedListener(
                new StringSpinnerWidget.ItemSelectedListener<CameraMediaSourceConfiguration>() {
                    @Override
                    public void itemSelected(final CameraMediaSourceConfiguration mediaSource) {
                        mResolutionDropdown = new StringSpinnerWidget<>(
                                getActivity(),
                                view,
                                R.id.resolutions_spinner,
                                getSupportedResolutions(getActivity(), mediaSource.getCameraId()));
                        select640orBelow();
                    }
                });

        mMimeTypeDropdown = new StringSpinnerWidget<>(
                getActivity(),
                view,
                R.id.codecs_spinner,
                getSupportedMimeTypes());

        return view;
    }

    private void select640orBelow() {
        Size tmpSize = new Size(0, 0);
        int indexToSelect = 0;
        for (int i = 0; i < mResolutionDropdown.getCount(); i++) {
            final Size resolution = mResolutionDropdown.getItem(i);
            if (resolution.getWidth() <= RESOLUTION_320x240.getWidth()
                    && tmpSize.getWidth() <= resolution.getWidth()
                    && resolution.getHeight() <= RESOLUTION_320x240.getHeight()
                    && tmpSize.getHeight() <= resolution.getHeight()) {

                tmpSize = resolution;
                indexToSelect = i;
            }
        }

        mResolutionDropdown.selectItem(indexToSelect);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        mStartStreamingButton = (Button) view.findViewById(R.id.start_streaming);
        mStartStreamingButton.setOnClickListener(startStreamingActivityWhenClicked());
//        mStreamName = (EditText) view.findViewById(R.id.stream_name);
    }

    private View.OnClickListener startStreamingActivityWhenClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                startStreamingActivity();
            }
        };
    }

    private void startStreamingActivity() {
        final Bundle extras = new Bundle();

        extras.putParcelable(
                Camera_Fragment.KEY_MEDIA_SOURCE_CONFIGURATION,
                getCurrentConfiguration());

        extras.putString(
                Camera_Fragment.KEY_STREAM_NAME,
                "Testing");     // stream name is the user name
//                mStreamName.getText().toString());

        navActivity.startStreamingFragment(extras);
    }

    private AndroidCameraMediaSourceConfiguration getCurrentConfiguration() {
        return new AndroidCameraMediaSourceConfiguration(
                AndroidCameraMediaSourceConfiguration.builder()
                        .withCameraId(mCamerasDropdown.getSelectedItem().getCameraId())
                        .withEncodingMimeType(mMimeTypeDropdown.getSelectedItem().getMimeType())
                        .withHorizontalResolution(mResolutionDropdown.getSelectedItem().getWidth())
                        .withVerticalResolution(mResolutionDropdown.getSelectedItem().getHeight())
                        .withCameraFacing(mCamerasDropdown.getSelectedItem().getCameraFacing())
                        .withIsEncoderHardwareAccelerated(
                                mCamerasDropdown.getSelectedItem().isEndcoderHardwareAccelerated())
                        .withFrameRate(FRAMERATE_7)
                        .withRetentionPeriodInHours(RETENTION_PERIOD_48_HOURS)
                        .withEncodingBitRate(BITRATE_500_KBPS)
                        .withCameraOrientation(-mCamerasDropdown.getSelectedItem().getCameraOrientation())
                        .withNalAdaptationFlags(StreamInfo.NalAdaptationFlags.NAL_ADAPTATION_ANNEXB_CPD_AND_FRAME_NALS)
                        .withIsAbsoluteTimecode(false));
    }
}