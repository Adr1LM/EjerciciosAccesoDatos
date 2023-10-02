package Unidad1parte3;

import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.File;

/*
 *
 * MODIFICAR UN ELEMENTO DEL ARCHIVO
 *
 * */

public class Actividad3OpcionalD {

    public static void main(String[] args) {
        try {
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("pelis.xml"));
            XPath cadenaXPath = XPathFactory.newInstance().newXPath();
            //Elijo peli a cambiar actor
            String expr = "/pelis/peli[titulo='El imperio contraataca']/actor";

            // Crea una lista con todos los nodos TÍTULO de las pelis que cumplen la condición
            NodeList peliculas = (NodeList) cadenaXPath.compile(expr).evaluate(documento, XPathConstants.NODESET);

            // Recorremos la lista para actualizar el texto de los nodos
            for (int i = 0; i < peliculas.getLength(); i++) {
                Node actor = peliculas.item(i);
                System.out.println("Actor actual: " + actor.getTextContent());
                actor.setTextContent("Adrian Lujan"); // Ponemos mi nombre en actor
                System.out.println("Actor nuevo: " + actor.getTextContent());
            }

            // Guardar el documento modificado en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource fuente = new DOMSource(documento);
            StreamResult resultado = new StreamResult(new File("ActorMOdificado.xml"));
            transformer.transform(fuente, resultado);

            System.out.println("Documento modificado y guardado correctamente en ActorMOdificado.xml.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
