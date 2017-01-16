package Ejercicio2;

import org.jdom2.Document;
import org.jdom2.Element;
import Herramientas.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Alvaro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {
        Element raiz = new Element("tebeos");
        Document doc = new Document(raiz);

        System.out.println("ESCRITURA");
        Metodos.escribirEXML(doc, raiz);

        System.out.println("\nLECTURA");
        Metodos.leerEXML(doc, raiz);

        System.out.println("\nOPERACIONES");
        Metodos.OperacionesEXML(doc, raiz);

    }

}
