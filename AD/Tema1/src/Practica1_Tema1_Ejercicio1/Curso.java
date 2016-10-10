package Practica1_Tema1_Ejercicio1;

/**
 *
 * @author AlumnoT
 */
public class Curso {

    String nombre;
    Integer duracion;

    public Curso(String nombre, Integer duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Curso{" + "nombre=" + nombre + ", duracion=" + duracion + '}';
    }

}
