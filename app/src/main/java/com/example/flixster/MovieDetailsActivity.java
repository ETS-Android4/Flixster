package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.flixster.models.Movie;

import org.parceler.Parcels;

public class MovieDetailsActivity extends AppCompatActivity {

    // The movie we are displaying
    Movie movie;

    // The view objects
    TextView tvDetailTitle;
    RatingBar rbVoteAverage;
    TextView tvDetailOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        // Resolve the view objects
        tvDetailTitle = (TextView) findViewById(R.id.tvDetailTitle);
        rbVoteAverage = (RatingBar) findViewById(R.id.rbVoteAverage);
        tvDetailOverview = (TextView) findViewById(R.id.tvDetailOverview);

        // Unwrap the parceled movie intent using the SimpleName as key
        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));

        // Set the title and overview
        tvDetailTitle.setText(movie.getTitle());
        tvDetailOverview.setText(movie.getOverview());
        rbVoteAverage.setRating(movie.getVoteAverage().floatValue() / 2.0f);
    }
}