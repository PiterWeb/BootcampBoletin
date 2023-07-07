package org.boletin.ej20.clases;

import org.boletin.ej11.clases.Tipo;
import org.boletin.ej13.clases.*;
import org.boletin.ej21.clases.CriaUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LeerCSV {

    private static ArrayList<Animal> animales = new ArrayList<>();

    public static ArrayList<Animal> obtenerAnimales() {
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

                String[] valores = linea.split(" ,");

                int id = Integer.parseInt(valores[0]);
                String nombre = valores[1];
                Sexo sexo = Sexo.valueOf(valores[2]);
                Tipo tipo = Tipo.valueOf(valores[3]);
                String propietario = valores[4];
                //String reino = valores[5];
                String raza = valores[6];
                //String medio = valores[7];

                ArrayList<Integer> crias = new ArrayList<>();

                for (int j = 0; j < valores.length - 9; j++) {

                    try {
                        crias.add(Integer.parseInt(valores[j+9]));
                    } catch (Exception e) {
                        break;
                    }

                }

                int ncrias = Integer.parseInt(valores[8]);

                Animal animal = null;

                if (!nombre.equals("")) {

                    if (tipo == Tipo.PERRO)
                        animal = new Perro(raza, nombre, propietario, sexo);


                    if (tipo == Tipo.GATO)
                        animal = new Gato(raza, nombre, propietario, sexo);

                    if (animal != null) {
                        animal.setNumeroCrias(ncrias);
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
                        animal.setNumeroCrias(ncrias);
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
                    animal.setNumeroCrias(ncrias);
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
