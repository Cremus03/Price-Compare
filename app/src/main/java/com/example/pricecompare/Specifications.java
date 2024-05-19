package com.example.pricecompare;

public class Specifications {

    String produs, marca, model, culoare;
    int  memorieRom, memorieRam;
    double pret;

    public Specifications(String produs, String marca, String model, String culoare, int memorieRom, int memorieRam, double pret) {
        this.produs=produs;
        this.marca = marca;
        this.model = model;
        this.culoare = culoare;
        this.memorieRom = memorieRom;
        this.memorieRam = memorieRam;
        this.pret = pret;
    }

    public String getProdus() {
        return produs;
    }

    public void setProdus(String produs) {
        this.produs = produs;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getCuloare() {
        return culoare;
    }
    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }
    public int getMemorieRom() {
        return memorieRom;
    }
    public void setMemorieRom(int memorieRom) {
        this.memorieRom = memorieRom;
    }
    public int getMemorieRam() {
        return memorieRam;
    }
    public void setMemorieRam(int memorieRam) {
        this.memorieRam = memorieRam;
    }
    public double getPret() {
        return pret;
    }
    public void setPret(float pret) {
        this.pret = pret;
    }
    @Override
    public String toString() {
        return produs + '\n' + marca + " " +  model + " " + culoare + '\n'
                + memorieRom+ "GB memorie" + '\n'
                + memorieRam + "GB RAM" + '\n'
                + pret + " lei.";
    }
}
