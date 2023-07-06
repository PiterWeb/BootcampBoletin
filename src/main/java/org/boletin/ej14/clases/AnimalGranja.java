package org.boletin.ej14.clases;

import org.boletin.ej11.clases.ITienePropietario;
import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;

public abstract class AnimalGranja extends Animal implements ITienePropietario {

    private String propietario;

    public AnimalGranja(Animal animal, String propietario) {
        super(animal);
        this.propietario = propietario;
    }

    public AnimalGranja(Reino reino, Tipo tipo, String raza, Medio medio, String propietario, Sexo sexo) {
        super(reino, tipo, raza, medio, sexo);
        this.propietario = propietario;
    }

    public AnimalGranja(AnimalGranja animalGranja) {
        super(animalGranja);
        this.propietario = animalGranja.propietario;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return super.toString() + " { propietario : " + propietario + " }";
    }
}
