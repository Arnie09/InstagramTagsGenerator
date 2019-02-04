package com.example.arnab.instagramtagsgenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle bundle = getIntent().getExtras();
        String Tag = bundle.getString("Tag");
        TextView tv = findViewById(R.id.output);
        tv.setText(Tag);
    }
}
