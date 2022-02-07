package com.example.zadaca_lv9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        toolbar = getSupportActionBar();

        navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(myListener);

        toolbar.setTitle("Shop");
        loadFragment(new Fragment01());
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener myListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if(item.getItemId() == R.id.shop){
                toolbar.setTitle("Shop");
                loadFragment(new Fragment01());
                return true;
            } else if(item.getItemId() == R.id.gifts){
                toolbar.setTitle("Gifts");
                loadFragment(new Fragment02());
                return true;
            } else if(item.getItemId() == R.id.profile){
                toolbar.setTitle("Profile");
                loadFragment(new Fragment03());
                return true;
            }

            return false;
        }
    };
}
