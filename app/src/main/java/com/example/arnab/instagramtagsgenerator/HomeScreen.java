package com.example.arnab.instagramtagsgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    TextView tag_to_search;
    TextView number_of_tags;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        tag_to_search = findViewById(R.id.tagInput);
        number_of_tags = findViewById(R.id.noOfTags);
    }
    public void methodSearch(View view){
        Intent intent = new Intent(HomeScreen.this,ResultActivity.class);
        intent.putExtra("Tag",tag_to_search.getText().toString());
        startActivity(intent);
    }
}
