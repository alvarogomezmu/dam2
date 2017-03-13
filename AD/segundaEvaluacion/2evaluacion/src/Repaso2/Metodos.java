package Repaso2;

import java.sql.Connection;
import Herramientas.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Principal;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    public static void crearTablaCliente(Connection c) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Cliente (\n"
                + "	codigo INTEGER PRIMARY KEY not null,\n"
                + "	edad INTEGER NOT NULL,\n"
                + "	direccion VARCHAR(30));";
        Herramientas.crearTabla_SQLite(c, sql);
        c.close();

    }

    // código, descripción, fecha pedido, email contacto, telefonocliente., código_cliente
    public static void crearTablaPedido(Connection c) {

        String sql = "CREATE TABLE IF NOT EXISTS Pedido (\n"
                + "	codigo INTEGER PRIMARY KEY not null,\n"
                + "	descripcion VARCHAR(30),\n"
                + "	fechaPedido INTEGER NOT NULL,\n"
                + "	emailContacto VARCHAR(30),\n"
                + "	telefonoCliente INTEGER NOT NULL,\n"
                + "	codigoCliente INTEGER NOT NULL,\n"
                + "     FOREIGN KEY(codigoCliente) REFERENCES Cliente(codigo));";
        Herramientas.crearTabla_SQLite(c, sql);
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
                    i.setInt(2, Integer.parseInt(st.nextToken()));
                    i.setString(3, (String) st.nextToken());
                    i.executeUpdate();

                }
            }
            leer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearPedidos() throws SQLException {
        Pedido ped1 = new Pedido();
        ped1.nuevoPedido(111, "urgente", 11, "loquieroya@yahoo.es", 656600978, 1);

        Pedido ped2 = new Pedido();
        ped2.nuevoPedido(222, "normal", 22, "juanjo@ono.com", 644346090, 2);

        Pedido ped3 = new Pedido();
        ped3.nuevoPedido(333, "defectuoso", 33, "repararlo@yahoo.es", 650909003, 3);

        HashMap<String, Object> map1 = new HashMap<>();

        map1.put("1a", ped1);
        map1.put("2a", ped2);
        map1.put("3a", ped3);

        System.out.println("Los pedidos son: ");
        System.out.println("codigo: " + ped1.codigo + " descripcion: " + ped1.descripcion + " fechaPedido: " + ped1.fechaPedido + " emailContacto: " + ped1.emailContacto + " telefonoCliente: " + ped1.telefonoCliente + " codigoCliente:" + ped1.codigoCliente);
        System.out.println("codigo: " + ped2.codigo + " descripcion: " + ped2.descripcion + " fechaPedido: " + ped2.fechaPedido + " emailContacto: " + ped2.emailContacto + " telefonoCliente: " + ped2.telefonoCliente + " codigoCliente:" + ped2.codigoCliente);
        System.out.println("codigo: " + ped3.codigo + " descripcion: " + ped3.descripcion + " fechaPedido: " + ped3.fechaPedido + " emailContacto: " + ped3.emailContacto + " telefonoCliente: " + ped3.telefonoCliente + " codigoCliente:" + ped3.codigoCliente);

        PreparedStatement ps = Herramientas.connectSQLite("repaso2").prepareStatement("INSERT INTO Pedido(codigo,descripcion, fechaPedido, emailContacto, telefonoCliente, codigoCliente) values (?, ?,?,?,?,?)");
        for (Map.Entry<String, Object> entries : map1.entrySet()) {
            Pedido pedido = (Pedido) entries.getValue();
            ps.setInt(1, pedido.getCodigo());
            ps.setString(2, pedido.getDescripcion());
            ps.setInt(3, pedido.getFechaPedido());
            ps.setString(4, pedido.getEmailContacto());
            ps.setInt(5, pedido.getTelefonoCliente());
            ps.setInt(6, pedido.getCodigoCliente());

            ps.executeUpdate();
        }
    }

    public static void mostrarMenu() {
        System.out.println("\n1- Mostrar todos los datos de cada tabla.");
        System.out.println("2- Mostrar los datos del pedido realizado en la provincia de Madrid.");
        System.out.println("3.- Mostrar la dirección del cliente que haya realizado una cantidad de pedidos mayor a 5.");
        System.out.println("4.- Terminar.");
    }

    public static void pedirOpcion() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\repaso2.db");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int opcion = 0;
            while (opcion != 4) {
                mostrarMenu();

                System.out.println("Introduzca una opcion válida del menu:");
                opcion = Integer.parseInt(br.readLine());

                switch (opcion) {
                    case 1:

                        /**
                         * Mostrar todos los datos de cada tabla
                         */
                        PreparedStatement psCliente = conn.prepareStatement("SELECT * from Cliente;");
                        PreparedStatement psPedido = conn.prepareStatement("SELECT * from Pedido;");
                        ResultSet rsCliente = psCliente.executeQuery();
                        ResultSet rsPedido = psPedido.executeQuery();
                        while (rsCliente.next()) {
                            System.out.println("codigo:" + rsCliente.getString(1) + " edad:" + rsCliente.getString(2) + " direccion:" + rsCliente.getString(3));
                        }
                        rsCliente.close();
                        while (rsPedido.next()) {
                            System.out.println("codigo: " + rsPedido.getString(1) + " descripcion:" + rsPedido.getString(2) + " fecha pedido:" + rsPedido.getString(3) + " email contacto: " + rsPedido.getString(4) + " telefono cliente:" + rsPedido.getString(5) + " codigo cliente:" + rsPedido.getString(6));
                        }
                        break;

                    case 2:

                        PreparedStatement psMadrid = conn.prepareStatement("SELECT * from pedido p join cliente c on c.codigo=p.codigoCliente where c.direccion='Madrid';");
                        ResultSet rsMadrid = psMadrid.executeQuery();
                        while (rsMadrid.next()) {
                            System.out.println("codigo: " + rsMadrid.getString(1) + " descripcion: " + rsMadrid.getString(2) + " fecha pedido: " + rsMadrid.getString(3) + " email contacto: " + rsMadrid.getString(4) + " telefono cliente: " + rsMadrid.getString(5) + "codigoCliente: " + rsMadrid.getString(6));
                        }
                        break;
                    case 3:
                        PreparedStatement psCantidad = conn.prepareStatement("SELECT c.direccion, count(p.codigoCliente) from cliente c join pedido p on p.codigoCliente=c.codigo where (select count(codigo) from pedido where codigoCliente=c.codigo)>5;");
                        ResultSet rsCantidad = psCantidad.executeQuery();
                        while (rsCantidad.next()) {
                            System.out.println("La direccion de cliente que haya realizado una cantidad de pedidos mayor a 5 es: " + rsCantidad.getString(1));
                        }
                        break;
                    case 4:
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
