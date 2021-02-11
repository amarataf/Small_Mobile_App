package com.example.everapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MondayActivity extends AppCompatActivity {

    public static final String mypreferencesM ="myprefm";
    public static final String Name1kM = "name1keym";
    public static final String Name2kM = "name2keym";
    SharedPreferences sharedPreferencesM;
    TextView name1M, name2M;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monday);
        name1M = findViewById(R.id.editTextTextPersonName);
        name2M = findViewById(R.id.editTextTextPersonName2);
        sharedPreferencesM = getSharedPreferences(mypreferencesM, Context.MODE_PRIVATE);
        if (sharedPreferencesM.contains(Name1kM)) {
            name1M.setText(sharedPreferencesM.getString(Name1kM, ""));
        }
        if (sharedPreferencesM.contains(Name2kM)) {
            name2M.setText(sharedPreferencesM.getString(Name2kM, ""));
        }
    }
    public void Save(View view) {
        String n1 = name1M.getText().toString();
        String n2 = name2M.getText().toString();
        SharedPreferences.Editor editor = sharedPreferencesM.edit();
        editor.putString(Name1kM, n1);
        editor.putString(Name2kM, n2);
        editor.commit();
    }
    public void Clear(View view) {
        name1M = findViewById(R.id.editTextTextPersonName);
        name2M = findViewById(R.id.editTextTextPersonName2);
        name1M.setText("");
        name2M.setText("");
    }
}
