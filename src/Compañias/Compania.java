/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compañias;

import Estructuras.ListaDoble;
import Almacen.Almacen;

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
    private ListaDoble prodPlacaBase; //
    private ListaDoble prodCpu; //
    private ListaDoble prodRam; //
    private ListaDoble prodFuentes; //
    private ListaDoble prodGraficas; //

    private float prodDiariaPlacaBase; //
    private float prodDiariaCpu; //
    private float prodDiariaRam; //
    private float prodDiariaFuentes; //
    private float prodDiariaGraficas; //

    public Compania() {
    }

    public Compania(Almacen almacen, int companyType) {
        this.duracionDia = 6000;
        this.tipoCompania = companyType;
        this.almacen = almacen;
        this.utilidades = 0;
        this.ensambladores = new ListaDoble();
        this.prodCpu = new ListaDoble();
        this.prodPlacaBase = new ListaDoble();
        this.prodRam = new ListaDoble();
        this.prodFuentes = new ListaDoble();
        this.prodGraficas = new ListaDoble();

        if (tipoCompania == 0) { //Cuando la compañia es Apple. (Stefano)
//            Ultimo digito del carnet = 6
            this.prodDiariaPlacaBase = (float) 1 / 4; // 1 placa cada 4 dias
            this.prodDiariaCpu = (float) 1 / 4; // 1 CPU cada 4 dias
            this.prodDiariaRam = (float) 1; // 1 RAM cada dia
            this.prodDiariaFuentes = (float) 5; // 5 fuente cada dia
            this.prodDiariaGraficas = (float) 1 / 2; // 1 grafica cada 2 dias
        } else if (tipoCompania == 1) { //Cuando la compañia es HP. (Emiliana)
//            Ultimo digito del carnet = 3
            this.prodDiariaPlacaBase = (float) 1 / 3; // 1 placa cada 3 dias
            this.prodDiariaCpu = (float) 1 / 3; // 1 CPU cada 3 dias
            this.prodDiariaRam = (float) 2; // 2 RAM cada dia
            this.prodDiariaFuentes = (float) 3; // 3 fuente cada dia
            this.prodDiariaGraficas = (float) 1 / 3; // 1 grafica cada 3 dias
        }
    }

    public int cantidadTrabajadores() {
        int respuesta = getEnsambladores().getSize()
                + getProdPlacaBase().getSize()
                + getProdPlacaBase().getSize()
                + getProdRam().getSize()
                + getProdFuentes().getSize()
                + getProdGraficas().getSize();
        return respuesta;
    }

    public int getDuracionDia() {
        return duracionDia;
    }

    public void setDuracionDia(int duracionDia) {
        this.duracionDia = duracionDia;
    }

    public int getTipoCompania() {
        return tipoCompania;
    }

    public void setTipoCompania(int tipoCompania) {
        this.tipoCompania = tipoCompania;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public float getUtilidades() {
        return utilidades;
    }

    public void setUtilidades(float utilidades) {
        this.utilidades = utilidades;
    }

    public ListaDoble getEnsambladores() {
        return ensambladores;
    }

    public void setEnsambladores(ListaDoble ensambladores) {
        this.ensambladores = ensambladores;
    }

    public ListaDoble getProdPlacaBase() {
        return prodPlacaBase;
    }

    public void setProdPlacaBase(ListaDoble prodPlacaBase) {
        this.prodPlacaBase = prodPlacaBase;
    }

    public ListaDoble getProdCpu() {
        return prodCpu;
    }

    public void setProdCpu(ListaDoble prodCpu) {
        this.prodCpu = prodCpu;
    }

    public ListaDoble getProdRam() {
        return prodRam;
    }

    public void setProdRam(ListaDoble prodRam) {
        this.prodRam = prodRam;
    }

    public ListaDoble getProdFuentes() {
        return prodFuentes;
    }

    public void setProdFuentes(ListaDoble prodFuentes) {
        this.prodFuentes = prodFuentes;
    }

    public ListaDoble getProdGraficas() {
        return prodGraficas;
    }

    public void setProdGraficas(ListaDoble prodGraficas) {
        this.prodGraficas = prodGraficas;
    }

    public float getProdDiariaPlacaBase() {
        return prodDiariaPlacaBase;
    }

    public void setProdDiariaPlacaBase(float prodDiariaPlacaBase) {
        this.prodDiariaPlacaBase = prodDiariaPlacaBase;
    }

    public float getProdDiariaCpu() {
        return prodDiariaCpu;
    }

    public void setProdDiariaCpu(float prodDiariaCpu) {
        this.prodDiariaCpu = prodDiariaCpu;
    }

    public float getProdDiariaRam() {
        return prodDiariaRam;
    }

    public void setProdDiariaRam(float prodDiariaRam) {
        this.prodDiariaRam = prodDiariaRam;
    }

    public float getProdDiariaFuentes() {
        return prodDiariaFuentes;
    }

    public void setProdDiariaFuentes(float prodDiariaFuentes) {
        this.prodDiariaFuentes = prodDiariaFuentes;
    }

    public float getProdDiariaGraficas() {
        return prodDiariaGraficas;
    }

    public void setProdDiariaGraficas(float prodDiariaGraficas) {
        this.prodDiariaGraficas = prodDiariaGraficas;
    }

}
