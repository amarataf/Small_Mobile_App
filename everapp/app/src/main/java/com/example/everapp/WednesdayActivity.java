package com.example.everapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WednesdayActivity extends AppCompatActivity {

    public static final String mypreferencesMw ="myprefmw";
    public static final String Name1kMw = "name1keymw";
    public static final String Name2kMw = "name2keymw";
    SharedPreferences sharedPreferencesMw;
    TextView name1Mw, name2Mw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wednesday);
        name1Mw = findViewById(R.id.editTextTextPersonName);
        name2Mw = findViewById(R.id.editTextTextPersonName2);
        sharedPreferencesMw = getSharedPreferences(mypreferencesMw, Context.MODE_PRIVATE);
        if (sharedPreferencesMw.contains(Name1kMw)) {
            name1Mw.setText(sharedPreferencesMw.getString(Name1kMw, ""));
        }
        if (sharedPreferencesMw.contains(Name2kMw)) {
            name2Mw.setText(sharedPreferencesMw.getString(Name2kMw, ""));
        }
    }
    public void Save(View view) {
        String n1 = name1Mw.getText().toString();
        String n2 = name2Mw.getText().toString();
        SharedPreferences.Editor editor = sharedPreferencesMw.edit();
        editor.putString(Name1kMw, n1);
        editor.putString(Name2kMw, n2);
        editor.commit();
    }
    public void Clear(View view) {
        name1Mw = findViewById(R.id.editTextTextPersonName);
        name2Mw = findViewById(R.id.editTextTextPersonName2);
        name1Mw.setText("");
        name2Mw.setText("");
    }
}
