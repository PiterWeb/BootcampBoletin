package org.boletin.ej21.main;

import org.boletin.ej21.clases.*;
import org.campusdual.util.Input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Ej21 {

    public static ArrayList<Animal> animales = new ArrayList<Animal>();

    public static void main(String[] args) {

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
                String sexo = valores[2];
                String tipo = valores[3];
                String propietario = valores[4];
                //String reino = valores[5];
                String raza = valores[6];
                //String medio = valores[7];
                int cria1 = valores[8].equals("") ? -1 : Integer.parseInt(valores[8]);
                int cria2 = valores[9].equals("") ? -1 : Integer.parseInt(valores[9]);
                int cria3 = valores[10].equals("") ? -1 : Integer.parseInt(valores[10]);

                int[] crias = {cria1, cria2, cria3};

                int ncrias = Integer.parseInt(valores[11]);

                Animal animal = null;

                if (!nombre.equals("")) {

                    if (tipo.equalsIgnoreCase("perro"))
                        animal = new Perro(raza, nombre, propietario, sexo);


                    if (tipo.equalsIgnoreCase("gato"))
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

                    if (tipo.equalsIgnoreCase("vaca"))
                        animal = new Vaca(raza, propietario, sexo);

                    if (tipo.equalsIgnoreCase("oveja"))
                        animal = new Oveja(raza, propietario, sexo);

                    if (animal != null) {
                        animal.setNumeroCrias(ncrias);
                        animal.setCrias(crias);
                        animal.setId(id);
                        animales.add(animal);
                    }

                    continue;
                }

                if (tipo.equalsIgnoreCase("tucan"))
                    animal = new Tucan(raza, sexo);

                if (tipo.equalsIgnoreCase("pezpayaso"))
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

        for (Animal a: animales) asignarPadres(a);

        int id = Input.integer("Introduce el ID de un animal para conocer sus antepasados: ");

        ArrayList<Animal> antepasados = null;

        for (Animal a : animales) {
            if (a.getId() == id) {
                antepasados = a.obtenerAntepasados();
                break;
            }
        }

        if (antepasados == null) return;

        for (Animal antepasado: antepasados) {
            System.out.println(antepasado);
        }


    }

    public static void asignarPadres(Animal animal) {

        if (animal.getPadres()[0] != null && animal.getPadres()[1] != null) return;

        int id = animal.getId();

        for (Animal a: animales) {

            if (Arrays.stream(a.getCrias()).noneMatch(cria -> id == cria)) continue;

            if (animal.getPadres()[0] == null) animal.setPadres(new Animal[]{a, null});
            else if (animal.getPadres()[1] == null) animal.setPadres(new Animal[]{animal.getPadres()[0], a});

        }

    }

//    public static ArrayList<Animal> obtenerAntepasados(Animal animal) {
//
//        ArrayList<Animal> antepasados = new ArrayList<Animal>();
//        int id = animal.getId();
//
//        for (Animal a: animales) {
//
//            if (Arrays.stream(a.getCrias()).noneMatch(cria -> id == cria)) continue;
//
//            antepasados.add(a);
//            antepasados.addAll(obtenerAntepasados(a));
//
//        }
//
//        return antepasados;
//
//    }

}
