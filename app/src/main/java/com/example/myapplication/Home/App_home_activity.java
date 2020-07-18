package com.example.myapplication.Home;

import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Featured_Fragment;
import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class App_home_activity extends AppCompatActivity {
    Home_Fragment home_fragment;
    Discover_Fragment discover_fragment;
    Featured_Fragment featured_fragment;
    Profile_Fragment profile_fragment;
    Growth_Fragment growth_fragment;
    FrameLayout frameLayout;
    ChipNavigationBar bottomNavigationView;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home_activity);

        frameLayout = findViewById(R.id.frame);
        bottomNavigationView = findViewById(R.id.nav);

        home_fragment = new Home_Fragment();
        discover_fragment = new Discover_Fragment();
        featured_fragment = new Featured_Fragment();
        profile_fragment = new Profile_Fragment();
        growth_fragment = new Growth_Fragment();

        setFragment(home_fragment);

        bottomNavigationView.setItemSelected(R.id.home_b, true);

        bottomNavigationView.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {

                switch (i){
                    case R.id.home_b:
                        setFragment(home_fragment);
                        break;
                    case R.id.play_b:
                        setFragment(discover_fragment);
                        break;
                    case R.id.star_b:
                        setFragment(growth_fragment);
                        break;
                    case R.id.profile_b:
                        setFragment(profile_fragment);
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(bottomNavigationView.getSelectedItemId() != 2131296522){
            System.out.println(bottomNavigationView.getSelectedItemId());
            setFragment(home_fragment);
            bottomNavigationView.setItemSelected(R.id.home_b, true);
        } else {
            if (doubleBackToExitPressedOnce) {
                finishAffinity();
                finish();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Snackbar snackbar = Snackbar.make(bottomNavigationView,"Press again to Exit...", Snackbar.LENGTH_SHORT);
            snackbar.setTextColor(getResources().getColor(R.color.black));
            snackbar.setBackgroundTint(getResources().getColor(R.color.black));
            snackbar.show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 3000);
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}