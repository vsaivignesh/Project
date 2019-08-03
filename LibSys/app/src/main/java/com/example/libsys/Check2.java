package com.example.libsys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Check2 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Ret> aData= new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avail_r_view);
        recyclerView=findViewById(R.id.RecyclerViewLend);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        int StdID= getIntent().getIntExtra("StdID", 0);
        getdata(StdID);

    }



    private void getdata(final int stdID) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://myname3.co.nf")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetInt iFace=retrofit.create(RetInt.class);


        Call<List<Ret>> call=iFace.getLent();
        call.enqueue(new Callback<List<Ret>>() {
            @Override
            public void onResponse(Call<List<Ret>> call, Response<List<Ret>> response) {
                if(response.body()!=null){
                    Toast.makeText(Check2.this, "Getting Books", Toast.LENGTH_SHORT).show();
                    ArrayList<Ret> abData = new ArrayList<>(response.body());
                    for(int i=0;i<abData.size();i++){
                        if (Integer.valueOf(abData.get(i).getStdID())==stdID){
                            aData.add(abData.get(i));
                        }
                    }
                    lAdapter adapter=new lAdapter(Check2.this, aData);
                    recyclerView.setAdapter(adapter);
                }
                else{
                    Toast.makeText(Check2.this,"No Records Available",Toast.LENGTH_LONG).show();}

            }

            @Override
            public void onFailure(Call<List<Ret>> call, Throwable t) {
                Toast.makeText(Check2.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });}}
