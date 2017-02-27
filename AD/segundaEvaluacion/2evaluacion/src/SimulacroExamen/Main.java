package SimulacroExamen;

import BaseDeDatos.BBDD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author AlumnoT
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        // Metodo para conectarnos a una BBDD sqlite
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\simulacro.db");
        } catch (Exception e) {
            System.out.println("error de conexion");
            System.exit(0);
        }
        System.out.println("Abierta la BBDD");

        // llamada a los metodos
        createNewTable();
        insertarDatos();
        mostrarDatos();

    }

    /**
     * Metodo para crear tabla(s) en una base de datos de sqlite
     */
    public static void createNewTable() {
        // conexion a sqlite
        String url = "jdbc:sqlite:C:\\sqlite3\\simulacro.db";

        // SQL declaracion para crear nuevas tablas
        String Alumno = "CREATE TABLE IF NOT EXISTS Alumno (\n"
                + "	codigo integer PRIMARY KEY not null,\n"
                + "	nom VARCHAR(30) not null,\n"
                + "	edad integer not null,\n"
                + "     sexo VARCHAR(10) not null\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(Alumno);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("1. Tabla Alumno creada.");
    }

    /**
     * Metodo para insertar datos en una base de datos de sqlite
     */
    private static void insertarDatos() throws IOException {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\sqlite3\\simulacro.db";

        int codigo;
        String nom;
        int edad;
        String sexo;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner teclado = new Scanner(System.in);
        //System.out.print("Introduce el numero de alumnos que quieras introducir: ");
        int total = 0;

        System.out.println("Vamos a crear dos Alumnos.");
        System.out.println("Escriba el codigo del primer Alumno : ");
        codigo = Integer.parseInt(br.readLine());
        System.out.println("Escriba el nombre del primer Alumno : ");
        nom = br.readLine();
        System.out.println("Escriba la edad del primer Alumno : ");
        edad = Integer.parseInt(br.readLine());
        System.out.println("Escriba el sexo del primer Alumno : ");
        sexo = br.readLine();

        String Alumno = "INSERT INTO Alumno VALUES (?,?,?,?);";

        //System.out.println("Los datos del primer alumno son: " + "codigo:" + codigo + " nombre:" + nom + " edad:" + edad + " sexo:" + sexo);
        // SQL declaracion de inserciones
        //String Alumno1 = "INSERT INTO Alumno VALUES (1, 'Pepe', 15, 'Masculino');";
//        String Alumno1 = "INSERT INTO Alumno VALUES (?,?,?,?);";
//        //String Alumno2 = "INSERT INTO Alumno VALUES (2, 'Sara', 20, 'Femenino');";
//        String Alumno2 = "INSERT INTO Alumno VALUES (?,?,?,?);";
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // inserccion de datos
            String sql = "INSERT INTO Alumno VALUES(?,?,?,?)";
            sp = BBDD.getConexion().prepareStatement(sql);
            sp.setInt(1, Integer.parseInt(visto.txt2.getText()));
            sp.setString(2, this.visto.txt.getText());
            sp.setInt(3, Integer.parseInt(visto.txt2.getText()));
            sp.setString(4, this.visto.txt3.getText());
            int resultado = sp.executeUpdate();
            sp.close();
            stmt.execute(Alumno);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("2. Datos insertados en la tabla alumno.");
    }

    /**
     *
     * Metodo para mostrar las tablas de una base de datos en sqlite
     */
    private static void mostrarDatos() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\simulacro.db");
        PreparedStatement psAlumno = conn.prepareStatement("SELECT * FROM Alumno");
        ResultSet rsAlumno = psAlumno.executeQuery();

        System.out.println("3. SELECT de la tabla Alumno");
        while (rsAlumno.next()) {
            System.out.println("Alumno con dni:" + rsAlumno.getString(1) + " nombre:" + rsAlumno.getString(2) + " edad:" + rsAlumno.getString(3) + " sexo:" + rsAlumno.getString(4));
        }
        rsAlumno.close();
    }

}
