package com.example.pantrypal;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.MyViewHolder> {
    Context context;
    ArrayList<model> model;
    MediaPlayer likeSound, disSound, favSound;

    public recycleAdapter(Context context, ArrayList<model> models){
        this.context = context;
        this.model = models;

        likeSound = MediaPlayer.create(context, R.raw.likesound);
        disSound = MediaPlayer.create(context, R.raw.dissound);
        favSound = MediaPlayer.create(context, R.raw.favsound);
    }

    @NonNull
    @Override
    public recycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler, parent, false);
        return new recycleAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recycleAdapter.MyViewHolder holder, int position) {
        holder.tv.setText(model.get(position).getNaziv());
        holder.iv.setImageResource(model.get(position).getSlika());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, JuhaRecept.class);
                intent.putExtra("recipe_name", context.getResources().getStringArray(R.array.juhe)[position]);
                intent.putExtra("recipe_image", model.get(position).getSlika());
                context.startActivity(intent);
            }
        });

        holder.ivLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likeSound.start();
            }
        });

        holder.ivDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disSound.start();
            }
        });

        holder.ivFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favSound.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv, ivLike, ivDis, ivFav;
        TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.ivJelo);
            ivLike = itemView.findViewById(R.id.ivLike);
            ivDis = itemView.findViewById(R.id.ivDis);
            ivFav = itemView.findViewById(R.id.ivFav);
            tv = itemView.findViewById(R.id.tvNaziv);
        }
    }
}
