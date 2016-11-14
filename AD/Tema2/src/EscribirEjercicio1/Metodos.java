/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscribirEjercicio1;

import org.jdom2.Document;
import org.jdom2.Element;
import Herramientas.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    public static void crearXML(Document doc, Element raiz) {
        // Creamos la etiqueta fruta
        Element fruta = new Element("Fruta");

        // Creamos la etiqueta nombre
        Element nombre = new Element("Nombre");

        // Añadimos un nombre a la etiqueta nombre
        nombre.setText("Cereza");
        raiz.addContent(fruta);

        // Creamos la etiqueta fruta2
        Element fruta2 = new Element("Fruta");

        // Creamos la etiqueta nombre2
        Element nombre2 = new Element("Nombre");

        // Añadimos un nombre a la etiqueta nombre2
        nombre2.setText("naranja");
        raiz.addContent(fruta2);

        // Creamos el arbol
        fruta.addContent(nombre);
        fruta2.addContent(nombre2);

        try {
            // Generamos el fichero XML
            //Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio1\\frutas");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Añade en la primera fruta un nuevo nombre llamado limon
    public static void nuevaFruta(Document doc, Element raiz) {
        Element fruta;
        List modificaCal = raiz.getChildren("Fruta");
        Iterator it = modificaCal.iterator();
        while (it.hasNext()) {
            fruta = (Element) it.next();
            if (fruta.getChild("Nombre").getText().equals("Cereza")) {
                fruta.addContent(new Element("Nombre").setText("limon"));
            }

        }

        try {
            // Generamos el fichero XML
            //Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio1\\frutasModificado1");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Renombra la raiz con Frutas → Fruits
    public static void cambiarNombreRaiz(Document doc, Element raiz) {
        raiz.setName("Fruits");

        try {
            // Generamos el fichero XML
            //Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio1\\frutasModificado2");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
