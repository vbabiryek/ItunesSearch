package com.example.itunessearch.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.itunessearch.R;
import com.example.itunessearch.models.Artist;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ViewHolder> {
    private final List<Artist> artistArrayList;

    public ArtistAdapter(Context context, List<Artist> artistArrayList) {
        this.artistArrayList = artistArrayList;
    }

    @NonNull
    @Override
    public ArtistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_artist_itemview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistAdapter.ViewHolder holder, int position) {
        Artist artist = artistArrayList.get(position);
        String artistNameText = "Artist Name: " + artist.getArtistName();
        holder.artistName.setText(artistNameText);
        String trackNameText = "Track Name: " + artist.getTrackName();
        holder.trackName.setText(trackNameText);
        String releaseDateText = "Release Date: " + artist.getReleaseDate();
        holder.releaseDate.setText(releaseDateText);
        String primaryGenreNameText = "Primary Genre Name: " + artist.getPrimaryGenreName();
        holder.primaryGenreName.setText(primaryGenreNameText);
        String trackPriceText = "Track Price: " + artist.getTrackPrice();
        holder.trackPrice.setText(trackPriceText);
    }

    @Override
    public int getItemCount() {
        return artistArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView artistName;
        private final TextView trackName;
        private final TextView releaseDate;
        private final TextView primaryGenreName;
        private final TextView trackPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            CardView cardView = itemView.findViewById(R.id.card_view);
            artistName = itemView.findViewById(R.id.artist_name_txt);
            trackName = itemView.findViewById(R.id.track_name_txt);
            releaseDate = itemView.findViewById(R.id.release_date_txt);
            primaryGenreName = itemView.findViewById(R.id.primary_genre_name_txt);
            trackPrice = itemView.findViewById(R.id.track_price_txt);
        }
    }
}
