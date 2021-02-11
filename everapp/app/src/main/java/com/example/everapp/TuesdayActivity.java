package com.example.everapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TuesdayActivity extends AppCompatActivity {

    public static final String mypreferencest ="mypreft";
    public static final String Name1kt = "name1keyt";
    public static final String Name2kt = "name2keyt";
    SharedPreferences sharedPreferencest;
    TextView name1t, name2t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuesday);
        name1t = findViewById(R.id.editTextTextPersonName);
        name2t = findViewById(R.id.editTextTextPersonName2);
        sharedPreferencest = getSharedPreferences(mypreferencest, Context.MODE_PRIVATE);
        if (sharedPreferencest.contains(Name1kt)) {
            name1t.setText(sharedPreferencest.getString(Name1kt, ""));
        }
        if (sharedPreferencest.contains(Name2kt)) {
            name2t.setText(sharedPreferencest.getString(Name2kt, ""));
        }
    }
    public void Save(View view) {
        String n1 = name1t.getText().toString();
        String n2 = name2t.getText().toString();
        SharedPreferences.Editor editor = sharedPreferencest.edit();
        editor.putString(Name1kt, n1);
        editor.putString(Name2kt, n2);
        editor.commit();
    }
    public void Clear(View view) {
        name1t = findViewById(R.id.editTextTextPersonName);
        name2t = findViewById(R.id.editTextTextPersonName2);
        name1t.setText("");
        name2t.setText("");
    }
}
