package com.example.valeriyasin.technotracksimple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = (ImageView) findViewById(R.id.mainImage);
//        iv.setImageResource(R.drawable.c);
        try {
            Thread.sleep(10000);
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        } catch (InterruptedException e) {
            System.out.println("application was interrupted\n");
        }
    }
}
