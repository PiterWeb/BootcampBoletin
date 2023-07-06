package org.boletin.ej22.main;

import org.boletin.ej14.clases.Sexo;
import org.boletin.ej22.clases.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Ej22 {

    public static ArrayList<Animal> animales = new ArrayList<>();

    public static void main(String[] args) {

        Perro perroMacho = new Perro("Boxer", "Piplo", "Manolo", Sexo.Macho);
        Perro perroHembra = new Perro("Pug", "Dori", "Pedro", Sexo.Hembra);

        Perro[] perros = new Perro[]{perroHembra, perroMacho};

        animales.addAll(Arrays.asList(perros));

        Gato gatoMacho = new Gato("Siames", "Trosky", "Pedro", Sexo.Macho);
        Gato gatoHembra = new Gato("Egipcio", "Olga", "Manolo", Sexo.Hembra);

        Gato[] gatos = new Gato[]{gatoHembra, gatoMacho};

        animales.addAll(Arrays.asList(gatos));

        Granjero manolo = new Granjero("Manolo");
        Granjero pedro = new Granjero("Pedro");

        Vaca vacaMacho = new Vaca("Gallega", manolo, Sexo.Macho);
        Vaca vacaHembra = new Vaca("Astuariana", pedro, Sexo.Hembra);
        Vaca vacaOtro = new Vaca("Vasca", pedro, Sexo.Hembra);

        Vaca[] vacas = new Vaca[]{vacaHembra, vacaMacho, vacaOtro};

        animales.addAll(Arrays.asList(vacas));

        Tucan tucanMacho = new Tucan("Azul", Sexo.Macho);
        Tucan tucanHembra = new Tucan("Rojo", Sexo.Hembra);

        Tucan[] tucanes = new Tucan[]{tucanHembra, tucanMacho};

        animales.addAll(Arrays.asList(tucanes));

        Oveja ovejaMacho = new Oveja("Gallega", pedro, Sexo.Macho);
        Oveja ovejaHembra = new Oveja("Vasca", manolo, Sexo.Hembra);

        Oveja[] ovejas = new Oveja[]{ovejaHembra, ovejaMacho};

        animales.addAll(Arrays.asList(ovejas));

        PezPayaso pezPayasoMacho = new PezPayaso("atlantico", Sexo.Macho);
        PezPayaso pezPayasoHembra = new PezPayaso("pacífico", Sexo.Hembra);

        PezPayaso[] pezesPayaso = new PezPayaso[]{pezPayasoHembra, pezPayasoMacho};

        animales.addAll(Arrays.asList(pezesPayaso));

        ArrayList<Animal> animalesTemporales;

        while (true) {

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

        for (Animal a : animales) System.out.println(a);

    }

}
