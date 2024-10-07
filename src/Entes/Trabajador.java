/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entes;

/**
 * @author Emiliana Plaz
 * @author Stefano Boschetti
 */
import Compañias.Compania;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class Trabajador extends Thread{

    private Compania compania;
    private float salario;
    private float salarioAcumulado;
    private int tipo;
    private float produccionDiaria;
    private Semaphore mutex;

    

    /*TIPOS DE TRABAJADORES:
        Productores de placa base                    = 0            $20/h
        Productores de CPUs                          = 1            $26/h
        Productores de Memoria RAM                   = 2            $40/h
        Productores de Fuente de alimentación        = 3            $16/h
        Productores de tarjetas gráficas             = 4            $34/h
    
        Ensambladores                                = 5            $50/h
        Project manager                              = 6            $40/h
        Director                                     = 7            $60/h
     */
    public Trabajador(int tipo, float salario, Semaphore mutex, Compania compania) {
        this.tipo = tipo;
        this.compania = compania;
        this.salarioAcumulado = salarioAcumulado;

        switch (tipo) {
            case 0 -> {
                this.salario = 20;
                this.produccionDiaria = compania.getProd_placa_base();
            }
            case 1 -> {
                this.salario = 26;
                this.produccionDiaria = compania.getProd_cpu();
            }
            case 2 -> {
                this.salario = 40;
                this.produccionDiaria = compania.getProd_ram();
            }
            case 3 -> {
                this.salario = 16;
                this.produccionDiaria = compania.getProd_fuentes();
            }
            case 4 -> {
                this.salario = 34;
                this.produccionDiaria = compania.getProd_graficas();
            }
        }
    }
    
    public float getSalario() {
        return salario;
    }

    
    public void setSalario(float salario) {
        this.salario = salario;
    }
        
    public Compania getCompania() {
        return compania;
    }

    
    public void setCompania(Compania compania) {
        this.compania = compania;
    }
    
}
