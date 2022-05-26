package com.example.itunessearch.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artist {
    @SerializedName("artistName")
    @Expose
    private String artistName;
    @SerializedName("trackName")
    @Expose
    private String trackName;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("primaryGenreName")
    @Expose
    private String primaryGenreName;
    @SerializedName("trackPrice")
    @Expose
    private String trackPrice;

    public Artist(String artistName, String trackName, String releaseDate, String primaryGenreName, String trackPrice) {
        this.artistName = artistName;
        this.trackName = trackName;
        this.releaseDate = releaseDate;
        this.primaryGenreName = primaryGenreName;
        this.trackPrice = trackPrice;
    }


    public String getArtistName() {
        if(artistName.isEmpty()){
            setArtistName("null");
        }
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackName() {
        if(trackName.isEmpty()){
            setTrackName("null");
        }
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getReleaseDate() {
        if(releaseDate.isEmpty()){
            setReleaseDate("null");
        }
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPrimaryGenreName() {
        if(primaryGenreName.isEmpty()){
            setPrimaryGenreName("null");
        }
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public String getTrackPrice() {
        if(trackPrice.isEmpty()){
            setTrackPrice("null");
        }
        return trackPrice;
    }

    public void setTrackPrice(String trackPrice) {
        this.trackPrice = trackPrice;
    }
}
