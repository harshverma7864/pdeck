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
import com.example.pdeck.adapter.CardAdapter;
import com.example.pdeck.constants.GetUrls;
import com.example.pdeck.models.Information;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CardsRecyclerView extends AppCompatActivity {

    CardAdapter cardAdapter;
    Information information;
    RecyclerView recyclerView;

    private static ArrayList<Information> informationList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards_recycler_view);
        recyclerView = findViewById(R.id.reccycler);

        Intent intent = getIntent();
        if (intent.getStringExtra("card").equals("1")){
            getCompanyInfo("1", intent.getStringExtra("year"));
        }
        else{
            getCompanyInfo("2", intent.getStringExtra("companyType"));

        }

        cardAdapter = new CardAdapter(this, informationList);
        recyclerView.setAdapter(cardAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void getCompanyInfo(String basis , String type) {
        RequestQueue queue = Volley.newRequestQueue(this);

        final String url = GetUrls.ALLCOMPANIESURL +basis+"&type="+type;
        informationList.clear();
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            for(int i=0;i<jsonArray.length();i++) {
                                JSONObject jsonObject =  jsonArray.getJSONObject(i);
                                String id = jsonObject.getString("id");
                                String collegeName = jsonObject.getString("collegeName");
                                String companyName = jsonObject.getString("companyName");
                                String companytype = jsonObject.getString("companytype");
                                String ctc = jsonObject.getString("ctc");
                                String roleOffered = jsonObject.getString("roleOffered");
                                String yearOfVisit = jsonObject.getString("yearOfVisit");
                                String logo = jsonObject.getString("logo");
                                String noOfRounds = jsonObject.getString("noOfRounds");
                                String techStack = jsonObject.getString("techStack");
                                String location = jsonObject.getString("location");
                                String drivetype = jsonObject.getString("drivetype");
                                information = new Information(roleOffered, Integer.parseInt(id), collegeName, companyName, companytype ,Double.parseDouble(ctc) , Integer.parseInt(yearOfVisit), logo, Integer.parseInt(noOfRounds), techStack,
                                        location, drivetype);
                                informationList.add(information);
                                cardAdapter.notifyDataSetChanged();
                            }

                        } catch (JSONException e) {
                            Toast.makeText(CardsRecyclerView.this, "Error Occured" + e, Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CardsRecyclerView.this, "Volley Error Occured" + error, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(getRequest);

    }


}