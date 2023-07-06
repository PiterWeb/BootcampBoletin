package org.boletin.ej13.clases;

import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;

public class PezPayaso extends AnimalSalvaje {

    public PezPayaso(String raza) {
        super(Reino.Pez, Tipo.Pez_Payaso,raza, Medio.Acuatico);
    }
    public PezPayaso(AnimalSalvaje animalSalvaje) {
        super(animalSalvaje);
    }

    @Override
    public void desplazarse() {
        System.out.println("Nadar");
    }

    @Override
    public void reproducirSonido() {
        System.out.println("...");
    }

}
