/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Alvaro
 */
public class Serializacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // TODO code application logic here

        Coche c1 = new Coche("bmw", "rojo",1);
        Coche c2 = new Coche("honda", "plateado",5);

        ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("fichero.dat"));

        escribir.writeObject(c1);
        escribir.writeObject(c2);
        escribir.close();

        // leer
        ObjectInputStream leer = new ObjectInputStream(new FileInputStream("fichero.dat"));
        c1 = (Coche) leer.readObject();
        c2 = (Coche) leer.readObject();
        leer.
            
        //mostramos los coches
        System.out.println("coche A: " + c1.marca + c1.color+c1.cantidad);
        System.out.println("coche B: " + c2.marca + c2.color + c2.cantidad);
        
        leer.close();

    }

}
