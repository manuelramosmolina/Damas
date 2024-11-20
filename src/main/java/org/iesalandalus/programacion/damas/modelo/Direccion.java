package org.iesalandalus.programacion.damas.modelo;

public enum Direccion {

    NORESTE("Noreste"), SURESTE("Sureste"), SUROESTE("Suroeste"), NOROESTE("Noroeste");

    private String cadenaAMostrar;
    Direccion(String cadenaAMostrar){

        this.cadenaAMostrar=cadenaAMostrar;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
