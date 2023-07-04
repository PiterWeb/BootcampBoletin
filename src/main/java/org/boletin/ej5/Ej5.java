package org.boletin.ej5;

import org.campusdual.util.Input;

public class Ej5 {

        public static void main(String[] args) {
            double numeroDecimal = Input.real("Introduce un numero con parte decimal: ");

            System.out.println("Parte entera : " + (int) numeroDecimal);
            System.out.println("Parte decimal : " + (numeroDecimal - (int)numeroDecimal));
        }

}
