package com.cft.shift.partysharing.partysharing.features.register.presentation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cft.shift.partysharing.partysharing.R;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class RegisterActivity extends AppCompatActivity {

    private RegisterAdapter registerAdapter;
    private ViewPager registerPager;
    private SpringDotsIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);
        registerPager = findViewById(R.id.register_pager);
        indicator = findViewById(R.id.spring_dots_indicator);
        registerAdapter = new RegisterAdapter(getSupportFragmentManager());
        registerPager.setAdapter(registerAdapter);
        indicator.setViewPager(registerPager);
    }

    @Override
    public void onBackPressed() {
        if (registerPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            registerPager.setCurrentItem(registerPager.getCurrentItem() - 1);
        }
    }

    private class RegisterAdapter extends FragmentStatePagerAdapter {

        public RegisterAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if (i == 0) {
                return new InterestRegisterFragment();
            }
            if (i == 1) {
                return new ProfileRegisterFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

    }
}
