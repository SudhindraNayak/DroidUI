package com.example.asus.strapuserui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class TripTrack extends AppCompatActivity {

    Toolbar toolbar;
    AppCompatButton btn_pause,btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_track);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        btn_pause=(AppCompatButton)findViewById(R.id.btn_pause_trip);
        btn_stop=(AppCompatButton)findViewById(R.id.btn_stop_trip);

        btn_stop.setText(R.string.stop_trip);
        btn_pause.setText(R.string.pause_trip);

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),TripClose.class);
                startActivity(intent);
            }
        });

        setSupportActionBar(toolbar);
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
