package com.example.schedulehelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView nameList;
    private ArrayList<String> names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] NAMES = {"Test One", "Test Two", "Test Three"};
        ListAdapter nameAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,NAMES);
        ListView nameList = (ListView) findViewById(R.id.nameList);
        nameList.setAdapter(nameAdapter);

        nameList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String name = String.valueOf(adapterView.getItemAtPosition(i));
                        Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}
