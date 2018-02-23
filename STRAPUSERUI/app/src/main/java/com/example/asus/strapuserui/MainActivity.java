package com.example.asus.strapuserui;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    AppCompatEditText et_trip_code;
    TextInputLayout til_trip_code;
    RelativeLayout relativeLayout;
    AppCompatButton btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        et_trip_code=(AppCompatEditText)findViewById(R.id.et_trip_code);
        til_trip_code=(TextInputLayout)findViewById(R.id.til_trip_code);
        relativeLayout=(RelativeLayout)findViewById(R.id.rl_tc_page);
        btn_submit=(AppCompatButton)findViewById(R.id.btn_submit_code);

        setSupportActionBar(toolbar);
        relativeLayout.setOnClickListener(null);

        et_trip_code.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                check_empty();
            }
        });

        et_trip_code.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Not required for the current situation
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               check_empty();
            }

            @Override
            public void afterTextChanged(Editable s) {
                //Not required for the current situation
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Redirecting to Trip details",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),TripData.class);
                intent.putExtra("Trip_code",et_trip_code.getText().toString());
                startActivity(intent);
            }
        });

        til_trip_code.setCounterEnabled(true);
        til_trip_code.setCounterMaxLength(16);

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

    void check_empty()
    {
        //Checks for empty trip code
        if(et_trip_code.getText().toString().isEmpty()){
            til_trip_code.setErrorEnabled(true);
            til_trip_code.setError("Please Enter Trip Code");
        }
        else
        {
            til_trip_code.setErrorEnabled(false);
        }
    }
}
