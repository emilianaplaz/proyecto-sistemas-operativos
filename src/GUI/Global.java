/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Almacen.Almacen;
import Compañias.Compania;
import Funciones.Funciones;
import java.util.concurrent.Semaphore;
import javax.swing.JFrame;

/**
 * @author Stefano Boschetti
 * @author Emiliana Plaz
 */
public class Global {
   //Estas son instancias de clases estaticas. Te permiten acceder a los objetos desde cualquier clase sin inicializarlos
    private static Almacen almacenApple = new Almacen();
    private static Almacen almacenHP = new Almacen();
    private static Compania Apple = new Compania();
    private static Compania HP = new Compania();
    private static Semaphore mutexApple = new Semaphore(1);
    private static Semaphore mutexHP = new Semaphore(1);
    private static Funciones  funciones = new Funciones();
    private static Grafico grafico = new Grafico();

    
    public static Almacen getAlmacenApple(){
        return almacenApple;
    }
    
    public static void setAlmacenApple(Almacen aAlmacenApple) {
        almacenApple = aAlmacenApple;
    }
    
    public static Almacen getAlmacenHP(){
        return almacenHP;
    }
    
    public static void setAlmacenHP(Almacen aAlmacenHP) {
        almacenHP = aAlmacenHP;
    }
    
    public static Compania getApple(){
        return Apple;
    }
    
    public static void setApple(Compania aApple) {
        Apple = aApple;
    }
    
    public static Compania getHP(){
        return HP;
    }
    
    public static void setHP(Compania aHP) {
        HP = aHP;
    }


    public static Semaphore getMutexApple() {
        return mutexApple;
    }


    public static void setMutexApple(Semaphore aMutexApple) {
        mutexApple = aMutexApple;
    }

    
    public static Semaphore getMutexHP() {
        return mutexHP;
    }

   
    public static void setMutexHP(Semaphore aMutexHP) {
        mutexHP = aMutexHP;
    }

  
    public static Funciones getFunciones() {
        return funciones;
    }

   
    public static void setFunciones(Funciones aFunciones) {
        funciones = aFunciones;
    }

    
    public static Grafico getGrafico() {
        return grafico;
    }

   
    public static void setGrafico(Grafico aGrafico) {
        grafico = aGrafico;
    }
}
