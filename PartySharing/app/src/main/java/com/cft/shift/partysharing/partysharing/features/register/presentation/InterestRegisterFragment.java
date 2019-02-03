package com.cft.shift.partysharing.partysharing.features.register.presentation;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cft.shift.partysharing.partysharing.R;
import com.cft.shift.partysharing.partysharing.types.InterestType;

import java.util.ArrayList;
import java.util.List;

public class InterestRegisterFragment extends Fragment {

    private ListView interestView;
    RegisterActivity activity;
    RegisterPresenter presenter;

    private static String[] INTERESTS = InterestType.getAllNames();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register_interest, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (RegisterActivity) getActivity();
        presenter = activity.accessPresenter();
        setupInterestView(activity);
    }

    private void setupInterestView(Activity activity) {
        interestView = activity.findViewById(R.id.interest_list);
        interestView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        interestView.setAdapter(new ArrayAdapter<>(this.activity, android.R.layout.simple_list_item_multiple_choice, INTERESTS));
        interestView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<String> selected = new ArrayList<>();
                SparseBooleanArray selection = interestView.getCheckedItemPositions();
                for (int i = 0; i < selection.size(); i++) {
                    selected.add(InterestType.values()[i].toString());
                }
                presenter.setSelectedInterests(String.join(",", selected));
            }
        });
    }

}
