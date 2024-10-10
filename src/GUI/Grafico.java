package GUI;

import Entes.Productor;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.BasicStroke;
import java.awt.Color;
 
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @author Emiliana Plaz
 * @author Stefano Boschetti
 */
public class Grafico extends Thread{
   private JFrame ventana = new JFrame("Grafica");
    @Override
    public void run() {
        XYSeries apple = new XYSeries("APPLE");
        apple.add(0, 0);
        XYSeries hp = new XYSeries("HP");
        hp.add(0, 0);        
       
     
 
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(apple);
        dataset.addSeries(hp);
 
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                "Utilidad en tiempo real", 
                "DIA", 
                "UTILIDAD", 
                dataset,
                PlotOrientation.VERTICAL, true, true, false);
 
        
        XYPlot plot = xylineChart.getXYPlot();
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        
        renderer.setSeriesPaint(0, Color.BLACK);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        plot.setRenderer(renderer);
        
        ChartPanel panel = new ChartPanel(xylineChart);
        this.getVentana().setSize(500, 600);
 
        this.getVentana().add(panel);
        int x = 5;
        int y = 7;
        while (true) {
            x = x +5;
            y = y +7;
            try {
                this.agregarNuevoValor(apple, hp,(int)Global.getApple().getAlmacen().getUtilidades(),
                        Global.getApple().getAlmacen().getContadorPasoDeLosDias(),(int)Global.getHP().getAlmacen().getUtilidades(),
                        Global.getHP().getAlmacen().getContadorPasoDeLosDias());
                

                sleep(Global.getApple().getDuracionDia());
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void agregarNuevoValor(XYSeries apple,XYSeries cn,int yApple,int xApple,int yHP,int xHP){
        apple.add(xApple, yApple);
        cn.add(xHP, yHP);
    }
    public JFrame getVentana() {
        return ventana;
    }
    public void setVentana(JFrame ventana) {
        this.ventana = ventana;
    }
}