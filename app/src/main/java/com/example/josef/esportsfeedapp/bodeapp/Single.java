package com.example.josef.esportsfeedapp.bodeapp;

import java.util.ArrayList;

public class Single {

    public Single(){

    }

    private ArrayList<double[]> valores = new ArrayList<>();
    private ArrayList<double[]> valoresFase = new ArrayList<>();

    static final Single single = new Single();

    public static Single getSingle() {
        return single;
    }



    public ArrayList<double[]> getValores() {
        return valores;
    }

    public void setValores(ArrayList<double[]> valores) {
        this.valores = valores;
    }

    public ArrayList<double[]> getValoresFase() {
        return valoresFase;
    }

    public void setValoresFase(ArrayList<double[]> valoresFase) {
        this.valoresFase = valoresFase;
    }
}
