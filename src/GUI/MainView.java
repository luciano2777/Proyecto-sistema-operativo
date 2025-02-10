
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import CPUScheduler.CalcSimulation;
import CPUScheduler.Job;
import static GUI.CreateProcessView.NumInstructions;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class MainView extends javax.swing.JFrame {
    private int xMouse;
    private int yMouse;
    private final SimulationView simulationView = new SimulationView();
    private final CreateProcessView createProcessView = new CreateProcessView();
    private final settingsView settingsView = new settingsView();
    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        this.setVisible(true);
        buttonGroup.add(createProcessButton);
        buttonGroup.add(settingsButton);
        buttonGroup.add(SimulationButton);
        
        simulationView.setSize(660, 420);
        simulationView.setLocation(0, 0);
        settingsView.setSize(660, 420);
        settingsView.setLocation(0, 0);
        createProcessView.setSize(660, 420);
        createProcessView.setLocation(0, 0);
        
        SimulationButton.setSelected(true);
        bodyPanel.add(simulationView, BorderLayout.CENTER);
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        topPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JPanel();
        closeLabel = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JPanel();
        minimizeLabel = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        createProcessButton = new javax.swing.JToggleButton();
        pauseButton = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JToggleButton();
        SimulationButton = new javax.swing.JToggleButton();
        bodyPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topPanel.setBackground(new java.awt.Color(255, 255, 255));
        topPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                topPanelMouseDragged(evt);
            }
        });
        topPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                topPanelMousePressed(evt);
            }
        });
        topPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closeButton.setBackground(new java.awt.Color(255, 255, 255));
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButtonMouseExited(evt);
            }
        });
        closeButton.setLayout(new java.awt.GridBagLayout());

        closeLabel.setText("x");
        closeButton.add(closeLabel, new java.awt.GridBagConstraints());

        topPanel.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 30, 30));

        minimizeButton.setBackground(new java.awt.Color(255, 255, 255));
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseExited(evt);
            }
        });
        minimizeButton.setLayout(new java.awt.GridBagLayout());

        minimizeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        minimizeLabel.setText("-");
        minimizeButton.add(minimizeLabel, new java.awt.GridBagConstraints());

        topPanel.add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 30, 30));

        getContentPane().add(topPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 30));

        leftPanel.setBackground(new java.awt.Color(204, 204, 204));
        leftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        createProcessButton.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        createProcessButton.setText("Crear Proceso");
        createProcessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProcessButtonActionPerformed(evt);
            }
        });
        leftPanel.add(createProcessButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 100, 50));

        pauseButton.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        pauseButton.setText("Parar");
        leftPanel.add(pauseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 80, -1));

        finishButton.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        finishButton.setText("Terminar");
        leftPanel.add(finishButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 80, -1));

        startButton.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        startButton.setText("Iniciar ");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        leftPanel.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 80, -1));

        settingsButton.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        settingsButton.setText("Configuracion");
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });
        leftPanel.add(settingsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 100, 50));

        SimulationButton.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        SimulationButton.setText("Simulacion");
        SimulationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimulationButtonActionPerformed(evt);
            }
        });
        leftPanel.add(SimulationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 50));

        getContentPane().add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 100, 420));

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        getContentPane().add(bodyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 660, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseEntered
        closeButton.setBackground(Color.red);
        closeLabel.setForeground(Color.white);
    }//GEN-LAST:event_closeButtonMouseEntered

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        this.dispose();
        closeButton.setBackground(Color.white);
        closeLabel.setForeground(Color.black);
    }//GEN-LAST:event_closeButtonMouseClicked

    private void closeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseExited
        closeButton.setBackground(Color.white);
        closeLabel.setForeground(Color.black);
    }//GEN-LAST:event_closeButtonMouseExited

    private void minimizeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseEntered
        minimizeButton.setBackground(Color.red);
        minimizeLabel.setForeground(Color.white);
    }//GEN-LAST:event_minimizeButtonMouseEntered

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        this.setState(JFrame.ICONIFIED);
        closeButton.setBackground(Color.white);
        closeLabel.setForeground(Color.black);
    }//GEN-LAST:event_minimizeButtonMouseClicked

    private void minimizeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseExited
        minimizeButton.setBackground(Color.white);
        minimizeLabel.setForeground(Color.black);
    }//GEN-LAST:event_minimizeButtonMouseExited

    private void topPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_topPanelMousePressed

    private void topPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_topPanelMouseDragged

    private void createProcessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProcessButtonActionPerformed
        createProcessView.setSize(660, 420);
        createProcessView.setLocation(0, 0);
        
        bodyPanel.removeAll();
        bodyPanel.add(createProcessView, BorderLayout.CENTER);
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }//GEN-LAST:event_createProcessButtonActionPerformed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        settingsView.setSize(660, 420);
        settingsView.setLocation(0, 0);
        
        bodyPanel.removeAll();
        bodyPanel.add(settingsView, BorderLayout.CENTER);
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void SimulationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimulationButtonActionPerformed
        simulationView.setSize(660, 420);
        simulationView.setLocation(0, 0);
        
        bodyPanel.removeAll();
        bodyPanel.add(simulationView, BorderLayout.CENTER);
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }//GEN-LAST:event_SimulationButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("Iniciando");
//        if(sourcePath.isEmpty()) //Meter el sourcepath
//            JOptionPane.showMessageDialog(null, "ERROR: Please input the source of computation");
        
         if(NumInstructions <= 0)
            JOptionPane.showMessageDialog(null, "ERROR: Por favor introduzca la cantidad correcta de procesos");
        else { //Aquí se ejecuta el codigo si todas las anteriores condiciones se cumplieron.
            Job[] jobs = new Job[NumInstructions];       
            String SelectedAlgo = "FCFS";
            for(int i = 1; i <= NumInstructions; i++) {
                String processID = "P"+i;
                long arrivalTime = (new java.util.Random().nextInt(9) + 1) * 300;
                long burstTime = (new java.util.Random().nextInt(3) + 1) * 100;
                long STRTTIME = System.nanoTime();
                
                Job newJob = new Job(processID, arrivalTime, burstTime, STRTTIME);
                jobs[(i-1)] = newJob;
            }
                CalcSimulation sim = new CalcSimulation(jobs, NumInstructions, "text", SelectedAlgo);
            sim.start();
            this.dispose();
            
        }
    }//GEN-LAST:event_startButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton SimulationButton;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JPanel closeButton;
    private javax.swing.JLabel closeLabel;
    private javax.swing.JToggleButton createProcessButton;
    private javax.swing.JButton finishButton;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel minimizeButton;
    private javax.swing.JLabel minimizeLabel;
    private javax.swing.JButton pauseButton;
    private javax.swing.JToggleButton settingsButton;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
