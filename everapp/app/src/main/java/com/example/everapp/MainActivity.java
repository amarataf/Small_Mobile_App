package com.example.everapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    public static final String mypreferences ="mypref";
    public static final String Name1k = "name1key";
    public static final String Name2k = "name2key";
    public static final String Name3k = "name3key";
    public static final String mynamek = "mynamek";
    SharedPreferences sharedPreferences;
    SharedPreferences sharename;
    TextView name1, name2, name3, myname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name1 = findViewById(R.id.reminder1);
        name2 = findViewById(R.id.reminder2);
        name3 = findViewById(R.id.reminder3);
        myname = findViewById(R.id.text1);
        dl = findViewById(R.id.activity_main);
        sharedPreferences = getSharedPreferences(mypreferences, Context.MODE_PRIVATE);
        sharename = getSharedPreferences(mynamek, Context.MODE_PRIVATE);
        t = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);
        if (sharedPreferences.contains(Name1k)) {
            name1.setText(sharedPreferences.getString(Name1k, ""));
        }
        if (sharedPreferences.contains(Name2k)) {
            name2.setText(sharedPreferences.getString(Name2k, ""));
        }
        if (sharedPreferences.contains(Name3k)) {
            name3.setText(sharedPreferences.getString(Name3k, ""));
        }
        if (sharename.contains(mynamek)) {
            myname.setText("Hello "+sharename.getString(mynamek, ""));
        }
        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = findViewById(R.id.nv);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.plat1:
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.plat2:
                        Intent intent2 = new Intent(MainActivity.this, WeekActivity.class);
                        startActivity(intent2);
                        return true;
                    case R.id.plat3:
                        Intent intent3 = new Intent(MainActivity.this, UserActivity.class);
                        startActivity(intent3);
                        return true;
                    default:
                        return true;
                }
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_main);
        name1 = findViewById(R.id.reminder1);
        name2 = findViewById(R.id.reminder2);
        name3 = findViewById(R.id.reminder3);
        myname = findViewById(R.id.text1);
        dl = findViewById(R.id.activity_main);
        sharedPreferences = getSharedPreferences(mypreferences, Context.MODE_PRIVATE);
        t = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);
        if (sharedPreferences.contains(Name1k)) {
            name1.setText(sharedPreferences.getString(Name1k, ""));
        }
        if (sharedPreferences.contains(Name2k)) {
            name2.setText(sharedPreferences.getString(Name2k, ""));
        }
        if (sharedPreferences.contains(Name3k)) {
            name3.setText(sharedPreferences.getString(Name3k, ""));
        }
        if (sharename.contains(mynamek)) {
            myname.setText("Hello "+sharename.getString(mynamek, ""));
        }
        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = findViewById(R.id.nv);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.plat1:
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.plat2:
                        Intent intent2 = new Intent(MainActivity.this, WeekActivity.class);
                        startActivity(intent2);
                        return true;
                    case R.id.plat3:
                        Intent intent3 = new Intent(MainActivity.this, UserActivity.class);
                        startActivity(intent3);
                        return true;
                    default:
                        return true;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}