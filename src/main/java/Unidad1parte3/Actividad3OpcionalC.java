package Unidad1parte3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/*
 *
 * BUSCAR ELEMENTOS FILTRANDO Y MOSTRARLOS
 *
 *
 *  */


public class Actividad3OpcionalC {
    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factoria.newDocumentBuilder();
            Document documento = builder.parse(new File("pelis.xml"));
            documento.getDocumentElement().normalize();
            System.out.println("Elemento raíz: " + documento.getDocumentElement().getNodeName());
            NodeList pelis = documento.getElementsByTagName("peli");

            // Recorremos la lista
            for (int i = 0; i < pelis.getLength(); i++) {
                Node peli = pelis.item(i);
                if (peli.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) peli; //Obtenemos los elemento del nodo
                    if (peli.getNodeType() == Node.ELEMENT_NODE) {

                        if (Integer.parseInt(getNodo("duracion", elemento)) > 120) {
                            System.out.println("titulo: " + getNodo("titulo", elemento));
                            System.out.println("Año: " + getNodo("ano", elemento));
                            System.out.println("Duración: " + getNodo("duracion", elemento));
                            System.out.println("Actor: " + getNodo("actor", elemento));
                        }
                    }
                }


            }
        } catch (Exception e) {
            System.err.println("Error: " + e);


        }

    }

    private static String getNodo(String etiqueta, Element elem) {
        NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valorNodo = (Node) nodo.item(0);
        return valorNodo.getNodeValue();
    }
}





