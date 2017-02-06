package TareaLibros;

/**
 *
 * @author Alvaro Gomez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // TODO code application logic here

        new BBDD("tarealibros.db");//llamar BBD para conectar
        Vista v = new Vista();//introducir ventana
        Controlador c = new Controlador(v);//conectar  vista controlador
        v.conectarContador(c);//relizar conexion +vista+conexion
    }

}