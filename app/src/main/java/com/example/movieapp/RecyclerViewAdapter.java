package com.example.movieapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MovieView> {
    ArrayList<Item> movies;
    private RecycleViewOnItemClick rei;

    public RecyclerViewAdapter(ArrayList<Item> movies,RecycleViewOnItemClick rei) {
        this.rei = rei;
        this.movies = movies;
    }




    @NonNull
    @Override
    public MovieView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.moviecustomitem, null, false);
        return new MovieView(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieView holder, int position) {
        Item i = movies.get(position);
        holder.i.setImageResource(i.getImage());
        holder.t.setText(i.getName());
        holder.itemView.setOnClickListener(view -> rei.onItemClick(position));

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    //holder class for recyclerview
    class MovieView extends RecyclerView.ViewHolder {
        TextView t;
        ImageView i;

        public MovieView(@NonNull View itemView) {
            super(itemView);
            t = itemView.findViewById(R.id.movieText);
            i = itemView.findViewById(R.id.movieImage);
        }
    }


}
