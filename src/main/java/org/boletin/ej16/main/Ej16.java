package org.boletin.ej16.main;

import org.boletin.ej13.clases.*;
import org.boletin.ej16.clases.ListaAnimales;

import java.util.ArrayList;
import java.util.Optional;

public class Ej16 {

    public static void main(String[] args) {

        final ArrayList<Animal> animales = ListaAnimales.getLista();

        ArrayList<Animal> animalesTemporales = new ArrayList<Animal>();

        for (Animal animal1 : animales) {

            if (animal1 == null) continue;

            for (Animal animal2 : animales) {

                if (animal2 == null) continue;

                while (true) {

                    Optional<Animal> cria = animal1.aparearse(animal2);

                    if (cria.isEmpty()) break;

                    animalesTemporales.add(cria.get());

                }

            }

        }

        animales.addAll(animalesTemporales);

        for (Animal a : animales)
            System.out.println(a);

    }

}
