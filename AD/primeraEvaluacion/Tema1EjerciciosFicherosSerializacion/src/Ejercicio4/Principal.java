/**
 * Crear un objeto Empleados con los atributos (nombre,edad y salario)
 * debemos serializarlo de tal manera que podamos guardarlo en un ArrayList.
 * Modificar los datos , por ejemplo cambiar el salario de los empleados que tienen una edad comprendida entre 20 y 30 años.
 * Una vez hecho volcamos los datos en un fichero.
 *
 */
package Ejercicio4;

import java.util.*;
import java.io.*;
import Herramientas.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Empleados obj1 = new Empleados("David", 22, 235.6);
        Empleados obj2 = new Empleados("Mama", 42, 1050.36);
        Empleados obj3 = new Empleados("Papa", 44, 444.3);

        ArrayList<Empleados> personas = new ArrayList();
        personas.add(obj1);
        personas.add(obj2);
        personas.add(obj3);

        Iterator it = personas.iterator();
        while (it.hasNext()) {//mientras haya objeto que me lea
            Empleados e = (Empleados) it.next();//cada objeto de un objeto del arraylist
            if (e.getEdad() <= 30 && e.getEdad() > 20) {
                e.setSalario(2000);
            }
        }

        ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("eje4hoja.dat"));
        Herramientas.escribirObjetos(escribir, personas);
        ObjectInputStream leer = new ObjectInputStream(new FileInputStream("eje4hoja.dat"));
        Herramientas.leerObjetos(leer);
        for(int i=0; i<4; i++){
            
        }
        
    }

}
