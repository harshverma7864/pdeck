package com.example.pdeck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pdeck.adapter.ImageAdapter;
import com.example.pdeck.adapter.RoundAdapter;
import com.example.pdeck.constants.GetUrls;
import com.example.pdeck.models.Rounds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class CardsInfo extends AppCompatActivity {
    Rounds roundsDataClass;
    RoundAdapter rAdapter;
    ImageAdapter imageAdapter;
    RecyclerView recyclerView, imageRecycler;
    public static ArrayList<Rounds> roundInfoList = new ArrayList<>();
    public static ArrayList<String> images = new ArrayList<>();
    TextView idText,companyNameText ,driveTypeText , roleOfferedText , ctcText , locationText , companyTypeText , colNameText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);



        recyclerView = findViewById(R.id.rounds);
        imageRecycler = findViewById(R.id.imageRecycler);

        driveTypeText = findViewById(R.id.driveType);

        companyNameText = findViewById(R.id.companyName);
        companyTypeText = findViewById(R.id.companyType);
        roleOfferedText = findViewById(R.id.role);
        ctcText = findViewById(R.id.ctc);
        locationText = findViewById(R.id.location);
        colNameText = findViewById(R.id.colName);




        Intent intent = getIntent();
        int companyId = Integer.parseInt(intent.getStringExtra("cardId"));
        companyNameText.setText(intent.getStringExtra("companyName"));
        companyTypeText.setText(intent.getStringExtra("companytype"));
        roleOfferedText.setText(intent.getStringExtra("roleOffered"));
        ctcText.setText(intent.getStringExtra("ctc"));
        locationText.setText(intent.getStringExtra("location"));
        colNameText.setText(intent.getStringExtra("collegeName"));



        getRoundsInfo(companyId);
        getAllImages(companyId);



        rAdapter = new RoundAdapter(this, roundInfoList);
        recyclerView.setAdapter(rAdapter);
        LinearLayoutManager h = new LinearLayoutManager(CardsInfo.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(h);



        imageAdapter = new ImageAdapter(this, images);
        imageRecycler.setAdapter(imageAdapter);
        LinearLayoutManager h2 = new LinearLayoutManager(CardsInfo.this, LinearLayoutManager.HORIZONTAL, false);
        imageRecycler.setLayoutManager(h2);





    }


    public void getRoundsInfo(int companyid) {

        RequestQueue queue = Volley.newRequestQueue(this);
        roundInfoList.clear();
        final String url = GetUrls.ROUNDSINFOURL + companyid;

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            for(int i=0;i<jsonArray.length();i++) {
                                JSONObject jsonObject =  jsonArray.getJSONObject(i);
                                String roundId = jsonObject.getString("roundid");
                                String roundName = jsonObject.getString("roundName");
                                String roundType = jsonObject.getString("roundType");
                                String noOfQuestions = jsonObject.getString("noOfQuestions");
                                String duration = jsonObject.getString("duration");
                                String companyId = jsonObject.getString("companyId");
                                roundsDataClass = new Rounds(Integer.parseInt(roundId),Integer.parseInt(companyId), roundName, roundType, Integer.parseInt(noOfQuestions), Integer.parseInt(duration));
                                roundInfoList.add(roundsDataClass);
                                rAdapter.notifyDataSetChanged();
                            }

                        } catch (JSONException e) {
                            Toast.makeText(CardsInfo.this, "Error Occured" + e, Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CardsInfo.this, "Volley Error Occured" + error, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(getRequest);

    }

    public void getAllImages(int companyid) {

        RequestQueue queue = Volley.newRequestQueue(this);
        images.clear();
        final String url = GetUrls.CARDSINFOURL +companyid;

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            for(int i=0;i<jsonArray.length();i++) {
                                JSONObject jsonObject =  jsonArray.getJSONObject(i);
                                String imageUrl = jsonObject.getString("url");
                                images.add(imageUrl);
                                imageAdapter.notifyDataSetChanged();
                            }

                        } catch (JSONException e) {
                            Toast.makeText(CardsInfo.this, "Error Occured" + e, Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CardsInfo.this, "Volley Error Occured" + error, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(getRequest);

    }


}