package com.example.myapplication.login;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

public class App_6_activity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    View view;
    ImageView back_button;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_6_activity);

        textView = findViewById(R.id.namaha19_text);
        back_button = findViewById(R.id.namaha19_back_button);
        view = findViewById(R.id.verify_otp);
        constraintLayout = findViewById(R.id.app_6_layout);

        Intent i = getIntent();
        final String mobile = i.getStringExtra("mobile");
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(App_6_activity.this,App_3_activity.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        textView.setText("Please enter OTP weve sent you on \n" +
                "+91-"+mobile);
        editText = findViewById(R.id.nickname_edt);
        if (editText.getText().toString().equals("")){
            requestSmsPermission();
            new OTP_Reciever().setEditText(editText);
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = editText.getText().toString();
                if(otp.equals("")){
                    Snackbar snackbar = Snackbar.make(constraintLayout,"Please enter valid OTP !", Snackbar.LENGTH_SHORT);
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.show();
                }else {

//                    RequestQueue requestQueue = Volley.newRequestQueue(App_6_activity.this);
//                    String URL = "http://gettingstartedapp-env.eba-wfumthra.ap-south-1.elasticbeanstalk.com/auth/verify";
//                    JSONObject jsonBody = new JSONObject();
//                    try {
//                        jsonBody.put("phoneNumber", "+91"+mobile);
//                        jsonBody.put("verificationCode", otp);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                    final String mRequestBody = jsonBody.toString();
//
//                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            System.out.println("Response:-  " + response);
//                            if (response.equals("Phone Number Verified")){
//                                Intent i = new Intent(App_6_activity.this, App_2_activity.class);
//                                startActivity(i);
//                                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
//                            }
//                            else {
//                                Toast.makeText(App_6_activity.this,"Please enter correct OTP!",Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            System.out.println("LOG_VOLLEY_ERROR " + error.toString());
//                        }
//                    }) {
//                        @Override
//                        public String getBodyContentType() {
//                            return "application/json; charset=utf-8";
//                        }
//
//                        @Override
//                        public byte[] getBody() throws AuthFailureError {
//                            try {
//                                return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
//                            } catch (UnsupportedEncodingException uee) {
//                                VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
//                                return null;
//                            }
//                        }
//                    };
//
//                    requestQueue.add(stringRequest);

                    Intent i = new Intent(App_6_activity.this, App_2_activity.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
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