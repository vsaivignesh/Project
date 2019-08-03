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

public class RetBooks extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Ret> aData= new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.avail_r_view);

        recyclerView=findViewById(R.id.RecyclerViewLend);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getdata();


    }




    private void getdata() {
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
                    Toast.makeText(RetBooks.this, "Getting Books", Toast.LENGTH_SHORT).show();
                    aData= new ArrayList<>(response.body());
                    rAdapter adapter=new rAdapter(RetBooks.this, aData);
                    recyclerView.setAdapter(adapter);



                    }
                else{
                    Toast.makeText(RetBooks.this,"No Books Available",Toast.LENGTH_LONG).show();}
            }

            @Override
            public void onFailure(Call<List<Ret>> call, Throwable t) {

            }
        });}}