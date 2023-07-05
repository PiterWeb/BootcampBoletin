package org.boletin.ej2;

import org.campusdual.util.Input;

public class Ej2 {

    public static void main(String[] args) {

        double numeroAleatorio = Input.real("Introduce un numero aleatorio: ");

        if (numeroAleatorio % 2 == 0) System.out.println("Es multiplo de 2");

        if (numeroAleatorio % 3 == 0) System.out.println("Es multiplo de 3");

        if (numeroAleatorio % 5 == 0) System.out.println("Es multiplo de 5");

        if (numeroAleatorio % 7 == 0) System.out.println("Es multiplo de 7");

    }

}
