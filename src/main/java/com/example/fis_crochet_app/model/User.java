package com.example.fis_crochet_app.model;


import org.dizitart.no2.objects.Id;

import java.util.ArrayList;

public class
User {

    private String email;
    private String password;
    @Id
    private String username;

    private ArrayList<String> designuri_cumparate = new ArrayList<String>();
    private ArrayList<Design> likedDesigns = new ArrayList<Design>();

    public ArrayList<String> getDesignuri_cumparate() {
        return designuri_cumparate;
    }

    public void addDesign(String d) {
        designuri_cumparate.add(d);
    }

    public ArrayList<Design> getLikedDesigns() {
        return likedDesigns;
    }

    public void addLikedDesign(Design d) {
        likedDesigns.add(d);
        d.addLike();
    }

    public void removeLikedDesign(Design d) {
        likedDesigns.remove(d);
        d.removeLike();
    }

    public User(String username, String email, String password) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return username != null ? username.equals(user.username) : user.username == null;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
