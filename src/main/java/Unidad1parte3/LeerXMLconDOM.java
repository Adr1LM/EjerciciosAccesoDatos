package Unidad1parte3;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class LeerXMLconDOM {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factoria.newDocumentBuilder();
            Document documento = builder.parse(new File("Empleados.xml"));
            documento.getDocumentElement().normalize();

            System.out.println("Elemento raíz: " + documento.getDocumentElement().getNodeName());

            NodeList empleados = documento.getElementsByTagName("Empleado");

            for (int i = 0; i < empleados.getLength(); i++) {
                Node empleado = empleados.item(i);
                if (empleado.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) empleado;
                    System.out.println("ID: " + getNodo("id", elemento));
                    System.out.println("Apellido: " + getNodo("apellido", elemento));
                    System.out.println("Departamento: " + getNodo("dep", elemento));
                    System.out.println("Salario: " + getNodo("salario", elemento));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getNodo(String etiqueta, Element elem) {
        NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valorNodo = (Node) nodo.item(0);
        return valorNodo.getNodeValue();
    }
}
