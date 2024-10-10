/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;


import Compañias.Compania;
import Almacen.Almacen;
import Estructuras.Nodo;
import Entes.Ensamblador;
import Entes.ProjectManager;
import Entes.Trabajador;
import Entes.Director;
import java.util.concurrent.Semaphore;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import GUI.Global;
import GUI.Grafico;


/**
 * @author Stefano Boschetti
 * @author Emiliana Plaz
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
        
         //Creamos la compania Apple y la cargamos a Global
        Compania apple = new Compania(Global.getAlmacenApple(),0);
        Global.setApple(apple);
        //Creamos la compania HP y la cargamos a Global
        Compania hp = new Compania(Global.getAlmacenHP(),1);
        Global.setHP(hp);
        
        //Creamos los semaforos y los cargamos  a Global
        Semaphore mutexApple = new Semaphore(1);
        Semaphore mutexHP = new Semaphore(1);
        Global.setMutexHP(mutexHP);
        Global.setMutexApple(mutexApple);
        
        Global.getFunciones().leer_txt();
        
        
        //Creamos y ponemos a trabjar los PM de ambas empresas
        ProjectManager pm = new ProjectManager(6,mutexApple,       Global.getApple());
        ProjectManager pm2 = new ProjectManager(6,mutexApple,Global.getHP());
        pm.start();
        pm2.start();
        
        //Creamos y ponemos a trabjar los DIRECTORES de ambas empresas
        Director directorApple = new Director(7,mutexApple,Global.getApple());
        directorApple.start();
        Director directorHP = new Director(7,mutexHP,Global.getHP());
        directorHP.start();        
        
        
        
        
        //Global.getGrafico().start();
    }
    
}
