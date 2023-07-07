package org.boletin.ej18.main;

import org.boletin.ej13.clases.*;
import org.boletin.ej16.clases.ListaAnimales;

import java.util.ArrayList;

public class Ej18 {

    public static void main(String[] args) {

        final ArrayList<Animal> animales = ListaAnimales.reproducirAnimales();

        for (Animal a : animales)
            System.out.println(a);

    }

}
