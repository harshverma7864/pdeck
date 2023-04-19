package com.example.pdeck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class Profile extends AppCompatActivity {

    TextView tName , tEmail , tCollege;
    MaterialCardView logoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tName = findViewById(R.id.username);
        tEmail = findViewById(R.id.email);
        tCollege = findViewById(R.id.cllg);
        logoutBtn = findViewById(R.id.logout);

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String name =  sh.getString("name","");
        String email = sh.getString("email", "");
        String college = sh.getString("college", "");

        tName.setText(name);
        tEmail.setText(email);
        tCollege.setText(college + "  ");

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sh.edit();
                myEdit.remove("name");
                myEdit.remove("email");
                myEdit.remove("college");
                myEdit.commit();
                Intent intent = new Intent(Profile.this , Loginactivity.class);
                startActivity(intent);

            }
        });

    }
}