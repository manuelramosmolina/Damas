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
        if (color == null)
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
        this.color = color;
    }

    public Posicion getPosicion(){
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        if (posicion == null)
            throw new NullPointerException("ERROR: La Posición no puede ser nula.");
        this.posicion = posicion;
    }

    public boolean isEsDamaEspecial() {
        return esDamaEspecial;
    }

    public void setEsDamaEspecial(boolean esDamaEspecial) throws OperationNotSupportedException {
        if (this.esDamaEspecial != esDamaEspecial)
            throw new OperationNotSupportedException("ERROR: NO es dama especial. ");

    }


    private Posicion crearPosicionInicial(Color color) {
        int fila = 0;
        char columna;
        do {
            if (color.equals(Color.BLANCO))
                fila = (int) (Math.random() * 3) + 1;
        } while (fila > 3);
        do {
            if (color.equals(Color.NEGRO))
                fila = (int) (Math.random() * 3) + 6;
        } while (fila > 8);

        int columnaNumero = (int) (Math.random() * 4) * 2 + 1;
        if (fila % 2 == 0) {
            columnaNumero -= 1;
        }

        switch (columnaNumero) {

            case 1:
                columna = 'a';
                break;
            case 2:
                columna = 'b';
                break;
            case 3:
                columna = 'c';
                break;
            case 4:
                columna = 'd';
                break;
            case 5:
                columna = 'e';
                break;
            case 6:
                columna = 'f';
                break;
            case 7:
                columna = 'g';
                break;
            default:
                columna = 'h';
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
                throw new OperationNotSupportedException("ERROR: La dama NO puede retroceder.");
            }
            if (color.equals(Color.NEGRO) && (direccion != Direccion.SURESTE && direccion != Direccion.SUROESTE)) {
                throw new OperationNotSupportedException("ERROR: La dama NO puede retroceder.");
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
                nuevaFila -= pasos;
                nuevaColumna += (char) pasos;
                break;
            case SURESTE:
                nuevaFila -= pasos;
                nuevaColumna -= (char) pasos;
                break;
            case SUROESTE:
                nuevaFila += pasos;
                nuevaColumna -= (char) pasos;
                break;
        }

        if ((color == Color.BLANCO && nuevaFila == 8) || (color == Color.NEGRO && nuevaFila == 1)) {
            this.esDamaEspecial = true;
        }

    }

    @Override
    public String toString() {
        return "color=" + color + ", posicion=(fila=" + posicion.getFila() + ", columna=" + posicion.getColumna() + ")";
    }

}
