package com.example.myapplication.login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.R;

public class App_3_activity extends AppCompatActivity {
    ImageView back;
    View view;
    TextView login;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_3_activity);

        back=findViewById(R.id.namaha11_back);
        login=findViewById(R.id.again_login);
        view=findViewById(R.id.sign_up_phone_button);
        constraintLayout = findViewById(R.id.app_3_layout);

        view.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent shared = new Intent(App_3_activity.this,App_4_activity.class);
                startActivity(shared);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent shared = new Intent(App_3_activity.this, App_2_activity.class);
                startActivity(shared);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
    }
}