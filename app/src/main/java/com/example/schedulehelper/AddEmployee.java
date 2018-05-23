package com.example.schedulehelper;

import android.content.Intent;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddEmployee extends AppCompatActivity {

    String availability;
    String name = null;
    boolean monday;
    boolean tuesday;
    boolean wednesday;
    boolean thursday;
    boolean friday;
    boolean saturday;
    boolean sunday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);


        Button create_user_button = (Button)findViewById(R.id.button_CreateUser);
        ToggleButton monday_toggle = (ToggleButton) findViewById(R.id.toggleButton_Mo);
        ToggleButton tuesday_toggle = (ToggleButton) findViewById(R.id.toggleButton_Tu);
        final ToggleButton wednesday_toggle = (ToggleButton) findViewById(R.id.toggleButton_We);
        ToggleButton thursday_toggle = (ToggleButton) findViewById(R.id.toggleButton_Th);
        ToggleButton friday_toggle = (ToggleButton) findViewById(R.id.toggleButton_Fr);
        ToggleButton saturday_toggle = (ToggleButton) findViewById(R.id.toggleButton_Sa);
        ToggleButton sunday_toggle = (ToggleButton) findViewById(R.id.toggleButton_Su);
        final EditText name_text = (EditText) findViewById(R.id.new_name_text);





        create_user_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = (String)name_text.getText().toString();
                if(name.matches("")) {
                    Toast.makeText(getApplication().getBaseContext(), "Please Enter a Name", Toast.LENGTH_LONG).show();
                }
                else {
                    DatabaseReference firebaseRef = FirebaseDatabase.getInstance().getReference();
                    System.out.println("The new employee's name is" + name);
                    WriteNewEmployee(firebaseRef,name,convertToAvailability(monday,tuesday,wednesday,thursday,friday,saturday,sunday));
                    Intent startIntent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(startIntent);
                }

            }
        });

        monday_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    monday = isChecked;

            }
        });
        tuesday_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tuesday = isChecked;
            }
        });
        wednesday_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                wednesday = isChecked;
            }
        });
        thursday_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               thursday = isChecked;
            }
        });
        friday_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                friday = isChecked;
            }
        });
        saturday_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               saturday = isChecked;
            }
        });
        sunday_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               sunday = isChecked;
            }
        });

    }

    public void WriteNewEmployee (DatabaseReference nameReference, String userName, String availability ){
        employee newUser;
        newUser = new employee(userName,availability);
        nameReference.child("Users").child(newUser.getName()).setValue(newUser);

    }

    public String convertToAvailability(boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday){
        if(monday){
             availability = "1";
        }
        else{
             availability = "0";
        }
        if(tuesday){
            availability+="1";
        }
        else{
            availability+="0";
        }
        if(wednesday){
            availability+="1";
        }
        else{
            availability+="0";
        }
        if(thursday){
            availability+="1";
        }
        else{
            availability+="0";
        }
        if(friday){
            availability+="1";
        }
        else{
            availability+="0";
        }
        if(saturday){
            availability+="1";
        }
        else{
            availability+="0";
        }
        if(sunday){
            availability+="1";
        }
        else{
            availability+="0";
        }
        return availability;
    }
}
