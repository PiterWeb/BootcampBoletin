package org.boletin.ej14.clases;

import org.boletin.ej11.clases.Tipo;
import org.boletin.ej13.clases.*;

import java.util.HashMap;

public class ParejasAnimales {

    private final static HashMap<Tipo, Animal[]> parejas = new HashMap<>();
    public  static HashMap<Tipo, Animal[]> getLista() {

        Perro perroMacho = new Perro("Boxer", "Piplo", "Manolo", Sexo.MACHO);
        Perro perroHembra = new Perro("Pug", "Dori", "Pedro", Sexo.HEMBRA);

        Perro[] perros = new Perro[]{perroHembra, perroMacho};

        parejas.put(Tipo.PERRO, perros);

        Gato gatoMacho = new Gato("Siames", "Trosky", "Pedro", Sexo.MACHO);
        Gato gatoHembra = new Gato("Egipcio", "Olga", "Manolo", Sexo.HEMBRA);

        Gato[] gatos = new Gato[]{gatoHembra, gatoMacho};

        parejas.put(Tipo.GATO, gatos);

        Vaca vacaMacho = new Vaca("Gallega", "Manolo", Sexo.MACHO);
        Vaca vacaHembra = new Vaca("Astuariana", "Pedro", Sexo.HEMBRA);

        Vaca[] vacas = new Vaca[]{vacaHembra, vacaMacho};

        parejas.put(Tipo.VACA, vacas);

        Tucan tucanMacho = new Tucan("Azul", Sexo.MACHO);
        Tucan tucanHembra = new Tucan("Rojo", Sexo.HEMBRA);

        Tucan[] tucanes = new Tucan[]{tucanHembra, tucanMacho};

        parejas.put(Tipo.TUCAN, tucanes);

        Oveja ovejaMacho = new Oveja("Gallega", "Pedro", Sexo.MACHO);
        Oveja ovejaHembra = new Oveja("Vasca", "Manolo", Sexo.HEMBRA);

        Oveja[] ovejas = new Oveja[]{ovejaHembra, ovejaMacho};

        parejas.put(Tipo.OVEJA, ovejas);

        PezPayaso pezPayasoMacho = new PezPayaso("atlantico", Sexo.MACHO);
        PezPayaso pezPayasoHembra = new PezPayaso("pacífico", Sexo.HEMBRA);

        PezPayaso[] pezesPayaso = new PezPayaso[]{pezPayasoHembra, pezPayasoMacho};

        parejas.put(Tipo.PEZ_PAYASO, pezesPayaso);

        return parejas;

    }

}
