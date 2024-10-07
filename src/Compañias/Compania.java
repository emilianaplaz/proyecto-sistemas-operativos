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
    private int tipoCompania;
    private Almacen almacen;
    private float utilidades; //
    private ListaDoble ensambladores; //
    private ListaDoble prod_placa_base; //
    private ListaDoble prod_cpu; //
    private ListaDoble prod_ram; //
    private ListaDoble prod_fuentes; //
    private ListaDoble prod_graficas; //

    public Compania() {
    }
    
    public Compania(Almacen almacen,int companyType) {
        this.tipoCompania = companyType;
        this.almacen = almacen;
        this.utilidades = 0;
        this.ensambladores = new ListaDoble();
        this.prod_placa_base = new ListaDoble();
        this.prod_placa_base = new ListaDoble();
        this.prod_ram = new ListaDoble();
        this.prod_fuentes = new ListaDoble();
        this.prod_graficas = new ListaDoble();
    }
    
    public int cantidadTrabajadores(){
        int respuesta = ensambladores.getSize()+
                        prod_placa_base.getSize()+
                        prod_placa_base.getSize()+
                        prod_ram.getSize()+
                        prod_fuentes.getSize()+
                        prod_graficas.getSize();
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
    public Almacen getDrive() {
        return almacen;
    }

    /**
     * @param drive the drive to set
     */
    public void setDrive(Almacen drive) {
        this.almacen = drive;
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
    public ListaDoble getAnimadores() {
        return animadores;
    }

    /**
     * @param animadores the animadores to set
     */
    public void setAnimadores(ListaDoble animadores) {
        this.animadores = animadores;
    }

    /**
     * @return the disenadoresEscenarios
     */
    public ListaDoble getDisenadoresEscenarios() {
        return disenadoresEscenarios;
    }

    /**
     * @param disenadoresEscenarios the disenadoresEscenarios to set
     */
    public void setDisenadoresEscenarios(ListaDoble disenadoresEscenarios) {
        this.disenadoresEscenarios = disenadoresEscenarios;
    }

    /**
     * @return the guionistas
     */
    public ListaDoble getGuionistas() {
        return guionistas;
    }

    /**
     * @param guionistas the guionistas to set
     */
    public void setGuionistas(ListaDoble guionistas) {
        this.guionistas = guionistas;
    }

    /**
     * @return the actoresDoblaje
     */
    public ListaDoble getActoresDoblaje() {
        return actoresDoblaje;
    }

    /**
     * @param actoresDoblaje the actoresDoblaje to set
     */
    public void setActoresDoblaje(ListaDoble actoresDoblaje) {
        this.actoresDoblaje = actoresDoblaje;
    }

    /**
     * @return the guionistasPlotTwist
     */
    public ListaDoble getGuionistasPlotTwist() {
        return guionistasPlotTwist;
    }

    /**
     * @param guionistasPlotTwist the guionistasPlotTwist to set
     */
    public void setGuionistasPlotTwist(ListaDoble guionistasPlotTwist) {
        this.guionistasPlotTwist = guionistasPlotTwist;
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
