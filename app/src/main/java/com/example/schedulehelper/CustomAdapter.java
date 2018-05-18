package com.example.schedulehelper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Blake on 2018-05-18.
 */

class CustomAdapter extends ArrayAdapter{

     CustomAdapter( Context context, String[] NAMES) {
        super(context, R.layout.availability_row, NAMES);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater nameInfalter = LayoutInflater.from(getContext());
        View customView = nameInfalter.inflate(R.layout.availability_row, parent, false);
        String singleName = (String) getItem(position);
        TextView nameText = (TextView) customView.findViewById(R.id.name_text);
        ImageView sundayImage = (ImageView) customView.findViewById(R.id.sunday_image);
        ImageView mondayImage = (ImageView) customView.findViewById(R.id.monday_image);
        ImageView tuesdayImage = (ImageView) customView.findViewById(R.id.tuesday_image);
        ImageView wednesdayImage = (ImageView) customView.findViewById(R.id.wednesday_image);
        ImageView thursdayImage = (ImageView) customView.findViewById(R.id.thursday_image);
        ImageView fridayImage = (ImageView) customView.findViewById(R.id.friday_image);
        ImageView saturdayImage = (ImageView) customView.findViewById(R.id.saturday_image);

        nameText.setText(singleName);
        return customView;
    }
}
