package org.boletin.ej12;

public class AnimalSalvaje extends Animal {

    public AnimalSalvaje(Animal animal) {
        super(animal);
    }

    @Override
    public String toString() {
        return super.toString() + " { Salvaje }";
    }
}
