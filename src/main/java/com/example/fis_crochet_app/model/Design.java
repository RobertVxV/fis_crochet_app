package com.example.fis_crochet_app.model;

import com.example.fis_crochet_app.services.UserService;
import org.dizitart.no2.objects.Id;

import java.util.*;

public class Design {
    private int NoOfRows;
    @Id
    private String Name;

    private String ownerUsername;

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public int getNoOfRows() {
        return NoOfRows;
    }

    public void setNoOfRows(int noOfRows) {
        NoOfRows = noOfRows;
    }

    //private User Owner;
    private double Price;
    private boolean Free;
    private String Description;
    private String Difficulty;
    private boolean Public;
    private int Likes;
    private ArrayList<Stitch> stitches;

    public ArrayList<Stitch> getStitches() {
        return stitches;
    }

    public Design() {
    }

    public Design(String Name, String Difficulty, double Price, String Description, boolean Public, boolean Free) {
        this.Name = Name;
        this.ownerUsername = UserService.get_logged_in().getUsername();
        this.Difficulty = Difficulty;
        if (Free) {
            this.Price = 0;
        } else {
            this.Price = Price;
        }
        this.Free = Free;
        this.Description = Description;
        this.Public = Public;
        this.Likes = 0;
        this.NoOfRows = 0;
        this.stitches = new ArrayList<>();
        this.items = new ArrayList<>();

    }

    public void setStitches(ArrayList<Stitch> stitches) {
        this.stitches = stitches;
    }

    public void addStitch(Stitch s) {
        this.stitches.add(s);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public boolean isFree() {
        return Free;
    }

    public void setFree(boolean free) {
        Free = free;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(String difficulty) {
        Difficulty = difficulty;
    }

    public boolean isPublic() {
        return Public;
    }

    public void setPublic(boolean aPublic) {
        Public = aPublic;
    }

    public int getLikes() {
        return this.Likes;
    }

    public void addLike() {
        this.Likes = this.Likes + 1;
    }

    public void removeLike() {
        this.Likes = this.Likes - 1;
    }

    public ArrayList<Object> getItems() {
        return items;
    }

    public void setItems(ArrayList<Object> items) {
        this.items = items;
    }

    public void addItem(Object o) {
        this.items.add(o);
    }


    private ArrayList<Object> items = new ArrayList<Object>();

    public String listStitches() {
        String s = "";
        for (Stitch st : this.stitches)
            s = s + st.toString() + "\n";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Design design = (Design) o;

        if (Name != null ? !Name.equals(design.Name) : design.Name != null) return false;

        return design != null ? Name.equals(design.Name) : design.Name == null;
    }

    public int getRowNumber() {
        NoOfRows++;
        return NoOfRows;
    }

    public int hashCode() {
        return Objects.hash(Name);
    }
}