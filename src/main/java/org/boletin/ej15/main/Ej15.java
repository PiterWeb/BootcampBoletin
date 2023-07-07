package org.boletin.ej15.main;

import org.boletin.ej11.clases.Tipo;
import org.boletin.ej13.clases.Animal;
import org.boletin.ej13.clases.AnimalGranja;
import org.boletin.ej13.clases.AnimalSalvaje;
import org.boletin.ej13.clases.Mascota;
import org.boletin.ej14.clases.*;

import java.util.HashMap;
import java.util.Map;

public class Ej15 {

    public static HashMap<Tipo, AnimalSalvaje[]> parejasSalvajes = new HashMap<>();
    public static HashMap<Tipo, Mascota[]> parejasMascotas = new HashMap<>();
    public static HashMap<Tipo, AnimalGranja[]> parejasGranja = new HashMap<>();

    public static void main(String[] args) {

        HashMap<Tipo, Animal[]> parejas = new HashMap<>(ParejasAnimales.getLista());

        for (Map.Entry<Tipo, Animal[]> parejaEntry: parejas.entrySet()) {

            Tipo tipo = parejaEntry.getKey();
            Animal[] pareja = parejaEntry.getValue();

            if (pareja.length == 0) continue;

            if (pareja[0] == null || pareja[1] == null) continue;

            if (pareja[0] instanceof AnimalSalvaje)
                parejasSalvajes.put(tipo, (AnimalSalvaje[]) pareja);

            if (pareja[0] instanceof AnimalGranja)
                parejasGranja.put(tipo, ((AnimalGranja[]) pareja));

            if (pareja[0] instanceof Mascota)
                parejasMascotas.put(tipo, ((Mascota[]) pareja));

        }

        System.out.println("[Parejas Salvajes]");
        for (Map.Entry<Tipo, AnimalSalvaje[]> pareja: parejasSalvajes.entrySet()) {

            System.out.println("---" + pareja.getKey() + "---");

            System.out.println(pareja.getValue()[0]);
            System.out.println(pareja.getValue()[1]);

        }

        System.out.println("[Parejas Mascotas]");
        for (Map.Entry<Tipo, Mascota[]> pareja: parejasMascotas.entrySet()) {

            System.out.println("---" + pareja.getKey() + "---");

            System.out.println(pareja.getValue()[0]);
            System.out.println(pareja.getValue()[1]);

        }

        System.out.println("[Parejas Granja]");
        for (Map.Entry<Tipo, AnimalGranja[]> pareja: parejasGranja.entrySet()) {

            System.out.println("---" + pareja.getKey() + "---");

            System.out.println(pareja.getValue()[0]);
            System.out.println(pareja.getValue()[1]);

        }

    }
}
