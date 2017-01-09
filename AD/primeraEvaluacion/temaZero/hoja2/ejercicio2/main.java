
package Tema0_Ejs2_2;

import java.util.*;
import Herramientas.*;

public class main {
    public static void main(String[] args) {
        Map <String,Integer> agenda =new HashMap();
        
        agenda.put("Papa", 123123123);
        agenda.put("Mama", 234234234);
        agenda.put("Hermano", 435345345);
        agenda.put("Hermana", 456456456);
        agenda.put("Primo", 567567567);
        
        Agenda.anadirTelefono("Tio", 74657645, agenda);
        Agenda.mostrarNumeros(agenda);
        System.out.println("");
        Agenda.consultaNombre("Hermana", agenda);
        System.out.println("");
        Agenda.consultaTelefono("Mama", agenda);
    }
}
