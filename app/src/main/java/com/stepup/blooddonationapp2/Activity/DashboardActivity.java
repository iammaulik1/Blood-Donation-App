package com.stepup.blooddonationapp2.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.stepup.blooddonationapp2.Adapter.Dashboard_Adapter;
import com.stepup.blooddonationapp2.R;
import com.stepup.blooddonationapp2.Util.Method;
import com.stepup.blooddonationapp2.Util.RecyclerTouchListener;
import com.stepup.blooddonationapp2.databinding.ActivityDashboardBinding;
import com.stepup.blooddonationapp2.fragment.About_us;
import com.stepup.blooddonationapp2.fragment.Blood_Request;
import com.stepup.blooddonationapp2.fragment.Blood_compatibility;
import com.stepup.blooddonationapp2.fragment.FAQ;
import com.stepup.blooddonationapp2.fragment.Home;
import com.stepup.blooddonationapp2.fragment.Logout;
import com.stepup.blooddonationapp2.fragment.Privacy_policy;
import com.stepup.blooddonationapp2.fragment.Profile;
import com.stepup.blooddonationapp2.fragment.Setting;

public class DashboardActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityDashboardBinding binding;

    private RecyclerView recyclerView;
    DrawerLayout drawer;
    public static Dashboard_Adapter mainAdapter;

    private String[] name = {"Home", "Profile", "Blood Request", "Blood Compatibility",
            "Setting", "FAQ", "Privacy Policy", "About Us", "Log Out"};

    private Integer[] image =
            {
                    R.drawable.ic_black_home, R.drawable.ic_black_person, R.drawable.ic_black_send, R.drawable.ic_black_policy, R.drawable.ic_black_setting, R.drawable.ic_black_faq,
                    R.drawable.ic_black_policy, R.drawable.ic_black_group, R.drawable.ic_black_logout
            };

    int flag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        drawer = findViewById(R.id.drawer_layout);
        settoolbar();




        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, binding.toolbarMain, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Home homeFragment;
        if (savedInstanceState != null) {
            homeFragment = (Home) getSupportFragmentManager().findFragmentByTag("Home");
        } else {
            homeFragment = new Home();
            getSupportFragmentManager().beginTransaction().replace(R.id.framlayout_main, homeFragment, "Home").commit();
            binding.toolbarMain.setTitle("Home");
            Method.onBackPress = true;
        }

        recyclerView = findViewById(R.id.recyclerView_main);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(DashboardActivity.this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setFocusable(false);
        mainAdapter = new Dashboard_Adapter(DashboardActivity.this, name, image);
        recyclerView.setAdapter(mainAdapter);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(DashboardActivity.this, recyclerView, new Dashboard_Adapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                navigation(position);
                //about to implement afterwards....
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void navigation(int position) {

        switch (position) {

            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout_main, new Home(), "Home").commit();
                binding.toolbarMain.setTitle("Home");
                Method.onBackPress = true;
                drawer.closeDrawers();
                flag = 0;
                break;

            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout_main, new Profile(), "Profile").commit();
                binding.toolbarMain.setTitle("Profile");
                Method.onBackPress = true;
                drawer.closeDrawers();
                flag = 0;
                break;

            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout_main, new Blood_Request(), "Blood Request").commit();
                binding.toolbarMain.setTitle("Blood Request");
                Method.onBackPress = true;
                flag = 0;
                drawer.closeDrawers();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout_main, new Blood_compatibility(), "Blood Compatibility").commit();
                binding.toolbarMain.setTitle("Blood Compatibility");
                Method.onBackPress = true;
                flag = 0;
                drawer.closeDrawers();
                break;

            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout_main, new Setting(), "Setting").commit();
                binding.toolbarMain.setTitle("Setting");
                Method.onBackPress = true;
                flag = 0;
                drawer.closeDrawers();
                break;

            case 5:
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout_main, new FAQ(), "FAQ").commit();
                binding.toolbarMain.setTitle("FAQ");
                Method.onBackPress = true;
                flag = 0;
                drawer.closeDrawers();
                break;

            case 6:
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout_main, new Privacy_policy(), "Logout").commit();
                binding.toolbarMain.setTitle("Privacy Policy");
                Method.onBackPress = true;
                flag = 0;
                drawer.closeDrawers();
                break;
            case 7:
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout_main, new About_us(), "About Us").commit();
                binding.toolbarMain.setTitle("About Us");
                Method.onBackPress = true;
                flag = 0;
                drawer.closeDrawers();
                break;
            case 8:
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout_main, new Logout(), "Logout").commit();
                binding.toolbarMain.setTitle("Logout");
                Method.onBackPress = true;
                flag = 0;
                drawer.closeDrawers();
                break;

            default:
                break;
        }


    }

    private void settoolbar() {

        binding.toolbarMain.setNavigationIcon(R.drawable.ic_black_menu);
        setSupportActionBar(binding.toolbarMain);
        //
        binding.toolbarMain.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}