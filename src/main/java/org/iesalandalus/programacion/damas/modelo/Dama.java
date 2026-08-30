package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;

public class Dama {

    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    public Dama() {

        this.color = Color.BLANCO;
        this.posicion = crearPosicionInicial(color);
        this.esDamaEspecial = false;

    }


    public Dama(Color color) {
        setColor(color);
        this.posicion = crearPosicionInicial(getColor());
        this.esDamaEspecial = false;
    }

    public Color getColor() {
        return color;
    }

    private void setColor(Color color) {
        if (color == null) {
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
        }
        this.color = color;
    }

    public Posicion getPosicion() {
        return new Posicion(posicion);
    }

    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new NullPointerException("ERROR: La posición no puede ser nula.");
        }
        this.posicion = new Posicion(posicion);
    }

    public boolean isEsDamaEspecial() {
        return esDamaEspecial;
    }


    private Posicion crearPosicionInicial(Color color) {
        int fila;
        if (color == Color.BLANCO) {
            fila = (int) (Math.random() * 3) + 1;
        } else {
            fila = (int) (Math.random() * 3) + 6;
        }

        int offset = (int) (Math.random() * 4) * 2;
        char columna;
        if (fila % 2 != 0) {
            columna = (char) ('a' + offset);
        } else {
            columna = (char) ('b' + offset);
        }

        return new Posicion(fila, columna);
    }


    public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
        if (direccion == null) {
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        }
        if (pasos < 1) {
            throw new IllegalArgumentException("ERROR: El número de pasos no puede ser menor a 1.");
        }
        if (getColor() == null) {
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
        }

        if (!esDamaEspecial) {
            if (color.equals(Color.BLANCO) && (direccion != Direccion.NORESTE && direccion != Direccion.NOROESTE)) {
                throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
            }
            if (color.equals(Color.NEGRO) && (direccion != Direccion.SURESTE && direccion != Direccion.SUROESTE)) {
                throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
            }
            if (pasos > 1) {
                throw new OperationNotSupportedException("ERROR: Las damas normales solo se pueden mover 1 casilla.");
            }
        }

        int nuevaFila = this.posicion.getFila();
        char nuevaColumna = this.posicion.getColumna();

        switch (direccion) {
            case NORESTE:
                nuevaFila += pasos;
                nuevaColumna += (char) pasos;
                break;
            case NOROESTE:
                nuevaFila += pasos;
                nuevaColumna -= (char) pasos;
                break;
            case SURESTE:
                nuevaFila -= pasos;
                nuevaColumna += (char) pasos;
                break;
            case SUROESTE:
                nuevaFila -= pasos;
                nuevaColumna -= (char) pasos;
                break;
        }

        if (nuevaFila < 1 || nuevaFila > 8 || nuevaColumna < 'a' || nuevaColumna > 'h') {
            throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
        }

        if ((color == Color.BLANCO && nuevaFila == 8) || (color == Color.NEGRO && nuevaFila == 1)) {
            this.esDamaEspecial = true;
        }

        this.posicion = new Posicion(nuevaFila, nuevaColumna);
    }

    @Override
    public String toString() {
        return "color=" + color + ", posicion=(fila=" + posicion.getFila() + ", columna=" + posicion.getColumna() + ")";
    }

}
