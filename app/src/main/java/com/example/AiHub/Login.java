package com.example.AiHub;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {

    private Button loginBtn;
    private TextView registerBtn, forgotPassword;

    private EditText username , password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn = findViewById(R.id.loginbtn);
        registerBtn = findViewById(R.id.register);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        forgotPassword = findViewById(R.id.forgot);


        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        if (!sh.getString("username", "").equals("")){
            Intent intent = new Intent(Login.this ,MainActivity.class);
            startActivity(intent);
        }





        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uuname = username.getText().toString();
                String ppass = password.getText().toString();
                if (!uuname.equals("")){
                    if (!ppass.equals("")){
//                        API.validateLogin(uuname, ppass, getApplicationContext());
                        Intent intent = new Intent(Login.this, NewDash.class);
                        startActivity(intent);
                    }else{

                        Toast.makeText(Login.this, "Password Must Not Be Empty", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Login.this, "Username Must Not Be Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this , SignUp.class);
                startActivity(intent);
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this ,ForgotPassword.class );
                startActivity(intent);
            }
        });
    }

}