package com.example.ratingdataservice.models;

import java.util.List;

public class UserRating {

    private List<Ratings> userRating;

    public UserRating(List<Ratings> userRating) {
        this.userRating = userRating;
    }

    public UserRating() {

    }


    public List<Ratings> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Ratings> userRating) {
        this.userRating = userRating;
    }
}
