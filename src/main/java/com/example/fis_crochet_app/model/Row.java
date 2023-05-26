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

    public Row() {
    }

    ;

    public Row(String Text) {
        this.StitchesUsed = Text;
        this.TotalStitches = 0;
    }

    @Override
    public String toString() {
        String s = new String();
        s = "R" + No + ": " + StitchesUsed + " Total: " + TotalStitches;
        return s;
    }

    public int calculateTotalStitches(ArrayList<Stitch> StitchList) {
        String[] words = this.getStitchesUsed().split(" ");
        boolean OpenParanthesis = false;
        boolean ClosedParanthesis = false;
        int counter = 0;
        int total = 0;
        for (int i = 0; i < words.length; i++)
        {
            for (Stitch s : StitchList) {
                if (s.getAbbr().equals(words[i]))
                {
                    if (OpenParanthesis)
                        counter++;
                    else
                        total++;
                }
            }

            if (words[i].chars().allMatch(Character::isDigit))
            {
                if (ClosedParanthesis)
                {
                    OpenParanthesis = false;
                    ClosedParanthesis = false;
                    total += counter * Integer.parseInt(words[i]);
                    counter = 0;
                }
                else if (OpenParanthesis)
                {
                    counter += Integer.parseInt(words[i]) - 1;
                }
                else
                    total += Integer.parseInt(words[i]) -1;
            }

            if (words[i].equals("("))
                OpenParanthesis = true;

            if (words[i].equals(")"))
                ClosedParanthesis = true;


        }
        return total;
    }
}

