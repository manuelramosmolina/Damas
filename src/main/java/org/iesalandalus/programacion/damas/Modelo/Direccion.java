package org.iesalandalus.programacion.damas.Modelo;

public enum Direccion {

    NORESTE("Noreste"), SURESTE("Sureste"), SUROESTE("Suroeste"), NOROESTE("Noroeste");

    private String cadenaAMostrar;
    Direccion(String cadenaAMostrar){

        this.cadenaAMostrar=cadenaAMostrar;
    }

    @Override
    public String toString() {
        return ordinal() + ".-" + cadenaAMostrar;
    }

}
