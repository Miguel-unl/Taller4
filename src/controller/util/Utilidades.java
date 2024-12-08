package controller.util;

import java.util.Scanner;

public class Utilidades {

    private static final Scanner sn = new Scanner(System.in);

    public static boolean validate(String numero) {
        boolean validador = true;
        int contador_punto = 0;
        if (numero.charAt(0) == '-') {
            numero = numero.substring(1);
        }
        for (int i = 0; i < numero.length(); i++) {
            if (!Character.isDigit(numero.charAt(i)) && !(numero.charAt(i) == '.')) {
                validador = false;
            } else if (numero.charAt(i) == '.') {
                contador_punto++;
            }
        }
        if (contador_punto > 1 || (numero.length() < 2 && contador_punto == 1) || numero.length() == 0) {
            System.out.println(numero);
            return false;
        }
        return validador;
    }

    public static String readDoubleString(String message) {
        String value = "";
        boolean flag;
        do {
            value = readString(message);
            flag = validate(value);
            if (!flag) {
                System.out.println("¡¡¡NUMERO INVALIDO!!!");
                System.out.println("Ingrese numero valido");
            }
        } while (!flag);
        return value;
    }

    public static double readDouble(String message) {
        return Double.parseDouble(readDoubleString(message));
    }

    public static float readFloat(String message) {
        return Float.parseFloat(readDoubleString(message));
    }

    public static int readInteger(String message) {
        return (int) readDouble(message);
    }

    public static String readString(String message) {
        System.out.println(message);
        String a = sn.nextLine();
        if (a.isEmpty()) {
            a = " ";
        }
        return a;
    }

    public static char readChar(String message) {
        return readString(message).toUpperCase().charAt(0);
    }

    public static int aleatorio(int min, int max) {
        double aux;
        aux = Math.random() / Math.nextDown(1.0);
        return ((int) (min * (1.0 - aux) + max * aux));
    }

    public static float redondear(float num, int decimales) {
        float aux = (float) Math.pow(10, decimales);
        return Math.round(num * aux) / aux;
    }
}
