package Tarea2_Sqlite;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 CREATE TABLE Localidad (
 LOCATION_ID integer PRIMARY KEY not null, 
 CIUDAD varchar(30) not null); 

 CREATE TABLE Departamento (
 DEPARTMENT_ID integer PRIMARY KEY not null, 
 DEPARTMENT_NAME varchar(30) not null, 
 LOCATION_ID integer not null, 
 FOREIGN KEY(LOCATION_ID) REFERENCES Localidad(LOCATION_ID));

 CREATE TABLE Empleados (
 EMPLOYEE_ID integer PRIMARY KEY not null, 
 LAST_NAME varchar(30) not null, 
 COMMISION real not null, 
 DEPARTMENT_ID integer not null, 
 FOREIGN KEY(DEPARTMENT_ID) REFERENCES Departamento(DEPARTMENT_ID));
 */
public class HerramientasTarea2 {

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

    public static void leerTokenLocalidad(String fichero, String tokenBase, Connection c, String orden) throws Exception {
        try {

            PreparedStatement i = c.prepareStatement(orden);
            BufferedReader leer = new BufferedReader(new FileReader(fichero + ".txt"));

            String linea;
            while ((linea = leer.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, tokenBase);
                while (st.hasMoreTokens()) {

                    i.setInt(1, Integer.parseInt(st.nextToken()));
                    i.setString(2, (String) st.nextToken());
                    i.executeUpdate();

                }
            }
            leer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerTokenDepartamento(String fichero, String tokenBase, Connection c, String orden) throws Exception {
        try {

            PreparedStatement i = c.prepareStatement(orden);
            BufferedReader leer = new BufferedReader(new FileReader(fichero + ".txt"));

            String linea;
            while ((linea = leer.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, tokenBase);
                while (st.hasMoreTokens()) {

                    i.setInt(1, Integer.parseInt(st.nextToken()));
                    i.setString(2, (String) st.nextToken());
                    i.setInt(3, Integer.parseInt(st.nextToken()));
                    i.executeUpdate();

                }
            }
            leer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para insertar datos en una base de datos de sqlite
     */
    public static void insertarDatosEmpleados() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\sqlite3\\tarea2.db";

        // SQL declaracion de inserciones
        String Empleado1 = "INSERT INTO Empleados VALUES (111, 'Rodriguez', 1.1, 1123);";
        String Empleado2 = "INSERT INTO Empleados VALUES (222, 'Gomez', 2.2, 1456);";
        String Empleado3 = "INSERT INTO Empleados VALUES (333, 'Carrasco', 3.3, 1123);";
        String Empleado4 = "INSERT INTO Empleados VALUES (444, 'Alvarez', 4.4, 1123);";
        String Empleado5 = "INSERT INTO Empleados VALUES (555, 'Lopez', 5.5, 1789);";
        String Empleado6 = "INSERT INTO Empleados VALUES (666, 'Amazon', 6.6, 1456);";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // inserccion de datos
            stmt.execute(Empleado1);
            stmt.execute(Empleado2);
            stmt.execute(Empleado3);
            stmt.execute(Empleado4);
            stmt.execute(Empleado5);
            stmt.execute(Empleado6);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarMenu() {
        System.out.println("\n1- Mostrar los datos de los empleados que trabajan en departamentos cuya localidad tiene como ciudad una que empiece por v.");
        System.out.println("2- Mostrar  los departamentos donde el número de empleados que trabajan en él sea mayor a 1.");
        System.out.println("3.- Mostrar los departamentos donde trabajan mas de dos empleados y que estan en ciudades como Londres, Paris o Madrid.");
        System.out.println("4.- Mostrar el nombre y la ciudad de los departamentos  independientemente de si tienen o no empleados asignados.");
        System.out.println("5.- Actualizar la comision de los empleados que trabajan en el departamento de la localidad de \"sevilla\" incrementándola a 500.");
        System.out.println("6.- Borra los Departamentos cuyos empleados tengan en su apellido dos  letras a.");
        System.out.println("7.- Terminar.");
    }

    public static void menuEmpleados() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\tarea2.db");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int opcion = 0;
            while (opcion != 7) {
                mostrarMenu();

                System.out.println("Introduzca una opcion válida del menu:");
                opcion = Integer.parseInt(br.readLine());

                switch (opcion) {
                    case 1:

                        /**
                         * Mostrar los datos de los empleados que trabajan en
                         * departamentos cuya localidad tiene como ciudad una
                         * que empiece por v
                         */
                        PreparedStatement psEmpleado = conn.prepareStatement("SELECT employee_id, last_name, commision, E.department_id from empleados E join departamento D on D.department_id = E.department_id join localidad L on L.location_id = D.location_id where L.ciudad like 'V%';");
                        ResultSet rsEmpleado = psEmpleado.executeQuery();
                        while (rsEmpleado.next()) {
                            System.out.println("employee_id:" + rsEmpleado.getString(1) + " last_name:" + rsEmpleado.getString(2) + " comision:" + rsEmpleado.getString(3) + " department_id:" + rsEmpleado.getString(4));
                        }
                        rsEmpleado.close();
                        break;
                    case 2:

                        /**
                         * Mostrar los departamentos donde el número de
                         * empleados que trabajan en él sea mayor a 1
                         */
                        PreparedStatement psDpt = conn.prepareStatement("SELECT department_name from departamento D where(select count(employee_id) from empleados where department_id = D.department_id)>1;");
                        ResultSet rsDpt = psDpt.executeQuery();
                        while (rsDpt.next()) {
                            System.out.println("department_name:" + rsDpt.getString(1));
                        }
                        rsDpt.close();
                        break;
                    case 3:

                        /**
                         * Mostrar los departamentos donde trabajan mas de dos
                         * empleados y que estan en ciudades como Londres, Paris
                         * o Madrid
                         */
                        PreparedStatement psDpt2 = conn.prepareStatement("SELECT department_name from departamento D join localidad L on L.location_id = D.location_id where(select count(employee_id) from empleados where department_id = D.department_id)>2 and (L.ciudad='Londres' or L.ciudad='Paris' or L.ciudad='Madrid');");
                        ResultSet rsDpt2 = psDpt2.executeQuery();
                        while (rsDpt2.next()) {
                            System.out.println("department_name:" + rsDpt2.getString(1));
                        }
                        rsDpt2.close();
                        break;

                    case 4:

                        /**
                         * Mostrar el nombre y la ciudad de los departamentos
                         * independientemente de si tienen o no empleados
                         * asignados
                         */
                        PreparedStatement psDpt3 = conn.prepareStatement("SELECT department_name, L.ciudad from departamento D join localidad L on L.location_id = D.location_id;);");
                        ResultSet rsDpt3 = psDpt3.executeQuery();
                        while (rsDpt3.next()) {
                            System.out.println("department_name:" + rsDpt3.getString(1));
                        }
                        rsDpt3.close();
                        break;

                    case 5:

                        /**
                         * Actualizar la comision de los empleados que trabajan
                         * en el departamento de la localidad de "sevilla"
                         * incrementándola a 500
                         */
                        PreparedStatement psUpdate = conn.prepareStatement("UPDATE empleados SET commision = 500 where department_id IN (select E.department_id from empleados E join departamento D on d.department_id=e.department_id join localidad L on L.location_id = D.location_id where L.ciudad='Sevilla');");
                        PreparedStatement psSelect = conn.prepareStatement("Select * from empleados where department_id IN (select E.department_id from empleados E join departamento D on d.department_id=e.department_id join localidad L on L.location_id = D.location_id where L.ciudad='Sevilla');");
                        psUpdate.execute();
                        ResultSet rsSelect = psSelect.executeQuery();
                        while (rsSelect.next()) {
                            System.out.println("employee_id:" + rsSelect.getString(1) + " last_name:" + rsSelect.getString(2) + " comision:" + rsSelect.getString(3) + " department_id:" + rsSelect.getString(4));
                        }
                        rsSelect.close();
                        break;
                    case 6:

                        /**
                         * Borra los Departamentos cuyos empleados tengan en su
                         * apellido dos letras a
                         */
                        PreparedStatement psDelete = conn.prepareStatement("DELETE from empleados E where E.department_id in(select D.department_id from departamento D join empleados E on E.department_id=D.department_id where E.last_name like ’%a%’);");
                        PreparedStatement psSelectDelete = conn.prepareStatement("Select * from empleados);");
                        psDelete.execute();
                        ResultSet rsSelectDelete = psSelectDelete.executeQuery();
                        while (rsSelectDelete.next()) {
                            System.out.println("employee_id:" + rsSelectDelete.getString(1) + " last_name:" + rsSelectDelete.getString(2) + " comision:" + rsSelectDelete.getString(3) + " department_id:" + rsSelectDelete.getString(4));
                        }
                        rsSelectDelete.close();
                        break;
                    case 7:

                        System.out.println("Ejecucion finalizada.");
                        break;
                    default:
                        System.out.println("Error.");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
