package org.boletin.ej13.clases;

public abstract class AnimalGranja extends Animal implements ITienePropietario {

    private String propietario;

    public AnimalGranja(Animal animal, String propietario) {
        super(animal);
        this.propietario = propietario;
    }

    public AnimalGranja(String reino, String tipo, String raza, String medio, String propietario) {
        super(reino, tipo, raza, medio);
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
