package org.boletin.ej14.main;

import org.boletin.ej11.clases.Tipo;
import org.boletin.ej13.clases.Animal;
import org.boletin.ej14.clases.*;

import java.util.HashMap;
import java.util.Map;

public class Ej14 {
    public static void main(String[] args) {

        HashMap<Tipo, Animal[]> parejas = new HashMap<>(ParejasAnimales.getLista());

        for (Map.Entry<Tipo, Animal[]> pareja: parejas.entrySet()) {

            System.out.println("---" + pareja.getKey() + "---");

            System.out.println(pareja.getValue()[0]);
            System.out.println(pareja.getValue()[1]);

        }

    }
}
