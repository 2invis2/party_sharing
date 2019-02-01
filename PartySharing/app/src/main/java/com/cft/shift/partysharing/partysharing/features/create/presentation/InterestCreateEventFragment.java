package com.cft.shift.partysharing.partysharing.features.create.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cft.shift.partysharing.partysharing.R;
import com.cft.shift.partysharing.partysharing.features.register.presentation.RegisterActivity;
import com.cft.shift.partysharing.partysharing.types.InterestType;

import java.util.ArrayList;
import java.util.List;

public class InterestCreateEventFragment extends Fragment {
    private ListView interestView;

    private static  String[] INTERESTS = InterestType.getAllNames();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_event_interest, container, false);
        interestView = view.findViewById(R.id.event_interest_list);
        interestView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        interestView.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_single_choice, INTERESTS));
        interestView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray selection = interestView.getCheckedItemPositions();
                for (int i = 0; i < selection.size(); i++) {
                    ((CreateEventActivity)getActivity()).getMyPresenter().setInterest(InterestType.values()[i]);
                }
            }
        });
        return view;
    }
}