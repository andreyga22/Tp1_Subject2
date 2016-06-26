/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Decode.Tree;
import java.awt.Frame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objectssockets.Client;

/**
 *
 * @author andre
 */
public class ChatWindow extends javax.swing.JDialog {

    /**
     * Creates new form ChatWindow
     */
    private final String userName;
    private final Frame parent;
    private final Tree tree;
    private final Client client;

    public ChatWindow(java.awt.Frame parent, boolean modal, String userName, Tree tree, Client client) {
        super(parent, modal);
        initComponents();
        this.userName = userName;
        titlelabel.setText("Hablando con el servidor");
        this.parent = parent;
        this.tree = tree;
        this.client = client;
        this.setLocationRelativeTo(null);
        jTextcode.setEditable(false);
        jTextNormal.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextNormal = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextcode = new javax.swing.JTextArea();
        titlelabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        sendBt = new javax.swing.JButton();
        jTextWrite = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ChatWindow");
        setBackground(new java.awt.Color(184, 26, 26));
        setForeground(new java.awt.Color(184, 26, 26));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextNormal.setColumns(20);
        jTextNormal.setRows(5);
        jScrollPane1.setViewportView(jTextNormal);

        jTextcode.setColumns(20);
        jTextcode.setRows(5);
        jScrollPane2.setViewportView(jTextcode);

        titlelabel.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        titlelabel.setText("label");

        jButton1.setBackground(new java.awt.Color(153, 113, 203));
        jButton1.setText("Salir");
        jButton1.setName("btSalir"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        sendBt.setBackground(new java.awt.Color(153, 113, 203));
        sendBt.setText("Enviar");
        sendBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtActionPerformed(evt);
            }
        });

        jTextWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextWriteActionPerformed(evt);
            }
        });

        jLabel3.setText("Hexadecimal");

        jLabel4.setText(":D");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(titlelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jTextWrite, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(sendBt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextWrite, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendBt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        client.closeConnection();
        parent.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sendBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtActionPerformed
        try {
            if (!jTextWrite.getText().equals("")) {
                String text = jTextWrite.getText();
                jTextNormal.setText(jTextNormal.getText() + "\nCliente: " + text);
                String codedText = tree.encode(text);
                jTextcode.setText(jTextcode.getText() + "\nCliente: " + codedText);
                client.sendMessage(codedText);
                jTextWrite.setText("");
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_sendBtActionPerformed

    private void jTextWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextWriteActionPerformed

    }//GEN-LAST:event_jTextWriteActionPerformed

    public void read(String text) {
        jTextcode.setText(jTextcode.getText() + "\nServidor: " + text);
        String aux = decode(text);
        jTextNormal.setText(jTextNormal.getText() + "\nServidor: " + aux);
    }

    private String decode(String text) {
        return tree.decode(text);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextNormal;
    private javax.swing.JTextField jTextWrite;
    private javax.swing.JTextArea jTextcode;
    private javax.swing.JButton sendBt;
    private javax.swing.JLabel titlelabel;
    // End of variables declaration//GEN-END:variables
}
