package modeloVistaControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 *
 * @author AlumnoT
 */

public class Controlador implements ActionListener {

    Vista view;

    public Controlador(Vista view) {
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        Statement stm;

        try {
            String sql = view.txt.getText();
            stm = BBDD.getConexion().createStatement();
            stm.executeUpdate(sql);
            stm.close();
        } 
        catch (SQLException s) {
            System.out.println("Error conexion servidor");
        }

    }
}
