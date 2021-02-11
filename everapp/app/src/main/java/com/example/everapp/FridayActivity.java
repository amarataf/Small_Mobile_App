package com.example.everapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FridayActivity extends AppCompatActivity {

    public static final String mypreferencesMf ="myprefmf";
    public static final String Name1kMf = "name1keymf";
    public static final String Name2kMf = "name2keymf";
    SharedPreferences sharedPreferencesMf;
    TextView name1Mf, name2Mf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friday);
        name1Mf = findViewById(R.id.editTextTextPersonName);
        name2Mf = findViewById(R.id.editTextTextPersonName2);
        sharedPreferencesMf = getSharedPreferences(mypreferencesMf, Context.MODE_PRIVATE);
        if (sharedPreferencesMf.contains(Name1kMf)) {
            name1Mf.setText(sharedPreferencesMf.getString(Name1kMf, ""));
        }
        if (sharedPreferencesMf.contains(Name2kMf)) {
            name2Mf.setText(sharedPreferencesMf.getString(Name2kMf, ""));
        }
    }
    public void Save(View view) {
        String n1 = name1Mf.getText().toString();
        String n2 = name2Mf.getText().toString();
        SharedPreferences.Editor editor = sharedPreferencesMf.edit();
        editor.putString(Name1kMf, n1);
        editor.putString(Name2kMf, n2);
        editor.commit();
    }
    public void Clear(View view) {
        name1Mf = findViewById(R.id.editTextTextPersonName);
        name2Mf = findViewById(R.id.editTextTextPersonName2);
        name1Mf.setText("");
        name2Mf.setText("");
    }
}
