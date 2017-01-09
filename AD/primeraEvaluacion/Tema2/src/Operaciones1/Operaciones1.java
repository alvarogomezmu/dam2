package Operaciones1;

import Herramientas.*;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author AlumnoT
 */
public class Operaciones1 {

    public static void main(String args[]) {

        // Leemos el XML y lo metemos en un document
        Document documento = null;
        try {
            documento = new SAXBuilder().build("operaciones1copia1.xml");
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }// Cogemos el element root

        Element root = documento.getRootElement();

        // Modificar la etiqueta nivel por libro
         root.getChild("nivel").setName("Libro");

        // Escribimos las modificaciones
        try {
            Herramientas.escribirXMLpantalla(documento);
            Herramientas.escribirXMLmachacar(documento, "operaciones1copia1");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Modificar el atributo ubicacion por localidad
         root.getAttribute("ubicacion").setName("Localidad");
        // Escribimos las modificaciones
        try {
            Herramientas.escribirXMLpantalla(documento);
            Herramientas.escribirXMLmachacar(documento, "operaciones1copia1");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        // Modificar el precio de la ocmputadora de 1200 a 2000
//         root.getChild("computadora").setAttribute("precio", "2000");
//        // Escribimos las modificaciones
//        try {
//            Herramientas.escribirXMLpantalla(documento);
//            Herramientas.escribirXMLmachacar(documento, "operaciones1copia1");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        
//        // Anadir nueva etiqueta empleado con atributo cargo, con valor responsable
//        root.addContent(new Element("empleado").setAttribute("cargo", "responsable"));
//
//        //Escribimos las modificaciones
//        try {
//            //Herramientas.escribirXMLpantalla(documento);
//            Herramientas.escribirXMLmachacar(documento, "operaciones1copia1");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
            
//        // Eliminar la etiqueta libro
//        root.removeChild("libro");
//
//        //Escribimos las modificaciones
//        try {
//            //Herramientas.escribirXMLpantalla(documento);
//            Herramientas.escribirXMLmachacar(documento, "operaciones1copia1");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }
}
