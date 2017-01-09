package ejercicioFactura;

import Herramientas.Herramientas;
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

        Document doc = null;
        try {
            doc = new SAXBuilder().build("NoAbreviada\\factura.xml");
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // 1. Mostrar la última linea de pedido del cliente c881
        System.out.println("\nApartado 1\n");
        //Herramientas.xpath(doc, "//datos_cliente[@n_cli]");
        //Herramientas.xpathAttVal(doc, "//datos_cliente", "n_cli");
        Herramientas.xpathAttVal(doc, "//datos_cliente", "n_cli='c881'","n_cli");
    }

}
