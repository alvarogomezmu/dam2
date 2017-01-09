package Ejercicio2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Alvaro
 */
public class Lectura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {
        SAXBuilder b = new SAXBuilder();
        Document doc = b.build(new FileInputStream("Ejercicio2/escribirAlumnos.xml"));
        Element raiz = doc.getRootElement();

        System.out.println("<" + raiz.getName() + ">");

        //----- ALUMNO
        List<Element> tipo = raiz.getChildren("alumno");
        Iterator i = tipo.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            System.out.print("<" + e.getName());

            System.out.print(" id='" + e.getAttributeValue("id") + "'");

            String beca = e.getAttributeValue("beca");

            if (beca != null) {
                System.out.println(" beca='" + e.getAttributeValue("beca") + "'>");
            } else {
                System.out.println(">");
            }

            Element ape1Hijo = e.getChild("apellido1");
            System.out.print("\t<" + ape1Hijo.getName() + ">");
            System.out.println(ape1Hijo.getText() + "</" + ape1Hijo.getName() + ">");

            Element ape2Hijo = e.getChild("apellido2");
            System.out.print("\t<" + ape2Hijo.getName() + ">");
            System.out.println(ape2Hijo.getText() + "</" + ape2Hijo.getName() + ">");

            Element nomHijo = e.getChild("nombre");
            System.out.print("\t<" + nomHijo.getName() + ">");
            System.out.println(nomHijo.getText() + "</" + nomHijo.getName() + ">");

            Element sexoHijo = e.getChild("sexo");
            System.out.print("\t<" + sexoHijo.getName() + ">");
            System.out.println(sexoHijo.getText() + "</" + sexoHijo.getName() + ">");

            //----- ESTUDIOS
            List<Element> estudios = e.getChildren("estudios");
            Iterator itEstudios = estudios.iterator();
            while (itEstudios.hasNext()) {
                Element estudiosHijo = (Element) itEstudios.next();
                System.out.println("\t<" + estudiosHijo.getName() + ">");

                Element carreraHijox2 = estudiosHijo.getChild("carrera");
                System.out.print("\t\t<" + carreraHijox2.getName());

                System.out.println(" " + carreraHijox2.getAttribute("codigo").getName() + " ='" + carreraHijox2.getAttributeValue("codigo") + "'/>");

                //------ ASIGNATURAS
                Element ehijox3 = estudiosHijo.getChild("asignaturas");
                List<Element> asignatura = ehijox3.getChildren("asignatura");
                Iterator itAsignaturas = asignatura.iterator();
                while (itAsignaturas.hasNext()) {
                    Element asignaturasHijo = (Element) itAsignaturas.next();
                    System.out.print("\t\t<" + asignaturasHijo.getName());
                    System.out.println(" " + asignaturasHijo.getAttribute("codigo").getName() + " ='" + asignaturasHijo.getAttributeValue("codigo") + "'/>");
                }
                System.out.println("\t</" + estudiosHijo.getName() + ">");

            }

            System.out.println("</" + e.getName() + ">");
        }
        System.out.println("</" + raiz.getName() + ">");

    }

}
