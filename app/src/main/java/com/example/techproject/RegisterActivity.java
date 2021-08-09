package com.example.techproject;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;
    Spinner spinner;
    ArrayList qualification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        spinner=findViewById(R.id.spinner);
        qualification=new ArrayList();
        qualification.add("not specified");
        qualification.add("Undergraduate");
        qualification.add("Postgraduate");
        qualification.add("Masters");
        qualification.add("Phd");

        ArrayAdapter adapter= new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,qualification);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        db = new DatabaseHelper(this);
        mTextUsername = findViewById(R.id.edittext_username);
        mTextPassword = findViewById(R.id.edittext_password);
        mTextCnfPassword = findViewById(R.id.edittext_cnf_password);
        mButtonRegister = findViewById(R.id.button_register);
        mTextViewLogin =findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();


                if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,pwd);
                    if(val > 0){

                        if (user.isEmpty()) {
                            mTextUsername.setError("Please Enter username ");
                            mTextUsername.requestFocus();


                        }
                        else if( pwd.isEmpty()){
                            mTextPassword.setError("Please Enter Password ");
                            mTextPassword.requestFocus();
                        }
                        else if( cnf_pwd.isEmpty()){
                            mTextCnfPassword.setError("Please Enter Confirm Password ");
                            mTextCnfPassword.requestFocus();
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "You have registered", Toast.LENGTH_SHORT).show();
                            Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(moveToLogin);
                        }
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"Registeration Error",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(RegisterActivity.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}



