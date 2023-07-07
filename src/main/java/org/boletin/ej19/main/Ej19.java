package org.boletin.ej19.main;

import org.boletin.ej13.clases.*;
import org.boletin.ej16.clases.ListaAnimales;
import org.boletin.ej19.clases.CSVUtils;

import java.util.ArrayList;
import java.util.Optional;

public class Ej19 {

    public static void main(String[] args) {

        final ArrayList<Animal> animales = ListaAnimales.reproducirAnimales();

        CSVUtils.escribirAnimales(animales);

    }

}
