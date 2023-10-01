package Unidad1parte3;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LeerConSax {

    public static void main(String[] args) throws IOException, FileNotFoundException, SAXException {
        XMLReader lector = XMLReaderFactory.createXMLReader();
        GestionContenido gestor = new GestionContenido();
        lector.setContentHandler(gestor);
        InputSource ficheroXML = new InputSource("FEmpleados.xml");
        lector.parse(ficheroXML);
    }
}

class GestionContenido extends DefaultHandler {

    public GestionContenido() {
        super();
    }

    public void startDocument() {
        System.out.println("Comienzo del documento");
    }

    public void endDocument() {
        System.out.println("Fin del documento");
    }

    public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
        System.out.println("\tPrincipio del Elemento: " + nombre);
    }

    public void endElement(String uri, String nombre, String nombreC) {
        System.out.println("\tFin del Elemento: " + nombre);
    }

    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
        String car = new String(ch, inicio, longitud);
        car = car.replaceAll("[\t\n]", ""); // quitar saltos de línea
        System.out.println("\tcaracteres: " + car);
    }
}
