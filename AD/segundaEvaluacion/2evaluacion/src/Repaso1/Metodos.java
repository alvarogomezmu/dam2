package Repaso1;

import java.sql.*;
import Herramientas.*;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    // Method before been renamed: callOracleStoredProcOUTParameter
    public static void ApartadoUno() throws SQLException {

        Connection dbConnection = null;
        CallableStatement callableStatement = null;

        String getDBUSERByUserIdSql = "{call CATEGORIA_ES(?,?)}";

        try {
            dbConnection = Herramientas.connectORACLE("usu1", "root");
            callableStatement = dbConnection.prepareCall(getDBUSERByUserIdSql);

            callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);

            callableStatement.executeUpdate();

            String titulo = callableStatement.getString(1);
            String categoria = callableStatement.getString(2);

            System.out.println("titulo : " + titulo);
            System.out.println("categoria : " + categoria);

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


    public static void ApartadoDos() throws SQLException {

        Connection conn = null;

        try {
            // Creamos la conexion  
            conn = Herramientas.connectORACLE("usu1", "root");
            conn.setAutoCommit(false);

            String nombre="";
            CallableStatement cs = conn.prepareCall("{?=call AUTORESDOSLIBROS(?)}");
            cs.registerOutParameter(1, java.sql.Types.VARCHAR);
            cs.setString(2, "Aventura");
            cs.executeUpdate();
            nombre=cs.getString(1);
            System.out.println(nombre);

        }catch (Exception e) {  
            conn.rollback();  
            e.printStackTrace();  
        }finally{  
            conn.close();  
        }  
    }  

    public static void ApartadoTres() throws SQLException {
        Connection conn = null;

        try {
            // Creamos la conexion  
            conn = Herramientas.connectORACLE("usu1", "root");
            conn.setAutoCommit(false);

            String nombre="";
            CallableStatement cs = conn.prepareCall("{call MASVIEJO(?)}");
            cs.registerOutParameter(1, java.sql.Types.VARCHAR);
            cs.executeUpdate();
            nombre=cs.getString(1);
            System.out.println(nombre);

        }catch (Exception e) {  
            conn.rollback();  
            e.printStackTrace();  
        }finally{  
            conn.close();  
        }  
    }
}
