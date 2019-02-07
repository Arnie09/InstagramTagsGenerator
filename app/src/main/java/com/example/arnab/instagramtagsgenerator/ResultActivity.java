package com.example.arnab.instagramtagsgenerator;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class ResultActivity extends AppCompatActivity {

    String Tag;
    int no_of_tags;
    WebView webView;
    ArrayList<String> imagelinks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle bundle = getIntent().getExtras();
        Tag = bundle.getString("Tag");
        no_of_tags = bundle.getInt("numberoftags");
        TextView tv = findViewById(R.id.output);
        TextView tv2 = findViewById(R.id.output2);
        tv.setText("Tag: " + Tag);
        tv2.setText("Number of tags: " + valueOf(no_of_tags));
        new scrapInstagram().execute();
    }

    public class scrapInstagram extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            

            return null;
        }
    }
}


