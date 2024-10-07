/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import GUI.Home;
import Compañias.Compania;
import Almacenes.Almacen;
import Estructuras.Nodo;
import Entes.Ensamblador;
//import Entes.Desarrollador;
import Entes.ProjectManager;
import Entes.Trabajador;
import java.util.concurrent.Semaphore;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import GUI.Global;
import GUI.Grafico;
import Entes.Director;

/**
 *
 * @author emilianaplaz
 */
public class ProyectoSO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Home homepage = new Home ();
        //homepage.setVisible(true); 
        
        ManejadorInterfaz.getInterfaz().show();
    }
    
}
