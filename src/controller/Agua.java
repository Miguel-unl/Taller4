package controller;

import controller.util.Utilidades;

public class Agua {

    private static final float base = 3.0f;
    private static final float recoleccionBasura = 0.75f;
    private static final float procDatos = 0.5f;

    public static void ejecutar() {
        float volumen, reduccion = 0.0f;
        char desc;
        do{
            volumen = Utilidades.readFloat("Ingrese el consumo de agua en m3 (metros cubicos)");
            if(volumen <=0){
                System.out.println("El consumo de agua debe ser mayor a 0");
            }
        }while(volumen<=0);
        desc = Utilidades.readChar("Ingrese \"S\" si el propietario es de tercera edad");
        if (desc == 'S') {
            reduccion += Utilidades.redondear(descuento(true, volumen), 2);
        }
        desc = Utilidades.readChar("Ingrese \"S\" si el propietario posee una discapacidad");
        if (desc == 'S') {
            reduccion += Utilidades.redondear(descuento(false, volumen), 2);
        }
        informePago(valorCobro(volumen), volumen, reduccion);
    }

    public static void informePago(float total, float volumen, float descuento) {
        float impuesto = calcularImpuesto(total);
        System.out.println("------------------------------------------------------");
        System.out.println("Consumo de agua en m3: \t\t\t" + volumen + " m3");
        System.out.println("Precio por consumo: \t\t\t" + total + " dolares");
        System.out.println("El impuesto por alcantarillado es: \t" + impuesto + " dolares");
        System.out.println("Precio por recoleccion de basura: \t" + recoleccionBasura + " dolares");
        System.out.println("Precio por el proceso: \t\t\t" + procDatos + " dolares");
        System.out.println("Descuento: \t\t\t\t" + descuento + " dolares");
        System.out.println("------------------------------------------------------");
        System.out.println("Total a pagar: \t\t\t\t"
                + Utilidades.redondear(total + impuesto + recoleccionBasura + procDatos - descuento, 2) + " dolares");
        System.out.println("------------------------------------------------------");
    }

    // validador = true || tercera edad
    // validador = false || discapacidad
    public static float descuento(boolean validador, float volumen) {
        float resto;
        if (validador) {
            if (volumen <= 15.0f) {
                resto = 0.5f;
            } else {
                resto = 0.3f;
            }
        } else {
            resto = (float) validarDiscapacidad() / 100;
        }
        return resto * base;
    }

    public static float calcularImpuesto(float total) {
        return Utilidades.redondear(total * 0.35f, 2);
    }

    public static int validarDiscapacidad() {
        int valor;
        boolean validador;
        do {
            valor = Utilidades.readInteger("Ingrese el porcentaje de su discapacidad:    %");
            validador = (valor <= 100 && valor >= 5);
            if (!validador) {
                System.out.println("Ingrese un porcentaje de discapacidad valido.");
            }
        } while (!validador);
        return valor;
    }

    public static float valorCobro(float volumen) {
        if (volumen <= 15) {
            return base;
        }
        if (volumen <= 25) {
            return (base + (volumen - 15) * 0.1f);
        }
        if (volumen <= 40) {
            return (base + 10 * 0.1f + (volumen - 25) * 0.2f);
        }
        if (volumen <= 60) {
            return (base + 10 * 0.1f + 15 * 0.2f + (volumen - 40) * 0.3f);
        } else {
            return (base + 10 * 0.1f + 15 * 0.2f + 20 * 0.3f + (volumen - 60) * 0.35f);
        }
    }
}
