package org.boletin.ej14.main;

import org.boletin.ej14.clases.*;

import java.util.HashMap;
import java.util.Map;

public class Ej14 {

    public static HashMap<String, Animal[]> parejas = new HashMap<String, Animal[]>();
    public static void main(String[] args) {

        Perro perroMacho = new Perro("Boxer", "Piplo", "Manolo", Sexo.Macho);
        Perro perroHembra = new Perro("Pug", "Dori", "Pedro", Sexo.Hembra);

        Perro[] perros = new Perro[]{perroHembra, perroMacho};

        parejas.put("Perros", perros);

        Gato gatoMacho = new Gato("Siames", "Trosky", "Pedro", Sexo.Macho);
        Gato gatoHembra = new Gato("Egipcio", "Olga", "Manolo", Sexo.Hembra);

        Gato[] gatos = new Gato[]{gatoHembra, gatoMacho};

        parejas.put("Gatos", gatos);

        Vaca vacaMacho = new Vaca("Gallega", "Manolo", Sexo.Macho);
        Vaca vacaHembra = new Vaca("Astuariana", "Pedro", Sexo.Hembra);

        Vaca[] vacas = new Vaca[]{vacaHembra, vacaMacho};

        parejas.put("Vacas", vacas);

        Tucan tucanMacho = new Tucan("Azul", Sexo.Macho);
        Tucan tucanHembra = new Tucan("Rojo", Sexo.Hembra);

        Tucan[] tucanes = new Tucan[]{tucanHembra, tucanMacho};

        parejas.put("Tucanes", tucanes);

        Oveja ovejaMacho = new Oveja("Gallega", "Pedro", Sexo.Macho);
        Oveja ovejaHembra = new Oveja("Vasca", "Manolo", Sexo.Hembra);

        Oveja[] ovejas = new Oveja[]{ovejaHembra, ovejaMacho};

        parejas.put("Ovejas", ovejas);

        PezPayaso pezPayasoMacho = new PezPayaso("atlantico", Sexo.Macho);
        PezPayaso pezPayasoHembra = new PezPayaso("pacífico", Sexo.Hembra);

        PezPayaso[] pezesPayaso = new PezPayaso[]{pezPayasoHembra, pezPayasoMacho};

        parejas.put("Pezes payaso", pezesPayaso);

        for (Map.Entry<String, Animal[]> pareja: parejas.entrySet()) {

            System.out.println("---" + pareja.getKey() + "---");

            System.out.println(pareja.getValue()[0]);
            System.out.println(pareja.getValue()[1]);

        }

    }
}
