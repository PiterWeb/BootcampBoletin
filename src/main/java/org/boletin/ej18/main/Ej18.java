package org.boletin.ej18.main;

import org.boletin.ej14.clases.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Ej18 {

    public static ArrayList<Animal> animales = new ArrayList<Animal>();

    public static void main(String[] args) {

        Perro perroMacho = new Perro("Boxer", "Piplo", "Manolo", Sexo.Macho);
        Perro perroHembra = new Perro("Pug", "Dori", "Pedro", Sexo.Hembra);
        Perro perroOtro = new Perro("Shiba inu", "Kota", "Pedro", Sexo.Macho);

        Perro[] perros = new Perro[]{perroHembra, perroMacho, perroOtro};

        animales.addAll(Arrays.asList(perros));

        Gato gatoMacho = new Gato("Siames", "Trosky", "Pedro", Sexo.Macho);
        Gato gatoHembra = new Gato("Egipcio", "Olga", "Manolo", Sexo.Hembra);

        Gato[] gatos = new Gato[]{gatoHembra, gatoMacho};

        animales.addAll(Arrays.asList(gatos));

        Vaca vacaMacho = new Vaca("Gallega", "Manolo", Sexo.Macho);
        Vaca vacaHembra = new Vaca("Astuariana", "Pedro", Sexo.Hembra);

        Vaca[] vacas = new Vaca[]{vacaHembra, vacaMacho};

        animales.addAll(Arrays.asList(vacas));

        Tucan tucanMacho = new Tucan("Azul", Sexo.Macho);
        Tucan tucanHembra = new Tucan("Rojo", Sexo.Hembra);

        Tucan[] tucanes = new Tucan[]{tucanHembra, tucanMacho};

        animales.addAll(Arrays.asList(tucanes));

        Oveja ovejaMacho = new Oveja("Gallega", "Pedro", Sexo.Macho);
        Oveja ovejaHembra = new Oveja("Vasca", "Manolo", Sexo.Hembra);

        Oveja[] ovejas = new Oveja[]{ovejaHembra, ovejaMacho};

        animales.addAll(Arrays.asList(ovejas));

        PezPayaso pezPayasoMacho = new PezPayaso("atlantico", Sexo.Macho);
        PezPayaso pezPayasoHembra = new PezPayaso("pacífico", Sexo.Hembra);

        PezPayaso[] pezesPayaso = new PezPayaso[]{pezPayasoHembra, pezPayasoMacho};

        animales.addAll(Arrays.asList(pezesPayaso));

        for (int i = 0; i < animales.size(); i++) {

            Animal animal1 = animales.get(i);

            if (animal1 == null) continue;

            for (int j = 0; j < animales.size(); j++) {

                Animal animal2 = animales.get(j);

                if (animal2 == null) continue;

                while (true) {

                    Optional<Animal> cria = animal1.aparearse(animal2);

                    if (cria.isEmpty()) break;

                    animales.add(cria.get());

                }


            }

        }


        for (Animal a : animales)
            System.out.println(a);

    }

}
