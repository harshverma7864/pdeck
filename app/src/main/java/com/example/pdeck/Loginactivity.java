package com.example.pdeck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pdeck.constants.GetUrls;
import com.example.pdeck.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Loginactivity extends AppCompatActivity{
        TextView registerHere, forgot;
        Button loginBtn;
        EditText  user , pass;
        private static User userGlobal = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        registerHere = findViewById(R.id.register);
        loginBtn = findViewById(R.id.loginbtn);
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        forgot = findViewById(R.id.forgot);


        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        if(!sh.getString("name", "").equals("")){
            Intent intent = new Intent(Loginactivity.this, NewDash.class);
            startActivity(intent);
        }
        else{
            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (user.getText().toString().equals("")) {
                        Toast.makeText(Loginactivity.this, "Please Enter Username", Toast.LENGTH_SHORT).show();
                    } else if (pass.getText().toString().equals("")) {
                        Toast.makeText(Loginactivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    } else {
                        getUserInfo(user.getText().toString());
                    }
                }
            });
        }

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Loginactivity.this, Forgot.class);
                startActivity(intent);
            }
        });

        registerHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Loginactivity.this , Register.class);
                startActivity(intent);
            }
        });
    }

    public User getUserInfo(String username) {
        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = GetUrls.LOGINURL + username;
        User userT = new User();
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                                JSONObject jsonObject =  jsonArray.getJSONObject(0);
                                userGlobal.setId(Integer.parseInt(jsonObject.getString("sno")));
                            userGlobal.setName(jsonObject.getString("name"));
                            userGlobal.setCollegeName(jsonObject.getString("college"));
                            userGlobal.setEmail(jsonObject.getString("email"));
                            userGlobal.setRollNo(jsonObject.getString("rollno"));
                            userGlobal.setPassword(jsonObject.getString("password"));
                            userGlobal.setCourse(jsonObject.getString("course"));
                            userGlobal.setYear(Integer.parseInt(jsonObject.getString("year")));
                                if (userGlobal.getPassword().equals(pass.getText().toString())) {
                                    Toast.makeText(Loginactivity.this, "Login SuccessFull", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Loginactivity.this, NewDash.class);
                                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                                    myEdit.putString("email", userGlobal.getEmail());
                                    myEdit.putString("name", userGlobal.getName());
                                    myEdit.putString("roll", userGlobal.getRollNo());
                                    myEdit.putString("college", userGlobal.getCollegeName());
                                    myEdit.commit();
                                    startActivity(intent);
                                }

                        } catch (JSONException e) {
                            Toast.makeText(Loginactivity.this, "Please Register To Login", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Loginactivity.this, "Volley Error Occured" + error, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(getRequest);
        return userT;
    }
}