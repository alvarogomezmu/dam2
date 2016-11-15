package xpathEjercicio1;

import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

/**
 *
 * @author AlumnoT
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {
        // LEER
        SAXBuilder b = new SAXBuilder();
        Document doc = b.build(new FileInputStream("noAbreviada\\ejemplo1.xml"));

        Metodos.apartado1(doc);
        Metodos.apartado2(doc);
        Metodos.apartado3(doc);
        Metodos.apartado4(doc);
        Metodos.apartado5(doc);

    }

}
