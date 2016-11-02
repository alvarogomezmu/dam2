package EscribirEjercicio1;

import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author AlumnoT
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Element raiz = new Element("Frutas");

        Element f = new Element("fruta");
        f.setAttribute("nombre", "cereza");
        raiz.addContent(f);
        
        Element fr = new Element("fruta");
        fr.setAttribute("nombre", "naranja");
        raiz.addContent(fr);
        
        XMLOutputter outputer = new XMLOutputter();
        try {
            Document doc = new Document(raiz);

            // DOS FORMAS PARA PINTAR:
            // pintamos en fichero (que hayamos creado previamente)
            outputer.output(doc, new FileOutputStream("escribir1.xml"));
            // pintamos de forma rapida
            //outputer.output(doc, System.out);
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
}
/*
// Creamos la etiqueta root fruta
        Element frutas = new Element("Frutas");

        // Creamos la etiqueta fruta
        Element fruta = new Element("Fruta");

        // Creamos la etiqueta nombre
        Element nombre = new Element("Nombre");

        // Añadimos un nombre a la etiqueta nombre
        nombre.setText("Cereza");

        // Creamos la etiqueta fruta2
        Element fruta2 = new Element("Fruta");

        // Creamos la etiqueta nombre2
        Element nombre2 = new Element("Nombre");

        // Añadimos un nombre a la etiqueta nombre2
        nombre.setText("naranja");

        // Creamos el arbol
        fruta.addContent(nombre);
        fruta2.addContent(nombre2);
        frutas.addContent(fruta).addContent(fruta2);

        // Creamos el documento que contendrá el arbol
        Document doc = new Document(frutas);

        try {
            // Generamos el fichero XML
            Herramientas.escribirFichero(doc, "frutas");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
*/
