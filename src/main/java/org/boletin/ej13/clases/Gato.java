package org.boletin.ej13.clases;

import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;

public class Gato extends Mascota {

    public Gato(String raza, String nombre, String propietario, Sexo sexo) {
        super(Reino.Mamifero, Tipo.GATO,raza, Medio.Terreno,nombre,propietario, sexo);
    }
    public Gato(Mascota mascota) {
        super(mascota);
    }

    public Gato instanciarCria(Gato progenitor) {
        Gato cria = new Gato(this);
        cria.setNombre(getNombre() + "-" + progenitor.getNombre() + numeroCriasConPareja(progenitor));
        return cria;
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
