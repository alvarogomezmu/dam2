package TareaLibross;

/**
 *
 * @author AlumnoT
 */
public class main {

    public static void main(String[] args) {
        new BBDD("curso.db");//LLama a BD ppara conectar
        Vista v = new Vista();
        Controlador c = new Controlador(v);//Conectar al controlador
        v.conectaControlador(c);//Realiza la conexcion Vista + Controlador
    }
}
