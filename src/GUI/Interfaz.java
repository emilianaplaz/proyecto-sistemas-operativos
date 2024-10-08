/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.text.DecimalFormat;

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
        }else{
            diasEntregaHP.setText(Integer.toString(t));
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
            estandarappleinicio.setText(Integer.toString(t));
        }else{
            pcestandarListasHP.setText(Integer.toString(t));
            estandarhpinicio.setText(Integer.toString(t));
        }
    }
    
    public void cambiarPcGraficasListas(int t,int tipoCompania){
        if(tipoCompania == 0){
            pcgraficasListasApple.setText(Integer.toString(t));
            graficasappleinicio.setText(Integer.toString(t));
        }else{
            //System.out.println(t+"hj");
            pcgraficasListasHP.setText(Integer.toString(t));
            graficashpinicio.setText(Integer.toString(t));
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
    public String getDuracionDias(){
        return duracionDias.getText();
    }
    public String getDiasEntrega(){
        return diasEntrega.getText();
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
        jLabel1 = new javax.swing.JLabel();
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
        jButton8 = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        jLabel1.setText("Apple vs HP");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(376, 19, 73, 17);

        jLabel2.setText("DIAS:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(24, 98, 32, 17);

        diasInicio.setText("0");
        jPanel2.add(diasInicio);
        diasInicio.setBounds(62, 98, 7, 17);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(24, 188, 0, 0);

        jLabel4.setText("Apple");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(351, 121, 90, 17);

        jLabel5.setText("HP");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(754, 121, 40, 17);

        jLabel6.setText("Utilidades");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(144, 171, 59, 17);

        jLabel7.setText("Costos Operativos");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(144, 206, 109, 17);

        jLabel8.setText("Ganancias en bruto");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(144, 241, 114, 17);

        jLabel9.setText("Computadoras Entándar");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(144, 276, 142, 17);

        jLabel10.setText("Computadoras Gráficas");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(144, 311, 139, 17);

        utilidadesappleinicio.setText("0");
        jPanel2.add(utilidadesappleinicio);
        utilidadesappleinicio.setBounds(365, 171, 40, 17);

        operativosappleinicio.setText("0");
        jPanel2.add(operativosappleinicio);
        operativosappleinicio.setBounds(365, 206, 60, 17);

        gananciasappleinicio.setText("0");
        jPanel2.add(gananciasappleinicio);
        gananciasappleinicio.setBounds(365, 241, 80, 17);

        estandarappleinicio.setText("0");
        jPanel2.add(estandarappleinicio);
        estandarappleinicio.setBounds(365, 276, 30, 17);

        graficasappleinicio.setText("0");
        jPanel2.add(graficasappleinicio);
        graficasappleinicio.setBounds(365, 311, 30, 17);

        utilidadeshpinicio.setText("0");
        jPanel2.add(utilidadeshpinicio);
        utilidadeshpinicio.setBounds(754, 171, 7, 17);

        operativoshpinicio.setText("0");
        jPanel2.add(operativoshpinicio);
        operativoshpinicio.setBounds(754, 206, 7, 17);

        gananciashpinicio.setText("0");
        jPanel2.add(gananciashpinicio);
        gananciashpinicio.setBounds(754, 241, 7, 17);

        estandarhpinicio.setText("0");
        jPanel2.add(estandarhpinicio);
        estandarhpinicio.setBounds(754, 276, 7, 17);

        graficashpinicio.setText("0");
        jPanel2.add(graficashpinicio);
        graficashpinicio.setBounds(754, 311, 7, 17);

        jTabbedPane2.addTab("Home", jPanel2);

        jPanel3.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel11.setText("Configuración Inicial");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(230, 20, 250, 30);

        jLabel12.setText("Productors placa base");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(32, 152, 132, 17);

        jLabel13.setText("Productores CPU");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(30, 190, 100, 17);

        jLabel14.setText("Productores RAM");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(32, 222, 102, 17);

        jLabel15.setText("Productores fuentes de energía");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(32, 257, 182, 17);

        jLabel16.setText("Productores tarjeta gráfica");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(32, 292, 153, 17);

        jLabel17.setText("Ensambladores");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(32, 327, 91, 17);

        jLabel18.setText("Apple");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(350, 90, 34, 17);

        jLabel19.setText("HP");
        jPanel3.add(jLabel19);
        jLabel19.setBounds(503, 89, 17, 17);

        prodplacabaseApple.setText("0");
        jPanel3.add(prodplacabaseApple);
        prodplacabaseApple.setBounds(358, 152, 7, 17);

        prodcpuApple.setText("0");
        jPanel3.add(prodcpuApple);
        prodcpuApple.setBounds(360, 190, 7, 17);

        prodramApple.setText("0");
        jPanel3.add(prodramApple);
        prodramApple.setBounds(358, 222, 7, 17);

        prodfuenteApple.setText("0");
        jPanel3.add(prodfuenteApple);
        prodfuenteApple.setBounds(358, 257, 7, 17);

        prodgraficaApple.setText("0");
        jPanel3.add(prodgraficaApple);
        prodgraficaApple.setBounds(358, 292, 7, 17);

        ensambladoresApple.setText("0");
        jPanel3.add(ensambladoresApple);
        ensambladoresApple.setBounds(358, 327, 7, 17);

        prodplacabaseHP.setText("0");
        jPanel3.add(prodplacabaseHP);
        prodplacabaseHP.setBounds(510, 150, 16, 17);

        prodcpuHP.setText("0");
        jPanel3.add(prodcpuHP);
        prodcpuHP.setBounds(510, 190, 49, 17);

        prodramHP.setText("0");
        jPanel3.add(prodramHP);
        prodramHP.setBounds(510, 220, 7, 17);

        prodfuenteHP.setText("0");
        jPanel3.add(prodfuenteHP);
        prodfuenteHP.setBounds(510, 260, 7, 17);

        prodgraficaHP.setText("0");
        jPanel3.add(prodgraficaHP);
        prodgraficaHP.setBounds(510, 290, 7, 17);

        ensambladoresHP.setText("0");
        jPanel3.add(ensambladoresHP);
        ensambladoresHP.setBounds(510, 320, 7, 17);

        jButton1.setText("+");
        jPanel3.add(jButton1);
        jButton1.setBounds(380, 320, 30, 23);

        jButton2.setText("+");
        jPanel3.add(jButton2);
        jButton2.setBounds(540, 320, 30, 23);

        jButton3.setText("+");
        jPanel3.add(jButton3);
        jButton3.setBounds(380, 190, 30, 23);

        jButton4.setText("+");
        jPanel3.add(jButton4);
        jButton4.setBounds(380, 220, 30, 23);

        jButton5.setText("+");
        jPanel3.add(jButton5);
        jButton5.setBounds(380, 250, 30, 23);

        jButton6.setText("+");
        jPanel3.add(jButton6);
        jButton6.setBounds(380, 290, 30, 23);

        jButton7.setText("-");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7);
        jButton7.setBounds(520, 380, 30, 23);

        jButton8.setText("+");
        jPanel3.add(jButton8);
        jButton8.setBounds(540, 150, 30, 23);

        jButton9.setText("+");
        jPanel3.add(jButton9);
        jButton9.setBounds(540, 150, 30, 23);

        jButton10.setText("+");
        jPanel3.add(jButton10);
        jButton10.setBounds(540, 190, 30, 23);

        jButton11.setText("+");
        jPanel3.add(jButton11);
        jButton11.setBounds(540, 220, 30, 23);

        jButton12.setText("+");
        jPanel3.add(jButton12);
        jButton12.setBounds(540, 260, 30, 23);

        jButton13.setText("+");
        jPanel3.add(jButton13);
        jButton13.setBounds(540, 290, 30, 23);

        jLabel60.setText("Duración de días en segundos");
        jPanel3.add(jLabel60);
        jLabel60.setBounds(30, 380, 190, 17);

        duracionDias.setText("0");
        jPanel3.add(duracionDias);
        duracionDias.setBounds(260, 380, 7, 17);

        jButton14.setText("+");
        jPanel3.add(jButton14);
        jButton14.setBounds(380, 150, 30, 23);

        jButton15.setText("+");
        jPanel3.add(jButton15);
        jButton15.setBounds(590, 380, 30, 23);

        jLabel69.setText("Días para la entrega");
        jPanel3.add(jLabel69);
        jLabel69.setBounds(390, 380, 130, 17);

        diasEntrega.setText("0");
        jPanel3.add(diasEntrega);
        diasEntrega.setBounds(570, 380, 7, 17);

        jButton16.setText("-");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton16);
        jButton16.setBounds(320, 320, 30, 23);

        jButton17.setText("+");
        jPanel3.add(jButton17);
        jButton17.setBounds(280, 380, 30, 23);

        jButton18.setText("-");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton18);
        jButton18.setBounds(220, 380, 30, 23);

        jButton19.setText("-");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton19);
        jButton19.setBounds(320, 150, 30, 23);

        jButton20.setText("-");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton20);
        jButton20.setBounds(320, 190, 30, 23);

        jButton21.setText("-");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton21);
        jButton21.setBounds(320, 220, 30, 23);

        jButton22.setText("-");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton22);
        jButton22.setBounds(320, 250, 30, 23);

        jButton23.setText("-");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton23);
        jButton23.setBounds(320, 290, 30, 23);

        jButton24.setText("GUARDAR");
        jPanel3.add(jButton24);
        jButton24.setBounds(550, 30, 100, 23);

        jTabbedPane2.addTab("Config", jPanel3);

        jPanel4.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(null);

        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel20.setText("Trabajadores Activos");
        jPanel6.add(jLabel20);
        jLabel20.setBounds(90, 10, 140, 17);

        jLabel22.setText("Productores CPU");
        jPanel6.add(jLabel22);
        jLabel22.setBounds(20, 70, 100, 17);

        jLabel23.setText("Productores RAM");
        jPanel6.add(jLabel23);
        jLabel23.setBounds(20, 100, 102, 17);

        jLabel24.setText("Productores fuentes de energia");
        jPanel6.add(jLabel24);
        jLabel24.setBounds(20, 130, 182, 17);

        jLabel25.setText("Productores tarjeta gráfica");
        jPanel6.add(jLabel25);
        jLabel25.setBounds(20, 160, 153, 17);

        jLabel26.setText("Ensambladores");
        jPanel6.add(jLabel26);
        jLabel26.setBounds(20, 190, 91, 17);

        prodplacabaseAppleActivos.setText("0");
        jPanel6.add(prodplacabaseAppleActivos);
        prodplacabaseAppleActivos.setBounds(230, 40, 7, 17);

        prodcpuAppleActivos.setText("0");
        jPanel6.add(prodcpuAppleActivos);
        prodcpuAppleActivos.setBounds(230, 70, 7, 17);

        prodramAppleActivos.setText("0");
        jPanel6.add(prodramAppleActivos);
        prodramAppleActivos.setBounds(230, 100, 7, 17);

        prodfuenteAppleActivos.setText("0");
        jPanel6.add(prodfuenteAppleActivos);
        prodfuenteAppleActivos.setBounds(230, 130, 7, 17);

        prodgraficaAppleActivos.setText("0");
        jPanel6.add(prodgraficaAppleActivos);
        prodgraficaAppleActivos.setBounds(230, 160, 7, 17);

        ensambladoresAppleActivos.setText("0");
        jPanel6.add(ensambladoresAppleActivos);
        ensambladoresAppleActivos.setBounds(230, 190, 7, 17);

        jLabel28.setText("Productores placa base");
        jPanel6.add(jLabel28);
        jLabel28.setBounds(20, 40, 150, 17);

        jPanel4.add(jPanel6);
        jPanel6.setBounds(30, 30, 280, 220);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(null);

        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel27.setText("Capacidad del Almacen");
        jPanel7.add(jLabel27);
        jLabel27.setBounds(20, 10, 150, 17);

        jLabel21.setText("Placa base");
        jPanel7.add(jLabel21);
        jLabel21.setBounds(30, 40, 150, 17);

        jLabel29.setText("CPU");
        jPanel7.add(jLabel29);
        jLabel29.setBounds(30, 70, 26, 17);

        jLabel30.setText("RAM");
        jPanel7.add(jLabel30);
        jLabel30.setBounds(30, 100, 28, 17);

        jLabel31.setText("Fuente");
        jPanel7.add(jLabel31);
        jLabel31.setBounds(30, 130, 39, 17);

        jLabel32.setText("Tarjetas Gráficas");
        jPanel7.add(jLabel32);
        jLabel32.setBounds(30, 160, 110, 17);

        placasbaseApple.setText("0");
        jPanel7.add(placasbaseApple);
        placasbaseApple.setBounds(190, 40, 7, 17);

        cpuApple.setText("0");
        jPanel7.add(cpuApple);
        cpuApple.setBounds(190, 70, 7, 17);

        ramApple.setText("0");
        jPanel7.add(ramApple);
        ramApple.setBounds(190, 100, 7, 17);

        fuentesApple.setText("0");
        jPanel7.add(fuentesApple);
        fuentesApple.setBounds(190, 130, 7, 17);

        graficasApple.setText("0");
        jPanel7.add(graficasApple);
        graficasApple.setBounds(190, 160, 7, 17);

        jPanel4.add(jPanel7);
        jPanel7.setBounds(320, 30, 250, 220);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(null);

        jLabel61.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel61.setText("Estadísticas");
        jPanel8.add(jLabel61);
        jLabel61.setBounds(79, 6, 80, 17);

        jLabel62.setText("Costos operativos");
        jPanel8.add(jLabel62);
        jLabel62.setBounds(20, 40, 106, 17);

        jLabel64.setText("Utilidades");
        jPanel8.add(jLabel64);
        jLabel64.setBounds(20, 70, 59, 17);

        jLabel66.setText("Ganancia en bruto");
        jPanel8.add(jLabel66);
        jLabel66.setBounds(20, 100, 120, 17);

        costosOperativosApple.setText("0");
        jPanel8.add(costosOperativosApple);
        costosOperativosApple.setBounds(160, 40, 7, 17);

        utilidadesApple.setText("0");
        jPanel8.add(utilidadesApple);
        utilidadesApple.setBounds(160, 70, 7, 17);

        gananciasApple.setText("0");
        jPanel8.add(gananciasApple);
        gananciasApple.setBounds(160, 100, 7, 17);

        jPanel4.add(jPanel8);
        jPanel8.setBounds(30, 260, 230, 140);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(null);

        jLabel33.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel33.setText("Project Manager");
        jPanel9.add(jLabel33);
        jLabel33.setBounds(50, 10, 110, 17);

        jLabel34.setText("Actividad");
        jPanel9.add(jLabel34);
        jLabel34.setBounds(10, 40, 70, 17);

        jLabel35.setText("Faltas");
        jPanel9.add(jLabel35);
        jLabel35.setBounds(10, 70, 35, 17);

        jLabel36.setText("Sueldo descontado");
        jPanel9.add(jLabel36);
        jLabel36.setBounds(10, 100, 120, 17);

        pmActividadApple.setText("0");
        jPanel9.add(pmActividadApple);
        pmActividadApple.setBounds(130, 40, 7, 17);

        faltaspmApple.setText("0");
        jPanel9.add(faltaspmApple);
        faltaspmApple.setBounds(130, 70, 7, 17);

        salarioDescontadoApple.setText("0");
        jPanel9.add(salarioDescontadoApple);
        salarioDescontadoApple.setBounds(140, 100, 7, 17);

        jPanel4.add(jPanel9);
        jPanel9.setBounds(270, 260, 220, 140);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(null);

        jLabel54.setText("Director");
        jPanel10.add(jLabel54);
        jLabel54.setBounds(50, 10, 49, 17);

        jPanel4.add(jPanel10);
        jPanel10.setBounds(550, 260, 0, 0);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(null);

        jLabel56.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel56.setText("Director");
        jPanel12.add(jLabel56);
        jLabel56.setBounds(76, 6, 50, 17);

        jLabel57.setText("Actividad");
        jPanel12.add(jLabel57);
        jLabel57.setBounds(10, 40, 55, 17);

        jLabel58.setText("pcs Estandar listas");
        jPanel12.add(jLabel58);
        jLabel58.setBounds(10, 70, 113, 17);

        jLabel59.setText("pcs Tarjeta Grafica listas");
        jPanel12.add(jLabel59);
        jLabel59.setBounds(10, 100, 146, 17);

        actividadDirectorApple.setText("0");
        jPanel12.add(actividadDirectorApple);
        actividadDirectorApple.setBounds(170, 40, 7, 17);

        pcestandarListasApple.setText("0");
        jPanel12.add(pcestandarListasApple);
        pcestandarListasApple.setBounds(170, 70, 7, 17);

        pcgraficasListasApple.setText("0");
        jPanel12.add(pcgraficasListasApple);
        pcgraficasListasApple.setBounds(170, 100, 49, 17);

        jPanel4.add(jPanel12);
        jPanel12.setBounds(500, 260, 200, 140);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(null);

        jLabel72.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel72.setText("Dias para entrega");
        jPanel16.add(jLabel72);
        jLabel72.setBounds(6, 6, 109, 17);

        diasEntregaApple.setText("0");
        jPanel16.add(diasEntregaApple);
        diasEntregaApple.setBounds(40, 60, 7, 17);

        jLabel74.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel74.setText("Dias");
        jPanel16.add(jLabel74);
        jLabel74.setBounds(40, 110, 49, 17);

        diasApple.setText("0");
        jPanel16.add(diasApple);
        diasApple.setBounds(50, 160, 7, 17);

        jPanel4.add(jPanel16);
        jPanel16.setBounds(580, 30, 120, 220);

        jTabbedPane2.addTab("Apple", jPanel4);

        jPanel5.setLayout(null);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(null);

        jLabel37.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel37.setText("Trabajadores Activos");
        jPanel17.add(jLabel37);
        jLabel37.setBounds(80, 10, 150, 17);

        jLabel38.setText("Productores placa base");
        jPanel17.add(jLabel38);
        jLabel38.setBounds(20, 50, 140, 17);

        jLabel39.setText("Productores CPU");
        jPanel17.add(jLabel39);
        jLabel39.setBounds(20, 80, 100, 17);

        jLabel40.setText("Productores RAM");
        jPanel17.add(jLabel40);
        jLabel40.setBounds(20, 110, 102, 17);

        jLabel41.setText("Productores fuentes de energía");
        jPanel17.add(jLabel41);
        jLabel41.setBounds(20, 140, 182, 17);

        jLabel42.setText("Productores tarjetas gráficas");
        jPanel17.add(jLabel42);
        jLabel42.setBounds(20, 170, 167, 17);

        jLabel43.setText("Ensambladores");
        jPanel17.add(jLabel43);
        jLabel43.setBounds(20, 200, 91, 17);

        prodplacabaseHPActivos.setText("0");
        jPanel17.add(prodplacabaseHPActivos);
        prodplacabaseHPActivos.setBounds(240, 50, 7, 17);

        prodcpuHPActivos.setText("0");
        jPanel17.add(prodcpuHPActivos);
        prodcpuHPActivos.setBounds(240, 80, 7, 17);

        prodramHPActivos.setText("0");
        jPanel17.add(prodramHPActivos);
        prodramHPActivos.setBounds(240, 110, 7, 17);

        prodfuenteHPActivos.setText("0");
        jPanel17.add(prodfuenteHPActivos);
        prodfuenteHPActivos.setBounds(240, 140, 7, 17);

        prodgraficaHPActivos.setText("0");
        jPanel17.add(prodgraficaHPActivos);
        prodgraficaHPActivos.setBounds(240, 170, 7, 17);

        ensambladoresHPActivos.setText("0");
        jPanel17.add(ensambladoresHPActivos);
        ensambladoresHPActivos.setBounds(240, 200, 7, 17);

        jPanel5.add(jPanel17);
        jPanel17.setBounds(30, 20, 300, 230);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(null);

        jLabel44.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel44.setText("Capacidad del Almacen");
        jPanel11.add(jLabel44);
        jLabel44.setBounds(40, 10, 150, 17);

        jLabel45.setText("Placas base");
        jPanel11.add(jLabel45);
        jLabel45.setBounds(20, 50, 90, 17);

        jLabel46.setText("CPU");
        jPanel11.add(jLabel46);
        jLabel46.setBounds(20, 80, 26, 17);

        jLabel47.setText("RAM");
        jPanel11.add(jLabel47);
        jLabel47.setBounds(20, 110, 28, 17);

        jLabel48.setText("Fuentes de energía");
        jPanel11.add(jLabel48);
        jLabel48.setBounds(20, 140, 111, 17);

        jLabel49.setText("Tarjetas gráficas");
        jPanel11.add(jLabel49);
        jLabel49.setBounds(20, 170, 96, 17);

        placasbaseHP.setText("0");
        jPanel11.add(placasbaseHP);
        placasbaseHP.setBounds(180, 50, 7, 17);

        cpuHP.setText("0");
        jPanel11.add(cpuHP);
        cpuHP.setBounds(180, 80, 7, 17);

        ramHP.setText("0");
        jPanel11.add(ramHP);
        ramHP.setBounds(180, 110, 7, 17);

        fuentesHP.setText("0");
        jPanel11.add(fuentesHP);
        fuentesHP.setBounds(180, 140, 7, 17);

        graficasHP.setText("0");
        jPanel11.add(graficasHP);
        graficasHP.setBounds(180, 170, 7, 17);

        jPanel5.add(jPanel11);
        jPanel11.setBounds(340, 20, 230, 230);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(null);

        jLabel76.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel76.setText("Estadísticas");
        jPanel13.add(jLabel76);
        jLabel76.setBounds(79, 6, 80, 17);

        jLabel77.setText("Costos operativos");
        jPanel13.add(jLabel77);
        jLabel77.setBounds(20, 40, 106, 17);

        jLabel78.setText("Utilidades");
        jPanel13.add(jLabel78);
        jLabel78.setBounds(20, 70, 59, 17);

        jLabel79.setText("Ganancia en bruto");
        jPanel13.add(jLabel79);
        jLabel79.setBounds(20, 100, 120, 17);

        costosOperativosHP.setText("0");
        jPanel13.add(costosOperativosHP);
        costosOperativosHP.setBounds(160, 40, 7, 17);

        utilidadesHP.setText("0");
        jPanel13.add(utilidadesHP);
        utilidadesHP.setBounds(160, 70, 7, 17);

        gananciasHP.setText("0");
        jPanel13.add(gananciasHP);
        gananciasHP.setBounds(160, 100, 7, 17);

        jPanel5.add(jPanel13);
        jPanel13.setBounds(30, 260, 240, 140);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(null);

        jLabel50.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel50.setText("Project Manager");
        jPanel14.add(jLabel50);
        jLabel50.setBounds(40, 10, 110, 17);

        jLabel51.setText("Actividad");
        jPanel14.add(jLabel51);
        jLabel51.setBounds(10, 50, 100, 17);

        jLabel52.setText("Faltas");
        jPanel14.add(jLabel52);
        jLabel52.setBounds(10, 80, 35, 17);

        jLabel53.setText("Sueldo descontado");
        jPanel14.add(jLabel53);
        jLabel53.setBounds(10, 110, 113, 17);

        pmActividadHP.setText("0");
        jPanel14.add(pmActividadHP);
        pmActividadHP.setBounds(100, 50, 7, 17);

        faltaspmHP.setText("0");
        jPanel14.add(faltaspmHP);
        faltaspmHP.setBounds(100, 80, 7, 17);

        salarioDescontadoHP.setText("0");
        jPanel14.add(salarioDescontadoHP);
        salarioDescontadoHP.setBounds(140, 110, 7, 17);

        jPanel5.add(jPanel14);
        jPanel14.setBounds(280, 260, 210, 140);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(null);

        jLabel55.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel55.setText("Director");
        jPanel15.add(jLabel55);
        jLabel55.setBounds(75, 6, 50, 17);

        jLabel63.setText("Actividad");
        jPanel15.add(jLabel63);
        jLabel63.setBounds(10, 40, 55, 17);

        actividadDirectorHP.setText("0");
        jPanel15.add(actividadDirectorHP);
        actividadDirectorHP.setBounds(170, 40, 7, 17);

        jLabel65.setText("pcs Estandar listas");
        jPanel15.add(jLabel65);
        jLabel65.setBounds(10, 70, 113, 17);

        pcestandarListasHP.setText("0");
        jPanel15.add(pcestandarListasHP);
        pcestandarListasHP.setBounds(170, 70, 7, 17);

        jLabel67.setText("pcs Tarjeta Grafica listas");
        jPanel15.add(jLabel67);
        jLabel67.setBounds(10, 100, 146, 17);

        pcgraficasListasHP.setText("0");
        jPanel15.add(pcgraficasListasHP);
        pcgraficasListasHP.setBounds(170, 100, 49, 17);

        jPanel5.add(jPanel15);
        jPanel15.setBounds(500, 260, 210, 140);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel68.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel68.setText("Días para entrega");
        jPanel1.add(jLabel68);
        jLabel68.setBounds(10, 10, 128, 25);

        diasEntregaHP.setText("0");
        jPanel1.add(diasEntregaHP);
        diasEntregaHP.setBounds(60, 60, 20, 17);

        jLabel70.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel70.setText("Dias");
        jPanel1.add(jLabel70);
        jLabel70.setBounds(50, 120, 49, 17);

        diasHP.setText("0");
        jPanel1.add(diasHP);
        diasHP.setBounds(50, 180, 7, 17);

        jPanel5.add(jPanel1);
        jPanel1.setBounds(580, 20, 140, 230);

        jTabbedPane2.addTab("HP", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
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
