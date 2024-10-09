/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Almacen;

import Entes.Productor;
import Main.ManejadorInterfaz;
import java.util.concurrent.Semaphore;

/**
 * @author Stefano Boschetti
 * @author Emiliana Plaz
 */
public class Almacen {

    // Almacen de partes de PC
    private int placasBase = 0;
    private int cpu = 0;
    private int ram = 0;
    private int fuentes = 0;
    private int graficas = 0;

    //Computadoras sin enviar.
    private int pcEstandar = 0; // Caomputadoras Estandar
    private int pcConGrafica = 0; //Computadoras con Grafica

    //Historico de computadoras vendidas.
    private int pcAcumulados = 0; // Computadoras Estandar
    private int pcConGraficaAcumulados = 0; //Computadoras con Grafica

    //Semaforos
    private Semaphore salarioAccMutex = new Semaphore(1); //Este es para entrar al almacen a gestionar los salarios
    private Semaphore diasMutex = new Semaphore(1); //Este es para entrar al almacen a gestionar los dias

    private int deadline;//cantidad de dias que se tienen para entregar capitulos
    private int estadoDeadline;//ira disminuyendo de 1 en 1 hasta llegar a 0, luego se reiniciara.

    //Salario acumulado
    private float prodPlacaBaseAcc = 0;
    private float prodCpuAcc = 0;
    private float prodRamAcc = 0;
    private float prodFuentesAcc = 0;
    private float prodGraficasAcc = 0;
    private float ensambladorAcc = 0;
    private float pmAcc = 0;
    private float directorAcc = 0;

    //DATOS IMPORTANTES DE CADA EMPRESA
    private float ganancias = 0;
    private float costosOperativos = 0;
    private float utilidades = 0;

    private int contadorPasoDeLosDias = 0;

    //Maximo de partes en el almacen
    private int placasBaseMax = 25;
    private int cpuMax = 20;
    private int ramMax = 55;
    private int fuentesMax = 35;
    private int graficasMax = 10;

    //Estatus del director: 0 = vigilando, 1 = trabajando
    private int estadorDirector = 1;

    //Estatus del PM: 0  = trabajando, 1 = viendo anime
    private int pmEstado = 0;
    private int faltas = 0;
    private int salarioDescontado = 0;

    public Almacen() {
    }

    //ESTE METODO AGREGA EL SALARIO, AL ACUMULADO DE CADA TIPO DE TRABAJADOR: el parametro salary es el salario acumulado del trabajador(salario_por_hora *24)
    public void addSalary(int type, float salary, int tipoCompania) {
        switch (type) {
            case 0 ->
                this.setprodPlacaBaseAcc(this.getprodPlacaBaseAcc() + salary);
            case 1 ->
                this.setprodCpuAcc(this.getprodCpuAcc() + salary);
            case 2 ->
                this.setprodRamAcc(this.getprodRamAcc() + salary);
            case 3 ->
                this.setprodFuentesAcc(this.getprodFuentesAcc() + salary);
            case 4 ->
                this.setprodGraficasAcc(this.getprodGraficasAcc() + salary);
            case 5 ->
                this.setEnsambladorAcc(this.getEnsambladorAcc() + salary);
            case 6 ->
                this.setPmAcc(this.getPmAcc() + salary);
            case 7 ->
                this.setDirectorAcc(this.getDirectorAcc() + salary);
        }
        this.setCostosOperativos(this.getCostosOperativos() + (salary), tipoCompania);
        this.setUtilidades(this.getUtilidades() - (salary), tipoCompania);
    }

