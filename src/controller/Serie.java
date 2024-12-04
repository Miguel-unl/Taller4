package controller;

public class Serie {

    public static double generarSerie(int n) {
        double acum = 0.0;
        int evaluador = -1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                evaluador *= -1;
            }
            if (evaluador > 0) {
                if (i != 1) {
                    acum += serie(i, "+");
                } else {
                    acum += serie(i, "S =");
                }
            } else {
                acum -= serie(i, "-");
            }
        }
        return acum;
    }
    // Metodo imprime un termino de la serie y devuelve el valor de este

    public static double serie(int i, String signo) {
        long f = fibonacci(i);
        int imp = impar(i);
        int pr = par(i);
        System.out.print(" " + signo + " (" + f + "/" + imp + ")^" + pr);
        return (Math.pow((f / (double) (imp)), pr));
    }

    // Genera n termino de la serie de Fibonacci
    public static long fibonacci(int n) {
        long i, a = 1, b = 0, c = 0;
        for (i = 1; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    // Genera n numero par

    public static int par(int n) {
        return 2 * n;
    }
    // Genera n numero impar

    public static int impar(int n) {
        return ((2 * n) - 1);
    }
}
