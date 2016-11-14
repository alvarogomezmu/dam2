package EscribirEjercicio3;

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

        Element terrestres = new Element("Terrestres");
        Element acuaticos = new Element("Acuaticos");
        Element aereos = new Element("Aereos");
        Element vehiculo = new Element("Vehiculo");

        // Terrestres
        vehiculo.setText("bicicleta");
        terrestres.addContent(vehiculo);

        vehiculo = new Element("Vehiculo");
        vehiculo.setText("coche");
        terrestres.addContent(vehiculo);

        vehiculo = new Element("Vehiculo");
        vehiculo.setText("tractor");
        terrestres.addContent(vehiculo);

        raiz.addContent(terrestres);

        // Acuaticos
        vehiculo = new Element("Vehiculo");
        vehiculo.setText("canoa");

        acuaticos.addContent(vehiculo);

        raiz.addContent(acuaticos);

        // Aereos
        vehiculo = new Element("Vehiculo");
        vehiculo.setText("avioneta");
        aereos.addContent(vehiculo);

        vehiculo = new Element("Vehiculo");
        vehiculo.setText("helicoptero");
        aereos.addContent(vehiculo);

        raiz.addContent(aereos);

        try {
            // Generamos el fichero XML
            //Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "practicaEscritura\\ejercicio3\\vehiculos");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
