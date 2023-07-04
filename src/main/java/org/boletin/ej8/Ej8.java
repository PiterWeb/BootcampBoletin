package org.boletin.ej8;

import org.campusdual.util.Input;

import java.util.ArrayList;

public class Ej8 {

    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();

        while (true) {

            System.out.println("\n\n");
            System.out.println("- a: Añadir numero");
            System.out.println("- s: Suma de los numeros");
            System.out.println("- d: Eliminar ultimo numero");
            System.out.println();

            char c = Input.character("Seleccione una opción: ");

            switch (c) {
                case 'a':
                    int numeroAdd = Input.integer("Introduzca un numero entero: ");
                    numeros.add(numeroAdd);
                    break;
                case 's':
                    int suma = 0;
                    for (int n: numeros) suma +=n;
                    System.out.println("Suma de los numeros: " + suma);
                    break;
                case 'd':
                    if (numeros.size() == 0) System.out.println("La lista de numeros está vacia");
                    else {
                        int lastIndex = numeros.size() - 1;
                        System.out.println("Numero eliminado: " + numeros.remove(lastIndex));
                    }
                    break;
                default:
                    System.out.println("Saliendo del programa ...");
                    System.exit(0);
                    break;


            }
        }


    }

}
