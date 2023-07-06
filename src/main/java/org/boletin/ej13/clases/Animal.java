package org.boletin.ej13.clases;

import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;

public abstract class Animal {
    private final Reino reino;

    private final Tipo tipo;

    private final String raza;

    private final Medio medio;

    public Animal(Reino reino, Tipo tipo, String raza, Medio medio) {
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

    public abstract void reproducirSonido();

    public abstract void desplazarse();

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

