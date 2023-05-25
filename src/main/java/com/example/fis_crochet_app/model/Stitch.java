package com.example.fis_crochet_app.model;

import java.util.Objects;

public class Stitch {
    private String Abbr;
    private String Name;
    private String Description;
    public Stitch(String Abbr, String Name, String Description)
    {
        this.Abbr = Abbr;
        this.Name = Name;
        this.Description = Description;

    }
    public Stitch(){}

    public String getAbbr() {
        return Abbr;
    }

    public void setAbbr(String abbr) {
        Abbr = abbr;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString()
    {
        String s = this.Abbr.toString() + " " + this.Name.toString() + " " +this.Description.toString() + "\n";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stitch s = (Stitch) o;

        return Abbr != null ? Abbr.equals(s.Abbr) : s.Abbr == null;
    }

    public int hashCode() {
        return Objects.hash(Abbr);
    }
}

