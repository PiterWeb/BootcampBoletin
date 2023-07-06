package org.boletin.ej22.clases;

import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;
import org.boletin.ej14.clases.Sexo;

public abstract class AnimalSalvaje extends Animal {


    public AnimalSalvaje(Reino reino, Tipo tipo, String raza, Medio medio, Sexo sexo) {
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
