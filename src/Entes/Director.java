/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entes;

import Compañias.Compania;
import java.util.concurrent.Semaphore;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Stefano Boschetti
 * @author Emiliana Plaz
 */
public class Director extends Trabajador {

    public Director(int tipo, Semaphore mutex, Compania compania) {
        super(tipo, mutex, compania);
        this.mutex = mutex;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.cobrarSueldo();
                this.work();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void work() {
        if (this.getCompania().getAlmacen().getEstadoDeadline() == 0) {
            try {
                this.enviarComputadoras();
                this.getCompania().getAlmacen().getDiasMutex().acquire();
                this.getCompania().getAlmacen().setEstadoDeadline(this.getCompania().getAlmacen().getDeadline(), this.getCompania().getTipoCompania());
                this.getCompania().getAlmacen().getDiasMutex().release();
                sleep(this.getCompania().getDuracionDia());
            } catch (InterruptedException ex) {
                Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                //El director escoge una hora del dia aleatoriamente, 
                //si llega a esa hora el director cambiara su estado a revisando y revisara durante 35 minutos
                Random r = new Random();

                double oneHour = this.getCompania().getDuracionDia() / 24;
                double checkingHour = r.nextInt(24) * oneHour; //obtiene un numero aleatorio entre 0-23.  Y lo multiplica por el equivalente a 1 hora
                //int horas = 0;
                double contador = 0;
                while (contador < this.getCompania().getDuracionDia()) {
                    if (contador == checkingHour) {
                        this.getCompania().getAlmacen().setEstadorDirector(0, this.getCompania().getTipoCompania()); // cambiamos su estado a vigilando

                        //Empiezan a pasar los minutos 
                        double oneMinute = oneHour / 60;
                        sleep(Math.round(35 * oneMinute)); //vigila durante 35 minutos
                        this.getCompania().getAlmacen().setEstadorDirector(1, this.getCompania().getTipoCompania());//cambias su estado a trabajando
                        sleep(Math.round(25 * oneMinute));//trabaja 25 minutos
                        contador += oneHour;
                        //horas +=1;
                    } else {
                        sleep(Math.round(oneHour));
                        contador += oneHour;
                        //horas +=1;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void cobrarSueldo() {
        try {
            //Cobrando su dia de trabajo
            this.getCompania().getAlmacen().getSalarioAccMutex().acquire();
            this.getCompania().getAlmacen().addSalary(this.getTipo(), this.getSalario() * 24, this.getCompania().getTipoCompania());
            this.getCompania().getAlmacen().getSalarioAccMutex().release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarComputadoras() {
        try {
            //Cobrando su dia de trabajo
            this.getMutex().acquire();
            this.getCompania().getAlmacen().getSalarioAccMutex().acquire();
            float ganancias = 0;
            if (this.getCompania().getTipoCompania() == 0) { // APPLE
                ganancias = (this.getCompania().getAlmacen().getPcEstandar() * 100000) + (this.getCompania().getAlmacen().getPcConGrafica() * 150000);
                this.getCompania().getAlmacen().setGanancias(this.getCompania().getAlmacen().getGanancias() + ganancias, this.getCompania().getTipoCompania());
                this.getCompania().getAlmacen().setUtilidades(this.getCompania().getAlmacen().getUtilidades() + ganancias, this.getCompania().getTipoCompania());
            } else if (this.getCompania().getTipoCompania() == 1) { // HP
                ganancias = (this.getCompania().getAlmacen().getPcEstandar() * 90000) + (this.getCompania().getAlmacen().getPcConGrafica() * 140000);
                this.getCompania().getAlmacen().setGanancias(this.getCompania().getAlmacen().getGanancias() + ganancias, this.getCompania().getTipoCompania());
                this.getCompania().getAlmacen().setUtilidades(this.getCompania().getAlmacen().getUtilidades() + ganancias, this.getCompania().getTipoCompania());
            }

            //reiniciamos las computadoras acumulados
            this.getCompania().getAlmacen().setPcEstandar(0, this.getCompania().getTipoCompania());
            this.getCompania().getAlmacen().setPcConGrafica(0, this.getCompania().getTipoCompania());

            this.getMutex().release();
            this.getCompania().getAlmacen().getSalarioAccMutex().release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
