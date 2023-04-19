package com.example.pdeck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.pdeck.fragments.ChatFragment;
import com.example.pdeck.fragments.HomeFragment;
import com.example.pdeck.fragments.PremiumFragment;
import com.example.pdeck.fragments.ProfileFragment;
import com.example.pdeck.fragments.SearchFragment;

public class NewDash extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dash);

        bottomNavigation=findViewById(R.id.bottomnav);

        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.notification));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.college));
        bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.chat));
        bottomNavigation.add(new MeowBottomNavigation.Model(5,R.drawable.user));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment;

                if (item.getId() ==5){
                    fragment = new ProfileFragment();
                }
                else if (item.getId() ==4){
                    fragment = new ChatFragment();
                }else  if (item.getId() ==3){
                    fragment = new PremiumFragment();
                }
                else  if (item.getId() ==2){
                    fragment = new SearchFragment();
                }
                else {
                    fragment = new HomeFragment();
                }

                //use load fragment method to show the current fragment
                loadFragment(fragment);
            }
        });

        bottomNavigation.show(1, true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //display a toast
                Toast.makeText(getApplicationContext()," You clicked "+ item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                //display a toast
                Toast.makeText(getApplicationContext()," You reselected "+ item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        // bottomNavigation.setCount(3, "10");
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment_container,fragment, null)
                .commit();
    }
}