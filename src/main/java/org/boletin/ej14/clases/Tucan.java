package org.boletin.ej14.clases;

public class Tucan extends AnimalSalvaje {

    public Tucan(String raza, String sexo) {
        super("Ave","Tucan",raza,"Aereo", sexo);
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