    //ESTE METODO AGREGA LAS PIEZAS QUE HA HECHO CADA TRABAJADOR
    public void addPart(Productor trabajador) {
        switch (trabajador.getTipo()) {
            case 0 -> {
                if (this.getPlacasBase() < this.getplacasBaseMax()) { // El almacen no esta lleno.
                    if (this.getPlacasBase() + trabajador.getProgresoActual() > this.getplacasBaseMax()) {
                        // Si hay piezas de más se "descartan" y se marca el almacen como si estuviera al maximo.
                        this.setPlacasBase(this.getplacasBaseMax(), trabajador.getCompania().getTipoCompania());
                    } else {
                        // Si hay espacio simplemente se suman las piezas.
                        this.setPlacasBase((int) (this.getPlacasBase() + trabajador.getProgresoActual()), trabajador.getCompania().getTipoCompania());
                    }
                }
            }

            case 1 -> {
                if (this.getCpu() < this.getcpuMax()) { // El almacen no esta lleno.
                    if (this.getCpu() + trabajador.getProgresoActual() > this.getcpuMax()) {
                        // Si hay piezas de más se "descartan" y se marca el almacen como si estuviera al maximo.
                        this.setCpu(this.getcpuMax(), trabajador.getCompania().getTipoCompania());
                    } else {
                        // Si hay espacio simplemente se suman las piezas.
                        this.setCpu((int) (this.getCpu() + trabajador.getProgresoActual()), trabajador.getCompania().getTipoCompania());
                    }
                }
            }

            case 2 -> {
                if (this.getRam() < this.getramMax()) { // El almacen no esta lleno.
                    if (this.getRam() + trabajador.getProgresoActual() > this.getramMax()) {
                        // Si hay piezas de más se "descartan" y se marca el almacen como si estuviera al maximo.
                        this.setRam(this.getramMax(), trabajador.getCompania().getTipoCompania());
                    } else {
                        // Si hay espacio simplemente se suman las piezas.
                        this.setRam((int) (this.getRam() + trabajador.getProgresoActual()), trabajador.getCompania().getTipoCompania());
                    }
                }

            }

            case 3 -> {
                if (this.getFuentes() < this.getfuentesMax()) { // El almacen no esta lleno.
                    if (this.getFuentes() + trabajador.getProgresoActual() > this.getfuentesMax()) {
                        // Si hay piezas de más se "descartan" y se marca el almacen como si estuviera al maximo.
                        this.setFuentes(this.getfuentesMax(), trabajador.getCompania().getTipoCompania());
                    } else {
                        // Si hay espacio simplemente se suman las piezas.
                        this.setFuentes((int) (this.getFuentes() + trabajador.getProgresoActual()), trabajador.getCompania().getTipoCompania());
                    }
                }
            }

            case 4 -> {
                if (this.getGraficas() < this.getgraficasMax()) { // El almacen no esta lleno.
                    if (this.getGraficas() + trabajador.getProgresoActual() > this.getgraficasMax()) {
                        // Si hay piezas de más se "descartan" y se marca el almacen como si estuviera al maximo.
                        this.setGraficas(this.getgraficasMax(), trabajador.getCompania().getTipoCompania());
                    } else {
                        // Si hay espacio simplemente se suman las piezas.
                        
                        this.setGraficas((int) (this.getGraficas() + trabajador.getProgresoActual()), trabajador.getCompania().getTipoCompania());
                    }
                }
            }
        }
    }

    public int getPlacasBase() {
        return placasBase;
    }

    public void setPlacasBase(int placasBase, int tipoCompania) {
        this.placasBase = placasBase;
        if (tipoCompania == 0) {
            ManejadorInterfaz.getInterfaz().cambiarPlacasBaseApple(placasBase);
        } else if (tipoCompania == 1) {
            ManejadorInterfaz.getInterfaz().cambiarPlacasBaseHP(placasBase);
        }
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu, int tipoCompania) {
        this.cpu = cpu;
        if (tipoCompania == 0) {
            ManejadorInterfaz.getInterfaz().cambiarCpuApple(cpu);
        } else if (tipoCompania == 1) {
            ManejadorInterfaz.getInterfaz().cambiarCpuHP(cpu);
        }
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram, int tipoCompania) {
        this.ram = ram;
        if (tipoCompania == 0) {
            ManejadorInterfaz.getInterfaz().cambiarRamApple(ram);
        } else if (tipoCompania == 1) {
            ManejadorInterfaz.getInterfaz().cambiarRamHP(ram);
        }
    }

