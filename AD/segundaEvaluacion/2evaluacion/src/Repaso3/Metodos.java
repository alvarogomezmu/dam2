/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso3;

import java.sql.*;
import Herramientas.*;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    public static void ApartadoUno() throws SQLException {

        Connection dbConnection = null;
        CallableStatement callableStatement = null;

        String getDBUSERByUserIdSql = "{call sueldo_mayor_de(?)}";

        try {
            dbConnection = Herramientas.connectORACLE("hr", "root");
            callableStatement = dbConnection.prepareCall(getDBUSERByUserIdSql);

            callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);

            callableStatement.executeUpdate();

            String nombre = callableStatement.getString(1);

            System.out.println("nombre : " + nombre);

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static void apartadoTres() throws SQLException {
        Connection dbConnection = null;
        CallableStatement callableStatement = null;

        String getDBUSERByUserIdSql = "{call INSERTP(?,?,?)}";

        try {
            dbConnection = Herramientas.connectORACLE("hr", "root");
            callableStatement = dbConnection.prepareCall(getDBUSERByUserIdSql);

            callableStatement.setString(1,"NOMBRE_ASIG");
            callableStatement.setString(2,"NOMBRE_PROF");
            callableStatement.setInt("id", 3);
            callableStatement.registerOutParameter("inOutParam", Types.INTEGER);

            callableStatement.execute();
            final ResultSet rs = callableStatement.getResultSet(); 
            
             while (rs.next()) {  
                 System.out.println("Cadena de caracteres pasada como parametro de entrada="+rs.getString("inputParam"));  
             } 
             
             int outputValue = callableStatement.getInt("inOutParam");  
             System.out.println("Parametro de salida incrementado="+outputValue); 

//            String nombreAsig = callableStatement.getString(1);
//            String nombreProf = callableStatement.getString(2);
//            String id = callableStatement.getString(3);
//
//            System.out.println("nombreAsig : " + nombreAsig);
//            System.out.println("nombreProf : " + nombreProf);
//            System.out.println("id : " + id);

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    
    public static void Apartado() throws SQLException {

        Connection dbConnection = null;
        CallableStatement callableStatement = null;

        String getDBUSERByUserIdSql = "{call sueldo_mayor_de(?)}";

        try {
            dbConnection = Herramientas.connectORACLE("hr", "root");
            callableStatement = dbConnection.prepareCall(getDBUSERByUserIdSql);

            callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);

            callableStatement.executeUpdate();

            String nombre = callableStatement.getString(1);

            System.out.println("nombre : " + nombre);

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

}
