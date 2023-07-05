package org.boletin.ej13.clases;

public class Oveja extends AnimalGranja {

    public Oveja(String raza, String propietario) {
        super("Mamifero", "Oveja", raza, "Terreno", propietario);
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
