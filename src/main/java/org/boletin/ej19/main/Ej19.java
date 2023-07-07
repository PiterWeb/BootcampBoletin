package org.boletin.ej19.main;

import org.boletin.ej13.clases.*;
import org.boletin.ej16.clases.ListaAnimales;
import org.boletin.ej19.clases.CSVUtils;

import java.util.ArrayList;
import java.util.Optional;

public class Ej19 {

    public static void main(String[] args) {

        final ArrayList<Animal> animales = ListaAnimales.getLista();

        ArrayList<Animal> animalesTemporales;

        for (int i = 0; i < 3; i++) {

            animalesTemporales = new ArrayList<Animal>();

            int animalesSize = animales.size();

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

            if (animalesSize == animales.size()) break;
        }

        CSVUtils.escribirAnimales(animales);

    }

}
