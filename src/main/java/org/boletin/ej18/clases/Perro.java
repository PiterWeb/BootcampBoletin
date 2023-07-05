package org.boletin.ej18.clases;

public class Perro extends Mascota {
    public Perro(String raza, String nombre, String propietario, String sexo) {
        super("Mamifero","Perro",raza,"Terreno",nombre,propietario, sexo);
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
