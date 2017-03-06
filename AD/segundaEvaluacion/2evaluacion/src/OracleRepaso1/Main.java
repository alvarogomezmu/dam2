/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OracleRepaso1;

import Herramientas.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Alvaro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{  
  
        Connection conn = null;  
        try {  
            // Creamos la conexion  
            Herramientas.connectORACLE("usu1", "root");
              
             CallableStatement cStmt = conn.prepareCall("{call CATEGORIA_ES(?)}");    
             cStmt.setString(1, "abcdefg");      
             cStmt.registerOutParameter("inOutParam", Types.VARCHAR);    
               
             cStmt.execute();    
             final ResultSet rs = cStmt.getResultSet();  
               
             while (rs.next()) {  
                 System.out.println("Cadena de caracteres pasada como parametro de entrada="+rs.getString("inputParam"));  
             }    
               
             int outputValue = cStmt.getInt("inOutParam");  
             System.out.println("Parametro de salida incrementado="+outputValue);  
          
              
          
        }catch (Exception e) {  
            conn.rollback();  
            e.printStackTrace();  
        }finally{  
            conn.close();  
        }  
    }  
} 