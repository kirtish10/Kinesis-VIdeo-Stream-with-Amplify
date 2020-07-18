package com.example.myapplication.questionare;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.R;

public class App_ques_2_pager_activity extends AppCompatActivity {
    Button button;
    ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_ques_2_pager_activity);

//        Intent intent = getIntent();
//        int pos = intent.getIntExtra("position",0);
//        System.out.println("posssss ; "+pos);
//
//        final String url = "http://gettingstartedapp-env.eba-wfumthra.ap-south-1.elasticbeanstalk.com/quiz/answer_question";
//        final String id = "eyJraWQiOiJORm1RRjdseGZyWGpoQmlodDVRZ2VNSk1aUE9nbUNsa0xuZVRqQzNIU1B3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJmZTNkNGQ4Yi1mNDYxLTQxZjktOGM2Mi05MGIzMzUwMGFmNWEiLCJhdWQiOiJlYjR1dXY0NHRxNmxnY2tqYmJrOWtxMWxsIiwiZXZlbnRfaWQiOiI0NTIxNjM0Yy1jOWQ5LTQ2NzUtOGRhMi0xMTAzOWVjMTk3ZjQiLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTU5Mzc4NzE2MywiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9aY1VmQmtBbHEiLCJwaG9uZV9udW1iZXJfdmVyaWZpZWQiOnRydWUsImNvZ25pdG86dXNlcm5hbWUiOiJmZTNkNGQ4Yi1mNDYxLTQxZjktOGM2Mi05MGIzMzUwMGFmNWEiLCJwaG9uZV9udW1iZXIiOiIrOTE5ODIyNTk1MDAyIiwiZXhwIjoxNTkzNzkwNzYzLCJpYXQiOjE1OTM3ODcxNjN9.mKRmhDXm5LNbSCu1XSHZUGitcTiHV24uFA7wHFKdmZmuD95NnLr2uOtF6-8BENWcjGWRyGApESmEvC0fFIk2xJAcFNt7aZJOEbu5otrWedxZrvect1-PMqFsVuA_UFMJ7vI1j1-i6nvnQlacKDA5iZUE-HFs6qkNraCBaQnaOXUz4X6Y_O-MqvgshcQHWgX2W8lUCk_vhTHSiSWlvqrw7hmhv1aiBFUnT0G_I0w4ZZ11JYV6j1esJN0590pxx4GwfdD1dFV3qmWBfc1ISnAq2p3sNTigOCd6qDGVXymynmrJOOYDSFdIlKybWnVzz3dKbOwE6xvpf8gZqMHbIbU4uQ";
//
//
//        viewPager2 = findViewById(R.id.viewpager);
//        final List<Model> list = new ArrayList<>();
//        list.add(new Model(R.drawable.namaha22_image1,"Better Sleep"));
//        list.add(new Model(R.drawable.namaha22_image2,"Reduce Stress"));
//        list.add(new Model(R.drawable.namaha22_image3,"Improve Focus"));
//        list.add(new Model(R.drawable.namaha22_image4,"Reduce Anxiety"));
//        list.add(new Model(R.drawable.namaha22_image5,"Lose Weight"));
//        list.add(new Model(R.drawable.namaha22_image6,"Remain Calm"));
//
//        viewPager2.setAdapter(new Adapter(list,viewPager2));
//        viewPager2.setCurrentItem(pos);
//
//
//        viewPager2.setClipToPadding(false);
//        viewPager2.setClipChildren(false);
//        viewPager2.setOffscreenPageLimit(3);
//        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
//
//        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
//        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
//        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull View page, float position) {
//                float r = 1 - Math.abs(position);
//                page.setScaleY(0.85f + r * 0.15f);
//            }
//        });
//
//        viewPager2.setPageTransformer(compositePageTransformer);
//
//        button = findViewById(R.id.namaha27_button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                RequestQueue requestQueue = Volley.newRequestQueue(App_ques_2_pager_activity.this);
////
////                JSONObject jsonBody = new JSONObject();
////                try {
////                    jsonBody.put("questionNo", 2);
////                    jsonBody.put("answer",viewPager2.getCurrentItem()+1);
////                } catch (JSONException e) {
////                    e.printStackTrace();
////                }
////                final String mRequestBody = jsonBody.toString();
////
////                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
////                    @Override
////                    public void onResponse(String response) {
////                        System.out.println("Response:-  " + response);
////                        if (response.equals("Question answered successfully")){
////                            Intent i = new Intent(App_ques_2_pager_activity.this, App_ques_3_activity.class);
////                            startActivity(i);
////                            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
////                            finish();
////                        }
////                    }
////                }, new Response.ErrorListener() {
////                    @Override
////                    public void onErrorResponse(VolleyError error) {
////                        System.out.println("LOG_VOLLEY_ERROR " + error.toString());
////                    }
////                }) {
////                    @Override
////                    public Map<String, String> getHeaders() throws AuthFailureError {
////                        Map<String, String>  params = new HashMap<String, String>();
////                        params.put("id-token", id);
////
////                        return params;
////                    }
////                    @Override
////                    public String getBodyContentType() {
////                        return "application/json; charset=utf-8";
////                    }
////
////                    @Override
////                    public byte[] getBody() throws AuthFailureError {
////                        try {
////                            return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
////                        } catch (UnsupportedEncodingException uee) {
////                            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
////                            return null;
////                        }
////                    }
////                };
////
////                requestQueue.add(stringRequest);
//
//                Intent i = new Intent(App_ques_2_pager_activity.this, App_ques_3_activity.class);
//                startActivity(i);
//                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
//
//            }
//        });
    }
}