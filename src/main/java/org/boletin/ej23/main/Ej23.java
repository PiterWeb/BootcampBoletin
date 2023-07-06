package org.boletin.ej23.main;

import org.boletin.ej14.clases.Sexo;
import org.boletin.ej22.clases.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Ej23 {
    public static ArrayList<Animal> animales = new ArrayList<>();

    public static void main(String[] args) {

        Perro perroMacho = new Perro("Boxer", "Piplo", "Manolo", Sexo.Macho);
        Perro perroHembra = new Perro("Pug", "Dori", "Pedro", Sexo.Hembra);

        Perro[] perros = new Perro[]{perroHembra, perroMacho};

        animales.addAll(Arrays.asList(perros));

        Gato gatoMacho = new Gato("Siames", "Trosky", "Pedro", Sexo.Macho);
        Gato gatoHembra = new Gato("Egipcio", "Olga", "Manolo", Sexo.Hembra);

        Gato[] gatos = new Gato[]{gatoHembra, gatoMacho};

        animales.addAll(Arrays.asList(gatos));

        Granjero manolo = new Granjero("Manolo");
        Granjero pedro = new Granjero("Pedro");

        Vaca vacaMacho = new Vaca("Gallega", manolo, Sexo.Macho);
        Vaca vacaHembra = new Vaca("Astuariana", pedro, Sexo.Hembra);
        Vaca vacaOtro = new Vaca("Vasca", pedro, Sexo.Hembra);

        Vaca[] vacas = new Vaca[]{vacaHembra, vacaMacho, vacaOtro};

        animales.addAll(Arrays.asList(vacas));

        Tucan tucanMacho = new Tucan("Azul", Sexo.Macho);
        Tucan tucanHembra = new Tucan("Rojo", Sexo.Hembra);

        Tucan[] tucanes = new Tucan[]{tucanHembra, tucanMacho};

        animales.addAll(Arrays.asList(tucanes));

        Oveja ovejaMacho = new Oveja("Gallega", pedro, Sexo.Macho);
        Oveja ovejaHembra = new Oveja("Vasca", manolo, Sexo.Hembra);

        Oveja[] ovejas = new Oveja[]{ovejaHembra, ovejaMacho};

        animales.addAll(Arrays.asList(ovejas));

        PezPayaso pezPayasoMacho = new PezPayaso("atlantico", Sexo.Macho);
        PezPayaso pezPayasoHembra = new PezPayaso("pacífico", Sexo.Hembra);

        PezPayaso[] pezesPayaso = new PezPayaso[]{pezPayasoHembra, pezPayasoMacho};

        animales.addAll(Arrays.asList(pezesPayaso));

        ArrayList<Animal> animalesTemporales;

        for (int i = 0; i < 4; i++) {

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

                int cria1 = a.getCrias()[0];
                int cria2 = a.getCrias()[1];
                int cria3 = a.getCrias()[2];

                linea += "\"reino\": \"" + a.getReino() + sigProp + "\"raza\": \"" + a.getRaza() + sigProp + "\"medio\": \"" + a.getMedio() + sigProp;

                linea += "\"numero_crias\": " + a.getNumeroCrias() + ",\n";

                linea += "\"crias\": [\n";

                if (cria1 != -1)
                    linea += "\t" + cria1 + ",\n";
                if (cria2 != 1)
                    linea += "\t" + cria2 + ",\n";
                if (cria3 != 1)
                    linea += "\t" + cria3 + "\n";

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
