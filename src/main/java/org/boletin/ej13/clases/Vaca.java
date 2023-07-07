package org.boletin.ej13.clases;

import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;

public class Vaca extends AnimalGranja {

    public Vaca(String raza, String propietario, Sexo sexo) {
        super(Reino.Mamifero, Tipo.VACA,raza, Medio.Terreno,propietario, sexo);
    }
    public Vaca(AnimalGranja animalGranja) {
        super(animalGranja);
    }

    public Vaca instanciarCria(Vaca Progenitor) {
        return new Vaca(Progenitor);
    }
    @Override
    public void desplazarse() {
        System.out.println("Caminar");
    }

    @Override
    public void reproducirSonido() {
        System.out.println("Muuuuuuuuuuuu");
    }

}
