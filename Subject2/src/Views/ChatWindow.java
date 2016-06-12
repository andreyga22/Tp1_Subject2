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
        titlelabel.setText(userName);
        this.parent = parent;
        this.tree = tree;
        this.client = client;
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextNormal = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        titlelabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextcode = new javax.swing.JTextArea();
        jTextWrite = new javax.swing.JTextField();
        sendBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ChatWindow");
        setBackground(new java.awt.Color(184, 26, 26));
        setForeground(new java.awt.Color(184, 26, 26));

        jTextNormal.setColumns(20);
        jTextNormal.setRows(5);
        jScrollPane1.setViewportView(jTextNormal);

        jButton1.setText("Salir");
        jButton1.setName("btSalir"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        titlelabel.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        titlelabel.setText("label");

        jTextcode.setColumns(20);
        jTextcode.setRows(5);
        jScrollPane2.setViewportView(jTextcode);

        jTextWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextWriteActionPerformed(evt);
            }
        });

        sendBt.setText("Enviar");
        sendBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(titlelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextWrite, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(sendBt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextWrite, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendBt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextWriteActionPerformed
        
    }//GEN-LAST:event_jTextWriteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        parent.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sendBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtActionPerformed
        
    }//GEN-LAST:event_sendBtActionPerformed

    private void write(String text) {
        try {
            String code2 = "";
            for (int i = 0; i < text.length(); i++) {
                code2 += tree.findKey(text.charAt(i));
            }
            client.sendMessage(code2);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error en la escritura del codigo");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextNormal;
    private javax.swing.JTextField jTextWrite;
    private javax.swing.JTextArea jTextcode;
    private javax.swing.JButton sendBt;
    private javax.swing.JLabel titlelabel;
    // End of variables declaration//GEN-END:variables
}
