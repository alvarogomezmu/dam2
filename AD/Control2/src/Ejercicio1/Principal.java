/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import Herramientas.*;
import java.io.FileInputStream;
import java.io.IOException;
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
    public static void main(String[] args) throws JDOMException, IOException {
        // LEER
        SAXBuilder b = new SAXBuilder();
        Document doc = b.build(new FileInputStream("ejercicio1.xml"));
        // Leemos el XML y lo metemos en un document

       

        // Cogemos el element root
        Element root = doc.getRootElement();

//        System.out.println("Mostrar el titulo de los CD cuyo precio esté comprendido entre 8 y 12 euros: ");
//        Herramientas.xpath(doc, "//CD[precio>'8' and precio<'12']/titulo");
//
//        System.out.println("CD que tiene mas de una discografica: ");
//        Herramientas.xpath(doc, "//CD[discografica!=1]/titulo");
        //System.out.println("Mostrar los CD's que tiene su país es el mismo que el del CD publicado el año 1987.");
        //Herramientas.xpath(doc, "//CD[pais=//CD[Ano='1987']/pais]/titulo");
        //CD[pais=//CD[Ano=1987]/pais]/titulo

        if (root.getChild("CD").getChild("precio").getText().equals("7.90")) {
            root.getChild("pais").setText("Papo");
        }
        // Escribimos las modificaciones
        try {
            Herramientas.escribirXMLpantalla(doc);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
