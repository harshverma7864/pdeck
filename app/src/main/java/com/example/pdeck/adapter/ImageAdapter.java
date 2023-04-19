package com.example.pdeck.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pdeck.R;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    Context context;
    List<String> imageList;

    public ImageAdapter(Context context, ArrayList<String> images) {
        this.context = context;
        this.imageList = images;
    }

    @NonNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.imagecard, parent, false);
        return new ImageAdapter.ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(imageList.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        View parentView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.parentView = itemView;
            this.imageView = itemView.findViewById(R.id.image);
        }
    }
}
