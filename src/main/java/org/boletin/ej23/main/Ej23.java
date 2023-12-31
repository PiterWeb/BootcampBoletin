package org.boletin.ej23.main;


import org.boletin.ej13.clases.*;
import org.boletin.ej16.clases.ListaAnimales;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;

public class Ej23 {

    public static void main(String[] args) {

        final ArrayList<Animal> animales = ListaAnimales.reproducirAnimales();

        for (Animal a : animales) System.out.println(a);

        try {
            PrintWriter pw = new PrintWriter("animales.json");

            pw.println("[");

            String linea = "";

            Animal a;

            final String sigProp = "\",\n";

            for (int i = 0; i < animales.size(); i++) {

                a = animales.get(i);

                linea += "{\n";

                linea += "\"id\": " + a.getId() + ",\n";
                if (a instanceof Mascota) linea += "\"nombre\": \"" + (((Mascota) a).getNombre()) + sigProp;

                linea += "\"sexo\": \"" + a.getSexo() + sigProp + "\"tipo\": \"" + a.getTipo() + sigProp;

                if (a instanceof AnimalGranja)
                    linea += "\"propietario\": \"" + ((AnimalGranja) a).getPropietario() + sigProp;
                else if (a instanceof Mascota)
                    linea += "\"propietario\": \"" + ((Mascota) a).getPropietario() + sigProp;

                linea += "\"reino\": \"" + a.getReino() + sigProp + "\"raza\": \"" + a.getRaza() + sigProp + "\"medio\": \"" + a.getMedio() + sigProp;

                linea += "\"numero_crias\": " + a.getNumeroCrias() + ",\n";

                if (a.getPadre() != null && a.getMadre() != null) {
                    linea += "\"padre\": " + a.getPadre().getId() + ",\n";
                    linea += "\"madre\": " + a.getMadre().getId() + ",\n";
                } else {
                    linea += "\"padre\": " + null + ",\n";
                    linea += "\"madre\": " + null + ",\n";
                }

                linea += "\"crias\": [\n";

                for (int j = 0; j < a.getNumeroCrias(); j++) {

                    int cria = a.getCrias().get(j);

                    if (j + 1 == a.getNumeroCrias())
                        linea += "\t" + cria + "\n";
                    else linea += "\t" + cria + ",\n";

                }


                linea += "]\n";

                linea += "}";

                if (i + 1 != animales.size()) linea += ",\n";

                pw.println(linea);

                linea = "";

            }

            pw.println("]");

            pw.close();

        } catch (FileNotFoundException err) {
            err.printStackTrace();
            System.out.println("No se puede escribir en el archivo csv");
        }

    }


}
