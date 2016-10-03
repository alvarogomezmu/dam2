/**
 * Se nos informa que tenemos un fichero llamado Mezcla.txt y lo que queremos es
 * separarlo en dos ficheros distintos: Autor.txt y correo.txt
 *
 * Mezcla.txt
 *
 * titulo=El gran libro de Java:idioma=castellano:autor=Peter Smith:e-mail=
 * peter.smith@akamai.com :titulo=El Quijote:idioma=castellano:autor=Miguel de
 * Cervantes:e-mail= miguel.cervantes@gmail.com :titulo=El señor de los
 * anillos:idioma=ingles:autor=Tolkien:e-mail= tolkien@tierramedia.com
 * :titulo=La chica que soñaba con una cerrilla y un bidón de
 * gasolina:idioma=sueco:autor=Stier Larsson:e-mail= stier.larsson@akamai.com
 * :titulo=Teo va al parque:idioma=castellano:autor=Teo:e-mail= teo@akamai.com
 * upus maximus:e-mail= peter.lupus@akamai.com :titulo=Los pilares de la
 * tierra:idioma=alemán:autor=Ken Follet:e-mail= KT.Follet@akamai.com
 *
 * En correo tendremos sólo los e-mails y en el de Autor los demás datos.
 *
 * Crear el código pertinente para poder separar los datos
 *
 */
package Ejercicio5;

import java.util.*;
import java.io.*;
import Herramientas.*;

/**
 *
 * @author Alvaro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedWriter fichA = new BufferedWriter(new FileWriter("C:\\Users\\Alvaro\\Documents\\autor.txt"));
            BufferedWriter fichE = new BufferedWriter(new FileWriter("C:\\Users\\Alvaro\\Documents\\correo.txt"));
            BufferedReader fichM = new BufferedReader(new FileReader("C:\\Users\\Alvaro\\Documents\\Mezcla.txt"));
            String linea;
            String idioma;
            String autor;
            String titulo;
            String mail;

            while ((linea = fichM.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, ":");
                while (st.hasMoreTokens()) {
                    //Se escriben los datos en el fichero autor
                    titulo = st.nextToken();
                    fichA.write(titulo);

                    idioma = st.nextToken();
                    fichA.write(idioma);

                    autor = st.nextToken();
                    fichA.write(autor);
                    fichA.newLine();

                    //Se escriben los datos en el fichero mail
                    mail = st.nextToken();
                    fichE.write(mail);
                    fichE.newLine();
                }
            }

            fichE.close();
            fichA.close();
            fichM.close();

            String ruta1 = "C:\\Users\\Alvaro\\Documents\\correo.txt";
            String ruta2 = "C:\\Users\\Alvaro\\Documents\\autor.txt";

            Herramientas.leerFichero();
            Herramientas.leerFichero();

        } catch (IOException e) {
            System.out.println("ERROR");
        }

    }

}
