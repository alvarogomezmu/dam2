package ejemplo5;

import java.util.*;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            //usar el parser Xerces Para que no valide el doc
            Document doc = builder.build("ejemplo5.xml");
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// al club realmadrid vamos a modificar la valoracion de 5 a 100
// modificar Bilbao por Madrid y club Bilbao por club atletico de madrid
// vamos a modificar la etiqueta plantilla por plantillaNueva
// vamos a modificar el atributo valoracion del equipo Real Madrid por el nombre valor
