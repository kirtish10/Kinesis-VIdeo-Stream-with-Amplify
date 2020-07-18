package com.example.myapplication.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.regex.Pattern;

public class App_7_activity extends AppCompatActivity {
    EditText editText;
    View button;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_7_activity);

//        editText = findViewById(R.id.enter_password);
//        button = findViewById(R.id.login_button);
//        Intent i = getIntent();
//        String mobile = i.getStringExtra("mobile_login");
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String password = editText.getText().toString();
//                if(password.equals("")){
//                    Toast.makeText(App_7_activity.this,"Please enter password !",Toast.LENGTH_LONG).show();
//                }
//                else if (!validatePassword(password)&&password.length()<8){
//                    Toast.makeText(App_7_activity.this,"The password must contain - 1 Upper Case Letter, 1 Digit, 1 Special Character and should not be less then 8 characters.",Toast.LENGTH_LONG).show();
//                }else
//                {
////                    RequestQueue requestQueue = Volley.newRequestQueue(App_7_activity.this);
////                    String URL = "http://gettingstartedapp-env.eba-wfumthra.ap-south-1.elasticbeanstalk.com/auth/login";
////                    JSONObject jsonBody = new JSONObject();
////                    try {
////                        jsonBody.put("phoneNumber", "+91"+mobile);
////                        jsonBody.put("password", password);
////                    } catch (JSONException e) {
////                        e.printStackTrace();
////                    }
////                    final String mRequestBody = jsonBody.toString();
////
////                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
////                        @Override
////                        public void onResponse(String response) {
////                            System.out.println("Response:-  " + response);
////                            if (response.equals("Sign Up - Verification Required")){
////                            }else {
////                                try {
////                                    JSONObject jso = new JSONObject(response);
////                                    String message = jso.getString("message");
////                                    Toast.makeText(App_7_activity.this,message,Toast.LENGTH_SHORT).show();
////                                } catch (JSONException e) {
////                                    System.out.println(e);
////                                }
////                            }
////                        }
////                    }, new Response.ErrorListener() {
////                        @Override
////                        public void onErrorResponse(VolleyError error) {
////                            System.out.println("LOG_VOLLEY_ERROR " + error.toString());
////                        }
////                    }) {
////                        @Override
////                        public String getBodyContentType() {
////                            return "application/json; charset=utf-8";
////                        }
////
////                        @Override
////                        public byte[] getBody() throws AuthFailureError {
////                            try {
////                                return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
////                            } catch (UnsupportedEncodingException uee) {
////                                VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
////                                return null;
////                            }
////                        }
////                    };
////
////                    requestQueue.add(stringRequest);
//                    Intent i = new Intent(App_7_activity.this,App_8_activity.class);
//                    startActivity(i);
//                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
//                }
//            }
//        });
//    }
//    private boolean validatePassword(String string) {
//        String passwordInput = string.trim();
//        if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
//            return false;
//        } else {
//            return true;
//        }
//    }
}}