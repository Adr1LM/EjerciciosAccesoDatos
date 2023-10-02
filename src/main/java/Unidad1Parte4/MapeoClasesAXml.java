package Unidad1Parte4;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MapeoClasesAXml {
    public static void main(String[] args) {
        // Crear objetos Libro y Libreria
        ArrayList<Libro> listaLibro = new ArrayList<>();
        listaLibro.add(new Libro("La niebla", "S. King"));
        listaLibro.add(new Libro("Hamlet", "W. Shakespeare"));

        Libreria libreria = new Libreria(listaLibro, "Mi Librería", "Valencia");

        // Configurar Jackson para trabajar con XML
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        try {
            // Convertir el objeto Libreria a XML y guardar en un archivo
            String xml = objectMapper.writeValueAsString(libreria);
            File xmlFile = new File("libreria.xml");
            objectMapper.writeValue(xmlFile, libreria);

            System.out.println("XML generado:");
            System.out.println(xml);

            System.out.println("Archivo XML guardado en: " + xmlFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
