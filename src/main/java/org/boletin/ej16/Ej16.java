package org.boletin.ej16;

import java.util.*;

public class Ej16 {

    public static HashMap<String, AnimalSalvaje[]> parejasSalvajes = new HashMap<String, AnimalSalvaje[]>();
    public static HashMap<String, Mascota[]> parejasMascotas = new HashMap<String, Mascota[]>();
    public static HashMap<String, AnimalGranja[]> parejasGranja = new HashMap<String, AnimalGranja[]>();

    public static ArrayList<Animal> animales = new ArrayList<Animal>();

    public static void main(String[] args) {

        Perro perroMacho = new Perro("Boxer", "Piplo", "Manolo", "macho");
        Perro perroHembra = new Perro("Pug", "Dori", "Pedro", "hembra");

        Perro[] perros = new Perro[]{perroHembra, perroMacho};

        animales.addAll(Arrays.asList(perros));

        parejasMascotas.put("Perros", perros);

        Gato gatoMacho = new Gato("Siames", "Trosky", "Pedro", "macho");
        Gato gatoHembra = new Gato("Egipcio", "Olga", "Manolo", "hembra");

        Gato[] gatos = new Gato[]{gatoHembra, gatoMacho};

        animales.addAll(Arrays.asList(gatos));

        parejasMascotas.put("Gatos", gatos);

        Vaca vacaMacho = new Vaca("Gallega", "Manolo", "macho");
        Vaca vacaHembra = new Vaca("Astuariana", "Pedro", "hembra");

        Vaca[] vacas = new Vaca[]{vacaHembra, vacaMacho};

        animales.addAll(Arrays.asList(vacas));

        parejasGranja.put("Vacas", vacas);

        Tucan tucanMacho = new Tucan("Azul", "macho");
        Tucan tucanHembra = new Tucan("Rojo", "hembra");

        Tucan[] tucanes = new Tucan[]{tucanHembra, tucanMacho};

        animales.addAll(Arrays.asList(tucanes));

        parejasSalvajes.put("Tucanes", tucanes);

        Oveja ovejaMacho = new Oveja("Gallega", "Pedro", "macho");
        Oveja ovejaHembra = new Oveja("Vasca", "Manolo", "hembra");

        Oveja[] ovejas = new Oveja[]{ovejaHembra, ovejaMacho};

        //Oveja ovejaExtra = new Oveja("Vasca", "Josefa", "macho");
        //animales.add(ovejaExtra);

        animales.addAll(Arrays.asList(ovejas));

        parejasGranja.put("Ovejas", ovejas);

        PezPayaso pezPayasoMacho = new PezPayaso("atlantico", "macho");
        PezPayaso pezPayasoHembra = new PezPayaso("pacífico", "hembra");

        PezPayaso[] pezesPayaso = new PezPayaso[]{pezPayasoHembra, pezPayasoMacho};

        animales.addAll(Arrays.asList(pezesPayaso));

        parejasSalvajes.put("Pezes payaso", pezesPayaso);

        for (int i = 0; i < animales.size(); i++) {

            Animal animal1 = animales.get(i);

            if (animal1 == null) continue;

            for (int j = 0; j < animales.size(); j++) {

                Animal animal2 = animales.get(j);

                if (animal2 == null) continue;

                Optional<Animal> cria = animal1.addCria(animal2);

                cria.ifPresent((c) -> {
                    animales.add(cria.get());
                });

            }

        }

        for (Animal a : animales)
            System.out.println(a);


        System.out.println("[Parejas Salvajes]");
        for (Map.Entry<String, AnimalSalvaje[]> pareja : parejasSalvajes.entrySet()) {

            System.out.println("---" + pareja.getKey() + "---");

            System.out.println(pareja.getValue()[0]);
            System.out.println(pareja.getValue()[1]);

        }

        System.out.println("[Parejas Mascotas]");
        for (Map.Entry<String, Mascota[]> pareja : parejasMascotas.entrySet()) {

            System.out.println("---" + pareja.getKey() + "---");

            System.out.println(pareja.getValue()[0]);
            System.out.println(pareja.getValue()[1]);

        }

        System.out.println("[Parejas Granja]");
        for (Map.Entry<String, AnimalGranja[]> pareja : parejasGranja.entrySet()) {

            System.out.println("---" + pareja.getKey() + "---");

            System.out.println(pareja.getValue()[0]);
            System.out.println(pareja.getValue()[1]);

        }

    }

}
