package com.example.libsys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Check extends AppCompatActivity {
    EditText stdID;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lend);
        send=findViewById(R.id.Confirm);
        stdID=findViewById(R.id.stdID);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.valueOf(String.valueOf(stdID.getText()))>0 && Integer.valueOf(String.valueOf(stdID.getText()))<Math.pow(10,8)){
                Intent check=new Intent(getApplicationContext(),Check2.class);
                check.putExtra("StdID",Integer.valueOf(String.valueOf(stdID.getText())));
                startActivity(check);}
                else{
                    Toast.makeText(Check.this, "Enter Valid 8 digit Student ID", Toast.LENGTH_SHORT).show();
                }

            }
                    });}}