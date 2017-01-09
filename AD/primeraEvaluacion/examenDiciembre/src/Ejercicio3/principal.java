/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import Herramientas.*;
import java.io.FileInputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Alvaro
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Abrimos el fichero
        Document doc = null;
        try {
            doc = new SAXBuilder().build("megacines.xml");
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //System.out.println("1. Nombre de las Películas  que  se están proyectando en más de dos cines: ");
        //Herramientas.xpath(doc, "//pelicula/cines[count(cine)>2]/../titulo");
        //System.out.println("2. Nombre de los directores que han dirigido películas con algún actor de UK: ");
        //Herramientas.xpath(doc, "//pelicula/reparto/actor[@nacionalidad='uk']//../../director");
        //System.out.println("3. Mostrar  la dirección de los cines que tengan  el mismo numsala que el del cine ubicado en Madrid: ");

        //Herramientas.xpath(doc, "//hora[@numsala=//cine[@ubicacion='madrid']/hora/@numsala]/../direccion");
        
        System.out.println("4. Información de los actores que tengan la misma nacionalidad que el actor protagonista de la película el Hobbit:");
        Herramientas.xpath(doc, "//actor[@nacionalidad=//pelicula/reparto/actor[nombre='Martin Freeman']/titulo]/*");
        Herramientas.xpath(doc, "//actor[@nacionalidad=//pelicula/reparto/actor]/*");

    }

}
