package org.boletin.ej12.main;

import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;
import org.boletin.ej12.clases.*;

public class Ej12 {

    public static void main(String[] args) {

        Animal gato = new Animal(Reino.Mamifero, Tipo.GATO, "Siames", Medio.Terreno);
        System.out.println(gato);

        System.out.println(gato.clone());

        System.out.println(new Animal(gato));

        Gato gatoMascota = new Gato(new Mascota(gato, "Trosky", "Pedro"));

        System.out.println(gatoMascota);

        Animal vaca = new Animal(Reino.Mamifero, Tipo.VACA, "Gallega", Medio.Terreno);

        Vaca vacaGranja = new Vaca(new AnimalGranja(vaca, "Pedro"));

        System.out.println(vacaGranja);

        Tucan tucan = new Tucan(new AnimalSalvaje(new Animal(Reino.Ave, Tipo.TUCAN, "Rojo", Medio.Aereo)));

        System.out.println(tucan);

    }
}
