package org.iesalandalus.programacion.damas.modelo;

import java.util.Objects;

public class Posicion {

    private int fila;
    private char columna;

    public Posicion(int fila, char columna){

        setFila(fila);
        setColumna(columna);
    }

    public Posicion(Posicion posicion){
        if (posicion==null)
            throw new NullPointerException("ERROR: No es posible copiar una posición nula.");

        setFila(posicion.getFila());
        setColumna(posicion.getColumna());

    }

    public int getFila() {
        return fila;
    }

    private void setFila(int fila) {
        if (fila<1 || fila>8)
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    private void setColumna(char columna) {
        if(columna<'a' || columna>'h')
            throw new IllegalArgumentException("ERROR: Columna no válida.");
        this.columna = columna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return fila == posicion.fila && columna == posicion.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    @Override
    public String
    toString() {
        return "fila=" + fila + ", columna=" + columna;
    }
}
