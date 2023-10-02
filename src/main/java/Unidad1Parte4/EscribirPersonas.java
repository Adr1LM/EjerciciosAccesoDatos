/*
package Unidad1Parte4;

import java.io.*;


public class EscribirPersonas {
    public static void main(String[] args) {
        try {
            File fichero = new File("FichPersona.dat");
            FileInputStream filein = new FileInputStream(fichero);
            ObjectInputStream dataIS = new ObjectInputStream(filein);
            System.out.println("Comienza el proceso de creación del fichero a XML ...");

            // Creamos un objeto Lista de Personas
            ListaPersonas listaper = new ListaPersonas();

            try {
                while (true) {
                    Persona persona = (Persona) dataIS.readObject();
                    listaper.add(persona);
                }
            } catch (ClassNotFoundException nf) {
                nf.printStackTrace();
            } catch (EOFException eo) {

            }

            dataIS.close();

            try {
                XStream xstream = new XStream();
                xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
                xstream.alias("DatosPersona", Persona.class);
                xstream.addImplicitCollection(ListaPersonas.class, "lista");

                xstream.toXML(listaper, new FileOutputStream("Personas.xml"));
                System.out.println("Creado fichero XML....");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
