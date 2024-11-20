package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.damas.modelo.Dama;

import static org.iesalandalus.programacion.damas.Consola.despedirse;

public class MainApp {

    private static Dama dama;


    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearDamaDefecto();
                break;
            case 2:
                crearDamaColor();
                break;
            case 3:
                mover();
                break;
            case 4:
                despedirse();
                break;
            default:
                System.out.println("ERROR: Opción NO válida.");
        }
    }

    private static void crearDamaDefecto() {
        dama = new Dama();
        System.out.println("Se ha creado una dama por defecto.");
    }

    private static void crearDamaColor() {
        Color color = Consola.elegirColor();
        dama = new Dama(color);
        System.out.println("Se ha creado una dama de color " + color + ".");
    }

    private static void mover() {

        try {
            if (dama == null) {
                System.out.println("ERROR: Debes crear una dama.");
                return;
            }
            Consola.mostrarMenuDirecciones();
            Direccion direccion = Consola.elegirDireccion();
            int pasos = 1;
            if (dama.isEsDamaEspecial()) {
                pasos = Consola.elegirPasos();
            }
                dama.mover(direccion, pasos);
                System.out.println("Dama movida correctamente a la nueva posición: " + dama);
        } catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarDama() {
        if (dama == null) {
            System.out.println("No hay ninguna dama creada.");
        } else {
            System.out.println(dama);
        }
    }

    public static void main(String[] args) {

        int opcion;
        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcionMenu();
            ejecutarOpcion(opcion);
        } while (opcion != 4);
        despedirse();
    }
	
	
}
