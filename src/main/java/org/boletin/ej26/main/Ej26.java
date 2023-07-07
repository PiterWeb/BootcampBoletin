package org.boletin.ej26.main;

import org.boletin.ej11.clases.Tipo;
import org.boletin.ej13.clases.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class Ej26 {

    private static ArrayList<Animal> animales = new ArrayList<>();

    public static void main(String[] args) {

        File xmlFile = new File("animales.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;
        Document doc = null;

        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        if (doc == null)
            System.exit(1);

        NodeList animalNodes = doc.getElementsByTagName("animal");

        for (int i = 0; i < animalNodes.getLength(); i++) {

            Node animalNode = animalNodes.item(i);

            if (animalNode.getNodeType() != Node.ELEMENT_NODE) continue;

            Element animalElement = (Element) animalNode;

            int animalId = Integer.parseInt(animalElement.getElementsByTagName("id").item(0).getTextContent());
            Tipo animalTipo = Tipo.valueOf(animalElement.getElementsByTagName("tipo").item(0).getTextContent());
            Sexo animalSexo = Sexo.valueOf(animalElement.getElementsByTagName("sexo").item(0).getTextContent());
            String raza = animalElement.getElementsByTagName("raza").item(0).getTextContent();
            int nCrias = Integer.parseInt(animalElement.getElementsByTagName("n-crias").item(0).getTextContent());

            Animal animal = null;

            boolean tienePropietario = animalElement.getElementsByTagName("propietario").getLength() == 1;
            boolean esMascota = tienePropietario && animalElement.getElementsByTagName("nombre").getLength() == 1;

            if (animalTipo == Tipo.PERRO && esMascota) {
                String propietario = animalElement.getElementsByTagName("propietario").item(0).getTextContent();
                String nombre = animalElement.getElementsByTagName("nombre").item(0).getTextContent();
                animal = new Perro(raza, nombre, propietario, animalSexo);
            } else if (animalTipo == Tipo.GATO && esMascota) {
                String propietario = animalElement.getElementsByTagName("propietario").item(0).getTextContent();
                String nombre = animalElement.getElementsByTagName("nombre").item(0).getTextContent();
                animal = new Gato(raza, nombre, propietario, animalSexo);
            } else if (animalTipo == Tipo.OVEJA && tienePropietario) {
                String propietario = animalElement.getElementsByTagName("propietario").item(0).getTextContent();
                animal = new Oveja(raza, propietario, animalSexo);
            } else if (animalTipo == Tipo.VACA && tienePropietario) {
                String propietario = animalElement.getElementsByTagName("propietario").item(0).getTextContent();
                animal = new Vaca(raza, propietario, animalSexo);
            } else if (animalTipo == Tipo.TUCAN) {
                animal = new Tucan(raza, animalSexo);
            } else if (animalTipo == Tipo.PEZ_PAYASO) {
                animal = new PezPayaso(raza, animalSexo);
            }

            if (animal == null) continue;

            animal.setId(animalId);
            animal.setNumeroCrias(nCrias);

            if (nCrias <= 0) {

                animales.add(animal);

                continue;
            }

            ArrayList<Integer> crias = new ArrayList<>();

            Node criasNode = animalElement.getElementsByTagName("crias").item(0);

            if (criasNode.getNodeType() != Node.ELEMENT_NODE) continue;

            NodeList criaNodes = criasNode.getChildNodes();

            for (int j = 0; j < criaNodes.getLength(); j++) {

                if (criaNodes.item(j).getTextContent().trim().isEmpty()) continue;

                int criaId = Integer.parseInt(criaNodes.item(j).getTextContent().trim());

                crias.add(criaId);

            }

            animal.setCrias(crias);
            animales.add(animal);

        }

        for (Animal a: animales) System.out.println(a);

    }


}
