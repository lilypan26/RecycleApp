package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class Plastic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plastic);

        TextView isRecyclable = findViewById(R.id.isRecyclable);

        Button back = findViewById(R.id.back);
        back.setOnClickListener(unused -> back());
        Button recycle = findViewById(R.id.recycle);
        recycle.setOnClickListener(unused -> show());

        Switch clean = findViewById(R.id.foodResidue);
        RadioGroup number = findViewById(R.id.plasticNumber);

        number.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int id)
            {
                isRecyclable.setVisibility(View.VISIBLE);
                updateUI();
            }
        });

        clean.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateUI();
            }
        });
    }

    private void updateUI() {
        TextView isRecyclable = findViewById(R.id.isRecyclable);

        Switch clean = findViewById(R.id.foodResidue);
        RadioGroup number = findViewById(R.id.plasticNumber);

        int checkedId = number.getCheckedRadioButtonId();

        if ((checkedId == R.id.one || checkedId == R.id.two) && clean.isChecked()) {
            isRecyclable.setText("Recyclable");
        } else {
            isRecyclable.setText("Not Recyclable");
        }
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
