package Unidad1parte3;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
/*
*
* LEER UN DOCUMENTO XML
*
* */
public class Actividad3OpcionalA {
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
                        System.out.println("titulo: " + getNodo("titulo", elemento));
                        System.out.println("Año: " + getNodo("ano", elemento));
                        System.out.println("Duración: " + getNodo("duracion", elemento));
                        System.out.println("Actor: " + getNodo("actor", elemento));
                    }
                }
            }


            } catch(Exception e){
                System.err.println("Error: " + e);


            }
        }

    private static String getNodo(String etiqueta, Element elem) {
        NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valorNodo = (Node) nodo.item(0);
        return valorNodo.getNodeValue();
    }
    }





