package org.boletin.ej21.main;

import org.boletin.ej13.clases.*;
import org.boletin.ej19.clases.CSVUtils;
import org.campusdual.util.Input;

import java.util.ArrayList;

public class Ej21 {

    public static ArrayList<Animal> animales = new ArrayList<Animal>();

    public static void main(String[] args) {

        animales.addAll(CSVUtils.obtenerAnimales());

        while (true) {

            int id = Input.integer("Introduce el ID de un animal para conocer sus antepasados: ");

            ArrayList<Animal> antepasados = null;

            for (Animal a : animales) {
                if (a.getId() == id) {
                    antepasados = a.obtenerAntepasados();
                    break;
                }
            }

            if (antepasados == null) return;

            System.out.println("--- Antepasados del ID (" + id + ") ---");

            for (Animal antepasado : antepasados) {
                System.out.println(antepasado);
            }

            char c = Input.character("Introduzca una \"s\" para salir o una otra letra cualquiera para continuar");

            if (c == 's' || c == 'S') break;

        }


    }

}
