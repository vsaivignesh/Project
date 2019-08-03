package com.example.libsys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class red extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.red);
        Toast.makeText(this, "Connect to a network and click Go Home", Toast.LENGTH_LONG).show();
        Button red=findViewById(R.id.gBack);
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gBack=new Intent(getApplicationContext(),MainActivity.class);
                gBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(gBack);
            }
        });
        }}