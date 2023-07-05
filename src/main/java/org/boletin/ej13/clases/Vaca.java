package org.boletin.ej13.clases;

public class Vaca extends AnimalGranja {

    public Vaca(String raza, String propietario) {
        super("Mamifero","Vaca",raza,"Terreno",propietario);
    }
    public Vaca(AnimalGranja animalGranja) {
        super(animalGranja);
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
