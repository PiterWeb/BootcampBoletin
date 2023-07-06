package org.boletin.ej19.main;

import org.boletin.ej14.clases.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Ej19 {

    public static ArrayList<Animal> animales = new ArrayList<Animal>();

    public static void main(String[] args) {

        Perro perroMacho = new Perro("Boxer", "Piplo", "Manolo", Sexo.Macho);
        Perro perroHembra = new Perro("Pug", "Dori", "Pedro", Sexo.Hembra);
        Perro perroOtro = new Perro("Shiba inu", "Kota", "Pedro", Sexo.Macho);

        Perro[] perros = new Perro[]{perroHembra, perroMacho, perroOtro};

        animales.addAll(Arrays.asList(perros));

        Gato gatoMacho = new Gato("Siames", "Trosky", "Pedro", Sexo.Macho);
        Gato gatoHembra = new Gato("Egipcio", "Olga", "Manolo", Sexo.Hembra);

        Gato[] gatos = new Gato[]{gatoHembra, gatoMacho};

        animales.addAll(Arrays.asList(gatos));

        Vaca vacaMacho = new Vaca("Gallega", "Manolo", Sexo.Macho);
        Vaca vacaHembra = new Vaca("Astuariana", "Pedro", Sexo.Hembra);

        Vaca[] vacas = new Vaca[]{vacaHembra, vacaMacho};

        animales.addAll(Arrays.asList(vacas));

        Tucan tucanMacho = new Tucan("Azul", Sexo.Macho);
        Tucan tucanHembra = new Tucan("Rojo", Sexo.Hembra);

        Tucan[] tucanes = new Tucan[]{tucanHembra, tucanMacho};

        animales.addAll(Arrays.asList(tucanes));

        Oveja ovejaMacho = new Oveja("Gallega", "Pedro", Sexo.Macho);
        Oveja ovejaHembra = new Oveja("Vasca", "Manolo", Sexo.Hembra);

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
