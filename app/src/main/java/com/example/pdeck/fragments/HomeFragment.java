package com.example.pdeck.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pdeck.CardsRecyclerView;
import com.example.pdeck.MainActivity;
import com.example.pdeck.Profile;
import com.example.pdeck.R;
import com.google.android.material.navigation.NavigationView;

import java.time.LocalDate;

public class HomeFragment extends Fragment  {
    CardView lastYear, lastLastYear, lastLastLastYear, product, service, fintech, edtech;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_home_fragment, null);

        Context context = getActivity().getApplicationContext();


        lastYear = root.findViewById(R.id.cardLastYear);
        lastLastYear = root.findViewById(R.id.cardLastLastYear);
        lastLastLastYear = root.findViewById(R.id.lastLastLastYear);
        product = root.findViewById(R.id.product);
        service = root.findViewById(R.id.service);
        fintech = root.findViewById(R.id.fintech);
        edtech = root.findViewById(R.id.edtech);



//        lastYear.setOnClickListener(this);

        lastYear.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "kdshjkahdasjkd", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity().getApplication(), CardsRecyclerView.class);
                int year = LocalDate.now().getYear() - 1;
                intent.putExtra("card", "1");
                intent.putExtra("year", String.valueOf(year));
                startActivity(intent);
            }
        });

        lastLastYear.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), CardsRecyclerView.class);
                intent.putExtra("card", "1");
                int year = LocalDate.now().getYear() - 2;
                intent.putExtra("year", String.valueOf(year));
                startActivity(intent);
            }
        });

        lastLastLastYear.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), CardsRecyclerView.class);
                intent.putExtra("card", "1");
                int year = LocalDate.now().getYear() - 3;
                intent.putExtra("year", String.valueOf(year));
                startActivity(intent);
            }
        });

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), CardsRecyclerView.class);
                intent.putExtra("card", "2");
                intent.putExtra("companyType", "product");
                startActivity(intent);
            }
        });


        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), CardsRecyclerView.class);
                intent.putExtra("card", "2");
                intent.putExtra("companyType", "service");
                startActivity(intent);
            }
        });


        fintech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), CardsRecyclerView.class);
                intent.putExtra("card", "2");
                intent.putExtra("companyType", "fintech");
                startActivity(intent);
            }
        });


        edtech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), Profile.class);
                intent.putExtra("card", "2");
                intent.putExtra("companyType", "edtech");
                startActivity(intent);
            }
        });


        return root;


    }



}