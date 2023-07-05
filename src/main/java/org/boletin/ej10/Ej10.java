package org.boletin.ej10;

public class Ej10 {

    public static void main(String[] args) {

        Animal gato = new Animal("Mamifero", "Gato", "Siames", "Terreno");

        System.out.println(gato);

        System.out.println(gato.clone());

        System.out.println(new Animal(gato));

    }

}
