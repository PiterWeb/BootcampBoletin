package org.boletin.ej22.clases;

public class Oveja extends AnimalGranja {

    public Oveja(String raza, Granjero propietario, String sexo) {
        super("Mamifero", "Oveja", raza, "Terreno", propietario, sexo);
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
