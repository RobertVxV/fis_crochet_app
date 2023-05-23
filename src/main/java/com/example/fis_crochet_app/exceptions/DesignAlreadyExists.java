package com.example.fis_crochet_app.exceptions;


public class DesignAlreadyExists extends Exception {
    public DesignAlreadyExists(String name) {
        super(String.format("This design name '%s' is already taken", name));
    }
}
