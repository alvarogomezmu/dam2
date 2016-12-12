/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import Herramientas.*;

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
        Document doc = b.build(new FileInputStream("cine.xml"));
        
        System.out.println("Nombre de las personas de sexo femenino: ");
        Herramientas.xpath(doc, "//personas/persona[@sexo='mujer']/nombre");
//        Metodos.apartado1(doc);
//        Metodos.apartado1_NoAbreviado(doc);
//        Metodos.apartado2(doc);
//        Metodos.apartado2_NoAbreviada(doc);
//        Metodos.apartado3(doc);
//        Metodos.apartado3_NoAbreviada(doc);
//        Metodos.apartado4(doc);
//        Metodos.apartado4_NoAbreviada(doc);
//        Metodos.apartado5(doc);
//        Metodos.apartado6(doc);
//        Metodos.apartado7(doc);
    }
    
}
