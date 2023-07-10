package org.boletin.ej19.clases;

import org.boletin.ej11.clases.ITienePropietario;
import org.boletin.ej11.clases.Tipo;
import org.boletin.ej13.clases.*;
import org.boletin.ej20.clases.CriaUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVUtils {

    public static void escribirAnimales(ArrayList<Animal> animales) {
        try {
            PrintWriter pw = new PrintWriter("animales.csv");

            pw.print("ID,NOMBRE,SEXO,TIPO,PROPIETARIO,REINO,RAZA,MEDIO,PADRE,MADRE,NCRIAS,");

            int maxCria = animales.stream().mapToInt(org.boletin.ej13.clases.Animal::getNumeroCrias).max().orElse(-1);

            for (int i = 1; i <= maxCria; i++) {
                if (i == maxCria)
                    pw.print("CRIA_" + i);
                else
                    pw.print("CRIA_" + i + ",");
            }
            pw.println();

            String linea = "";

            for (Animal a : animales) {

                linea += a.getId() + ",";
                if (a instanceof Mascota) linea += (((Mascota) a).getNombre()) + ",";
                else linea += ",";

                linea += a.getSexo() + "," + a.getTipo() + " ,";

                if (a instanceof ITienePropietario) linea += ((ITienePropietario) a).getPropietario() + ",";
                else linea += " ,";

                linea += a.getReino() + "," + a.getRaza() + "," + a.getMedio() + ",";
                if (a.getMadre() != null && a.getPadre() != null)
                    linea += a.getPadre().getId() + "," + a.getMadre().getId() + ",";
                else
                    linea += ",,";

                linea += a.getNumeroCrias() + ",";

                for (int i = 0; i < a.getNumeroCrias(); i++) {

                    int cria = a.getCrias().get(i);

                    if (i + 1 == a.getNumeroCrias())
                        linea += cria;
                    else
                        linea += cria + ",";

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

    public static ArrayList<Animal> obtenerAnimales() {

        ArrayList<Animal> animales = new ArrayList<>();

        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader("animales.csv"));

            String linea = "";
            int i = 0;

            while ((linea = br.readLine()) != null) {

                if (i == 0) {
                    i++;
                    continue;
                }

                String[] valores = linea.trim().split(",");

                int id = Integer.parseInt(valores[0]);
                String nombre = valores[1];
                Sexo sexo = Sexo.valueOf(valores[2]);
                Tipo tipo = Tipo.valueOf(valores[3]);
                String propietario = valores[4];
                //String reino = valores[5];
                String raza = valores[6];
                //String medio = valores[7];
                //String padreId = valores[8];
                //String madreId = valores[9];

                ArrayList<Integer> crias = new ArrayList<>();

                final int criasPostion = 11;

                for (int j = 0; j < valores.length - criasPostion; j++) {

                    try {
                        crias.add(Integer.parseInt(valores[j + criasPostion]));
                    } catch (Exception e) {
                        break;
                    }

                }

                int nCrias = Integer.parseInt(valores[criasPostion - 1]);

                Animal animal = null;

                if (!nombre.equals("")) {

                    if (tipo == Tipo.PERRO)
                        animal = new Perro(raza, nombre, propietario, sexo);


                    if (tipo == Tipo.GATO)
                        animal = new Gato(raza, nombre, propietario, sexo);

                    if (animal != null) {
                        animal.setNumeroCrias(nCrias);
                        animal.setCrias(crias);
                        animal.setId(id);
                        animales.add(animal);
                    }

                    continue;
                }

                if (!propietario.equals("")) {

                    if (tipo == Tipo.VACA)
                        animal = new Vaca(raza, propietario, sexo);

                    if (tipo == Tipo.OVEJA)
                        animal = new Oveja(raza, propietario, sexo);

                    if (animal != null) {
                        animal.setNumeroCrias(nCrias);
                        animal.setCrias(crias);
                        animal.setId(id);
                        animales.add(animal);
                    }

                    continue;
                }

                if (tipo == Tipo.TUCAN)
                    animal = new Tucan(raza, sexo);

                if (tipo == Tipo.PEZ_PAYASO)
                    animal = new PezPayaso(raza, sexo);

                if (animal != null) {
                    animal.setNumeroCrias(nCrias);
                    animal.setCrias(crias);
                    animal.setId(id);
                    animales.add(animal);
                }

            }

        } catch (Exception err) {
            err.printStackTrace();
            System.out.println("No se puede escribir en el archivo csv");
        } finally {

            try {

                if (br != null) br.close();

            } catch (Exception err2) {
                err2.printStackTrace();
            }

        }

        CriaUtils.asignarPadres(animales);

        return animales;
    }
}
