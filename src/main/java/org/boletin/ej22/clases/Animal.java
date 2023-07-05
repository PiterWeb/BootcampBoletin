package org.boletin.ej22.clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class Animal implements ISexual {
    private final String reino;

    private final String tipo;

    private final String raza;

    private final String medio;

    private String sexo = "macho";

    private Animal[] padres = new Animal[2];

    private int[] crias = new int[]{-1, -1, -1};
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

    public int getId() {
        return id;
    }

    @Override
    public String getSexo() {
        return sexo;
    }

    public String getReino() {
        return reino;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRaza() {
        return raza;
    }

    public String getMedio() {
        return medio;
    }

    public int[] getCrias() {
        return crias;
    }

    public int getNumeroCrias() {
        return numeroCrias;
    }

    public Animal[] getPadres() {
        return padres;
    }

    public void setPadres(Animal[] padres) {
        this.padres = padres;
    }

    public void setCrias(int[] crias) {
        this.crias = crias;
    }

    public void setNumeroCrias(int n) {
        this.numeroCrias = n;
    }

    @Override
    public void setSexo(String sexo) {
        if (sexo.equalsIgnoreCase("macho") || sexo.equalsIgnoreCase("hembra"))
            this.sexo = sexo;
    }

    public boolean equalsEspecie(Animal animal) {
        return animal.tipo.equalsIgnoreCase(this.tipo);
    }

    public Optional<Animal> aparearse(Animal pareja) {

        if (this == pareja) return Optional.empty();

        if (numeroCrias >= 3) return Optional.empty();
        if (pareja.numeroCrias >= 3) return Optional.empty();

        if (!equalsEspecie(pareja)) return Optional.empty();

        if (sexo.equals(pareja.sexo)) return Optional.empty();

        // No son padre/madre <-> hijo/hija
        if (List.of(pareja.crias).contains(id)) return Optional.empty();
        if (List.of(crias).contains(pareja.id)) return Optional.empty();


        // No son hermanos ni hermanastros entre si
        if (pareja.padres[0] != null && List.of(pareja.padres[0].crias).contains(id)) return Optional.empty();
        if (padres[0] != null && List.of(padres[0].crias).contains(pareja.id)) return Optional.empty();

        if (pareja.padres[1] != null && List.of(pareja.padres[1].crias).contains(id)) return Optional.empty();
        if (padres[1] != null && List.of(padres[1].crias).contains(pareja.id)) return Optional.empty();


        Animal cria = null;

        if (this instanceof Mascota) {
            if (this instanceof Perro)
                cria = new Perro((Mascota) this);

            if (this instanceof Gato)
                cria = new Gato((Mascota) this);

            if (cria == null) return Optional.empty();

            ((Mascota) cria).setNombre(((Mascota) this).getNombre() + "-" + ((Mascota) pareja).getNombre() + numeroCrias + "-jr");
        }

        if (this instanceof AnimalGranja) {
            if (this instanceof Vaca)
                cria = new Vaca((AnimalGranja) this);
            if (this instanceof Oveja)
                cria = new Oveja((AnimalGranja) this);

            if (this.sexo.equalsIgnoreCase("hembra"))
                ((AnimalGranja) cria).setPropietario(((AnimalGranja) this).getPropietario());
            else ((AnimalGranja) cria).setPropietario(((AnimalGranja) pareja).getPropietario());

        }


        if (this instanceof Tucan)
            cria = new Tucan((AnimalSalvaje) this);
        if (this instanceof PezPayaso)
            cria = new PezPayaso((AnimalSalvaje) this);

        if (cria == null) return Optional.empty();

        cria.setPadres(new Animal[]{this, pareja});

        crias[numeroCrias] = cria.id;
        pareja.crias[pareja.numeroCrias] = cria.id;

        numeroCrias++;
        pareja.numeroCrias++;

        return Optional.of(cria);
    }

    public ArrayList<Animal> obtenerAntepasados() {

        if (padres[0] == null || padres[1] == null) return new ArrayList<Animal>();

        ArrayList<Animal> antepasados = new ArrayList<Animal>(List.of(padres));

        Arrays.stream(padres).forEach(p -> {
            antepasados.addAll(p.obtenerAntepasados());
        });

        return antepasados;

    }

    private static int genId() {
        return lastId++;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id='" + id + '\'' +
                ", reino='" + reino + '\'' +
                ", tipo='" + tipo + '\'' +
                ", raza='" + raza + '\'' +
                ", medio='" + medio + '\'' +
                ", sexo='" + sexo + '\'' +
                ", crias=" + Arrays.toString(crias).replace("-1", "None") +
                ", numeroCrias=" + numeroCrias +
                '}';
    }
}