    public int getFuentes() {
        return fuentes;
    }

    public void setFuentes(int fuentes, int tipoCompania) {
        this.fuentes = fuentes;
        if (tipoCompania == 0) {
            ManejadorInterfaz.getInterfaz().cambiarFuentesApple(fuentes);
        } else if (tipoCompania == 1) {
            ManejadorInterfaz.getInterfaz().cambiarFuentesHP(fuentes);
        }
    }

    public int getGraficas() {
        return graficas;
    }

    public void setGraficas(int graficas, int tipoCompania) {
        this.graficas = graficas;
        if (tipoCompania == 0) {
            ManejadorInterfaz.getInterfaz().cambiarGraficasApple(graficas);
        } else if (tipoCompania == 1) {
            ManejadorInterfaz.getInterfaz().cambiarGraficasHP(graficas);
        }
    }

    public int getPcConGrafica() {
        return pcConGrafica;
    }

    public void setPcConGrafica(int pcConGrafica, int tipoCompania) {
        this.pcConGrafica = pcConGrafica;
        ManejadorInterfaz.getInterfaz().cambiarPcGraficasListas(pcConGrafica, tipoCompania);
    }

    public int getPcEstandar() {
        return pcEstandar;
    }

    public void setPcEstandar(int pcEstandar, int tipoCompania) {
        this.pcEstandar = pcEstandar;
        ManejadorInterfaz.getInterfaz().cambiarPcEstandarListas(pcEstandar, tipoCompania);
    }

    public Semaphore getSalarioAccMutex() {
        return salarioAccMutex;
    }

    public void setSalarioAccMutex(Semaphore salarioAccMutex) {
        this.salarioAccMutex = salarioAccMutex;
    }

    public float getprodPlacaBaseAcc() {
        return prodPlacaBaseAcc;
    }

    public void setprodPlacaBaseAcc(float prodPlacaBaseAcc) {
        this.prodPlacaBaseAcc = prodPlacaBaseAcc;
    }

    public float getprodCpuAcc() {
        return prodCpuAcc;
    }

    public void setprodCpuAcc(float prodCpuAcc) {
        this.prodCpuAcc = prodCpuAcc;
    }

    public float getprodRamAcc() {
        return prodRamAcc;
    }

    public void setprodRamAcc(float prodRamAcc) {
        this.prodRamAcc = prodRamAcc;
    }

    public float getprodFuentesAcc() {
        return prodFuentesAcc;
    }

    public void setprodFuentesAcc(float prodFuentesAcc) {
        this.prodFuentesAcc = prodFuentesAcc;
    }

    public float getprodGraficasAcc() {
        return prodGraficasAcc;
    }

    public void setprodGraficasAcc(float prodGraficasAcc) {
        this.prodGraficasAcc = prodGraficasAcc;
    }

    public int getplacasBaseMax() {
        return placasBaseMax;
    }

    public void setplacasBaseMax(int placasBaseMax) {
        this.placasBaseMax = placasBaseMax;
    }

    public int getcpuMax() {
        return cpuMax;
    }

    public void setcpuMax(int cpuMax) {
        this.cpuMax = cpuMax;
    }

    public int getramMax() {
        return ramMax;
    }

    public void setramMax(int ramMax) {
        this.ramMax = ramMax;
    }

    public int getfuentesMax() {
        return fuentesMax;
    }

    public void setfuentesMax(int fuentesMax) {
        this.fuentesMax = fuentesMax;
    }

    public int getgraficasMax() {
        return graficasMax;
    }

    public void setgraficasMax(int graficasMax) {
        this.graficasMax = graficasMax;
    }

    public int getEstadorDirector() {
        return estadorDirector;
    }

