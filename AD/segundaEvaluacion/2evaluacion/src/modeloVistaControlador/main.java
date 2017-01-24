/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVistaControlador;

import static java.awt.PageAttributes.MediaType.C;
import static javafx.scene.input.KeyCode.V;

/**
 *
 * @author AlumnoT
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new BBDD("test.db"); // llama a BBDD para conectar
	Vista v = new Vista(); //instancia ventana
        Controlador c = new Controlador(v); // conecta la vista al controlador
        v.conectarControlador(c); // realiza la conexion + vista + controlador
        
    }

}
