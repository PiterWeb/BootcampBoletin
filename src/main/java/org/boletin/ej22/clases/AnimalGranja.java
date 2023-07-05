package org.boletin.ej22.clases;

public abstract class AnimalGranja extends Animal implements ITienePropietario {

    private Granjero propietario;

    public AnimalGranja(Animal animal, Granjero propietario) {
        super(animal);
        this.propietario = propietario;
    }

    public AnimalGranja(String reino, String tipo, String raza, String medio, Granjero propietario, String sexo) {
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
