package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola(){

    }

    public static void mostrarMenu(){
        System.out.println("¡¡Bienvenido al juego de las Damas!!");
        System.out.println("----");
        System.out.println("MENU");
        System.out.println("----");
        System.out.println("1. Crear dama por defecto.");
        System.out.println("2. Crear dama eligiendo color.");
        System.out.println("3. Mover dama.");
        System.out.println("4. Salir.");
    }
    public static int elegirOpcionMenu(){
        int opcionMenu;
        do {
            System.out.println("Elige una de las opciones del menú:");
            opcionMenu= Entrada.entero();
            if (opcionMenu<1 || opcionMenu>4){
                System.out.println("Opción NO válida.");
            }
        }while (opcionMenu<1 || opcionMenu>4);
        return opcionMenu;

    }

    public static Color elegirColor(){
        int colorElegido;
        do {
            System.out.println("Elige un color: 1. Blanco - 2.Negro");
            colorElegido= Entrada.entero();
            if (colorElegido<1 || colorElegido>2){
                System.out.println("Opción NO válida.");
            }
        }while (colorElegido<1 || colorElegido>2);
        if (colorElegido==1){
            return Color.BLANCO;
        }else {
            return Color.NEGRO;
        }
    }

    public static void mostrarMenuDirecciones(){
        System.out.println("Dirección:");
        System.out.println("---------");
        System.out.println("1. Noreste");
        System.out.println("2. Noroeste");
        System.out.println("3. Sureste");
        System.out.println("4. Suroeste");

    }

    public static Direccion elegirDireccion(){
        int opcionDireccion;
        do {
            System.out.println("Elige una Dirección");
            opcionDireccion= Entrada.entero();
            if (opcionDireccion<1 || opcionDireccion>4){
                System.out.println("Opción NO válida.");
            }
        }while (opcionDireccion<1 || opcionDireccion>4);

        Direccion direccionElegida;
        switch (opcionDireccion){
            case 1:
                direccionElegida=Direccion.NORESTE;
                break;

            case 2:
                direccionElegida=Direccion.NOROESTE;
                break;

            case 3:
                direccionElegida=Direccion.SURESTE;
                break;

            default:
                direccionElegida=Direccion.SUROESTE;
        };
        return direccionElegida;
    }

    public static int elegirPasos(){
        int pasosElegidos;
        do{
            System.out.println("Elige los pasos, número de casillas, a mover:");
            pasosElegidos=Entrada.entero();
            if (pasosElegidos<1){
                System.out.println("Opción no válida.");
            }
        }while (pasosElegidos<1);
        return pasosElegidos;
    }

    public static void despedirse(){

        System.out.println("¡¡Gracias por jugar a las Damas!!. Hasta pronto.");
    }
}
