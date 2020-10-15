import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Luiz Felipe
 */
public class AgendaTreinos extends javax.swing.JFrame {

    public void PopularJTable(String sql) {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);

            while (resultado.next()) {
                model.addRow(new Object[]{
                    //retorna os dados da tabela do BD, cada campo e um coluna.
                    resultado.getString("dia"),
                    resultado.getString("horario"),
                    resultado.getString("pessoas"),
                    resultado.getString("categoria"),});
            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }  //********** FIM DO MÉTODO PARA PUXAR DADOS DO BANCO **********//

     public boolean data(String data, String datab) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(data);
            sdf.parse(datab);

            if (datab.compareTo(data) < 0) {
                JOptionPane.showMessageDialog(null, "Intervalo inválido! Insira um intervalo com número de dias igual a 0 ou maior");
                data1.setText(null);
                data2.setText(null);
            } else {
                if (jComboBoxSala.getSelectedItem().equals("Musculação")) {

                    if (jTable1.getColumnCount() == 4) {
                        jTable1.removeColumn(jTable1.getColumnModel().getColumn(3));
                    }

                    this.PopularJTable("select to_char(a.dia, 'DD/MM/YYYY') as dia, b.horariomc as horario, (15-a.qtdpesmc)||'/15' as pessoas, c.nomcat as categoria\n"
                            + "from agendamentomc a, horariomc b, categoria c \n"
                            + "where a.codhormc = b.codhormc and a.codcat = c.codcat\n"
                            + "and a.dia >='" + data + "'\n"
                            + "and a.dia <='" + datab + "' order by dia, horario;");
                } else {

                    if (jComboBox3.getSelectedItem().equals("Todos")) {
                        if (jTable1.getColumnCount() == 3) {
                            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                            model.fireTableStructureChanged();
                        }
                        this.PopularJTable("select to_char(a.dia, 'DD/MM/YYYY') as dia, b.horariomf as horario, (15-a.qtdpesmf)||'/15' as pessoas, c.nomcat as categoria \n"
                                + "from agendamentomf a, horariomf b, categoria c\n"
                                + "where a.codhormf = b.codhormf and a.codcat = c.codcat\n"
                                + "and a.dia >='" + data + "'\n"
                                + "and a.dia <='" + datab + "' order by dia, horario;");
                    } else {

                        if (jTable1.getColumnCount() == 4) {
                            jTable1.removeColumn(jTable1.getColumnModel().getColumn(3));
                        }

                        this.PopularJTable("select to_char(a.dia, 'DD/MM/YYYY') as dia, b.horariomf as horario, (15-a.qtdpesmf)||'/15' as pessoas, c.nomcat as categoria \n"
                                + "from agendamentomf a, horariomf b, categoria c\n"
                                + "where a.codhormf = b.codhormf and a.codcat = c.codcat\n"
                                + "and a.dia >='" + data + "'\n"
                                + "and a.dia <='" + datab + "' and c.nomcat ilike '" + jComboBox3.getSelectedItem() + "' order by dia, horario;");

                    }

                }
            }

            System.out.println(jTable1.getColumnCount());
            return true;
        } catch (ParseException ex) {
            //se algum passo dentro do "try" der errado quer dizer que sua data é falsa, então,
            //retorna falso
            data1.setText(null);
            data2.setText(null);
            JOptionPane.showMessageDialog(null, "Insira um valor de data válido");

            return false;

        }
    }

    public AgendaTreinos() {
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
        jComboBoxSala = new javax.swing.JComboBox<String>();
        jLabelCategoria1 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<String>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelCategoria2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        data1 = new javax.swing.JFormattedTextField();
        jLabelCategoria3 = new javax.swing.JLabel();
        data2 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();

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

        jComboBoxSala.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBoxSala.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Musculação", "Multifuncional" }));
        jComboBoxSala.setSelectedItem(null);
        jComboBoxSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSalaActionPerformed(evt);
            }
        });

        jLabelCategoria1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCategoria1.setForeground(new java.awt.Color(50, 194, 128));
        jLabelCategoria1.setText("Categoria:");

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox3.setSelectedItem(null);

        jLabelCategoria2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCategoria2.setForeground(new java.awt.Color(50, 194, 128));
        jLabelCategoria2.setText("De:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia", "Horário", "Pessoas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        try {
            data1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        data1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabelCategoria3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCategoria3.setForeground(new java.awt.Color(50, 194, 128));
        jLabelCategoria3.setText("Até:");

        try {
            data2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        data2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabelCategoria)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxSala, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addContainerGap(71, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelCategoria2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(data1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCategoria3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(data2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCategoria)
                    .addComponent(jComboBoxSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCategoria1)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCategoria2)
                    .addComponent(data1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCategoria3)
                    .addComponent(data2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
if (jTable1.getColumnCount() == 4) {
            jTable1.removeColumn(jTable1.getColumnModel().getColumn(3));
        }

    }//GEN-LAST:event_formWindowOpened

    private void jComboBoxSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSalaActionPerformed

        if (jComboBoxSala.getSelectedItem().equals("Musculação")) {

            jComboBox3.addItem("Musculação");
            jComboBox3.removeItem("Conv. Bem estar");
            jComboBox3.removeItem("Funcional");
            jComboBox3.removeItem("Pilates");
            jComboBox3.removeItem("Yoga");
            jComboBox3.removeItem("Todos");
            jComboBox3.updateUI();

        } else if (jComboBoxSala.getSelectedItem().equals("Multifuncional")) {

            jComboBox3.addItem("Conv. Bem estar");
            jComboBox3.addItem("Funcional");
            jComboBox3.addItem("Pilates");
            jComboBox3.addItem("Yoga");
            jComboBox3.addItem("Todos");
            jComboBox3.setSelectedItem("Todos");

            jComboBox3.removeItem("Musculação");
            jComboBox3.updateUI();

        }


    }//GEN-LAST:event_jComboBoxSalaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.data(data1.getText(), data2.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            JOptionPane.showMessageDialog(null, "Deu clique duplo? Quer verificar esse horario?");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgendaTreinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendaTreinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendaTreinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendaTreinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendaTreinos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JFormattedTextField data1;
    private javax.swing.JFormattedTextField data2;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    public static javax.swing.JComboBox<String> jComboBox3;
    public static javax.swing.JComboBox<String> jComboBoxSala;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelCategoria1;
    private javax.swing.JLabel jLabelCategoria2;
    private javax.swing.JLabel jLabelCategoria3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel sair;
    // End of variables declaration//GEN-END:variables
}
