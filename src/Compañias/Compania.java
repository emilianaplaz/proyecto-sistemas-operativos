/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compañias;

import Estructuras.ListaDoble;
import Estructuras.Nodo;
import java.util.concurrent.Semaphore;
import Almacenes.Almacen;

/**
 * @author Emiliana Plaz
 * @author Stefano Boschetti
 */
public class Compania {

    private int duracionDia;
    private int tipo;
    private float prod_placa_base;
    private float prod_cpu;
    private float prod_ram;
    private float prod_fuentes;
    private float prod_graficas;
    private Almacen almacen;

    public Compania() {
        this.tipo = tipo;
        this.duracionDia = 60; // Duracion del dia en segundos.
        this.almacen = new Almacen(); // Se genera un nuevo almacen.
        
        if (tipo == 0) { //Cuando la compañia es Apple. (Stefano)
//            Ultimo digito del carnet = 6
            this.prod_placa_base = (float) 1/4; // 1 placa cada 4 dias
            this.prod_cpu = (float) 1/4; // 1 CPU cada 4 dias
            this.prod_ram = (float) 1; // 1 RAM cada dia
            this.prod_fuentes = (float) 5; // 5 fuente cada dia
            this.prod_graficas = (float) 1/2; // 1 grafica cada 2 dias

        } else if (tipo == 1) { //Cuando la compañia es HP. (Emiliana)
//            Ultimo digito del carnet = 3
            this.prod_placa_base = (float) 1/3; // 1 placa cada 3 dias
            this.prod_cpu = (float) 1/3; // 1 CPU cada 3 dias
            this.prod_ram = (float) 2; // 2 RAM cada dia
            this.prod_fuentes = (float) 3; // 3 fuente cada dia
            this.prod_graficas = (float) 1/3; // 1 grafica cada 3 dias
        }
    }


    public int getDuracionDia() {
        return duracionDia;
    }

    public void setDuracionDia(int duracionDia) {
        this.duracionDia = duracionDia;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public float getProd_placa_base() {
        return prod_placa_base;
    }

    public void setProd_placa_base(float prod_placa_base) {
        this.prod_placa_base = prod_placa_base;
    }

    public float getProd_cpu() {
        return prod_cpu;
    }

    public void setProd_cpu(float prod_cpu) {
        this.prod_cpu = prod_cpu;
    }

    public float getProd_ram() {
        return prod_ram;
    }

    public void setProd_ram(float prod_ram) {
        this.prod_ram = prod_ram;
    }

    public float getProd_fuentes() {
        return prod_fuentes;
    }

    public void setProd_fuentes(float prod_fuentes) {
        this.prod_fuentes = prod_fuentes;
    }

    public float getProd_graficas() {
        return prod_graficas;
    }

    public void setProd_graficas(float prod_graficas) {
        this.prod_graficas = prod_graficas;
    }
    

    public Almacen getAlmacen() {
        return almacen;
    }

   
    public void setAlmacen(Almacen drive) {
        this.almacen = drive;
    }


}
