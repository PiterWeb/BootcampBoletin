package org.boletin.ej13.main;

import org.boletin.ej13.clases.Gato;
import org.boletin.ej13.clases.Tucan;
import org.boletin.ej13.clases.Vaca;

public class Ej13 {

    public static void main(String[] args) {

        Gato gato = new Gato("Siames", "Trosky", "Pedro");

        Vaca vaca = new Vaca("Gallega", "Pedro");

        Tucan tucan = new Tucan("Rojo");

        System.out.println(gato);
        System.out.println(vaca);
        System.out.println(tucan);

    }
}
