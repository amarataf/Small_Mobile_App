package com.example.everapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.everapp.MainActivity.mynamek;

public class UserActivity extends AppCompatActivity {
    SharedPreferences sharename;
    TextView name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        name1 = findViewById(R.id.editTextTextPersonName3);
        sharename = getSharedPreferences(mynamek, Context.MODE_PRIVATE);
        if (sharename.contains(mynamek)) {
            name1.setText(sharename.getString(mynamek, ""));
        }
    }
    public void Save(View view) {
        String n1 = name1.getText().toString();
        SharedPreferences.Editor editor = sharename.edit();
        editor.putString(mynamek, n1);
        editor.commit();
    }
    public void Clear(View view) {
        name1 = findViewById(R.id.editTextTextPersonName3);
        name1.setText("");
    }
}
