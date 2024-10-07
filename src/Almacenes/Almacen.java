/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Almacenes;

import java.util.concurrent.Semaphore;

/**
 *
 * @author emilianaplaz
 */
public class Almacen {

    //partes de las computadoras
    private int cantidadPlacas = 0;
    private int cantidadCpu = 0;
    private int cantidadRam = 0;
    private int cantidadFuentes = 0;
    private int cantidadGraficas = 0;
    
    //cantidad de computadoras listas para entregar
    private int ComputadorasEstandar = 0;
    private int ComputadorasGraficas = 0;
    
    //total de computadoras creadas
    private int ComputadorasEstandarAcumuladas = 0;
    private int ComputadorasGraficasAcumuladas = 0;
    
    //Semaforos
    private Semaphore salarioAccMutex = new Semaphore(1); //Gestionar los salarios
    private Semaphore diasMutex = new Semaphore(1); //Gestionar los días
    
    private int deadline;//cantidad de dias que se tienen para entregar las computadoras
    private int estadoDeadline;//ira disminuyendo de 1 en 1 hasta llegar a 0, luego se reiniciara.
    
    //Salario acumulado
    private float prodPlacaBaseAcc = 0;
    private float prodCPUAcc = 0;
    private float prodRAMAcc = 0;
    private float prodFuentesAcc = 0;
    private float prodGraficasAcc = 0;
    private float ensambladorAcc = 0;
    private float projectManagerAcc = 0;
    private float directorAcc =0;
 
    
    //Datos de la empresa
    private float ganancias = 0; 
    private float costosOperativos = 0;
    private float utilidades = 0;
    
    private int contadorPasoDeLosDias = 0;
    
    //Maximo de partes en el drive
    private float placaBaseMax = 25;
    private float CPUMax = 20;
    private float RAMMax = 55;
    private float fuenteMax = 35;
    private float graficastMax = 10;
    
    //Estatus del director: 0 = vigilando, 1 = trabajando
    private int estadorDirector = 1;
    
    //Estatus del Project manager: 0  = trabajando, 1 = viendo anime
    private int projectManagerEstado = 0;
    private int faltas = 0;
    private int salarioDescontado = 0;
    

    public Almacen() {
        
    }
}

