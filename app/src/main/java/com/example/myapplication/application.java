package com.example.myapplication;

import android.app.Application;
import android.util.Log;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;

public class application extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        try {
            Amplify.configure(getApplicationContext());

            Log.i("MyAmplify", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("MyAmplify", "Could not initialize Amplify", error);
        }
    }
}
