package ArrayListEjemplo3;

import java.util.ArrayList;
import Herramientas.*;
import java.util.Scanner;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String nombrePais;
        String nuevo,nuevo2;

        // 1. Vamos a crear un ArrayList al que le vamos a pasar 3 paises y mostrar el contenido del ArrayList
        ArrayList<String> paises = new ArrayList<String>();
        paises.add("Francia");
        paises.add("Alemania");
        paises.add("Noruega");

        System.out.println("1. Mostramos el contenido del ArrayList que acabamos de crear: ");
        Herramientas.recorrerColeccion(paises);

        // 2. Intercalar un nuevo pais en la posicion 1
        paises.add(1, "Italia");

        System.out.println("\n2. Intercalar un nuevo pais en la posicion 1: ");
        Herramientas.recorrerColeccion(paises);

        // 3. Borrar de la lista el pais que esta en la posicion 2 pero hay que hacerlo por posicion y por contenido
        System.out.println("\n3. Borrar de la lista el pais que esta en la posicion 2 (por posicion y contenido)");
        paises.remove(2);
        //paises.remove("Alemania");
        System.out.println("Mostramos el ArrayList: ");
        Herramientas.recorrerColeccion(paises);

        // 4. Mostramos como queda la lista
        System.out.println("\n4. Mostramos como queda la lista: ");
        Herramientas.recorrerColeccion(paises);

        // 5. Vamos a pedir por teclado el nombre de un pais y deberemos de indicar en que posicion se encuentra
        System.out.println("\n5. Introduzca el nombre de un pais para indicar en que posicion se encuentra: ");
        nuevo=(teclado.nextLine().toUpperCase());    
        System.out.println("El pais se encuentra en la posicion: "+paises.indexOf(nuevo));
        /*System.out.println("\n5. Introduzca el nombre de un pais para indicar en que posicion se encuentra: ");
        nombrePais = teclado.nextLine();
        System.out.println("El nombre del pais introducido es: " + nombrePais);
        //if(paises.contains(nombrePais))
        Integer posicion = 0;
        for (int i = 0; i < paises.size(); i++) {
            if (paises.get(i) == nombrePais) {
                System.out.println("Esta es a posicion: " + i);
            }
        }*/
        //System.out.println("No encontrado");        
        
        // 6. Mostrar la longitud del ArrayList
        System.out.println("\n6. La longitud del ArrayList es: " + paises.size());

        // 7. Mirar si un valor concreto (pedido por teclado) se encuentra en la lista
        System.out.println("Introduzca un valor con");
    }

}
