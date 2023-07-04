package org.boletin.ej16;

public class Vaca extends AnimalGranja {

    public Vaca(String raza, String propietario, String sexo) {
        super("Mamifero","Vaca",raza,"Terreno",propietario, sexo);
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
