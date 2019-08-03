package com.example.libsys;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static java.lang.Boolean.TRUE;

public class rAdapter extends RecyclerView.Adapter<rAdapter.ViewHolder> {
    private ArrayList<Ret> aList;
    private Context mcontext;


    public rAdapter(Context context, ArrayList<Ret> cList){
        this.aList=cList;
        this.mcontext=context;
        setHasStableIds(TRUE);


    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);
        return new rAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {
        viewHolder.id.setText("ID: \n" + aList.get(i).getID());
        viewHolder.name.setText("Book Name: \n" + aList.get(i).getBName());
        viewHolder.aName.setText("Author Name:\n " + aList.get(i).getAName());
        viewHolder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("ID",Integer.valueOf(aList.get(i).getID()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                sendPost(jsonObject);

            }
        });

    }

    private void sendPost(final JSONObject jsonObject) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://myname3.co.nf/return.php");
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
                    Log.i("MSG" , conn.getResponseMessage());

                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        Intent back=new Intent(mcontext.getApplicationContext(), MainActivity.class);
        mcontext.startActivity(back);
    }


    @Override
    public int getItemCount() {
        return aList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView id,name,aName;
        CardView cardview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.ID);
            name=itemView.findViewById((R.id.Book));
            aName=itemView.findViewById(R.id.Author);
            cardview=itemView.findViewById(R.id.Cardview);
        }
    }
}
