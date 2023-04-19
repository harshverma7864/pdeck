package com.example.pdeck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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

public class Forgot extends AppCompatActivity {
    EditText roll , otp;
    Button sendOtp, verifyButton;
    LinearLayout otpLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        roll = findViewById(R.id.fUserName);
        otp = findViewById(R.id.otp);
        otpLinearLayout = findViewById(R.id.otpLinearLayout);
        sendOtp = findViewById(R.id.sendOtp);
        verifyButton = findViewById(R.id.verifyOtp);

        sendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!roll.getText().toString().equals("")){
                    Toast.makeText(Forgot.this, "OTP Sent to Registered Mail", Toast.LENGTH_SHORT).show();
                    otpLinearLayout.setVisibility(View.VISIBLE);
                    verifyButton.setVisibility(View.VISIBLE);

                }else {
                    Toast.makeText(Forgot.this, "Please Enter Roll Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public User sendOtp(String rollno) {
        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = GetUrls.OTPURL + rollno;
        User userT = new User();
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            JSONObject jsonObject =  jsonArray.getJSONObject(0);


                        } catch (JSONException e) {
                            Toast.makeText(Forgot.this, "Please Register To Login", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Forgot.this, "Volley Error Occured" + error, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(getRequest);
        return userT;
    }
}