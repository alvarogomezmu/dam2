/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import org.jdom2.Document;
import org.jdom2.Element;
import Herramientas.*;
import java.io.IOException;

/**
 *
 * @author Alvaro
 */
public class escribirEXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Element raiz = new Element("tebeos");

        Document doc = new Document(raiz);

        Element personajes = new Element("personajes");
        Element autores = new Element("autores");
        Element dibujantes = new Element("dibujantes");
        Element albumes = new Element("albumes");

        Element guionistas = new Element("guionistas");

        personajes.addContent(new Element("personaje").setAttribute("id", "P001").setAttribute("especie", "humano").setText("Asterix"));
        personajes.addContent(new Element("personaje").setAttribute("id", "P002").setAttribute("especie", "animal").setText("Idefix"));
        personajes.addContent(new Element("personaje").setAttribute("id", "P003").setAttribute("especie", "humano").setText("Lucky Luke"));
        personajes.addContent(new Element("personaje").setAttribute("id", "P004").setAttribute("especie", "animal").setText("Jolly Jumper"));
        personajes.addContent(new Element("personaje").setAttribute("id", "P005").setAttribute("especie", "humano").setText("Dalton"));
        personajes.addContent(new Element("personaje").setAttribute("id", "P006").setAttribute("especie", "humano").setText("Rantanplan"));

        raiz.addContent(personajes);

        
        dibujantes.addContent(new Element("dibujante").setAttribute("id", "D001"));
        dibujantes.addContent(new Element("nombre").setText("Albert Uderzo"));

        //fot.
        autores.addContent(dibujantes);
        raiz.addContent(autores);

        try {
            // Generamos el fichero XML
            Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "escribirXML");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
