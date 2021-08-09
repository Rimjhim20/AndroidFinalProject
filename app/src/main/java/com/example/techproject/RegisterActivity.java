package com.example.techproject;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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



//package com.example.techproject;
//
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.RadioButton;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//
//
//import java.util.ArrayList;
//
//public class RegisterActivity extends AppCompatActivity implements  View.OnClickListener{
//EditText name,email,pass,cpass;
//    EditText edt,edt1,edt2,edt3,edt4,edt5;
//    RadioButton rdo1,rdo2;
//    Spinner spinner;
//    Helper DB;
//    ArrayList qualification;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//        name=findViewById(R.id.loginpass);
//        email=findViewById(R.id.regname);
//        pass=findViewById(R.id.regpass);
//        cpass=findViewById(R.id.regcpass);
//        DB=new Helper (this);
//
//        Button button=findViewById(R.id.button);
//        button.setOnClickListener(this);
//        TextView btn=findViewById(R.id.alreadyaccount);
//         btn.setOnClickListener(this);
//        spinner=findViewById(R.id.spinner);
//        qualification=new ArrayList();
//        qualification.add("not specified");
//        qualification.add("Undergraduate");
//        qualification.add("Postgraduate");
//        qualification.add("Masters");
//        qualification.add("Phd");
//        ArrayAdapter adapter= new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,qualification);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        spinner.setAdapter(adapter);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
//            }
//        });
//   }
//
//    @SuppressLint("NonConstantResourceId")
//    @Override
//    public void onClick(View v) {
//
//        String Personname = name.getText().toString();
//        String Personemail = email.getText().toString();
//        String pwd = pass.getText().toString();
//        String cpwd = cpass.getText().toString();
//
//        if (Personname.isEmpty()) {
//            name.setError("Please Enter email id");
//            name.requestFocus();
//        }
//         else if (Personemail.isEmpty()) {
//            email.setError("Please enter username");
//            email.requestFocus();
//        } else if (pwd.isEmpty()) {
//            pass.setError("Please enter password");
//            pass.requestFocus();
//        } else if (cpwd.isEmpty()) {
//            cpass.setError("Please enter confirm password");
//            cpass.requestFocus();
//        }
//        else if (cpwd.isEmpty()) {
//            cpass.setError("Please enter confirm password");
//            cpass.requestFocus();
//        }
//        else if(!pwd.equals(cpwd)){
//            Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show();
//        }
//        else if (Personemail.equals(" ")|| Personname.equals(" ") || pwd.equals(" ")|| cpwd.equals(" ")) {
//            Toast.makeText(this, "Please Enter all fields", Toast.LENGTH_SHORT).show();
//        }else {
//            if(pwd.equals(cpwd)){
//                Boolean checkuser = DB.checkusername(Personname);
//                if(checkuser==false){
//                    Boolean insert = DB.insertData(Personname,pwd);
//                    if(insert==true){
//                        Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show();
//                        Intent intent= new Intent( getApplicationContext(), LoginActivity.class);
//                        startActivity(intent);
//                    }else{
//                        Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
//                    }
//                }else{
//                    Toast.makeText(this, "User Already exists! Please Sign in", Toast.LENGTH_SHORT).show();
//                }
//            }else{
//                Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show();
//            }
//
//        }
//
//    }
//
//
//}
