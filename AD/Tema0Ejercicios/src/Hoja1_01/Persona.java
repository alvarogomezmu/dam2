package Hoja1_01;

/**
 *
 * @author AlumnoT
 */
public class Persona {

    private String rut;
    private String nombre;

    public Persona(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
    }


    public void nuevaPersona(String r, String n) {
        rut = r;
        nombre = n;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "rut=" + rut + ", nombre=" + nombre + '}';
    }
}
