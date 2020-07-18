package com.example.myapplication.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

public class App_4_activity extends AppCompatActivity {
    View view;
    EditText edt;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_4_activity);

        view = findViewById(R.id.send_otp);
        edt = findViewById(R.id.enter_phone_no);
        constraintLayout = findViewById(R.id.app_4_layout);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = edt.getText().toString();
                if (mobile.equals("")){
                    Snackbar snackbar = Snackbar.make(constraintLayout,"Please Enter Your Phone No. !", Snackbar.LENGTH_SHORT);
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.show();
                }
                else if(mobile.length()!=10){
                    Snackbar snackbar = Snackbar.make(constraintLayout,"Please Enter a valid Phone No. !", Snackbar.LENGTH_SHORT);
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.show();
                }
                else {

//                    RequestQueue requestQueue = Volley.newRequestQueue(App_4_activity.this);
//                    String URL = "http://gettingstartedapp-env.eba-wfumthra.ap-south-1.elasticbeanstalk.com/auth/register";
//                    JSONObject jsonBody = new JSONObject();
//                    try {
//                        jsonBody.put("phoneNumber", "+91"+mobile);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                    final String mRequestBody = jsonBody.toString();
//
//                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            System.out.println("Response:-  " + response);
//                            if (response.equals("Sign Up - Verification Required")){
//                                Intent i = new Intent(App_4_activity.this,App_6_activity.class);
//                                i.putExtra("mobile",mobile);
//                                startActivity(i);
//                                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
//                            }else {
//                                try {
//                                    JSONObject jso = new JSONObject(response);
//                                    String message = jso.getString("message");
//                                    Toast.makeText(App_4_activity.this,message,Toast.LENGTH_SHORT).show();
//                                } catch (JSONException e) {
//                                    System.out.println(e);
//                                }
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

                    Intent i = new Intent(App_4_activity.this,App_6_activity.class);
                    i.putExtra("mobile",mobile);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                }
            }
        });
    }
}