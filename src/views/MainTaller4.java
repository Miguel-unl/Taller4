package views;

import controller.Agua;
import controller.Llamadas;
import controller.Serie;
import controller.SueldoEmpleados;
import controller.util.Utilidades;

public class MainTaller4 {
        public static void main(String[] args) {
            int op;
            do {
                menu();
                op = Utilidades.readInteger("Ingrese el ejercicio que desea");
                switch (op) {
                    case 1 -> {
                        char opcion;
                        do {
                            SueldoEmpleados.ejecutar();
                            opcion = Utilidades.readChar(
                                    "¿Desea ingresar otro empleado? Ingrese \"S\", caso contrario cualquier otra tecla (que no sea la de apagado)");
                        } while (opcion == 'S');
                        break;
                    }
                    case 2 -> {
                        Llamadas.ejecutar();
                        break;
                    }
                    case 3 -> {
                        Agua.ejecutar();
                        break;
                    }
                    case 4 -> {
                        boolean val;
                        int n;
                        do {
                            n = Utilidades.readInteger("Ingrese la cantidad de terminos de la serie: ");
                            val = n < 1;
                            if (val) {
                                System.out.println("ingrese un numero mayor a 0");
                            }
                        } while (val);
                        System.out.println("\nLa suma de la serie es: " + Serie.generarSerie(n));
                        break;
                    }
                    case 0 -> {
                        System.out.println("¡¡¡¡¡¡Gracias por usar!!!!!!");
                        break;
                    }
                    default -> {
                        System.out.println("Ingrese valores entre 0 y 4");
                    }
                }
            } while (op != 0);
        }
        // Imprime las opciones Presentes en el Menu

        public static void menu() {
            System.out.println("1. Informe de venta de Autos. ");
            System.out.println("2. Llamadas Internacionales. ");
            System.out.println("3. Valor de Consumo de Agua. ");
            System.out.println("4. Generar una serie. ");
            System.out.println("0. Salir. ");
        }
    }
}