package EscribirEjercicio5;

import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import Herramientas.*;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.DocType;
import org.jdom2.Namespace;
import static org.jdom2.filter.Filters.element;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    public static void crearXML(Document doc, Element raiz) {
        //doc.setBaseURI("http://www.miempresa.org/pedidos");
        //doc.setDocType(new DocType("xmlns").s)
        //raiz.setAttribute("xmlns", "http://www.miempresa.org/pedidos");
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

//    // Modifica la cantidad del producto cuyo codigo sea 926-fh por 30
    public static void modificaCant(Document doc, Element raiz) {
        Element producto;
        List modificaCant = raiz.getChildren("Contenido");
        Iterator it = modificaCant.iterator();
        while (it.hasNext()) {
            producto = (Element) it.next();
            Attribute attr = producto.getAttribute("codigo");
            String value = "";

            if (attr != null) {
                value = attr.getValue();
            }

            if (value =="926-FH") {
                producto.getChild("Cantidad").setText("30");
            }
//            if (valor == ("926-FH")) {
//                producto.getChild("Cantidad").setText("30");
//            }
        }
        try {
            // Generamos el fichero XML
            //Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio5\\pedidosModificado1");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
//    // Borrar las observaciones cuyo precio sea 148,98
//    public static void borrarObserv(Document doc, Element raiz) {
//        Element producto;
//        List borrarObserv = raiz.getChildren("Contenido");
//        Iterator it = borrarObserv.iterator();
//        while (it.hasNext()) {
//            producto = (Element) it.next();
//
//            if (producto.getChild("Precio").getValue().equals("148.98")) {
//                //producto.getChild("Observaciones").setText("hola");
//                producto.removeChild("Observaciones");
//                
//            }
////            }
////            Element precio = (Element) producto.getChild("Precio");
////            Element observaciones = (Element) producto.getChild("Observaciones");
////            if (precio.getValue().equals("148.98")) {
////                producto.removeContent(observaciones);
////            }
//        }
//        try {
//            // Generamos el fichero XML
//            //Herramientas.escribirXMLpantalla(doc);
//            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio5\\pedidosModificado2");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//    // Añadir un precio a todos los productos vacio
//    public static void precioNuevo(Document doc, Element raiz) {
//        Element contenido;
//        List addprecio = raiz.getChildren("Contenido");
//        Iterator it = addprecio.iterator();
//        while (it.hasNext()) {
//            contenido = (Element) it.next();
//            List prec = contenido.getChildren("Producto");
//            Iterator itPreci = prec.iterator();
//
//            while (itPreci.hasNext()) {
//                Element producto = (Element) itPreci.next();
//                Element precio = producto.getChild("Precio");
//                if (precio.getText().equals("7.98")) {
//                    producto.addContent("precio2").setText("hola");
//                }
//
//            }
//        }
//        try {
//            // Generamos el fichero XML
//            //Herramientas.escribirXMLpantalla(doc);
//            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio5\\pedidosModificado8");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

// Mostrar el codigo postal del ordenante de Madrid
    public static void mostrarCp(Document doc, Element raiz) {
        Element ordenante;
        List mostrar = raiz.getChildren("Ordenante");
        Iterator it = mostrar.iterator();
        while (it.hasNext()) {
            ordenante = (Element) it.next();
            if (ordenante.getChild("Ciudad").getText().equals("Madrid")) {
                System.out.println("El codigo postal del ordenante de Madrid es: " + ordenante.getChild("CodPostal").getText());
            }

        }

    }
}
