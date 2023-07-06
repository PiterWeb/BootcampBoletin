package org.boletin.ej22.clases;

import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;
import org.boletin.ej14.clases.Sexo;

public class PezPayaso extends AnimalSalvaje {

    public PezPayaso( String raza, Sexo sexo) {
        super(Reino.Pez, Tipo.Pez_Payaso,raza, Medio.Acuatico, sexo);
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
