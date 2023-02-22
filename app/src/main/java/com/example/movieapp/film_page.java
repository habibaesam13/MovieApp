package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class film_page extends AppCompatActivity {
    ImageView filmImage;
    TextView filmName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_page);
        filmImage = findViewById(R.id.fimage);
        filmName = findViewById(R.id.fname);
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("movieName");
        int img = extras.getInt("movieImage");
        filmName.setText(value);
        filmImage.setImageResource(img);

    }
}