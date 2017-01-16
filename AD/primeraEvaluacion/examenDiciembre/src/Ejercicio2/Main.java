package Ejercicio2;

import org.jdom2.Document;
import org.jdom2.Element;
import Herramientas.*;
import java.io.IOException;
import org.jdom2.JDOMException;

/**
 *
 * @author Alvaro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {
        Element raiz = new Element("alumnos");

        Document doc = new Document(raiz);

        System.out.println("ESCRIBIR");
        Metodos.escribirEXML(doc, raiz);
        
        System.out.println("\nLEER");
        Metodos.leerEXML(doc, raiz);
        
        System.out.println("\nOPERACIONES");
        Metodos.OperacionesXML(doc, raiz);

    }

}
