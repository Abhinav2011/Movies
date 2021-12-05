package com.abhinav.movies;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends  RecyclerView.Adapter<Adapter.MyViewHolder>{
    private List<MovieModel> movieList;

    Adapter(List<MovieModel> movieList){
        this.movieList = movieList;
    }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.MyViewHolder holder, final int position) {

        final MovieModel movie = movieList.get(position);

        holder.title.setText(movie.getTitle());
        holder.image.setBackgroundResource(movie.getImage());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView image;
        private CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.carView);
        }
    }
}
