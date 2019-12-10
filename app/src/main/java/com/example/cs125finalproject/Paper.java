package com.example.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class Paper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView isRecyclable = findViewById(R.id.recyclable);
        Button back = findViewById(R.id.back);
        back.setOnClickListener(unused -> back());
        Button recycle = findViewById(R.id.recycle);
        recycle.setOnClickListener(unused -> show());
        Switch clean = findViewById(R.id.clean);
        clean.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    isRecyclable.setText("Not Recyclable!");
                } else {
                    isRecyclable.setText("Recyclable!");
                }
            }
        });
        Switch mirror = findViewById(R.id.mirror);
        mirror.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    isRecyclable.setText("Not Recyclable!");
                } else {
                    isRecyclable.setText("Recyclable!");
                }
            }
        });
        Switch cookware = findViewById(R.id.cookware);
        cookware.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    isRecyclable.setText("Not Recyclable!");
                } else {
                    isRecyclable.setText("Recyclable!");
                }
            }
        });
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
    protected void show() {
        Intent intent = new Intent(this, Statistics.class);
        //intent.putExtra("check", true);
        Intent uiIntent = new Intent(this, UI.class);
        uiIntent.putExtra("check", true);
        startActivity(uiIntent);
    }
    protected void back() {
        startActivity(new Intent(this, RecycleList.class));
    }

}
