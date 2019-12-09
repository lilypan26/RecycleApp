package com.example.cs125finalproject;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Metal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView isRecyclable = findViewById(R.id.isRecyclable);

        Switch foodResidue = findViewById(R.id.foodResidue);
        Switch electronic = findViewById(R.id.electronic);
        RadioGroup metalType = findViewById(R.id.metalType);

        metalType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int id)
            {
                isRecyclable.setVisibility(View.VISIBLE);
                updateUI();
            }
        });

        foodResidue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateUI();
            }
        });

        electronic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateUI();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void updateUI() {
        TextView isRecyclable = findViewById(R.id.isRecyclable);

        Switch foodResidue = findViewById(R.id.foodResidue);
        Switch electronic = findViewById(R.id.electronic);
        RadioGroup metalType = findViewById(R.id.metalType);

        int checkedID = metalType.getCheckedRadioButtonId();

        if (checkedID != -1 && checkedID != R.id.lead && checkedID != R.id.mercury
            && foodResidue.isChecked() && !electronic.isChecked()) {
            isRecyclable.setText("Recyclable");
        } else {
            isRecyclable.setText("Not Recyclable");
        }
    }
}
