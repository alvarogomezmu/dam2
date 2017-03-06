package Herramientas;

import java.io.*;
import java.sql.*;
import java.util.*;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author AlumnoT
 */
public class Herramientas {

    // Metodo para conectarnos a una BBDD sqlite
    public static Connection connectSQLite(String ruta) {
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\" + ruta + ".db");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al iniciar la DB D:");
        }
        return c;
    }

    public static Connection connectORACLE(String user, String pass) {
        String host = "localhost"; // O ip como "192.168.35.185"
        String puerto = "1521";
        String sid = "XE";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String ulrjdbc = "jdbc:oracle:thin:" + user + "/" + pass + "@" + host + ":" + puerto + ":" + sid;

        Connection c = null;

        try {
            Class.forName(driver).newInstance();
            c = DriverManager.getConnection(ulrjdbc);
            System.out.println("BD Abierta con exito");
        } catch (Exception e) {
            System.out.println("Error al abrir BD");
            e.printStackTrace();
        }
        return c;
    }
//--------------------------------------------
//--------------------------------------------
//--------------------------------------------

    public static void crearTabla_SQLite(Connection c, String sql) {
        Statement s = null;
        try {
            s = c.createStatement();
            s.executeUpdate(sql);

            s.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en la creacion.");
            System.exit(0);
        }
        System.out.println("Creacion con exito!");

    }
//--------------------------------------------
//--------------------------------------------
//--------------------------------------------

    public static void insertarDatosTabla_SQLite(Connection c, String tabla) {
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement("insert into " + tabla + " values(?,?);");

            // posicion del campo, valor
            ps.setInt(1, 100);
            ps.setString(2, "prueba1");
            ps.executeUpdate();

            ps.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en la insercion.");
            System.exit(0);
        }
        System.out.println("Insercion realizada!");
    }

    public static void insertarDatosColeccionTabla_SQLite(Connection c, String tabla, ArrayList lista) {
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement("insert into " + tabla + " values(?,?);");

            Iterator it = lista.iterator();
            while (it.hasNext()) {
                ps.setInt(1, (int) it.next());
                ps.setString(2, (String) it.next());
                ps.executeUpdate();
            }

            ps.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en la insercion.");
            System.exit(0);
        }
        System.out.println("Insercion realizada!");
    }
//--------------------------------------------
//--------------------------------------------
//--------------------------------------------

    public static void mostrarDatosTablaSQLite() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\nombre.db");
        PreparedStatement psTableName = conn.prepareStatement("SELECT * FROM tableName");
        ResultSet rsTableName = psTableName.executeQuery();

        System.out.println("SELECT de los datos de tableName:");
        while (rsTableName.next()) {
            System.out.println("dato1:" + rsTableName.getString(1) + " dato2:" + rsTableName.getString(2));
        }
        rsTableName.close();
    }

    public static void consulta_SQL(Connection c, String consulta) {
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(consulta);
            ps.setInt(1, 100);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

            ps.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en la consulta.");
            System.exit(0);
        }
        System.out.println("consulta realizada!");
    }
//--------------------------------------------
//--------------------------------------------
//--------------------------------------------

    public static void insertarDatosFicheroTokenTabla_SQLite(Connection c, String tabla, String fichero, String caracter) {
        PreparedStatement ps = null;
        try {
            BufferedReader leer = new BufferedReader(new FileReader(fichero));

            ps = c.prepareStatement("insert into " + tabla + " values(?,?);");

            String linea;
            while ((linea = leer.readLine()) != null) {

                StringTokenizer token = new StringTokenizer(linea, caracter);

                while (token.hasMoreTokens()) {
                    ps.setInt(1, Integer.parseInt(token.nextToken()));
                    ps.setString(2, (String) token.nextToken());
                    ps.executeUpdate();
                }
            }

            ps.close();
            c.close();

        } catch (Exception e) {
            System.out.println("Error en la insercion.");
            System.exit(0);
        }
        System.out.println("Insercion realizada!");
    }

    public static void leerTokenTabla(String fichero, String tokenBase, Connection c, String orden) throws Exception {
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

//--------------------------------------------
//--------------------------------------------
//--------------------------------------------
    public static void actualizarDatosTabla_SQLite(Connection c, String tabla) {
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try {
            ps = c.prepareStatement("update " + tabla + " set sueldo=sueldo+100 where sueldo between ? and ?");
            ps.setInt(1, 500);
            ps.setInt(2, 1200);
            ps.executeUpdate();

            //Consulta para ver los cambios
            //Statement s=c.createStatement();
            //ResultSet rs=s.executeQuery("select*from "+tabla);
            //while(rs.next())
            //{
            //    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
            //}
            ps2 = c.prepareStatement("select*from " + tabla + " where id>?");
            ps2.setInt(1, 0);
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }

            ps.close();
            ps2.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en la actualizacion.");
            System.exit(0);
        }
        System.out.println("actualizacion realizada!");
    }
//--------------------------------------------
//--------------------------------------------
//--------------------------------------------

    public static void eliminarDatosTabla_SQLite(Connection c, String tabla) {
        PreparedStatement ps = null;
        Statement s = null;
        try {
            ps = c.prepareStatement("delete from " + tabla + " where nom like ?");
            ps.setString(1, "s%");
            ps.executeUpdate();

            //Consulta para ver los cambios
            s = c.createStatement();
            ResultSet rs = s.executeQuery("select*from " + tabla);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }

            ps.close();
            s.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en la eliminacion.");
            System.exit(0);
        }
        System.out.println("eliminacion realizada!");
    }
//--------------------------------------------
//--------------------------------------------
//--------------------------------------------

    public void LLamarProcedimientoOracle(Connection c, String nombreProcedimiento) {
        try {
            int id, max_salario;
            CallableStatement cs = c.prepareCall("{call" + nombreProcedimiento + "(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();
            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                id = rs.getInt(1);
                max_salario = rs.getInt(2);
                System.out.println(id + " " + max_salario);
            }
            rs.close();
            cs.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LLamarFuncionOracle(Connection c, String nombreFuncion) {
        try {
            CallableStatement cs = c.prepareCall("{?=call" + nombreFuncion + "}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.executeUpdate();
            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

            cs.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
