package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
        
        createNewTable();
        insertarDatos();

    }

    /**
     * Create a new table in the test database
     *
     */
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\sqlite3\\curso.db";

        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS ejemplo (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	nom text NOT NULL,\n"
                + "	sueldo integer\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
