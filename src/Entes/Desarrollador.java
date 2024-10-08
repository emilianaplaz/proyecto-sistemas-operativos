/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entes;

import Compañias.Compania;
import Almacen.Almacen;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emilianaplaz
 */
public class Desarrollador extends Trabajador{
    float salarioAcc;
    float acc;
    public Desarrollador(int tipo,float salario, Semaphore mutex, Compania compania) {
        super(tipo,salario, mutex,compania);
        this.salarioAcc = 0;
        this.acc = 0;
    }
    @Override
    public void run(){
       while(true) {
            
            try {
                obtainSalary();
                work();
                //System.out.println("Trabajador: "+ this.name + " gana: "+this.salaryAcc+"$");
                sleep(this.getCompania().getDuracionDia());
            } catch (InterruptedException ex) {
                Logger.getLogger(Desarrollador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void obtainSalary(){
        this.salarioAcc += this.getSalario()*24;
        try {
            this.getCompania().getAlmacen().getSalarioAccMutex().acquire(); //wait
            this.getCompania().getAlmacen().addSalary(this.getTipo(), this.getSalario()*24,this.getCompania().getTipoCompania());
            this.getCompania().getAlmacen().getSalarioAccMutex().release();// signal
            } catch (InterruptedException ex) {
                Logger.getLogger(Desarrollador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void work(){
        this.acc += this.getCantidadDeTrabajoPorDia();
            try {
                if (this.acc >= 1){
                    this.getMutex().acquire(); //wait
                    this.getCompania().getAlmacen().addPart(this.getTipo(),this.getCompania().getTipoCompania());//critica
                    this.getMutex().release();// signal
                    this.acc = 0;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Desarrollador.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }
}
