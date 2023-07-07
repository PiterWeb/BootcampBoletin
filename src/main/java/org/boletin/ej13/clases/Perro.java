package org.boletin.ej13.clases;

import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;

public class Perro extends Mascota {
    public Perro(String raza, String nombre, String propietario, Sexo sexo) {
        super(Reino.Mamifero, Tipo.PERRO,raza, Medio.Terreno,nombre,propietario, sexo);
    }
    public Perro(Mascota mascota) {
        super(mascota);
    }

    public Animal instanciarCria(Animal progenitor) {
        Perro cria = new Perro(this);
        cria.setNombre(getNombre() + "-" + ((Mascota)progenitor).getNombre() + numeroCriasConPareja(progenitor) + "-jr");
        return cria;
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
