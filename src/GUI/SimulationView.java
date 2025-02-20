/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Classes.CPU;
import Classes.Clock;
import Classes.ClockListener;
import Classes.MemoryEntity;
import Classes.OperatingSystem;
import Classes.Simulator;
import Classes.Process;
import Classes.ProcessCPUbound;
import Classes.ProcessIObound;
import Classes.Util;
import DataStructures.List;
import DataStructures.Queue;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan
 */
public class SimulationView extends javax.swing.JPanel implements ClockListener {
    private Simulator simulator; 
    
    /**
     * Creates new form SimulationView
     * @param simulator
     */
    public SimulationView(Simulator simulator) {
        initComponents();
        initLookAndFeel();
        this.simulator = simulator;    
        this.simulator.getClock().getClockListeners().append(this);
        
        buttonGroup.add(FCFSbutton);
        buttonGroup.add(RRbutton);
        buttonGroup.add(SPNbutton);
        buttonGroup.add(SRTbutton);
        buttonGroup.add(HRRNbutton);
        FCFSbutton.setSelected(true);
        
        initQueue();
        loadProcess();
        drawReadyQueue();   
        initCPUs();        
    }
    
    public void initQueue(){
        
    }
    
    public void initCPUs(){
        CPU[] cpuArray = this.simulator.getCPUarray();

        if(!cpuArray[0].isEnabled()) CPU1Panel.setBackground(new Color(204, 204, 204));
        else CPU1Panel.setBackground(Color.white);
            
        if(!cpuArray[1].isEnabled()) CPU2Panel.setBackground(new Color(204, 204, 204));
        else CPU2Panel.setBackground(Color.white);
        
        if(!cpuArray[2].isEnabled()) CPU3Panel.setBackground(new Color(204, 204, 204));
        else CPU3Panel.setBackground(Color.white);
        
        progressBar1.setMinimum(0);
        progressBar2.setMinimum(0);
        progressBar3.setMinimum(0);
        
        SO1.setText("");
        SO2.setText("");
        SO3.setText("");
    }
    
