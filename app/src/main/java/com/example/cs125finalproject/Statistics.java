package com.example.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {
    //boolean b = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button home = findViewById(R.id.home);
        home.setOnClickListener(unused -> onClick());
        ProgressBar progressBar = findViewById(R.id.progressBar);
        int count = 0;
        progressBar.setProgress(count);
        boolean check = false;
        check = getIntent().getBooleanExtra("check", false);
        TextView items = findViewById(R.id.items);
        items.setText(Integer.toString(progressBar.getProgress()));
        if (check) {
            progressBar.incrementProgressBy(1);
            count++;
        }
        items.setText(Integer.toString(progressBar.getProgress()));
        //items.setText(Integer.toString(count));
        //FloatingActionButton fab = findViewById(R.id.fab);

    }
    protected void onClick() {
        Intent intent = new Intent(this, UI.class);
        intent.putExtra("check", false);
        startActivity(intent);
    }
    /*
    public void update() {
        b = true;
    }
*/
}
