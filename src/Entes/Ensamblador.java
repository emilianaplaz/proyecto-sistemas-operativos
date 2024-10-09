/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class Ensamblador extends Trabajador {

    float acc;
    int pcEstandar = 0; //computadoras estandar ensambladas
    int pcConGrafica = 0; //computadoras con tarjeta grafica ensambladas
    int contadorPcTemp = 0; // Computadoras estandar para llevar la cuenta de cuando crear una grafica.

    public Ensamblador(int tipo, float salario, Semaphore mutex, Compania compania) {
        super(tipo, salario, mutex, compania);
        this.mutex = mutex;
        this.acc = 0;
    }

    @Override
    public void run() {
        while (true) {
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

    private void obtainSalary() {
        try {
            this.getCompania().getAlmacen().getSalarioAccMutex().acquire();
            this.getCompania().getAlmacen().addSalary(this.getTipo(), this.getSalario() * 24, this.getCompania().getTipoCompania());
            this.getCompania().getAlmacen().getSalarioAccMutex().release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ensamblador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Apple = 0 y HP = 1
    //Ademas se debe verificar si se cuenta con las partes necesarias para realizar una PC.
    //Se debe esperar para hacer la computadora grafica
    private boolean verificarPartesNecesarias() {
        boolean respuesta = false;
        //- Computador estándar:  
        //Para ensamblar una computadora necesitan de:
        //1 Placas base 
        //1 CPU 
        //2 Memorias RAM 
        //4 Fuentes de alimentación 
        //Ganancia al vender computador: $90K 
        //
        //- Computadora con tarjeta gráfica: 
        //Después de crear 2 computadoras, la siguiente tendrá 3 tarjeta gráfica.
        //Ganancia al sacar el computadora: $140K  

        //Si es HP y el almacen tiene suficientes partes para hacer una pc estandar entrara en el siguiente if
        if (this.getCompania().getTipoCompania() == 1
                && this.getCompania().getAlmacen().getPlacasBase() >= 1
                && this.getCompania().getAlmacen().getCpu() >= 1
                && this.getCompania().getAlmacen().getRam() >= 2
                && this.getCompania().getAlmacen().getFuentes() >= 4) {
            //Es capaz de fabricar una PC.
            respuesta = true;

            //Si es Apple y el almacen tiene suficientes partes para hacer una pc estandar entrara en el siguiente if
            //- Computador estándar:  
            //Para ensamblar una computadora necesitan de:
            //2 Placas base 
            //1 CPU 
            //4 Memorias RAM 
            //4 Fuentes de alimentación 
            //Ganancia al vender computador: $100K 
            //- Computadora con tarjeta gráfica: 
            //
            //Después de crear 5 computadoras, la siguiente tendrá 2 tarjetas gráficas 
            //Ganancia al sacar el computadora: $150K 
        } else if (this.getCompania().getTipoCompania() == 0
                && this.getCompania().getAlmacen().getPlacasBase() >= 2
                && this.getCompania().getAlmacen().getCpu() >= 1
                && this.getCompania().getAlmacen().getRam() >= 4
                && this.getCompania().getAlmacen().getFuentes() >= 4) {
            //Es capaz de fabricar una PC.
            respuesta = true;
        }
        return respuesta;
    }

    private void work() {
        //si el ensamblador no esta ensamblando una computadora, entra aqui (Primer dia)
        if (this.pcEstandar == 0 && this.pcConGrafica == 0) {
            try {
                this.getMutex().acquire(); //wait
                boolean autorizacion = this.verificarPartesNecesarias();
                if (autorizacion == true) {
                    this.tomarPartesDeComputadora();
                    this.acc = this.acc + this.getProduccionDiaria();
                }
                this.getMutex().release();// signal     

            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
            //entrara aqui si esta ensamblando una computadora (Segundo dia)
        } else {
            this.acc = this.acc + this.getProduccionDiaria();
            if (this.acc >= 1) {
                try {
                    
                    this.getMutex().acquire(); //wait
                    //Termina de agregar un capitulo.
                    this.agregarComputadora();// CRITICA

                    this.getMutex().release();// signal
                    this.acc = 0;

                } catch (InterruptedException ex) {
                    Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    //ESTE METODO AGREGA COMPUTADORAS AL ALMACEN Y ACTUALIZA EL ESTADO DE PARTES DEL ENSAMBLADOR
    public void agregarComputadora() {
        if (this.pcEstandar == 1) {
            this.pcEstandar = 0;
            //System.out.println(this.getCompania().getAlmacen().getPcEstandar());
            this.getCompania().getAlmacen().setPcEstandar(this.getCompania().getAlmacen().getPcEstandar() + 1, this.getCompania().getTipoCompania());
            this.getCompania().getAlmacen().setpcAcumulados(this.getCompania().getAlmacen().getpcAcumulados() + 1);
        } else if (this.pcConGrafica == 1) {
            this.pcConGrafica = 0;
            this.getCompania().getAlmacen().setPcConGrafica(this.getCompania().getAlmacen().getPcConGrafica() + 1, this.getCompania().getTipoCompania());
            this.getCompania().getAlmacen().setpcConGraficaAcumulados(this.getCompania().getAlmacen().getpcConGraficaAcumulados() + 1);

        }
    }

    //ESTE METODO TOMA LAS PARTES DE COMPUTADORAS, PUEDE DARSE CUENTA DE SI TOCA UNA ESTANDAR O UNA GRAFICA
    public void tomarPartesDeComputadora() {
        if (this.getCompania().getTipoCompania() == 1) { // 1 HP
            //- Computador estándar:  
            //Para ensamblar una computadora necesitan de:
            //1 Placas base 
            //1 CPU 
            //2 Memorias RAM 
            //4 Fuentes de alimentación 
            //Ganancia al vender computador: $90K 
            //
            //- Computadora con tarjeta gráfica: 
            //Después de crear 2 computadoras, la siguiente tendrá 3 tarjeta gráfica.
            //Ganancia al sacar el computadora: $140K  

            //Tomamos las partes necesarias del Almacen
            this.getCompania().getAlmacen().setPlacasBase(this.getCompania().getAlmacen().getPlacasBase() - 1, this.getCompania().getTipoCompania());
            this.getCompania().getAlmacen().setCpu(this.getCompania().getAlmacen().getCpu() - 1, this.getCompania().getTipoCompania());
            this.getCompania().getAlmacen().setRam(this.getCompania().getAlmacen().getRam() - 2, this.getCompania().getTipoCompania());
            this.getCompania().getAlmacen().setFuentes(this.getCompania().getAlmacen().getFuentes() - 4, this.getCompania().getTipoCompania());

            if ((this.contadorPcTemp >= 2) && (this.getCompania().getAlmacen().getGraficas() >= 3)) {
                // Si se han creado 2 pc Estandar y hay suficientes graficas para hacer una grafica.
                // Se toman las graficas necesarias.
                this.getCompania().getAlmacen().setGraficas(this.getCompania().getAlmacen().getGraficas() - 3, this.getCompania().getTipoCompania());
                // Empezamos el ensambljae de una pc con grafica.
                this.pcConGrafica = this.pcConGrafica + 1;
                // Reseteamos el contador temporal de PcEstandar.
                this.contadorPcTemp = 0;
            } else {
                // Si no se cumplen las condiciones para crear una computadora Grafica se crea una Estandar.
                this.pcEstandar = this.pcEstandar + 1;
                // Aumentamos el contador temporal de PcEstandar.
                this.contadorPcTemp = this.contadorPcTemp + 1;
            }

        } else if (this.getCompania().getTipoCompania() == 0) { // 0 APPLE
            //- Computador estándar:  
            //Para ensamblar una computadora necesitan de:
            //2 Placas base 
            //1 CPU 
            //4 Memorias RAM 
            //4 Fuentes de alimentación 
            //Ganancia al vender computador: $100K 
            //- Computadora con tarjeta gráfica: 
            //
            //Después de crear 5 computadoras, la siguiente tendrá 2 tarjetas gráficas 
            //Ganancia al sacar el computadora: $150K 

            //Tomamos las partes necesarias del Almacen
            this.getCompania().getAlmacen().setPlacasBase(this.getCompania().getAlmacen().getPlacasBase() - 2, this.getCompania().getTipoCompania());
            this.getCompania().getAlmacen().setCpu(this.getCompania().getAlmacen().getCpu() - 1, this.getCompania().getTipoCompania());
            this.getCompania().getAlmacen().setRam(this.getCompania().getAlmacen().getRam() - 4, this.getCompania().getTipoCompania());
            this.getCompania().getAlmacen().setFuentes(this.getCompania().getAlmacen().getFuentes() - 4, this.getCompania().getTipoCompania());

            if ((this.contadorPcTemp >= 5) && (this.getCompania().getAlmacen().getGraficas() >= 2)) {
                // Si se han creado 2 pc Estandar y hay suficientes graficas para hacer una grafica.
                // Se toman las graficas necesarias.
                this.getCompania().getAlmacen().setGraficas(this.getCompania().getAlmacen().getGraficas() - 2, this.getCompania().getTipoCompania());
                // Aumentamos las pcGraficas almacenadas por el ensamblador.
                this.pcConGrafica = this.pcConGrafica + 1;
                // Reseteamos el contador temporal de PcEstandar.
                this.contadorPcTemp = 0;
            } else {
                // Si no se cumplen las condiciones para crear una computadora Grafica se crea una Estandar.
                this.pcEstandar = this.pcEstandar + 1;
                // Aumentamos el contador temporal de PcEstandar.
                this.contadorPcTemp = this.contadorPcTemp + 1;
            }
        }
    }

}
