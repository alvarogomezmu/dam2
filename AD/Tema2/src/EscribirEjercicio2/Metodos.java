package EscribirEjercicio2;

import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import Herramientas.*;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    public static void crearXML(Document doc, Element raiz) {

        Element comida = new Element("comida");
        Element nombre = new Element("nombre");
        Element precio = new Element("precio");
        Element descripcion = new Element("descripcion");
        Element calorias = new Element("calorias");

        nombre.setText("Waffles");
        precio.setText("$2.00");
        descripcion.setText("Waffles baratos de McDonald’s");
        calorias.setText("650");

        comida.addContent(nombre).addContent(precio).addContent(descripcion).addContent(calorias);

        raiz.addContent(comida);

        comida = new Element("comida");
        nombre = new Element("nombre");
        precio = new Element("precio");
        descripcion = new Element("descripcion");
        calorias = new Element("calorias");

        nombre.setText("hamburguesa");
        precio.setText("$5.00");
        descripcion.setText("La hamburguesa más común de McDonald’s");
        calorias.setText("1500");

        comida.addContent(nombre).addContent(precio).addContent(descripcion).addContent(calorias);

        raiz.addContent(comida);

        try {
            // Generamos el fichero XML
            //Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio2\\almuerzo");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void modifica1(Document doc, Element raiz) {
        // Modifica las calorias de las hamburguesas a 1800
        Element comida;
        List modificaCal = raiz.getChildren("comida");
        Iterator it = modificaCal.iterator();
        while (it.hasNext()) {
            comida = (Element) it.next();
            if (comida.getChild("nombre").getText().equals(("hamburguesa"))) {
                comida.getChild("calorias").setText("1800");
            }
        }

        try {
            // Generamos el fichero XML
            //Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio2\\almuerzoModificado1");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void modifica2(Document doc, Element raiz) {
        // Modifica el precio de WAFFLES a 20
        Element comida;
        List precioWa = raiz.getChildren("comida");
        Iterator i = precioWa.iterator();
        while (i.hasNext()) {
            comida = (Element) i.next();

            if (comida.getChild("nombre").getText().equals("Waffles")) {
                // Modifica el precio de 2 a 20
                comida.getChild("precio").setText("$20.00");
            }
        }

        try {
            // Generamos el fichero XML
            //Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio2\\almuerzoModificado2");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void modifica3(Document doc, Element raiz) {
        // Borra la descripcion de las comidas
        Element comida;
        List borraDesc = raiz.getChildren("comida");
        Iterator it = borraDesc.iterator();
        while (it.hasNext()) {
            comida = (Element) it.next();

            comida.getChild("descripcion").setText("");

        }

        try {
            // Generamos el fichero XML
            //Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio2\\almuerzoModificado3");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
