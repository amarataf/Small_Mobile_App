package com.example.everapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SaturdayActivity extends AppCompatActivity {

    public static final String mypreferencesMsa ="myprefmsa";
    public static final String Name1kMsa = "name1keymsa";
    public static final String Name2kMsa = "name2keymsa";
    SharedPreferences sharedPreferencesMsa;
    TextView name1Msa, name2Msa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saturday);
        name1Msa = findViewById(R.id.editTextTextPersonName);
        name2Msa = findViewById(R.id.editTextTextPersonName2);
        sharedPreferencesMsa = getSharedPreferences(mypreferencesMsa, Context.MODE_PRIVATE);
        if (sharedPreferencesMsa.contains(Name1kMsa)) {
            name1Msa.setText(sharedPreferencesMsa.getString(Name1kMsa, ""));
        }
        if (sharedPreferencesMsa.contains(Name2kMsa)) {
            name2Msa.setText(sharedPreferencesMsa.getString(Name2kMsa, ""));
        }
    }
    public void Save(View view) {
        String n1 = name1Msa.getText().toString();
        String n2 = name2Msa.getText().toString();
        SharedPreferences.Editor editor = sharedPreferencesMsa.edit();
        editor.putString(Name1kMsa, n1);
        editor.putString(Name2kMsa, n2);
        editor.commit();
    }
    public void Clear(View view) {
        name1Msa = findViewById(R.id.editTextTextPersonName);
        name2Msa = findViewById(R.id.editTextTextPersonName2);
        name1Msa.setText("");
        name2Msa.setText("");
    }
}
