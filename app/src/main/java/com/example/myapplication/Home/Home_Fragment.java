package com.example.myapplication.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.App_music1_activity;
import com.example.myapplication.Courses.CourseAdapter;
import com.example.myapplication.Courses.CourseModel;
import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_Fragment extends Fragment {

    RecyclerView recyclerView1,recyclerView2;
    ArrayList<CourseModel> list1,list2;
    CourseAdapter adapter1,adapter2;
    ProgressBar progressBar;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_Fragment newInstance(String param1, String param2) {
        Home_Fragment fragment = new Home_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_, container, false);

        recyclerView1 = view.findViewById(R.id.courses_rcv);
        recyclerView2 = view.findViewById(R.id.originals_rcv);
        progressBar = view.findViewById(R.id.progress);
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();


        String url1 = "http://gettingstartedapp-env.eba-wfumthra.ap-south-1.elasticbeanstalk.com/courses";
        String url2 = url1+"/originals";
        String imageUrl = "https://zyoga-courses.s3.ap-south-1.amazonaws.com/courses/";

        progressBar.setVisibility(View.VISIBLE);

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                System.out.println("Response:-  " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("courses");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jso = jsonArray.getJSONObject(i);
                        String course_name = jso.getString("courseName");
                        String course_id = jso.getString("_id");
                        String course_image = jso.getString("coursePicture");
                        list1.add(new CourseModel(course_id,course_name,imageUrl+course_image));
                    }
                    adapter1 = new CourseAdapter(getActivity(),list1,progressBar);
                    recyclerView1.setAdapter(adapter1);
                    recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapter1.setOnItemClickListener(new CourseAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int pos) {
                        Intent intent = new Intent(getActivity(),App_music1_activity.class);
                        intent.putExtra("CourseId",list1.get(pos).getCourse_id());
                        startActivity(intent);
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("LOG_VOLLEY_ERROR " + error.toString());
            }
        });

        requestQueue.add(stringRequest);
        RequestQueue requestQueue2 = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest2 = new StringRequest(Request.Method.GET, url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("Response:-  " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("courses");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jso = jsonArray.getJSONObject(i);
                        String course_name = jso.getString("courseName");
                        String course_id = jso.getString("_id");
                        String course_image = jso.getString("coursePicture");
                        list2.add(new CourseModel(course_id,course_name,imageUrl+course_image));
                    }
                    adapter2 = new CourseAdapter(getActivity(),list2,progressBar);
                    recyclerView2.setAdapter(adapter2);
                    recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapter2.setOnItemClickListener(new CourseAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int pos) {
                        Intent intent = new Intent(getActivity(),App_music1_activity.class);
                        intent.putExtra("CourseId",list1.get(pos).getCourse_id());
                        startActivity(intent);
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("LOG_VOLLEY_ERROR " + error.toString());
            }
        });

        requestQueue2.add(stringRequest2);
//        requestQueue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>() {
//            @Override
//            public void onRequestFinished(Request<Object> request) {
//                progressBar.setVisibility(View.GONE);
//            }
//        });
        return view;
    }
}