package com.example.rvnl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class home extends AppCompatActivity {

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    androidx.appcompat.widget.Toolbar toolbar;
    View header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav=(NavigationView)findViewById(R.id.nav_view);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                int id = item.getItemId();

                if(id == R.id.profile)
                {
                    Intent intent = new Intent(home.this, home.class);
                    startActivity(intent);
                    finish();

                    Toast.makeText(home.this, "This is your Profile ", Toast.LENGTH_SHORT).show();

                }
                else if(id==R.id.daily)
                {
                    Intent cartIntent = new Intent(home.this, home.class);
                    startActivity(cartIntent);

                    Toast.makeText(home.this, "Update your work", Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.logout)
                {
                    Intent aboutIntent = new Intent(home.this, home.class);
                    startActivity(aboutIntent);
                    Toast.makeText(home.this, "log out.", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });
    }
}