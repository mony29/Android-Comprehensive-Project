package com.example.comphrehensivehomework;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new HomeFragment()).commit();
        }

        initViewPager();
    }

    private void initViewPager() {
        navigationView = findViewById(R.id.bottomNavigateView);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                if (menuItem.getItemId() == R.id.home_fragment) {
                    fragment = new HomeFragment();
                } else if (menuItem.getItemId() == R.id.learning_fragment) {
                    fragment = new LearningFragment();
                } else if (menuItem.getItemId() == R.id.video_fragment) {
                    fragment = new VideoFragment();
                } else if (menuItem.getItemId() == R.id.my_fragment) {
                    fragment = new MyFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
                return true;
            }
        });
    }
}