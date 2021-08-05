package com.example.techproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements  View.OnClickListener{
EditText name,email,pass,cpass;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        name=findViewById(R.id.loginpass);
        email=findViewById(R.id.regemail);
        pass=findViewById(R.id.regpass);
        cpass=findViewById(R.id.regcpass);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(this);
        TextView btn=findViewById(R.id.alreadyaccount);
         btn.setOnClickListener(this);
        mFirebaseAuth=FirebaseAuth.getInstance();
   }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        String Personname = name.getText().toString();
        String Personemail = email.getText().toString();
        String pwd = pass.getText().toString();
        String cpwd = cpass.getText().toString();

        if (Personname.isEmpty()) {
            name.setError("Please Enter email id");
            name.requestFocus();
        }
         else if (Personemail.isEmpty()) {
            email.setError("Please enter username");
            email.requestFocus();
        } else if (pwd.isEmpty()) {
            pass.setError("Please enter password");
            pass.requestFocus();
        } else if (cpwd.isEmpty()) {
            cpass.setError("Please enter confirm password");
            cpass.requestFocus();
        }else if(!pwd.equals(cpwd)){
            Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show();
        } else if (!(Personemail.isEmpty() && pwd.isEmpty())) {
            mFirebaseAuth.createUserWithEmailAndPassword(Personemail, pwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                }
            });
        } else {
            Toast.makeText(this, "Error Occurred", Toast.LENGTH_SHORT).show();
        }

    
        switch(v.getId()){
            case R.id.alreadyaccount:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                break;
        }

    }


}
