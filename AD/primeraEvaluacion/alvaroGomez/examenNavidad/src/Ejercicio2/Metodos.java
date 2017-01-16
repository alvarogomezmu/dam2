package Ejercicio2;

import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import Herramientas.*;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    public static void escribirEXML(Document doc, Element raiz) {

        Element personajes = new Element("personajes");
        Element autores = new Element("autores");
        Element dibujantes = new Element("dibujantes");
        Element guionistas = new Element("guionistas");
        Element albumes = new Element("albumes");

        personajes.addContent(new Element("personaje").setAttribute("id", "P001").setAttribute("especie", "humano").setText("Asterix"));
        personajes.addContent(new Element("personaje").setAttribute("id", "P002").setAttribute("especie", "animal").setText("Idefix"));
        personajes.addContent(new Element("personaje").setAttribute("id", "P003").setAttribute("especie", "humano").setText("Lucky Luke"));
        personajes.addContent(new Element("personaje").setAttribute("id", "P004").setAttribute("especie", "animal").setText("Jolly Jumper"));
        personajes.addContent(new Element("personaje").setAttribute("id", "P005").setAttribute("especie", "humano").setText("Dalton"));
        personajes.addContent(new Element("personaje").setAttribute("id", "P006").setAttribute("especie", "humano").setText("Rantanplan"));

        raiz.addContent(personajes);

        // AUTORES
        //------ DIBUJANTES
        Element dibujante = new Element("dibujante").setAttribute("id", "D001");
        dibujante.addContent(new Element("nombre").setText("Albert Uderzo"));
        dibujante.addContent(new Element("nacimientoFecha").setText("1927"));
        dibujante.addContent(new Element("nacimientoPais").setText("Francia"));

        Element dibujante2 = new Element("dibujante").setAttribute("id", "D002");
        dibujante2.addContent(new Element("nombre").setText("Maurice de Bevere"));
        dibujante2.addContent(new Element("apodo").setText("Morris"));
        dibujante2.addContent(new Element("nacimientoFecha").setText("1923"));
        dibujante2.addContent(new Element("nacimientoPais").setText("Belgica"));
        dibujante2.addContent(new Element("fallecimientoFecha").setText("2001"));

        dibujantes.addContent(dibujante).addContent(dibujante2);
        autores.addContent(dibujantes);

        //------ GUIONISTAS
        Element guionista = new Element("guionista").setAttribute("id", "G001");
        guionista.addContent(new Element("nombre").setText("Rene Goscinny"));
        guionista.addContent(new Element("nacimientoFecha").setText("1926"));
        guionista.addContent(new Element("nacimientoPais").setText("Francia"));
        guionista.addContent(new Element("fallecimientoFecha").setText("1977"));

        guionistas.addContent(guionista);
        autores.addContent(guionistas);
        raiz.addContent(autores);

        // ALBUMES
        //------ ALBUM 1
        Element album = new Element("album").setAttribute("id", "A001");
        album.addContent(new Element("titulo").setText("Asterix, el galo"));
        //------ ------ PERSONAJES 
        personajes = new Element("personajes");
        personajes.addContent(new Element("personaje").setText("P001"));
        personajes.addContent(new Element("personaje").setText("P002"));

        //------ ------ AUTORES
        autores = new Element("autores");
        autores.addContent(new Element("dibujante").setText("D001"));
        autores.addContent(new Element("guionista").setText("G001"));

        Element fechaPublicacion = new Element("fechaPublicacion").setText("1961");

        album.addContent(personajes).addContent(autores).addContent(fechaPublicacion);
        albumes.addContent(album);

        //------ ALBUM 2
        Element album2 = new Element("album").setAttribute("id", "A002");
        album2.addContent(new Element("titulo").setText("Indulto para los Dalton"));
        //------ ------ PERSONAJES 
        Element personajes2 = new Element("personajes");
        personajes2.addContent(new Element("personaje").setText("P003"));
        personajes2.addContent(new Element("personaje").setText("P004"));
        personajes2.addContent(new Element("personaje").setText("P005"));

        //------ ------ AUTORES
        Element autores2 = new Element("autores");
        autores2.addContent(new Element("dibujante").setText("D002"));
        autores2.addContent(new Element("guionista").setText("G001"));

        Element fechaPublicacion2 = new Element("fechaPublicacion").setText("1965");

        album2.addContent(personajes2).addContent(autores2).addContent(fechaPublicacion2);
        albumes.addContent(album2);

        //------ ALBUM 3
        Element album3 = new Element("album").setAttribute("id", "A003");
        album3.addContent(new Element("titulo").setText("Obelix y compania"));
        //------ ------ PERSONAJES 
        Element personajes3 = new Element("personajes");
        personajes3.addContent(new Element("personaje").setText("P001"));
        personajes3.addContent(new Element("personaje").setText("P003"));
        personajes3.addContent(new Element("personaje").setText("P006"));

        //------ ------ AUTORES
        Element autores3 = new Element("autores");
        autores3.addContent(new Element("dibujante").setText("D001"));
        autores3.addContent(new Element("guionista").setText("G001"));

        Element fechaPublicacion3 = new Element("fechaPublicacion").setText("1976");

        album3.addContent(personajes3).addContent(autores3).addContent(fechaPublicacion3);
        albumes.addContent(album3);
        raiz.addContent(albumes);

        try {
            // Generamos el fichero XML
            Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "escribirXML");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void leerEXML(Document doc, Element raiz) throws JDOMException, IOException {
        SAXBuilder b = new SAXBuilder();

        System.out.println("<" + raiz.getName() + ">");

        // PERSONAJES
        List<Element> listaPersonajes = raiz.getChildren("personajes");
        Iterator i = listaPersonajes.iterator();
        while (i.hasNext()) {
            Element personajes = (Element) i.next();
            System.out.println("<" + personajes.getName() + ">");

            List<Element> datosPersonaje = personajes.getChildren("personaje");
            Iterator it = datosPersonaje.iterator();
            while (it.hasNext()) {
                Element personaje = (Element) it.next();
                System.out.println("\t<" + personaje.getName() + " id='" + personaje.getAttributeValue("id") + " especie='" + personaje.getAttributeValue("especie") + "'>");
            }
            System.out.println("</" + personajes.getName() + ">");

        }

        // AUTORES
        List<Element> listaAutores = raiz.getChildren("autores");
        Iterator it = listaAutores.iterator();
        while (it.hasNext()) {
            Element autores = (Element) it.next();
            System.out.println("<" + autores.getName() + ">");
            // ----- DIBUJANTES
            List<Element> listaDibujantes = autores.getChildren("dibujantes");
            Iterator itDibuj = listaDibujantes.iterator();
            while (itDibuj.hasNext()) {
                Element dibujantes = (Element) itDibuj.next();
                System.out.println("\t<" + dibujantes.getName() + ">");

                List<Element> idDibujante = dibujantes.getChildren("dibujante");
                Iterator itIdDibuj = idDibujante.iterator();
                while (itIdDibuj.hasNext()) {
                    Element dibujante = (Element) itIdDibuj.next();
                    System.out.println("\t\t<" + dibujante.getName() + " id='" + dibujante.getAttributeValue("id") + "'>");

                    List<Element> datosDibujante = dibujante.getChildren();
                    Iterator itDatosDibuj = datosDibujante.iterator();
                    while (itDatosDibuj.hasNext()) {
                        Element dato = (Element) itDatosDibuj.next();
                        System.out.println("\t\t\t<" + dato.getName() + ">" + dato.getText() + "<" + dato.getName() + ">");
                    }
                    System.out.println("\t\t</" + dibujante.getName() + ">");

                }
                System.out.println("\t</" + dibujantes.getName() + ">");

            }

            // ----- GUIONISTAS
            List<Element> listaGuionistas = autores.getChildren("guionistas");
            Iterator itGuion = listaGuionistas.iterator();
            while (itGuion.hasNext()) {
                Element guionistas = (Element) itGuion.next();
                System.out.println("\t<" + guionistas.getName() + ">");

                List<Element> idGuionista = guionistas.getChildren("guionista");
                Iterator itIdGuion = idGuionista.iterator();
                while (itIdGuion.hasNext()) {
                    Element guionista = (Element) itIdGuion.next();
                    System.out.println("\t\t<" + guionista.getName() + " id='" + guionista.getAttributeValue("id") + "'>");

                    List<Element> datosGuionista = guionista.getChildren();
                    Iterator itDatosGuion = datosGuionista.iterator();
                    while (itDatosGuion.hasNext()) {
                        Element dato = (Element) itDatosGuion.next();
                        System.out.println("\t\t\t<" + dato.getName() + ">" + dato.getText() + "<" + dato.getName() + ">");
                    }
                    System.out.println("\t\t</" + guionista.getName() + ">");

                }
                System.out.println("\t</" + guionistas.getName() + ">");

            }
            System.out.println("</" + autores.getName() + ">");

        }

        // ALBUMES
        List<Element> listaAlbumes = raiz.getChildren("albumes");
        Iterator ite = listaAlbumes.iterator();
        while (ite.hasNext()) {
            Element albumes = (Element) ite.next();
            System.out.println("<" + albumes.getName() + ">");
            // ----- ALBUM
            List<Element> listaAlbum = albumes.getChildren("album");
            Iterator itAutor = listaAlbum.iterator();
            while (itAutor.hasNext()) {
                Element album = (Element) itAutor.next();
                System.out.println("\t<" + album.getName() + " id='" + album.getAttributeValue("id") + "'>");

                List<Element> listaTitulo = album.getChildren("titulo");
                Iterator itTitulo = listaTitulo.iterator();
                while (itTitulo.hasNext()) {
                    Element titulo = (Element) itTitulo.next();
                    System.out.println("\t\t<" + titulo.getName() + ">" + titulo.getText() + "</" + titulo.getName() + ">");

                }
                // ----- ----- PERSONAJES
                List<Element> listaPerson = album.getChildren("personajes");
                Iterator itPerson = listaPerson.iterator();
                while (itPerson.hasNext()) {
                    Element personajes = (Element) itPerson.next();
                    System.out.println("\t\t<" + personajes.getName() + ">");

                    List<Element> listaPersona = personajes.getChildren("personaje");
                    Iterator itPersona = listaPersona.iterator();
                    while (itPersona.hasNext()) {
                        Element personaje = (Element) itPersona.next();
                        System.out.println("\t\t\t<" + personaje.getName() + ">" + personaje.getText() + "</" + personaje.getName() + ">");
                    }
                    System.out.println("\t\t</" + personajes.getName() + ">");
                }

                // ----- ----- AUTORES
                List<Element> listaAutor = album.getChildren("autores");
                Iterator iteAutor = listaAutor.iterator();
                while (iteAutor.hasNext()) {
                    Element autores = (Element) iteAutor.next();
                    System.out.println("\t\t<" + autores.getName() + ">");

                    List<Element> datos = autores.getChildren();
                    Iterator iteDatos = datos.iterator();
                    while (iteDatos.hasNext()) {
                        Element dato = (Element) iteDatos.next();
                        System.out.println("\t\t\t<" + dato.getName() + dato.getText() + "</" + dato.getName() + ">");
                    }
                    System.out.println("\t\t</" + autores.getName() + ">");

                }
                // ----- ----- FECHA PUBLIC
                List<Element> listaFecha = album.getChildren("fechaPublicacion");
                Iterator iteFecha = listaFecha.iterator();
                while (iteFecha.hasNext()) {
                    Element fecha = (Element) iteFecha.next();
                    System.out.println("\t\t<" + fecha.getName() + ">" + fecha.getText() + "</" + fecha.getName() + ">");
                }

                System.out.println("\t</" + album.getName() + ">");

            }
            System.out.println("</" + albumes.getName() + ">");

        }
        System.out.println("</" + raiz.getName() + ">");

    }

    public static void OperacionesEXML(Document doc, Element raiz) {
        System.out.println("1. Eliminar la etiqueta de la fecha de su fallecimiento, para el guionista G001. ");
        if (raiz.getChild("autores").getChild("guionistas").getChild("guionista").getAttributeValue("id").equals("G001")) {
            raiz.getChild("autores").getChild("guionistas").getChild("guionista").removeChild("fallecimientoFecha");
        }

        // Escribimos las modificaciones
        try {
            Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "operacion1");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("2. Añadir a la etiqueta autores un atributo llamado famosos que tenga el Valor SI. ");
        if (raiz.getChild("autores").getAttributes().isEmpty()) {
            raiz.getChild("autores").setAttribute("famosos", "SI");
        }

        // Escribimos las modificaciones
        try {
            Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "operacion2");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("3. Modificar la fecha de nacimiento del dibujante cuyo país de nacimiento sea Bélgica, cámbiala por 1995. ");
        if (raiz.getChild("autores").getChild("dibujantes").getChild("dibujante").getChild("nacimientoPais").getText().equals("Belgica")) {
            raiz.getChild("autores").getChild("dibujantes").getChild("dibujante").getChild("nacimientoPais").setText("AAAAAAAAAAA");
        }

        // Escribimos las modificaciones
        try {
            Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "operacion3");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
