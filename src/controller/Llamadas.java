package controller;

import controller.util.Utilidades;

public class Llamadas {
    public static void ejecutar() {
        int op, minutos;
        boolean opcion;
        do {
            opciones();
            op = Utilidades.readInteger("Ingrese el código de la zona ");
            opcion = !(op == 12 || op == 15 || op == 18 || op == 19 || op == 23 || op == 25 || op == 29 || op == 31);
            if (opcion) {
                System.out.println("INGRESE UN CODIGO DE REGION VALIDO");
            }
        } while (opcion);
        minutos = Utilidades.readInteger("Ingrese los minutos hablados");
        System.out.println("Por realizar una llamada de " + minutos + " minutos a la zona " + op + ": " + region(op));
        System.out.println("Debe pagar: " + (minutos * precioRegion(op)) + " dolares");
    }

    public static void opciones() {
        System.out.println("-------------------------------------------------");
        System.out.println("\tCODIGO\t\tREGION");
        System.out.println("\t  12\t AMERICA DEL NORTE");
        System.out.println("\t  15\t AMERICA CENTRAL");
        System.out.println("\t  18\t AMERICA DEL SUR");
        System.out.println("\t  19\t EUROPA");
        System.out.println("\t  23\t ASIA");
        System.out.println("\t  25\t AFRICA");
        System.out.println("\t  29\t OCEANIA");
        System.out.println("\t  31\t RESTO DEL MUNDO");
        System.out.println("-------------------------------------------------");
    }

    public static String region(int n) {
        String zona = "";
        switch (n) {
            case 12 -> zona = "AMERICA DEL NORTE";
            case 15 -> zona = "AMERICA CENTRAL";
            case 18 -> zona = "AMERICA DEL SUR";
            case 19 -> zona = "EUROPA";
            case 23 -> zona = "ASIA";
            case 25 -> zona = "AFRICA";
            case 29 -> zona = "OCEANIA";
            case 31 -> zona = "RESTO DEL MUNDO";
        }
        return zona;
    }

    public static float precioRegion(int n) {
        float valor = 0.0f;
        switch (n) {
            case 12 -> valor = 2.75f;
            case 15 -> valor = 1.85f;
            case 18 -> valor = 1.60f;
            case 19 -> valor = 3.5f;
            case 23 -> valor = 4.5f;
            case 25 -> valor = 3.1f;
            case 29 -> valor = 3.0f;
            case 31 -> valor = 6.0f;
        }
        return valor;
    }
}
