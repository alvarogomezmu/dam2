package EscribirEjercicio4;

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
        // Persona 1
        Element persona = new Element("Persona");
        Element nombre = new Element("nombre");
        Element apellido = new Element("apellido");
        Element nacimiento = new Element("nacimiento");
        Element direccion = new Element("direccion");

        nombre.setText("Juan");
        apellido.setText("Pardo");
        nacimiento.setAttribute("dia", "10").setAttribute("mes", "Abril").setAttribute("ano", "1982");

        persona.addContent(nombre);
        persona.addContent(apellido);
        persona.addContent(nacimiento);

        direccion.addContent(new Element("calle").setText("Caoba, 1"));
        direccion.addContent(new Element("poblacion").setText("Madrid"));
        direccion.addContent(new Element("provincia").setText("Madrid"));
        direccion.addContent(new Element("costal").setText("28005"));

        persona.addContent(direccion);
        persona.addContent(new Element("varon"));

        raiz.addContent(persona);

        // Persona 2
        persona = new Element("Persona");

        nombre = new Element("nombre");
        apellido = new Element("apellido");
        direccion = new Element("direccion");

        nombre.setText("Maria");
        apellido.setText("Lopez");

        persona.addContent(nombre);
        persona.addContent(apellido);

        direccion.addContent(new Element("calle").setText("Roncito, 1"));
        direccion.addContent(new Element("poblacion").setText("Illescas"));
        direccion.addContent(new Element("provincia").setText("Toledo"));
        direccion.addContent(new Element("costal").setText("45200"));

        persona.addContent(direccion);

        direccion = new Element("direccion");
        direccion.addContent(new Element("calle").setText("Paseo de la Esperanza, 15 - 1 A"));
        direccion.addContent(new Element("poblacion").setText("Madrid"));
        direccion.addContent(new Element("provincia").setText("Madrid"));
        direccion.addContent(new Element("costal").setText("28005"));

        persona.addContent(direccion);
        persona.addContent(new Element("hembra"));

        raiz.addContent(persona);

        try {
            // Generamos el fichero XML
            //Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio4\\personas");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Añade una nueva dirección al nombre llamado Juan
    public static void nuevaDireccion(Document doc, Element raiz) {
        Element persona;
        List modificaDir = raiz.getChildren("Persona");
        Iterator it = modificaDir.iterator();
        while (it.hasNext()) {
            persona = (Element) it.next();
            if (persona.getChild("nombre").getText().equals(("Juan"))) {
                Element direccion = new Element("direccion");
                direccion.addContent(new Element("calle").setText("Atocha, 5"));
                direccion.addContent(new Element("poblacion").setText("Madrid"));
                direccion.addContent(new Element("provincia").setText("Madrid"));
                direccion.addContent(new Element("costal").setText("28001"));

                persona.addContent(direccion);
            }
        }

        try {
            // Generamos el fichero XML
            //Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio4\\personas1");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Modifica las etiquetas costal por cp
    public static void modificarCP(Document doc, Element raiz) {
        Element persona;
        List modificarCP = raiz.getChildren("Persona");
        Iterator it = modificarCP.iterator();
        while (it.hasNext()) {
            persona = (Element) it.next();
            List dir = persona.getChildren("direccion");
            Iterator itDir = dir.iterator();
            while (itDir.hasNext()) {
                Element direccion = (Element) itDir.next();
                Element cp = direccion.getChild("costal");
                if (cp != null) {
                    cp.setName("cp");
                }
            }
        }
        try {
            // Generamos el fichero XML
            //Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio4\\personas2");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Modifica la etiqueta varón por hombre
    public static void modificarSexo(Document doc, Element raiz) {
        Element persona;
        List modificarSexo = raiz.getChildren("Persona");
        Iterator it = modificarSexo.iterator();
        while (it.hasNext()) {
            persona = (Element) it.next();
            Element varon = persona.getChild("varon");
            if (varon != null) {
                varon.setName("hombre");
            }
        }
        try {
            // Generamos el fichero XML
            //Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio4\\personas3");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // Modificar el año de nacimiento de la persona llamada pardo a 2000
    public static void modificaAno(Document doc, Element raiz) {
        Element persona;
        List modificaAno = raiz.getChildren("Persona");
        Iterator it = modificaAno.iterator();
        while (it.hasNext()) {
            persona = (Element) it.next();
            if (persona.getChild("apellido").getText().equals("Pardo")) {
                persona.getChild("nacimiento").setAttribute("ano", "2000");
            }
        }
        try {
            // Generamos el fichero XML
            //Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio4\\personas4");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
