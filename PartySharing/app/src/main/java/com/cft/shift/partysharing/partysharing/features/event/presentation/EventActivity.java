package com.cft.shift.partysharing.partysharing.features.event.presentation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cft.shift.partysharing.partysharing.R;
import com.cft.shift.partysharing.partysharing.features.BaseActivity;
import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.MvpView;
import com.cft.shift.partysharing.partysharing.features.event.domain.model.Event;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileResponse;

import java.util.List;

public class EventActivity extends BaseActivity implements EventView {
    private TextView event_name;
    private TextView event_description;
    private TextView event_date;
    private TextView event_location;
    private TextView event_creator_name;
    private TextView event_members_num;
    private Button event_members;
    private EventPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_event);
        configureView();
    }
    private void configureView(){
        event_name = findViewById(R.id.title_event_name);
        event_creator_name = findViewById(R.id.events_autor);
        event_date = findViewById(R.id.event_date);
        event_description= findViewById(R.id.event_description);
        event_location=findViewById(R.id.event_location);
        event_members_num=findViewById(R.id.event_members_num);
        event_members=findViewById(R.id.event_members);
        event_members.setOnClickListener(onMembersButtonClickListener);
    }

    private View.OnClickListener onMembersButtonClickListener = new View.OnClickListener() {
        Fragment fragment = null;
        @Override
        public void onClick(View v) {
            fragment = new MembersFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.event_frame ,fragment);
            ft.commit();
        }

    };

    @Override
    protected MvpPresenter<EventView> getPresenter() {
        presenter = PresenterEventFactory.createEventPresenter(this);
        return presenter;
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

    @Override
    public void showEvent(Event event) {

    }

    @Override
    public void showParticipants(int numPartic, List<GetProfileResponse> profiles) {

    }

    @Override
    public void showError(String message) {

    }
}
