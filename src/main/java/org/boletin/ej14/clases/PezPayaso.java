package org.boletin.ej14.clases;

public class PezPayaso extends AnimalSalvaje {

    public PezPayaso( String raza, String sexo) {
        super("Pez","Pez Globo",raza,"Acuatico", sexo);
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
