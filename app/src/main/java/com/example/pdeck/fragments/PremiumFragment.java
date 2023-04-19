package com.example.pdeck.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pdeck.CardsRecyclerView;
import com.example.pdeck.R;
import com.example.pdeck.adapter.CardAdapter;
import com.example.pdeck.adapter.CollegeAdapter;
import com.example.pdeck.constants.GetUrls;
import com.example.pdeck.models.CollegeInfo;
import com.example.pdeck.models.Information;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PremiumFragment extends Fragment {

    RecyclerView collegeCardsRecyclerView;
    private static ArrayList<CollegeInfo> collegeList = new ArrayList<>();
    CollegeAdapter collegeAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_premium, null);

        Context context = getActivity().getApplicationContext();
        ArrayList<CollegeInfo> collegeList = new ArrayList<>();

//        collegeCardsRecyclerView = root.findViewById(R.id.collegeCardsRecyclerView);
//        collegeAdapter = new CollegeAdapter(context, collegeList);
//        collegeCardsRecyclerView.setAdapter(collegeAdapter);
//        collegeCardsRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));
//        collegeCardsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        getCollegeInfo(context);
        collegeCardsRecyclerView = root.findViewById(R.id.collegeCardsRecyclerView);
        collegeCardsRecyclerView.setHasFixedSize(true);
        collegeCardsRecyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        collegeCardsRecyclerView.setAdapter(new CollegeAdapter(context, collegeList));





        // Inflate the layout for this fragment
        return root;
    }



    public void getCollegeInfo(Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);

        final String url = GetUrls.ALLCOLLEGESURL;
        collegeList.clear();
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            for(int i=0;i<jsonArray.length();i++) {
                                JSONObject jsonObject =  jsonArray.getJSONObject(i);
                                String sno = jsonObject.getString("sno");
                                String name = jsonObject.getString("name");
                                String location = jsonObject.getString("location");
                                String imgurl = jsonObject.getString("imgurl");

                                CollegeInfo college = new CollegeInfo(Integer.parseInt(sno), name , location);
                                college.setImgUrl(imgurl);
                                collegeList.add(college);
                                Toast.makeText(context, "" + college.toString(), Toast.LENGTH_SHORT).show();
                            }
                            collegeAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            Toast.makeText(context, "Error Occured" + e, Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Volley Error Occured" + error, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(getRequest);

    }



}