package org.boletin.ej11.main;

import org.boletin.ej11.clases.Animal;
import org.boletin.ej11.clases.AnimalGranja;
import org.boletin.ej11.clases.Mascota;

public class Ej11 {
    public static void main(String[] args) {

        Animal gato = new Animal("Mamifero", "Gato", "Siames", "Terreno");
        System.out.println(gato);

        System.out.println(gato.clone());

        System.out.println(new Animal(gato));

        Mascota gatoMascota = new Mascota(gato, "Trosky", "Pedro");

        System.out.println("Nombre mascota : " + gatoMascota.getNombre() + "; Propietario : " + gatoMascota.getPropietario());

        Animal vaca = new Animal("Mamifero", "Vaca", "Gallega", "Terreno");

        AnimalGranja vacaGranja = new AnimalGranja(vaca, "Pedro");

        System.out.println("Propietario animal de granja : " + vacaGranja.getPropietario());

    }

}