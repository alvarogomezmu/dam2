/**
 * En un fichero de acceso aleatorio se han escrito una serie de registros
 * compuestos por dos campos enteros (int, 4 bytes) y uno real en doble
 * precisión (double, 8 bytes). Sobre el fichero se aplica el método seek de la
 * forma siguiente: fichero.seek(48).
 *
 * Si el contenido del fichero es:
 *
 * 1 5 900.2 
 * 2 23 1100.4 
 * 3 2 2000.5 
 * 4 49 1529.8
 *
 *
 * donde cada línea representa un registro, ¿qué valores se leerían al hacer
 * fichero.readInt() seguido de fichero.readInt() y fichero.readDouble()?
 *
 */
package Ejercicio3;

/**
 *
 * @author Alvaro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Se leeria el cuarto registro
    }

}
