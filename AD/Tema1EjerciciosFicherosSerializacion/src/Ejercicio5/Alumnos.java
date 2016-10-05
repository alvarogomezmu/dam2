package Ejercicio5;

/**
 *
 * @author AlumnoT
 */
public class Alumnos implements java.io.Serializable {

    private int nAlumnos;
    private String nombre;
    private String sexo;
    private int edad;
    private double estatura;
    private double peso;

    public Alumnos(int nAlumnos, String nombre, String sexo, int edad, double estatura, double peso) {
        this.nAlumnos = nAlumnos;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.estatura = estatura;
        this.peso = peso;
    }

    public Alumnos() {
    }

    public int getnAlumnos() {
        return nAlumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public double getEstatura() {
        return estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setnAlumnos(int nAlumnos) {
        this.nAlumnos = nAlumnos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Alumnos{" + "nAlumnos=" + nAlumnos + ", nombre=" + nombre + ", sexo=" + sexo + ", edad=" + edad + ", estatura=" + estatura + ", peso=" + peso + '}';
    }
}
