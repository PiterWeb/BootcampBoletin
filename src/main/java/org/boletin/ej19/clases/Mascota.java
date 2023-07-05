package org.boletin.ej19.clases;


public abstract class Mascota extends Animal implements ITienePropietario {

    private String nombre;
    private String propietario;

    public Mascota(String reino, String tipo, String raza, String medio, String nombre, String propietario, String sexo) {
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
