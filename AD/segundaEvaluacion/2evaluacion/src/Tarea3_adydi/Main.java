/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea3_adydi;

import java.sql.Connection;

/**
 *
 * @author Alvaro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Connection c = null;

        c = HerramientasTarea3.conectarBD("tarea3");
        HerramientasTarea3.createTableEmpleado();
        HerramientasTarea3.leerTokenEmpleado("FicheroEmpleado", "#", c, "insert  into Empleado values(?,?,?,?,?,?,?,?,?,?,?)");
        HerramientasTarea3.mostrarEmpleados();
        HerramientasTarea3.borrarEmpleado();
        
    }

}
