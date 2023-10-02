package Unidad1parte3;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/*
 *
 * AÑADIR ELEMENTOS AL ARCHIVO
 *
 * */

public class Actividad3OpcionalB {


    public static void main(String[] args) {

        try {

            //Crear factoria y volcar la info de pelis.xml en un objeto "document"
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factoria.newDocumentBuilder();
            Document documento = builder.parse(new File("pelis.xml"));
            documento.getDocumentElement().normalize();
            System.out.println("Elemento raíz: " + documento.getDocumentElement().getNodeName());
            NodeList pelis = documento.getElementsByTagName("peli");

            //Crear el elemento de la nueva pelicula
            Element nuevaPeli = documento.createElement("peli");
            documento.getDocumentElement().appendChild(nuevaPeli);
            CrearElemento("titulo", "La amenaza Fantasma", nuevaPeli, documento);
            CrearElemento("ano", "1999", nuevaPeli, documento);
            CrearElemento("duracion", "120", nuevaPeli, documento);
            CrearElemento("actor", "Hayden Cristiansen", nuevaPeli, documento);

            //Agregarla al documento
            documento.getDocumentElement().appendChild(nuevaPeli);

            // Guardar el documento modificado en el archivo "pelis.xml"
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource fuente = new DOMSource(documento);
            StreamResult resultado = new StreamResult(new File("pelis.xml"));
            transformer.transform(fuente, resultado);


        } catch (Exception e) {
            System.err.println("Error: " + e);


        }
    }

    static void CrearElemento(String campoPeli, String valor, Element raiz, Document documento) {
        Element elem = documento.createElement(campoPeli);
        Text texto = documento.createTextNode(valor);
        raiz.appendChild(elem);
        elem.appendChild(texto);
    }
}
