package org.boletin.ej13.clases;

import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;

public class Tucan extends AnimalSalvaje {

    public Tucan(String raza) {
        super(Reino.Ave, Tipo.Tucan,raza, Medio.Aereo);
    }
    public Tucan(AnimalSalvaje animalSalvaje) {
        super(animalSalvaje);
    }

    @Override
    public void desplazarse() {
        System.out.println("Volar");
    }

    @Override
    public void reproducirSonido() {
        System.out.println("Pio pio");
    }

}
