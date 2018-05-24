package com.example.schedulehelper;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    employee emp1 = new employee("emp1","0000001");
    employee emp2 = new employee("emp2","0000010");
    employee emp3 = new employee("emp3","0000011");
    public ArrayList<employee> employees = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference nameDatabase;
        System.out.println("Made reference");
        nameDatabase = FirebaseDatabase.getInstance().getReference();
        /*employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        WriteNewEmployee(nameDatabase, "firebaseUser2", "1010101");*/
        final ArrayAdapter nameAdapter = new CustomAdapter(this, employees);
        ListView nameList =  findViewById(R.id.nameList);
        nameList.setAdapter(nameAdapter);

        FloatingActionButton addEmployeeButton = (FloatingActionButton) findViewById(R.id.add_employee_button);
        addEmployeeButton.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View view) {
                 Intent startIntent = new Intent(getApplicationContext(),AddEmployee.class);
                 startActivity(startIntent);
             }
         });

       nameDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot childSnapShot : dataSnapshot.child("Users").getChildren()){
                    System.out.println("childSnapShot is: "+ childSnapShot);
                    String name = (String) childSnapShot.child("name").getValue();

                    System.out.println("name is: " + name);
                    String availability = (String) childSnapShot.child("availability").getValue();
                    System.out.println("availability is: " + availability);

                    employee newEmp = new employee(name,availability);
                    employees.add(newEmp);
                    System.out.println("Added a new employee");
                    nameAdapter.notifyDataSetChanged();
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });


        nameList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String name = employees.get(i).getName();
                        Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
                    }
                }
        );



    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void WriteNewEmployee (DatabaseReference nameReference, String userName, String availability ){
        employee newUser;
        String [] timeOffString = {"January 1", "January 2"};
        newUser = new employee(userName,availability);
        nameReference.child("Users").child(newUser.getName()).setValue(newUser);

    }


}

