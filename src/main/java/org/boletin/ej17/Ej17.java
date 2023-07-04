package org.boletin.ej17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Ej17 {

    public static ArrayList<Animal> animales = new ArrayList<Animal>();

    public static void main(String[] args) {

        // Acabar (No funciona correctamente)

        Perro perroMacho = new Perro("Boxer", "Piplo", "Manolo", "macho");
        Perro perroHembra = new Perro("Pug", "Dori", "Pedro", "hembra");
        Perro perroMacho2 = new Perro("Boxer", "Piplo", "Manolo", "macho");
        Perro perroHembra2 = new Perro("Pug", "Dori", "Pedro", "hembra");
        Perro perroMacho3 = new Perro("Boxer", "Piplo", "Manolo", "macho");
        Perro perroHembra3 = new Perro("Pug", "Dori", "Pedro", "hembra");
        Perro perroMacho4 = new Perro("Boxer", "Piplo", "Manolo", "macho");
        Perro perroHembra4 = new Perro("Pug", "Dori", "Pedro", "hembra");

        Perro[] perros = new Perro[]{perroHembra, perroMacho, perroHembra2, perroMacho2, perroHembra3, perroMacho3, perroHembra4, perroMacho4};

        animales.addAll(Arrays.asList(perros));

        Gato gatoMacho = new Gato("Siames", "Trosky", "Pedro", "macho");
        Gato gatoHembra = new Gato("Egipcio", "Olga", "Manolo", "hembra");

        Gato[] gatos = new Gato[]{gatoHembra, gatoMacho};

        animales.addAll(Arrays.asList(gatos));

        Vaca vacaMacho = new Vaca("Gallega", "Manolo", "macho");
        Vaca vacaHembra = new Vaca("Astuariana", "Pedro", "hembra");

        Vaca[] vacas = new Vaca[]{vacaHembra, vacaMacho};

        animales.addAll(Arrays.asList(vacas));

        Tucan tucanMacho = new Tucan("Azul", "macho");
        Tucan tucanHembra = new Tucan("Rojo", "hembra");

        Tucan[] tucanes = new Tucan[]{tucanHembra, tucanMacho};

        animales.addAll(Arrays.asList(tucanes));

        Oveja ovejaMacho = new Oveja("Gallega", "Pedro", "macho");
        Oveja ovejaHembra = new Oveja("Vasca", "Manolo", "hembra");

        Oveja[] ovejas = new Oveja[]{ovejaHembra, ovejaMacho};

        animales.addAll(Arrays.asList(ovejas));

        PezPayaso pezPayasoMacho = new PezPayaso("atlantico", "macho");
        PezPayaso pezPayasoHembra = new PezPayaso("pacífico", "hembra");

        PezPayaso[] pezesPayaso = new PezPayaso[]{pezPayasoHembra, pezPayasoMacho};

        animales.addAll(Arrays.asList(pezesPayaso));

        for (int limit = 4; limit > 0; limit--) {

            for (int i = 0; i < animales.size(); i++) {

                Animal animal1 = animales.get(i);

                if (animal1 == null) continue;

                for (int j = 0; j < animales.size(); j++) {

                    Animal animal2 = animales.get(j);

                    if (animal2 == null) continue;

                    while (true) {

                        Optional<Animal> cria = animal1.addCria(animal2);

                        if (cria.isEmpty()) break;

                        animales.add(cria.get());

                    }

                }

            }
        }


        for (Animal a : animales)
            System.out.println(a);

    }

}
