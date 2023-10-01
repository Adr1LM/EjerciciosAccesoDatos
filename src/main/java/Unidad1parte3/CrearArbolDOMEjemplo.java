package Unidad1parte3;

import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.*;

public class CrearArbolDOMEjemplo {

    public static void main(String[] args) {
        String apellido[] = {"FERNANDEZ", "GIL", "LOPEZ", "RAMOS", "SEVILLA", "CASILLA", "REY"};
        int dep[] = {10, 20, 10, 10, 30, 30, 20};
        Double salario[] = {1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0};
        int n = apellido.length;

        try {
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();  //se utiliza para crear un árbol DOM (Modelo de Objeto del Documento) para el documento XML.
            DocumentBuilder builder = factoria.newDocumentBuilder(); //Instancia para crear arbol DOM
            DOMImplementation implementacion = builder.getDOMImplementation();
            Document documento = implementacion.createDocument(null, "Empleados", null);
            documento.setXmlVersion("1.0");

            for (int i = 0; i < n; i++) {
                Element raiz = documento.createElement("Empleado");
                documento.getDocumentElement().appendChild(raiz);
                CrearElemento("id", Integer.toString(i + 1), raiz, documento);
                CrearElemento("apellido", apellido[i].trim(), raiz, documento);
                CrearElemento("dep", Integer.toString(dep[i]), raiz, documento);
                CrearElemento("salario", Double.toString(salario[i]), raiz, documento);
            }

            Source fuente = new DOMSource(documento);
            Result resultado = new StreamResult(new java.io.File("FEmpleados.xml"));
            Transformer transformador = TransformerFactory.newInstance().newTransformer();
            transformador.transform(fuente, resultado);

            // Para mostrar el resultado en pantalla podemos indicar como resultado el canal de salida System.out
            Result consola = new StreamResult(System.out);
            transformador.transform(fuente, consola);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
        //Metodo para crear elementos hijos de cada elemento "empleado"
    static void CrearElemento(String campoemple, String valor, Element raiz, Document documento) {
        Element elem = documento.createElement(campoemple);
        Text texto = documento.createTextNode(valor);
        raiz.appendChild(elem);
        elem.appendChild(texto);
    }
}
