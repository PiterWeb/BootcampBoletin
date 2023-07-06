package org.boletin.ej13.clases;

import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;

public class Perro extends Mascota {

    public Perro(String raza, String nombre, String propietario) {
        super(Reino.Mamifero, Tipo.Perro,raza, Medio.Terreno,nombre,propietario);
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
