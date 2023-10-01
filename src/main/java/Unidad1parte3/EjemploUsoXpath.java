package Unidad1parte3;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class EjemploUsoXpath {

    public static void main(String[] args) {
        try {
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("FEmpleados.xml"));
            XPath cadenaXPath = XPathFactory.newInstance().newXPath();
            String expr = "/Empleados/Empleado[dep = 20]/id";

            // Compila la expresión XPath
            XPathExpression xpathExpr = cadenaXPath.compile(expr);

            // Evalúa la expresión XPath en el documento
            NodeList empdep20 = (NodeList) xpathExpr.evaluate(documento, XPathConstants.NODESET);

            // Recorremos la lista obtenida para visualizar el ID del empleado
            for (int i = 0; i < empdep20.getLength(); i++) {
                System.out.println("ID: " + empdep20.item(i).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
