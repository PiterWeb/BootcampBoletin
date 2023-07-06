package org.boletin.ej22.clases;


import org.boletin.ej11.clases.ITienePropietario;
import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;
import org.boletin.ej14.clases.Sexo;

public abstract class Mascota extends Animal implements ITienePropietario {

    private String nombre;
    private String propietario;

    public Mascota(Reino reino, Tipo tipo, String raza, Medio medio, String nombre, String propietario, Sexo sexo) {
        super(reino, tipo, raza, medio, sexo);
        this.nombre = nombre;
        this.propietario = propietario;
    }

    public Mascota(Animal animal, String nombre, String propietario) {
        super(animal);
        this.nombre = nombre;
        this.propietario = propietario;
    }

    public Mascota(Mascota mascota) {
        super(mascota);
        this.nombre = mascota.nombre;
        this.propietario = mascota.propietario;
    }


    public String getPropietario() {
        return propietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    @Override
    public String toString() {
        return super.toString() + " { propietario : " + propietario + ", nombre : " + nombre + " }";
    }

}
