package org.boletin.ej1;

import org.campusdual.util.Input;

public class Ej1 {

    public static void main(String[] args) {

        int enteroAleatorio = Input.integer("Introduce un numero entero aleatorio : ");

        System.out.println("El numero es : " + (enteroAleatorio % 2 == 0 ? "par" : "impar"));

    }

}
