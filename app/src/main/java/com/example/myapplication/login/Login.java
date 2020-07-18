package com.example.myapplication.login;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class Login extends AsyncTask <String, String, String> {

    Context ctx;
    String mobile;
    String url = "http://gettingstartedapp-env.eba-wfumthra.ap-south-1.elasticbeanstalk.com/auth/login";

    public Login(Context ctx, String mobile) {
        this.ctx = ctx;
        this.mobile = mobile;
        execute(url);
    }

    @Override
    protected String doInBackground(String... strings) {

        RequestQueue requestQueue = Volley.newRequestQueue(ctx);
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("phoneNumber", "+91"+mobile);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String mRequestBody = jsonBody.toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("Response:-  " + response);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                    if (response.length()<200){
                        if (jsonObject.getString("name").equals("CodeMismatchException")){
                            Toast.makeText(ctx,"Wrong OTP !",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(ctx,jsonObject.getString("message"),Toast.LENGTH_SHORT).show();
                        }
                    } else {

                        User user = new User(jsonObject.getString("accessToken"),jsonObject.getString("idToken"),jsonObject.getString("refreshToken"));
                        UserDbHelper userDbHelper = new UserDbHelper(ctx);
                        userDbHelper.addUser(user);

                        cancel(true);

                        Ques_check ques_check = new Ques_check(ctx,jsonObject.getString("idToken"));

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("LOG_VOLLEY_ERROR " + error.toString());
                NetworkResponse response = error.networkResponse;
                if (error instanceof ServerError && response != null) {
                    try {
                        String res = new String(response.data,
                                HttpHeaderParser.parseCharset(response.headers, "utf-8"));
                        System.out.println("loginnnnn:- "+res);
                        // Now you can use any deserializer to make sense of data
                        JSONObject obj = new JSONObject(res);
                    } catch (UnsupportedEncodingException e1) {
                        // Couldn't properly decode data to string
                        e1.printStackTrace();
                    } catch (JSONException e2) {
                        // returned data is not JSONObject?
                        e2.printStackTrace();
                    }
                }
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

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(20000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        requestQueue.add(stringRequest);

        return null;
    }

}
