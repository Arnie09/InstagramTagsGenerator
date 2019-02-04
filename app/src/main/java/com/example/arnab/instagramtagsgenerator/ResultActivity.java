package com.example.arnab.instagramtagsgenerator;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class ResultActivity extends AppCompatActivity {

    String Tag;
    int no_of_tags;
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
        tv2.setText("Number of tags: "+valueOf(no_of_tags));
        new scrapInstagram().execute();
    }
    public class scrapInstagram extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            String url = "https://www.instagram.com/explore/tags/"+Tag.trim()+"/";
            Log.i("URLS",url);
            String Doc = null;
            try {
                Doc = Jsoup.connect(url).get().html();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Document Doc2 = Jsoup.parse(Doc);

            Elements tags = Doc2.select("div.v1Nh3.kIKUG._bz0w a");
            for(int i =0 ;i< tags.size();i++) {
                imagelinks.add(tags.get(0).toString());
            }
            //Toast.makeText(ResultActivity.this, "Hurrah", Toast.LENGTH_SHORT).show();
            for(int i = 0;i<imagelinks.size();i++){
                Log.i("Chandrika", imagelinks.get(i));
            }
            return null;
        }

    }
}
