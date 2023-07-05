package org.boletin.ej22.clases;

import java.util.ArrayList;

public class Granjero {

    private final String nombre;
    private ArrayList<Integer> animales = new ArrayList<Integer>();

    public Granjero(String nombre) {
        this.nombre = nombre;
    }

    public Granjero(String nombre, ArrayList<Integer> animales) {
        this.nombre = nombre;
        this.animales = animales;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Integer> getAnimales() {
        return animales;
    }

    public void addAnimal(AnimalGranja animalGranja) {
        animales.add(animalGranja.getId());
    }

}
