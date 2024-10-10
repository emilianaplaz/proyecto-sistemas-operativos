/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;


import Compañias.Compania;
import Entes.ProjectManager;
import Entes.Director;
import java.util.concurrent.Semaphore;
import GUI.Global;
import java.util.concurrent.TimeUnit;


/**
 * @author Stefano Boschetti
 * @author Emiliana Plaz
 */
public class ProyectoSO {

    
    public static void main(String[] args) throws InterruptedException {
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
        Global.getGrafico().start();
        TimeUnit.SECONDS.sleep(1);
        Global.getGrafico().getVentana().setVisible(true);
    }
    
}
