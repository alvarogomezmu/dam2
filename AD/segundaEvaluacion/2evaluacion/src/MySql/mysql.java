package MySql;

import sqlite.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AlumnoT
 */
public class mysql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Metodo para conectarnos a una BBDD sqlite
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:C:\\sqlite3\\curso.db");
            /*
o URL de Conexión: jdbc:mysql://<host>/<database>
             */
        } catch (Exception e) {
            System.out.println("error de conexion");
            System.exit(0);
        }
        System.out.println("Abierta la BBDD");
    }

}
