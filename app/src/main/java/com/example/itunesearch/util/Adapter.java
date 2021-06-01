package com.example.itunesearch.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itunesearch.Model.ResultModel;
import com.example.itunesearch.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    List<ResultModel> result;

    public Adapter(Context context, List<ResultModel> result) {
        this.context = context;
        this.result = result;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        final ResultModel a = result.get(position);
        holder.track.setText(String.valueOf(a.getTrackName()));
        holder.trackid.setText(String.valueOf(a.getTrackId()));

        holder.artist.setText(String.valueOf(a.getArtistName()));
        holder.artistid.setText(String.valueOf(a.getArtistId()));
        holder.genre.setText(String.valueOf(a.getPrimaryGenreName()));
        holder.time.setText(String.valueOf(a.getTrackTimeMillis()) + ":00");

        //Fetching image from JSON
        String imageUrl = a.getArtworkUrl100();
        Picasso.with(context).load(imageUrl).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView artist, artistid, track, trackid, genre, time;
        ImageView imageView;
        CardView cardView, cardView1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            artist = itemView.findViewById(R.id.artist);
            artistid = itemView.findViewById(R.id.artistid);
            track = itemView.findViewById(R.id.trackname);
            trackid = itemView.findViewById(R.id.trackid);
            genre = itemView.findViewById(R.id.genre);
            time = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.imageview);

        }
    }
}
