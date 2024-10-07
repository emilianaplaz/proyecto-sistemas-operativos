/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entes;

import java.util.concurrent.Semaphore;
import Compañias.Compania;
import java.util.concurrent.Semaphore;


/**
 * @author Stefano Boschetti
 * @author Emiliana Plaz
 */
public class ProjectManager extends Trabajador{
    
    private float salarioAcumulado = this.getSalario() * 24;
    
    public ProjectManager(int tipo, float salario, Semaphore mutex, Compania compania) {
        super(tipo, salario, mutex, compania);
    }
    
    public void run() {
        while (true) {
            try {
                //NECESITAMOS OBTENER EL EQUIVALENTE A MEDIA HORA
                // Media hora = un dia entre 48
                double halfHour = this.getCompania().getDuracionDia() / 48;
                int counter = 0;
                float salario_final = salarioAcumulado;
                // 16 horas al dia
                while (counter < 16) {
                    this.getCompania().getAlmacen().setPmEstado(1,this.getCompania().getTipoCompania()); //Actualizamos Su estado a Viendo Anime

                    //Si el director lo esta vigilando entonces
                    if (this.getCompania().getAlmacen().getEstadorDirector() == 0) {
                        //TODO: poner lo que va a hacer 
                        this.getCompania().getAlmacen().setFaltas(this.getCompania().getAlmacen().getFaltas() + 1,this.getCompania().getTipoCompania());
                        this.getCompania().getAlmacen().setSalarioDescontado(this.getCompania().getAlmacen().getSalarioDescontado() + 100,this.getCompania().getTipoCompania());
                        salario_final = salario_final - 100;
                    }

                    sleep(Math.round(halfHour));
                    this.getCompania().getAlmacen().setPmEstado(0,this.getCompania().getTipoCompania());
                    sleep(Math.round(halfHour));
                    counter++;
                }

                this.getCompania().getAlmacen().setPmEstado(0,this.getCompania().getTipoCompania());
                //Cobrando su dia de trabajo
                this.getCompania().getAlmacen().getSalarioAccMutex().acquire();
                this.getCompania().getAlmacen().addSalary(this.getTipo(), salario_final, this.getCompania().getTipoCompania());
                this.getCompania().getAlmacen().getSalarioAccMutex().release();
                sleep(Math.round(halfHour * 16));
                
                this.getCompania().getAlmacen().getDiasMutex().acquire();
                if(this.getCompania().getAlmacen().getEstadoDeadline() != 0){
                    this.getCompania().getAlmacen().setEstadoDeadline(this.getCompania().getAlmacen().getEstadoDeadline() - 1,this.getCompania().getTipoCompania()); //LE RESTA 1 AL DEADLINE,el dia 0 sera el director quien reiniciara el deadline
                }
                this.getCompania().getAlmacen().setContadorPasoDeLosDias(this.getCompania().getAlmacen().getContadorPasoDeLosDias() + 1);
                this.getCompania().getAlmacen().getDiasMutex().release();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
