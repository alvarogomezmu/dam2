/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import org.jdom2.Document;
import org.jdom2.Element;
import Herramientas.*;
import java.io.IOException;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    public static void crearXML(Document doc, Element raiz) {

        raiz.setAttribute("fecha", "1999-10-20");

        Element destino = new Element("Destino");
        Element ordenante = new Element("Ordenante");
        Element observaciones = new Element("Observaciones");
        Element contenido = new Element("Contenido");

        destino.addContent(new Element("Nombre").setText("Alicia Abad"));
        destino.addContent(new Element("Direccion").setText("Plaza de la Duquesa, 12"));
        destino.addContent(new Element("Ciudad").setText("Albacete"));
        destino.addContent(new Element("CodPostal").setText("05020"));
        raiz.addContent(destino);

        ordenante.addContent(new Element("Nombre").setText("Roberto Movilla"));
        ordenante.addContent(new Element("Direccion").setText("General Ricardos, 56"));
        ordenante.addContent(new Element("Ciudad").setText("Madrid"));
        ordenante.addContent(new Element("CodPostal").setText("28055"));
        raiz.addContent(ordenante);

        observaciones.setText("Es urgente, el cesped esta muy alto");
        raiz.addContent(observaciones);

        Element producto = new Element("Producto");
        producto.setAttribute("codigo", "872-AA");
        producto.addContent(new Element("Nombre").setText("Cortadora de cesped"));
        producto.addContent(new Element("Cantidad").setText("1"));
        producto.addContent(new Element("Precio").setText("148.98"));
        producto.addContent(new Element("Observaciones").setText("Confirmar que es electrica"));
        contenido.addContent(producto);

        producto = new Element("Producto");
        producto.setAttribute("codigo", "926-FH");
        producto.addContent(new Element("Nombre").setText("Podadora"));
        producto.addContent(new Element("Cantidad").setText("3"));
        producto.addContent(new Element("Precio").setText("7.98"));
        contenido.addContent(producto);

        raiz.addContent(contenido);
        try {
            // Generamos el fichero XML
            //Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio5\\pedidos");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
