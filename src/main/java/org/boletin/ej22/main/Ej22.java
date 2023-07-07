package org.boletin.ej22.main;

import org.boletin.ej13.clases.*;
import org.boletin.ej16.clases.ListaAnimales;
import org.boletin.ej22.clases.*;
import org.boletin.ej22.clases.Oveja;
import org.boletin.ej22.clases.Vaca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Ej22 {

    public static ArrayList<Animal> animales = new ArrayList<>();

    public static void main(String[] args) {

        Perro perroMacho = new Perro("Boxer", "Piplo", "Manolo", Sexo.MACHO);
        Perro perroHembra = new Perro("Pug", "Dori", "Pedro", Sexo.HEMBRA);

        Perro[] perros = new Perro[]{perroHembra, perroMacho};

        animales.addAll(Arrays.asList(perros));

        Gato gatoMacho = new Gato("Siames", "Trosky", "Pedro", Sexo.MACHO);
        Gato gatoHembra = new Gato("Egipcio", "Olga", "Manolo", Sexo.HEMBRA);

        Gato[] gatos = new Gato[]{gatoHembra, gatoMacho};

        animales.addAll(Arrays.asList(gatos));

        Granjero manolo = new Granjero("Manolo");
        Granjero pedro = new Granjero("Pedro");

        Vaca vacaMacho = new Vaca("Gallega", manolo, Sexo.MACHO);
        Vaca vacaHembra = new Vaca("Astuariana", pedro, Sexo.HEMBRA);
        Vaca vacaOtro = new Vaca("Vasca", pedro, Sexo.HEMBRA);

        Vaca[] vacas = new Vaca[]{vacaHembra, vacaMacho, vacaOtro};

        animales.addAll(Arrays.asList(vacas));

        Tucan tucanMacho = new Tucan("Azul", Sexo.MACHO);
        Tucan tucanHembra = new Tucan("Rojo", Sexo.HEMBRA);

        Tucan[] tucanes = new Tucan[]{tucanHembra, tucanMacho};

        animales.addAll(Arrays.asList(tucanes));

        Oveja ovejaMacho = new Oveja("Gallega", pedro, Sexo.MACHO);
        Oveja ovejaHembra = new Oveja("Vasca", manolo, Sexo.HEMBRA);

        Oveja[] ovejas = new Oveja[]{ovejaHembra, ovejaMacho};

        animales.addAll(Arrays.asList(ovejas));

        PezPayaso pezPayasoMacho = new PezPayaso("atlantico", Sexo.MACHO);
        PezPayaso pezPayasoHembra = new PezPayaso("pacífico", Sexo.HEMBRA);

        PezPayaso[] pezesPayaso = new PezPayaso[]{pezPayasoHembra, pezPayasoMacho};

        animales.addAll(Arrays.asList(pezesPayaso));

        animales = ListaAnimales.reproducirAnimales(animales, 3);

        for (Animal a : animales) System.out.println(a);

    }

}