    public void setEstadorDirector(int estadorDirector, int tipoCompania) {
        this.estadorDirector = estadorDirector;
        if (estadorDirector == 0) {
            ManejadorInterfaz.getInterfaz().cambiarActividadDirector("VIGILANDO", tipoCompania);
        } else {
            ManejadorInterfaz.getInterfaz().cambiarActividadDirector("TRABAJANDO", tipoCompania);
        }
    }

    public int getPmEstado() {
        return pmEstado;
    }

    public void setPmEstado(int pmEstado, int tipoCompania) {
        this.pmEstado = pmEstado;
        if (pmEstado == 0) {
            ManejadorInterfaz.getInterfaz().cambiarPMActividad("TRABAJANDO", tipoCompania);
        } else {
            ManejadorInterfaz.getInterfaz().cambiarPMActividad("VIENDO ANIME", tipoCompania);
        }
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas, int tipoCompania) {
        this.faltas = faltas;
        ManejadorInterfaz.getInterfaz().cambiarFaltasPM(faltas, tipoCompania);
    }

    public int getSalarioDescontado() {
        return salarioDescontado;
    }

    public void setSalarioDescontado(int salarioDescontado, int tipoCompania) {
        this.salarioDescontado = salarioDescontado;
        ManejadorInterfaz.getInterfaz().cambiarSalarioDescontadoPM(salarioDescontado, tipoCompania);
    }

    public float getEnsambladorAcc() {
        return ensambladorAcc;
    }

    public void setEnsambladorAcc(float ensambladorAcc) {
        this.ensambladorAcc = ensambladorAcc;
    }

    public float getPmAcc() {
        return pmAcc;
    }

    public void setPmAcc(float pmAcc) {
        this.pmAcc = pmAcc;
    }

    public float getDirectorAcc() {
        return directorAcc;
    }

    public void setDirectorAcc(float directorAcc) {
        this.directorAcc = directorAcc;
    }

    public Semaphore getDiasMutex() {
        return diasMutex;
    }

    public void setDiasMutex(Semaphore diasMutex) {
        this.diasMutex = diasMutex;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getEstadoDeadline() {
        return estadoDeadline;
    }

    public void setEstadoDeadline(int estadoDeadlineNuevo, int tipoCompania) {
        this.estadoDeadline = estadoDeadlineNuevo;
        ManejadorInterfaz.getInterfaz().cambiarDiasLanzamiento(estadoDeadline, tipoCompania);
    }

    public int getContadorPasoDeLosDias() {
        return contadorPasoDeLosDias;
    }

    public void setContadorPasoDeLosDias(int contadorPasoDeLosDias) {
        this.contadorPasoDeLosDias = contadorPasoDeLosDias;
        ManejadorInterfaz.getInterfaz().cambiarPasoDeDias(contadorPasoDeLosDias);
    }

    public float getGanancias() {
        return ganancias;
    }

    public void setGanancias(float ganancias, int tipoCompania) {
        this.ganancias = ganancias;
        ManejadorInterfaz.getInterfaz().cambiarGanancias(ganancias, tipoCompania);
    }

    public float getCostosOperativos() {
        return costosOperativos;
    }

    public void setCostosOperativos(float costosOperativos, int tipoCompania) {
        this.costosOperativos = costosOperativos;
        ManejadorInterfaz.getInterfaz().cambiarCostosOperativos(costosOperativos, tipoCompania);
    }

    public float getUtilidades() {
        return utilidades;
    }

    public void setUtilidades(float utilidades, int tipoCompania) {
        this.utilidades = utilidades;
        ManejadorInterfaz.getInterfaz().cambiarUtilidades(utilidades, tipoCompania);
    }

    public int getpcConGraficaAcumulados() {
        return pcConGraficaAcumulados;
    }

    public void setpcConGraficaAcumulados(int pcConGraficaAcumulados) {
        this.pcConGraficaAcumulados = pcConGraficaAcumulados;
    }

    public int getpcAcumulados() {
        return pcAcumulados;
    }

    public void setpcAcumulados(int pcAcumulados) {
        this.pcAcumulados = pcAcumulados;
    }

}
