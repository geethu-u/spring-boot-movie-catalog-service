package com.geethu.moviecatalogservice.model;

public class Movie {
    private String movieId;

    public Movie(String movieId, String movieName, String movieDesc) {
        this.movieId = movieId;
        this.movieName =  movieName;
        this.movieDesc =  movieDesc;
    }

    public Movie() {
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDesc() {
        return movieName;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    private String movieName;
    private String movieDesc;

}
