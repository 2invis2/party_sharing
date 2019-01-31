package com.cft.shift.partysharing.partysharing.features.profile.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.cft.shift.partysharing.partysharing.R;
import com.cft.shift.partysharing.partysharing.features.BaseActivity;
import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.MvpView;
import com.cft.shift.partysharing.partysharing.features.feed.presentation.FeedActivity;

public class CreateEventActivity extends BaseActivity implements CreateActivityView {

    private CreateActivityPresenter presenter;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event_activity);

        initView();
    }

    private void initView(){
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected MvpPresenter<CreateActivityView> getPresenter() {
        presenter = new CreateActivityPresenter();
        return presenter;
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

    @Override
    public void showError(String message) {

    }
}
