package com.example.myapplication.login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.AuthProvider;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

public class App_2_activity extends AppCompatActivity {
    View view,login;
    EditText editText;
    View login_with_fb;
    View login_with_google;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_2_activity);
        view=findViewById(R.id.create_acc_button);
        editText = findViewById(R.id.enter_phone_no_);
        login = findViewById(R.id.login);
        login_with_fb = findViewById(R.id.login_with_fb);
        login_with_google = findViewById(R.id.login_with_google);
        linearLayout = findViewById(R.id.main_layout);

//        Snackbar snackbar = Snackbar.make(linearLayout,"Please check your internet connection...", Snackbar.LENGTH_INDEFINITE);
//        snackbar.setTextColor(getResources().getColor(R.color.white));
//        snackbar.setBackgroundTint(getResources().getColor(R.color.black));
//        snackbar.setActionTextColor(getResources().getColor(R.color.ellipse_50_color));
//        snackbar.setAction("Retry", new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (networkCheck()){
//                    snackbar.dismiss();
//                }else {
//                    snackbar.show();
//                }
//            }
//        });
//
//        if (!networkCheck()){
//            snackbar.show();
//        }
        try {
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.configure(getApplicationContext());
            Log.i("MyAmplify", "Initialized Amplify");
        } catch (AmplifyException e) {
            e.printStackTrace();
            Log.e("MyAmplify", "Could not initialize Amplify", e);
        }

        Amplify.Auth.fetchAuthSession(
                result -> Log.i("AmplifyQuickstart", result.toString()),
                error -> Log.e("AmplifyQuickstart", error.toString())
        );



        login_with_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Amplify.Auth.signInWithSocialWebUI(
                        AuthProvider.facebook(),
                        App_2_activity.this,
                        result -> Log.i("AuthQuickstartfb", result.toString()),
                        error -> Log.e("AuthQuickstartfb_error", error.toString())
                );
            }
        });

        login_with_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Amplify.Auth.signInWithSocialWebUI(
                        AuthProvider.google(),
                        App_2_activity.this,
                        result -> Log.i("AuthQuickstartgoogle", result.toString()),
                        error -> Log.e("AuthQuickgoogle_error", error.toString())
                );

            }
        });



        view.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent shared = new Intent(App_2_activity.this, App_3_activity.class);
                startActivity(shared);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = editText.getText().toString();
                if (mobile.equals("")){
                    Snackbar snackbar = Snackbar.make(linearLayout,"Please Enter Your Phone No. !", Snackbar.LENGTH_SHORT);
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.show();
                }
                else if(mobile.length()!=10){
                    Snackbar snackbar = Snackbar.make(linearLayout,"Please Enter a valid Phone No. !", Snackbar.LENGTH_SHORT);
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.show();
                }
                else {

                    Intent shared = new Intent(App_2_activity.this, App_8_activity.class);
                    shared.putExtra("mobile_login",mobile);
                    startActivity(shared);
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                }
            }
        });
    }

//    @Override
//    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//
//        if(intent.getData() != null && "myapp".equals(intent.getData().getScheme())) {
//            Amplify.Auth.handleWebUISignInResponse(intent);
//        }
//    }
//    public boolean networkCheck(){
//        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
//                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
//            //we are connected to a network
//            return true;
//        }
//        else
//            return false;
//    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if(intent.getData() != null && "myapp".equals(intent.getData().getScheme())) {
            Amplify.Auth.handleWebUISignInResponse(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}