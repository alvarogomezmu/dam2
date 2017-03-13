/*
 SQLITE-JAVA 
 Realizar una inserción masiva: 
 Cliente (código, edad, dirección)
 Pedidos (código, descripción, fecha pedido, email contacto, telefonocliente., código_cliente)
 Los datos de cliente se encuentran en un fichero token. Realizar la inserción masiva en la tabla. 
 Los datos de pedidos  los hemos guardado temporalmente en una estructura COLLECTION. Ahora debemos volcar dichos datos a la tabla. 
 Deberemos realizar las siguientes consultas sobre la tabla:
 -Mostrar todos los datos de cada tabla 
 -Mostrar los datos del pedido realizado en la provincia de Madrid 
 -Mostrar la dirección del cliente que haya realizado una cantidad de pedidos mayor a 5 
 */
package Repaso2;

import Herramientas.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Alvaro
 */
public class Main {
    /*
     CREATE TABLE Cliente (
     codigo INTEGER PRIMARY KEY not null, 
     edad varchar(30) not null,
     ); 

     CREATE TABLE Departamento (
     DEPARTMENT_ID integer PRIMARY KEY not null, 
     DEPARTMENT_NAME varchar(30) not null, 
     LOCATION_ID integer not null, 
     FOREIGN KEY(LOCATION_ID) REFERENCES Localidad(LOCATION_ID));

     CREATE TABLE Empleados (
     EMPLOYEE_ID integer PRIMARY KEY not null, 
     LAST_NAME varchar(30) not null, 
     COMMISION real not null, 
     DEPARTMENT_ID integer not null, 
     FOREIGN KEY(DEPARTMENT_ID) REFERENCES Departamento(DEPARTMENT_ID));
     */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, SQLException, Exception {
//        // TODO code application logic here
        Connection c = null;
        // conexion a la db
        c = Herramientas.connectSQLite("repaso2");
        Metodos.crearTablaCliente(c); // dentro del metodo se cierra la conexion a la db
        c = Herramientas.connectSQLite("repaso2"); // se vuelve a abrir la db
        Metodos.crearTablaPedido(c);
        c.close(); // db cerrada
        
        c = Herramientas.connectSQLite("repaso2");
        Metodos.leerTokenTabla("DatosCliente", "@", c, "insert into Cliente values(?,?,?)");
        
        Metodos.crearPedidos();
        
        //Metodos.mostrarMenu();
        Metodos.pedirOpcion();
        
        
        
        
    }

    
}
