package com.example.chint.viewpagerwithrecyclerview;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context c = getBaseContext();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tl = (TabLayout)findViewById(R.id.tablayout);
        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
        sections pa = new sections(getSupportFragmentManager(), MainActivity.this);
        vp.setAdapter(pa);
        tl.setupWithViewPager(vp);
        for(int i = 0; i < tl.getTabCount(); i++){
            TabLayout.Tab tab = tl.getTabAt(i);
            tab.setCustomView(pa.getTabView(i));
        }
    }

    public class sections extends FragmentPagerAdapter{

        String[] titles = {"GOOGLE","YAHOO","BING"};
        Context c;
        public sections(FragmentManager fm, Context c) {
            super(fm);
            this.c = c;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new GoogleFragment();
                case 1:
                    return new YahooFragment();
                case 2:
                    return new BingFragment();
            }
            return null;
        }



        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
        public View getTabView(int position){
            View tab = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_tab, null);
            TextView tv = (TextView)tab.findViewById(R.id.customtext);
            tv.setText(titles[position]);
            return tab;
        }
    }

}
