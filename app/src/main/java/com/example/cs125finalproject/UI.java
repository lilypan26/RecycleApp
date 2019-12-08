package com.example.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UI extends AppCompatActivity {
    boolean b = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        Button list = findViewById(R.id.enter);
        list.setOnClickListener(unused -> onClick());
        Button stats = findViewById(R.id.statsButton);
        stats.setOnClickListener(unused -> stats());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView congrats = findViewById(R.id.congrats);
        congrats.setVisibility(View.VISIBLE);
        if (b) {
            congrats.setVisibility(View.GONE);
        }
        /*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

         */
    }

    protected void onClick() {
        startActivity(new Intent(this, RecycleList.class));
    }
    protected void stats() {
        startActivity(new Intent(this, Statistics.class));
    }
    protected void showMessage() {
        b = true;
    }
}
