package com.example.pantrypal;

public class model {
    String naziv;
    int slika;

    public model(String naziv, int slika) {
        this.naziv = naziv;
        this.slika = slika;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getSlika() {
        return slika;
    }
}
