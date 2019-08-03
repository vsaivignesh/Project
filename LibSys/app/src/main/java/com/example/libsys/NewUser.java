package com.example.libsys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class NewUser extends Activity {
    EditText bName,aName,id;
    Button sub;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.add_user);
        id=findViewById(R.id.ID);
        bName = findViewById(R.id.Book_Name);
        aName = findViewById(R.id.Auth_Name);
        sub=findViewById(R.id.Sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("ID", Integer.valueOf(String.valueOf(id.getText())));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    jsonObject.put("BookName",bName.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    jsonObject.put("autName",aName.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("JSONobject", String.valueOf(jsonObject));
                sendPost(jsonObject);

            }
        });

    }

    public void sendPost(final JSONObject jsonParam) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://myname3.co.nf/insertuser.php");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept","application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);



                    Log.i("JSON", jsonParam.toString());
                    DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                    os.writeBytes(jsonParam.toString());

                    os.flush();
                    os.close();

                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    if(conn.getResponseMessage()=="ok"){
                        Toast.makeText(NewUser.this, "Book Sent", Toast.LENGTH_SHORT).show();
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