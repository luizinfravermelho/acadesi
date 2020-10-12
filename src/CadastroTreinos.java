import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Luiz Felipe
 */
public class CadastroTreinos extends javax.swing.JFrame {

    /**
     * Creates new form CadastroTreinos
     */
    public CadastroTreinos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        sair = new javax.swing.JLabel();
        jLabelCategoria = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<String>();
        jLabelCategoria1 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<String>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelCategoria2 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelCategoria3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        HorM1 = new javax.swing.JCheckBox();
        HorM2 = new javax.swing.JCheckBox();
        HorM3 = new javax.swing.JCheckBox();
        HorM4 = new javax.swing.JCheckBox();
        HorM5 = new javax.swing.JCheckBox();
        HorM6 = new javax.swing.JCheckBox();
        HorM7 = new javax.swing.JCheckBox();
        HorV7 = new javax.swing.JCheckBox();
        HorV6 = new javax.swing.JCheckBox();
        HorV5 = new javax.swing.JCheckBox();
        HorV4 = new javax.swing.JCheckBox();
        HorV3 = new javax.swing.JCheckBox();
        HorV2 = new javax.swing.JCheckBox();
        HorV1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sesi_Logo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(50, 194, 128));
        jLabel1.setText("Treinos");

        sair.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sair.setForeground(new java.awt.Color(50, 194, 128));
        sair.setText("Sair");
        sair.setToolTipText("");
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        jLabelCategoria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCategoria.setForeground(new java.awt.Color(50, 194, 128));
        jLabelCategoria.setText("Sala:");

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Musculação", "Multifuncional" }));
        jComboBox2.setSelectedItem(null);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabelCategoria1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCategoria1.setForeground(new java.awt.Color(50, 194, 128));
        jLabelCategoria1.setText("Categoria:");

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox3.setSelectedItem(null);
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabelCategoria2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCategoria2.setForeground(new java.awt.Color(50, 194, 128));
        jLabelCategoria2.setText("Dia da semana:");

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("Segunda-feira");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setText("Terça-feira");

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setText("Quarta-feira");

        jCheckBox8.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox8.setText("Quinta-feira");

        jCheckBox9.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox9.setText("Sexta-feira");

        jLabelCategoria3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCategoria3.setForeground(new java.awt.Color(50, 194, 128));
        jLabelCategoria3.setText("Horários");

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("+");

        HorM1.setBackground(new java.awt.Color(255, 255, 255));
        HorM1.setText("jCheckBox1");

        HorM2.setBackground(new java.awt.Color(255, 255, 255));
        HorM2.setText("jCheckBox1");

        HorM3.setBackground(new java.awt.Color(255, 255, 255));
        HorM3.setText("jCheckBox1");

        HorM4.setBackground(new java.awt.Color(255, 255, 255));
        HorM4.setText("jCheckBox1");

        HorM5.setBackground(new java.awt.Color(255, 255, 255));
        HorM5.setText("jCheckBox1");
        HorM5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorM5ActionPerformed(evt);
            }
        });

        HorM6.setBackground(new java.awt.Color(255, 255, 255));
        HorM6.setText("jCheckBox1");
        HorM6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorM6ActionPerformed(evt);
            }
        });

        HorM7.setBackground(new java.awt.Color(255, 255, 255));
        HorM7.setText("jCheckBox1");
        HorM7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorM7ActionPerformed(evt);
            }
        });

        HorV7.setBackground(new java.awt.Color(255, 255, 255));
        HorV7.setText("jCheckBox1");
        HorV7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorV7ActionPerformed(evt);
            }
        });

        HorV6.setBackground(new java.awt.Color(255, 255, 255));
        HorV6.setText("jCheckBox1");
        HorV6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorV6ActionPerformed(evt);
            }
        });

        HorV5.setBackground(new java.awt.Color(255, 255, 255));
        HorV5.setText("jCheckBox1");
        HorV5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorV5ActionPerformed(evt);
            }
        });

        HorV4.setBackground(new java.awt.Color(255, 255, 255));
        HorV4.setText("jCheckBox1");

        HorV3.setBackground(new java.awt.Color(255, 255, 255));
        HorV3.setText("jCheckBox1");

        HorV2.setBackground(new java.awt.Color(255, 255, 255));
        HorV2.setText("jCheckBox1");

        HorV1.setBackground(new java.awt.Color(255, 255, 255));
        HorV1.setText("jCheckBox1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelCategoria2)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox2)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox6)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox7)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox8)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox9)
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabelCategoria)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                .addGap(80, 80, 80)
                                .addComponent(jLabel1)
                                .addGap(9, 9, 9)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(sair)
                                .addGap(154, 154, 154))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelCategoria1)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabelCategoria3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HorM2)
                    .addComponent(HorM1)
                    .addComponent(HorM3)
                    .addComponent(HorM4)
                    .addComponent(HorM5)
                    .addComponent(HorM6)
                    .addComponent(HorM7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HorV2)
                    .addComponent(HorV1)
                    .addComponent(HorV3)
                    .addComponent(HorV4)
                    .addComponent(HorV5)
                    .addComponent(HorV6)
                    .addComponent(HorV7))
                .addGap(131, 131, 131))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(sair))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCategoria)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelCategoria1)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCategoria2)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCategoria3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(HorM1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HorM2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HorM3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HorM4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HorM5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HorM6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HorM7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(HorV1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HorV2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HorV3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HorV4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HorV5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HorV6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HorV7)))
                .addContainerGap(196, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked

        dispose(); //Fecha a janela
        new Login().setVisible(true); //Abre a tela de Login
    }//GEN-LAST:event_sairMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        HorM1.setVisible(false);
        HorM2.setVisible(false);
        HorM3.setVisible(false);
        HorM4.setVisible(false);
        HorM5.setVisible(false);
        HorM6.setVisible(false);
        HorM7.setVisible(false);
        HorV1.setVisible(false);
        HorV2.setVisible(false);
        HorV3.setVisible(false);
        HorV4.setVisible(false);
        HorV5.setVisible(false);
        HorV6.setVisible(false);
        HorV7.setVisible(false);

    }//GEN-LAST:event_formWindowOpened

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        if (jComboBox2.getSelectedItem().equals("Musculação")) {
            jComboBox3.addItem("Musculação");
            jComboBox3.removeItem("Cons. Bem estar");
            jComboBox3.removeItem("Funcional");
            jComboBox3.removeItem("Pilates");
            jComboBox3.removeItem("Yoga");
            jComboBox3.updateUI();
        } else if (jComboBox2.getSelectedItem().equals("Multifuncional")) {

            jComboBox3.addItem("Cons. Bem estar");
            jComboBox3.addItem("Funcional");
            jComboBox3.addItem("Pilates");
            jComboBox3.addItem("Yoga");
            jComboBox3.setSelectedItem("Cons. Bem estar");
            jComboBox3.removeItem("Musculação");
            jComboBox3.updateUI();
        }


    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed


    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed

    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged

        if (jComboBox3.getSelectedItem().equals("Musculação")) {
            //HABILITA TODOS OS HORÁRIOS
            HorM1.setVisible(true);
            HorM2.setVisible(true);
            HorM3.setVisible(true);
            HorM4.setVisible(true);
            HorM5.setVisible(true);
            HorM6.setVisible(true);
            HorM7.setVisible(true);
            HorV1.setVisible(true);
            HorV2.setVisible(true);
            HorV3.setVisible(true);
            HorV4.setVisible(true);
            HorV5.setVisible(true);
            HorV6.setVisible(true);
            HorV7.setVisible(true);
            
            //CONFIGURA AS HORAS
            HorM1.setText("06:30 - 07:15");
            HorM2.setText("07:30 - 08:15");
            HorM3.setText("08:30 - 09:15");
            HorM4.setText("09:30 - 10:15");
            HorM5.setText("11:30 - 12:15");
            HorM6.setText("12:30 - 13:15");
            HorM7.setText("13:30 - 14:15");
            HorV1.setText("14:30 - 15:15");
            HorV2.setText("16:00 - 16:45");
            HorV3.setText("17:00 - 17:45");
            HorV4.setText("18:00 - 18:45");
            HorV5.setText("19:00 - 19:45");
            HorV6.setText("20:00 - 20:45");
            HorV7.setText("21:00 - 21:45");

        } else {
            //HABILITA TODOS OS HORÁRIOS
            HorM1.setVisible(true);
            HorM2.setVisible(true);
            HorM3.setVisible(true);
            HorV1.setVisible(true);
            HorV2.setVisible(true);
            HorV3.setVisible(true);
            HorV4.setVisible(true);
            
            //CONFIGURA AS HORAS
            HorM1.setText("07:00 - 07:45");
            HorM2.setText("08:00 - 08:45");
            HorM3.setText("09:00 - 09:55");
            HorM4.setVisible(false);
            HorM5.setVisible(false);
            HorM6.setVisible(false);
            HorM7.setVisible(false);
            HorV1.setText("16:00 - 16:45");
            HorV2.setText("17:00 - 17:45");
            HorV3.setText("18:00 - 18:45");
            HorV4.setText("19:00 - 19:45");
            HorV5.setVisible(false);
            HorV6.setVisible(false);
            HorV7.setVisible(false);
        }
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void HorM5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorM5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HorM5ActionPerformed

    private void HorM6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorM6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HorM6ActionPerformed

    private void HorM7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorM7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HorM7ActionPerformed

    private void HorV7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorV7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HorV7ActionPerformed

    private void HorV6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorV6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HorV6ActionPerformed

    private void HorV5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorV5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HorV5ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroTreinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroTreinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroTreinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroTreinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroTreinos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox HorM1;
    private javax.swing.JCheckBox HorM2;
    private javax.swing.JCheckBox HorM3;
    private javax.swing.JCheckBox HorM4;
    private javax.swing.JCheckBox HorM5;
    private javax.swing.JCheckBox HorM6;
    private javax.swing.JCheckBox HorM7;
    private javax.swing.JCheckBox HorV1;
    private javax.swing.JCheckBox HorV2;
    private javax.swing.JCheckBox HorV3;
    private javax.swing.JCheckBox HorV4;
    private javax.swing.JCheckBox HorV5;
    private javax.swing.JCheckBox HorV6;
    private javax.swing.JCheckBox HorV7;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    public static javax.swing.JComboBox<String> jComboBox2;
    public static javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelCategoria1;
    private javax.swing.JLabel jLabelCategoria2;
    private javax.swing.JLabel jLabelCategoria3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel sair;
    // End of variables declaration//GEN-END:variables
}
