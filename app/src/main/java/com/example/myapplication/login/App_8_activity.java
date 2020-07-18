package com.example.myapplication.login;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.myapplication.R;
import com.example.myapplication.questionare.App_ques_1_activity;
import com.google.android.material.snackbar.Snackbar;

public class App_8_activity extends AppCompatActivity {
    EditText editText;
    View view;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_8_activity);

        view = findViewById(R.id.otp_button);
        editText = findViewById(R.id.enter_login_otp);
        constraintLayout = findViewById(R.id.app_8_layout);

        requestSmsPermission();
        new OTP_Reciever().setEditText(editText);

        Intent intent = getIntent();
        String mobile = intent.getStringExtra("mobile_login");
        System.out.println(mobile);

//        Login login = new Login(App_8_activity.this,mobile);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = editText.getText().toString();
                if(otp.equals("")){
                    Snackbar snackbar = Snackbar.make(constraintLayout,"Please enter valid OTP !", Snackbar.LENGTH_SHORT);
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.show();
                }else if (otp.length() != 6){
                    Snackbar snackbar = Snackbar.make(constraintLayout,"OTP is of wrong length !", Snackbar.LENGTH_SHORT);
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.show();
                }else {

//                    Login_OTP login_otp = new Login_OTP(App_8_activity.this,mobile,otp);
                    Intent shared = new Intent(App_8_activity.this, App_ques_1_activity.class);
                    startActivity(shared);

                }
            }
        });

    }
    private void requestSmsPermission() {
        String permission = Manifest.permission.RECEIVE_SMS;

        int grant = ContextCompat.checkSelfPermission(this,permission);
        if(grant != PackageManager.PERMISSION_GRANTED){
            String[] permission_list = new String[1];
            permission_list[0] = permission;

            ActivityCompat.requestPermissions(this,permission_list,1);
        }
    }
}