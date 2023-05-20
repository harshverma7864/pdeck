package com.example.AiHub.apis;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.AiHub.Login;
import com.example.AiHub.NewDash;

import java.util.HashMap;
import java.util.Map;

public class API {

    private static String DOMAIN_NAME = "https://way2job.shodns.in/AIHUB/";
    public static String API_URL = "https://api.openai.com/v1/completions";
    public static String API = "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";

    private static String LOGINAPI = DOMAIN_NAME+"validateLogin.php";
    private static String REGISTERAPI = DOMAIN_NAME+"registerUser.php";
    private static String RSTAPI = DOMAIN_NAME+"resetPass.php";


    public static void validateLogin(String username , String password, Context context) {

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(context);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, "https://way2job.shodns.in/AIHUB/validateLogin.php", new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.split(",")[0].equals("success")) {
                    Toast.makeText(context, "Welcome", Toast.LENGTH_SHORT).show();
                    SharedPreferences sh = context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = sh.edit();
                    myEdit.putString("username",response.split(",")[1] );
                    myEdit.putString("email",username);
                    myEdit.commit();
                    Intent intent = new Intent(context, NewDash.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                } else {
                    Toast.makeText(context, "InValid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(context, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("username", username);
                params.put("password", password);

                return params;
            }
        };
        queue.add(request);
    }



    public static void registerUser(String username , String email, String password, Context context) {

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(context);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, REGISTERAPI, new com.android.volley.Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (response.equals("success")) {
                    Toast.makeText(context, "Welcome", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, Login.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                } else {
                    Toast.makeText(context, "InValid Credentials", Toast.LENGTH_SHORT).show();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(context, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("username", username);
                params.put("password", password);
                params.put("email", email);

                return params;
            }
        };
        queue.add(request);
    }


    public static void resetPassword(String email, String password,Context context) {

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(context);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, RSTAPI, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Password Changed Successfully")){
                    Intent intent = new Intent(context, Login.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }else{
                    Toast.makeText(context, "Email Id does not exist", Toast.LENGTH_SHORT).show();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(context, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("email", email);
                params.put("password", password);

                return params;
            }
        };
        queue.add(request);
    }


}

