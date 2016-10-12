package Practica1_Tema1_Ejercicio1;

import java.io.*;
import java.util.HashMap;
import Herramientas.*;
import java.util.Iterator;
import static jdk.nashorn.internal.objects.NativeArray.map;

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
     *
     * @param cursos
     * @param numeroCursos
     * @param nombreFichero
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void crearCursos(HashMap<String, Curso> cursos, int numeroCursos, String nombreFichero) throws FileNotFoundException, IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        String nombre;
        int duracion;

        System.out.println("Creando cursos...");

        for (int i = 0; i < numeroCursos; i++) {
            System.out.println("Nombre del curso:");
            nombre = teclado.readLine();
            System.out.println("Duracion: ");
            duracion = Integer.parseInt(teclado.readLine());
            String codigoCurso = Integer.toString(i);
            System.out.println("Codigo curso: ");
            codigoCurso = teclado.readLine();
            Curso cursoNuevo = new Curso(nombre, duracion);
            cursos.put(codigoCurso, cursoNuevo);
        }
        FileOutputStream fo = new FileOutputStream(nombreFichero);
        ObjectOutputStream os = new ObjectOutputStream(fo);
        os.writeObject(cursos);

    }

    /**
     * 
     * @param nombreFichero
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static void mostrarCursos(String nombreFichero) throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream cursosOS = new ObjectInputStream(new FileInputStream(nombreFichero));
        Curso micurso;
        micurso = (Curso) cursosOS.readObject();
        while (micurso != null) {

            System.out.println("El curso es " + micurso);
            micurso = (Curso) cursosOS.readObject();
        }

    }

    /**
     * 
     * @param leer
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static void mediaDuracionCursos(ObjectInputStream leer) throws IOException, ClassNotFoundException {

        int totalDuracion = 0;
        int numeroCursos = 0;
        double media = 0;
        HashMap<String, Curso> cursos;
        Curso micurso;
        cursos = (HashMap<String, Curso>) leer.readObject();
        // Iteramos el map 
        Iterator it = cursos.keySet().iterator();

        // Recorremos el map e imprimimos la clave y el valor 
        while (it.hasNext()) {
            String clave = (String) it.next();
            Curso curso = (Curso) cursos.get(clave);
            totalDuracion += curso.duracion;
            numeroCursos += 1;
        }
        media = Double.parseDouble(Integer.toString(totalDuracion)) / Double.parseDouble(Integer.toString(numeroCursos));
        System.out.println("\nLa duracion media de los cursos es: " + Double.toString(media));
        System.out.println("");
    }

    /**
     * 
     * @param leer
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static void mayorDuracion(ObjectInputStream leer) throws IOException, ClassNotFoundException {

        int maximo = 0;
        HashMap<String, Curso> cursos;
        Curso micurso;
        cursos = (HashMap<String, Curso>) leer.readObject();
        // Iteramos el map 
        Iterator it = cursos.keySet().iterator();

        // Recorremos el map e imprimimos la clave y el valor 
        while (it.hasNext()) {
            String clave = (String) it.next();
            Curso curso = (Curso) cursos.get(clave);

            if (curso.duracion > maximo) {
                maximo = curso.duracion;
            }
        }

        System.out.println("\nLa duracion del curso mas largo es de: " + Integer.toString(maximo));
    }

    /**
     * Metodo para mostrar el menu
     *
     */
    public static void mostrarMenu() {
        System.out.println("Menú:\n"
                + "1) Numerar cursos\n"
                + "2) Duración media\n"
                + "3) Duración total\n"
                + "4) Salir\n");

    }

    /**
     *
     * @param teclado
     * @return
     * @throws IOException
     */
    public static String pedirOpcion(BufferedReader teclado) throws IOException {
        System.out.println("Tu opcion: ");
        return teclado.readLine().toUpperCase();
    }
}
