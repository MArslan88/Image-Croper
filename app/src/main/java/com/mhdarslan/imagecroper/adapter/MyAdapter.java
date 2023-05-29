package com.mhdarslan.imagecroper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mhdarslan.imagecroper.R;
import com.mhdarslan.imagecroper.model.DataClass;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<DataClass> dataClassArrayList;
    Context context;

    public MyAdapter(ArrayList<DataClass> dataClassArrayList, Context context) {
        this.dataClassArrayList = dataClassArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        DataClass model = dataClassArrayList.get(position);

        holder.recyclerCaption.setText(model.getCaption());
        Glide.with(context).load(model.getImageURL()).into(holder.recyclerImage);
    }

    @Override
    public int getItemCount() {
        return dataClassArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView recyclerImage;
        TextView recyclerCaption;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerCaption = itemView.findViewById(R.id.recyclerCaption);
            recyclerImage = itemView.findViewById(R.id.recyclerImage);
        }
    }
}
