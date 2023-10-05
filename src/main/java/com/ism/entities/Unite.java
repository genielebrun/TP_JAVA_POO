package com.ism.entities;

public class Unite extends AbstractEntity {

    //Constructeur
    public Unite() {
        super();
    }

    public Unite(int id, String libelle) {
        super(id, libelle);
    }

    public Unite(String libelle) {
        super(libelle);
    }

    @Override
    public String toString() {
        return "Unite" + super.toString();
    }

}
