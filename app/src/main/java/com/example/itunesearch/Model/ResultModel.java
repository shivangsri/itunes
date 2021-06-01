package com.example.itunesearch.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultModel {

    @SerializedName("artistId")
    @Expose
    private Integer artistId;

    @SerializedName("trackId")
    @Expose
    private Integer trackId;

    @SerializedName("artistName")
    @Expose
    private String artistName;

    @SerializedName("trackName")
    @Expose
    private String trackName;

    @SerializedName("trackTimeMillis")
    @Expose
    private Integer trackTimeMillis;

    @SerializedName("primaryGenreName")
    @Expose
    private String primaryGenreName;

    //Image URL
    @SerializedName("artworkUrl100")
    @Expose
    private String artworkUrl100;

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Integer getTrackTimeMillis() {
        //Converting millisecond to minutes and ignoring null values
        if (trackTimeMillis == null) {
            trackTimeMillis = 0;
        }
        return Math.round(trackTimeMillis / 100000);
    }

    public void setTrackTimeMillis(int trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }


    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }


}
