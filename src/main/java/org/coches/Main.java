package org.coches;
public class Main {
    public static void main(String[] args) {

        Coche c = new Coche("Peugeot", "3008", 130, "Diesel");

        System.out.println(c.getTipoCombustible());
        System.out.println(c.getMarca());
        System.out.println(c.getModelo());

        c.arrancar();

        c.darMarchaAtras(10);

        c.girarVolante();

        c.frenar();

        c.acelerar(20);

        c.girarVolante();

        c.apagar(); // Error: No se puede apagar con velocidad

        c.acelerar(60);

        c.frenar();

        c.apagar();

    }

}