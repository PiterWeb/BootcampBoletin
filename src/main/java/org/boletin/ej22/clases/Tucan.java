package org.boletin.ej22.clases;

import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;
import org.boletin.ej14.clases.Sexo;

public class Tucan extends AnimalSalvaje {

    public Tucan(String raza, Sexo sexo) {
        super(Reino.Ave, Tipo.Tucan,raza, Medio.Aereo, sexo);
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
