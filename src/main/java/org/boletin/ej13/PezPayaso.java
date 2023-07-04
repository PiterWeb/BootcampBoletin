package org.boletin.ej13;

public class PezPayaso extends AnimalSalvaje {

    public PezPayaso( String raza) {
        super("Pez","Pez Globo",raza,"Acuatico");
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
