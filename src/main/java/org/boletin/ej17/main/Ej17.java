package org.boletin.ej17.main;

import org.boletin.ej13.clases.*;
import org.boletin.ej16.clases.ListaAnimales;


import java.util.ArrayList;
import java.util.Optional;

public class Ej17 {

    public static void main(String[] args) {

        final ArrayList<Animal> animales = ListaAnimales.reproducirAnimales();

        for (Animal a : animales)
            System.out.println(a);

    }

}
