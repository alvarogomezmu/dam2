/**
 * Tenemos un objeto profesor (nombre, edad, titulación) que guardamos en dos
 * estructuras map<DNI, profesor>, queremos comparar los profesores guardados en
 * el primer Map con el segundo Map. Intenta crear un método que nos compare las
 * dos estructuras. Nos debe informar de los valores repetidos en la estructura.
 * Quiero ver los profesores iguales.
 */
package Practica2_Tema0_Ejercicio1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alvaro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creamos 6 profesores
        Profesor profe1 = new Profesor();
        profe1.nuevoProfesor("Pepe", 33, "Biologia");

        Profesor profe2 = new Profesor();
        profe2.nuevoProfesor("Juan", 45, "Matematicas");

        Profesor profe3 = new Profesor();
        profe3.nuevoProfesor("Eduardo", 27, "Lengua");

        Profesor profe4 = new Profesor();
        profe4.nuevoProfesor("Pepe", 33, "Biologia");

        Profesor profe5 = new Profesor();
        profe5.nuevoProfesor("Antonio", 56, "Ingles");

        Profesor profe6 = new Profesor();
        profe6.nuevoProfesor("Juan", 45, "Matematicas");

        // Declaramos los 2 HashMap
        HashMap<String, Object> map1 = new HashMap<>();
        HashMap<String, Object> map2 = new HashMap<>();

        // Añadimos los profesores a los maps, poniendo 3 en cada uno
        map1.put("12345678A", profe1);
        map1.put("56411501C", profe2);
        map1.put("48161616X", profe3);

        map2.put("12345678A", profe4);
        map2.put("93819832C", profe5);
        map2.put("56411501C", profe6);

        System.out.println("Los profesores son:");
        System.out.println("Nombre:"+profe1.nombre+" Edad:"+profe1.edad+" Titulacion:"+profe1.titulacion);
        System.out.println("Nombre:"+profe2.nombre+" Edad:"+profe2.edad+" Titulacion:"+profe2.titulacion);
        System.out.println("Nombre:"+profe3.nombre+" Edad:"+profe3.edad+" Titulacion:"+profe3.titulacion);
        System.out.println("Nombre:"+profe4.nombre+" Edad:"+profe4.edad+" Titulacion:"+profe4.titulacion);
        System.out.println("Nombre:"+profe5.nombre+" Edad:"+profe5.edad+" Titulacion:"+profe5.titulacion);
        System.out.println("Nombre:"+profe6.nombre+" Edad:"+profe6.edad+" Titulacion:"+profe6.titulacion);
        
        System.out.println("\n\nDatos de los profesores repetidos:");
        Profesor.comparaProfes(map1, map2);
    }

}
