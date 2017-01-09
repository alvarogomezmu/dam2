/**
 * Crear un programa que pida por teclado el TIPO de fichero con el que queremos
 * trabajar.
 *
 * EJEMPLOS DE TIPOS: A (ALEATORIO) S (SERIALIZADO) SE (SECUENCIAL) ETC...
 *
 * Deberemos crear un menú con las dos opciones siguientes implementadas
 * mediante métodos.
 *
 * Cada opción del menú debe tener la letra del tipo de fichero que vosotros
 * vais a implementar.
 *
 * -------
 *
 * Opcion1. Crear un fichero POR TECLADO pidiendo: Código (string), nombre
 * (string) y precio (integer) nos tiene que pedir 4 veces la Información a
 * guardar.
 *
 * El fichero se llamará medicamentos.txt. Una vez lo tengamos creado tenemos
 * que mostrar un menú como el que se muestra y que debe repetirse hasta que no
 * se le dé a la opción de salir.
 *
 * a. todos los datos introducidos (0,25 puntos)
 *
 * b. El penúltimo dato introducido (0,25 puntos)
 *
 * c. El primero y el tercero dato introducido. (0,25 puntos)
 *
 * d. Salir
 *
 * -------
 *
 * Opcion2. Tenemos un fichero llamado animales.txt donde vamos a guardar Clases
 * Animales (Nombre, edad, raza, debe tener implementados los getter y setter) y
 * que hemos vinculado a cada animal un código que será único. Sabemos que el
 * código tiene que ser entero.
 *
 * Lo primero que debemos hacer es generar dicho fichero, crear un método para
 * implementar los animales y sus códigos (mínimo 3) (0,25 puntos)
 *
 * Una vez hecho este primer paso, crear un pequeño menú donde podamos
 * seleccionar: (no es necesario la repetición)
 *
 * a) Debemos borrar un código de animal y por lo tanto el objeto asociado.
 * Dicho código se pedirá por teclado en cuanto coincida lo debe borrar. Una vez
 * hecha dicha operación nos debe mostrar cómo queda el fichero (0,75 puntos)
 *
 * b) Debemos modificar la raza de un animal. Para ello se nos pedirá el nombre
 * del animal y una vez encontrado, debemos modificar su raza con el que
 * vosotros hayáis pedido por teclado.
 *
 * Una vez hecha dicha operación nos debe mostrar cómo queda el fichero. Ojo si
 * tenemos un nombre de animal repetido deberá modificar todas las razas que
 * coincidan con ese nombre (1 punto)
 */
package Ejercicio1;

import java.io.*;

/**
 *
 * @author Alvaro
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        /**
         * Opcion1. Crear un fichero POR TECLADO pidiendo: Código (string),
         * nombre (string) y precio (integer) nos tiene que pedir 4 veces la
         * Información a guardar.
         *
         * El fichero se llamará medicamentos.txt. Una vez lo tengamos creado
         * tenemos que mostrar un menú como el que se muestra y que debe
         * repetirse hasta que no se le dé a la opción de salir.
         *
         * a. todos los datos introducidos (0,25 puntos)
         *
         * b. El penúltimo dato introducido (0,25 puntos)
         *
         * c. El primero y el tercero dato introducido. (0,25 puntos)
         *
         * d. Salir
         */

        String opcion1 = "";

        do {
            Metodos.mostrarMenu();
            opcion1 = Metodos.pedirOpcion();

            switch (opcion1) {
                case "1":
                    Metodos.medicamentos();
                    break;
                case "2":
                    Metodos.animales();
                    break;

                case "F":
                    break;
                default:
                    System.out.println("Las opciones disponibles son 1, 2 y F");
                    Metodos.pedirOpcion();

            }

        } while (!opcion1.equals("F"));

    }
}
