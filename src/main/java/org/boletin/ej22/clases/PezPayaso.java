package org.boletin.ej22.clases;

public class PezPayaso extends AnimalSalvaje {

    public PezPayaso( String raza, String sexo) {
        super("Pez","PezPayaso",raza,"Acuatico", sexo);
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
