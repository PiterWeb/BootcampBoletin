package org.boletin.ej24.main;

import org.boletin.ej11.clases.Tipo;
import org.boletin.ej13.clases.*;
import org.boletin.ej20.clases.CriaUtils;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Ej24 {

    public static ArrayList<Animal> animales = new ArrayList<Animal>();

    public static void main(String[] args) {

        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader("animales.json"));

            StringBuilder JSON = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null)
                JSON.append(linea);


            JSONArray animalesJSON = new JSONArray(JSON.toString());

            for (Object a : animalesJSON) {

                JSONObject animalJSON = new JSONObject(a.toString());

                int id = animalJSON.getInt("id");

                Tipo tipo = animalJSON.getEnum(Tipo.class, "tipo");
                Sexo sexo = animalJSON.getEnum(Sexo.class, "sexo");
                String raza = animalJSON.getString("raza");
                JSONArray criasJSON = animalJSON.getJSONArray("crias");
                int nCrias = animalJSON.getInt("numero_crias");

                ArrayList<Integer> crias = new ArrayList<>();

                for (int i = 0; i < criasJSON.length(); i++) {
                    crias.add(criasJSON.getInt(i));
                }

                Animal animal = null;

                boolean tienePropietario = animalJSON.has("propietario");
                boolean esMascota = tienePropietario && animalJSON.has("nombre");

                if (tipo == Tipo.GATO && esMascota) {
                    String propietario = animalJSON.getString("propietario");
                    String nombre = animalJSON.getString("nombre");
                    animal = new Gato(raza, nombre, propietario, sexo);
                } else if (tipo == Tipo.PERRO && esMascota) {
                    String propietario = animalJSON.getString("propietario");
                    String nombre = animalJSON.getString("nombre");
                    animal = new Gato(raza, nombre, propietario, sexo);
                } else if (tipo == Tipo.VACA && tienePropietario) {
                    String propietario = animalJSON.getString("propietario");
                    animal = new Vaca(raza, propietario, sexo);
                } else if (tipo == Tipo.OVEJA && tienePropietario) {
                    String propietario = animalJSON.getString("propietario");
                    animal = new Oveja(raza, propietario, sexo);
                } else if (tipo == Tipo.TUCAN)
                    animal = new Tucan(raza, sexo);

                else if (tipo == Tipo.PEZ_PAYASO)
                    animal = new PezPayaso(raza, sexo);

                if (animal == null) continue;
                animal.setId(id);
                animal.setCrias(crias);
                animal.setNumeroCrias(nCrias);

                animales.add(animal);

            }


        } catch (Exception err) {
            err.printStackTrace();
            System.out.println("No se puede escribir en el archivo json");
        } finally {

            try {

                if (br != null) br.close();

            } catch (Exception err2) {
                err2.printStackTrace();
            }

        }

        CriaUtils.asignarPadres(animales);

        for (Animal a : animales) System.out.println(a);


    }


}
