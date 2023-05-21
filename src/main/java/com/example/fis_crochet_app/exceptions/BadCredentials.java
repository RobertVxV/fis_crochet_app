package com.example.fis_crochet_app.exceptions;

public class BadCredentials extends Exception {
    public BadCredentials() {
        super(String.format("Parola sau utilizatorul sunt gresite!"));
    }
}
