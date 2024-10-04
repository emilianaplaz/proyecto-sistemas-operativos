/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compañias;

import Drive.Drive;
import Estructuras.ListaDoble;
import Estructuras.Nodo;
import java.util.concurrent.Semaphore;

/**
 *
 * @author emilianaplaz
 */
public class Compania {
    private int duracionDia;
    private int tipoCompania;
    private Drive drive;
    private float utilidades; //Utilidad
    private ListaDoble ensambladores; //ensambladores
    private ListaDoble prod_placa_base; //animadores
    private ListaDoble prod_cpu; //disenadores de escenarios
    private ListaDoble prod_memoria_ram; //guionistas
    private ListaDoble prod_fuente_alimentacion; //Actores de doblaje

    public Compania() {
    }
    
    public Compania(Drive drive,int companyType) {
        this.tipoCompania = companyType;
        this.drive = drive;
        this.utilidades = 0;
        this.prod_placa_base = new ListaDoble();
        this.prod_cpu = new ListaDoble();
        this.prod_memoria_ram = new ListaDoble();
        this.prod_fuente_alimentacion = new ListaDoble();
        this.prod_tarjetas_graficas = new ListaDoble();
    }
    
    public int cantidadTrabajadores(){
        int respuesta = ensambladores.getSize()+
                        prod_placa_base.getSize()+
                        prod_cpu.getSize()+
                        prod_memoria_ram.getSize()+
                        prod_fuente_alimentacion.getSize()+
                        prod_tarjetas_graficas.getSize();
        return respuesta;
    }

    /**
     * @return the tipoCompania
     */
    public int getTipoCompania() {
        return tipoCompania;
    }

    /**
     * @param tipoCompania the tipoCompania to set
     */
    public void setTipoCompania(int tipoCompania) {
        this.tipoCompania = tipoCompania;
    }

    /**
     * @return the drive
     */
    public Drive getDrive() {
        return drive;
    }

    /**
     * @param drive the drive to set
     */
    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    /**
     * @return the utilidades
     */
    public float getUtilidades() {
        return utilidades;
    }

    /**
     * @param utilidades the utilidades to set
     */
    public void setUtilidades(float utilidades) {
        this.utilidades = utilidades;
    }

    /**
     * @return the ensambladores
     */
    public ListaDoble getEnsambladores() {
        return ensambladores;
    }

    /**
     * @param ensambladores the ensambladores to set
     */
    public void setEnsambladores(ListaDoble ensambladores) {
        this.ensambladores = ensambladores;
    }

    /**
     * @return the animadores
     */
    public ListaDoble getProdPlacaBase() {
        return prod_placa_base;
    }

    /**
     * @param animadores the animadores to set
     */
    public void setProdPlacaBase(ListaDoble prod_placa_base) {
        this.prod_placa_base = prod_placa_base;
    }

    /**
     * @return the disenadoresEscenarios
     */
    public ListaDoble getProdCPU() {
        return prod_cpu;
    }

    /**
     * @param disenadoresEscenarios the disenadoresEscenarios to set
     */
    public void setProdCPU(ListaDoble prod_cpu) {
        this.prod_cpu = prod_cpu;
    }

    /**
     * @return the guionistas
     */
    public ListaDoble getMemoriaRAM() {
        return prod_memoria_ram;
    }

    /**
     * @param guionistas the guionistas to set
     */
    public void setMemoriaRAM(ListaDoble prod_memoria_ram) {
        this.prod_memoria_ram = prod_memoria_ram;
    }

    /**
     * @return the actoresDoblaje
     */
    public ListaDoble getProdFuenteAlimentacion() {
        return prod_fuente_alimentacion;
    }

    /**
     * @param actoresDoblaje the actoresDoblaje to set
     */
    public void setProdFuenteAlimentacion(ListaDoble prod_fuente_alimentacion) {
        this.prod_fuente_alimentacion = prod_fuente_alimentacion;
    }

    /**
     * @return the duracionDia
     */
    public int getDuracionDia() {
        return duracionDia;
    }

    /**
     * @param duracionDia the duracionDia to set
     */
    public void setDuracionDia(int duracionDia) {
        this.duracionDia = duracionDia;
    }
    
}