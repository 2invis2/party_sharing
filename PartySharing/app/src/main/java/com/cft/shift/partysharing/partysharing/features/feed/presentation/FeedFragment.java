package com.cft.shift.partysharing.partysharing.features.feed.presentation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cft.shift.partysharing.partysharing.R;
import com.cft.shift.partysharing.partysharing.features.MvpView;

public class FeedFragment extends Fragment implements MvpView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed, container, false);

        /*if (getArguments().getInt(ARG_SECTION_NUMBER) == 0) {
            View rootView = inflater.inflate(R.layout.fragment_feed, container, false);
            return rootView;
        } else {
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                View rootView = inflater.inflate(R.layout.fragment_pending, container, false);
                return rootView;*/
    }

}