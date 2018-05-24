package com.example.schedulehelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.view.Display;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Blake on 2018-05-18.
 */

class CustomAdapter extends ArrayAdapter {

    CustomAdapter(Context context, ArrayList<employee> employees) {
        super(context, R.layout.availability_row, employees);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater nameInfalter = LayoutInflater.from(getContext());
        View customView = nameInfalter.inflate(R.layout.availability_row, parent, false);
        String singleName = ((employee) getItem(position)).getName();
        String singleAvail = ((employee) getItem(position)).getAvailability();

        TextView name_text = (TextView) customView.findViewById(R.id.name_text);
        ImageView sundayImage = (ImageView) customView.findViewById(R.id.sunday_image);
        ImageView mondayImage = (ImageView) customView.findViewById(R.id.monday_image);
        ImageView tuesdayImage = (ImageView) customView.findViewById(R.id.tuesday_image);
        ImageView wednesdayImage = (ImageView) customView.findViewById(R.id.wednesday_image);
        ImageView thursdayImage = (ImageView) customView.findViewById(R.id.thursday_image);
        ImageView fridayImage = (ImageView) customView.findViewById(R.id.friday_image);
        ImageView saturdayImage = (ImageView) customView.findViewById(R.id.saturday_image);

        name_text.setText(singleName);
        if(singleAvail!=null) {
            if (singleAvail.charAt(6) == '0') {
                sundayImage.setImageResource(R.drawable.unavailable);
            } else {
                sundayImage.setImageResource(R.drawable.available);
            }
            if (singleAvail.charAt(5) == '0') {
                saturdayImage.setImageResource(R.drawable.unavailable);
            } else {
                saturdayImage.setImageResource(R.drawable.available);
            }
            if (singleAvail.charAt(4) == '0') {
                fridayImage.setImageResource(R.drawable.unavailable);
            } else {
                fridayImage.setImageResource(R.drawable.available);
            }
            if (singleAvail.charAt(3) == '0') {
                thursdayImage.setImageResource(R.drawable.unavailable);
            } else {
                thursdayImage.setImageResource(R.drawable.available);
            }
            if (singleAvail.charAt(2) == '0') {
                wednesdayImage.setImageResource(R.drawable.unavailable);
            } else {
                wednesdayImage.setImageResource(R.drawable.available);
            }
            if (singleAvail.charAt(1) == '0') {
                tuesdayImage.setImageResource(R.drawable.unavailable);
            } else {
                tuesdayImage.setImageResource(R.drawable.available);
            }
            if (singleAvail.charAt(0) == '0') {
                mondayImage.setImageResource(R.drawable.unavailable);
            } else {
                mondayImage.setImageResource(R.drawable.available);
            }
        }
        return customView;
    }
}





