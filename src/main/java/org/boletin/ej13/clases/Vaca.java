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

    public Animal instanciarCria(Animal progenitor) {
        return new Vaca((AnimalGranja) progenitor);
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
