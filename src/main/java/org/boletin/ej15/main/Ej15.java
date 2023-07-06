package org.boletin.ej15.main;

import org.boletin.ej14.clases.*;

import java.util.HashMap;
import java.util.Map;

public class Ej15 {

    public static HashMap<String, AnimalSalvaje[]> parejasSalvajes = new HashMap<String, AnimalSalvaje[]>();
    public static HashMap<String, Mascota[]> parejasMascotas = new HashMap<String, Mascota[]>();
    public static HashMap<String, AnimalGranja[]> parejasGranja = new HashMap<String, AnimalGranja[]>();

    public static void main(String[] args) {

        Perro perroMacho = new Perro("Boxer", "Piplo", "Manolo", Sexo.Macho);
        Perro perroHembra = new Perro("Pug", "Dori", "Pedro", Sexo.Hembra);

        Perro[] perros = new Perro[]{perroHembra, perroMacho};

        parejasMascotas.put("Perros", perros);

        Gato gatoMacho = new Gato("Siames", "Trosky", "Pedro", Sexo.Macho);
        Gato gatoHembra = new Gato("Egipcio", "Olga", "Manolo", Sexo.Hembra);

        Gato[] gatos = new Gato[]{gatoHembra, gatoMacho};

        parejasMascotas.put("Gatos", gatos);

        Vaca vacaMacho = new Vaca("Gallega", "Manolo", Sexo.Macho);
        Vaca vacaHembra = new Vaca("Astuariana", "Pedro", Sexo.Hembra);

        Vaca[] vacas = new Vaca[]{vacaHembra, vacaMacho};

        parejasGranja.put("Vacas", vacas);

        Tucan tucanMacho = new Tucan("Azul", Sexo.Macho);
        Tucan tucanHembra = new Tucan("Rojo", Sexo.Hembra);

        Tucan[] tucanes = new Tucan[]{tucanHembra, tucanMacho};

        parejasSalvajes.put("Tucanes", tucanes);

        Oveja ovejaMacho = new Oveja("Gallega", "Pedro", Sexo.Macho);
        Oveja ovejaHembra = new Oveja("Vasca", "Manolo", Sexo.Hembra);

        Oveja[] ovejas = new Oveja[]{ovejaHembra, ovejaMacho};

        parejasGranja.put("Ovejas", ovejas);

        PezPayaso pezPayasoMacho = new PezPayaso("atlantico", Sexo.Macho);
        PezPayaso pezPayasoHembra = new PezPayaso("pacífico", Sexo.Hembra);

        PezPayaso[] pezesPayaso = new PezPayaso[]{pezPayasoHembra, pezPayasoMacho};

        parejasSalvajes.put("Pezes payaso", pezesPayaso);

        System.out.println("[Parejas Salvajes]");
        for (Map.Entry<String, AnimalSalvaje[]> pareja: parejasSalvajes.entrySet()) {

            System.out.println("---" + pareja.getKey() + "---");

            System.out.println(pareja.getValue()[0]);
            System.out.println(pareja.getValue()[1]);

        }

        System.out.println("[Parejas Mascotas]");
        for (Map.Entry<String, Mascota[]> pareja: parejasMascotas.entrySet()) {

            System.out.println("---" + pareja.getKey() + "---");

            System.out.println(pareja.getValue()[0]);
            System.out.println(pareja.getValue()[1]);

        }

        System.out.println("[Parejas Granja]");
        for (Map.Entry<String, AnimalGranja[]> pareja: parejasGranja.entrySet()) {

            System.out.println("---" + pareja.getKey() + "---");

            System.out.println(pareja.getValue()[0]);
            System.out.println(pareja.getValue()[1]);

        }

    }
}
