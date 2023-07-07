package org.boletin.ej20.clases;

import org.boletin.ej13.clases.Animal;
import org.boletin.ej13.clases.Sexo;

import java.util.List;

public class CriaUtils {

    public static void asignarPadres(List<Animal> animales) {

        for (Animal animal : animales) {

            if (animal.getPadre() != null && animal.getMadre() != null) return;

            int id = animal.getId();

            for (Animal a : animales) {

                if (a.getCrias().stream().noneMatch(cria -> id == cria)) continue;

                if (a.getSexo() == Sexo.MACHO && animal.getPadre() == null)
                    animal.setPadre(a);
                else if (a.getSexo() == Sexo.HEMBRA && animal.getMadre() == null)
                    animal.setMadre(a);

            }
        }


    }
}
