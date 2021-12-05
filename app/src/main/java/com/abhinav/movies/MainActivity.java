package com.abhinav.movies;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.abhinav.movies.Adapter;
import com.abhinav.movies.MovieModel;
import com.abhinav.movies.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter recyclerViewAdapter;
    private List<MovieModel> movieList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        movieList = new ArrayList<>();
        addMovie();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerViewAdapter = new Adapter(movieList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                MovieModel deletedMovie = movieList.get(viewHolder.getAdapterPosition());
                int position = viewHolder.getAdapterPosition();
                movieList.remove(viewHolder.getAdapterPosition());

                recyclerViewAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

                Snackbar.make(recyclerView, deletedMovie.getTitle(), Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        movieList.add(position, deletedMovie);
                        recyclerViewAdapter.notifyItemInserted(position);
                    }
                }).show();
            }
        }).attachToRecyclerView(recyclerView);
    }


    private void addMovie() {
        MovieModel movie = new MovieModel("Coco", R.drawable.coco);
        movieList.add(movie);
        movie = new MovieModel("Knives Out", R.drawable.knives_out);
        movieList.add(movie);
        movie = new MovieModel("The Sixth Sense", R.drawable.the_sixth_sense_poster);
        movieList.add(movie);
        movie = new MovieModel("Titanic", R.drawable.titanic);
        movieList.add(movie);
        movie = new MovieModel("The Boss Baby", R.drawable.the_boss_baby);
        movieList.add(movie);
        movie = new MovieModel("Captain Marvel", R.drawable.captain_marvel);
        movieList.add(movie);
        movie = new MovieModel("The Avengers", R.drawable.the_avengers);
        movieList.add(movie);
        movie = new MovieModel("Harry Potter and the Chambers of Secrets", R.drawable.harry_potter);
        movieList.add(movie);
        movie = new MovieModel("The Woman in Black", R.drawable.woman_in_black_ver4);
        movieList.add(movie);
        movie = new MovieModel("Home Alone", R.drawable.home_alone);
        movieList.add(movie);
        movie = new MovieModel("Insidious", R.drawable.insidious);
        movieList.add(movie);
        movie = new MovieModel("The Conjuring", R.drawable.the_conjuring);
        movieList.add(movie);
        movie = new MovieModel("The Fault in our stars", R.drawable.the_fault_in_our_stars);
        movieList.add(movie);
        movie = new MovieModel("SkyFall", R.drawable.skyfall);
        movieList.add(movie);
        movie = new MovieModel("Inception", R.drawable.inception);
        movieList.add(movie);
        movie = new MovieModel("The Shutter Island", R.drawable.the_shutter_island);
        movieList.add(movie);
        //recyclerViewAdapter.notifyDataSetChanged();
    }
}