    private void loadProcess(){
        String filePath = "src" + File.separator + "Config" + File.separator + "process.txt";
        
        BufferedReader bufferedReader = null;
        
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
            String processList = "";
            String line;
            while ((line = bufferedReader.readLine()) != null) {                      
                processList += line + "\n";                    
            }                
            
            String[] processArray = processList.split("\n");
            if(!processList.isBlank()){
                for(String process: processArray){
                    String[] properties = process.split("-");
                    if(properties[0].equals("IObound")){
                        String name = properties[1];
                        Integer numInstructions = Integer.valueOf(properties[2]);
                        Integer memoryAdress = Integer.valueOf(properties[3]);
                        Integer ticksToInterrupt = Integer.valueOf(properties[4]);
                        Integer ticksToSuccess = Integer.valueOf(properties[5]);
                        simulator.createProcessIObound(name, numInstructions, memoryAdress, ticksToInterrupt, ticksToSuccess);
                    }
                    else{
                        String name = properties[1];
                        Integer numInstructions = Integer.valueOf(properties[2]);
                        Integer memoryAdress = Integer.valueOf(properties[3]);
                        simulator.createProcessCPUbound(name, numInstructions, memoryAdress);
                    }
                }                
            }
            
            bufferedReader.close();                        
        } 
        catch (IOException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }

                
    }
    
    public void drawCPUs(){        
        CPU[] cpuArray = simulator.getCPUarray();
        CPU cpu1 = cpuArray[0];
        CPU cpu2 = cpuArray[1];
        CPU cpu3 = cpuArray[2];
                        
        //CPU1
        if(Clock.tick != 0){
            if(cpu1.isEnabled()){
                switch (cpu1.getCpuStatus()) {
                    case CPU.RUN_OS -> {
                        idCpu1.setText("");
                        nameCpu1.setText("");
                        pcCpu1.setText("");
                        marCpu1.setText("");
                        statusCpu1.setText("");
                        SO1.setText("Sistema Operativo");
                    }
                    case CPU.RUN_IDLE_PROCESS -> {
                        idCpu1.setText("");
                        nameCpu1.setText("");
                        pcCpu1.setText("");
                        marCpu1.setText("");
                        statusCpu1.setText("");
                        SO1.setText("Proceso de Sistema");
                    }
                    case CPU.RUN_PROCESS -> {
                        idCpu1.setText("ID=" + cpu1.getCurrentProcess().getID());
                        nameCpu1.setText("Name=" + cpu1.getCurrentProcess().getName());
                        pcCpu1.setText("PC=" + cpu1.getCurrentProcess().getPC());
                        marCpu1.setText("MAR=" + cpu1.getCurrentProcess().getMAR());
                        statusCpu1.setText("Status=" + Util.getStatusStr(cpu1.getCurrentProcess().getStatus()));            
                        SO1.setText("");
                    }
                }            
            }

            //CPU2
            if(cpu2.isEnabled()){
                switch (cpu2.getCpuStatus()) {
                    case CPU.RUN_OS -> {
                        idCpu2.setText("");
                        nameCpu2.setText("");
                        pcCpu2.setText("");
                        marCpu2.setText("");
                        statusCpu2.setText("");
                        SO2.setText("Sistema Operativo");
                    }
                    case CPU.RUN_IDLE_PROCESS -> {
                        idCpu2.setText("");
                        nameCpu2.setText("");
                        pcCpu2.setText("");
                        marCpu2.setText("");
                        statusCpu2.setText("");
                        SO2.setText("Proceso de Sistema");
                    }
                    case CPU.RUN_PROCESS -> {
                        idCpu2.setText("ID=" + cpu2.getCurrentProcess().getID());
                        nameCpu2.setText("Name=" + cpu2.getCurrentProcess().getName());
                        pcCpu2.setText("PC=" + cpu2.getCurrentProcess().getPC());
                        marCpu2.setText("MAR=" + cpu2.getCurrentProcess().getMAR());
                        statusCpu2.setText("Status=" + Util.getStatusStr(cpu2.getCurrentProcess().getStatus()));            
                        SO2.setText("");
                    }
                }            
            }

            //CPU3
            if(cpu3.isEnabled()){
                switch (cpu3.getCpuStatus()) {
                    case CPU.RUN_OS -> {
                        idCpu3.setText("");
                        nameCpu3.setText("");
                        pcCpu3.setText("");
                        marCpu3.setText("");
                        statusCpu3.setText("");
                        SO3.setText("Sistema Operativo");
                    }
                    case CPU.RUN_IDLE_PROCESS -> {
                        idCpu3.setText("");
                        nameCpu3.setText("");
                        pcCpu3.setText("");
                        marCpu3.setText("");
                        statusCpu3.setText("");
                        SO3.setText("Proceso de Sistema");
                    }
                    case CPU.RUN_PROCESS -> {
                        idCpu3.setText("ID=" + cpu3.getCurrentProcess().getID());
                        nameCpu3.setText("Name=" + cpu3.getCurrentProcess().getName());
                        pcCpu3.setText("PC=" + cpu3.getCurrentProcess().getPC());
                        marCpu3.setText("MAR=" + cpu3.getCurrentProcess().getMAR());
                        statusCpu3.setText("Status=" + Util.getStatusStr(cpu3.getCurrentProcess().getStatus()));            
                        SO3.setText("");
                    }
                }            
            }            
        }
        
        

    }
    
    public void drawReadyQueue(){
        Queue<Integer> readyQueue = simulator.getOperatingSystem().getScheduler().getReadyQueue();        
        
        int size = readyQueue.getSize();  
        
        DefaultTableModel model = (DefaultTableModel) readyQueueArea.getModel();
        model.setRowCount(0);
        for (int i = 0; i < size; i++) {
            MemoryEntity[] mainMemory = simulator.getOperatingSystem().getMainMemory();
            
            Integer memoryAdress = readyQueue.dequeue();
                        
            Process process = (Process) mainMemory[memoryAdress];
            
            model.addRow(new Object[]{
                process.getID(),
                process.getName(),
                process.getPC(),
                process.getMAR(),
                Util.getStatusStr(process.getStatus())
            });           
            
            
            readyQueue.enqueue(memoryAdress);
        }                      
    }
    
    public void drawBlockedQueue(){
        Queue<Integer> blockedQueue = simulator.getOperatingSystem().getScheduler().getBlockedQueue();        
        
        int size = blockedQueue.getSize();             
        
        DefaultTableModel model = (DefaultTableModel) blockedQueueArea.getModel();
        model.setRowCount(0);
        for (int i = 0; i < size; i++) {
            MemoryEntity[] mainMemory = simulator.getOperatingSystem().getMainMemory();
            
            Integer memoryAdress = blockedQueue.dequeue();
                        
            Process process = (Process) mainMemory[memoryAdress];
            
            model.addRow(new Object[]{
                process.getID(),
                process.getName(),
                process.getPC(),
                process.getMAR(),
                Util.getStatusStr(process.getStatus())
            });
                                    
            blockedQueue.enqueue(memoryAdress);
        }                        
    }
    
    public void drawCompletedProcessList(){
        List<Process> completedProcessList = this.simulator.getOperatingSystem().getScheduler().getCompletedProcessList();
                
        DefaultTableModel model = (DefaultTableModel) completedProcessArea.getModel();
        model.setRowCount(0);
        for (int i = 0; i < completedProcessList.getSize(); i++) {
            Process process = completedProcessList.get(i);
            
            model.addRow(new Object[]{
                process.getID(),
                process.getName(),
                process.getPC(),
                process.getMAR(),
                Util.getStatusStr(process.getStatus())
            });
        }        
    }
    
    
    public void drawProgressBar(){
        CPU[] cpuArray = this.simulator.getCPUarray();
        
        CPU cpu1 = cpuArray[0];
        if(cpu1.getCurrentProcess() != null){
            progressBar1.setMaximum(cpu1.getCurrentProcess().getNumInstructions());
            progressBar1.setValue(cpu1.getMAR());
        }            
        else{            
            progressBar1.setValue(0);
        }
        
        CPU cpu2 = cpuArray[1];
        if(cpu2.getCurrentProcess() != null){
            progressBar2.setMaximum(cpu2.getCurrentProcess().getNumInstructions());
            progressBar2.setValue(cpu2.getMAR());
        }            
        else{            
            progressBar2.setValue(0);
        }
        
        CPU cpu3 = cpuArray[2];
        if(cpu3.getCurrentProcess() != null){
            progressBar3.setMaximum(cpu3.getCurrentProcess().getNumInstructions());
            progressBar3.setValue(cpu3.getMAR());
        }            
        else{            
            progressBar3.setValue(0);
        }        
    }
    
    private void initLookAndFeel(){
        List<JToggleButton> buttonsList = new List(FCFSbutton, RRbutton, SPNbutton, SRTbutton, HRRNbutton);
        
        for (int i = 0; i < buttonsList.getSize(); i++) {
            JToggleButton btn = buttonsList.get(i);
            btn.setUI(new MetalToggleButtonUI() {
                @Override
                protected Color getSelectColor() {
                    return new Color(255, 153, 51);                    
                }
            });
        }
    }
    
    @Override
    public void onTick(int tick) { 
        this.tick.setText("Ciclo: " + tick);
        drawCPUs();      
        drawReadyQueue();
        drawBlockedQueue();
        drawCompletedProcessList();
        drawProgressBar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        CPU1Panel = new javax.swing.JPanel();
        progressBar1 = new javax.swing.JProgressBar();
        marCpu1 = new javax.swing.JLabel();
        pcCpu1 = new javax.swing.JLabel();
        statusCpu1 = new javax.swing.JLabel();
        idCpu1 = new javax.swing.JLabel();
        nameCpu1 = new javax.swing.JLabel();
        SO1 = new javax.swing.JLabel();
        CPU2Panel = new javax.swing.JPanel();
        progressBar2 = new javax.swing.JProgressBar();
        idCpu2 = new javax.swing.JLabel();
        pcCpu2 = new javax.swing.JLabel();
        statusCpu2 = new javax.swing.JLabel();
        marCpu2 = new javax.swing.JLabel();
        nameCpu2 = new javax.swing.JLabel();
        SO2 = new javax.swing.JLabel();
        CPU3Panel = new javax.swing.JPanel();
        progressBar3 = new javax.swing.JProgressBar();
        marCpu3 = new javax.swing.JLabel();
        idCpu3 = new javax.swing.JLabel();
        nameCpu3 = new javax.swing.JLabel();
        statusCpu3 = new javax.swing.JLabel();
        pcCpu3 = new javax.swing.JLabel();
        SO3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tick = new javax.swing.JLabel();
        FCFSbutton = new javax.swing.JToggleButton();
        RRbutton = new javax.swing.JToggleButton();
        SPNbutton = new javax.swing.JToggleButton();
        SRTbutton = new javax.swing.JToggleButton();
        HRRNbutton = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        completedProcessArea = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        readyQueueArea = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        blockedQueueArea = new javax.swing.JTable();

        jLabel7.setText("jLabel7");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPU1Panel.setBackground(new java.awt.Color(255, 255, 255));
        CPU1Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CPU1Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        progressBar1.setBackground(new java.awt.Color(255, 255, 255));
        progressBar1.setForeground(new java.awt.Color(255, 153, 51));
        progressBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        progressBar1.setEnabled(false);
        CPU1Panel.add(progressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, 10));

        marCpu1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        marCpu1.setText("MAR=");
        CPU1Panel.add(marCpu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        pcCpu1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        pcCpu1.setText("PC=");
        CPU1Panel.add(pcCpu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        statusCpu1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        statusCpu1.setText("Status=");
        CPU1Panel.add(statusCpu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        idCpu1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        idCpu1.setText("ID=");
        CPU1Panel.add(idCpu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        nameCpu1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        nameCpu1.setText("Name=");
        CPU1Panel.add(nameCpu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        SO1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        SO1.setText("SO1");
        CPU1Panel.add(SO1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jPanel1.add(CPU1Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 140, 130));

        CPU2Panel.setBackground(new java.awt.Color(255, 255, 255));
        CPU2Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CPU2Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        progressBar2.setBackground(new java.awt.Color(255, 255, 255));
        progressBar2.setForeground(new java.awt.Color(255, 153, 51));
        progressBar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CPU2Panel.add(progressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, 10));

        idCpu2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        idCpu2.setText("ID=");
        CPU2Panel.add(idCpu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pcCpu2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        pcCpu2.setText("PC=");
        CPU2Panel.add(pcCpu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        statusCpu2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        statusCpu2.setText("Status=");
        CPU2Panel.add(statusCpu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        marCpu2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        marCpu2.setText("MAR=");
        CPU2Panel.add(marCpu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        nameCpu2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        nameCpu2.setText("Name=");
        CPU2Panel.add(nameCpu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        SO2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        SO2.setText("SO2");
        CPU2Panel.add(SO2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jPanel1.add(CPU2Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 140, 130));

        CPU3Panel.setBackground(new java.awt.Color(255, 255, 255));
        CPU3Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CPU3Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        progressBar3.setBackground(new java.awt.Color(255, 255, 255));
        progressBar3.setForeground(new java.awt.Color(255, 153, 51));
        progressBar3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CPU3Panel.add(progressBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, 10));

        marCpu3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        marCpu3.setText("MAR=");
        CPU3Panel.add(marCpu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        idCpu3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        idCpu3.setText("ID=");
        CPU3Panel.add(idCpu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        nameCpu3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        nameCpu3.setText("Name=");
        CPU3Panel.add(nameCpu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        statusCpu3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        statusCpu3.setText("Status=");
        CPU3Panel.add(statusCpu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        pcCpu3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        pcCpu3.setText("PC=");
        CPU3Panel.add(pcCpu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        SO3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        SO3.setText("SO3");
        CPU3Panel.add(SO3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jPanel1.add(CPU3Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 140, 130));

        jLabel1.setText("Cola Listos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 80, -1));

        jLabel2.setText("Cola Bloqueados");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 100, -1));

        jLabel3.setText("Procesos terminados");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 130, -1));

        jLabel4.setText("CPU1");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 20));

        jLabel5.setText("CPU2");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 50, 20));

        jLabel6.setText("CPU3");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 60, 20));

        tick.setText("Ciclo: 0");
        jPanel1.add(tick, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 480, -1, -1));

        FCFSbutton.setBackground(new java.awt.Color(250, 250, 250));
        FCFSbutton.setText("FCFS");
        FCFSbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        FCFSbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FCFSbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FCFSbuttonMouseExited(evt);
            }
        });
        FCFSbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FCFSbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(FCFSbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 100, 30));

        RRbutton.setBackground(new java.awt.Color(250, 250, 250));
        RRbutton.setText("Round Robin");
        RRbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RRbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RRbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RRbuttonMouseExited(evt);
            }
        });
        RRbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RRbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(RRbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 100, 30));

        SPNbutton.setBackground(new java.awt.Color(250, 250, 250));
        SPNbutton.setText("SPN");
        SPNbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SPNbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SPNbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SPNbuttonMouseExited(evt);
            }
        });
        SPNbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPNbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(SPNbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 100, 30));

        SRTbutton.setBackground(new java.awt.Color(250, 250, 250));
        SRTbutton.setText("SRT");
        SRTbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SRTbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SRTbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SRTbuttonMouseExited(evt);
            }
        });
        SRTbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SRTbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(SRTbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 460, 100, 30));

        HRRNbutton.setBackground(new java.awt.Color(250, 250, 250));
        HRRNbutton.setText("HRRN");
        HRRNbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        HRRNbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HRRNbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HRRNbuttonMouseExited(evt);
            }
        });
        HRRNbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HRRNbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(HRRNbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 460, 100, 30));

        completedProcessArea.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        completedProcessArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "PC", "MAR", "Status"
            }
        ));
        completedProcessArea.setEnabled(false);
        jScrollPane1.setViewportView(completedProcessArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 250, 370));

        readyQueueArea.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        readyQueueArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "PC", "MAR", "Status"
            }
        ));
        readyQueueArea.setEnabled(false);
        jScrollPane2.setViewportView(readyQueueArea);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 250, 370));

        blockedQueueArea.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        blockedQueueArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "PC", "MAR", "Status"
            }
        ));
        blockedQueueArea.setEnabled(false);
        jScrollPane3.setViewportView(blockedQueueArea);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 250, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void FCFSbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FCFSbuttonActionPerformed
        simulator.getOperatingSystem().setPlanningPolicy(OperatingSystem.FCFS);
        RRbutton.setBackground(new Color(250, 250, 250));
        SPNbutton.setBackground(new Color(250, 250, 250));
        SRTbutton.setBackground(new Color(250, 250, 250));
        HRRNbutton.setBackground(new Color(250, 250, 250));
    }//GEN-LAST:event_FCFSbuttonActionPerformed

    private void RRbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RRbuttonActionPerformed
        simulator.getOperatingSystem().setPlanningPolicy(OperatingSystem.roundRobin);
        FCFSbutton.setBackground(new Color(250, 250, 250));
        SPNbutton.setBackground(new Color(250, 250, 250));
        SRTbutton.setBackground(new Color(250, 250, 250));
        HRRNbutton.setBackground(new Color(250, 250, 250));
    }//GEN-LAST:event_RRbuttonActionPerformed

    private void SPNbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPNbuttonActionPerformed
        simulator.getOperatingSystem().setPlanningPolicy(OperatingSystem.SPN);
        FCFSbutton.setBackground(new Color(250, 250, 250));
        RRbutton.setBackground(new Color(250, 250, 250));
        SRTbutton.setBackground(new Color(250, 250, 250));
        HRRNbutton.setBackground(new Color(250, 250, 250));
    }//GEN-LAST:event_SPNbuttonActionPerformed

    private void SRTbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SRTbuttonActionPerformed
        simulator.getOperatingSystem().setPlanningPolicy(OperatingSystem.SRT);
        FCFSbutton.setBackground(new Color(250, 250, 250));
        RRbutton.setBackground(new Color(250, 250, 250));
        SPNbutton.setBackground(new Color(250, 250, 250));
        HRRNbutton.setBackground(new Color(250, 250, 250));
    }//GEN-LAST:event_SRTbuttonActionPerformed

    private void HRRNbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HRRNbuttonActionPerformed
        simulator.getOperatingSystem().setPlanningPolicy(OperatingSystem.HRRN);
        FCFSbutton.setBackground(new Color(250, 250, 250));
        RRbutton.setBackground(new Color(250, 250, 250));
        SPNbutton.setBackground(new Color(250, 250, 250));
        SRTbutton.setBackground(new Color(250, 250, 250));
    }//GEN-LAST:event_HRRNbuttonActionPerformed

    private void FCFSbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FCFSbuttonMouseEntered
        if(!FCFSbutton.isSelected()){
            FCFSbutton.setBackground(new Color(255, 194, 133));            
        }
    }//GEN-LAST:event_FCFSbuttonMouseEntered

    private void FCFSbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FCFSbuttonMouseExited
        if(!FCFSbutton.isSelected()){
            FCFSbutton.setBackground(new Color(250, 250, 250));            
        }
    }//GEN-LAST:event_FCFSbuttonMouseExited

    private void RRbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RRbuttonMouseEntered
        if(!RRbutton.isSelected()){
            RRbutton.setBackground(new Color(255, 194, 133));            
        }
    }//GEN-LAST:event_RRbuttonMouseEntered

    private void RRbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RRbuttonMouseExited
        if(!RRbutton.isSelected()){
            RRbutton.setBackground(new Color(250, 250, 250));            
        }
    }//GEN-LAST:event_RRbuttonMouseExited

    private void SPNbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SPNbuttonMouseEntered
        if(!SPNbutton.isSelected()){
            SPNbutton.setBackground(new Color(255, 194, 133));            
        }
    }//GEN-LAST:event_SPNbuttonMouseEntered

    private void SPNbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SPNbuttonMouseExited
        if(!SPNbutton.isSelected()){
            SPNbutton.setBackground(new Color(250, 250, 250));            
        }
    }//GEN-LAST:event_SPNbuttonMouseExited

    private void SRTbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SRTbuttonMouseEntered
        if(!SRTbutton.isSelected()){
            SRTbutton.setBackground(new Color(255, 194, 133));            
        }
    }//GEN-LAST:event_SRTbuttonMouseEntered

    private void SRTbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SRTbuttonMouseExited
        if(!SRTbutton.isSelected()){
            SRTbutton.setBackground(new Color(250, 250, 250));            
        }
    }//GEN-LAST:event_SRTbuttonMouseExited

    private void HRRNbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HRRNbuttonMouseEntered
        if(!HRRNbutton.isSelected()){
            HRRNbutton.setBackground(new Color(255, 194, 133));            
        }
    }//GEN-LAST:event_HRRNbuttonMouseEntered

    private void HRRNbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HRRNbuttonMouseExited
        if(!HRRNbutton.isSelected()){
            HRRNbutton.setBackground(new Color(250, 250, 250));            
        }
    }//GEN-LAST:event_HRRNbuttonMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CPU1Panel;
    private javax.swing.JPanel CPU2Panel;
    private javax.swing.JPanel CPU3Panel;
    private javax.swing.JToggleButton FCFSbutton;
    private javax.swing.JToggleButton HRRNbutton;
    private javax.swing.JToggleButton RRbutton;
    private javax.swing.JLabel SO1;
    private javax.swing.JLabel SO2;
    private javax.swing.JLabel SO3;
    private javax.swing.JToggleButton SPNbutton;
    private javax.swing.JToggleButton SRTbutton;
    private javax.swing.JTable blockedQueueArea;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JTable completedProcessArea;
    private javax.swing.JLabel idCpu1;
    private javax.swing.JLabel idCpu2;
    private javax.swing.JLabel idCpu3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel marCpu1;
    private javax.swing.JLabel marCpu2;
    private javax.swing.JLabel marCpu3;
    private javax.swing.JLabel nameCpu1;
    private javax.swing.JLabel nameCpu2;
    private javax.swing.JLabel nameCpu3;
    private javax.swing.JLabel pcCpu1;
    private javax.swing.JLabel pcCpu2;
    private javax.swing.JLabel pcCpu3;
    private javax.swing.JProgressBar progressBar1;
    private javax.swing.JProgressBar progressBar2;
    private javax.swing.JProgressBar progressBar3;
    private javax.swing.JTable readyQueueArea;
    private javax.swing.JLabel statusCpu1;
    private javax.swing.JLabel statusCpu2;
    private javax.swing.JLabel statusCpu3;
    private javax.swing.JLabel tick;
    // End of variables declaration//GEN-END:variables
   
}
