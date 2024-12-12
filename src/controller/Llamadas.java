package controller;

import controller.util.Utilidades;

public class Llamadas {
    public enum Region {
        AMERICA_DEL_NORTE(12, 2.75f),
        AMERICA_CENTRAL(15, 1.89f),
        AMERICA_DEL_SUR(18, 1.60f),
        EUROPA(19, 3.50f),
        ASIA(23, 4.50f),
        AFRICA(25, 3.10f),
        OCEANIA(29, 3.00f),
        RESTO_DEL_MUNDO(31, 6.00f);

        private final int codigo;
        private final float precio;

        Region(int codigo, float precio) {
            this.codigo = codigo;
            this.precio = precio;
        }

        public int getCodigo() {
            return codigo;
        }

        public float getPrecio() {
            return precio;
        }
    }

    public static void ejecutar() {
        int op, minutos;
        boolean opcion;
        Region rg = Region.values()[0];
        do {
            opciones();
            op = Utilidades.readInteger("Ingrese el código de la zona ");
            opcion = !(op == 12 || op == 15 || op == 18 || op == 19 || op == 23 || op == 25 || op == 29 || op == 31);
            if (opcion) {
                System.out.println("INGRESE UN CODIGO DE REGION VALIDO");
            }
        } while (opcion);
        for (int i = 0; i < Region.values().length; i++) {
            rg = Region.values()[i];
            if (rg.getCodigo() == op) {
                break;
            }
        }
        do {
            minutos = Utilidades.readInteger("Ingrese los minutos hablados");
            if (minutos <= 0) {
                System.out.println("Una cantidad de minutos valida");
            }
        } while (minutos <= 0);
        System.out.println(
                "Por realizar una llamada de " + minutos + " minutos a la zona " + op + ": " + rg.name());
        System.out.println("Debe pagar: " + (minutos * rg.getPrecio()) + " dolares");
    }

    public static void opciones() {
        Region rg;
        System.out.println("-------------------------------------------------");
        System.out.println("\tCODIGO\t\tREGION");
        for (int i = 0; i < Region.values().length; i++) {
            rg = Region.values()[i];
            System.out.println("\t" + rg.getCodigo() + "\t" + rg.name().replace("_", " "));
        }
        System.out.println("-------------------------------------------------");

    }
}
