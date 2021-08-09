package com.example.techproject;


import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        mTextUsername = findViewById(R.id.edittext_username);
        mTextPassword = findViewById(R.id.edittext_password);
        mButtonLogin = (findViewById(R.id.button_login));
        mTextViewRegister = findViewById(R.id.textview_register);
        mTextViewRegister.setOnClickListener(view -> {
            Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
        });

        mButtonLogin.setOnClickListener(view -> {
            String user = mTextUsername.getText().toString().trim();
            String pwd = mTextPassword.getText().toString().trim();
            boolean res = db.checkUser(user, pwd);
            if(res)
            {
                if (user.isEmpty()) {
                    mTextUsername.setError("Please Enter username ");
                    mTextUsername.requestFocus();


                } else if( pwd.isEmpty()){
                    mTextPassword.setError("Please Enter Password ");
                    mTextPassword.requestFocus();
                }
                else {
                    Intent HomePage = new Intent(LoginActivity.this, option.class);
                    startActivity(HomePage);
                }
            }
            else
            {
                Toast.makeText(LoginActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
            }
        });
    }


}



