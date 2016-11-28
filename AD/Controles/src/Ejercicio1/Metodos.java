package Ejercicio1;

import java.io.*;
import Herramientas.*;

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
     * Metodo para crear productos
     *
     * @param teclado
     * @param ruta
     * @param numeroProductos
     * @param maximo
     */
    public static void crearProductos(BufferedReader teclado, String ruta, int numeroProductos, int maximo) {
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        Producto p;

        try {
            //Se crea el fichero
            fos = new FileOutputStream(ruta);
            salida = new ObjectOutputStream(fos);

            // Pedimos los datos y los introducimos en el fichero
            for (int i = 0; i < numeroProductos; i++) {
                Integer codigo;
                String nombre;
                Double precio;
                System.out.println(i);

                System.out.println("Introduce el codigo: ");
                codigo = Integer.valueOf(teclado.readLine());

                System.out.println("Introduce el nombre: ");
                nombre = Herramientas.ConvertUTF(teclado.readLine(), maximo);

                System.out.println("Introduce el precio: ");
                precio = Double.valueOf(teclado.readLine());

                p = new Producto(codigo, nombre, precio);
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

    public static void mostrarTodos(String ruta, int numeroProductos) {
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        Producto p;

        try {

            fis = new FileInputStream(ruta);
            entrada = new ObjectInputStream(fis);
            for (int i = 0; i < numeroProductos; i++) {
                p = (Producto) entrada.readObject(); //es necesario el casting
                if (i == numeroProductos - 1) {

                    System.out.println("Codigo:"+p.getCodigo() +"Nombre:"+p.getNombre() +"Precio:"+p.getPrecio());
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

    public static void mostrarUltimoProducto(String ruta, int numeroProductos) {
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        Producto p;

        try {

            fis = new FileInputStream(ruta);
            entrada = new ObjectInputStream(fis);
            for (int i = 0; i < numeroProductos; i++) {
                p = (Producto) entrada.readObject(); //es necesario el casting
                if (i == numeroProductos - 1) {

                    System.out.println(p.getCodigo() + " " + p.getNombre() + " " + p.getPrecio());
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

    public static void mostrarMenu() {
        System.out.println("Elige una opcion:\n"
                + "a) Mostrar todos los datos introducidos (0,5puntos).\n"
                + "b) Modificar el valor de la posición 2 cambiando nombre por ******. Mostrar el cambio realizado. (2 puntos).\n"
                + "c) c. Mostrar el primero y el tercero dato introducido. (1 punto).\n"
                + "d) Salir.");
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

    public static void mostrarProductoPedido(String ruta, int numeroPeliculas, int posicion) {
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        Producto p = null;

        try {

            fis = new FileInputStream(ruta);
            entrada = new ObjectInputStream(fis);

            for (int i = 0; i <= posicion - 1; i++) {
                p = (Producto) entrada.readObject(); //es necesario el casting
            }
            System.out.println(p.getCodigo() + " " + p.getNombre() + " " + p.getPrecio());

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
// Modificar el valor de la posición 2 cambiando nombre por ******. Mostrar el cambio realizado. (2 puntos)
// Mostrar el primero y el tercero dato introducido. (1 punto)
//
}
