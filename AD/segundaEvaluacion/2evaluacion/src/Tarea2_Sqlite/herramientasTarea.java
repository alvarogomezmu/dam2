package Tarea2_Sqlite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.StringTokenizer;

public class herramientasTarea {

    public static Connection conectarBD(String nombre) {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\" + nombre + ".db");
            System.out.println("Abierta la BBDD");

        } catch (Exception e) {
            System.out.println("Error en la conexion");
            System.exit(0);
        }

        return c;
    }

    public static void leerToken(String fichero, String tokenBase, Connection c, String orden) throws Exception {
        try {

            PreparedStatement i = c.prepareStatement(orden);
            BufferedReader leer = new BufferedReader(new FileReader(fichero + ".txt"));

            String linea;
            while ((linea = leer.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, tokenBase);
                while (st.hasMoreTokens()) {

                    i.setInt(1, Integer.parseInt(st.nextToken()));
                    i.setString(2, (String) st.nextToken());
                    i.setString(3, (String) st.nextToken());
                    i.executeUpdate();

                }
            }
            leer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
