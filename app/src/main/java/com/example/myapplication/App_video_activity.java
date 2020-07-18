package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.material.card.MaterialCardView;

public class App_video_activity extends AppCompatActivity {

    PlayerView playerView;
    ProgressBar progressBar;
    SimpleExoPlayer simpleExoPlayer;
    MaterialCardView materialCardView;
    FrameLayout frame;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_video_activity);

        frame = findViewById(R.id.camera_frag);
        materialCardView = findViewById(R.id.doing_btn);
        frame.setVisibility(View.VISIBLE);
        startConfigFragment();
        constraintLayout = findViewById(R.id.video_layout);
        constraintLayout.setVisibility(View.GONE);
//
//        materialCardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                materialCardView.setVisibility(View.GONE);
//                frame.setVisibility(View.VISIBLE);
//                setFragment(new Camera_Fragment());
//            }
//        });

        playerView = findViewById(R.id.player_view);
        progressBar = findViewById(R.id.progress_bar);

        // make it full screen
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        // video url
//        Uri video = Uri.parse("https://i.imgur.com/7bMqysJ.mp4");
//
//        // Initialize load control
//        LoadControl loadControl = new DefaultLoadControl();
//
//        // Initialize bandwidth meter
//        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
//
//        // Initialize track selector
//        TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
//
//        // Initialize simple exoplayer
//        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(App_video_activity.this,trackSelector,loadControl);
//
//        //Init data source factory
//        DefaultHttpDataSourceFactory factory = new DefaultHttpDataSourceFactory("exoplayer_video");
//
//        //Init extractors factory
//        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
//
//        //Init media source
//        MediaSource mediaSource = new ExtractorMediaSource(video,factory,extractorsFactory,null,null);
//
//        // set player
//        playerView.setPlayer(simpleExoPlayer);
//
//        // keep on screen
//        playerView.setKeepScreenOn(true);
//
//        //prepare media
//        simpleExoPlayer.prepare(mediaSource);
//
//        //play video when ready
//        simpleExoPlayer.setPlayWhenReady(true);
//        simpleExoPlayer.addListener(new Player.EventListener() {
//            @Override
//            public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {
//
//            }
//
//            @Override
//            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
//
//            }
//
//            @Override
//            public void onLoadingChanged(boolean isLoading) {
//
//            }
//
//            @Override
//            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
//                // check condition
//                if (playbackState == Player.STATE_BUFFERING){
//                    // when Buffering
//                    // show Progress bar
//                    progressBar.setVisibility(View.VISIBLE);
//                }else if (playbackState == Player.STATE_READY){
//                    // when ready
//                    // hide progress bar
//                    progressBar.setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void onRepeatModeChanged(int repeatMode) {
//
//            }
//
//            @Override
//            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
//
//            }
//
//            @Override
//            public void onPlayerError(ExoPlaybackException error) {
//
//            }
//
//            @Override
//            public void onPositionDiscontinuity(int reason) {
//
//            }
//
//            @Override
//            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
//
//            }
//
//            @Override
//            public void onSeekProcessed() {
//
//            }
//        });
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        // stop video when ready
//        simpleExoPlayer.setPlayWhenReady(false);
//        //get playback state
//        simpleExoPlayer.getPlaybackState();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        //play video when ready
//        simpleExoPlayer.setPlayWhenReady(true);
//        // get playback state
//        simpleExoPlayer.getPlaybackState();
//    }
//    @Override
//    public void onBackPressed() {
//        if(materialCardView.getVisibility() == View.GONE){
//            materialCardView.setVisibility(View.VISIBLE);
//            frame.setVisibility(View.GONE);
//        } else {
//            finish();
//        }

    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.camera_frag,fragment);
        fragmentTransaction.commit();
    }
    public void startStreamingFragment(Bundle extras) {
        try {
            Camera_Fragment streamFragment = Camera_Fragment.newInstance(this);
            streamFragment.setArguments(extras);
            this.setFragment(streamFragment);
        } catch (Exception e) {
            Log.e("", "Failed to start streaming fragment.");
            e.printStackTrace();
        }
    }
    public void startConfigFragment() {
        try {
            Fragment streamFragment = StreamConfigurationFragment.newInstance(this);
            setFragment(streamFragment);
        } catch (Exception e) {
            Log.e("", "Failed to go back to configure stream.");
            e.printStackTrace();
        }
    }
}