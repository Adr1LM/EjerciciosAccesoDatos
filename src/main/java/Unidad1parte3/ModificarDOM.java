package Unidad1parte3;

import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

import java.io.File;

public class ModificarDOM {

    public static void main(String[] args) {
        try {
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("FEmpleados.xml"));
            XPath cadenaXPath = XPathFactory.newInstance().newXPath();
            String expr = "/Empleados/Empleado[dep=20]/salario";

            // Crea una lista con todos los nodos salario de los empleados que cumplen la condición
            NodeList salarios = (NodeList) cadenaXPath.compile(expr).evaluate(documento, XPathConstants.NODESET);

            // Recorremos la lista para actualizar el texto de los nodos
            for (int i = 0; i < salarios.getLength(); i++) {
                Node salario = salarios.item(i);
                System.out.println("Salario: " + salario.getTextContent());
                salario.setTextContent("0"); // Ponemos a 0 el salario
            }

            // Guardar el documento modificado en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource fuente = new DOMSource(documento);
            StreamResult resultado = new StreamResult(new File("EmpleadosModificados.xml"));
            transformer.transform(fuente, resultado);

            System.out.println("Documento modificado y guardado correctamente en EmpleadosModificados.xml.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
