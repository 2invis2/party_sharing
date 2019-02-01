package com.cft.shift.partysharing.partysharing.features.profile.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cft.shift.partysharing.partysharing.R;

public class InterestCreateEventFragment extends Fragment {
    private ListView interestView;

    private static  String[] INTERESTS = new String[] {
            "Action", "Adventure", "Animation", "Children", "Comedy", "Documentary", "Drama",
            "Foreign", "History", "Independent", "Romance", "Sci-Fi", "Television", "Thriller"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_event_interest, container, false);
        interestView = view.findViewById(R.id.event_interest_list);
        interestView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        interestView.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_single_choice, INTERESTS));
        return view;
    }
}