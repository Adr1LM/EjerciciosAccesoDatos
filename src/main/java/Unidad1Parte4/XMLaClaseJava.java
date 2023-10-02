package Unidad1Parte4;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XMLaClaseJava {
    public static void main(String[] args) {
        // Configurar Jackson para trabajar con XML
        XmlMapper xmlMapper = new XmlMapper();

        try {
            // Leer el archivo XML y convertirlo en objetos Libreria
            File xmlFile = new File("libreria.xml");
            Libreria libreria = xmlMapper.readValue(xmlFile, Libreria.class);

            // Ahora puedes acceder a los objetos Java
            System.out.println("Nombre de la librería: " + libreria.getNombre());
            System.out.println("Ubicación de la librería: " + libreria.getLugar());

            System.out.println("Libros en la librería:");
            for (Libro libro : libreria.getListaLibro()) {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
