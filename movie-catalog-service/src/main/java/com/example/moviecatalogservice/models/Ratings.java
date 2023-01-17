package com.example.moviecatalogservice.models;

public class Ratings {
    private String movieId;
    private int rating;

    public Ratings(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }
public Ratings(){}
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
