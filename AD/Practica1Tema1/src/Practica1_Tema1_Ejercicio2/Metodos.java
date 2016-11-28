package Practica1_Tema1_Ejercicio2;

import Herramientas.Herramientas;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

/**
 *
 * @author AlumnoT
 */
public class Metodos {

    /**
     * Determinar el tamaño de una cadena dentro de un fichero aleatorio
     *
     * @param txt Cualquier string
     * @param largo Integer asociado al string
     * @return Cadena generada
     */
    public static String convertUTF(String txt, int largo) {
        // Si la longitud del String es mayor que el integer asociado
        // Devuelve un substring del String dado
        if (txt.length() > largo) {
            return txt.substring(0, largo);
        }
        // Si el String es menor, añadirle espacios en blanco
        for (int n = txt.length(); n < largo; n++) {
            txt = txt + " ";
        }
        return txt;
    }

    /**
     * Metodo para crear peliculas
     *
     * @param teclado
     * @param ruta
     * @param numeroPeliculas
     * @param maximo
     * @throws IOException
     */
    public static void crearPeliculas(BufferedReader teclado, String ruta, int numeroPeliculas, int maximo) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        Pelicula p;

        try {
            //Se crea el fichero
            fos = new FileOutputStream(ruta);
            salida = new ObjectOutputStream(fos);

            // Pedimos los datos y los introducimos en el fichero
            for (int i = 0; i < numeroPeliculas; i++) {
                String titulo;
                Double precio;
                System.out.println(i);
                System.out.println("Introduce el titulo: ");
                titulo = Herramientas.ConvertUTF(teclado.readLine(), maximo);

                System.out.println("Introduce el precio: ");
                precio = Double.valueOf(teclado.readLine());

                p = new Pelicula(titulo, precio);
                salida.writeObject(p);

            }
            // cerramos el fichero
        } catch (FileNotFoundException e) {
            System.out.println("1" + e.getMessage());
        } catch (IOException e) {
            System.out.println("2" + e.getMessage());
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException e) {
                System.out.println("3" + e.getMessage());
            }
        }
    }

    /**
     * Metodo para mostrar todas las peliculas
     *
     * @param ruta
     * @param numeroPeliculas
     * @throws IOException
     */
    public static void mostrarTodas(String ruta, int numeroPeliculas) throws IOException {
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        Pelicula p;

        try {

            fis = new FileInputStream(ruta);
            entrada = new ObjectInputStream(fis);
            for (int i = 0; i < numeroPeliculas; i++) {
                p = (Pelicula) entrada.readObject(); //es necesario el casting
                System.out.println(p.getTitulo() + " " + p.getPrecio());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Metodo para mostrar la ultima pelicula
     *
     * @param ruta
     * @param numeroPeliculas
     */
    public static void mostrarUltimaPelicula(String ruta, int numeroPeliculas) {
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        Pelicula p;

        try {

            fis = new FileInputStream(ruta);
            entrada = new ObjectInputStream(fis);
            for (int i = 0; i < numeroPeliculas; i++) {
                p = (Pelicula) entrada.readObject(); //es necesario el casting
                if (i == numeroPeliculas - 1) {

                    System.out.println(p.getTitulo() + " " + p.getPrecio());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void mostrarPeliculaPedida(String ruta, int numeroPeliculas, int posicion) {
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        Pelicula p = null;

        try {

            fis = new FileInputStream(ruta);
            entrada = new ObjectInputStream(fis);

            for (int i = 0; i <= posicion - 1; i++) {
                p = (Pelicula) entrada.readObject(); //es necesario el casting
            }
            System.out.println(p.getTitulo() + " " + p.getPrecio());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Metodo para mostrar el menu
     */
    public static void mostrarMenu() {
        System.out.println("Elige una opcion:\n"
                + "a) Mostrar los datos de la última película introducido.\n"
                + "b) Mostrar los datos de una posición que un usuario pida por teclado.\n"
                + "c) Mostrar los datos de todas las películas que disponemos.\n"
                + "f) Finalizar.");
    }

    /**
     * Metodo para pedir al usuario que elija una opcion del menu
     *
     * @param teclado
     * @return
     * @throws IOException
     */
    public static String pedirOpcion(BufferedReader teclado) throws IOException {
        System.out.println("Tu opcion: ");
        return teclado.readLine().toUpperCase();
    }

    public static void setPeliculaDatos(Pelicula p) throws IOException {
        // Creamos un escaner para permitir al usuario introducir datos
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        // Pedimos al usuario que meta los datos de la persona
        System.out.print("Introduce una posicion para ver los datos: ");

        System.out.print("El titulo de la pelicula es: ");
        p.setTitulo(teclado.readLine());
        System.out.print("El precio de la pelicula es: ");
        p.setTitulo(teclado.readLine());

    }
}
