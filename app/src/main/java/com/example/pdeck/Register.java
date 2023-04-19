package com.example.pdeck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.pdeck.constants.SetUrls;
import com.example.pdeck.models.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

     Button registerBtn;
        TextView loginBtn;
        TextView rollno , username , email , college, password, confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginBtn = findViewById(R.id.loginbtn);
        registerBtn = findViewById(R.id.registerBtn);

        rollno = findViewById(R.id.rollno);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        college = findViewById(R.id.college);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.cpassword);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this , Loginactivity.class);
                startActivity(intent);
            }
        });


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.getText().toString().equals(confirmPassword.getText().toString())){
                    if (nullCheck(rollno , username, email, college, password, confirmPassword)){
                      User user = new User();
                      user.setRollNo(rollno.getText().toString());
                      user.setPassword(password.getText().toString());
                      user.setEmail(email.getText().toString());
                      user.setCollegeName(college.getText().toString());
                      user.setName(username.getText().toString());
                      createUser(user);
                    }else {
                        Toast.makeText(Register.this, "Please Fill All The Entries", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Register.this, "Passwords Must Be Equal", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    private Boolean nullCheck(TextView rollno , TextView name , TextView email, TextView college, TextView pass, TextView cpass){
        if(rollno.getText().toString().equals("") ||
                email.getText().toString().equals("") ||
                name.getText().toString().equals("") ||
                college.getText().toString().equals("") ||
                pass.getText().toString().equals("") ||
                cpass.getText().toString().equals("")){
            return false;
        }else {
            return true;
        }
    }

    private void createUser(User user) {
        RequestQueue queue = Volley.newRequestQueue(Register.this);
        StringRequest request = new StringRequest(Request.Method.POST, SetUrls.SIGNUPURL, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(Register.this, "Data added to API", Toast.LENGTH_SHORT).show();
                try {
                    JSONObject respObj = new JSONObject(response);
                    String name = respObj.getString("name");
                    String job = respObj.getString("job");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(Register.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("name", user.getName());
                params.put("rollno", user.getRollNo());
                params.put("email", user.getEmail());
                params.put("college", user.getCollegeName());
                params.put("password", user.getPassword());

                // at last we are
                // returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }
}