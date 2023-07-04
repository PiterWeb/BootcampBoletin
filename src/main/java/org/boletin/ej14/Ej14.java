package org.boletin.ej14;

import java.util.HashMap;
import java.util.Map;

public class Ej14 {

    public static HashMap<String, Animal[]> parejas = new HashMap<String, Animal[]>();
    public static void main(String[] args) {

        Perro perroMacho = new Perro("Boxer", "Piplo", "Manolo", "macho");
        Perro perroHembra = new Perro("Pug", "Dori", "Pedro", "hembra");

        Perro[] perros = new Perro[]{perroHembra, perroMacho};

        parejas.put("Perros", perros);

        Gato gatoMacho = new Gato("Siames", "Trosky", "Pedro", "macho");
        Gato gatoHembra = new Gato("Egipcio", "Olga", "Manolo", "hembra");

        Gato[] gatos = new Gato[]{gatoHembra, gatoMacho};

        parejas.put("Gatos", gatos);

        Vaca vacaMacho = new Vaca("Gallega", "Manolo", "macho");
        Vaca vacaHembra = new Vaca("Astuariana", "Pedro", "hembra");

        Vaca[] vacas = new Vaca[]{vacaHembra, vacaMacho};

        parejas.put("Vacas", vacas);

        Tucan tucanMacho = new Tucan("Azul", "macho");
        Tucan tucanHembra = new Tucan("Rojo", "hembra");

        Tucan[] tucanes = new Tucan[]{tucanHembra, tucanMacho};

        parejas.put("Tucanes", tucanes);

        Oveja ovejaMacho = new Oveja("Gallega", "Pedro", "macho");
        Oveja ovejaHembra = new Oveja("Vasca", "Manolo", "hembra");

        Oveja[] ovejas = new Oveja[]{ovejaHembra, ovejaMacho};

        parejas.put("Ovejas", ovejas);

        PezPayaso pezPayasoMacho = new PezPayaso("atlantico", "macho");
        PezPayaso pezPayasoHembra = new PezPayaso("pacífico", "hembra");

        PezPayaso[] pezesPayaso = new PezPayaso[]{pezPayasoHembra, pezPayasoMacho};

        parejas.put("Pezes payaso", pezesPayaso);

        for (Map.Entry<String, Animal[]> pareja: parejas.entrySet()) {

            System.out.println("---" + pareja.getKey() + "---");

            System.out.println(pareja.getValue()[0]);
            System.out.println(pareja.getValue()[1]);

        }

    }
}
