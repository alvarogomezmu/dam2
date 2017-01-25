package modeloVistaControlador;

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
