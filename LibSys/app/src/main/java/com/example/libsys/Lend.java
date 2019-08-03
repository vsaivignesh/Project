package com.example.libsys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Lend extends AppCompatActivity {
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
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("ID",Integer.valueOf(getIntent().getIntExtra("ID",0)));
                    jsonObject.put("StdID",Integer.valueOf(String.valueOf(stdID.getText())));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                sendPost(jsonObject);
            }
        });}
    private void sendPost(final JSONObject jsonObject) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://myname3.co.nf/lend.php");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept","application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);



                    Log.i("JSON", jsonObject.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    os.writeBytes(jsonObject.toString());

                    os.flush();
                    os.close();

                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    if(conn.getResponseMessage()=="ok"){
                        Toast.makeText(Lend.this, "Book Sent", Toast.LENGTH_SHORT).show();
                    }

                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("Success",true);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }}