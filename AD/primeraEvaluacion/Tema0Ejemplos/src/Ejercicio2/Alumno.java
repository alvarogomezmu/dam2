package Ejercicio2;

/**
 *
 * @author AlumnoT
 */
public class Alumno {

    private String nombre;
    private Integer edad;
    private String Modulo;
    private Integer nota;

    public Alumno(String nombre, Integer edad, String Modulo, Integer nota) {
        this.nombre = nombre;
        this.edad = edad;
        this.Modulo = Modulo;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + getNombre() + ", edad=" + getEdad() + ", Modulo=" + getModulo() + ", nota=" + getNota() + '}';
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @return the Modulo
     */
    public String getModulo() {
        return Modulo;
    }

    /**
     * @param Modulo the Modulo to set
     */
    public void setModulo(String Modulo) {
        this.Modulo = Modulo;
    }

    /**
     * @return the nota
     */
    public Integer getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(Integer nota) {
        this.nota = nota;
    }

}
