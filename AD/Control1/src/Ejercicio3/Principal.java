package Ejercicio3;

import Herramientas.*;
import java.io.IOException;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Alvaro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Leemos el XML y lo metemos en un document
        Document documento = null;
        try {
            documento = new SAXBuilder().build("Ejercicio3/universidad.xml");
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }// Cogemos el element root

        Element root = documento.getRootElement();

        // Añade en la asignatura con codigoF89 un nuevo curso llamado CURSO1
        if(root.getChild("asignaturas").getChild("asignatura").getAttributeValue("codigo").equals("F89")){
            root.getChild("asignaturas").getChild("asignatura").addContent(new Element("curso").setText("1"));
            
        }

        
        // Añade al elemento alumno un atributo sexo que ponga H
        root.getChild("alumnos").getChild("alumno").setAttribute("sexo", "H");
        
        // borra de los profesores su direccion
        root.getChild("profesores").getChild("profesor").removeChild("direccion");
        
        // Escribimos las modificaciones
        try {
            Herramientas.escribirXMLpantalla(documento);
            Herramientas.escribirXMLmachacar(documento, "Ejercicio3/universidadModificado");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
