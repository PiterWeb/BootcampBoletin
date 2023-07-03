package org.coches;

public class Coche {

    private String marca;
    private String modelo;

    private int velocidadMax;

    private String tipoCombustible;

    private int velocimetro;

    private int tacometro;

    public Coche(String marca, String modelo, Integer velocidadMax, String tipoCombustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMax = velocidadMax;
        this.tipoCombustible = tipoCombustible;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getVelocidadMax() {
        return velocidadMax;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public int getVelocimetro() {
        return velocimetro;
    }

    public int getTacometro() {
        return tacometro;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setVelocidadMax(int velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public void setVelocimetro(int velocimetro) {
        this.velocimetro = velocimetro;
    }

    public void setTacometro(int tacometro) {
        this.tacometro = tacometro;
    }

    private boolean estaEncendido() {
        return tacometro != 0;
    }

    private String stringVelocidadActual() {
        return "(" + velocimetro + "/" + velocidadMax + ")";
    }

    public void arrancar() {

        if (estaEncendido()) {
            System.out.println("El vehiculo ya está encendido");
            return;
        }

        velocimetro = 0;
        tacometro = 1000;
        System.out.println("Vehiculo encendido");

    }

    public void apagar() {

        if (!estaEncendido()) {
            System.out.println("El coche no se puede apagar si ya esta apagado");
            return;
        }

        if (velocimetro != 0) {
            System.out.println("No se puede apagar con velocidad");
            return;
        }

        tacometro = 0;
        System.out.println("Vehiculo apagado");

    }

    public void acelerar() {
        acelerar(5);
    }

    public void acelerar(int val) {

        if (!estaEncendido()) {
            System.out.println("El coche no puede acelerar apagado");
            return;
        }

        velocimetro += val;

        if (velocimetro > velocidadMax)
            velocimetro = velocidadMax;

        System.out.println("Acelerando" + stringVelocidadActual());
    }

    public void frenar() {
        if (!estaEncendido()) {
            System.out.println("El coche no puede frenar apagado");
            return;
        }

        if (velocimetro == 0) {
            System.out.println("No se puede frenar sin velocidad");
            return;
        }

        velocimetro = 0;
        System.out.println("Frenando" + stringVelocidadActual());
    }

    public void girarVolante() {
        System.out.println("Girando volante");
    }

    public void darMarchaAtras() {
        darMarchaAtras(5);
    }

    public void darMarchaAtras(int val) {

        if (!estaEncendido()) {
            System.out.println("El coche no puede dar marcha atras apagado");
            return;
        }

        if (velocimetro != 0) {
            System.out.println("El coche debe estar quieto para dar marcha atras");
            return;
        }

        velocimetro -= val;

        if (velocimetro < -velocidadMax)
            velocimetro = -velocidadMax;

        System.out.println("Dar marcha atras" + stringVelocidadActual());

    }
}
