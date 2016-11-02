package ModificarEjemplo5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            //usar el parser Xerces Para que no valide el doc
            Document doc = builder.build("ejemplo52.xml");
            //se construye el arbol en memoria desde el fichero
            // que se lo pasará por parametro.
            Element raiz = doc.getRootElement();
            //se usa el elemento raiz
            System.out.println("La liga es de tipo:"
                    + raiz.getAttributeValue("tipo"));
            //todos los hijos  de equipo
            List equipos = raiz.getChildren("equipo");
            System.out.println("Formada por:" + equipos.size() + " equipos");
            Iterator i = equipos.iterator();
            while (i.hasNext()) {
                Element e = (Element) i.next();
                //primer hijo que  haya en club  y plantilla
                Element club = e.getChild("club"); // no tiene  hijos

                if (club.getText().equals("Real Madrid")) {
                    // al club realmadrid vamos a modificar la valoracion de 5 a 100
                    club.setAttribute("valoracion", "100");
                    // modificar el club Real Madrid por Real Club Nuevo
                    club.setText("Real Club Nuevo");
                }

                List plantilla = e.getChildren("plantilla"); // si tiene hijos
                System.out.println(club.getText() + ":" + "valoracion="
                        + club.getAttributeValue("valoracion") + ","
                        + "ciudad=" + club.getAttributeValue("ciudad") + ","
                        + "formada por:" + plantilla.size() + "jugadores");
                if (e.getChildren("conextranjeros").size() == 0) {
                    System.out.println("No tiene extranjeros");
                } else {
                    System.out.println("Tiene extranjeros");
                }
            }
            System.out.println("\n");

            XMLOutputter o = new XMLOutputter();
            // solo modifica por pantalla
            o.output(doc, System.out);

            // sobreescribimos el fichero
            BufferedWriter n = new BufferedWriter(new FileWriter("ejemplo5.xml"));
            o.output(doc, n);
            n.close();

            equipos.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
