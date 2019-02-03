package com.cft.shift.partysharing.partysharing.features.create.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.cft.shift.partysharing.partysharing.R;
import com.cft.shift.partysharing.partysharing.features.BaseActivity;
import com.cft.shift.partysharing.partysharing.features.MvpView;
import com.cft.shift.partysharing.partysharing.features.feed.presentation.FeedActivity;
import com.cft.shift.partysharing.partysharing.features.profile.presentation.ProfileActivity;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class CreateEventActivity extends BaseActivity implements CreateActivityView {

    private CreateEventAdapter createEventAdapter;
    private ViewPager pager;
    private SpringDotsIndicator indicator;
    private CreatePresenter presenter;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_feed:
                    Intent intent0 = new Intent(CreateEventActivity.this, FeedActivity.class);
                    startActivity(intent0);
                    return true;
                case R.id.navigation_search:
                    return true;
                case R.id.navigation_create:
                    return true;
                case R.id.navigation_profile:
                    Intent intent = new Intent(CreateEventActivity.this, ProfileActivity.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected CreatePresenter getPresenter() {
        presenter = CreatePresenterFactory.createPresenter(this);
        return presenter;
    }

    public CreatePresenter accessPresenter() {
        return presenter;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event_activity);
        pager = findViewById(R.id.create_event_pager);
        indicator = findViewById(R.id.spring_dots_indicator_event);
        createEventAdapter = new CreateEventAdapter((getSupportFragmentManager()));
        pager.setAdapter(createEventAdapter);
        indicator.setViewPager(pager);
        initView();
    }

    private void initView(){
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onBackPressed() {
        if (pager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            pager.setCurrentItem(pager.getCurrentItem() - 1);
        }
    }

    private class CreateEventAdapter extends FragmentStatePagerAdapter {

        public CreateEventAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if (i == 0) {
                return new InterestCreateEventFragment();
            }
            if (i == 1) {
                return new CreateEventFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
