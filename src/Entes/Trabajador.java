/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entes;

import Compañias.Compania;
import java.util.concurrent.Semaphore;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Stefano Boschetti
 * @author Emiliana Plaz
 */
public abstract class Trabajador extends Thread {

    protected Compania compania;
    protected float salario;
    protected float salarioAcumulado;
    protected int tipo;
    protected float produccionDiaria;
    protected Semaphore mutex;

    /*TIPOS DE TRABAJADORES:
        Productores de placa base                    = 0            $20
        Productores de CPUs                          = 1            $26
        Productores de Memoria RAM                   = 2            $40
        Productores de Fuente de alimentación        = 3            $16
        Productores de tarjetas gráficas             = 4            $34
    
        Ensambladores                                = 5            $50
        Project manager                              = 6            $40
        Director                                     = 7            $60
     */
    public Trabajador(int tipo, Semaphore mutex, Compania compania) {
        this.tipo = tipo;
        this.compania = compania;
        this.salarioAcumulado = 0;

        switch (tipo) {
            case 0 -> {
                this.salario = 20;
                this.produccionDiaria = compania.getProdDiariaPlacaBase();
            }
            case 1 -> {
                this.salario = 26;
                this.produccionDiaria = compania.getProdDiariaCpu();
            }
            case 2 -> {
                this.salario = 40;
                this.produccionDiaria = compania.getProdDiariaRam();
            }
            case 3 -> {
                this.salario = 16;
                this.produccionDiaria = compania.getProdDiariaFuentes();
            }
            case 4 -> {
                this.salario = 34;
                this.produccionDiaria = compania.getProdDiariaGraficas();
            }
            case 5 -> {
                this.salario = 50;
                this.produccionDiaria = (float) 1/2;
            }
            case 6 -> {
                this.salario = 40;
                this.produccionDiaria = 1;
            }
            case 7 -> {
                this.salario = 60;
                this.produccionDiaria = 1;
            }
        }
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getSalarioAcumulado() {
        return salarioAcumulado;
    }

    public void setSalarioAcumulado(float salarioAcumulado) {
        this.salarioAcumulado = salarioAcumulado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public float getProduccionDiaria() {
        return produccionDiaria;
    }

    public void setProduccionDiaria(float produccionDiaria) {
        this.produccionDiaria = produccionDiaria;
    }
    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

}
