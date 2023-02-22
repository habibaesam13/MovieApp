package com.example.movieapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity{
    RecyclerView rv;
    ArrayList<Item> movies ;
    Intent toMovieScrn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
       movies= new ArrayList<>();
        movies.add(new Item("Jhon Wick", R.drawable.jhon_wick));
        movies.add(new Item("The Project Adam", R.drawable.the_project_adam));
        movies.add(new Item("Avatar", R.drawable.avatar));
        movies.add(new Item("TopGun", R.drawable.topgun));
        movies.add(new Item("Samaritan", R.drawable.samaritan));
        movies.add(new Item("Nope", R.drawable.nope_adv1sht_1080x1920pxh_rgb_1));
        rv = findViewById(R.id.recyclerview);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(movies, new RecycleViewOnItemClick() {
            @Override
            public void onItemClick(int position) {
                toMovieScrn.putExtra("movieName",movies.get(position).getName());
                toMovieScrn.putExtra("movieImage",movies.get(position).getImage());
                startActivity(toMovieScrn);
            }
        });
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
        toMovieScrn=new Intent(HomePage.this,film_page.class);

    }


}