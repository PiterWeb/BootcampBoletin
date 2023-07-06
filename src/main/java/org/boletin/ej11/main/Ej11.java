package org.boletin.ej11.main;

import org.boletin.ej11.clases.*;

public class Ej11 {
    public static void main(String[] args) {

        Animal gato = new Animal(Reino.Mamifero, Tipo.Gato, "Siames", Medio.Terreno);
        System.out.println(gato);

        System.out.println(gato.clone());

        System.out.println(new Animal(gato));

        Mascota gatoMascota = new Mascota(gato, "Trosky", "Pedro");

        System.out.println("Nombre mascota : " + gatoMascota.getNombre() + "; Propietario : " + gatoMascota.getPropietario());

        Animal vaca = new Animal(Reino.Mamifero, Tipo.Vaca, "Gallega", Medio.Terreno);

        AnimalGranja vacaGranja = new AnimalGranja(vaca, "Pedro");

        System.out.println("Propietario animal de granja : " + vacaGranja.getPropietario());

    }

}
