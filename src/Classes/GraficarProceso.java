/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataStructures.Queue;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author luciano
 */
public class GraficarProceso {
    
    
    public static void GraficarProceso( Queue<Process> Queue ){
        
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        while(!Queue.isEmpty()){
            Process a = Queue.dequeue();
           dataset.addValue(a.GetExecutionTime(), a.getName(), "Probando");  
        }
        
        JFreeChart grafico = ChartFactory.createBarChart3D(  
        "GRAFICA DE RENDIMIENTO", //Chart Title  
        "Procesos", // Category axis  
        "TIEMPO", // Value axis  
        dataset,  
        PlotOrientation.VERTICAL,  
        true,true,false  
       );
        
        ChartPanel panel=new ChartPanel(grafico);  
        JFrame frame = new JFrame("Gráfica de Rendimiento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
        
    }
    public static void AñadirSerie(Queue<Integer> QueueTiempo, String seriesName, XYSeriesCollection dataset){
    
    XYSeries series = new XYSeries(seriesName); // Crea una serie
    
    int total = 0;
    series.add(0, 0);
    while (!QueueTiempo.isEmpty()) {
        int actual = QueueTiempo.dequeue();
        total += actual;
        series.add(total, actual); // Añade puntos a la misma serie
        System.out.println(actual);
    }
    
    dataset.addSeries(series); // Añade la serie al dataset
    
    }
    public static void VerGrafico(XYSeriesCollection dataset){
    JFreeChart grafico = ChartFactory.createXYLineChart(
        "Grafica de Rendimiento", // Title
        "Tiempo", // X-axis label
        "Consumo de CPU", // Y-axis label
        dataset, // Dataset
        PlotOrientation.VERTICAL,
        true,
        true,
        false
    );

    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
    renderer.setBaseShapesVisible(true);
    grafico.getXYPlot().setRenderer(renderer);

    ChartPanel panel = new ChartPanel(grafico);
    JFrame frame = new JFrame("Grafica de Rendimiento");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    frame.pack();
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    }
    
    public static void  RecibirCPUArray(CPU[] cpu){
        final XYSeriesCollection dataset = new XYSeriesCollection();
        if(cpu[0] != null){
            Queue<Integer> queue1 = cpu[0].getExecTimes();
            AñadirSerie(queue1, "CPU 1", dataset);
        }
        if(cpu[1] != null){
            Queue<Integer> queue2 = cpu[1].getExecTimes();
            AñadirSerie(queue2, "CPU 2", dataset);
        }
        if(cpu[2] != null){
            Queue<Integer> queue3 = cpu[2].getExecTimes();
            AñadirSerie(queue3, "CPU 3", dataset);
        }
        VerGrafico(dataset);
    }    
    public static void main(String[] args) {
        final XYSeriesCollection dataset = new XYSeriesCollection();

        // Create queues for different series
        Queue<Integer> queue1 = new Queue<>();
        queue1.enqueue(2);
        queue1.enqueue(7);
        queue1.enqueue(9);

        Queue<Integer> queue2 = new Queue<>();
        queue2.enqueue(1);
        queue2.enqueue(5);
        queue2.enqueue(8);

        Queue<Integer> queue3 = new Queue<>();
        queue3.enqueue(3);
        queue3.enqueue(4);
        queue3.enqueue(6);

        // Add each series to the dataset
        AñadirSerie(queue1, "Proceso 1", dataset);
        AñadirSerie(queue2, "Proceso 2", dataset);
        AñadirSerie(queue3, "Proceso 3", dataset);

        VerGrafico(dataset);
    
//        System.out.println(QueueTiempo.dequeue());
//        System.out.println(QueueTiempo.dequeue());
//        Queue<Process> Queue = new Queue();
//        // Manually generate processes with specific values
//        Process p1 = new Process("P1", 10, 100);
//        Process p2 = new Process("P2", 15, 200);
//        Process p3 = new Process("P3", 20, 300);
//        Process p4 = new Process("P4", 25, 400);
//        Process p5 = new Process("P5", 30, 500);
//        Process p6 = new Process("P6", 35, 600);
//        Process p7 = new Process("P7", 40, 700);
//        Process p8 = new Process("P8", 45, 800);
//        Process p9 = new Process("P9", 50, 900);
//        Process p10 = new Process("P10", 55, 1000);
//
//        // Manually set ExecutionTime for each process
//        p1.SetExecutionTime(5);   // ExecutionTime = 5
//        p2.SetExecutionTime(10);  // ExecutionTime = 10
//        p3.SetExecutionTime(15);  // ExecutionTime = 15
//        p4.SetExecutionTime(20);  // ExecutionTime = 20
//        p5.SetExecutionTime(25);  // ExecutionTime = 25
//        p6.SetExecutionTime(30);  // ExecutionTime = 30
//        p7.SetExecutionTime(35);  // ExecutionTime = 35
//        p8.SetExecutionTime(40);  // ExecutionTime = 40
//        p9.SetExecutionTime(45);  // ExecutionTime = 45
//        p10.SetExecutionTime(50); // ExecutionTime = 50
//
//        // Add processes to the queue
//        Queue.enqueue(p1);
//        Queue.enqueue(p2);
//        Queue.enqueue(p3);
//        Queue.enqueue(p4);
//        Queue.enqueue(p5);
//        Queue.enqueue(p6);
//        Queue.enqueue(p7);
//        Queue.enqueue(p8);
//        Queue.enqueue(p9);
//        Queue.enqueue(p10);
//        
//        GraficarProceso(Queue);
        
        
    }
    
}
