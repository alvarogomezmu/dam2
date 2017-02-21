/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea2_Sqlite;

/**
 *
 * @author Alvaro
 */
public class Empleados {

    Integer idEmpleado;
    String apellido;
    Double comision;
    Integer idDepartamento;

    public Empleados(Integer idEmpleado, String apellido, Double comision, Integer idDepartamento) {
        this.idEmpleado = idEmpleado;
        this.apellido = apellido;
        this.comision = comision;
        this.idDepartamento = idDepartamento;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public String toString() {
        return "Empleados{" + "idEmpleado=" + idEmpleado + ", apellido=" + apellido + ", comision=" + comision + ", idDepartamento=" + idDepartamento + '}';
    }
    
}
