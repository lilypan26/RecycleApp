package com.example.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

import static android.view.View.GONE;

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
        plastic.setOnClickListener(unused -> plastic());
        Button metal = findViewById(R.id.metal);
        metal.setOnClickListener(unused -> metal());
        Button glass = findViewById(R.id.glass);
        glass.setOnClickListener(unused -> glass());
        Button home = findViewById(R.id.home);
        home.setOnClickListener(unused -> onClick());

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
        startActivity(new Intent(this, Paper.class));
    }
    public void metal() {

    }
    public void glass() {

    }
    public void plastic() {

    }
    protected void onClick() {
        startActivity(new Intent(this, UI.class));
    }
}
