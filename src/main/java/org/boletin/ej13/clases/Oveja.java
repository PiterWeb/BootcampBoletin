package org.boletin.ej13.clases;

import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;

public class Oveja extends AnimalGranja {

    public Oveja(String raza, String propietario) {
        super(Reino.Mamifero, Tipo.Oveja, raza, Medio.Terreno, propietario);
    }

    public Oveja(AnimalGranja animalGranja) {
        super(animalGranja);
    }

    @Override
    public void desplazarse() {
        System.out.println("Caminar");
    }

    @Override
    public void reproducirSonido() {
        System.out.println("Beeeeeeeee");
    }

}
