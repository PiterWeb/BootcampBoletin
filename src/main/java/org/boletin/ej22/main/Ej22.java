package org.boletin.ej22.main;

import org.boletin.ej22.clases.*;
import org.campusdual.util.Input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Ej22 {

    public static ArrayList<Animal> animales = new ArrayList<Animal>();

    public static void main(String[] args) {

        Perro perroMacho = new Perro("Boxer", "Piplo", "Manolo", "macho");
        Perro perroHembra = new Perro("Pug", "Dori", "Pedro", "hembra");

        Perro[] perros = new Perro[]{perroHembra, perroMacho};

        animales.addAll(Arrays.asList(perros));

        Gato gatoMacho = new Gato("Siames", "Trosky", "Pedro", "macho");
        Gato gatoHembra = new Gato("Egipcio", "Olga", "Manolo", "hembra");

        Gato[] gatos = new Gato[]{gatoHembra, gatoMacho};

        animales.addAll(Arrays.asList(gatos));

        Granjero manolo = new Granjero("Manolo");
        Granjero pedro = new Granjero("Pedro");

        Vaca vacaMacho = new Vaca("Gallega", manolo, "macho");
        Vaca vacaHembra = new Vaca("Astuariana", pedro, "hembra");
        Vaca vacaOtro = new Vaca("Vasca", pedro, "hembra");

        Vaca[] vacas = new Vaca[]{vacaHembra, vacaMacho, vacaOtro};

        animales.addAll(Arrays.asList(vacas));

        Tucan tucanMacho = new Tucan("Azul", "macho");
        Tucan tucanHembra = new Tucan("Rojo", "hembra");

        Tucan[] tucanes = new Tucan[]{tucanHembra, tucanMacho};

        animales.addAll(Arrays.asList(tucanes));

        Oveja ovejaMacho = new Oveja("Gallega", pedro, "macho");
        Oveja ovejaHembra = new Oveja("Vasca", manolo, "hembra");

        Oveja[] ovejas = new Oveja[]{ovejaHembra, ovejaMacho};

        animales.addAll(Arrays.asList(ovejas));

        PezPayaso pezPayasoMacho = new PezPayaso("atlantico", "macho");
        PezPayaso pezPayasoHembra = new PezPayaso("pacífico", "hembra");

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

        for (Animal a : animales) System.out.println(a);

    }

}
