package com.geethu.moviecatalogservice.model;

public class CatalogItem {
    private String catalogId;
    private String catalogName;
    private String catalogDesc;
    private int rating;

    public CatalogItem() {
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public CatalogItem(String catalogId, String catalogName, String catalogDesc, int rating) {
        this.catalogId = catalogId;
        this.catalogName =  catalogName;
        this.catalogDesc =  catalogDesc;
        this.rating = rating;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogDesc() {
        return catalogName;
    }

    public void setCatalogDesc(String catalogDesc) {
        this.catalogDesc = catalogDesc;
    }



}
