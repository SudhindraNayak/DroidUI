package com.example.asus.srtapui;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

public class GeoFence extends AppCompatActivity {

    Toolbar toolbar;
    Button btnStartMonitor,btnStartGeo,btnStopGeo;
    GoogleApiClient googleApiClient=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_fence);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        googleApiClient=new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(@Nullable Bundle bundle) {
                        Toast.makeText(getApplicationContext(), "Connected to api", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onConnectionSuspended(int i) {
                        Toast.makeText(getApplicationContext(), "Suspended Connection", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Toast.makeText(getApplicationContext(), "Connection failed", Toast.LENGTH_SHORT).show();
                    }
                })
                .build();

        btnStartMonitor=(Button)findViewById(R.id.start_monitor);
        btnStartMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnStartGeo=(Button)findViewById(R.id.start_geo);
        btnStartGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnStopGeo=(Button)findViewById(R.id.stop_geo);
        btnStopGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},1234);
    }

    @Override
    protected void onResume(){
        super.onResume();
        int response= GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        if(response!=ConnectionResult.SUCCESS){
            Toast.makeText(getApplicationContext(), "api services not available", Toast.LENGTH_SHORT).show();
            GoogleApiAvailability.getInstance().getErrorDialog(this,response,1).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Available api", Toast.LENGTH_SHORT).show();

        }
    }
}
