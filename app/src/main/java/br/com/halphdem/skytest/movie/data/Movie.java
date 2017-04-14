package br.com.halphdem.skytest.movie.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fernando on 12/04/17.
 */

public class Movie {

    private String id;

    private String title;

    private String overview;

    private String duration;

    @SerializedName("release_year")
    private String releaseYear;

    @SerializedName("cover_url")
    private String coverUri;

    @SerializedName("backdrops_url")
    private List<String> backdropsUris;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<String> getBackdropsUris() {
        return backdropsUris;
    }

    public void setBackdropsUris(List<String> backdropsUris) {
        this.backdropsUris = backdropsUris;
    }

    public String getCoverUri() {
        return coverUri;
    }

    public void setCoverUri(String coverUri) {
        this.coverUri = coverUri;
    }
}
