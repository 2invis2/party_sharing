package com.cft.shift.partysharing.partysharing.features.feed.presentation;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cft.shift.partysharing.partysharing.R;
import com.cft.shift.partysharing.partysharing.network.exchange.EventPreview;

import java.util.List;

import static com.cft.shift.partysharing.partysharing.util.Converter.base64ToBitmap;

public class FeedListAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    List<EventPreview> objects;

    FeedListAdapter(Context context, List<EventPreview> products) {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.event_preview, parent, false);
        }

        EventPreview event = getEventPreview(position);

        ((TextView) view.findViewById(R.id.event_name)).setText(event.getName());
        ((ImageView) view.findViewById(R.id.event_image)).setImageBitmap(base64ToBitmap(event.getPreview()));
        return view;
    }

    EventPreview getEventPreview(int position) {
        return ((EventPreview) getItem(position));
    }
}
