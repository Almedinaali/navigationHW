package com.example.zadaca_lv9;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ScrollableTabsActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_tabs);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.bringToFront();
        viewPager = findViewById(R.id.viewPager);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new Fragment01(), "ONE");
        adapter.addFragment(new Fragment02(), "TWO");
        adapter.addFragment(new Fragment03(), "THREE");
        adapter.addFragment(new Fragment04(), "FOUR");
        adapter.addFragment(new Fragment05(), "FIVE");
        adapter.addFragment(new Fragment06(), "SIX");
        adapter.addFragment(new Fragment07(), "SEVEN");
        adapter.addFragment(new Fragment08(), "EIGNT");
        adapter.addFragment(new Fragment09(), "NINE");
        adapter.addFragment(new Fragment10(), "TEN");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> myFragmentList = new ArrayList<>();
        private List<String> myTitleList = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return myFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return myFragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return myTitleList.get(position);
        }

        public void addFragment(Fragment fragment, String title){
            myFragmentList.add(fragment);
            myTitleList.add(title);
        }
    }
}