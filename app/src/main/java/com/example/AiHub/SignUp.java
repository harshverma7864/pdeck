package com.example.AiHub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.AiHub.apis.API;

public class SignUp extends AppCompatActivity {

    private EditText username , password , cpassword , email;
    private TextView loginBtn;
    private Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.cpassword);
        registerBtn = findViewById(R.id.registerBtn);
        loginBtn = findViewById(R.id.loginbtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String uemail = email.getText().toString();
                String upass = password.getText().toString();
                String cpass = cpassword.getText().toString();
                if (!uname.equals("") || !uemail.equals("") || !upass.equals("") || !cpass.equals("")){
                    if (upass.equals(cpass)){
                        API.registerUser(uname , uemail , upass, getApplicationContext());
                    }else {
                        Toast.makeText(SignUp.this, "Password and Confirm Password must be Same", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(SignUp.this, "All Fields Must Be Filled", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });

    }
}