package com.example.libsys;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button add,lend,ret,checkProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if(getIntent().getBooleanExtra("Success",false)==true){
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        if(isNetworkConnected()==false){
            Intent redirect=new Intent(getApplicationContext(),red.class);
            startActivity(redirect);
        }
        add=findViewById(R.id.Submit);
        lend=findViewById(R.id.lend);
        ret=findViewById(R.id.receive);
        checkProf=findViewById(R.id.cProf);
        checkProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cProf=new Intent(getApplicationContext(),Check.class);
                startActivity(cProf);
            }
        });
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ret=new Intent(getApplicationContext(),RetBooks.class);
                startActivity(ret);
            }
        });
        lend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lend=new Intent(getApplicationContext(), LendBooks.class);
                startActivity(lend);

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent uIntent=new Intent(getApplicationContext(), NewUser.class);
                startActivity(uIntent);
            }
        });
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
    }