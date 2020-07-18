package com.example.myapplication.login;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Home.App_home_activity;
import com.example.myapplication.questionare.App_ques_1_activity;

import java.util.HashMap;
import java.util.Map;

public class Ques_check extends AsyncTask<String, String, String> {
    Context ctx;
    String id_token;
    String url = "http://gettingstartedapp-env.eba-wfumthra.ap-south-1.elasticbeanstalk.com/user/questionnaire";

    public Ques_check(Context ctx, String id_token) {
        this.ctx = ctx;
        this.id_token = id_token;
        execute(url);
    }

    @Override
    protected String doInBackground(String... strings) {

        RequestQueue requestQueue = Volley.newRequestQueue(ctx);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("Response:-  " + response);
                if (response.toString().equals("true")){
                    Intent shared = new Intent(ctx, App_home_activity.class);
                    ctx.startActivity(shared);
                    ((App_8_activity)ctx).finish();
                } else {
                    Intent shared = new Intent(ctx, App_ques_1_activity.class);
                    ctx.startActivity(shared);
                    ((App_8_activity)ctx).finish();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("LOG_VOLLEY_ERROR " + error.toString());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("id-token", id_token);

                return params;
            }
        };

        requestQueue.add(stringRequest);

        return null;
    }
}
