package Ejercicio3;

import java.io.*;

/**
 *
 * @author AlumnoT
 */
public class Agenda implements Serializable {

    private String s_nombre, s_apellidos, s_direccion, s_poblacion, s_fechanac;
    private int i_telefono;

    Agenda() {

    }

    Agenda(String s_nombre, String s_apellidos, String s_direccion, String s_poblacion, String s_fechanac, int i_telefono) {
        this.s_nombre = s_nombre;
        this.s_apellidos = s_apellidos;
        this.s_direccion = s_direccion;
        this.s_poblacion = s_poblacion;
        this.s_fechanac = s_fechanac;
        this.i_telefono = i_telefono;
    }

    public void setS_nombre(String s_nombre) {
        this.s_nombre = s_nombre;
    }

    public void setS_apellidos(String s_apellidos) {
        this.s_apellidos = s_apellidos;
    }

    public void setS_direccion(String s_direccion) {
        this.s_direccion = s_direccion;
    }

    public void setS_poblacion(String s_poblacion) {
        this.s_poblacion = s_poblacion;
    }

    public void setS_fechanac(String s_fechanac) {
        this.s_fechanac = s_fechanac;
    }

    public void setI_telefono(int i_telefono) {
        this.i_telefono = i_telefono;
    }

    public String getS_nombre() {
        return (s_nombre);
    }

    public String getS_apellidos() {
        return (s_apellidos);
    }

    public String getS_direccion() {
        return (s_direccion);
    }

    public String getS_poblacion() {
        return (s_poblacion);
    }

    public String getS_fechanac() {
        return (s_fechanac);
    }

    public int getI_telefono() {
        return (i_telefono);
    }

    @Override
    public String toString() {
        return "Agenda {" + "Nombre: " + s_nombre + ", Apellidos: " + s_apellidos + ", Direccion: " + s_direccion + ", Poblacion: " + s_poblacion + ", Fecha de Nacimiento: " + s_fechanac + ", Telefono: " + i_telefono + '}';
    }
}
