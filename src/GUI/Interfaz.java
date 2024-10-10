/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Entes.Ensamblador;
import Entes.Productor;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * @author Stefano Boschetti
 * @author Emiliana Plaz
 */
public class Interfaz extends javax.swing.JFrame {

    
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    //ESTE METODO DEVUELVE TRUE SI SE PUEDE AUMENTAR Y DEVUELVE FALSE SI NO SE PUEDE. Solo funciona para apple
    public boolean permisoDeAumentoDeTrabajadorApple(){
        boolean respuesta = false;
        int totalTrabajadores = Global.getApple().cantidadTrabajadores(); 
        if(totalTrabajadores < 18){  //CARNET DE Stefano TERMINA EN 6 POR LO TANTO -> 12+6=18
            respuesta = true;
        }
        return respuesta;
    }
    
    //ESTE METODO DEVUELVE TRUE SI SE PUEDE AUMENTAR Y DEVUELVE FALSE SI NO SE PUEDE. Solo funciona para cartoon HP
    public boolean permisoDeAumentoDeTrabajadorHP(){
        boolean respuesta = false;
        int totalTrabajadores = Global.getHP().cantidadTrabajadores();
        if(totalTrabajadores < 15){ //CARNET DE Emiliana TERMINA EN 3 POR LO TANTO -> 12+3=15
            respuesta = true;
        }
        return respuesta;
    }
    
    public boolean permisoDeAumentoDeTrabajadorAppleEnDatosIniciales(){
        boolean respuesta = false;
        int totalTrabajadores = Integer.parseInt(prodplacabaseApple.getText())+
                                Integer.parseInt(prodcpuApple.getText())+
                                Integer.parseInt(prodramApple.getText())+
                                Integer.parseInt(prodfuenteApple.getText())+
                                Integer.parseInt(prodgraficaApple.getText())+
                                Integer.parseInt(ensambladoresApple.getText()); 
        if(totalTrabajadores < 18){  //Carnet Stefano
            respuesta = true;
        }
        return respuesta;
    }
    
    public boolean permisoDeAumentoDeTrabajadorHPEnDatosIniciales(){
        boolean respuesta = false;
        int totalTrabajadores = Integer.parseInt(prodplacabaseHP.getText())+
                                Integer.parseInt(prodcpuHP.getText())+
                                Integer.parseInt(prodramHP.getText())+
                                Integer.parseInt(prodfuenteHP.getText())+
                                Integer.parseInt(prodgraficaHP.getText())+
                                Integer.parseInt(ensambladoresHP.getText()); 
        if(totalTrabajadores < 15){  //Carnet Emiliana
            respuesta = true;
        }
        return respuesta;
    }
    
    public void cambiarPasoDeDias(int t){
        diasInicio.setText(Integer.toString(t));
        diasApple.setText(Integer.toString(t));
        diasHP.setText(Integer.toString(t));
    }
    
    public void cambiarDiasLanzamiento(int t,int tipoCompania){
        if(tipoCompania == 0){
            diasEntregaApple.setText(Integer.toString(t));
            diasHP1.setText(Integer.toString(t));
        }else{
            diasEntregaHP.setText(Integer.toString(t));
            diasHP1.setText(Integer.toString(t));
        }
    }
    
    public void cambiarPMActividad(String t,int tipoCompania){
        if(tipoCompania == 0){
            pmActividadApple.setText(t);
        }else{
            pmActividadHP.setText(t);
        }
    }
    
    public void cambiarFaltasPM(int t,int tipoCompania){
        if(tipoCompania == 0){
            faltaspmApple.setText(Integer.toString(t));
        }else{
            faltaspmHP.setText(Integer.toString(t));
        }
    }
    
     public void cambiarSalarioDescontadoPM(int t,int tipoCompania){
        if(tipoCompania == 0){
            salarioDescontadoApple.setText("$"+Integer.toString(t));
        }else{
            salarioDescontadoHP.setText("$"+Integer.toString(t));
        }
    }
    
    public void cambiarActividadDirector(String t,int tipoCompania){
        if(tipoCompania == 0){
            actividadDirectorApple.setText(t);
        }else{
            actividadDirectorHP.setText(t);
        }
    }
    
    public void cambiarPcEstandarListas(int t,int tipoCompania){
        if(tipoCompania == 0){
            pcestandarListasApple.setText(Integer.toString(t));
            estandarappleinicio.setText(Integer.toString(Global.getAlmacenApple().getpcAcumulados()));
        }else{
            pcestandarListasHP.setText(Integer.toString(t));
            estandarhpinicio.setText(Integer.toString(Global.getAlmacenHP().getpcAcumulados()));
        }
    }
    
    public void cambiarPcGraficasListas(int t,int tipoCompania){
        if(tipoCompania == 0){
            pcgraficasListasApple.setText(Integer.toString(t));
            graficasappleinicio.setText(Integer.toString(Global.getAlmacenApple().getpcConGraficaAcumulados()));
        }else{
            pcgraficasListasHP.setText(Integer.toString(t));
            graficashpinicio.setText(Integer.toString(Global.getAlmacenHP().getpcConGraficaAcumulados()));
        }
    }
    
        public void cambiarCostosOperativos(float t,int tipoCompania){
        DecimalFormat formato = new DecimalFormat("#,###.##");
        String numeroFormateado = formato.format((int)t);
        
        if(tipoCompania == 0){
            costosOperativosApple.setText("$"+numeroFormateado);
            operativosappleinicio.setText("$"+numeroFormateado);
        }else{
            costosOperativosHP.setText("$"+numeroFormateado);
            operativoshpinicio.setText("$"+numeroFormateado);
        }
    }
    
    public void cambiarGanancias(float t,int tipoCompania){
        DecimalFormat formato = new DecimalFormat("#,###.##");
        String numeroFormateado = formato.format((int)t);
        if(tipoCompania == 0){
            gananciasApple.setText("$"+numeroFormateado);
            gananciasappleinicio.setText("$"+numeroFormateado);
        }else{
            gananciasHP.setText("$"+numeroFormateado);
            gananciashpinicio.setText("$"+numeroFormateado);
        }
    }
    
    public void cambiarUtilidades(float t,int tipoCompania){
        DecimalFormat formato = new DecimalFormat("#,###.##");
        String numeroFormateado = formato.format((int)t);
        if(tipoCompania == 0){
            utilidadesApple.setText("$"+numeroFormateado);
            utilidadesappleinicio.setText("$"+numeroFormateado);
        }else{
            utilidadesHP.setText("$"+numeroFormateado);
            utilidadeshpinicio.setText("$"+numeroFormateado);
        }
    }
    
    //DATOS INICIALES HP
    public String getProdPlacaBaseHP(){
        return prodplacabaseHP.getText();
    }
    public String getProdCpuHP(){
        return prodcpuHP.getText();
    }
    public String getProdRamHP(){
        return prodramHP.getText();
    }
    public String getProdFuenteHP(){
        return prodfuenteHP.getText();
    }
    public String getProdGraficaHP(){
        return prodgraficaHP.getText();
    }
    public String getEnsambladoresCN(){
        return ensambladoresHP.getText();
    }
    
    // DATOS INICIALES APPLE
    public String getProdPlacaBaseApple(){
        return prodplacabaseApple.getText();
    }
    public String getProdCpuApple(){
        return prodcpuApple.getText();
    }
    public String getProdRamApple(){
        return prodramApple.getText();
    }
    public String getProdFuenteApple(){
        return prodfuenteApple.getText();
    }
    public String getProdGraficaApple(){
        return prodgraficaApple.getText();
    }
    public String getEnsambladoresApple(){
        return ensambladoresApple.getText();
    }
    
    //DATOS DE CONFIGURACION
    public void setDuracionDias(String duracion){
        duracionDias.setText(duracion);
    }
    
    public String getDuracionDias(){
        return duracionDias.getText();
    }
    public String getDiasEntrega(){
        return diasEntrega.getText();
    }
    
    public void setDiasEntrega(String dias){
        diasEntrega.setText(dias);
    }
    
    
    public void cambiarPlacasBaseApple(int t){
        placasbaseApple.setText(Integer.toString(t)); 
    }
    
    public void cambiarCpuApple(int t){
        cpuApple.setText(Integer.toString(t)); 
    }
    
    public void cambiarRamApple(int t){
        ramApple.setText(Integer.toString(t)); 
    }
    
    public void cambiarFuentesApple(int t){
        fuentesApple.setText(Integer.toString(t)); 
    }
    
    public void cambiarGraficasApple(int t){
        graficasApple.setText(Integer.toString(t)); 
    }
    
     public void cambiarPlacasBaseHP(int t){
        placasbaseHP.setText(Integer.toString(t)); 
    }
    
    public void cambiarCpuHP(int t){
        cpuHP.setText(Integer.toString(t)); 
    }
    
    public void cambiarRamHP(int t){
        ramHP.setText(Integer.toString(t)); 
    }
    
    public void cambiarFuentesHP(int t){
        fuentesHP.setText(Integer.toString(t)); 
    }
    
    public void cambiarGraficasHP(int t){
        graficasHP.setText(Integer.toString(t)); 
    }
    
     //Metodos que cambian la cantidad de trabajadores activos que hay 
    public void setProdPlacaBaseApple(int t){
        prodplacabaseAppleActivos.setText(Integer.toString(t)); 
    }
    
    public void setProdCPUApple(int t){
        prodcpuAppleActivos.setText(Integer.toString(t)); 
    }
    
    public void setProdRamApple(int t){
        prodramAppleActivos.setText(Integer.toString(t)); 
    }
    
    public void setProdFuenteApple(int t){
        prodfuenteAppleActivos.setText(Integer.toString(t)); 
    }
    
    public void setProdGraficaApple(int t){
        prodgraficaAppleActivos.setText(Integer.toString(t)); 
    }
    
    public void setEnsambladoresApple(int t){
        ensambladoresAppleActivos.setText(Integer.toString(t)); 
    }
    
    public void setProdPlacaBaseHP(int t){
        prodplacabaseHPActivos.setText(Integer.toString(t)); 
    }
    
    public void setProdCPUHP(int t){
        prodcpuHPActivos.setText(Integer.toString(t)); 
    }
    
    public void setProdRamHP(int t){
        prodramHPActivos.setText(Integer.toString(t)); 
    }
    
    public void setProdFuenteHP(int t){
        prodfuenteHPActivos.setText(Integer.toString(t)); 
    }
    
    public void setProdGraficaHP(int t){
        prodgraficaHPActivos.setText(Integer.toString(t)); 
    }
    
