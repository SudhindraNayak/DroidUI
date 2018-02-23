package com.example.asus.srtapui;

import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView=(NavigationView)findViewById(R.id.design_navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);//addDrawerListener
        toggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.popup_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.settings)
        {
            Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_LONG).show();
        }
        else if(id==R.id.logout)
        {
            Toast.makeText(getApplicationContext(), "Finish", Toast.LENGTH_LONG).show();
        }
        else if(id==R.id.search)
        {
            Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_LONG).show();
        }
        else if(id==R.id.profile)
        {
            Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.notify_id:Toast.makeText(getApplicationContext(),"Notify",Toast.LENGTH_LONG).show();
                break;
            case R.id.add_trip_id:Toast.makeText(getApplicationContext(),"Add Trips",Toast.LENGTH_LONG).show();
                break;
            case R.id.add_route_id:Toast.makeText(getApplicationContext(),"Add Trips",Toast.LENGTH_LONG).show();
                break;
            case R.id.view_trip_id:Toast.makeText(getApplicationContext(),"View Trips",Toast.LENGTH_LONG).show();
                break;
            case R.id.re_trip_id:Toast.makeText(getApplicationContext(),"Reassign Trips",Toast.LENGTH_LONG).show();
                break;
            case R.id.logout_id:Toast.makeText(getApplicationContext(),"Logout",Toast.LENGTH_LONG).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }
}
