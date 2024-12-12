package controller;

import controller.util.Utilidades;

public class SueldoEmpleados {
    public static final float sueldoBase = 2500.0f;

    public static void ejecutar() {
        String nombre;
        nombre = Utilidades.readString("Ingrese el nombre del empleado: ");
        char opcion;
        float venta, total = 0;
        int autosbon = 0, autosven = 0;
        do {
            do {
                venta = Utilidades.readFloat("Ingrese el valor de la venta: ");
                if (venta <= 0) {
                    System.out.println("El precio del auto debe ser mayor a 0");
                }
            } while (venta <= 0);

            if (venta > 10000.0f) {
                autosbon++;
            } else {
                autosven++;
            }
            total += venta;
            opcion = Utilidades.readChar(
                    "Ingrese \"S\" si desea ingresar otra venta, caso contrario cualquier otra tecla (que no sea la de apagado)");
        } while (opcion == 'S');
        informe(nombre, autosbon + autosven, total, calculoBonos(autosbon), calculoBono5(total));
    }

    public static float calculoBonos(int autosBono) {
        return 250 * autosBono;
    }

    public static float calculoBono5(float total) {
        return total * 0.05f;
    }

    public static float calculoTotal(float bonosVenta, float bonosTotal) {
        return (bonosVenta + bonosTotal + sueldoBase);
    }

    public static void informe(String nombre, int autosvendidos, float total, float bonosVenta, float bonosTotal) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Nombre del empleado: \t\t\t" + nombre);
        System.out.println("Valor de autos vendidos: \t\t" + total);
        System.out.println("Total de autos vendidos: \t\t" + autosvendidos);
        System.out.println("Sueldo base: \t\t\t\t" + sueldoBase);
        System.out.println("Bonos por ventas mayores a 10000\t" + bonosVenta);
        System.out.println("Bono del 5% de ventas: \t\t\t" + bonosTotal);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Total a pagar este mes: \t\t" + calculoTotal(bonosTotal, bonosVenta));
        System.out.println("-----------------------------------------------------------");
    }
}