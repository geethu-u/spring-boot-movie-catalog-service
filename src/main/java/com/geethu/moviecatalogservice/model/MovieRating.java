package com.geethu.moviecatalogservice.model;

public class MovieRating {
    private String movieId;
    private int ratingStars;
    private String ratingDesc;

    public MovieRating() {
    }

    public MovieRating(String movieId, int ratingStars, String ratingDesc) {
        this.movieId = movieId;
        this.ratingStars =  ratingStars;
        this.ratingDesc =  ratingDesc;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRatingStars() {
        return ratingStars;
    }

    public void setRatingStars(int ratingStars) {
        this.ratingStars = ratingStars;
    }

    public String getRatingDesc() {
        return ratingDesc;
    }

    public void setRatingDesc(String ratingDesc) {
        this.ratingDesc = ratingDesc;
    }



}
