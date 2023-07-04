package org.boletin.ej15;

public abstract class Animal implements ISexual {
    private final String reino;

    private final String tipo;

    private final String raza;

    private final String medio;

    private String sexo = "macho";

    public Animal(String reino, String tipo, String raza, String medio, String sexo) {
        this.reino = reino;
        this.tipo = tipo;
        this.raza = raza;
        this.medio = medio;

        if (sexo.equalsIgnoreCase("hembra"))
            this.sexo = sexo;
    }

    public Animal(Animal animal) {
        this.reino = animal.reino;
        this.tipo = animal.tipo;
        this.raza = animal.raza;
        this.medio = animal.medio;
        this.sexo = animal.sexo;
    }

    public abstract void reproducirSonido();

    public abstract void desplazarse();

    @Override
    public String getSexo() {
        return sexo;
    }

    @Override
    public void setSexo(String sexo) {
        if (sexo.equalsIgnoreCase("macho") || sexo.equalsIgnoreCase("hembra"))
            this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "reino='" + reino + '\'' +
                ", tipo='" + tipo + '\'' +
                ", raza='" + raza + '\'' +
                ", medio='" + medio + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}

