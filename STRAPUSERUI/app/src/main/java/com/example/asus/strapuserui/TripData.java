package com.example.asus.strapuserui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TripData extends AppCompatActivity {

    Toolbar toolbar;
    TextView txtview;
    RelativeLayout relativeLayout;
    AppCompatButton btn_start,btn_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_data);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        txtview=(TextView)findViewById(R.id.txt_trip_code);
        relativeLayout=(RelativeLayout)findViewById(R.id.rl_td_page);
        btn_start=(AppCompatButton)findViewById(R.id.btn_start_trip);
        btn_cancel=(AppCompatButton)findViewById(R.id.btn_cancel_trip);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TripTracking.class);
                startActivity(intent);
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TripData.super.onBackPressed();
            }
        });

        txtview.setText(getIntent().getStringExtra("Trip_code"));

        setSupportActionBar(toolbar);
        relativeLayout.setOnClickListener(null);
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
            Toast.makeText(getApplicationContext(), "logout", Toast.LENGTH_LONG).show();
        }
        else if(id==R.id.notify)
        {
            Toast.makeText(getApplicationContext(), "Notify", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
