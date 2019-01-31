package com.cft.shift.partysharing.partysharing.features.profile.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cft.shift.partysharing.partysharing.R;
import com.cft.shift.partysharing.partysharing.features.BaseActivity;
import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.MvpView;
import com.cft.shift.partysharing.partysharing.features.feed.presentation.FeedActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends BaseActivity implements ProfileView{
    private ProfilePresenter presenter;

    private TextView mTextMessage;

    private CircleImageView image;
    private TextView profileName;
    private TextView profileLocation;
    private TextView profileAge;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()) {
                case R.id.navigation_feed:
                    mTextMessage.setText(R.string.title_feed);
                    ProfileActivity.super.onStop();
                    Intent intent0 = new Intent(ProfileActivity.this, FeedActivity.class);
                    startActivity(intent0);
                    return true;
                case R.id.navigation_search:
                    mTextMessage.setText(R.string.title_search);
                    //Intent intent1 = new Intent(ProfileActivity.this, SearchActivity.class);
                    //startActivity(intent1);
                    return true;
                case R.id.navigation_create:
                    mTextMessage.setText(R.string.title_create);
                    //Intent intent2 = new Intent(ProfileActivity.this, CreateActivity.class);
                    //startActivity(intent2);
                    return true;
                case R.id.navigation_profile:
                    mTextMessage.setText(R.string.title_profile);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_base);
        fragmentReplace(new ProfileFragment());
        initView();
    }

    private void initView() {
        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        image = findViewById(R.id.circle_profile);
        profileName = findViewById(R.id.title_profile_name);
        profileLocation = findViewById(R.id.title_profile_location);
        profileAge = findViewById(R.id.title_profile_age);
    }

    @Override
    protected MvpPresenter<ProfileView> getPresenter() {
        presenter = new ProfilePresenter();
        return presenter;
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

    @Override
    public void showError(String message) {

    }

    private void fragmentReplace(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.profile_fragment_replace, fragment)
                .commit();
    }
}
