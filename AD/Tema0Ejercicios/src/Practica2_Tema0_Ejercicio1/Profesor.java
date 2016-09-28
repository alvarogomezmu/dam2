package Practica2_Tema0_Ejercicio1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Alvaro
 */
public class Profesor {

    public String nombre;
    public Integer edad;
    public String titulacion;

    // Metodo constructor
    public void nuevoProfesor(String n, Integer e, String t) {
        nombre = n;
        edad = e;
        titulacion = t;
    }

    // gets y sets
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    //toString
    @Override
    public String toString() {
        return "Profesor{" + "nombre=" + nombre + ", edad=" + edad + ", titulacion=" + titulacion + '}';
    }

    // Metodo para comparar los dos HashMap mediante K-V (clave-valor)
    public static void comparaProfes(HashMap<String, Object> map, HashMap<String, Object> map2) {
        for (Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry obj1 = it.next();
            Profesor miprofe = (Profesor) obj1.getValue();

            if (map2.containsKey(obj1.getKey().toString())) {
                System.out.println("El DNI " + obj1.getKey().toString() + " esta repetido. \nPertenece al profesor de nombre: " + miprofe.getNombre() + "\nEdad: " + miprofe.edad + " años \nTitulacion: " + miprofe.titulacion + "\n");
            }
        }
    }
}
