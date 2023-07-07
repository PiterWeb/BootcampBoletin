package org.boletin.ej18.main;

import org.boletin.ej13.clases.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Ej18 {

    public static ArrayList<Animal> animales = new ArrayList<Animal>();

    public static void main(String[] args) {

        Perro perroMacho = new Perro("Boxer", "Piplo", "Manolo", Sexo.MACHO);
        Perro perroHembra = new Perro("Pug", "Dori", "Pedro", Sexo.HEMBRA);
        Perro perroOtro = new Perro("Shiba inu", "Kota", "Pedro", Sexo.MACHO);

        Perro[] perros = new Perro[]{perroHembra, perroMacho, perroOtro};

        animales.addAll(Arrays.asList(perros));

        Gato gatoMacho = new Gato("Siames", "Trosky", "Pedro", Sexo.MACHO);
        Gato gatoHembra = new Gato("Egipcio", "Olga", "Manolo", Sexo.HEMBRA);

        Gato[] gatos = new Gato[]{gatoHembra, gatoMacho};

        animales.addAll(Arrays.asList(gatos));

        Vaca vacaMacho = new Vaca("Gallega", "Manolo", Sexo.MACHO);
        Vaca vacaHembra = new Vaca("Astuariana", "Pedro", Sexo.HEMBRA);

        Vaca[] vacas = new Vaca[]{vacaHembra, vacaMacho};

        animales.addAll(Arrays.asList(vacas));

        Tucan tucanMacho = new Tucan("Azul", Sexo.MACHO);
        Tucan tucanHembra = new Tucan("Rojo", Sexo.HEMBRA);

        Tucan[] tucanes = new Tucan[]{tucanHembra, tucanMacho};

        animales.addAll(Arrays.asList(tucanes));

        Oveja ovejaMacho = new Oveja("Gallega", "Pedro", Sexo.MACHO);
        Oveja ovejaHembra = new Oveja("Vasca", "Manolo", Sexo.HEMBRA);

        Oveja[] ovejas = new Oveja[]{ovejaHembra, ovejaMacho};

        animales.addAll(Arrays.asList(ovejas));

        PezPayaso pezPayasoMacho = new PezPayaso("atlantico", Sexo.MACHO);
        PezPayaso pezPayasoHembra = new PezPayaso("pacífico", Sexo.HEMBRA);

        PezPayaso[] pezesPayaso = new PezPayaso[]{pezPayasoHembra, pezPayasoMacho};

        animales.addAll(Arrays.asList(pezesPayaso));

        ArrayList<Animal> animalesTemporales;

        for(int i = 0; i < 3; i++) {

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


        for (Animal a : animales)
            System.out.println(a);

    }

}
