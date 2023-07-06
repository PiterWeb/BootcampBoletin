package org.boletin.ej22.clases;

import org.boletin.ej11.clases.ITienePropietario;
import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;
import org.boletin.ej14.clases.Sexo;

public abstract class AnimalGranja extends Animal implements ITienePropietario {

    private Granjero propietario;

    public AnimalGranja(Animal animal, Granjero propietario) {
        super(animal);
        this.propietario = propietario;
    }

    public AnimalGranja(Reino reino, Tipo tipo, String raza, Medio medio, Granjero propietario, Sexo sexo) {
        super(reino, tipo, raza, medio, sexo);
        this.propietario = propietario;
    }

    public AnimalGranja(AnimalGranja animalGranja) {
        super(animalGranja);
        this.propietario = animalGranja.propietario;
    }

    public String getPropietario() {
        return propietario.getNombre();
    }

    public void setPropietario(Granjero propietario) {
        propietario.addAnimal(this);
        this.propietario = propietario;
    }
    public void setPropietario(String propietario) {
        Granjero granjero = new Granjero(propietario);
        granjero.addAnimal(this);
        this.propietario = granjero;
    }

    @Override
    public String toString() {
        return super.toString() + " { propietario : " + propietario.getNombre() + " }";
    }
}
