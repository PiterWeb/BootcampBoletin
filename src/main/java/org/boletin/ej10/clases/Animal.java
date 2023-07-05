package org.boletin.ej10.clases;

public class Animal {
    private final String reino;

    private final String tipo;

    private final String raza;

    private final String medio;

    public Animal(String reino, String tipo, String raza, String medio) {
        this.reino = reino;
        this.tipo = tipo;
        this.raza = raza;
        this.medio = medio;
    }

    public Animal(Animal animal) {
        this.reino = animal.reino;
        this.tipo = animal.tipo;
        this.raza = animal.raza;
        this.medio = animal.medio;
    }

    @Override
    public Animal clone() {
        return new Animal(
                this.reino,
                this.tipo,
                this.raza,
                this.medio
        );
    }

    @Override
    public String toString() {
        return "Animal{" +
                "reino='" + reino + '\'' +
                ", tipo='" + tipo + '\'' +
                ", raza='" + raza + '\'' +
                ", medio='" + medio + '\'' +
                '}';
    }
}

