package com.example.moviecatalogservice.models;

import java.util.List;

public class UserRating {

    private List<Ratings> userRating;
    private String userId;
    
    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserRating(List<Ratings> userRating, String userId) {
		super();
		this.userRating = userRating;
		this.userId = userId;
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
