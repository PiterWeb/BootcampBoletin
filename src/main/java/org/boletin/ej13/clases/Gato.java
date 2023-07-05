package org.boletin.ej13.clases;

public class Gato extends Mascota {

    public Gato(String raza, String nombre, String propietario) {
        super("Mamifero","Gato",raza,"Terreno",nombre,propietario);
    }
    public Gato(Mascota mascota) {
        super(mascota);
    }

    @Override
    public void desplazarse() {
        System.out.println("Caminar");
    }

    @Override
    public void reproducirSonido() {
        System.out.println("Miau");
    }
}
