package org.boletin.ej13;

public class Tucan extends AnimalSalvaje {

    public Tucan(String raza) {
        super("Ave","Tucan",raza,"Aereo");
    }
    public Tucan(AnimalSalvaje animalSalvaje) {
        super(animalSalvaje);
    }

    @Override
    public void desplazarse() {
        System.out.println("Volar");
    }

    @Override
    public void reproducirSonido() {
        System.out.println("Pio pio");
    }

}