    public void setEnsambladoresHP(int t){
        ensambladoresHPActivos.setText(Integer.toString(t)); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        diasInicio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        utilidadesappleinicio = new javax.swing.JLabel();
        operativosappleinicio = new javax.swing.JLabel();
        gananciasappleinicio = new javax.swing.JLabel();
        estandarappleinicio = new javax.swing.JLabel();
        graficasappleinicio = new javax.swing.JLabel();
        utilidadeshpinicio = new javax.swing.JLabel();
        operativoshpinicio = new javax.swing.JLabel();
        gananciashpinicio = new javax.swing.JLabel();
        estandarhpinicio = new javax.swing.JLabel();
        graficashpinicio = new javax.swing.JLabel();
        diasHP1 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        prodplacabaseAppleActivos = new javax.swing.JLabel();
        prodcpuAppleActivos = new javax.swing.JLabel();
        prodramAppleActivos = new javax.swing.JLabel();
        prodfuenteAppleActivos = new javax.swing.JLabel();
        prodgraficaAppleActivos = new javax.swing.JLabel();
        ensambladoresAppleActivos = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        placasbaseApple = new javax.swing.JLabel();
        cpuApple = new javax.swing.JLabel();
        ramApple = new javax.swing.JLabel();
        fuentesApple = new javax.swing.JLabel();
        graficasApple = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        costosOperativosApple = new javax.swing.JLabel();
        utilidadesApple = new javax.swing.JLabel();
        gananciasApple = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        pmActividadApple = new javax.swing.JLabel();
        faltaspmApple = new javax.swing.JLabel();
        salarioDescontadoApple = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        actividadDirectorApple = new javax.swing.JLabel();
        pcestandarListasApple = new javax.swing.JLabel();
        pcgraficasListasApple = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        diasEntregaApple = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        diasApple = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        prodplacabaseHPActivos = new javax.swing.JLabel();
        prodcpuHPActivos = new javax.swing.JLabel();
        prodramHPActivos = new javax.swing.JLabel();
        prodfuenteHPActivos = new javax.swing.JLabel();
        prodgraficaHPActivos = new javax.swing.JLabel();
        ensambladoresHPActivos = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        placasbaseHP = new javax.swing.JLabel();
        cpuHP = new javax.swing.JLabel();
        ramHP = new javax.swing.JLabel();
        fuentesHP = new javax.swing.JLabel();
        graficasHP = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        costosOperativosHP = new javax.swing.JLabel();
        utilidadesHP = new javax.swing.JLabel();
        gananciasHP = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        pmActividadHP = new javax.swing.JLabel();
        faltaspmHP = new javax.swing.JLabel();
        salarioDescontadoHP = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        actividadDirectorHP = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        pcestandarListasHP = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        pcgraficasListasHP = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        diasEntregaHP = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        diasHP = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        prodplacabaseApple = new javax.swing.JLabel();
        prodcpuApple = new javax.swing.JLabel();
        prodramApple = new javax.swing.JLabel();
        prodfuenteApple = new javax.swing.JLabel();
        prodgraficaApple = new javax.swing.JLabel();
        ensambladoresApple = new javax.swing.JLabel();
        prodplacabaseHP = new javax.swing.JLabel();
        prodcpuHP = new javax.swing.JLabel();
        prodramHP = new javax.swing.JLabel();
        prodfuenteHP = new javax.swing.JLabel();
        prodgraficaHP = new javax.swing.JLabel();
        ensambladoresHP = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        duracionDias = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        diasEntrega = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("DEADLINE:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 50, 80, 20);

        diasInicio.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        diasInicio.setText("0");
        jPanel2.add(diasInicio);
        diasInicio.setBounds(100, 20, 90, 19);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(24, 188, 0, 0);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel4.setText("Apple");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(350, 130, 70, 26);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel5.setText("HP");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(630, 130, 40, 26);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setText("Utilidades");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(150, 180, 180, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel7.setText("Costos Operativos");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(150, 210, 180, 20);

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setText("Ganancias en bruto");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(150, 240, 170, 20);

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel9.setText("PC Estándar vendidas");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(150, 280, 170, 20);

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel10.setText("PC con Gráfica vendidas");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(150, 310, 170, 20);

        utilidadesappleinicio.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        utilidadesappleinicio.setText("0");
        jPanel2.add(utilidadesappleinicio);
        utilidadesappleinicio.setBounds(365, 171, 110, 19);

        operativosappleinicio.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        operativosappleinicio.setText("0");
        jPanel2.add(operativosappleinicio);
        operativosappleinicio.setBounds(365, 206, 130, 19);

        gananciasappleinicio.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        gananciasappleinicio.setText("0");
        jPanel2.add(gananciasappleinicio);
        gananciasappleinicio.setBounds(365, 241, 150, 19);

        estandarappleinicio.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        estandarappleinicio.setText("0");
        jPanel2.add(estandarappleinicio);
        estandarappleinicio.setBounds(365, 276, 100, 19);

        graficasappleinicio.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        graficasappleinicio.setText("0");
        jPanel2.add(graficasappleinicio);
        graficasappleinicio.setBounds(365, 311, 100, 19);

        utilidadeshpinicio.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        utilidadeshpinicio.setText("0");
        jPanel2.add(utilidadeshpinicio);
        utilidadeshpinicio.setBounds(641, 171, 120, 19);

        operativoshpinicio.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        operativoshpinicio.setText("0");
        jPanel2.add(operativoshpinicio);
        operativoshpinicio.setBounds(641, 206, 120, 19);

        gananciashpinicio.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        gananciashpinicio.setText("0");
        jPanel2.add(gananciashpinicio);
        gananciashpinicio.setBounds(641, 241, 120, 19);

        estandarhpinicio.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        estandarhpinicio.setText("0");
        jPanel2.add(estandarhpinicio);
        estandarhpinicio.setBounds(641, 276, 120, 19);

        graficashpinicio.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        graficashpinicio.setText("0");
        jPanel2.add(graficashpinicio);
        graficashpinicio.setBounds(641, 311, 120, 19);

        diasHP1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        diasHP1.setText("0");
        jPanel2.add(diasHP1);
        diasHP1.setBounds(100, 50, 70, 19);

        jLabel71.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel71.setText("DIAS:");
        jPanel2.add(jLabel71);
        jLabel71.setBounds(10, 20, 80, 20);

        jTabbedPane2.addTab("Home", jPanel2);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(25, 25, 25));
        jPanel6.setLayout(null);

        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Trabajadores Activos");
        jPanel6.add(jLabel20);
        jLabel20.setBounds(130, 10, 140, 18);

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Productores CPU");
        jPanel6.add(jLabel22);
        jLabel22.setBounds(20, 70, 200, 16);

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Productores RAM");
        jPanel6.add(jLabel23);
        jLabel23.setBounds(20, 100, 200, 16);

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Productores fuentes de energia");
        jPanel6.add(jLabel24);
        jLabel24.setBounds(20, 130, 200, 16);

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Productores tarjeta gráfica");
        jPanel6.add(jLabel25);
        jLabel25.setBounds(20, 160, 200, 16);

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Ensambladores");
        jPanel6.add(jLabel26);
        jLabel26.setBounds(20, 190, 200, 16);

        prodplacabaseAppleActivos.setForeground(new java.awt.Color(255, 255, 255));
        prodplacabaseAppleActivos.setText("0");
        jPanel6.add(prodplacabaseAppleActivos);
        prodplacabaseAppleActivos.setBounds(280, 50, 50, 16);

        prodcpuAppleActivos.setForeground(new java.awt.Color(255, 255, 255));
        prodcpuAppleActivos.setText("0");
        jPanel6.add(prodcpuAppleActivos);
        prodcpuAppleActivos.setBounds(280, 80, 50, 16);

        prodramAppleActivos.setForeground(new java.awt.Color(255, 255, 255));
        prodramAppleActivos.setText("0");
        jPanel6.add(prodramAppleActivos);
        prodramAppleActivos.setBounds(280, 110, 50, 16);

        prodfuenteAppleActivos.setForeground(new java.awt.Color(255, 255, 255));
        prodfuenteAppleActivos.setText("0");
        jPanel6.add(prodfuenteAppleActivos);
        prodfuenteAppleActivos.setBounds(280, 140, 50, 16);

        prodgraficaAppleActivos.setForeground(new java.awt.Color(255, 255, 255));
        prodgraficaAppleActivos.setText("0");
        jPanel6.add(prodgraficaAppleActivos);
        prodgraficaAppleActivos.setBounds(280, 170, 50, 16);

        ensambladoresAppleActivos.setForeground(new java.awt.Color(255, 255, 255));
        ensambladoresAppleActivos.setText("0");
        jPanel6.add(ensambladoresAppleActivos);
        ensambladoresAppleActivos.setBounds(280, 200, 50, 16);

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Productores placa base");
        jPanel6.add(jLabel28);
        jLabel28.setBounds(20, 40, 200, 16);

        jButton42.setBackground(new java.awt.Color(204, 204, 204));
        jButton42.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton42.setForeground(new java.awt.Color(0, 0, 0));
        jButton42.setText("-");
        jButton42.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton42);
        jButton42.setBounds(230, 190, 40, 25);

        jButton43.setBackground(new java.awt.Color(204, 204, 204));
        jButton43.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton43.setForeground(new java.awt.Color(0, 0, 0));
        jButton43.setText("+");
        jButton43.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton43);
        jButton43.setBounds(300, 190, 40, 25);

