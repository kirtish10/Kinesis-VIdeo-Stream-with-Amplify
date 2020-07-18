package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.login.UserDbHelper;
import com.example.myapplication.questionare.App_ques_2_activity;

public class App_1_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                UserDbHelper userDbHelper = new UserDbHelper(App_1_activity.this);
                if(userDbHelper.getCount()==1){
                    Intent i = new Intent(App_1_activity.this, App_ques_2_activity.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    finish();
                }else{
                    Intent i = new Intent(App_1_activity.this, App_ques_2_activity.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    finish();
                }
            }
        },2000);
    }
}