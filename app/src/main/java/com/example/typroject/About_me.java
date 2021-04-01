package com.example.typroject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class About_me extends AppCompatActivity {
    ImageView im_home, mail,linkdin,github,twitter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        im_home = findViewById(R.id.tool_home);
        im_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_home = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(to_home);
            }
        });

        mail = findViewById(R.id.imageButton2);
        linkdin = findViewById(R.id.imageButton3);
        github = findViewById(R.id.imageButton4);
        twitter = findViewById(R.id.imageButton5);

        mail.setOnClickListener(v -> {
            String to = "amit.kushwaha@somaiya.edu";
            Intent mail = new Intent(Intent.ACTION_SEND);
            mail.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
            mail.setType("message/rfc822");
            startActivity(Intent.createChooser(mail,"Choose email app:"));

        });
        linkdin.setOnClickListener(v -> {
            String url = "https://www.linkedin.com/in/amit-kushwaha-b156a2177/";
            Intent linkdin = new Intent(Intent.ACTION_VIEW);
            linkdin.setData(Uri.parse(url));
            startActivity(linkdin);

        });
        github.setOnClickListener(v -> {
            String url = "https://github.com/Amit-exe";
            Intent github = new Intent(Intent.ACTION_VIEW);
            github.setData(Uri.parse(url));
            startActivity(github);

        });
        twitter.setOnClickListener(v -> {
            String url = "https://twitter.com/ak190732";
            Intent twitter = new Intent(Intent.ACTION_VIEW);
            twitter.setData(Uri.parse(url));
            startActivity(twitter);

        });
    }
}