package com.example.myapplication.questionare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class App_ques_4_activity extends AppCompatActivity {
    Button button;
    RadioButton rb1,rb2,rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_ques_4_activity);

        final String url = "http://gettingstartedapp-env.eba-wfumthra.ap-south-1.elasticbeanstalk.com/quiz/answer_question";
        final String id = "eyJraWQiOiJORm1RRjdseGZyWGpoQmlodDVRZ2VNSk1aUE9nbUNsa0xuZVRqQzNIU1B3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJmZTNkNGQ4Yi1mNDYxLTQxZjktOGM2Mi05MGIzMzUwMGFmNWEiLCJhdWQiOiJlYjR1dXY0NHRxNmxnY2tqYmJrOWtxMWxsIiwiZXZlbnRfaWQiOiI0NTIxNjM0Yy1jOWQ5LTQ2NzUtOGRhMi0xMTAzOWVjMTk3ZjQiLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTU5Mzc4NzE2MywiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9aY1VmQmtBbHEiLCJwaG9uZV9udW1iZXJfdmVyaWZpZWQiOnRydWUsImNvZ25pdG86dXNlcm5hbWUiOiJmZTNkNGQ4Yi1mNDYxLTQxZjktOGM2Mi05MGIzMzUwMGFmNWEiLCJwaG9uZV9udW1iZXIiOiIrOTE5ODIyNTk1MDAyIiwiZXhwIjoxNTkzNzkwNzYzLCJpYXQiOjE1OTM3ODcxNjN9.mKRmhDXm5LNbSCu1XSHZUGitcTiHV24uFA7wHFKdmZmuD95NnLr2uOtF6-8BENWcjGWRyGApESmEvC0fFIk2xJAcFNt7aZJOEbu5otrWedxZrvect1-PMqFsVuA_UFMJ7vI1j1-i6nvnQlacKDA5iZUE-HFs6qkNraCBaQnaOXUz4X6Y_O-MqvgshcQHWgX2W8lUCk_vhTHSiSWlvqrw7hmhv1aiBFUnT0G_I0w4ZZ11JYV6j1esJN0590pxx4GwfdD1dFV3qmWBfc1ISnAq2p3sNTigOCd6qDGVXymynmrJOOYDSFdIlKybWnVzz3dKbOwE6xvpf8gZqMHbIbU4uQ";

        rb1 = findViewById(R.id.ques4_rb1);
        rb2 = findViewById(R.id.ques4_rb2);
        rb3 = findViewById(R.id.ques4_rb3);
        button = findViewById(R.id.ques4_button);
        button.setEnabled(false);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
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

                int answer = 0;

                if (rb1.isChecked()){
                    answer = 1;
                }else if (rb2.isChecked()){
                    answer = 2;
                }else if (rb3.isChecked()){
                    answer = 3;
                }

//                RequestQueue requestQueue = Volley.newRequestQueue(App_ques_4_activity.this);
//
//                JSONObject jsonBody = new JSONObject();
//                try {
//                    jsonBody.put("questionNo", 4);
//                    jsonBody.put("answer",answer);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                final String mRequestBody = jsonBody.toString();
//
//                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        System.out.println("Response:-  " + response);
//                        if (response.equals("Question answered successfully")){
//                            Intent i = new Intent(App_ques_4_activity.this, App_ques_5_activity.class);
//                            startActivity(i);
//                            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
//                            finish();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        System.out.println("LOG_VOLLEY_ERROR " + error.toString());
//                    }
//                }) {
//                    @Override
//                    public Map<String, String> getHeaders() throws AuthFailureError {
//                        Map<String, String>  params = new HashMap<String, String>();
//                        params.put("id-token", id);
//
//                        return params;
//                    }
//                    @Override
//                    public String getBodyContentType() {
//                        return "application/json; charset=utf-8";
//                    }
//
//                    @Override
//                    public byte[] getBody() throws AuthFailureError {
//                        try {
//                            return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
//                        } catch (UnsupportedEncodingException uee) {
//                            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
//                            return null;
//                        }
//                    }
//                };
//
//                requestQueue.add(stringRequest);

                Intent i = new Intent(App_ques_4_activity.this, App_ques_5_activity.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });
    }
}