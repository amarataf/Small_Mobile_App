package com.example.everapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SundayActivity extends AppCompatActivity {

    public static final String mypreferencesMs ="myprefms";
    public static final String Name1kMs = "name1keyms";
    public static final String Name2kMs = "name2keyms";
    SharedPreferences sharedPreferencesMs;
    TextView name1Ms, name2Ms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sunday);
        name1Ms = findViewById(R.id.editTextTextPersonName);
        name2Ms = findViewById(R.id.editTextTextPersonName2);
        sharedPreferencesMs = getSharedPreferences(mypreferencesMs, Context.MODE_PRIVATE);
        if (sharedPreferencesMs.contains(Name1kMs)) {
            name1Ms.setText(sharedPreferencesMs.getString(Name1kMs, ""));
        }
        if (sharedPreferencesMs.contains(Name2kMs)) {
            name2Ms.setText(sharedPreferencesMs.getString(Name2kMs, ""));
        }
    }
    public void Save(View view) {
        String n1 = name1Ms.getText().toString();
        String n2 = name2Ms.getText().toString();
        SharedPreferences.Editor editor = sharedPreferencesMs.edit();
        editor.putString(Name1kMs, n1);
        editor.putString(Name2kMs, n2);
        editor.commit();
    }
    public void Clear(View view) {
        name1Ms = findViewById(R.id.editTextTextPersonName);
        name2Ms = findViewById(R.id.editTextTextPersonName2);
        name1Ms.setText("");
        name2Ms.setText("");
    }
}
