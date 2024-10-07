package Entes;

import Compañias.Compania;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Stefano Boschetti
 * @author Emiliana Plaz
 */
public class Productor extends Trabajador{
    float salarioAcc;
    float progresoActual;
    
    public Productor(int tipo,float salario, Semaphore mutex, Compania compania) {
        super(tipo,salario, mutex,compania);
        this.salarioAcc = 0;
        this.progresoActual = 0;
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
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void work(){
        this.progresoActual += this.getProgresoTrabajo();
            try {
                if (this.progresoActual >= 1){
                    this.getMutex().acquire(); //wait
                    this.getCompania().getAlmacen().addPart(this);//Espacio critico
                    this.getMutex().release();// signal
                    this.progresoActual = 0;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }
}