package org.boletin.ej13.clases;

public abstract class AnimalSalvaje extends Animal {


    public AnimalSalvaje(String reino, String tipo, String raza, String medio) {
        super(reino, tipo, raza, medio);
    }

    public AnimalSalvaje(Animal animal) {
        super(animal);
    }

    @Override
    public String toString() {
        return super.toString() + " { salvaje }";
    }
}
