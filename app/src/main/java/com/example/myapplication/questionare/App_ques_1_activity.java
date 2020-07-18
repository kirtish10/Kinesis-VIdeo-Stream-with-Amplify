package com.example.myapplication.questionare;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class App_ques_1_activity extends AppCompatActivity {
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_ques_1_activity);
        button = findViewById(R.id.ques1_button);
        editText = findViewById(R.id.nickname_edt);
        final String url = "http://gettingstartedapp-env.eba-wfumthra.ap-south-1.elasticbeanstalk.com/quiz/answer_question";
        final String id = "eyJraWQiOiJORm1RRjdseGZyWGpoQmlodDVRZ2VNSk1aUE9nbUNsa0xuZVRqQzNIU1B3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJmZTNkNGQ4Yi1mNDYxLTQxZjktOGM2Mi05MGIzMzUwMGFmNWEiLCJhdWQiOiJlYjR1dXY0NHRxNmxnY2tqYmJrOWtxMWxsIiwiZXZlbnRfaWQiOiI0NTIxNjM0Yy1jOWQ5LTQ2NzUtOGRhMi0xMTAzOWVjMTk3ZjQiLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTU5Mzc4NzE2MywiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9aY1VmQmtBbHEiLCJwaG9uZV9udW1iZXJfdmVyaWZpZWQiOnRydWUsImNvZ25pdG86dXNlcm5hbWUiOiJmZTNkNGQ4Yi1mNDYxLTQxZjktOGM2Mi05MGIzMzUwMGFmNWEiLCJwaG9uZV9udW1iZXIiOiIrOTE5ODIyNTk1MDAyIiwiZXhwIjoxNTkzNzkwNzYzLCJpYXQiOjE1OTM3ODcxNjN9.mKRmhDXm5LNbSCu1XSHZUGitcTiHV24uFA7wHFKdmZmuD95NnLr2uOtF6-8BENWcjGWRyGApESmEvC0fFIk2xJAcFNt7aZJOEbu5otrWedxZrvect1-PMqFsVuA_UFMJ7vI1j1-i6nvnQlacKDA5iZUE-HFs6qkNraCBaQnaOXUz4X6Y_O-MqvgshcQHWgX2W8lUCk_vhTHSiSWlvqrw7hmhv1aiBFUnT0G_I0w4ZZ11JYV6j1esJN0590pxx4GwfdD1dFV3qmWBfc1ISnAq2p3sNTigOCd6qDGVXymynmrJOOYDSFdIlKybWnVzz3dKbOwE6xvpf8gZqMHbIbU4uQ";

        button.setEnabled(false);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                button.setTextColor(getResources().getColor(R.color.rectangle_109_color));
                button.setBackgroundColor(getResources().getColor(R.color.black));
                button.setEnabled(true);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = editText.getText().toString();

//                RequestQueue requestQueue = Volley.newRequestQueue(App_ques_1_activity.this);
//
//                JSONObject jsonBody = new JSONObject();
//                try {
//                    jsonBody.put("questionNo", 1);
//                    jsonBody.put("answer",nickname);
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
//                            Intent i = new Intent(App_ques_1_activity.this, App_ques_2_activity.class);
//                            startActivity(i);
//                            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
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

                Intent i = new Intent(App_ques_1_activity.this, App_ques_2_activity.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });
    }
}