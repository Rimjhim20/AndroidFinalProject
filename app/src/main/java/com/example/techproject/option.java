package com.example.techproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class option extends AppCompatActivity implements  View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        Button news=findViewById(R.id.news);
        news.setOnClickListener(this);
        Button weather=findViewById(R.id.weather);
        weather.setOnClickListener(this);
        }
    public void onClick(View v){

        switch(v.getId()){
            case R.id.weather:
                startActivity(new Intent(option.this, Weather.class));
                break;
            case R.id.news:
                startActivity(new Intent(option.this, MainActivity.class));
                break;

        }
    }
    }
