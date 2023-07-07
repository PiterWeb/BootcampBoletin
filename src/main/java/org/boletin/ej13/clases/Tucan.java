package org.boletin.ej13.clases;

import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;

public class Tucan extends AnimalSalvaje {

    public Tucan(String raza, Sexo sexo) {
        super(Reino.Ave, Tipo.TUCAN,raza, Medio.Aereo, sexo);
    }
    public Tucan(AnimalSalvaje animalSalvaje) {
        super(animalSalvaje);
    }

    @Override
    public void desplazarse() {
        System.out.println("Volar");
    }

    public Animal instanciarCria(Animal progenitor) {
        return new Tucan((AnimalSalvaje) progenitor);
    }
    @Override
    public void reproducirSonido() {
        System.out.println("Pio pio");
    }

}
