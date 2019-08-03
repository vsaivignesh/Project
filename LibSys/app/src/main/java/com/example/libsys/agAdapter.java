package com.example.libsys;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.Boolean.TRUE;

public class agAdapter extends RecyclerView.Adapter<agAdapter.ViewHolder> {
    private ArrayList<Avail> aList;
    private Context mcontext;


    public agAdapter(Context context, ArrayList<Avail> cList){
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
        return new agAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {
        viewHolder.id.setText("ID: \n" + aList.get(i).getID());
        viewHolder.name.setText("Book Name: \n" + aList.get(i).getBName());
        viewHolder.aName.setText("Author Name:\n " + aList.get(i).getAName());

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
