package org.boletin.ej25.main;

import org.boletin.ej11.clases.ITienePropietario;
import org.boletin.ej13.clases.Animal;
import org.boletin.ej13.clases.Mascota;
import org.boletin.ej16.clases.ListaAnimales;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Ej25 {

    public static void main(String[] args) {

        final ArrayList<Animal> animales = ListaAnimales.reproducirAnimales();

        try {
            PrintWriter pw = new PrintWriter("animales.xml");

            pw.println("<animales>");
            for (Animal a : animales) {
                pw.println("<animal>");

                pw.println("<id>" + a.getId() + "</id>");
                if (a instanceof Mascota)
                    pw.println("<nombre>" + ((Mascota) a).getNombre() + "</nombre>");

                pw.println("<sexo>" + a.getSexo() + "</sexo>");
                pw.println("<tipo>" + a.getTipo() + "</tipo>");

                if (a instanceof ITienePropietario)
                    pw.println("<propietario>" + ((ITienePropietario) a).getPropietario() + "</propietario>");

                pw.println("<reino>" + a.getReino() + "</reino>");
                pw.println("<raza>" + a.getRaza() + "</raza>");
                pw.println("<medio>" + a.getMedio() + "</medio>");

                if (a.getMadre() != null && a.getPadre() != null) {
                    pw.println("<padre>" + a.getPadre().getId() + "</padre>");
                    pw.println("<madre>" + a.getMadre().getId() + "</madre>");
                }

                pw.println("<n-crias>" + a.getNumeroCrias() + "</n-crias>");

                if (a.getNumeroCrias() != 0) {

                    pw.println("<crias>");

                    for (int cria : a.getCrias()) {
                        pw.println("<cria>" + cria + "</cria>");
                    }

                    pw.println("</crias>");

                }


                pw.println("</animal>");
            }
            pw.println("</animales>");

            pw.close();

        } catch (FileNotFoundException err) {
            err.printStackTrace();
            System.out.println("No se puede escribir en el archivo csv");
        }

    }

}
