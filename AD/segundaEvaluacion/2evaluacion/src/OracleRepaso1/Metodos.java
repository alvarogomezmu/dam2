package OracleRepaso1;

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

//    public static void ApartadoDoss() throws SQLException {
//
//        CallableStatement callableStatement = null;
//        Connection dbConnection = null;
//
//        String getDBUSERByUserIdSql = "{call AUTORESDOSLIBROS(?)}";
//
//        try {
//            dbConnection = Herramientas.connectORACLE("usu1", "root");
//            callableStatement = dbConnection.prepareCall(getDBUSERByUserIdSql);
//
//            callableStatement.setString(1, "Aventura");
//            callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
//
//            callableStatement.execute();
//            
//            final ResultSet rs = callableStatement.getResultSet();
//
//            while (rs.next()) {  
//                 System.out.println("Autores que han escrito 2 o mas libros sobre el tema 'Aventura':"+rs.getString("inputParam"));  
//             }
//            String nombre = callableStatement.getString(1);  
//            //System.out.println("Parametro de salida incrementado="+nombre);
//            //String nombre = callableStatement.getString(1);
//
//            System.out.println(" " + nombre);
//
//        } catch (SQLException e) {
//
//            System.out.println(e.getMessage());
//
//        } finally {
//
//            if (callableStatement != null) {
//                callableStatement.close();
//            }
//
//            if (dbConnection != null) {
//                dbConnection.close();
//            }
//        }
//    }
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
//            
//            cStmt.setString(1, "Aventura");
//            cStmt.registerOutParameter(1, java.sql.Types.VARCHAR);
//
//             cStmt.executeUpdate();    
//   
//            System.out.println("Cadena de caracteres pasada como parametro de entrada="+cStmt.getString(1));  
// 
//               
//             String outputValue = cStmt.getString(1);  
//             System.out.println("Parametro de salida incrementado="+outputValue);   
        }catch (Exception e) {  
            conn.rollback();  
            e.printStackTrace();  
        }finally{  
            conn.close();  
        }  
    }  
}
