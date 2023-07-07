package org.boletin.ej11.clases;

public class Mascota extends Animal implements ITienePropietario {

    private final String nombre;
    private String propietario;

    public Mascota(Animal animal, String nombre, String propietario) {
        super(animal);
        this.nombre = nombre;
        this.propietario = propietario;
    }

    public Mascota(Tipo tipo, String raza, String nombre, String propietario) {
        super(Reino.Mamifero, tipo, raza, Medio.Terreno);
        this.nombre = nombre;
        this.propietario = propietario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }


}
