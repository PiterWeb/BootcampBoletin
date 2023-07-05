package org.boletin.ej4;

import org.campusdual.util.Input;

public class Ej4 {

    public static void main(String[] args) {

        int numero = Input.integer("Introduce un numero entero para calcular su factorial: ");

        System.out.println(fact(numero));

    }

    public static int fact(int n) {

        if (n == 0) return 1;

        if (n - 1 == 0) return n;

        return n * fact(n - 1);

    }

}
