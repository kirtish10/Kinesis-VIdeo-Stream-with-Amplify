package com.example.myapplication.login;

import android.content.Context;
import android.os.AsyncTask;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class Login_OTP extends AsyncTask<String, String, String> {

    Context ctx;
    String mobile;
    String otp;
    String url ="http://gettingstartedapp-env.eba-wfumthra.ap-south-1.elasticbeanstalk.com/auth/mfa_code";

    public Login_OTP(Context ctx, String mobile, String otp) {
        this.ctx = ctx;
        this.mobile = mobile;
        this.otp = otp;
        execute(url);
    }

    @Override
    protected String doInBackground(String... strings) {

        RequestQueue requestQueue = Volley.newRequestQueue(ctx);
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("phoneNumber", "+91"+mobile);
            jsonBody.put("verificationCode", otp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String mRequestBody = jsonBody.toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("Response:-  " + response);
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

        return null;
    }
}
