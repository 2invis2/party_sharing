package com.cft.shift.partysharing.partysharing.features.profile.presentation;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cft.shift.partysharing.partysharing.R;

import java.util.Calendar;

public class CreateEventFragment extends Fragment {
    private TextView aboutEvent;
    private EditText title;
    private EditText city;
    private EditText description;
    private ImageButton image;
    private Button chooseDate;
    private Button createEvent;
    private TextView date;

    private Calendar calendar;
    private DatePickerDialog datePickerDialog;


    @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_create_event_event, container, false);
        aboutEvent = view.findViewById(R.id.eventTextView);
        date = view.findViewById(R.id.event_date);
        title = view.findViewById(R.id.eventEditText3);
        city = view.findViewById(R.id.eventEditText6);
        description = view.findViewById(R.id.eventEditText7);
        image = view.findViewById(R.id.imageButton);
        chooseDate = view.findViewById(R.id.pick_date_button);
        createEvent = view.findViewById(R.id.create_button);

        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year  = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(requireActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        date.setText(day + "/" + (month + 1) + "/" +year);
                    }
                }, day, month, year);
                datePickerDialog.show();
            }
        });

        return view;
    }

}
