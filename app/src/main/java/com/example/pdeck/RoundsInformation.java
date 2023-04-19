package com.example.pdeck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pdeck.adapter.RoundInfoAdapter;
import com.example.pdeck.constants.GetUrls;
import com.example.pdeck.models.RoundInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RoundsInformation extends AppCompatActivity {

    RecyclerView recyclerView;
    RoundInfo roundInfo;
    RoundInfoAdapter roundInfoAdapter;
    private static ArrayList<RoundInfo> roundInfos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rounds_information);


        recyclerView = findViewById(R.id.questionAnswer);


        Intent intent = getIntent();
        String roundId = intent.getStringExtra("roundId");
        getRoundDetails(roundId);

        roundInfoAdapter = new RoundInfoAdapter(RoundsInformation.this, roundInfos);
        recyclerView.setAdapter(roundInfoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(RoundsInformation.this));

    }


    public void getRoundDetails(String roundId) {

        RequestQueue queue = Volley.newRequestQueue(this);
        roundInfos.clear();
        final String url = GetUrls.ROUNDURL + roundId;

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            for(int i=0;i<jsonArray.length();i++) {
                                JSONObject jsonObject =  jsonArray.getJSONObject(i);
                                String sno = jsonObject.getString("sno");
                                String roundid = jsonObject.getString("roundid");
                                String question = jsonObject.getString("question");
                                String answer = jsonObject.getString("answer");
                                String difficulty = jsonObject.getString("difficulty");
                                String postedby = jsonObject.getString("postedby");
                                String postedon = jsonObject.getString("postedon");
                                roundInfo = new RoundInfo(Integer.parseInt(sno), Integer.parseInt(roundid), question, answer, difficulty, postedby, postedon);
                                roundInfos.add(roundInfo);
                                roundInfoAdapter.notifyDataSetChanged();
                            }

                        } catch (JSONException e) {
                            Toast.makeText(RoundsInformation.this, "Error Occured" + e, Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RoundsInformation.this, "Volley Error Occured" + error, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(getRequest);

    }



}