        jButton44.setBackground(new java.awt.Color(204, 204, 204));
        jButton44.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton44.setForeground(new java.awt.Color(0, 0, 0));
        jButton44.setText("-");
        jButton44.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton44);
        jButton44.setBounds(230, 100, 40, 25);

        jButton45.setBackground(new java.awt.Color(204, 204, 204));
        jButton45.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton45.setForeground(new java.awt.Color(0, 0, 0));
        jButton45.setText("-");
        jButton45.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton45);
        jButton45.setBounds(230, 70, 40, 25);

        jButton46.setBackground(new java.awt.Color(204, 204, 204));
        jButton46.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton46.setForeground(new java.awt.Color(0, 0, 0));
        jButton46.setText("-");
        jButton46.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton46);
        jButton46.setBounds(230, 130, 40, 25);

        jButton47.setBackground(new java.awt.Color(204, 204, 204));
        jButton47.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton47.setForeground(new java.awt.Color(0, 0, 0));
        jButton47.setText("-");
        jButton47.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton47);
        jButton47.setBounds(230, 160, 40, 25);

        jButton48.setBackground(new java.awt.Color(204, 204, 204));
        jButton48.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton48.setForeground(new java.awt.Color(0, 0, 0));
        jButton48.setText("-");
        jButton48.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton48);
        jButton48.setBounds(230, 40, 40, 25);

        jButton49.setBackground(new java.awt.Color(204, 204, 204));
        jButton49.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton49.setForeground(new java.awt.Color(0, 0, 0));
        jButton49.setText("+");
        jButton49.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton49);
        jButton49.setBounds(300, 40, 40, 25);

        jButton50.setBackground(new java.awt.Color(204, 204, 204));
        jButton50.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton50.setForeground(new java.awt.Color(0, 0, 0));
        jButton50.setText("+");
        jButton50.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton50);
        jButton50.setBounds(300, 70, 40, 25);

        jButton51.setBackground(new java.awt.Color(204, 204, 204));
        jButton51.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton51.setForeground(new java.awt.Color(0, 0, 0));
        jButton51.setText("+");
        jButton51.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton51);
        jButton51.setBounds(300, 100, 40, 25);

        jButton52.setBackground(new java.awt.Color(204, 204, 204));
        jButton52.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton52.setForeground(new java.awt.Color(0, 0, 0));
        jButton52.setText("+");
        jButton52.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton52);
        jButton52.setBounds(300, 130, 40, 25);

        jButton53.setBackground(new java.awt.Color(204, 204, 204));
        jButton53.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton53.setForeground(new java.awt.Color(0, 0, 0));
        jButton53.setText("+");
        jButton53.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton53);
        jButton53.setBounds(300, 160, 40, 25);

        jPanel4.add(jPanel6);
        jPanel6.setBounds(30, 50, 400, 280);

        jPanel7.setBackground(new java.awt.Color(25, 25, 25));
        jPanel7.setLayout(null);

        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Capacidad del Almacen");
        jPanel7.add(jLabel27);
        jLabel27.setBounds(120, 10, 260, 18);

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Placa base");
        jPanel7.add(jLabel21);
        jLabel21.setBounds(30, 40, 130, 16);

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("CPU");
        jPanel7.add(jLabel29);
        jLabel29.setBounds(30, 70, 130, 16);

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("RAM");
        jPanel7.add(jLabel30);
        jLabel30.setBounds(30, 100, 130, 16);

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Fuente");
        jPanel7.add(jLabel31);
        jLabel31.setBounds(30, 130, 130, 16);

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Tarjetas Gráficas");
        jPanel7.add(jLabel32);
        jLabel32.setBounds(30, 160, 130, 16);

        placasbaseApple.setForeground(new java.awt.Color(255, 255, 255));
        placasbaseApple.setText("0");
        jPanel7.add(placasbaseApple);
        placasbaseApple.setBounds(190, 40, 150, 16);

        cpuApple.setForeground(new java.awt.Color(255, 255, 255));
        cpuApple.setText("0");
        jPanel7.add(cpuApple);
        cpuApple.setBounds(190, 70, 150, 16);

        ramApple.setForeground(new java.awt.Color(255, 255, 255));
        ramApple.setText("0");
        jPanel7.add(ramApple);
        ramApple.setBounds(190, 100, 150, 16);

        fuentesApple.setForeground(new java.awt.Color(255, 255, 255));
        fuentesApple.setText("0");
        jPanel7.add(fuentesApple);
        fuentesApple.setBounds(190, 130, 150, 16);

        graficasApple.setForeground(new java.awt.Color(255, 255, 255));
        graficasApple.setText("0");
        jPanel7.add(graficasApple);
        graficasApple.setBounds(190, 160, 150, 16);

        jPanel4.add(jPanel7);
        jPanel7.setBounds(440, 50, 380, 280);

        jPanel8.setBackground(new java.awt.Color(25, 25, 25));
        jPanel8.setLayout(null);

        jLabel61.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Estadísticas");
        jPanel8.add(jLabel61);
        jLabel61.setBounds(90, 10, 130, 18);

        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Costos operativos");
        jPanel8.add(jLabel62);
        jLabel62.setBounds(20, 40, 150, 16);

        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Utilidades");
        jPanel8.add(jLabel64);
        jLabel64.setBounds(20, 70, 100, 16);

        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Ganancia en bruto");
        jPanel8.add(jLabel66);
        jLabel66.setBounds(20, 100, 150, 16);

        costosOperativosApple.setForeground(new java.awt.Color(255, 255, 255));
        costosOperativosApple.setText("0");
        jPanel8.add(costosOperativosApple);
        costosOperativosApple.setBounds(190, 40, 60, 16);

        utilidadesApple.setForeground(new java.awt.Color(255, 255, 255));
        utilidadesApple.setText("0");
        jPanel8.add(utilidadesApple);
        utilidadesApple.setBounds(190, 70, 60, 16);

        gananciasApple.setForeground(new java.awt.Color(255, 255, 255));
        gananciasApple.setText("0");
        jPanel8.add(gananciasApple);
        gananciasApple.setBounds(190, 100, 60, 16);

        jPanel4.add(jPanel8);
        jPanel8.setBounds(30, 340, 260, 160);

        jPanel9.setBackground(new java.awt.Color(25, 25, 25));
        jPanel9.setLayout(null);

        jLabel33.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Project Manager");
        jPanel9.add(jLabel33);
        jLabel33.setBounds(80, 10, 160, 18);

        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Actividad");
        jPanel9.add(jLabel34);
        jLabel34.setBounds(10, 40, 90, 16);

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Faltas");
        jPanel9.add(jLabel35);
        jLabel35.setBounds(10, 70, 60, 16);

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Sueldo descontado");
        jPanel9.add(jLabel36);
        jLabel36.setBounds(10, 100, 130, 16);

        pmActividadApple.setForeground(new java.awt.Color(255, 255, 255));
        pmActividadApple.setText("0");
        jPanel9.add(pmActividadApple);
        pmActividadApple.setBounds(130, 40, 110, 16);

        faltaspmApple.setForeground(new java.awt.Color(255, 255, 255));
        faltaspmApple.setText("0");
        jPanel9.add(faltaspmApple);
        faltaspmApple.setBounds(130, 70, 110, 16);

        salarioDescontadoApple.setForeground(new java.awt.Color(255, 255, 255));
        salarioDescontadoApple.setText("0");
        jPanel9.add(salarioDescontadoApple);
        salarioDescontadoApple.setBounds(130, 100, 110, 16);

        jPanel4.add(jPanel9);
        jPanel9.setBounds(300, 340, 270, 160);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(null);

        jLabel54.setText("Director");
        jPanel10.add(jLabel54);
        jLabel54.setBounds(50, 10, 49, 16);

        jPanel4.add(jPanel10);
        jPanel10.setBounds(550, 260, 0, 0);

        jPanel12.setBackground(new java.awt.Color(25, 25, 25));
        jPanel12.setLayout(null);

        jLabel56.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Director");
        jPanel12.add(jLabel56);
        jLabel56.setBounds(76, 6, 50, 18);

        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Actividad");
        jPanel12.add(jLabel57);
        jLabel57.setBounds(10, 40, 90, 16);

        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("PC Estandar listas");
        jPanel12.add(jLabel58);
        jLabel58.setBounds(10, 70, 150, 16);

        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("PC Tarjeta Grafica listas");
        jPanel12.add(jLabel59);
        jLabel59.setBounds(10, 100, 140, 16);

        actividadDirectorApple.setForeground(new java.awt.Color(255, 255, 255));
        actividadDirectorApple.setText("0");
        jPanel12.add(actividadDirectorApple);
        actividadDirectorApple.setBounds(120, 40, 100, 16);

        pcestandarListasApple.setForeground(new java.awt.Color(255, 255, 255));
        pcestandarListasApple.setText("0");
        jPanel12.add(pcestandarListasApple);
        pcestandarListasApple.setBounds(170, 70, 60, 16);

        pcgraficasListasApple.setForeground(new java.awt.Color(255, 255, 255));
        pcgraficasListasApple.setText("0");
        jPanel12.add(pcgraficasListasApple);
        pcgraficasListasApple.setBounds(170, 100, 60, 16);

        jPanel4.add(jPanel12);
        jPanel12.setBounds(580, 340, 240, 160);

        jPanel16.setBackground(new java.awt.Color(25, 25, 25));
        jPanel16.setLayout(null);

        jLabel72.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Dias para entrega");
        jPanel16.add(jLabel72);
        jLabel72.setBounds(10, 10, 130, 18);

        diasEntregaApple.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        diasEntregaApple.setForeground(new java.awt.Color(255, 255, 255));
        diasEntregaApple.setText("0");
        jPanel16.add(diasEntregaApple);
        diasEntregaApple.setBounds(60, 30, 70, 19);

        jLabel74.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Dias");
        jPanel16.add(jLabel74);
        jLabel74.setBounds(50, 70, 49, 18);

        diasApple.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        diasApple.setForeground(new java.awt.Color(255, 255, 255));
        diasApple.setText("0");
        jPanel16.add(diasApple);
        diasApple.setBounds(60, 100, 70, 19);

        jPanel4.add(jPanel16);
        jPanel16.setBounds(830, 340, 140, 160);

        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Apple-Logo.png"))); // NOI18N
        jLabel73.setText("jLabel73");
        jPanel4.add(jLabel73);
        jLabel73.setBounds(850, 0, 120, 110);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/SteveJobs.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(820, 140, 200, 380);

        jTabbedPane2.addTab("Apple", jPanel4);

        jPanel5.setBackground(new java.awt.Color(5, 20, 43));
        jPanel5.setLayout(null);

        jPanel17.setBackground(new java.awt.Color(5, 3, 30));
        jPanel17.setLayout(null);

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Trabajadores Activos");
        jPanel17.add(jLabel37);
        jLabel37.setBounds(140, 10, 150, 18);

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Productores placa base");
        jPanel17.add(jLabel38);
        jLabel38.setBounds(20, 50, 190, 16);

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Productores CPU");
        jPanel17.add(jLabel39);
        jLabel39.setBounds(20, 80, 190, 16);

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Productores RAM");
        jPanel17.add(jLabel40);
        jLabel40.setBounds(20, 110, 190, 16);

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Productores fuentes de energía");
        jPanel17.add(jLabel41);
        jLabel41.setBounds(20, 140, 190, 16);

        jLabel42.setBackground(new java.awt.Color(255, 255, 255));
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Productores tarjetas gráficas");
        jPanel17.add(jLabel42);
        jLabel42.setBounds(20, 170, 190, 16);

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Ensambladores");
        jPanel17.add(jLabel43);
        jLabel43.setBounds(20, 200, 190, 16);

        prodplacabaseHPActivos.setBackground(new java.awt.Color(255, 255, 255));
        prodplacabaseHPActivos.setForeground(new java.awt.Color(255, 255, 255));
        prodplacabaseHPActivos.setText("0");
        jPanel17.add(prodplacabaseHPActivos);
        prodplacabaseHPActivos.setBounds(280, 60, 40, 16);

        prodcpuHPActivos.setBackground(new java.awt.Color(255, 255, 255));
        prodcpuHPActivos.setForeground(new java.awt.Color(255, 255, 255));
        prodcpuHPActivos.setText("0");
        jPanel17.add(prodcpuHPActivos);
        prodcpuHPActivos.setBounds(280, 90, 40, 16);

        prodramHPActivos.setBackground(new java.awt.Color(255, 255, 255));
        prodramHPActivos.setForeground(new java.awt.Color(255, 255, 255));
        prodramHPActivos.setText("0");
        jPanel17.add(prodramHPActivos);
        prodramHPActivos.setBounds(280, 120, 40, 16);

        prodfuenteHPActivos.setBackground(new java.awt.Color(255, 255, 255));
        prodfuenteHPActivos.setForeground(new java.awt.Color(255, 255, 255));
        prodfuenteHPActivos.setText("0");
        jPanel17.add(prodfuenteHPActivos);
        prodfuenteHPActivos.setBounds(280, 150, 40, 16);

        prodgraficaHPActivos.setBackground(new java.awt.Color(255, 255, 255));
        prodgraficaHPActivos.setForeground(new java.awt.Color(255, 255, 255));
        prodgraficaHPActivos.setText("0");
        jPanel17.add(prodgraficaHPActivos);
        prodgraficaHPActivos.setBounds(280, 180, 40, 16);

        ensambladoresHPActivos.setBackground(new java.awt.Color(255, 255, 255));
        ensambladoresHPActivos.setForeground(new java.awt.Color(255, 255, 255));
        ensambladoresHPActivos.setText("0");
        jPanel17.add(ensambladoresHPActivos);
        ensambladoresHPActivos.setBounds(280, 210, 40, 16);

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 0, 0));
        jButton8.setText("-");
        jButton8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton8);
        jButton8.setBounds(230, 50, 40, 25);

        jButton31.setBackground(new java.awt.Color(204, 204, 204));
        jButton31.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton31.setForeground(new java.awt.Color(0, 0, 0));
        jButton31.setText("+");
        jButton31.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton31);
        jButton31.setBounds(300, 50, 40, 25);

        jButton32.setBackground(new java.awt.Color(204, 204, 204));
        jButton32.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton32.setForeground(new java.awt.Color(0, 0, 0));
        jButton32.setText("+");
        jButton32.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton32);
        jButton32.setBounds(300, 80, 40, 25);

        jButton33.setBackground(new java.awt.Color(204, 204, 204));
        jButton33.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton33.setForeground(new java.awt.Color(0, 0, 0));
        jButton33.setText("+");
        jButton33.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton33);
        jButton33.setBounds(300, 110, 40, 25);

        jButton34.setBackground(new java.awt.Color(204, 204, 204));
        jButton34.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton34.setForeground(new java.awt.Color(0, 0, 0));
        jButton34.setText("+");
        jButton34.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton34);
        jButton34.setBounds(300, 140, 40, 25);

        jButton35.setBackground(new java.awt.Color(204, 204, 204));
        jButton35.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton35.setForeground(new java.awt.Color(0, 0, 0));
        jButton35.setText("+");
        jButton35.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton35);
        jButton35.setBounds(300, 170, 40, 25);

        jButton36.setBackground(new java.awt.Color(204, 204, 204));
        jButton36.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton36.setForeground(new java.awt.Color(0, 0, 0));
        jButton36.setText("+");
        jButton36.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton36);
        jButton36.setBounds(300, 200, 40, 25);

        jButton37.setBackground(new java.awt.Color(204, 204, 204));
        jButton37.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton37.setForeground(new java.awt.Color(0, 0, 0));
        jButton37.setText("-");
        jButton37.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton37);
        jButton37.setBounds(230, 200, 40, 25);

        jButton38.setBackground(new java.awt.Color(204, 204, 204));
        jButton38.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton38.setForeground(new java.awt.Color(0, 0, 0));
        jButton38.setText("-");
        jButton38.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton38);
        jButton38.setBounds(230, 170, 40, 25);

        jButton39.setBackground(new java.awt.Color(204, 204, 204));
        jButton39.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton39.setForeground(new java.awt.Color(0, 0, 0));
        jButton39.setText("-");
        jButton39.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton39);
        jButton39.setBounds(230, 140, 40, 25);

        jButton40.setBackground(new java.awt.Color(204, 204, 204));
        jButton40.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton40.setForeground(new java.awt.Color(0, 0, 0));
        jButton40.setText("-");
        jButton40.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton40);
        jButton40.setBounds(230, 110, 40, 25);

        jButton41.setBackground(new java.awt.Color(204, 204, 204));
        jButton41.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton41.setForeground(new java.awt.Color(0, 0, 0));
        jButton41.setText("-");
        jButton41.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton41);
        jButton41.setBounds(230, 80, 40, 25);

        jPanel5.add(jPanel17);
        jPanel17.setBounds(30, 50, 390, 270);

        jPanel11.setBackground(new java.awt.Color(5, 3, 30));
        jPanel11.setLayout(null);

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Capacidad del Almacen");
        jPanel11.add(jLabel44);
        jLabel44.setBounds(110, 10, 250, 18);

        jLabel45.setBackground(new java.awt.Color(255, 255, 255));
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Placas base");
        jPanel11.add(jLabel45);
        jLabel45.setBounds(20, 50, 130, 16);

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("CPU");
        jPanel11.add(jLabel46);
        jLabel46.setBounds(20, 80, 70, 16);

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("RAM");
        jPanel11.add(jLabel47);
        jLabel47.setBounds(20, 110, 70, 16);

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Fuentes de energía");
        jPanel11.add(jLabel48);
        jLabel48.setBounds(20, 140, 150, 16);

        jLabel49.setBackground(new java.awt.Color(255, 255, 255));
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Tarjetas gráficas");
        jPanel11.add(jLabel49);
        jLabel49.setBounds(20, 170, 140, 16);

        placasbaseHP.setBackground(new java.awt.Color(255, 255, 255));
        placasbaseHP.setForeground(new java.awt.Color(255, 255, 255));
        placasbaseHP.setText("0");
        jPanel11.add(placasbaseHP);
        placasbaseHP.setBounds(230, 50, 110, 16);

        cpuHP.setBackground(new java.awt.Color(255, 255, 255));
        cpuHP.setForeground(new java.awt.Color(255, 255, 255));
        cpuHP.setText("0");
        jPanel11.add(cpuHP);
        cpuHP.setBounds(230, 80, 110, 16);

        ramHP.setBackground(new java.awt.Color(255, 255, 255));
        ramHP.setForeground(new java.awt.Color(255, 255, 255));
        ramHP.setText("0");
        jPanel11.add(ramHP);
        ramHP.setBounds(230, 110, 110, 16);

        fuentesHP.setBackground(new java.awt.Color(255, 255, 255));
        fuentesHP.setForeground(new java.awt.Color(255, 255, 255));
        fuentesHP.setText("0");
        jPanel11.add(fuentesHP);
        fuentesHP.setBounds(230, 140, 110, 16);

        graficasHP.setBackground(new java.awt.Color(255, 255, 255));
        graficasHP.setForeground(new java.awt.Color(255, 255, 255));
        graficasHP.setText("0");
        jPanel11.add(graficasHP);
        graficasHP.setBounds(230, 170, 110, 16);

        jPanel5.add(jPanel11);
        jPanel11.setBounds(430, 50, 370, 270);

        jPanel13.setBackground(new java.awt.Color(5, 3, 30));
        jPanel13.setLayout(null);

        jLabel76.setBackground(new java.awt.Color(255, 255, 255));
        jLabel76.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Estadísticas");
        jPanel13.add(jLabel76);
        jLabel76.setBounds(90, 10, 150, 18);

        jLabel77.setBackground(new java.awt.Color(255, 255, 255));
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Costos operativos");
        jPanel13.add(jLabel77);
        jLabel77.setBounds(20, 40, 120, 16);

        jLabel78.setBackground(new java.awt.Color(255, 255, 255));
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("Utilidades");
        jPanel13.add(jLabel78);
        jLabel78.setBounds(20, 70, 130, 16);

        jLabel79.setBackground(new java.awt.Color(255, 255, 255));
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Ganancia en bruto");
        jPanel13.add(jLabel79);
        jLabel79.setBounds(20, 100, 120, 16);

        costosOperativosHP.setBackground(new java.awt.Color(255, 255, 255));
        costosOperativosHP.setForeground(new java.awt.Color(255, 255, 255));
        costosOperativosHP.setText("0");
        jPanel13.add(costosOperativosHP);
        costosOperativosHP.setBounds(160, 40, 100, 16);

        utilidadesHP.setBackground(new java.awt.Color(255, 255, 255));
        utilidadesHP.setForeground(new java.awt.Color(255, 255, 255));
        utilidadesHP.setText("0");
        jPanel13.add(utilidadesHP);
        utilidadesHP.setBounds(160, 70, 100, 16);

        gananciasHP.setBackground(new java.awt.Color(255, 255, 255));
        gananciasHP.setForeground(new java.awt.Color(255, 255, 255));
        gananciasHP.setText("0");
        jPanel13.add(gananciasHP);
        gananciasHP.setBounds(160, 100, 100, 16);

        jPanel5.add(jPanel13);
        jPanel13.setBounds(30, 340, 270, 160);

        jPanel14.setBackground(new java.awt.Color(5, 3, 30));
        jPanel14.setLayout(null);

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Project Manager");
        jPanel14.add(jLabel50);
        jLabel50.setBounds(70, 10, 160, 18);

        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Actividad");
        jPanel14.add(jLabel51);
        jLabel51.setBounds(10, 50, 80, 16);

        jLabel52.setBackground(new java.awt.Color(255, 255, 255));
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Faltas");
        jPanel14.add(jLabel52);
        jLabel52.setBounds(10, 80, 80, 16);

        jLabel53.setBackground(new java.awt.Color(255, 255, 255));
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Sueldo descontado");
        jPanel14.add(jLabel53);
        jLabel53.setBounds(10, 110, 120, 16);

        pmActividadHP.setBackground(new java.awt.Color(255, 255, 255));
        pmActividadHP.setForeground(new java.awt.Color(255, 255, 255));
        pmActividadHP.setText("0");
        jPanel14.add(pmActividadHP);
        pmActividadHP.setBounds(100, 50, 130, 16);

        faltaspmHP.setBackground(new java.awt.Color(255, 255, 255));
        faltaspmHP.setForeground(new java.awt.Color(255, 255, 255));
        faltaspmHP.setText("0");
        jPanel14.add(faltaspmHP);
        faltaspmHP.setBounds(100, 80, 130, 16);

        salarioDescontadoHP.setBackground(new java.awt.Color(255, 255, 255));
        salarioDescontadoHP.setForeground(new java.awt.Color(255, 255, 255));
        salarioDescontadoHP.setText("0");
        jPanel14.add(salarioDescontadoHP);
        salarioDescontadoHP.setBounds(140, 110, 90, 16);

        jPanel5.add(jPanel14);
        jPanel14.setBounds(310, 340, 240, 160);

        jPanel15.setBackground(new java.awt.Color(5, 3, 30));
        jPanel15.setLayout(null);

        jLabel55.setBackground(new java.awt.Color(255, 255, 255));
        jLabel55.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Director");
        jPanel15.add(jLabel55);
        jLabel55.setBounds(80, 10, 100, 18);

        jLabel63.setBackground(new java.awt.Color(255, 255, 255));
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Actividad");
        jPanel15.add(jLabel63);
        jLabel63.setBounds(10, 40, 90, 16);

        actividadDirectorHP.setBackground(new java.awt.Color(255, 255, 255));
        actividadDirectorHP.setForeground(new java.awt.Color(255, 255, 255));
        actividadDirectorHP.setText("0");
        jPanel15.add(actividadDirectorHP);
        actividadDirectorHP.setBounds(110, 40, 120, 16);

        jLabel65.setBackground(new java.awt.Color(255, 255, 255));
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("PC Estandar listas");
        jPanel15.add(jLabel65);
        jLabel65.setBounds(10, 70, 120, 16);

        pcestandarListasHP.setBackground(new java.awt.Color(255, 255, 255));
        pcestandarListasHP.setForeground(new java.awt.Color(255, 255, 255));
        pcestandarListasHP.setText("0");
        jPanel15.add(pcestandarListasHP);
        pcestandarListasHP.setBounds(150, 70, 80, 16);

        jLabel67.setBackground(new java.awt.Color(255, 255, 255));
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("PC Tarjeta Grafica listas");
        jPanel15.add(jLabel67);
        jLabel67.setBounds(10, 100, 140, 16);

        pcgraficasListasHP.setBackground(new java.awt.Color(255, 255, 255));
        pcgraficasListasHP.setForeground(new java.awt.Color(255, 255, 255));
        pcgraficasListasHP.setText("0");
        jPanel15.add(pcgraficasListasHP);
        pcgraficasListasHP.setBounds(150, 100, 80, 16);

        jPanel5.add(jPanel15);
        jPanel15.setBounds(560, 340, 240, 160);

        jPanel1.setBackground(new java.awt.Color(5, 3, 30));
        jPanel1.setLayout(null);

        jLabel68.setBackground(new java.awt.Color(255, 255, 255));
        jLabel68.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Días para entrega");
        jPanel1.add(jLabel68);
        jLabel68.setBounds(30, 10, 128, 25);

        diasEntregaHP.setBackground(new java.awt.Color(255, 255, 255));
        diasEntregaHP.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        diasEntregaHP.setForeground(new java.awt.Color(255, 255, 255));
        diasEntregaHP.setText("0");
        jPanel1.add(diasEntregaHP);
        diasEntregaHP.setBounds(80, 40, 70, 19);

        jLabel70.setBackground(new java.awt.Color(255, 255, 255));
        jLabel70.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Dias");
        jPanel1.add(jLabel70);
        jLabel70.setBounds(70, 90, 49, 18);

        diasHP.setBackground(new java.awt.Color(255, 255, 255));
        diasHP.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        diasHP.setForeground(new java.awt.Color(255, 255, 255));
        diasHP.setText("0");
        jPanel1.add(diasHP);
        diasHP.setBounds(80, 120, 70, 19);

        jPanel5.add(jPanel1);
        jPanel1.setBounds(810, 340, 170, 160);

        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/hp-logo.png"))); // NOI18N
        jLabel75.setText("jLabel75");
        jPanel5.add(jLabel75);
        jLabel75.setBounds(840, 10, 120, 120);

        jTabbedPane2.addTab("HP", jPanel5);

        jPanel3.setLayout(null);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Configuración Inicial");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(360, 10, 250, 30);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Productors placa base");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(32, 152, 180, 20);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Productores CPU");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(30, 190, 140, 20);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Productores RAM");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(32, 222, 140, 20);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Productores fuentes de energía");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(32, 257, 210, 20);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Productores tarjeta gráfica");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(32, 292, 200, 20);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Ensambladores");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(32, 327, 150, 20);

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Apple");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(340, 90, 70, 30);

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("HP");
        jPanel3.add(jLabel19);
        jLabel19.setBounds(670, 90, 60, 25);

        prodplacabaseApple.setBackground(new java.awt.Color(255, 255, 255));
        prodplacabaseApple.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        prodplacabaseApple.setForeground(new java.awt.Color(255, 255, 255));
        prodplacabaseApple.setText("1");
        jPanel3.add(prodplacabaseApple);
        prodplacabaseApple.setBounds(360, 160, 50, 19);

        prodcpuApple.setBackground(new java.awt.Color(255, 255, 255));
        prodcpuApple.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        prodcpuApple.setForeground(new java.awt.Color(255, 255, 255));
        prodcpuApple.setText("1");
        jPanel3.add(prodcpuApple);
        prodcpuApple.setBounds(360, 200, 50, 19);

        prodramApple.setBackground(new java.awt.Color(255, 255, 255));
        prodramApple.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        prodramApple.setForeground(new java.awt.Color(255, 255, 255));
        prodramApple.setText("1");
        jPanel3.add(prodramApple);
        prodramApple.setBounds(360, 230, 50, 19);

        prodfuenteApple.setBackground(new java.awt.Color(255, 255, 255));
        prodfuenteApple.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        prodfuenteApple.setForeground(new java.awt.Color(255, 255, 255));
        prodfuenteApple.setText("1");
        jPanel3.add(prodfuenteApple);
        prodfuenteApple.setBounds(360, 260, 50, 19);

        prodgraficaApple.setBackground(new java.awt.Color(255, 255, 255));
        prodgraficaApple.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        prodgraficaApple.setForeground(new java.awt.Color(255, 255, 255));
        prodgraficaApple.setText("1");
        jPanel3.add(prodgraficaApple);
        prodgraficaApple.setBounds(360, 300, 50, 19);

        ensambladoresApple.setBackground(new java.awt.Color(255, 255, 255));
        ensambladoresApple.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        ensambladoresApple.setForeground(new java.awt.Color(255, 255, 255));
        ensambladoresApple.setText("1");
        jPanel3.add(ensambladoresApple);
        ensambladoresApple.setBounds(360, 330, 50, 19);

        prodplacabaseHP.setBackground(new java.awt.Color(255, 255, 255));
        prodplacabaseHP.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        prodplacabaseHP.setForeground(new java.awt.Color(255, 255, 255));
        prodplacabaseHP.setText("1");
        jPanel3.add(prodplacabaseHP);
        prodplacabaseHP.setBounds(680, 160, 40, 19);

        prodcpuHP.setBackground(new java.awt.Color(255, 255, 255));
        prodcpuHP.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        prodcpuHP.setForeground(new java.awt.Color(255, 255, 255));
        prodcpuHP.setText("1");
        jPanel3.add(prodcpuHP);
        prodcpuHP.setBounds(680, 200, 49, 19);

        prodramHP.setBackground(new java.awt.Color(255, 255, 255));
        prodramHP.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        prodramHP.setForeground(new java.awt.Color(255, 255, 255));
        prodramHP.setText("1");
        jPanel3.add(prodramHP);
        prodramHP.setBounds(680, 230, 40, 19);

        prodfuenteHP.setBackground(new java.awt.Color(255, 255, 255));
        prodfuenteHP.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        prodfuenteHP.setForeground(new java.awt.Color(255, 255, 255));
        prodfuenteHP.setText("1");
        jPanel3.add(prodfuenteHP);
        prodfuenteHP.setBounds(680, 260, 40, 19);

        prodgraficaHP.setBackground(new java.awt.Color(255, 255, 255));
        prodgraficaHP.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        prodgraficaHP.setForeground(new java.awt.Color(255, 255, 255));
        prodgraficaHP.setText("1");
        jPanel3.add(prodgraficaHP);
        prodgraficaHP.setBounds(680, 300, 30, 19);

        ensambladoresHP.setBackground(new java.awt.Color(255, 255, 255));
        ensambladoresHP.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        ensambladoresHP.setForeground(new java.awt.Color(255, 255, 255));
        ensambladoresHP.setText("1");
        jPanel3.add(ensambladoresHP);
        ensambladoresHP.setBounds(680, 330, 60, 19);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("+");
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(390, 320, 40, 25);

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("+");
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(710, 320, 40, 25);

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("+");
        jButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(390, 190, 40, 25);

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("+");
        jButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(390, 220, 40, 25);

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("+");
        jButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);
        jButton5.setBounds(390, 250, 40, 25);

        jButton6.setBackground(new java.awt.Color(204, 204, 204));
        jButton6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setText("+");
        jButton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);
        jButton6.setBounds(390, 290, 40, 25);

        jButton7.setBackground(new java.awt.Color(204, 204, 204));
        jButton7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 0));
        jButton7.setText("-");
        jButton7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7);
        jButton7.setBounds(430, 410, 40, 25);

        jButton9.setBackground(new java.awt.Color(204, 204, 204));
        jButton9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 0, 0));
        jButton9.setText("-");
        jButton9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9);
        jButton9.setBounds(610, 320, 40, 25);

        jButton10.setBackground(new java.awt.Color(204, 204, 204));
        jButton10.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 0, 0));
        jButton10.setText("+");
        jButton10.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10);
        jButton10.setBounds(710, 190, 40, 25);

        jButton11.setBackground(new java.awt.Color(204, 204, 204));
        jButton11.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(0, 0, 0));
        jButton11.setText("+");
        jButton11.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11);
        jButton11.setBounds(710, 220, 40, 25);

        jButton12.setBackground(new java.awt.Color(204, 204, 204));
        jButton12.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 0, 0));
        jButton12.setText("+");
        jButton12.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton12);
        jButton12.setBounds(710, 250, 40, 25);

        jButton13.setBackground(new java.awt.Color(204, 204, 204));
        jButton13.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(0, 0, 0));
        jButton13.setText("+");
        jButton13.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton13);
        jButton13.setBounds(710, 290, 40, 25);

        jLabel60.setBackground(new java.awt.Color(255, 255, 255));
        jLabel60.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Duración de días en segundos");
        jPanel3.add(jLabel60);
        jLabel60.setBounds(20, 380, 250, 20);

        duracionDias.setBackground(new java.awt.Color(255, 255, 255));
        duracionDias.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        duracionDias.setForeground(new java.awt.Color(255, 255, 255));
        duracionDias.setText("0");
        jPanel3.add(duracionDias);
        duracionDias.setBounds(100, 420, 40, 19);

        jButton14.setBackground(new java.awt.Color(204, 204, 204));
        jButton14.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(0, 0, 0));
        jButton14.setText("+");
        jButton14.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton14);
        jButton14.setBounds(390, 150, 40, 25);

        jButton15.setBackground(new java.awt.Color(204, 204, 204));
        jButton15.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(0, 0, 0));
        jButton15.setText("+");
        jButton15.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton15);
        jButton15.setBounds(540, 410, 40, 25);

        jLabel69.setBackground(new java.awt.Color(255, 255, 255));
        jLabel69.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Días para la entrega");
        jPanel3.add(jLabel69);
        jLabel69.setBounds(440, 380, 180, 20);

        diasEntrega.setBackground(new java.awt.Color(255, 255, 255));
        diasEntrega.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        diasEntrega.setForeground(new java.awt.Color(255, 255, 255));
        diasEntrega.setText("0");
        jPanel3.add(diasEntrega);
        diasEntrega.setBounds(500, 420, 40, 19);

        jButton16.setBackground(new java.awt.Color(204, 204, 204));
        jButton16.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton16.setForeground(new java.awt.Color(0, 0, 0));
        jButton16.setText("-");
        jButton16.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton16);
        jButton16.setBounds(300, 320, 40, 25);

        jButton17.setBackground(new java.awt.Color(204, 204, 204));
        jButton17.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton17.setForeground(new java.awt.Color(0, 0, 0));
        jButton17.setText("+");
        jButton17.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton17);
        jButton17.setBounds(130, 410, 40, 25);

        jButton18.setBackground(new java.awt.Color(204, 204, 204));
        jButton18.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton18.setForeground(new java.awt.Color(0, 0, 0));
        jButton18.setText("-");
        jButton18.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton18);
        jButton18.setBounds(40, 410, 40, 25);

        jButton19.setBackground(new java.awt.Color(204, 204, 204));
        jButton19.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton19.setForeground(new java.awt.Color(0, 0, 0));
        jButton19.setText("-");
        jButton19.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton19);
        jButton19.setBounds(300, 150, 40, 25);

        jButton20.setBackground(new java.awt.Color(204, 204, 204));
        jButton20.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton20.setForeground(new java.awt.Color(0, 0, 0));
        jButton20.setText("-");
        jButton20.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton20);
        jButton20.setBounds(300, 190, 40, 25);

        jButton21.setBackground(new java.awt.Color(204, 204, 204));
        jButton21.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton21.setForeground(new java.awt.Color(0, 0, 0));
        jButton21.setText("-");
        jButton21.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton21);
        jButton21.setBounds(300, 220, 40, 25);

        jButton22.setBackground(new java.awt.Color(204, 204, 204));
        jButton22.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(0, 0, 0));
        jButton22.setText("-");
        jButton22.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton22);
        jButton22.setBounds(300, 250, 40, 25);

        jButton23.setBackground(new java.awt.Color(204, 204, 204));
        jButton23.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton23.setForeground(new java.awt.Color(0, 0, 0));
        jButton23.setText("-");
        jButton23.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton23);
        jButton23.setBounds(300, 290, 40, 25);

        jButton24.setBackground(new java.awt.Color(204, 204, 204));
        jButton24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton24.setForeground(new java.awt.Color(0, 0, 0));
        jButton24.setText("GUARDAR");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton24);
        jButton24.setBounds(820, 450, 110, 40);

        jButton25.setBackground(new java.awt.Color(204, 204, 204));
        jButton25.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton25.setForeground(new java.awt.Color(0, 0, 0));
        jButton25.setText("+");
        jButton25.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton25);
        jButton25.setBounds(710, 150, 40, 25);

        jButton26.setBackground(new java.awt.Color(204, 204, 204));
        jButton26.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton26.setForeground(new java.awt.Color(0, 0, 0));
        jButton26.setText("-");
        jButton26.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton26);
        jButton26.setBounds(610, 150, 40, 25);

        jButton27.setBackground(new java.awt.Color(204, 204, 204));
        jButton27.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton27.setForeground(new java.awt.Color(0, 0, 0));
        jButton27.setText("-");
        jButton27.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton27);
        jButton27.setBounds(610, 190, 40, 25);

        jButton28.setBackground(new java.awt.Color(204, 204, 204));
        jButton28.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton28.setForeground(new java.awt.Color(0, 0, 0));
        jButton28.setText("-");
        jButton28.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton28);
        jButton28.setBounds(610, 220, 40, 25);

        jButton29.setBackground(new java.awt.Color(204, 204, 204));
        jButton29.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton29.setForeground(new java.awt.Color(0, 0, 0));
        jButton29.setText("-");
        jButton29.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton29);
        jButton29.setBounds(610, 250, 40, 25);

        jButton30.setBackground(new java.awt.Color(204, 204, 204));
        jButton30.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton30.setForeground(new java.awt.Color(0, 0, 0));
        jButton30.setText("-");
        jButton30.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton30);
        jButton30.setBounds(610, 290, 40, 25);

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Config.png"))); // NOI18N
        jLabel81.setText("jLabel81");
        jPanel3.add(jLabel81);
        jLabel81.setBounds(0, 0, 1000, 520);

        jTabbedPane2.addTab("Config", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if(Integer.parseInt(diasEntrega.getText()) > 1){
            diasEntrega.setText(Integer.toString(Integer.parseInt(diasEntrega.getText()) - 1));
        }else{
            JOptionPane.showMessageDialog(null, "La duracion de dias no puede ser 0");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
         if(Integer.parseInt(ensambladoresApple.getText()) > 1){
            ensambladoresApple.setText(Integer.toString(Integer.parseInt(ensambladoresApple.getText())-1));
        }else{
            JOptionPane.showMessageDialog(null, "Tienes que tener al menos 1 trabajador de cada tipo");
        } 
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        if(Integer.parseInt(duracionDias.getText()) > 1){
            duracionDias.setText(Integer.toString(Integer.parseInt(duracionDias.getText()) - 1));
        }else{
            JOptionPane.showMessageDialog(null, "La duracion de dias no puede ser 0");
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
         if(Integer.parseInt(prodplacabaseApple.getText()) > 1){
            prodplacabaseApple.setText(Integer.toString(Integer.parseInt(prodplacabaseApple.getText())-1));
        }else{
            JOptionPane.showMessageDialog(null, "Tienes que tener al menos 1 trabajador de cada tipo");
        } 
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
         if(Integer.parseInt(prodcpuApple.getText()) > 1){
            prodcpuApple.setText(Integer.toString(Integer.parseInt(prodcpuApple.getText())-1));
        }else{
            JOptionPane.showMessageDialog(null, "Tienes que tener al menos 1 trabajador de cada tipo");
        } 
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
         if(Integer.parseInt(prodramApple.getText()) > 1){
            prodramApple.setText(Integer.toString(Integer.parseInt(prodramApple.getText())-1));
        }else{
            JOptionPane.showMessageDialog(null, "Tienes que tener al menos 1 trabajador de cada tipo");
        } 
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
         if(Integer.parseInt(prodfuenteApple.getText()) > 1){
            prodfuenteApple.setText(Integer.toString(Integer.parseInt(prodfuenteApple.getText())-1));
        }else{
            JOptionPane.showMessageDialog(null, "Tienes que tener al menos 1 trabajador de cada tipo");
        } 
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
         if(Integer.parseInt(prodgraficaApple.getText()) > 1){
            prodgraficaApple.setText(Integer.toString(Integer.parseInt(prodgraficaApple.getText())-1));
        }else{
            JOptionPane.showMessageDialog(null, "Tienes que tener al menos 1 trabajador de cada tipo");
        } 
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if(Integer.parseInt(ensambladoresHP.getText()) > 1){
            ensambladoresHP.setText(Integer.toString(Integer.parseInt(ensambladoresHP.getText())-1));
        }else{
            JOptionPane.showMessageDialog(null, "Tienes que tener al menos 1 trabajador de cada tipo");
        } 
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        if(Integer.parseInt(prodplacabaseHP.getText()) > 1){
            prodplacabaseHP.setText(Integer.toString(Integer.parseInt(prodplacabaseHP.getText())-1));
        }else{
            JOptionPane.showMessageDialog(null, "Tienes que tener al menos 1 trabajador de cada tipo");
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        if(Integer.parseInt(prodcpuHP.getText()) > 1){
            prodcpuHP.setText(Integer.toString(Integer.parseInt(prodcpuHP.getText())-1));
        }else{
            JOptionPane.showMessageDialog(null, "Tienes que tener al menos 1 trabajador de cada tipo");
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        if(Integer.parseInt(prodramHP.getText()) > 1){
            prodramHP.setText(Integer.toString(Integer.parseInt(prodramHP.getText())-1));
        }else{
            JOptionPane.showMessageDialog(null, "Tienes que tener al menos 1 trabajador de cada tipo");
        }
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        if(Integer.parseInt(prodfuenteHP.getText()) > 1){
            prodfuenteHP.setText(Integer.toString(Integer.parseInt(prodfuenteHP.getText())-1));
        }else{
            JOptionPane.showMessageDialog(null, "Tienes que tener al menos 1 trabajador de cada tipo");
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        if(Integer.parseInt(prodgraficaHP.getText()) > 1){
            prodgraficaHP.setText(Integer.toString(Integer.parseInt(prodgraficaHP.getText())-1));
        }else{
            JOptionPane.showMessageDialog(null, "Tienes que tener al menos 1 trabajador de cada tipo");
        }
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorHPEnDatosIniciales() == true){
            prodplacabaseHP.setText(Integer.toString(Integer.parseInt(prodplacabaseHP.getText())+1));
        }else{
            JOptionPane.showMessageDialog(null, "El maximo de trabajadores para HP es 15");
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorHPEnDatosIniciales() == true){
            prodcpuHP.setText(Integer.toString(Integer.parseInt(prodcpuHP.getText())+1));
        }else{
            JOptionPane.showMessageDialog(null, "El maximo de trabajadores para HP es 15");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorHPEnDatosIniciales() == true){
            prodramHP.setText(Integer.toString(Integer.parseInt(prodramHP.getText())+1));
        }else{
            JOptionPane.showMessageDialog(null, "El maximo de trabajadores para HP es 15");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorHPEnDatosIniciales() == true){
            prodfuenteHP.setText(Integer.toString(Integer.parseInt(prodfuenteHP.getText())+1));
        }else{
            JOptionPane.showMessageDialog(null, "El maximo de trabajadores para HP es 15");
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorHPEnDatosIniciales() == true){
            prodgraficaHP.setText(Integer.toString(Integer.parseInt(prodgraficaHP.getText())+1));
        }else{
            JOptionPane.showMessageDialog(null, "El maximo de trabajadores para HP es 15");
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorHPEnDatosIniciales() == true){
            ensambladoresHP.setText(Integer.toString(Integer.parseInt(ensambladoresHP.getText())+1));
        }else{
            JOptionPane.showMessageDialog(null, "El maximo de trabajadores para HP es 15");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
         if(this.permisoDeAumentoDeTrabajadorAppleEnDatosIniciales() == true){
            prodplacabaseApple.setText(Integer.toString(Integer.parseInt(prodplacabaseApple.getText())+1));
        }else{
            JOptionPane.showMessageDialog(null, "El maximo de trabajadores para Apple es 18");
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
          if(this.permisoDeAumentoDeTrabajadorAppleEnDatosIniciales() == true){
            prodcpuApple.setText(Integer.toString(Integer.parseInt(prodcpuApple.getText())+1));
        }else{
            JOptionPane.showMessageDialog(null, "El maximo de trabajadores para Apple es 18");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
          if(this.permisoDeAumentoDeTrabajadorAppleEnDatosIniciales() == true){
            prodramApple.setText(Integer.toString(Integer.parseInt(prodramApple.getText())+1));
        }else{
            JOptionPane.showMessageDialog(null, "El maximo de trabajadores para Apple es 18");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
          if(this.permisoDeAumentoDeTrabajadorAppleEnDatosIniciales() == true){
            prodfuenteApple.setText(Integer.toString(Integer.parseInt(prodfuenteApple.getText())+1));
        }else{
            JOptionPane.showMessageDialog(null, "El maximo de trabajadores para Apple es 18");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
          if(this.permisoDeAumentoDeTrabajadorAppleEnDatosIniciales() == true){
            prodgraficaApple.setText(Integer.toString(Integer.parseInt(prodgraficaApple.getText())+1));
        }else{
            JOptionPane.showMessageDialog(null, "El maximo de trabajadores para Apple es 18");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          if(this.permisoDeAumentoDeTrabajadorAppleEnDatosIniciales() == true){
            ensambladoresApple.setText(Integer.toString(Integer.parseInt(ensambladoresApple.getText())+1));
        }else{
            JOptionPane.showMessageDialog(null, "El maximo de trabajadores para Apple es 18");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        duracionDias.setText(Integer.toString(Integer.parseInt(duracionDias.getText()) + 1));
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        diasEntrega.setText(Integer.toString(Integer.parseInt(diasEntrega.getText()) + 1));
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        Global.getFunciones().escribir_txt();
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(Global.getHP().getProdPlacaBase().getSize() > 1){
            Productor trabajadorDespedido = (Productor) Global.getHP().getProdPlacaBase().getTail().getElement();//agarramos al ultimo 
            Global.getHP().getProdPlacaBase().deleteFinal();//eliminamos al ultimo 
            trabajadorDespedido.despedido = true;//detenemos el hilo del ultimo 
            prodplacabaseHPActivos.setText(Integer.toString(Global.getHP().getProdPlacaBase().getSize()));//actualizamos el label de la interfaz
        }else{
            JOptionPane.showMessageDialog(null, "No puedes despedir un productor de placa base.Te quedarias sin productores de placa base.");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorHP() == true){
            Productor prodplacabaseHPNuevo = new Productor(1, Global.getMutexHP(),Global.getHP()); //creas al nuevo 
            Global.getHP().getProdPlacaBase().insertFinal(prodplacabaseHPNuevo);//lo agregas a la lista de HP
            prodplacabaseHPActivos.setText(Integer.toString(Global.getHP().getProdPlacaBase().getSize()));//actualizamos el label de la GUI
            prodplacabaseHPNuevo.start();//lo pones a trabajar
        }else{
            JOptionPane.showMessageDialog(null, "Limite de trabajadores excedido");
        }
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorHP() == true){
            Productor prodcpuHPNuevo = new Productor(1, Global.getMutexHP(),Global.getHP()); //creas al nuevo 
            Global.getHP().getProdCpu().insertFinal(prodcpuHPNuevo);//lo agregas a la lista de HP
            prodcpuHPActivos.setText(Integer.toString(Global.getHP().getProdCpu().getSize()));//actualizamos el label de la GUI
            prodcpuHPNuevo.start();//lo pones a trabajar
        }else{
            JOptionPane.showMessageDialog(null, "Limite de trabajadores excedido");
        }
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorHP() == true){
            Productor prodramHPNuevo = new Productor(1, Global.getMutexHP(),Global.getHP()); //crear nuevo productor de ram
            Global.getHP().getProdRam().insertFinal(prodramHPNuevo);//agregar a la lista de productores de ram de HP
            prodramHPActivos.setText(Integer.toString(Global.getHP().getProdRam().getSize()));//actualizar el label de la GUI
            prodramHPNuevo.start();//lo pones a trabajar
        }else{
            JOptionPane.showMessageDialog(null, "Limite de trabajadores excedido");
        }
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorHP() == true){
            Productor prodfuenteHPNuevo = new Productor(1, Global.getMutexHP(),Global.getHP()); //crear al nuevo productor de fuente
            Global.getHP().getProdFuentes().insertFinal(prodfuenteHPNuevo);//agregar a la lista de productores de fuente de hp
            prodfuenteHPActivos.setText(Integer.toString(Global.getHP().getProdFuentes().getSize()));//actualizar el label de la GUI
            prodfuenteHPNuevo.start();//lo pones a trabajar
        }else{
            JOptionPane.showMessageDialog(null, "Limite de trabajadores excedido");
        }
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorHP() == true){
            Productor prodgraficaHPNuevo = new Productor(1, Global.getMutexHP(),Global.getHP()); //crear al nuevo productor de tarjetas graficas
            Global.getHP().getProdGraficas().insertFinal(prodgraficaHPNuevo);//agregar a la lista de productores de tarjetas graficas de hp 
            prodgraficaHPActivos.setText(Integer.toString(Global.getHP().getProdGraficas().getSize()));//actualizar el label de la GUI
            prodgraficaHPNuevo.start();//lo pones a trabajar
        }else{
            JOptionPane.showMessageDialog(null, "Limite de trabajadores excedido");
        }
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorHP() == true){
            Productor ensambladorHPNuevo = new Productor(1, Global.getMutexHP(),Global.getHP()); //crear al nuevo ensamblador
            Global.getHP().getEnsambladores().insertFinal(ensambladorHPNuevo);//agregar a la lista de ensambladores de hp 
            ensambladoresHPActivos.setText(Integer.toString(Global.getHP().getEnsambladores().getSize()));//actualizar el label de la GUI
            ensambladorHPNuevo.start();//lo pones a trabajar
        }else{
            JOptionPane.showMessageDialog(null, "Limite de trabajadores excedido");
        }
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:
        if(Global.getHP().getEnsambladores().getSize() > 1){
            Productor trabajadorDespedido = (Productor) Global.getHP().getEnsambladores().getTail().getElement();//agarramos al ultimo 
            Global.getHP().getEnsambladores().deleteFinal();//eliminamos al ultimo 
            trabajadorDespedido.despedido = true;//detenemos el hilo del ultimo 
            ensambladoresHPActivos.setText(Integer.toString(Global.getHP().getEnsambladores().getSize()));//actualizamos el label de la interfaz
        }else{
            JOptionPane.showMessageDialog(null, "No puedes despedir un ensamblador.Te quedarias sin ensambladores.");
        }
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:
        if(Global.getHP().getProdGraficas().getSize() > 1){
            Productor trabajadorDespedido = (Productor) Global.getHP().getProdGraficas().getTail().getElement();//agarramos al ultimo 
            Global.getHP().getProdGraficas().deleteFinal();//eliminamos al ultimo 
            trabajadorDespedido.despedido = true;//detenemos el hilo del ultimo 
            prodgraficaHPActivos.setText(Integer.toString(Global.getHP().getProdGraficas().getSize()));//actualizamos el label de la interfaz
        }else{
            JOptionPane.showMessageDialog(null, "No puedes despedir un productor de tarjetas graficas.Te quedarias sin productores de tarjetas graficas.");
        }
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        // TODO add your handling code here:
        if(Global.getHP().getProdFuentes().getSize() > 1){
            Productor trabajadorDespedido = (Productor) Global.getHP().getProdFuentes().getTail().getElement();//agarramos al ultimo 
            Global.getHP().getProdFuentes().deleteFinal();//eliminamos al ultimo 
            trabajadorDespedido.despedido = true;//detenemos el hilo del ultimo 
            prodfuenteHPActivos.setText(Integer.toString(Global.getHP().getProdFuentes().getSize()));//actualizamos el label de la interfaz
        }else{
            JOptionPane.showMessageDialog(null, "No puedes despedir un productor de fuentes.Te quedarias sin productores de fuentes.");
        }
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        // TODO add your handling code here:
        if(Global.getHP().getProdRam().getSize() > 1){
            Productor trabajadorDespedido = (Productor) Global.getHP().getProdRam().getTail().getElement();//agarramos al ultimo 
            Global.getHP().getProdRam().deleteFinal();//eliminamos al ultimo 
            trabajadorDespedido.despedido = true;//detenemos el hilo del ultimo 
            prodramHPActivos.setText(Integer.toString(Global.getHP().getProdRam().getSize()));//actualizamos el label de la interfaz
        }else{
            JOptionPane.showMessageDialog(null, "No puedes despedir un prodictores de ram.Te quedarias sin productores de ram.");
        }
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:
        if(Global.getHP().getProdCpu().getSize() > 1){
            Productor trabajadorDespedido = (Productor) Global.getHP().getProdCpu().getTail().getElement();//agarramos al ultimo 
            Global.getHP().getProdCpu().deleteFinal();//eliminamos al ultimo 
            trabajadorDespedido.despedido = true;//detenemos el hilo del ultimo 
            prodcpuHPActivos.setText(Integer.toString(Global.getHP().getProdCpu().getSize()));//actualizamos el label de la interfaz
        }else{
            JOptionPane.showMessageDialog(null, "No puedes despedir un productor de Cpu.Te quedarias sin productores de Cpu.");
        }
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
        if(Global.getApple().getEnsambladores().getSize() > 1){
            Ensamblador trabajadorDespedido = (Ensamblador) Global.getApple().getEnsambladores().getTail().getElement();//agarramos al ultimo 
            Global.getApple().getEnsambladores().deleteFinal();//eliminamos al ultimo 
            trabajadorDespedido.despedido = true;//detenemos el hilo del ultimo 
            ensambladoresAppleActivos.setText(Integer.toString(Global.getApple().getEnsambladores().getSize()));//actualizamos el label de la interfaz
        }else{
            JOptionPane.showMessageDialog(null, "No puedes despedir un ensamblador.Te quedarias sin ensambladores.");
        }
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorApple() == true){
            Ensamblador ensambladorAppleNuevo = new Ensamblador(1, Global.getMutexApple(),Global.getApple()); //creas al nuevo 
            Global.getApple().getEnsambladores().insertFinal(ensambladorAppleNuevo);//lo agregas a la lista de Apple
            ensambladoresAppleActivos.setText(Integer.toString(Global.getApple().getEnsambladores().getSize()));//actualizamos el label de la interfaz
            ensambladorAppleNuevo.start();//lo pones a trabajar
        }else{
            JOptionPane.showMessageDialog(null, "Límite de trabajadores excedido");
        }
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        // TODO add your handling code here:
        if(Global.getApple().getProdRam().getSize() > 1){
            Productor trabajadorDespedido = (Productor) Global.getApple().getProdRam().getTail().getElement();//agarramos al ultimo 
            Global.getApple().getProdRam().deleteFinal();//eliminamos al ultimo 
            trabajadorDespedido.despedido = true;//detenemos el hilo del ultimo 
            prodramAppleActivos.setText(Integer.toString(Global.getApple().getProdRam().getSize()));//actualizamos el label de la interfaz
        }else{
            JOptionPane.showMessageDialog(null, "No puedes despedir un productor de ram.Te quedarias sin productores de ram.");
        }
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        // TODO add your handling code here:
        if(Global.getApple().getProdCpu().getSize() > 1){
            Productor trabajadorDespedido = (Productor) Global.getApple().getProdCpu().getTail().getElement();//agarramos al ultimo 
            Global.getApple().getProdCpu().deleteFinal();//eliminamos al ultimo 
            trabajadorDespedido.despedido = true;//detenemos el hilo del ultimo 
            prodcpuAppleActivos.setText(Integer.toString(Global.getApple().getProdCpu().getSize()));//actualizamos el label de la interfaz
        }else{
            JOptionPane.showMessageDialog(null, "No puedes despedir un productores de cpu.Te quedarias sin productores de cpu.");
        }
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        // TODO add your handling code here:
        if(Global.getApple().getProdFuentes().getSize() > 1){
            Productor trabajadorDespedido = (Productor) Global.getApple().getProdFuentes().getTail().getElement();//agarramos al ultimo 
            Global.getApple().getProdFuentes().deleteFinal();//eliminamos al ultimo 
            trabajadorDespedido.despedido = true;//detenemos el hilo del ultimo 
            prodfuenteAppleActivos.setText(Integer.toString(Global.getApple().getProdFuentes().getSize()));//actualizamos el label de la interfaz
        }else{
            JOptionPane.showMessageDialog(null, "No puedes despedir un productor de fuente.Te quedarias sin productores de fuente.");
        }
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        // TODO add your handling code here:
        if(Global.getApple().getProdGraficas().getSize() > 1){
            Productor trabajadorDespedido = (Productor) Global.getApple().getProdGraficas().getTail().getElement();//agarramos al ultimo 
            Global.getApple().getProdGraficas().deleteFinal();//eliminamos al ultimo 
            trabajadorDespedido.despedido = true;//detenemos el hilo del ultimo 
            prodgraficaAppleActivos.setText(Integer.toString(Global.getApple().getProdGraficas().getSize()));//actualizamos el label de la interfaz
        }else{
            JOptionPane.showMessageDialog(null, "No puedes despedir un productores de tarjeta grafica.Te quedarias sin productores de tarjeta grafica.");
        }
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        // TODO add your handling code here:
        if(Global.getApple().getProdPlacaBase().getSize() > 1){
            Productor trabajadorDespedido = (Productor) Global.getApple().getProdPlacaBase().getTail().getElement();//agarramos al ultimo 
            Global.getApple().getProdPlacaBase().deleteFinal();//eliminamos al ultimo 
            trabajadorDespedido.despedido = true;//detenemos el hilo del ultimo 
            prodplacabaseAppleActivos.setText(Integer.toString(Global.getApple().getProdPlacaBase().getSize()));//actualizamos el label de la interfaz
        }else{
            JOptionPane.showMessageDialog(null, "No puedes despedir un productor de placa base.Te quedarias sin productores de placa base.");
        }
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorApple() == true){
            Productor prodplacabaseAppleNuevo = new Productor(1, Global.getMutexApple(),Global.getApple()); //creas al nuevo 
            Global.getApple().getProdPlacaBase().insertFinal(prodplacabaseAppleNuevo);//lo agregas a la lista de Apple
            prodplacabaseAppleActivos.setText(Integer.toString(Global.getApple().getProdPlacaBase().getSize()));//actualizamos el label de la interfaz
            prodplacabaseAppleNuevo.start();//lo pones a trabajar
        }else{
            JOptionPane.showMessageDialog(null, "Límite de trabajadores excedido");
        }
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorApple() == true){
            Productor prodcpuAppleNuevo = new Productor(1, Global.getMutexApple(),Global.getApple()); //creas al nuevo 
            Global.getApple().getProdCpu().insertFinal(prodcpuAppleNuevo);//lo agregas a la lista de Apple
            prodcpuAppleActivos.setText(Integer.toString(Global.getApple().getProdCpu().getSize()));//actualizamos el label de la interfaz
            prodcpuAppleNuevo.start();//lo pones a trabajar
        }else{
            JOptionPane.showMessageDialog(null, "Límite de trabajadores excedido");
        }
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorApple() == true){
            Productor prodramAppleNuevo = new Productor(1, Global.getMutexApple(),Global.getApple()); //creas al nuevo 
            Global.getApple().getProdRam().insertFinal(prodramAppleNuevo);//lo agregas a la lista de Apple
            prodramAppleActivos.setText(Integer.toString(Global.getApple().getProdRam().getSize()));//actualizamos el label de la interfaz
            prodramAppleNuevo.start();//lo pones a trabajar
        }else{
            JOptionPane.showMessageDialog(null, "Límite de trabajadores excedido");
        }
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorApple() == true){
            Productor prodfuenteAppleNuevo = new Productor(1, Global.getMutexApple(),Global.getApple()); //creas al nuevo 
            Global.getApple().getProdFuentes().insertFinal(prodfuenteAppleNuevo);//lo agregas a la lista de Apple
            prodfuenteAppleActivos.setText(Integer.toString(Global.getApple().getProdFuentes().getSize()));//actualizamos el label de la interfaz
            prodfuenteAppleNuevo.start();//lo pones a trabajar
        }else{
            JOptionPane.showMessageDialog(null, "Límite de trabajadores excedido");
        }
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        // TODO add your handling code here:
        if(this.permisoDeAumentoDeTrabajadorApple() == true){
            Productor prodgraficaAppleNuevo = new Productor(1, Global.getMutexApple(),Global.getApple()); //creas al nuevo 
            Global.getApple().getProdGraficas().insertFinal(prodgraficaAppleNuevo);//lo agregas a la lista de Apple
            prodgraficaAppleActivos.setText(Integer.toString(Global.getApple().getProdGraficas().getSize()));//actualizamos el label de la interfaz
            prodgraficaAppleNuevo.start();//lo pones a trabajar
        }else{
            JOptionPane.showMessageDialog(null, "Límite de trabajadores excedido");
        }
    }//GEN-LAST:event_jButton53ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actividadDirectorApple;
    private javax.swing.JLabel actividadDirectorHP;
    private javax.swing.JLabel costosOperativosApple;
    private javax.swing.JLabel costosOperativosHP;
    private javax.swing.JLabel cpuApple;
    private javax.swing.JLabel cpuHP;
    private javax.swing.JLabel diasApple;
    private javax.swing.JLabel diasEntrega;
    private javax.swing.JLabel diasEntregaApple;
    private javax.swing.JLabel diasEntregaHP;
    private javax.swing.JLabel diasHP;
    private javax.swing.JLabel diasHP1;
    private javax.swing.JLabel diasInicio;
    private javax.swing.JLabel duracionDias;
    private javax.swing.JLabel ensambladoresApple;
    private javax.swing.JLabel ensambladoresAppleActivos;
    private javax.swing.JLabel ensambladoresHP;
    private javax.swing.JLabel ensambladoresHPActivos;
    private javax.swing.JLabel estandarappleinicio;
    private javax.swing.JLabel estandarhpinicio;
    private javax.swing.JLabel faltaspmApple;
    private javax.swing.JLabel faltaspmHP;
    private javax.swing.JLabel fuentesApple;
    private javax.swing.JLabel fuentesHP;
    private javax.swing.JLabel gananciasApple;
    private javax.swing.JLabel gananciasHP;
    private javax.swing.JLabel gananciasappleinicio;
    private javax.swing.JLabel gananciashpinicio;
    private javax.swing.JLabel graficasApple;
    private javax.swing.JLabel graficasHP;
    private javax.swing.JLabel graficasappleinicio;
    private javax.swing.JLabel graficashpinicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel operativosappleinicio;
    private javax.swing.JLabel operativoshpinicio;
    private javax.swing.JLabel pcestandarListasApple;
    private javax.swing.JLabel pcestandarListasHP;
    private javax.swing.JLabel pcgraficasListasApple;
    private javax.swing.JLabel pcgraficasListasHP;
    private javax.swing.JLabel placasbaseApple;
    private javax.swing.JLabel placasbaseHP;
    private javax.swing.JLabel pmActividadApple;
    private javax.swing.JLabel pmActividadHP;
    private javax.swing.JLabel prodcpuApple;
    private javax.swing.JLabel prodcpuAppleActivos;
    private javax.swing.JLabel prodcpuHP;
    private javax.swing.JLabel prodcpuHPActivos;
    private javax.swing.JLabel prodfuenteApple;
    private javax.swing.JLabel prodfuenteAppleActivos;
    private javax.swing.JLabel prodfuenteHP;
    private javax.swing.JLabel prodfuenteHPActivos;
    private javax.swing.JLabel prodgraficaApple;
    private javax.swing.JLabel prodgraficaAppleActivos;
    private javax.swing.JLabel prodgraficaHP;
    private javax.swing.JLabel prodgraficaHPActivos;
    private javax.swing.JLabel prodplacabaseApple;
    private javax.swing.JLabel prodplacabaseAppleActivos;
    private javax.swing.JLabel prodplacabaseHP;
    private javax.swing.JLabel prodplacabaseHPActivos;
    private javax.swing.JLabel prodramApple;
    private javax.swing.JLabel prodramAppleActivos;
    private javax.swing.JLabel prodramHP;
    private javax.swing.JLabel prodramHPActivos;
    private javax.swing.JLabel ramApple;
    private javax.swing.JLabel ramHP;
    private javax.swing.JLabel salarioDescontadoApple;
    private javax.swing.JLabel salarioDescontadoHP;
    private javax.swing.JLabel utilidadesApple;
    private javax.swing.JLabel utilidadesHP;
    private javax.swing.JLabel utilidadesappleinicio;
    private javax.swing.JLabel utilidadeshpinicio;
    // End of variables declaration//GEN-END:variables
}
