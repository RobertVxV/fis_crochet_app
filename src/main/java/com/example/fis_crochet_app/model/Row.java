package com.example.fis_crochet_app.model;
import java.util.*;
public class Row {
    int No;
    private String StitchesUsed;
    private int TotalStitches;

    public int getTotalStitches() {
        return TotalStitches;
    }

    public void setTotalStitches(int totalStitches) {
        TotalStitches = totalStitches;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getStitchesUsed() {
        return StitchesUsed;
    }

    public void setStitchesUsed(String stitchesUsed) {
        StitchesUsed = stitchesUsed;
    }
    public String toString()
    {
        String s = "R" + No + ": " + StitchesUsed + " Total: "  + TotalStitches;
        return s;
    }
}
