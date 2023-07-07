package org.boletin.ej11.main;

import org.boletin.ej11.clases.*;

public class Ej11 {
    public static void main(String[] args) {

        Mascota gatoMascota = new Mascota(Tipo.GATO, "Siames", "Trosky", "Pedro");

        System.out.println("Nombre mascota : " + gatoMascota.getNombre() + "; Propietario : " + gatoMascota.getPropietario());

        AnimalGranja vacaGranja = new AnimalGranja(Tipo.VACA, "Gallega", "Pedro");

        System.out.println("Propietario animal de granja : " + vacaGranja.getPropietario());

    }

}
