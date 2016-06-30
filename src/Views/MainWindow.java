/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Decode.DuplicatedElement;
import Decode.Tree;
import File.ReadFile;
import File.WriteFile;
import Main.Controller;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import objectssockets.Client;

/**
 *
 * @author andre
 */
public class MainWindow extends javax.swing.JFrame {

    private ReadFile read = new ReadFile();
    private static final int MAX_CHAR = 468;
    private Tree tree = new Tree();
    private Client client;

    public MainWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        fChooser1 = new javax.swing.JFileChooser();
        jPanel2 = new javax.swing.JPanel();
        connectBt = new javax.swing.JButton();
        exitBt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        IPField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        createKeyBt = new javax.swing.JButton();
        loadKeyBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MainWindow");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        connectBt.setBackground(new java.awt.Color(153, 113, 203));
        connectBt.setForeground(new java.awt.Color(255, 255, 204));
        connectBt.setText("Conectar");
        connectBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectBtActionPerformed(evt);
            }
        });

        exitBt.setBackground(new java.awt.Color(153, 113, 203));
        exitBt.setForeground(new java.awt.Color(255, 255, 204));
        exitBt.setText("Salir");
        exitBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtActionPerformed(evt);
            }
        });

        jLabel1.setText("Direccion IP");

        IPField.setText("localhost");
        IPField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IPFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel2.setText("Citara chat");

        createKeyBt.setBackground(new java.awt.Color(153, 113, 203));
        createKeyBt.setForeground(new java.awt.Color(255, 255, 255));
        createKeyBt.setText("Generar llave");
        createKeyBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createKeyBtActionPerformed(evt);
            }
        });

        loadKeyBt.setBackground(new java.awt.Color(153, 113, 203));
        loadKeyBt.setForeground(new java.awt.Color(255, 255, 255));
        loadKeyBt.setText("Cargar llave");
        loadKeyBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadKeyBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 162, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(IPField))
                            .addComponent(connectBt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createKeyBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadKeyBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createKeyBt))
                .addGap(18, 18, 18)
                .addComponent(loadKeyBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitBt)
                    .addComponent(connectBt))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IPFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IPFieldActionPerformed

    }//GEN-LAST:event_IPFieldActionPerformed

    private void exitBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBtActionPerformed

    private void connectBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectBtActionPerformed
        try {
            String ip = IPField.getText();
            if (IPField.getText().equals("")) {
                throw new IllegalArgumentException("Error ");
            }

            Controller controller = new Controller();
            client = new Client(ip, controller);
            client.runClient();
            this.dispose();
            controller.initializeChat(client, this, true, tree);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con el servidor");
        }
    }//GEN-LAST:event_connectBtActionPerformed

    private void createKeyBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createKeyBtActionPerformed
        createKey();
    }//GEN-LAST:event_createKeyBtActionPerformed

    private void loadKeyBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadKeyBtActionPerformed
        fChooser1.setCurrentDirectory(new java.io.File("."));
        int returnVal = fChooser1.showOpenDialog(this);
        fChooser1.setAcceptAllFileFilterUsed(false);
        if (returnVal == fChooser1.APPROVE_OPTION) {
            File file = fChooser1.getSelectedFile();
            readFromTheFile(file);
        }

    }//GEN-LAST:event_loadKeyBtActionPerformed

    public void readFromTheFile(File file) {
        try {
            read.open(file);
            readTree();
            read.close();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
    }

    private void readTree() throws IOException, ClassNotFoundException {

        tree = read.readTree();
    }

    public void createKey() {
        try {
            tree.createDictionaryAndTree();
            tree.writeInTheFile(new WriteFile());
        } catch (DuplicatedElement | IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IPField;
    private javax.swing.JButton connectBt;
    private javax.swing.JButton createKeyBt;
    private javax.swing.JButton exitBt;
    private javax.swing.JFileChooser fChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JButton loadKeyBt;
    // End of variables declaration//GEN-END:variables
}
