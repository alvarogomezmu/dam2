/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import Herramientas.*;

/**
 *
 * @author Alvaro
 */
public class principal {

    public static void main(String args[]) {
        // Abrimos el fichero
        Document doc = null;
        try {
            doc = new SAXBuilder().build("escribirXML.xml");
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

//        System.out.println("1.	Mostrar los títulos de los álbumes donde haya trabajado el dibujante con apodo Morris");
//        Herramientas.xpath(doc, "//dibujante[apodo='Morris']/../../..//album/titulo");
//        Herramientas.xpath(doc, "//album/titulo=//");

        System.out.println("2. Mostrar el título de los álbumes donde intervienen más de 2 personajes y que haya un personaje de tipo animal (SINTAXIS ABREVIADA)");
        System.out.println("3. Mostrar los datos del álbum que no sea ni album con id=a003 ni id=A003 (SINTAXIS NO ABREVIADA usando following o/y preceding)");
        //Herramientas.xpath(doc, "//child::albumes/child::album[self::titulo='Asterix, el galo']/descendant::*");
        Herramientas.xpath(doc, "//child::autores/child::album[self::id='A001']/descendat::*");
        System.out.println("4. Mostrar el nombre de los personajes pintados por el dibujante que ha nacido en el mismo país que el guionista G001");

    }
}
