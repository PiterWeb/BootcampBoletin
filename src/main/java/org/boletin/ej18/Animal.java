package org.boletin.ej18;

import java.util.Arrays;
import java.util.Optional;

public abstract class Animal implements ISexual {
    private final String reino;

    private final String tipo;

    private final String raza;

    private final String medio;

    private String sexo = "macho";

    private Animal[] padres = new Animal[2];

    private final Animal[] crias = new Animal[MAX_CRIAS];
    private int numeroCrias = 0;

    private static int lastId = 0;

    private int id;

    private static final int MAX_CRIAS = 3;


    public Animal(String reino, String tipo, String raza, String medio, String sexo) {
        this.reino = reino;
        this.tipo = tipo;
        this.raza = raza;
        this.medio = medio;
        if (sexo.equalsIgnoreCase("hembra"))
            this.sexo = sexo;
        this.id = genId();
    }

    public Animal(Animal animal) {
        this.reino = animal.reino;
        this.tipo = animal.tipo;
        this.raza = animal.raza;
        this.medio = animal.medio;
        this.sexo = animal.sexo;
        this.id = genId();
    }

    public abstract void reproducirSonido();

    public abstract void desplazarse();

    @Override
    public String getSexo() {
        return sexo;
    }

    public Animal[] getPadres() {
        return padres;
    }

    public void setPadres(Animal[] padres) {
        this.padres = padres;
    }

    @Override
    public void setSexo(String sexo) {
        if (sexo.equalsIgnoreCase("macho") || sexo.equalsIgnoreCase("hembra"))
            this.sexo = sexo;
    }

    public boolean equalsEspecie(Animal animal) {
        return animal.tipo.equalsIgnoreCase(this.tipo);
    }

    public Optional<Animal> addCria(Animal pareja) {

        if (this == pareja) return Optional.empty();

        if (numeroCrias >= 3) return Optional.empty();
        if (pareja.numeroCrias >= 3) return Optional.empty();

        if (!equalsEspecie(pareja)) return Optional.empty();

        if (sexo.equals(pareja.sexo)) return Optional.empty();

        if (Arrays.asList(pareja.crias).contains(this)) return Optional.empty();
        if (Arrays.asList(crias).contains(pareja)) return Optional.empty();

        if (pareja.padres[0] != null && Arrays.asList(pareja.padres[0].crias).contains(this)) return Optional.empty();
        if (padres[0] != null && Arrays.asList(padres[0].crias).contains(pareja)) return Optional.empty();

        if (pareja.padres[1] != null && Arrays.asList(pareja.padres[1].crias).contains(this)) return Optional.empty();
        if (padres[1] != null && Arrays.asList(padres[1].crias).contains(pareja)) return Optional.empty();

        Animal cria = null;

        if (this instanceof Mascota) {
            if (this instanceof Perro)
                cria = new Perro((Mascota) this);

            if (this instanceof Gato)
                cria = new Gato((Mascota) this);

            if (cria == null) return Optional.empty();

            ((Mascota) cria).setNombre("Cria");
        }

        if (this instanceof Vaca)
            cria = new Vaca((AnimalGranja) this);
        if (this instanceof Oveja)
            cria = new Oveja((AnimalGranja) this);

        if (this instanceof Tucan)
            cria = new Tucan((AnimalSalvaje) this);
        if (this instanceof PezPayaso)
            cria = new PezPayaso((AnimalSalvaje) this);

        if (cria == null) return Optional.empty();

        cria.setPadres(new Animal[]{this, pareja});

        crias[numeroCrias] = cria;
        pareja.crias[pareja.numeroCrias] = cria;

        numeroCrias++;
        pareja.numeroCrias++;

        return Optional.of(cria);
    }

    private static int genId() {
        return lastId++;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "reino='" + reino + '\'' +
                ", tipo='" + tipo + '\'' +
                ", raza='" + raza + '\'' +
                ", medio='" + medio + '\'' +
                ", sexo='" + sexo + '\'' +
                ", crias=" + Arrays.toString(crias) +
                ", numeroCrias=" + numeroCrias +
                ", id=" + id +
                '}';
    }
}

