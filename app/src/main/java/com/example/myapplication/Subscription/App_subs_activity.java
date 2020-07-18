package com.example.myapplication.Subscription;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class App_subs_activity extends AppCompatActivity {
    Button button;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_subs_activity);

        viewPager2 = findViewById(R.id.subs_view_pager);
        final List<subs_model> list = new ArrayList<>();
        list.add(new subs_model(R.drawable.free_back,R.drawable.ellipse,"Free","free","free","freee","After trail, pay ₹ 1499 per month"));
        list.add(new subs_model(R.drawable.premium_back,R.drawable.ellipse2,"Premium","premium","premium","premium","After trail, pay ₹ 1499 per month"));
        list.add(new subs_model(R.drawable.ultimate_back,R.drawable.ellipse1,"Ultimate","ultimate","ultimate","ultimate","After trail, pay ₹ 1499 per month"));

        viewPager2.setAdapter(new SubsAdapter(list,viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
    }
}