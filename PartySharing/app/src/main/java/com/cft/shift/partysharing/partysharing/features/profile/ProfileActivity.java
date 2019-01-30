package com.cft.shift.partysharing.partysharing.features.profile;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.view.View;

import com.cft.shift.partysharing.partysharing.R;
import com.cft.shift.partysharing.partysharing.features.BaseActivity;
import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.MvpView;

public class ProfileActivity extends BaseActivity {
    @Override
    protected <T extends MvpView> MvpPresenter<T> getPresenter() {
        return null;
    }

    @Override
    protected <T extends MvpView> T getMvpView() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        View view = bottomNavigationView.findViewById(R.id.navigation_profile);
        view.performClick();
    }

}
