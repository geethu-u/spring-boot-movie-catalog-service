package com.geethu.moviecatalogservice.model;

import java.util.List;

public class UserRating {
    public UserRating() {
    }

    private List<MovieRating> userRatings;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;

    public UserRating(List<MovieRating> userRatings) {
        this.userRatings = userRatings;
    }

    public List<MovieRating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<MovieRating> userRatings) {
        this.userRatings = userRatings;
    }


}
