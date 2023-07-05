package org.boletin.ej19.main;

import org.boletin.ej19.clases.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Ej19 {

    public static ArrayList<Animal> animales = new ArrayList<Animal>();

    public static void main(String[] args) {

        Perro perroMacho = new Perro("Boxer", "Piplo", "Manolo", "macho");
        Perro perroHembra = new Perro("Pug", "Dori", "Pedro", "hembra");
        Perro perroOtro = new Perro("Shiba inu", "Kota", "Pedro", "macho");

        Perro[] perros = new Perro[]{perroHembra, perroMacho, perroOtro};

        animales.addAll(Arrays.asList(perros));

        Gato gatoMacho = new Gato("Siames", "Trosky", "Pedro", "macho");
        Gato gatoHembra = new Gato("Egipcio", "Olga", "Manolo", "hembra");

        Gato[] gatos = new Gato[]{gatoHembra, gatoMacho};

        animales.addAll(Arrays.asList(gatos));

        Vaca vacaMacho = new Vaca("Gallega", "Manolo", "macho");
        Vaca vacaHembra = new Vaca("Astuariana", "Pedro", "hembra");

        Vaca[] vacas = new Vaca[]{vacaHembra, vacaMacho};

        animales.addAll(Arrays.asList(vacas));

        Tucan tucanMacho = new Tucan("Azul", "macho");
        Tucan tucanHembra = new Tucan("Rojo", "hembra");

        Tucan[] tucanes = new Tucan[]{tucanHembra, tucanMacho};

        animales.addAll(Arrays.asList(tucanes));

        Oveja ovejaMacho = new Oveja("Gallega", "Pedro", "macho");
        Oveja ovejaHembra = new Oveja("Vasca", "Manolo", "hembra");

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

        try {
            PrintWriter pw = new PrintWriter("animales.csv");

            pw.println("ID ,NOMBRE ,SEXO ,TIPO, PROPIETARIO,REINO, RAZA, MEDIO, CRIA1, CRIA2, CRIA3, NCRIAS");

            String linea = "";

            for (Animal a : animales) {

                linea += a.getId() + " ,";
                if (a instanceof Mascota) linea += (((Mascota) a).getNombre()) + " ,";
                else linea += " ,";

                linea += a.getSexo() + " ," + a.getTipo() + " ,";

                if (a instanceof AnimalGranja) linea += ((AnimalGranja) a).getPropietario() + " ,";
                else if (a instanceof Mascota) linea += ((Mascota) a).getPropietario() + " ,";
                else linea += " ,";



                String cria1 = a.getCrias()[0] == -1 ? "" : Integer.toString(a.getCrias()[0]);
                String cria2 = a.getCrias()[1] == -1 ? "" : Integer.toString(a.getCrias()[1]);
                String cria3 = a.getCrias()[2] == -1 ? "" : Integer.toString(a.getCrias()[2]);

                linea += a.getReino() + " ," + a.getRaza() + " ," + a.getMedio() + " ,";
                linea += cria1 + " ," + cria2 + " ," + cria3 + " ," + a.getNumeroCrias();

                pw.println(linea);

                linea = "";

            }

            pw.close();

        } catch (FileNotFoundException err) {
            err.printStackTrace();
            System.out.println("No se puede escribir en el archivo csv");
        }


    }

}
