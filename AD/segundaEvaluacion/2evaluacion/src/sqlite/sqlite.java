package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AlumnoT
 */
public class sqlite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Metodo para conectarnos a una BBDD sqlite
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            //c = DriverManager.getConnection("jdbc:sqlite:C\\sqlite3\\test.db");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\curso.db");
        } catch (Exception e) {
            System.out.println("error de conexion");
            System.exit(0);
        }
        System.out.println("Abierta la BBDD");
    }

}