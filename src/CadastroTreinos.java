import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public void HorariosIguais(String sql) { //Busca os horários existentes da mesma categoria

        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();
            while (resultado.next()) {
                if (resultado.getString(1).equals(Hor1.getText())) {
                    Hor1.setSelected(true);
                }
                if (resultado.getString(1).equals(Hor2.getText())) {
                    Hor2.setSelected(true);
                }
                if (resultado.getString(1).equals(Hor3.getText())) {
                    Hor3.setSelected(true);
                }
                if (resultado.getString(1).equals(Hor4.getText())) {
                    Hor4.setSelected(true);
                }
                if (resultado.getString(1).equals(Hor5.getText())) {
                    Hor5.setSelected(true);
                }
                if (resultado.getString(1).equals(Hor6.getText())) {
                    Hor6.setSelected(true);
                }
                if (resultado.getString(1).equals(Hor7.getText())) {
                    Hor7.setSelected(true);
                }
                if (resultado.getString(1).equals(Hor8.getText())) {
                    Hor8.setSelected(true);
                }
                if (resultado.getString(1).equals(Hor9.getText())) {
                    Hor9.setSelected(true);
                }
                if (resultado.getString(1).equals(Hor10.getText())) {
                    Hor10.setSelected(true);
                }
                if (resultado.getString(1).equals(Hor11.getText())) {
                    Hor11.setSelected(true);
                }
                if (resultado.getString(1).equals(Hor12.getText())) {
                    Hor12.setSelected(true);
                }
                if (resultado.getString(1).equals(Hor13.getText())) {
                    Hor13.setSelected(true);
                }
                if (resultado.getString(1).equals(Hor14.getText())) {
                    Hor14.setSelected(true);
                }

            }

            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }  //********** FIM DO MÉTODO PARA PUXAR DADOS DO BANCO **********//

    public void HorariosDiferentes(String sql) { //Busca os horários existentes da outras categorias

        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();
            while (resultado.next()) {
                if (resultado.getString(1).equals(Hor1.getText())) {
                    Hor1.setSelected(true);
                    Hor1.setEnabled(false);
                }
                if (resultado.getString(1).equals(Hor2.getText())) {
                    Hor2.setSelected(true);
                    Hor2.setEnabled(false);
                }
                if (resultado.getString(1).equals(Hor3.getText())) {
                    Hor3.setSelected(true);
                    Hor3.setEnabled(false);
                }
                if (resultado.getString(1).equals(Hor4.getText())) {
                    Hor4.setSelected(true);
                    Hor4.setEnabled(false);
                }
                if (resultado.getString(1).equals(Hor5.getText())) {
                    Hor5.setSelected(true);
                    Hor5.setEnabled(false);
                }
                if (resultado.getString(1).equals(Hor6.getText())) {
                    Hor6.setSelected(true);
                    Hor6.setEnabled(false);
                }
                if (resultado.getString(1).equals(Hor7.getText())) {
                    Hor7.setSelected(true);
                    Hor7.setEnabled(false);
                }
                if (resultado.getString(1).equals(Hor8.getText())) {
                    Hor8.setSelected(true);
                    Hor8.setEnabled(false);
                }
                if (resultado.getString(1).equals(Hor9.getText())) {
                    Hor9.setSelected(true);
                    Hor9.setEnabled(false);
                }
                if (resultado.getString(1).equals(Hor10.getText())) {
                    Hor10.setSelected(true);
                    Hor10.setEnabled(false);
                }
                if (resultado.getString(1).equals(Hor11.getText())) {
                    Hor11.setSelected(true);
                    Hor11.setEnabled(false);
                }
                if (resultado.getString(1).equals(Hor12.getText())) {
                    Hor12.setSelected(true);
                    Hor12.setEnabled(false);
                }
                if (resultado.getString(1).equals(Hor13.getText())) {
                    Hor13.setSelected(true);
                    Hor13.setEnabled(false);
                }
                if (resultado.getString(1).equals(Hor14.getText())) {
                    Hor14.setSelected(true);
                    Hor14.setEnabled(false);
                }

            }

            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }  //********** FIM DO MÉTODO PARA PUXAR DADOS DO BANCO **********//

    public void LimpaHoras() {

        Hor1.setEnabled(true);
        Hor2.setEnabled(true);
        Hor3.setEnabled(true);
        Hor4.setEnabled(true);
        Hor5.setEnabled(true);
        Hor6.setEnabled(true);
        Hor7.setEnabled(true);
        Hor8.setEnabled(true);
        Hor9.setEnabled(true);
        Hor10.setEnabled(true);
        Hor11.setEnabled(true);
        Hor12.setEnabled(true);
        Hor13.setEnabled(true);
        Hor14.setEnabled(true);

        Hor1.setSelected(false);
        Hor2.setSelected(false);
        Hor3.setSelected(false);
        Hor4.setSelected(false);
        Hor5.setSelected(false);
        Hor6.setSelected(false);
        Hor7.setSelected(false);
        Hor8.setSelected(false);
        Hor9.setSelected(false);
        Hor10.setSelected(false);
        Hor11.setSelected(false);
        Hor12.setSelected(false);
        Hor13.setSelected(false);
        Hor14.setSelected(false);

    }

    public CadastroTreinos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
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
        jSeparator2 = new javax.swing.JSeparator();
        jLabelCategoria3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Hor1 = new javax.swing.JCheckBox();
        Hor2 = new javax.swing.JCheckBox();
        Hor3 = new javax.swing.JCheckBox();
        Hor4 = new javax.swing.JCheckBox();
        Hor5 = new javax.swing.JCheckBox();
        Hor6 = new javax.swing.JCheckBox();
        Hor7 = new javax.swing.JCheckBox();
        Hor14 = new javax.swing.JCheckBox();
        Hor13 = new javax.swing.JCheckBox();
        Hor12 = new javax.swing.JCheckBox();
        Hor11 = new javax.swing.JCheckBox();
        Hor10 = new javax.swing.JCheckBox();
        Hor9 = new javax.swing.JCheckBox();
        Hor8 = new javax.swing.JCheckBox();
        jComboBox4 = new javax.swing.JComboBox<String>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
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

        jLabelCategoria3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCategoria3.setForeground(new java.awt.Color(50, 194, 128));
        jLabelCategoria3.setText("Horários");

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("+");

        Hor1.setBackground(new java.awt.Color(255, 255, 255));

        Hor2.setBackground(new java.awt.Color(255, 255, 255));

        Hor3.setBackground(new java.awt.Color(255, 255, 255));

        Hor4.setBackground(new java.awt.Color(255, 255, 255));

        Hor5.setBackground(new java.awt.Color(255, 255, 255));
        Hor5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hor5ActionPerformed(evt);
            }
        });

        Hor6.setBackground(new java.awt.Color(255, 255, 255));
        Hor6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hor6ActionPerformed(evt);
            }
        });

        Hor7.setBackground(new java.awt.Color(255, 255, 255));
        Hor7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hor7ActionPerformed(evt);
            }
        });

        Hor14.setBackground(new java.awt.Color(255, 255, 255));
        Hor14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hor14ActionPerformed(evt);
            }
        });

        Hor13.setBackground(new java.awt.Color(255, 255, 255));
        Hor13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hor13ActionPerformed(evt);
            }
        });

        Hor12.setBackground(new java.awt.Color(255, 255, 255));
        Hor12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hor12ActionPerformed(evt);
            }
        });

        Hor11.setBackground(new java.awt.Color(255, 255, 255));

        Hor10.setBackground(new java.awt.Color(255, 255, 255));

        Hor9.setBackground(new java.awt.Color(255, 255, 255));

        Hor8.setBackground(new java.awt.Color(255, 255, 255));

        jComboBox4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira" }));
        jComboBox4.setSelectedItem(null);
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                                .addContainerGap(20, Short.MAX_VALUE))))
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
                    .addComponent(Hor2)
                    .addComponent(Hor1)
                    .addComponent(Hor3)
                    .addComponent(Hor4)
                    .addComponent(Hor5)
                    .addComponent(Hor6)
                    .addComponent(Hor7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Hor9)
                    .addComponent(Hor8)
                    .addComponent(Hor10)
                    .addComponent(Hor11)
                    .addComponent(Hor12)
                    .addComponent(Hor13)
                    .addComponent(Hor14))
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
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCategoria3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Hor1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Hor2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Hor3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Hor4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Hor5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Hor6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Hor7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Hor8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Hor9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Hor10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Hor11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Hor12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Hor13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Hor14)))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked

        dispose(); //Fecha a janela
        new Login().setVisible(true); //Abre a tela de Login
    }//GEN-LAST:event_sairMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Hor1.setVisible(false);
        Hor2.setVisible(false);
        Hor3.setVisible(false);
        Hor4.setVisible(false);
        Hor5.setVisible(false);
        Hor6.setVisible(false);
        Hor7.setVisible(false);
        Hor8.setVisible(false);
        Hor9.setVisible(false);
        Hor10.setVisible(false);
        Hor11.setVisible(false);
        Hor12.setVisible(false);
        Hor13.setVisible(false);
        Hor14.setVisible(false);

    }//GEN-LAST:event_formWindowOpened

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

        if (jComboBox2.getSelectedItem().equals("Musculação")) {

            jComboBox3.addItem("Musculação");
            this.LimpaHoras();
            jComboBox3.removeItem("Conv. Bem estar");
            jComboBox3.removeItem("Funcional");
            jComboBox3.removeItem("Pilates");
            jComboBox3.removeItem("Yoga");
            jComboBox3.updateUI();

        } else if (jComboBox2.getSelectedItem().equals("Multifuncional")) {

            jComboBox3.addItem("Conv. Bem estar");
            jComboBox3.addItem("Funcional");
            jComboBox3.addItem("Pilates");
            jComboBox3.addItem("Yoga");
            this.LimpaHoras();
            jComboBox3.setSelectedItem("Conv. Bem estar");

            jComboBox3.removeItem("Musculação");
            jComboBox3.updateUI();

        }


    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed


    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        this.LimpaHoras();

        if (jComboBox3.getSelectedItem().equals("Musculação")) {
            //HABILITA TODOS OS HORÁRIOS
            Hor1.setVisible(true);
            Hor2.setVisible(true);
            Hor3.setVisible(true);
            Hor4.setVisible(true);
            Hor5.setVisible(true);
            Hor6.setVisible(true);
            Hor7.setVisible(true);
            Hor8.setVisible(true);
            Hor9.setVisible(true);
            Hor10.setVisible(true);
            Hor11.setVisible(true);
            Hor12.setVisible(true);
            Hor13.setVisible(true);
            Hor14.setVisible(true);
            //CONFIGURA AS HORAS
            Hor1.setText("06:30-07:15");
            Hor2.setText("07:30-08:15");
            Hor3.setText("08:30-09:15");
            Hor4.setText("09:30-10:15");
            Hor5.setText("11:30-12:15");
            Hor6.setText("12:30-13:15");
            Hor7.setText("13:30-14:15");
            Hor8.setText("14:30-15:15");
            Hor9.setText("16:00-16:45");
            Hor10.setText("17:00-17:45");
            Hor11.setText("18:00-18:45");
            Hor12.setText("19:00-19:45");
            Hor13.setText("20:00-20:45");
            Hor14.setText("21:00-21:45");

        } else {
            //HABILITA TODOS OS HORÁRIOS
            Hor1.setVisible(true);
            Hor2.setVisible(true);
            Hor3.setVisible(true);
            Hor8.setVisible(true);
            Hor9.setVisible(true);
            Hor10.setVisible(true);
            Hor11.setVisible(true);

            //CONFIGURA AS HORAS
            Hor1.setText("07:00-07:45");
            Hor2.setText("08:00-08:45");
            Hor3.setText("09:00-09:45");
            Hor4.setVisible(false);
            Hor5.setVisible(false);
            Hor6.setVisible(false);
            Hor7.setVisible(false);
            Hor8.setText("16:00-16:45");
            Hor9.setText("18:00-18:45");
            Hor10.setText("19:00-19:45");
            Hor11.setText("20:00-20:45");
            Hor12.setVisible(false);
            Hor13.setVisible(false);
            Hor14.setVisible(false);
        }
        String dia;
        dia = (String) jComboBox4.getSelectedItem();

        jComboBox4.setSelectedItem(null);
        jComboBox4.setSelectedItem(dia);


    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void Hor5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hor5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Hor5ActionPerformed

    private void Hor6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hor6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Hor6ActionPerformed

    private void Hor7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hor7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Hor7ActionPerformed

    private void Hor14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hor14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Hor14ActionPerformed

    private void Hor13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hor13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Hor13ActionPerformed

    private void Hor12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hor12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Hor12ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged

        this.LimpaHoras();
        String dow = ""; //SALVA O DIA DA SEMANA (Day Of Week)

        if (jComboBox4.getSelectedItem() != null) {

            if (jComboBox4.getSelectedItem().equals("Segunda-feira")) {
                dow = "1";
            } else if (jComboBox4.getSelectedItem().equals("Terça-feira")) {
                dow = "2";
            } else if (jComboBox4.getSelectedItem().equals("Quarta-feira")) {
                dow = "3";
            } else if (jComboBox4.getSelectedItem().equals("Quinta-feira")) {
                dow = "4";
            } else if (jComboBox4.getSelectedItem().equals("Sexta-feira")) {
                dow = "5";
            }

            if (jComboBox3.getSelectedItem().equals("Musculação")) {
                this.HorariosIguais("select a.horariomc from horariomc a, agendamentomc b, categoria c where a.codhormc = b.codhormc and b.codcat = c.codcat and c.codcat=(select codcat from categoria where nomcat ilike 'Musc%')  and b.dia >= CURRENT_DATE and (select extract(dow from b.dia))=" + dow);
            } else {
                this.HorariosIguais("select a.horariomf from horariomf a, agendamentomf b, categoria c where a.codhormf = b.codhormf and b.codcat = c.codcat and c.codcat=(select codcat from categoria where nomcat ilike '" + jComboBox3.getSelectedItem() + "')  and b.dia >= CURRENT_DATE and (select extract(dow from b.dia))=" + dow);
                this.HorariosDiferentes("select a.horariomf from horariomf a, agendamentomf b, categoria c where a.codhormf = b.codhormf and b.codcat = c.codcat and c.codcat!=(select codcat from categoria where nomcat ilike '" + jComboBox3.getSelectedItem() + "')  and b.dia >= CURRENT_DATE and (select extract(dow from b.dia))=" + dow);

            }
        }

    }//GEN-LAST:event_jComboBox4ItemStateChanged

    public static void main(String args[]) {

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
    private javax.swing.JCheckBox Hor1;
    private javax.swing.JCheckBox Hor10;
    private javax.swing.JCheckBox Hor11;
    private javax.swing.JCheckBox Hor12;
    private javax.swing.JCheckBox Hor13;
    private javax.swing.JCheckBox Hor14;
    private javax.swing.JCheckBox Hor2;
    private javax.swing.JCheckBox Hor3;
    private javax.swing.JCheckBox Hor4;
    private javax.swing.JCheckBox Hor5;
    private javax.swing.JCheckBox Hor6;
    private javax.swing.JCheckBox Hor7;
    private javax.swing.JCheckBox Hor8;
    private javax.swing.JCheckBox Hor9;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    public static javax.swing.JComboBox<String> jComboBox2;
    public static javax.swing.JComboBox<String> jComboBox3;
    public static javax.swing.JComboBox<String> jComboBox4;
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
