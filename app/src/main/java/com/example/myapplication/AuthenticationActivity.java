package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.HostedUIOptions;
import com.amazonaws.mobile.client.UserStateDetails;
import com.amazonaws.mobile.client.results.Tokens;
import com.amplifyframework.core.Amplify;
import com.amazonaws.mobile.client.SignInUIOptions;

public class AuthenticationActivity extends AppCompatActivity {

    private final String TAG = AuthenticationActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        getCredentialProvider().initialize(getApplicationContext(), new Callback<UserStateDetails>() {
            @Override
            public void onResult(UserStateDetails result) {
                Log.i(TAG,result.getUserState().toString());
                switch (result.getUserState())
                {
                    case SIGNED_IN:
                        getCredentialProvider().getTokens(
                                new Callback<Tokens>() {
                                    @Override
                                    public void onResult(Tokens result) {
                                        Intent i = new Intent(AuthenticationActivity.this,App_video_activity.class);
                                        startActivity(i);
                                    }

                                    @Override
                                    public void onError(Exception e) {

                                    }
                                }
                        );



                    case SIGNED_OUT:
                        getCredentialProvider().showSignIn(AuthenticationActivity.this,
                                SignInUIOptions.builder()
//                                        .logo(R.drawable.logo)
//                                        .backgroundColor(R.color._bg__namaha___1_ek2_color)
                                        .nextActivity(App_video_activity.class)
                                        .build(),
                                new Callback<UserStateDetails>() {
                                    @Override
                                    public void onResult(UserStateDetails result) {
                                        Log.d(TAG, "onResult: User signed-in " + result.getUserState());
                                    }

                                    @Override
                                    public void onError(final Exception e) {
                                        runOnUiThread(() ->{

                                            Log.e(TAG, "onError: User sign-in error", e);
                                            Toast.makeText(AuthenticationActivity.this, "User sign-in error: " + e.getMessage(), Toast.LENGTH_LONG).show();

                                        });
                                    }
                                });

//                    default:
//                        AWSMobileClient.getInstance().signOut();
//                        try {
//                            AWSMobileClient.getInstance().showSignIn(AuthenticationActivity.this,
//                                    SignInUIOptions.builder()
//                                            .logo(R.drawable.logo)
//                                            .backgroundColor(R.color._bg__namaha___1_ek2_color)
//                                            .nextActivity(StreamConfig.class)
//    //                            .backgroundColor(android.R.color.background_dark)
//    //                            .logo(R.drawable.logo)
//                                            .build());
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }


                }
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    private AWSMobileClient getCredentialProvider() {
        return AWSMobileClient.getInstance();
    }
}