package org.boletin.ej6;

import org.campusdual.util.Input;

public class Ej6 {

    static int num1 = 0;
    static int num2 = 1;
    static int suma = 1;

    public static void main(String[] args) {

        int serie = Input.integer("Introduce hasta que valor de la serie de Fibonacci quieres: ");

        System.out.println(num1);

        fib(serie);

    }

    public static int fib(int serie) {

        int sig = serie - 1;

        if (sig < 1) return 0;

        System.out.println(suma);

        suma = num1 + num2;
        num1 = num2;
        num2 = suma;

        return fib(sig);

    }

}
