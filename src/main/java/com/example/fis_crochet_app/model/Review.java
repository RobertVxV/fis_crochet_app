package com.example.fis_crochet_app.model;

public class Review {
    private String user;
    private String design;
    private String review;
    public Review(String user, String design, String review){
        this.user = user;
        this.design = design;
        this.review = review;
    }

    public Review()
    {

    }

    public String getReview() {
        return review;
    }

    public String getDesign() {
        return design;
    }

    public String getUser() {
        return user;
    }
}
