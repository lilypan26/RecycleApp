package com.example.cs125finalproject;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class RecycleList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button paper = findViewById(R.id.paper);
        paper.setOnClickListener(unused -> paper());
        Button plastic = findViewById(R.id.plastic);
        paper.setOnClickListener(unused -> plastic());
        Button metal = findViewById(R.id.metal);
        paper.setOnClickListener(unused -> metal());
        Button glass = findViewById(R.id.glass);
        paper.setOnClickListener(unused -> glass());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void paper() {

    }
    public void metal() {

    }
    public void glass() {

    }
    public void plastic() {

    }
}
