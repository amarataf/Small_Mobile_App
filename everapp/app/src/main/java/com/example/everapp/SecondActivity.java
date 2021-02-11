package com.example.everapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.everapp.MainActivity.Name1k;
import static com.example.everapp.MainActivity.Name2k;
import static com.example.everapp.MainActivity.Name3k;
import static com.example.everapp.MainActivity.mypreferences;

public class SecondActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView name1, name2, name3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        name1 = findViewById(R.id.ename1);
        name2 = findViewById(R.id.ename2);
        name3 = findViewById(R.id.ename3);
        sharedPreferences = getSharedPreferences(mypreferences, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(Name1k)) {
            name1.setText(sharedPreferences.getString(Name1k, ""));
        }
        if (sharedPreferences.contains(Name2k)) {
            name2.setText(sharedPreferences.getString(Name2k, ""));
        }
        if (sharedPreferences.contains(Name3k)) {
            name3.setText(sharedPreferences.getString(Name3k, ""));
        }
    }
    public void Save(View view) {
        String n1 = name1.getText().toString();
        String n2 = name2.getText().toString();
        String n3 = name3.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Name1k, n1);
        editor.putString(Name2k, n2);
        editor.putString(Name3k, n3);
        editor.commit();
    }
    public void Clear(View view) {
        name1 = findViewById(R.id.ename1);
        name2 = findViewById(R.id.ename2);
        name3 = findViewById(R.id.ename3);
        name1.setText("");
        name2.setText("");
        name3.setText("");
    }
}
