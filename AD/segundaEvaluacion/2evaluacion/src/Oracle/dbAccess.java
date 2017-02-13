/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AlumnoT
 */
public class dbAccess {

    public static void main(String args[]) throws SQLException {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@WIN01:1521:oracleBD", "prueba", "root");
        // driver@machineName:port:SID           ,  userid,  password
        Statement stmt = conn.createStatement();
        ResultSet rset
                = stmt.executeQuery("select BANNER from SYS.V_$VERSION");
        while (rset.next()) {
            System.out.println(rset.getString(1));   // Print col 1
        }
        stmt.close();

    }
}
