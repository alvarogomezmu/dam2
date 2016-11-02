package EscribirEjercicio2;

import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author AlumnoT
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Element raiz = new Element("menu_almuerzo");
        
        Element c = new Element("comida");
        c.setAttribute("nombre", "Waffles");
        c.setAttribute("precio", "2$");
        c.setAttribute("descripcion", "Waffles baratos de McDonald’s");
        c.setAttribute("calorias", "650");
        raiz.addContent(c);
        
        Element co = new Element("comida");
        co.setAttribute("nombre", "hamburguesa");
        co.setAttribute("precio", "5$");
        co.setAttribute("descripcion", "La hamburguesa más común de McDonald’s");
        co.setAttribute("calorias", "1500");
        raiz.addContent(co);
        
        
        XMLOutputter outputer = new XMLOutputter();
        try {
            Document doc = new Document(raiz);

            // DOS FORMAS PARA PINTAR:
            // pintamos en fichero (que hayamos creado previamente)
            outputer.output(doc, new FileOutputStream("escribir2.xml"));
            // pintamos de forma rapida
            //outputer.output(doc, System.out);
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
}
