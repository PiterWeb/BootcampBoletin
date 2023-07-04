package org.boletin.ej3;

import org.campusdual.util.Input;

public class Ej3 {

    public static void main(String[] args) {

        int numero = Input.integer("Introduce un numero entero : ");

        for (int i = numero - 1; i > 0; i--) {

            if (numero % i == 0)
                System.out.println(i + " 1es divisor de " + numero);

        }

    }

}
