package com.example.myapplication.questionare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.Home.App_home_activity;
import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

public class App_ques_5_activity extends AppCompatActivity {
    Button button;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_ques_5_activity);

        final String url = "http://gettingstartedapp-env.eba-wfumthra.ap-south-1.elasticbeanstalk.com/quiz/answer_question";
        final String id = "eyJraWQiOiJORm1RRjdseGZyWGpoQmlodDVRZ2VNSk1aUE9nbUNsa0xuZVRqQzNIU1B3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJmZTNkNGQ4Yi1mNDYxLTQxZjktOGM2Mi05MGIzMzUwMGFmNWEiLCJhdWQiOiJlYjR1dXY0NHRxNmxnY2tqYmJrOWtxMWxsIiwiZXZlbnRfaWQiOiI0NTIxNjM0Yy1jOWQ5LTQ2NzUtOGRhMi0xMTAzOWVjMTk3ZjQiLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTU5Mzc4NzE2MywiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9aY1VmQmtBbHEiLCJwaG9uZV9udW1iZXJfdmVyaWZpZWQiOnRydWUsImNvZ25pdG86dXNlcm5hbWUiOiJmZTNkNGQ4Yi1mNDYxLTQxZjktOGM2Mi05MGIzMzUwMGFmNWEiLCJwaG9uZV9udW1iZXIiOiIrOTE5ODIyNTk1MDAyIiwiZXhwIjoxNTkzNzkwNzYzLCJpYXQiOjE1OTM3ODcxNjN9.mKRmhDXm5LNbSCu1XSHZUGitcTiHV24uFA7wHFKdmZmuD95NnLr2uOtF6-8BENWcjGWRyGApESmEvC0fFIk2xJAcFNt7aZJOEbu5otrWedxZrvect1-PMqFsVuA_UFMJ7vI1j1-i6nvnQlacKDA5iZUE-HFs6qkNraCBaQnaOXUz4X6Y_O-MqvgshcQHWgX2W8lUCk_vhTHSiSWlvqrw7hmhv1aiBFUnT0G_I0w4ZZ11JYV6j1esJN0590pxx4GwfdD1dFV3qmWBfc1ISnAq2p3sNTigOCd6qDGVXymynmrJOOYDSFdIlKybWnVzz3dKbOwE6xvpf8gZqMHbIbU4uQ";

        button = findViewById(R.id.ques5_button);
        cb1 = findViewById(R.id.ques5_cb1);
        cb2 = findViewById(R.id.ques5_cb2);
        cb3 = findViewById(R.id.ques5_cb3);
        cb4 = findViewById(R.id.ques5_cb4);
        cb5 = findViewById(R.id.ques5_cb5);
        cb6 = findViewById(R.id.ques5_cb6);
        cb7 = findViewById(R.id.ques5_cb7);
        cb8 = findViewById(R.id.ques5_cb8);
        cb9 = findViewById(R.id.ques5_cb9);
        cb10 = findViewById(R.id.ques5_cb10);
        cb11 = findViewById(R.id.ques5_cb11);
        cb12 = findViewById(R.id.ques5_cb12);
        cb13 = findViewById(R.id.ques5_cb13);
        cb14 = findViewById(R.id.ques5_cb14);
        cb15 = findViewById(R.id.ques5_cb15);
        cb16 = findViewById(R.id.ques5_cb16);
        cb17 = findViewById(R.id.ques5_cb17);
        cb18 = findViewById(R.id.ques5_cb18);
        cb19 = findViewById(R.id.ques5_cb19);

        constraintLayout = findViewById(R.id.app_ques_5_layout);

        button.setEnabled(false);

        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        cb19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked() || cb2.isChecked() || cb3.isChecked() || cb4.isChecked() || cb5.isChecked() || cb6.isChecked() || cb7.isChecked()
                || cb8.isChecked() || cb9.isChecked() || cb10.isChecked() || cb11.isChecked() || cb12.isChecked()
                || cb13.isChecked() || cb14.isChecked() || cb15.isChecked() || cb16.isChecked() || cb17.isChecked()
                || cb18.isChecked() || cb19.isChecked()){

//                    RequestQueue requestQueue = Volley.newRequestQueue(App_ques_5_activity.this);
//
//                    JSONObject jsonBody = new JSONObject();
//                    try {
//                        jsonBody.put("questionNo", 5);
//                        JSONArray jsonArray = new JSONArray();
//                        if (cb1.isChecked()){
//                            jsonArray.put(1);
//                        }else if (cb2.isChecked()){
//                            jsonArray.put(2);
//                        }else if (cb3.isChecked()){
//                            jsonArray.put(3);
//                        }else if (cb4.isChecked()){
//                            jsonArray.put(4);
//                        }else if (cb5.isChecked()){
//                            jsonArray.put(5);
//                        }else if (cb6.isChecked()){
//                            jsonArray.put(6);
//                        }else if (cb7.isChecked()){
//                            jsonArray.put(7);
//                        }else if (cb8.isChecked()){
//                            jsonArray.put(8);
//                        }else if (cb9.isChecked()){
//                            jsonArray.put(9);
//                        }else if (cb10.isChecked()){
//                            jsonArray.put(10);
//                        }
//                        jsonBody.put("answer",jsonArray);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                    final String mRequestBody = jsonBody.toString();
//
//                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            System.out.println("Response:-  " + response);
//                            if (response.equals("Question answered successfully")){
//                                Intent i = new Intent(App_ques_5_activity.this, App_home_activity.class);
//                                startActivity(i);
//                                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
//                                finish();
//                            }
//                        }
//                    }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            System.out.println("LOG_VOLLEY_ERROR " + error.toString());
//                        }
//                    }) {
//                        @Override
//                        public Map<String, String> getHeaders() throws AuthFailureError {
//                            Map<String, String>  params = new HashMap<String, String>();
//                            params.put("id-token", id);
//
//                            return params;
//                        }
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

                    Intent i = new Intent(App_ques_5_activity.this, App_home_activity.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                }else {
                    Snackbar snackbar = Snackbar.make(constraintLayout,"If you have no Medical Condition.\nPlease select Nope !", Snackbar.LENGTH_SHORT);
                    snackbar.setTextColor(getResources().getColor(R.color.white));
                    snackbar.setBackgroundTint(getResources().getColor(R.color.black));
                    snackbar.show();
                }
            }
        });
    }
}