package org.boletin.ej11.clases;

public class AnimalGranja extends Animal implements ITienePropietario {

    private String propietario;

    public AnimalGranja(Animal animal, String propietario) {
        super(animal);
        this.propietario = propietario;
    }

    public AnimalGranja(Tipo tipo, String raza, String propietario) {
        super(Reino.Mamifero, tipo, raza, Medio.Terreno);
        this.propietario = propietario;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

}
