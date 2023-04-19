package com.example.pdeck;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.pdeck.fragments.HomeFragment;
import com.example.pdeck.fragments.ProfileFragment;
import com.example.pdeck.fragments.SettingsFragment;
import com.google.android.material.navigation.NavigationView;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar  ;
NavigationView navigationView;
DrawerLayout drawerLayout;
CardView lastYear, lastLastYear, lastLastLastYear, product, service, fintech, edtech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("WAY 2 JOB");
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.OpenDrawer, R.string.CloseDrawer);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        lastYear = findViewById(R.id.cardLastYear);
        lastLastYear = findViewById(R.id.cardLastLastYear);
        lastLastLastYear = findViewById(R.id.lastLastLastYear);
        product = findViewById(R.id.product);
        service = findViewById(R.id.service);
        fintech = findViewById(R.id.fintech);
        edtech = findViewById(R.id.edtech);


        lastYear.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CardsRecyclerView.class);
                intent.putExtra("card", "1");
                int year = LocalDate.now().getYear() - 1;
                intent.putExtra("year", String.valueOf(year));
                startActivity(intent);
            }
        });


        lastLastYear.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CardsRecyclerView.class);
                int year = LocalDate.now().getYear() - 2;
                intent.putExtra("card", "1");
                intent.putExtra("year", String.valueOf(year));
                startActivity(intent);
            }
        });


        lastLastLastYear.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CardsRecyclerView.class);
                intent.putExtra("card", "1");
                int year = LocalDate.now().getYear() - 3;
                intent.putExtra("year", String.valueOf(year));
                startActivity(intent);
            }
        });

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CardsRecyclerView.class);
                intent.putExtra("card", "2");
                intent.putExtra("companyType", "product");
                startActivity(intent);
            }
        });


        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CardsRecyclerView.class);
                intent.putExtra("card", "2");
                intent.putExtra("companyType", "service");
                startActivity(intent);
            }
        });


        fintech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CardsRecyclerView.class);
                intent.putExtra("card", "2");
                intent.putExtra("companyType", "fintech");
                startActivity(intent);
            }
        });


        edtech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                intent.putExtra("card", "2");
                intent.putExtra("companyType", "edtech");
                startActivity(intent);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id==R.id.home){
                    loadFragment(new HomeFragment());
                }
                else if(id==R.id.profile){
                    Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                    loadFragment(new ProfileFragment());
                }
                else if(id==R.id.settings){
                    loadFragment(new SettingsFragment());
                }
                else if(id==R.id.logout){
                    Toast.makeText(MainActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }

        });


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container, fragment);
        ft.commit();
    }

}