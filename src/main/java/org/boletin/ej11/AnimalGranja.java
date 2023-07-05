package org.boletin.ej11;
public class AnimalGranja extends Animal implements ITienePropietario {

    private String propietario;
    AnimalGranja(Animal animal, String propietario) {
        super(animal);
        this.propietario = propietario;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

}
