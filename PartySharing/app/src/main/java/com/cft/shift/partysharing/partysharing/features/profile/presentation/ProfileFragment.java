package com.cft.shift.partysharing.partysharing.features.profile.presentation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cft.shift.partysharing.partysharing.R;

public class ProfileFragment extends Fragment{

    private TextView profileEvents;
    private Button interests;
    private Button profileEventsAttend;
    private Button profileEventsManage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profileEvents= view.findViewById(R.id.profile_events_title);
        interests = view.findViewById(R.id.profile_interests_button);
        profileEventsAttend = view.findViewById(R.id.profile_events_attend_button);
        profileEventsManage = view.findViewById(R.id.profile_events_manage_button);

        interests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ((ProfileActivity)requireActivity()).fragmentReplace(new ProfileInterestsFragment());
            }
        });

        profileEventsAttend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ((ProfileActivity)requireActivity()).fragmentReplace(new ProfileEventsAttendFragment());

                // fragmentReplace(new ProfileEventsAttendFragment());
            }
        });

        profileEventsManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ProfileActivity)requireActivity()).fragmentReplace(new ProfileEventsManageFragment());
              //  fragmentReplace(new ProfileEventsManageFragment());
            }
        });

        return view;
    }
}
