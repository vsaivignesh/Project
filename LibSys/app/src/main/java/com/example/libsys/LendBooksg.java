package com.example.libsys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LendBooksg extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Avail> aData= new ArrayList<>();
    EditText editTextSearch;
    ArrayList<String> useList;
    aAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avail_r_view);
        recyclerView=findViewById(R.id.RecyclerViewLend);
        editTextSearch=findViewById(R.id.Search);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getdata();
        addTextListener();

    }

    private void addTextListener() {
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                s=s.toString().toLowerCase();
                final ArrayList filteredList=new ArrayList<>();
                if(useList!=null){
                    for(int i=0;i<useList.size(); i++){
                        final String text=useList.get(i).toLowerCase();
                        if(text.contains(s)){
                            filteredList.add(aData.get(i));
                        }
                    }
                    recyclerView.setLayoutManager(new LinearLayoutManager(LendBooksg.this));
                    adapter=new aAdapter(LendBooksg.this,filteredList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }}

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    private void getdata() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://myname3.co.nf")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        availInt iFace=retrofit.create(availInt.class);


        Call<List<Avail>> call=iFace.getBooks();
        call.enqueue(new Callback<List<Avail>>() {
            @Override
            public void onResponse(Call<List<Avail>> call, Response<List<Avail>> response) {
                if(response.body()!=null){
                    Toast.makeText(LendBooksg.this, "Getting Books", Toast.LENGTH_SHORT).show();
                    aData= new ArrayList<>(response.body());
                    useList=new ArrayList<>();
                    for(int i=0;i<response.body().size();i++){
                        useList.add(response.body().get(i).getBName());}
                    agAdapter aadapter=new agAdapter(LendBooksg.this, aData);
                    recyclerView.setAdapter(aadapter);
                }
                else{
                    Toast.makeText(LendBooksg.this,"No Books Available",Toast.LENGTH_LONG).show();}

            }

            @Override
            public void onFailure(Call<List<Avail>> call, Throwable t) {
                Toast.makeText(LendBooksg.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });}}
