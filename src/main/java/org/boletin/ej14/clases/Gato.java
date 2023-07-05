package org.boletin.ej14.clases;

public class Gato extends Mascota {

    public Gato(String raza, String nombre, String propietario, String sexo) {
        super("Mamifero","Gato",raza,"Terreno",nombre,propietario, sexo);
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
