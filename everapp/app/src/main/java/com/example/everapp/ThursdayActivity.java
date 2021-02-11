package com.example.everapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThursdayActivity extends AppCompatActivity {

    public static final String mypreferencesMt ="myprefmt";
    public static final String Name1kMt = "name1keymt";
    public static final String Name2kMt = "name2keymt";
    SharedPreferences sharedPreferencesMt;
    TextView name1Mt, name2Mt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thursday);
        name1Mt = findViewById(R.id.editTextTextPersonName);
        name2Mt = findViewById(R.id.editTextTextPersonName2);
        sharedPreferencesMt = getSharedPreferences(mypreferencesMt, Context.MODE_PRIVATE);
        if (sharedPreferencesMt.contains(Name1kMt)) {
            name1Mt.setText(sharedPreferencesMt.getString(Name1kMt, ""));
        }
        if (sharedPreferencesMt.contains(Name2kMt)) {
            name2Mt.setText(sharedPreferencesMt.getString(Name2kMt, ""));
        }
    }
    public void Save(View view) {
        String n1 = name1Mt.getText().toString();
        String n2 = name2Mt.getText().toString();
        SharedPreferences.Editor editor = sharedPreferencesMt.edit();
        editor.putString(Name1kMt, n1);
        editor.putString(Name2kMt, n2);
        editor.commit();
    }
    public void Clear(View view) {
        name1Mt = findViewById(R.id.editTextTextPersonName);
        name2Mt = findViewById(R.id.editTextTextPersonName2);
        name1Mt.setText("");
        name2Mt.setText("");
    }
}
