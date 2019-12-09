package com.example.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

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

        Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(unused -> search());

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
        startActivity(new Intent(this, Plastic.class));
    }
    protected void search() {
        EditText searchBar = findViewById(R.id.searchBar);
        String material = searchBar.getText().toString();
        searchBar.setText("");

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });

        queue.add(jsonObjectRequest);
    }
}
