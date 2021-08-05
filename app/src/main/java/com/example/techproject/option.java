package com.example.techproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class option extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        Button news=findViewById(R.id.news);
        news.setOnClickListener(new View.OnClickListener(){



            @Override
            public void onClick(View view) {
                startActivity(new Intent(option.this,MainActivity.class));
            }
        });
    }
}