package com.example.libsys;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Guest extends AppCompatActivity {

    Button lend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.guest);
        if(isNetworkConnected()==false){
            Intent redirect=new Intent(getApplicationContext(),red2.class);
            startActivity(redirect);
        }
        lend=findViewById(R.id.lend);
        lend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lend=new Intent(getApplicationContext(), LendBooksg.class);
                startActivity(lend);

            }
        });
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }}