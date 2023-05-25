package com.example.fis_crochet_app.exceptions;


public class StitchAlreadyExists extends Exception {
    public StitchAlreadyExists(String abbr) {
        super(String.format("The abbreviation '%s' is already taken", abbr));
    }
}
