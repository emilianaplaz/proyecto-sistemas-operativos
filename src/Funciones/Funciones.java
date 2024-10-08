/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Main.ManejadorInterfaz;
import GUI.Global;
import Entes.Ensamblador;
import Entes.Productor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author emilianaplaz
 */
public class Funciones {

    public void escribir_txt() {
        System.out.println("");
        String datos_iniciales = "";
        //Cdatos de trabajadores de hp
        datos_iniciales = ManejadorInterfaz.getInterfaz().getProdPlacaBaseHP() + ","
                + ManejadorInterfaz.getInterfaz().getProdCpuHP() + ","
                + ManejadorInterfaz.getInterfaz().getProdRamHP() + ","
                + ManejadorInterfaz.getInterfaz().getProdFuenteHP() + ","
                + ManejadorInterfaz.getInterfaz().getProdGraficaHP() + ","
                + ManejadorInterfaz.getInterfaz().getEnsambladoresCN();
        //datos de trabajadores de apple
        datos_iniciales = datos_iniciales + "\n" + ManejadorInterfaz.getInterfaz().getProdPlacaBaseApple() + ","
                + ManejadorInterfaz.getInterfaz().getProdCpuApple() + ","
                + ManejadorInterfaz.getInterfaz().getProdRamApple() + ","
                + ManejadorInterfaz.getInterfaz().getProdFuenteApple() + ","
                + ManejadorInterfaz.getInterfaz().getProdGraficaApple() + ","
                + ManejadorInterfaz.getInterfaz().getEnsambladoresApple();
        //duracion de los dias
        datos_iniciales = datos_iniciales + "\n" + ManejadorInterfaz.getInterfaz().getDuracionDias();
        //dias para la entrega
        datos_iniciales = datos_iniciales + "\n" + ManejadorInterfaz.getInterfaz().getDiasEntrega();
        try {
            PrintWriter pw = new PrintWriter("test\\datos_iniciales.txt");
            pw.println(datos_iniciales);
            pw.close();
            JOptionPane.showMessageDialog(null, "Guardado exitoso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
    }

    public void leer_txt() {
        String line;
        String txt = "";
        String path = "test\\datos_iniciales.txt";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        txt += line + "\n";
                    }
                }

                if (!"".equals(txt)) {
                    String[] datos_split = txt.split("\n");
                    String[] hp = datos_split[0].split(",");
                    String[] apple = datos_split[1].split(",");
                    //Cargamos trabajadores de HP
                    for (int i = 0; i < 6; i++) {
                        switch (i) {
                            case 0 -> {
                                for (int j = 0; j < Integer.parseInt(hp[i]); j++) {
                                    Productor placaNuevo = new Productor(0, Global.getMutexHP(), Global.getHP());
                                    placaNuevo.start();
                                    Global.getHP().getProdPlacaBase().insertFinal(placaNuevo);
                                }
                            }
                            case 1 -> {
                                for (int j = 0; j < Integer.parseInt(hp[i]); j++) {
                                    Productor cpuNuevo = new Productor(1, Global.getMutexHP(), Global.getHP());
                                    cpuNuevo.start();
                                    Global.getHP().getProdCpu().insertFinal(cpuNuevo);
                                }
                            }
                            case 2 -> {
                                for (int j = 0; j < Integer.parseInt(hp[i]); j++) {
                                    Productor ramNuevo = new Productor(2, Global.getMutexHP(), Global.getHP());
                                    ramNuevo.start();
                                    Global.getHP().getProdRam().insertFinal(ramNuevo);
                                }
                            }
                            case 3 -> {
                                for (int j = 0; j < Integer.parseInt(hp[i]); j++) {
                                    Productor fuenteNuevo = new Productor(3, Global.getMutexHP(), Global.getHP());
                                    fuenteNuevo.start();
                                    Global.getHP().getProdFuentes().insertFinal(fuenteNuevo);
                                }
                            }
                            case 4 -> {
                                for (int j = 0; j < Integer.parseInt(hp[i]); j++) {
                                    Productor graficasNuevo = new Productor(4, Global.getMutexHP(), Global.getHP());
                                    graficasNuevo.start();
                                    Global.getHP().getProdGraficas().insertFinal(graficasNuevo);
                                }
                            }
                            case 5 -> {
                                for (int j = 0; j < Integer.parseInt(hp[i]); j++) {
                                    Ensamblador ensambladorNuevo = new Ensamblador(5, Global.getMutexHP(), Global.getHP());
                                    ensambladorNuevo.start();
                                    Global.getHP().getEnsambladores().insertFinal(ensambladorNuevo);
                                }
                            }
                        }
                    }
                    //actualizamos la interfaz con la cantidad de trabjadores que estan activos
                    this.ActualizarPestanaHP(hp);

                    //Cargamos trabajadores de Apple
                    for (int i = 0; i < 6; i++) {
                        switch (i) {
                            case 0 -> {
                                for (int j = 0; j < Integer.parseInt(apple[i]); j++) {
                                    Productor prodplacabaseNuevo = new Productor(0, Global.getMutexApple(), Global.getApple());
                                    prodplacabaseNuevo.start();
                                    Global.getApple().getProdPlacaBase().insertFinal(prodplacabaseNuevo);
                                }
                            }
                            case 1 -> {
                                for (int j = 0; j < Integer.parseInt(apple[i]); j++) {
                                    Productor prodcpuNuevo = new Productor(1, Global.getMutexApple(), Global.getApple());
                                    prodcpuNuevo.start();
                                    Global.getApple().getProdCpu().insertFinal(prodcpuNuevo);
                                }
                            }
                            case 2 -> {
                                for (int j = 0; j < Integer.parseInt(apple[i]); j++) {
                                    Productor prodramNuevo = new Productor(2, Global.getMutexApple(), Global.getApple());
                                    prodramNuevo.start();
                                    Global.getApple().getProdRam().insertFinal(prodramNuevo);
                                }
                            }
                            case 3 -> {
                                for (int j = 0; j < Integer.parseInt(apple[i]); j++) {
                                    Productor prodfuenteNuevo = new Productor(3, Global.getMutexApple(), Global.getApple());
                                    prodfuenteNuevo.start();
                                    Global.getApple().getProdFuentes().insertFinal(prodfuenteNuevo);
                                }
                            }
                            case 4 -> {
                                for (int j = 0; j < Integer.parseInt(apple[i]); j++) {
                                    Productor prodgraficaNuevo = new Productor(4, Global.getMutexApple(), Global.getApple());
                                    prodgraficaNuevo.start();
                                    Global.getApple().getProdGraficas().insertFinal(prodgraficaNuevo);
                                }
                            }
                            case 5 -> {
                                for (int j = 0; j < Integer.parseInt(apple[i]); j++) {
                                    Ensamblador ensambladorNuevo = new Ensamblador(5, Global.getMutexApple(), Global.getApple());
                                    ensambladorNuevo.start();
                                    Global.getApple().getEnsambladores().insertFinal(ensambladorNuevo);
                                }
                            }
                        }
                    }
                    //actualizamos la interfaz con la cantidad de trabjadores que estan activos
                    this.ActualizarPestanaApple(apple);

                    //Cargamos duracion dias
                    Global.getHP().setDuracionDia(Integer.parseInt(datos_split[2]) * 1000);
                    Global.getApple().setDuracionDia(Integer.parseInt(datos_split[2]) * 1000);
                    // Los actualizamos en la interfaz
                    ManejadorInterfaz.getInterfaz().setDuracionDias(datos_split[2]);
                    
                    //Cargamos deadline
                    Global.getAlmacenHP().setDeadline(Integer.parseInt(datos_split[3]));
                    Global.getAlmacenApple().setDeadline(Integer.parseInt(datos_split[3]));
                    ManejadorInterfaz.getInterfaz().setDiasEntrega(datos_split[3]);

                    //Cargamos el estadoDeadline
                    Global.getAlmacenApple().setEstadoDeadline(Integer.parseInt(datos_split[3]), Global.getApple().getTipoCompania());
                    Global.getAlmacenHP().setEstadoDeadline(Integer.parseInt(datos_split[3]), Global.getHP().getTipoCompania());

                }
                br.close();
                //JOptionPane.showMessageDialog(null,"Lectura exitosa");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer");
        }
    }

    public void ActualizarPestanaHP(String[] hp) {
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0 ->
                    ManejadorInterfaz.getInterfaz().setProdPlacaBaseHP(Integer.parseInt(hp[i]));
                case 1 ->
                    ManejadorInterfaz.getInterfaz().setProdCPUHP(Integer.parseInt(hp[i]));
                case 2 ->
                    ManejadorInterfaz.getInterfaz().setProdRamHP(Integer.parseInt(hp[i]));
                case 3 ->
                    ManejadorInterfaz.getInterfaz().setProdFuenteHP(Integer.parseInt(hp[i]));
                case 4 ->
                    ManejadorInterfaz.getInterfaz().setProdGraficaHP(Integer.parseInt(hp[i]));
                case 5 ->
                    ManejadorInterfaz.getInterfaz().setEnsambladoresHP(Integer.parseInt(hp[i]));
            }
        }
    }

    public void ActualizarPestanaApple(String[] apple) {
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0 ->
                    ManejadorInterfaz.getInterfaz().setProdPlacaBaseApple(Integer.parseInt(apple[i]));
                case 1 ->
                    ManejadorInterfaz.getInterfaz().setProdCPUApple(Integer.parseInt(apple[i]));
                case 2 ->
                    ManejadorInterfaz.getInterfaz().setProdRamApple(Integer.parseInt(apple[i]));
                case 3 ->
                    ManejadorInterfaz.getInterfaz().setProdFuenteApple(Integer.parseInt(apple[i]));
                case 4 ->
                    ManejadorInterfaz.getInterfaz().setProdGraficaApple(Integer.parseInt(apple[i]));
                case 5 ->
                    ManejadorInterfaz.getInterfaz().setEnsambladoresApple(Integer.parseInt(apple[i]));
            }
        }
    }

}
