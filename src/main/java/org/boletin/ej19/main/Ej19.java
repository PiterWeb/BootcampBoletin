package org.boletin.ej19.main;

import org.boletin.ej13.clases.*;
import org.boletin.ej16.clases.ListaAnimales;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Ej19 {

    public static void main(String[] args) {

        final ArrayList<Animal> animales = ListaAnimales.getLista();

        ArrayList<Animal> animalesTemporales;

        for (int i = 0; i < 3; i++) {

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

            pw.print("ID ,NOMBRE ,SEXO ,TIPO, PROPIETARIO,REINO, RAZA, MEDIO, PADRE, MADRE ,NCRIAS, ");

            int maxCria = animales.stream().mapToInt(Animal::getNumeroCrias).max().orElse(-1);

            for (int i = 1; i <= maxCria; i++) {
                if (i == maxCria)
                    pw.print("CRIA_" + i);
                else
                    pw.print("CRIA_" + i + ",");
            }
            pw.println();

            String linea = "";

            for (Animal a : animales) {

                linea += a.getId() + " ,";
                if (a instanceof Mascota) linea += (((Mascota) a).getNombre()) + " ,";
                else linea += " ,";

                linea += a.getSexo() + " ," + a.getTipo() + " ,";

                if (a instanceof AnimalGranja) linea += ((AnimalGranja) a).getPropietario() + " ,";
                else if (a instanceof Mascota) linea += ((Mascota) a).getPropietario() + " ,";
                else linea += " ,";

                linea += a.getReino() + " ," + a.getRaza() + " ," + a.getMedio() + " ,";
                if (a.getMadre() != null && a.getPadre() != null)
                    linea += a.getPadre().getId() + " ," + a.getMadre().getId() + " ,";
                else
                    linea += ",,";

                linea += a.getNumeroCrias() + " ,";

                for (int i = 0; i < a.getNumeroCrias(); i++) {

                    int cria = a.getCrias().get(i);

                    if (i + 1 == a.getNumeroCrias())
                        linea += cria;
                    else
                        linea += cria + " ,";

                }


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
