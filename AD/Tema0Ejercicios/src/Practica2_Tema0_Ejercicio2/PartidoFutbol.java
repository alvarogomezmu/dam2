/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2_Tema0_Ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Alvaro
 */
public class PartidoFutbol {
    public String equipoLocal;
    public String equipoVisitante;
    public int golesLocal;
    public int golesVisitante;
    

    public PartidoFutbol(String equipoLocal, String equipoVisitante, int golesLocal, int golesVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    @Override
    public String toString() {
        return "PartidoFutbol{" + "equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante + ", golesLocal=" + golesLocal + ", golesVisitante=" + golesVisitante + '}';
    }
    
    public static void ganador(ArrayList<PartidoFutbol>partidos){
    Iterator it = partidos.iterator();
        while (it.hasNext()) {
            PartidoFutbol partido = (PartidoFutbol) it.next();
            String texto = "";
            if (partido.golesLocal == partido.golesVisitante) {
                //texto = partido.equipoLocal + " y " + partido.equipoVisitante + " han empatado a " + Integer.toString(partido.golesLocal);
                texto = partido.equipoLocal + " " + Integer.toString(partido.golesLocal) + "-" + Integer.toString(partido.golesVisitante) + " " + partido.equipoVisitante;
                System.out.println("\nPartido empatado");
            }
            if (partido.golesLocal > partido.golesVisitante) {
                //texto = partido.equipoLocal + " ha ganado al " + partido.equipoVisitante + " por " + Integer.toString(partido.golesLocal) + " a " + Integer.toString(partido.golesVisitante);
                texto = partido.equipoLocal + " " + Integer.toString(partido.golesLocal) + " " + Integer.toString(partido.golesVisitante) + " " + partido.equipoVisitante;
                System.out.println("\nHa ganado el equipo local " + partido.equipoLocal);
            }
            if (partido.golesLocal < partido.golesVisitante) {
                //texto = partido.equipoLocal + " ha perdido frente al " + partido.equipoVisitante + " por " + Integer.toString(partido.golesLocal) + " a " + Integer.toHexString(partido.golesVisitante);
                texto = partido.equipoLocal + " " + Integer.toString(partido.golesLocal) + " " + Integer.toString(partido.golesVisitante) + " " + partido.equipoVisitante;
                System.out.println("\nHa ganado el equipo visitante " + partido.equipoVisitante);
            }
            System.out.println(texto);
        }
    
}
}
