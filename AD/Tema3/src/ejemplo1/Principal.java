package ejemplo1;

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
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {
        // LEER
        SAXBuilder b = new SAXBuilder();
        Document doc = b.build(new FileInputStream("biblioteca.xml"));

        // CONSULTAR
        
        // Mostrar el isbn del editorial EDICIONES RIALP SA
        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//libro[editorial='EDICIONES RIALP SA']/isbn", Filters.element());
        List<Element> elemento = xpath1.evaluate(doc);
        Iterator it1 = elemento.iterator();

        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
        
        // Mostrar el autor del penultimo libro 
        XPathExpression<Element> xpath2 = XPathFactory.instance().compile("//libro[last()-1]/autor", Filters.element());
        List<Element> elemento2 = xpath2.evaluate(doc);
        Iterator it2 = elemento2.iterator();

        while (it2.hasNext()) {
            Element at = (Element) it2.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
        
        // Contar el numero de libros (count)
        XPathExpression<Element> xpath3 = XPathFactory.instance().compile("count(//libro)", Filters.element());
        List<Element> elemento3 = xpath3.evaluate(doc);
        Iterator it3 = elemento3.iterator();

        while (it3.hasNext()) {
            Element at = (Element) it3.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
        

    }
}




