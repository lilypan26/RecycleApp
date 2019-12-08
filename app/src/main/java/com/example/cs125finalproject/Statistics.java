package com.example.cs125finalproject;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ProgressBar;

public class Statistics extends AppCompatActivity {
    boolean b = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        if (b) {
            progressBar.incrementProgressBy(1);
        }
        //FloatingActionButton fab = findViewById(R.id.fab);

    }
    public void update() {
        b = true;
    }

}
