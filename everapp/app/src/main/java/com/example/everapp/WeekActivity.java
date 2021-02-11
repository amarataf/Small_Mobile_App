package com.example.everapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WeekActivity extends AppCompatActivity {

    ListView listview;
    String[] data = {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);
        listview = findViewById(R.id.listviewy);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intentm = new Intent(WeekActivity.this, MondayActivity.class);
                    startActivity(intentm);
                }
                if (position == 1) {
                    Intent intenttu = new Intent(WeekActivity.this, TuesdayActivity.class);
                    startActivity(intenttu);
                }
                if (position == 2) {
                    Intent intentw = new Intent(WeekActivity.this, WednesdayActivity.class);
                    startActivity(intentw);
                }
                if (position == 3) {
                    Intent intentt = new Intent(WeekActivity.this, ThursdayActivity.class);
                    startActivity(intentt);
                }
                if (position == 4) {
                    Intent intentf = new Intent(WeekActivity.this, FridayActivity.class);
                    startActivity(intentf);
                }
                if (position == 5) {
                    Intent intentsa = new Intent(WeekActivity.this, SaturdayActivity.class);
                    startActivity(intentsa);
                }
                if (position == 6) {
                    Intent intents = new Intent(WeekActivity.this, SundayActivity.class);
                    startActivity(intents);
                }
            }
        });
    }
}