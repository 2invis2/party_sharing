package com.cft.shift.partysharing.partysharing.features.create.presentation;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.cft.shift.partysharing.partysharing.util.Converter;
import com.cft.shift.partysharing.partysharing.util.IdSaver;

import java.io.FileNotFoundException;
import java.io.InputStream;
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
    private EditText address;
    private String dateFormated;

    private Calendar calendar;
    private DatePickerDialog datePickerDialog;


    @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_create_event_event, container, false);
        aboutEvent = view.findViewById(R.id.eventTextView);
        date = view.findViewById(R.id.event_date);
        title = view.findViewById(R.id.event_tittle);
        city = view.findViewById(R.id.event_city);
        description = view.findViewById(R.id.event_desc);
        image = view.findViewById(R.id.imageButton);
        chooseDate = view.findViewById(R.id.pick_date_button);
        createEvent = view.findViewById(R.id.create_button);
        address = view.findViewById(R.id.event_address);

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
                        dateFormated = year + "-" + (month + 1) + "-" + day + "T00:00:00";
                    }
                }, day, month, year);
                datePickerDialog.show();
            }
        });


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
            }
        });

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CreateEventActivity)getActivity()).getMyPresenter().setEventInfo(title.getText().toString(),
                        city.getText().toString(), address.getText().toString(), dateFormated,
                        description.getText().toString());
                ((CreateEventActivity)getActivity()).getMyPresenter().create(IdSaver.getId(getActivity()));
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (data == null) {
                return;
            }
            try {
                InputStream inputStream = getActivity().getContentResolver().openInputStream(data.getData());
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                image.setImageBitmap(bitmap);
                ((CreateEventActivity)getActivity()).getMyPresenter().setImage(Converter.bitmapToBase64(bitmap));
            } catch (FileNotFoundException e) {
                //pass
            }
        }
    }

}
