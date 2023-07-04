package org.boletin.ej17;

public abstract class AnimalSalvaje extends Animal {


    public AnimalSalvaje(String reino, String tipo, String raza, String medio, String sexo) {
        super(reino, tipo, raza, medio, sexo);
    }

    public AnimalSalvaje(Animal animal) {
        super(animal);
    }

    @Override
    public String toString() {
        return super.toString() + " { salvaje }";
    }
}
