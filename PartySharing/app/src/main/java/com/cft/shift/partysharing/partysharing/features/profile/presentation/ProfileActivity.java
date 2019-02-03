package com.cft.shift.partysharing.partysharing.features.profile.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.cft.shift.partysharing.partysharing.R;
import com.cft.shift.partysharing.partysharing.features.BaseActivity;
import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.MvpView;
import com.cft.shift.partysharing.partysharing.features.create.presentation.CreateEventActivity;
import com.cft.shift.partysharing.partysharing.features.feed.presentation.FeedActivity;
import com.cft.shift.partysharing.partysharing.features.profile.domain.model.Profile;
import com.cft.shift.partysharing.partysharing.features.search.presentation.SearchActivity;
import com.cft.shift.partysharing.partysharing.network.exchange.EventPreview;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends BaseActivity implements ProfileView{
    private ProfilePresenter presenter;
    private ListView mListEvent;
    private ProfilesListAdapter mProfilesListAdapter;

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
                    Intent intent0 = new Intent(ProfileActivity.this, FeedActivity.class);
                    startActivity(intent0);
                    return true;
                case R.id.navigation_search:
                    Intent intent1 = new Intent(ProfileActivity.this, SearchActivity.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_create:
                    Intent intent2 = new Intent(ProfileActivity.this, CreateEventActivity.class);
                    startActivity(intent2);
                    return true;
                case R.id.navigation_profile:
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
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        image = findViewById(R.id.circle_profile);
        profileName = findViewById(R.id.title_profile_name);
        profileLocation = findViewById(R.id.title_profile_location);
        profileAge = findViewById(R.id.title_profile_age);
    }
    @Override
    public void showAttendEventsPreviw(int eventsNum, List<EventPreview> eventPreviews){
        mProfilesListAdapter = new ProfilesListAdapter(this, eventPreviews);

    }
    @Override
    public void showProfile(Profile profile) {
        if (profile.getImage() != null) {
            image.setImageBitmap(profile.getImage());
        }
        profileName.setText(profile.getFirstName()+profile.getLastName());
        profileAge.setText(profile.getAge());
        profileLocation.setText(profile.getLocation());
    }

    @Override
    public void showManageEventsPreview(int eventsNum, List<EventPreview> eventPreviews) {
        mProfilesListAdapter = new ProfilesListAdapter(this, eventPreviews);
        //mListEvent = findViewById(R.id.)
    }

    @Override
    public void showError(String message) {
    }

    public void fragmentReplace(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.profile_fragment_replace, fragment)
                .commit();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    @Override
    protected MvpPresenter<ProfileView> getPresenter() {
        presenter = PresenterProfileFactory.createProfilePresenter(this);
        return presenter;
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }
}
