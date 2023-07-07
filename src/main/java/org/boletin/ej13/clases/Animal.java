package org.boletin.ej13.clases;

import org.boletin.ej11.clases.Medio;
import org.boletin.ej11.clases.Reino;
import org.boletin.ej11.clases.Tipo;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Animal implements ISexual {
    private final Reino reino;

    private final Tipo tipo;

    private final String raza;

    private final Medio medio;

    private Sexo sexo;

    private Animal padre;

    private Animal madre;

    private ArrayList<Integer> crias = new ArrayList<>();
    private int numeroCrias = 0;

    private static int lastId = 0;

    private int id;


    public Animal(Reino reino, Tipo tipo, String raza, Medio medio, Sexo sexo) {
        this.reino = reino;
        this.tipo = tipo;
        this.raza = raza;
        this.medio = medio;
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
    public Sexo getSexo() {
        return sexo;
    }

    public Reino getReino() {
        return reino;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getRaza() {
        return raza;
    }

    public Medio getMedio() {
        return medio;
    }

    public ArrayList<Integer> getCrias() {
        return crias.stream().filter(Objects::nonNull).collect(Collectors.toCollection(ArrayList::new));
    }

    public int getNumeroCrias() {
        return numeroCrias;
    }

    public Animal getPadre() {
        return padre;
    }

    public Animal getMadre() {
        return madre;
    }

    public void setPadre(Animal padre) {
        this.padre = padre;
    }

    public void setMadre(Animal madre) {
        this.madre = madre;
    }

    public void setCrias(ArrayList<Integer> crias) {
        this.crias = crias.stream().filter(Objects::nonNull).collect(Collectors.toCollection(ArrayList::new));
    }

    public void setNumeroCrias(int n) {
        this.numeroCrias = n;
    }

    @Override
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public boolean equalsEspecie(Animal animal) {
        return animal.tipo == this.tipo;
    }

    private boolean puedenCriar(Animal pareja) {

        if (this == pareja) return false;

        if (numeroCriasConPareja(pareja) >= 3) return false;

        if (!equalsEspecie(pareja)) return false;

        if (sexo.equals(pareja.sexo)) return false;

        if (List.of(pareja.crias).contains(id)) return false;
        if (List.of(crias).contains(pareja.id)) return false;

        if (pareja.padre != null && List.of(pareja.padre.crias).contains(id)) return false;
        if (padre != null && List.of(padre.crias).contains(pareja.id)) return false;

        if (pareja.madre != null && List.of(pareja.madre.crias).contains(id)) return false;
        if (madre != null && List.of(madre.crias).contains(pareja.id)) return false;

        return true;

    }

    public int numeroCriasConPareja(Animal pareja) {

        int n = 0;

        for (int cria : crias) {
            for (int criaPareja : pareja.crias) {
                if (cria == criaPareja)
                    n++;
            }
        }

        return n;

    }

    public Optional<Animal> aparearse(Animal pareja) {

        if (!puedenCriar(pareja)) return Optional.empty();

        Animal cria = null;

        if (this instanceof Mascota) {
            if (this instanceof Perro)
                cria = new Perro((Mascota) this);

            if (this instanceof Gato)
                cria = new Gato((Mascota) this);

            if (cria == null) return Optional.empty();

            ((Mascota) cria).setNombre(((Mascota) this).getNombre() + "-" + ((Mascota) pareja).getNombre() + numeroCrias + "-jr");

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

        if (sexo == Sexo.MACHO) {
            cria.setPadre(this);
            cria.setMadre(pareja);
        } else {
            cria.setMadre(this);
            cria.setPadre(pareja);
        }

        cria.setSexo(Math.random() > 0.5 ? Sexo.MACHO : Sexo.HEMBRA);

        crias.add(cria.id);
        pareja.crias.add(cria.id);

        numeroCrias++;
        pareja.numeroCrias++;

        return Optional.of(cria);
    }

    private static int genId() {
        return lastId++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Animal> obtenerAntepasados() {

        if (padre == null || madre == null) return new ArrayList<Animal>();

        Animal[] padres = new Animal[]{padre, madre};

        ArrayList<Animal> antepasados = new ArrayList<Animal>(List.of(padres));

        Arrays.stream(padres).forEach(p -> {
            antepasados.addAll(p.obtenerAntepasados());
        });

        return antepasados;

    }

    @Override
    public String toString() {
        return "Animal{" +
                "reino=" + reino +
                ", tipo=" + tipo +
                ", raza='" + raza + '\'' +
                ", medio=" + medio +
                ", sexo=" + sexo +
                ", crias=" + crias +
                ", numeroCrias=" + numeroCrias +
                ", id=" + id +
                '}';
    }
}

