package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
}
