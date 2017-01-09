package ficheroSerializable;

import java.util.*;
import java.io.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        Persona p1 = new Persona("Pepe", 22);
        Persona p2 = new Persona("Dani", 31);
        Persona p3 = new Persona("Juan", 55);

        // Stream para escribir
        ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("fichero.dat"));
        
        // escribimos las 3 personas
        escribir.writeObject(p1);
        escribir.writeObject(p2);
        escribir.writeObject(p3);
        
        escribir.close();
        
        // LEER
        ObjectInputStream leer = new ObjectInputStream(new FileInputStream("fichero.dat"));
        p1 = (Persona) leer.readObject();
        p2 = (Persona) leer.readObject();
        p3 = (Persona) leer.readObject();
        
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        
        leer.close();

    }

}
