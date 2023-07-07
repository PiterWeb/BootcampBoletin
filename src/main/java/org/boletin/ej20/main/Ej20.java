package org.boletin.ej20.main;

import org.boletin.ej13.clases.*;
import org.boletin.ej20.clases.LeerCSV;

import java.util.ArrayList;

public class Ej20 {

    public static ArrayList<Animal> animales = new ArrayList<Animal>();

    public static void main(String[] args) {

        animales.addAll(LeerCSV.obtenerAnimales());

        for (Animal a : animales) System.out.println(a);

    }


}
