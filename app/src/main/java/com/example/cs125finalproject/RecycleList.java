package com.example.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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
        startActivity(new Intent(this, Metal.class));
    }
    public void glass() {

    }
    public void plastic() {
        startActivity(new Intent(this, Plastic.class));
    }
    protected void search() {
        EditText searchBar = findViewById(R.id.searchBar);
        TextView isRecyclable = findViewById(R.id.isRecyclable);
        String arg = searchBar.getText().toString();
        arg.replace(" ", "+");

        String url = "https://search.earth911.com/?what="
            + arg + "&where=60048&list_filter=all&max_distance=25&family_id=&latitude=&longitude=&country=&province=&city=&sponsor=";

        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            String textContents = doc.body().text();

            if (textContents.contains("Curbside") || textContents.contains("curbside")) {
                isRecyclable.setText("Recyclable");
            }  else {
                isRecyclable.setText("Not Listed in Recyclable Item Database");
            }
            isRecyclable.setVisibility(View.VISIBLE);
        } catch (IOException e) {
            Log.e("IOException", e.getMessage());

        }
    }
}
