package org.boletin.ej13;

public class Perro extends Mascota {

    public Perro(String raza, String nombre, String propietario) {
        super("Mamifero","Perro",raza,"Terreno",nombre,propietario);
    }
    public Perro(Mascota mascota) {
        super(mascota);
    }

    @Override
    public void desplazarse() {
        System.out.println("Caminar");
    }

    @Override
    public void reproducirSonido() {
        System.out.println("Guau guau");
    }
}
