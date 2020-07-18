package com.example.myapplication.Courses;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Singletonclass {
    private  static Singletonclass singletonclass;
    private RequestQueue requestQueue;
    private static Context ctx;

    private Singletonclass (Context context){
        ctx = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(ctx);

        }
        return requestQueue;
    }

    public static synchronized Singletonclass getInstance(Context context){
        if (singletonclass == null){
            singletonclass = new Singletonclass(context);
        }
        return singletonclass;
    }

    public void addToRequestQueue(Request request){
        requestQueue.add(request);
    }
}
