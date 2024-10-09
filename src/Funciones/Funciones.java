/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Estructuras.ListaDoble;
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
    public void escribir_txt(){
        System.out.println("");
        String datos_iniciales = "";
        //Cdatos de trabajadores de hp
        datos_iniciales = ManejadorInterfaz.getInterfaz().getProdPlacaBaseHP()+","+
                          ManejadorInterfaz.getInterfaz().getProdCpuHP() +","+
                          ManejadorInterfaz.getInterfaz().getProdRamHP()+","+
                          ManejadorInterfaz.getInterfaz().getProdFuenteHP()+","+
                          ManejadorInterfaz.getInterfaz().getProdGraficaHP()+","+
                          ManejadorInterfaz.getInterfaz().getEnsambladoresCN();
        //datos de trabajadores de apple
        datos_iniciales = datos_iniciales + "\n"+ManejadorInterfaz.getInterfaz().getProdPlacaBaseApple()+","+
                                                ManejadorInterfaz.getInterfaz().getProdCpuApple() +","+
                                                ManejadorInterfaz.getInterfaz().getProdRamApple()+","+
                                                ManejadorInterfaz.getInterfaz().getProdFuenteApple()+","+
                                                ManejadorInterfaz.getInterfaz().getProdGraficaApple()+","+
                                                ManejadorInterfaz.getInterfaz().getEnsambladoresApple();
        //duracion de los dias
        datos_iniciales = datos_iniciales + "\n"+ManejadorInterfaz.getInterfaz().getDuracionDias();
        //dias para la entrega
        datos_iniciales = datos_iniciales + "\n"+ManejadorInterfaz.getInterfaz().getDiasEntrega();
        try{
            PrintWriter pw = new PrintWriter("test\\datos_iniciales.txt");
            pw.println(datos_iniciales);
            pw.close();
            JOptionPane.showMessageDialog(null,"Guardado exitoso");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al guardar");
        }
    }
    
    public void leer_txt(){
        String line;
        String txt ="";
        String path = "test\\datos_iniciales.txt";
        File file = new File(path);
        try{
            if (!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine()) != null){
                    if(! line.isEmpty()){
                        txt += line + "\n";
                    }
                }
                
                if(! "".equals(txt)){
                    String[] datos_split = txt.split("\n");
                    String[] hp = datos_split[0].split(",");
                    String[] apple = datos_split[1].split(",");
                    //Cargamos trabajadores de HP
                    for (int i = 0; i < 6; i++) {
                        if(i == 0){ 
                            for (int j = 0; j < Integer.parseInt(hp[i]); j++) {
                                Productor animadorNuevo = new Productor(0,40,Global.getMutexHP(),Global.getHP());
                                animadorNuevo.start();
                                Global.getHP().getProdPlacaBase().insertFinal(animadorNuevo);
                            }
                        }else if(i == 1){
                            for (int j = 0; j < Integer.parseInt(hp[i]); j++) {
                                Productor guionistaNuevo = new Productor(1,20,Global.getMutexHP(),Global.getHP());
                                guionistaNuevo.start();
                                Global.getHP().getProdCpu().insertFinal(guionistaNuevo);
                            }
                        }else if(i == 2){
                            for (int j = 0; j < Integer.parseInt(hp[i]); j++) {
                                Productor DisEscenariosNuevo = new Productor(2,26,Global.getMutexHP(),Global.getHP());
                                DisEscenariosNuevo.start();
                                Global.getHP().getProdRam().insertFinal(DisEscenariosNuevo);
                            }
                        }else if(i == 3){
                            for (int j = 0; j < Integer.parseInt(hp[i]); j++) {
                                Productor ActorDoblajeNuevo = new Productor(3,16,Global.getMutexHP(),Global.getHP());
                                ActorDoblajeNuevo.start();
                                Global.getHP().getProdFuentes().insertFinal(ActorDoblajeNuevo);
                            }
                        }else if(i == 4){
                            for (int j = 0; j < Integer.parseInt(hp[i]); j++) {
                                Productor pttNuevo = new Productor(4,34,Global.getMutexHP(),Global.getHP());
                                pttNuevo.start();
                                Global.getHP().getProdGraficas().insertFinal(pttNuevo);
                            }
                        }else if(i == 5){
                            for (int j = 0; j < Integer.parseInt(hp[i]); j++) {
                                Ensamblador ensambladorNuevo = new Ensamblador(5,50,Global.getMutexHP(),Global.getHP());
                                ensambladorNuevo.start();
                                Global.getHP().getEnsambladores().insertFinal(ensambladorNuevo);
                            }
                        }
                    }
                    //actualizamos la interfaz con la cantidad de trabjadores que estan activos
                    this.ActualizarPestanaHP(hp);
                    
                    //Cargamos trabajadores de Apple
                    for (int i = 0; i < 6; i++) {
                        if(i == 0){ 
                            for (int j = 0; j < Integer.parseInt(apple[i]); j++) {
                                Productor prodplacabaseNuevo = new Productor(0,40,Global.getMutexApple(),Global.getApple());
                                prodplacabaseNuevo.start();
                                Global.getApple().getProdPlacaBase().insertFinal(prodplacabaseNuevo);
                            }
                        }else if(i == 1){
                            for (int j = 0; j < Integer.parseInt(apple[i]); j++) {
                                Productor prodcpuNuevo = new Productor(1,20,Global.getMutexApple(),Global.getApple());
                                prodcpuNuevo.start();
                                Global.getApple().getProdCpu().insertFinal(prodcpuNuevo);
                            }
                        }else if(i == 2){
                            for (int j = 0; j < Integer.parseInt(apple[i]); j++) {
                                Productor prodramNuevo = new Productor(2,26,Global.getMutexApple(),Global.getApple());
                                prodramNuevo.start();
                                Global.getApple().getProdRam().insertFinal(prodramNuevo);
                            }
                        }else if(i == 3){
                            for (int j = 0; j < Integer.parseInt(apple[i]); j++) {
                                Productor prodfuenteNuevo = new Productor(3,16,Global.getMutexApple(),Global.getApple());
                                prodfuenteNuevo.start();
                                Global.getApple().getProdFuentes().insertFinal(prodfuenteNuevo);
                            }
                        }else if(i == 4){
                            for (int j = 0; j < Integer.parseInt(apple[i]); j++) {
                                Productor prodgraficaNuevo = new Productor(4,34,Global.getMutexApple(),Global.getApple());
                                prodgraficaNuevo.start();
                                Global.getApple().getProdGraficas().insertFinal(prodgraficaNuevo);
                            }
                        }else if(i == 5){
                            for (int j = 0; j < Integer.parseInt(apple[i]); j++) {
                                Ensamblador ensambladorNuevo = new Ensamblador(5,50,Global.getMutexApple(),Global.getApple());
                                ensambladorNuevo.start();
                                Global.getApple().getEnsambladores().insertFinal(ensambladorNuevo);
                            }
                        }
                    }
                    //actualizamos la interfaz con la cantidad de trabjadores que estan activos
                    this.ActualizarPestanaApple(apple);
                    
                    //Cargamos duracion dias
                    Global.getHP().setDuracionDia(Integer.parseInt(datos_split[2])*1000);
                    Global.getApple().setDuracionDia(Integer.parseInt(datos_split[2])*1000);
                    
                    //Cargamos deadline
                    Global.getAlmacenHP().setDeadline(Integer.parseInt(datos_split[3]));
                    Global.getAlmacenApple().setDeadline(Integer.parseInt(datos_split[3]));
                    
                    //Cargamos el estadoDeadline
                    Global.getAlmacenApple().setEstadoDeadline(Integer.parseInt(datos_split[3]),Global.getApple().getTipoCompania());
                    Global.getAlmacenHP().setEstadoDeadline(Integer.parseInt(datos_split[3]), Global.getHP().getTipoCompania());
                    
                }
                br.close();
                //JOptionPane.showMessageDialog(null,"Lectura exitosa");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al leer");
        }
    }
    
    public void ActualizarPestanaHP(String[] hp){
        for (int i = 0; i < 6; i++) {
            if(i == 0){
                ManejadorInterfaz.getInterfaz().setProdPlacaBaseHP(Integer.parseInt(hp[i]));
            }else if(i == 1){
                ManejadorInterfaz.getInterfaz().setProdCPUHP(Integer.parseInt(hp[i]));
            }else if(i == 2){
                ManejadorInterfaz.getInterfaz().setProdRamHP(Integer.parseInt(hp[i]));
            }else if(i == 3){
                ManejadorInterfaz.getInterfaz().setProdFuenteHP(Integer.parseInt(hp[i]));
            }else if(i == 4){
                ManejadorInterfaz.getInterfaz().setProdGraficaHP(Integer.parseInt(hp[i]));
            }else if(i == 5){
                ManejadorInterfaz.getInterfaz().setEnsambladoresHP(Integer.parseInt(hp[i]));
            }
        }
    }
    
    public void ActualizarPestanaApple(String[] apple){
        for (int i = 0; i < 6; i++) {
            if(i == 0){
                ManejadorInterfaz.getInterfaz().setProdPlacaBaseApple(Integer.parseInt(apple[i]));
            }else if(i == 1){
                ManejadorInterfaz.getInterfaz().setProdCPUApple(Integer.parseInt(apple[i]));
            }else if(i == 2){
                ManejadorInterfaz.getInterfaz().setProdRamApple(Integer.parseInt(apple[i]));
            }else if(i == 3){
                ManejadorInterfaz.getInterfaz().setProdFuenteApple(Integer.parseInt(apple[i]));
            }else if(i == 4){
                ManejadorInterfaz.getInterfaz().setProdGraficaApple(Integer.parseInt(apple[i]));
            }else if(i == 5){
                ManejadorInterfaz.getInterfaz().setEnsambladoresApple(Integer.parseInt(apple[i]));
            }
        }
    }
    
}
