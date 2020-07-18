package com.example.myapplication.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public class App_5_activity extends AppCompatActivity {
    EditText password;
    EditText repassword;
    View button;
    ImageView back_button;
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
        setContentView(R.layout.activity_app_5_activity);

        password = findViewById(R.id.nickname_edt);
        back_button = findViewById(R.id.namaha24_back_button);
        repassword = findViewById(R.id.editText2);
        button = findViewById(R.id.create_account_button);
        Intent intent = getIntent();
        final String Phone_num = intent.getStringExtra("signup_mobile");
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(App_5_activity.this,App_3_activity.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(pass.equals("")){
                    Toast.makeText(App_5_activity.this,"Please enter a valid Password!",Toast.LENGTH_SHORT).show();
                }else if (repass.equals("")){
                    Toast.makeText(App_5_activity.this,"Please re-enter a valid Password!",Toast.LENGTH_SHORT).show();
                }else if (!pass.equals(repass)){
                    Toast.makeText(App_5_activity.this,"Password does not match!",Toast.LENGTH_SHORT).show();
                }else if (!validatePassword(pass)&&pass.length()<8){
                    Toast.makeText(App_5_activity.this,"The password must contain - 1 Upper Case Letter, 1 Digit, 1 Special Character and should not be less then 8 characters.",Toast.LENGTH_LONG).show();
                }else {
                    RequestQueue requestQueue = Volley.newRequestQueue(App_5_activity.this);
                    String URL = "http://gettingstartedapp-env.eba-wfumthra.ap-south-1.elasticbeanstalk.com/auth/register";
                    JSONObject jsonBody = new JSONObject();
                    try {
                        jsonBody.put("phoneNumber", "+91"+Phone_num);
                        jsonBody.put("password", pass);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    final String mRequestBody = jsonBody.toString();

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            System.out.println("Response:-  " + response);
                            if (response.equals("Sign Up - Verification Required")){
                                Intent i = new Intent(App_5_activity.this,App_6_activity.class);
                                i.putExtra("mobile",Phone_num);
                                startActivity(i);
                                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                            }else {
                                try {
                                    JSONObject jso = new JSONObject(response);
                                    String message = jso.getString("message");
                                    Toast.makeText(App_5_activity.this,message,Toast.LENGTH_SHORT).show();
                                } catch (JSONException e) {
                                    System.out.println(e);
                                }
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.println("LOG_VOLLEY_ERROR " + error.toString());
                        }
                    }) {
                        @Override
                        public String getBodyContentType() {
                            return "application/json; charset=utf-8";
                        }

                        @Override
                        public byte[] getBody() throws AuthFailureError {
                            try {
                                return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                            } catch (UnsupportedEncodingException uee) {
                                VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
                                return null;
                            }
                        }
                    };

                    requestQueue.add(stringRequest);
                }
            }
        });

    }
    private boolean validatePassword(String string) {
        String passwordInput = string.trim();
        if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            return false;
        } else {
            return true;
        }
    }
}