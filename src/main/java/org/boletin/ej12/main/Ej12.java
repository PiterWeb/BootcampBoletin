package org.boletin.ej12.main;

import org.boletin.ej12.clases.*;

public class Ej12 {

    public static void main(String[] args) {

        Animal gato = new Animal("Mamifero", "Gato", "Siames", "Terreno");
        System.out.println(gato);

        System.out.println(gato.clone());

        System.out.println(new Animal(gato));

        Gato gatoMascota = new Gato(new Mascota(gato, "Trosky", "Pedro"));

        System.out.println(gatoMascota);

        Animal vaca = new Animal("Mamifero", "Vaca", "Gallega", "Terreno");

        Vaca vacaGranja = new Vaca(new AnimalGranja(vaca, "Pedro"));

        System.out.println(vacaGranja);

        Tucan tucan = new Tucan(new AnimalSalvaje(new Animal("Ave", "Tucan", "Rojo", "Aereo")));

        System.out.println(tucan);

    }
}
