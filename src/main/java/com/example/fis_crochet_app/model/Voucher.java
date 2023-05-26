package com.example.fis_crochet_app.model;

import org.dizitart.no2.objects.Id;

public class Voucher {
    @Id
    private String cod;
    private int valoare;

    public Voucher(String cod, int valoare)
    {
        this.cod = cod;
        this.valoare = valoare;
    }
    public Voucher() {
    }


    public int getValoare() {
        return valoare;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setValoare(int valoare) {
        this.valoare = valoare;
    }
}
