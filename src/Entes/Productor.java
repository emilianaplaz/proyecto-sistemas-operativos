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
public class Productor extends Trabajador {

    private float salarioAcc;
    private float progresoActual;
    public boolean despedido = false;
    
    public Productor(int tipo, Semaphore mutex, Compania compania) {
        super(tipo, mutex, compania);
        this.mutex = mutex;
        this.salarioAcc = 0;
        this.progresoActual = 0;
    }

    @Override
    public void run() {
        while (true) {
                try {
                    if(this.despedido){
                        break;
                    }
                    obtainSalary();
                    work();
                    sleep(this.getCompania().getDuracionDia());
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }

    public void obtainSalary() {
        this.setSalarioAcc(this.getSalarioAcc() + this.getSalario() * 24);
        try {
            this.getCompania().getAlmacen().getSalarioAccMutex().acquire(); //wait
            this.getCompania().getAlmacen().addSalary(this.getTipo(), this.getSalario() * 24, this.getCompania().getTipoCompania());
            this.getCompania().getAlmacen().getSalarioAccMutex().release();// signal
        } catch (InterruptedException ex) {
            Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void work() {
        this.setProgresoActual(this.getProgresoActual() + this.getProduccionDiaria());
        try {
            if (this.getProgresoActual() >= 1) {
                this.getMutex().acquire(); //wait
                this.getCompania().getAlmacen().addPart(this);//Espacio critico
                this.getMutex().release();// signal
                this.setProgresoActual(0);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public float getSalarioAcc() {
        return salarioAcc;
    }

    public void setSalarioAcc(float salarioAcc) {
        this.salarioAcc = salarioAcc;
    }

    public float getProgresoActual() {
        return progresoActual;
    }

    public void setProgresoActual(float progresoActual) {
        this.progresoActual = progresoActual;
    }
}
