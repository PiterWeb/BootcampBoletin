package org.boletin.ej7;

public class Ej7 {

    public static void main(String[] args) {

        imprimirValor(5);
        imprimirValor(2.7f);
        imprimirValor("Hello World");
        imprimirValor('c');
        imprimirValor(true);
        imprimirValor(3.4);

    }

    public static void imprimirValor(int val) {
        System.out.println("El entero es " + val);
    }

    public static void imprimirValor(float val) {
        System.out.println("El flotante es " + val);
    }

    public static void imprimirValor(String val) {
        System.out.println("La cadena de texto es '" + val + "'");
    }

    public static void imprimirValor(boolean val) {
        System.out.println("El booleano es " + val);
    }

    public static void imprimirValor(char val) {
        System.out.println("El caracter es " + val);
    }

    public static void imprimirValor(double val) {
        System.out.println("El numero decimal de precision doble es " + val);
    }

}
