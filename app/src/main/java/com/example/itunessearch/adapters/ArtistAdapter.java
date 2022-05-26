package com.example.itunessearch.adapters;

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

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder> {
    private List<Artist> artistArrayList;

    public ArtistAdapter(List<Artist> artistArrayList) {
        this.artistArrayList = artistArrayList;
    }

//    public void setArtistArrayList(List<Artist> artistArrayList){
//        this.artistArrayList.clear();
//        this.artistArrayList.addAll(artistArrayList);
//        notifyDataSetChanged();
//    }

    @NonNull
    @Override
    public ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_artist_itemview, parent, false);
        return new ArtistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistViewHolder holder, int position) {
        Artist artist = artistArrayList.get(position);
        holder.onBind(artist);
    }

    @Override
    public int getItemCount() {
        return artistArrayList.size();
    }

    public static class ArtistViewHolder extends RecyclerView.ViewHolder {

        public CardView cardView;
        private final TextView artistName;
        private final TextView trackName;
        private final TextView releaseDate;
        private final TextView primaryGenreName;
        private final TextView trackPrice;



        public ArtistViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            artistName = itemView.findViewById(R.id.artist_name_txt);
            trackName = itemView.findViewById(R.id.track_name_txt);
            releaseDate = itemView.findViewById(R.id.release_date_txt);
            primaryGenreName = itemView.findViewById(R.id.primary_genre_name_txt);
            trackPrice = itemView.findViewById(R.id.track_price_txt);
        }


        public void onBind(Artist artist){
            String artistNameText = "Artist Name: " + artist.getArtistName();
            artistName.setText(artistNameText);
            String trackNameText = "Track Name: " + artist.getTrackName();
            trackName.setText(trackNameText);
            String releaseDateText = "Release Date: " + artist.getReleaseDate();
            releaseDate.setText(releaseDateText);
            String primaryGenreNameText = "Primary Genre Name: " + artist.getPrimaryGenreName();
            primaryGenreName.setText(primaryGenreNameText);
            String trackPriceText = "Track Price: " + artist.getTrackPrice();
            trackPrice.setText(trackPriceText);
        }
    }
}
