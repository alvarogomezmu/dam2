package Ejercicio3;

import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import Herramientas.*;

/**
 *
 * @author AlumnoT
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// Abrimos el fichero
        Document doc = null;
        try {
            doc = new SAXBuilder().build("arbol.xml");
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("1. Mostrar el nombre de los empleados que tienen mas de un curso");
        Metodos.xpath(doc, "//child::informacion_personal[child::dni=//child::datos_academicos[count(cursos)>1]/@dni]/child::nombre");

        System.out.println("2. Nombre de los empleados que se han gastado menos de 2200 euros en cursos");
        Metodos.xpath(doc, "//child::informacion_personal[child::dni=//child::datos_academicos[child::precio_cursos<2200]/@dni]/child::nombre");

        System.out.println("3. Nombre del titulo que tiene el empleado que no ha nacido en la misma ciudad que el empleado con dni 30954567");
        Metodos.xpath(doc, "//datos_academicos[@dni=//informacion_personal[lugar_nacimiento!=//informacion_personal[dni=\"30954567\"]/lugar_nacimiento]/dni]/titulos");

        System.out.println("4. Todos los datos de los empleados que han hecho mas de un curso y que en su titulacion tengan MCSA");
        Metodos.xpath(doc, "//informacion_personal[dni=//datos_academicos[count(cursos)>1 and titulos='MCSA']/@dni]/*");
    }

}
