
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class ConsultaCliente extends javax.swing.JFrame {

    public static String cod;
    
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

            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setNumRows(0);

            while (resultado.next()) {
                model.addRow(new Object[]{
                    //retorna os dados da tabela do BD, cada campo e um coluna.
                    resultado.getString("cpf"),
                    resultado.getString("nomcli"),
                    resultado.getString("celular"),
                    resultado.getString("nomcat")
                    
                  
                });
            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }
    
    public ConsultaCliente() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        cpf = new javax.swing.JLabel();
        cliente = new javax.swing.JLabel();
        cidade = new javax.swing.JLabel();
        endereco = new javax.swing.JLabel();
        datnas = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        telefone = new javax.swing.JLabel();
        categoria = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        clientede = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        classi = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        procura = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        musc = new javax.swing.JRadioButton();
        pila = new javax.swing.JRadioButton();
        livre = new javax.swing.JRadioButton();
        todos = new javax.swing.JRadioButton();
        codigo = new javax.swing.JLabel();
        yoga = new javax.swing.JRadioButton();
        func = new javax.swing.JRadioButton();
        conv = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();

        jDialog1.setMinimumSize(new java.awt.Dimension(500, 500));
        jDialog1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                jDialog1WindowOpened(evt);
            }
        });

        jPanel2.setMinimumSize(new java.awt.Dimension(400, 400));

        jLabel2.setText("Estado:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Nome:");

        jLabel5.setText("Cidade:");

        jLabel7.setText("Endereço:");

        jLabel8.setText("Data de Nascimento:");

        jLabel9.setText("Email:");

        jLabel10.setText("Telefone:");

        jLabel12.setText("Categoria");

        estado.setText("jLabel13");

        cpf.setText("jLabel14");

        cliente.setText("jLabel15");

        cidade.setText("jLabel16");

        endereco.setText("jLabel17");

        datnas.setText("jLabel18");

        email.setText("jLabel19");

        telefone.setText("jLabel20");

        categoria.setText("jLabel22");

        jLabel11.setText("Cliente de:");

        jLabel13.setText("Tipo:");

        jLabel14.setText("Classificação:");

        clientede.setText("jLabel15");

        tipo.setText("jLabel16");

        classi.setText("jLabel17");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classi)
                    .addComponent(tipo)
                    .addComponent(clientede)
                    .addComponent(categoria)
                    .addComponent(telefone)
                    .addComponent(email)
                    .addComponent(datnas)
                    .addComponent(endereco)
                    .addComponent(cidade)
                    .addComponent(cliente)
                    .addComponent(cpf)
                    .addComponent(estado))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(estado))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cpf))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cliente))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cidade))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(endereco))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(datnas))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(email))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(telefone))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(categoria))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(clientede))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tipo))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(classi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jRadioButton2.setText("jRadioButton2");

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Cliente", "Telefone", "Categoria"
            }
        ));
        tabela.setSelectionBackground(new java.awt.Color(50, 194, 128));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabelaMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        procura.setBackground(new java.awt.Color(255, 255, 255));
        procura.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        procura.setForeground(new java.awt.Color(50, 194, 128));
        procura.setText("Procurar");
        procura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procuraActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(50, 194, 128));
        jLabel1.setText("Categoria:");

        musc.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(musc);
        musc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        musc.setForeground(new java.awt.Color(50, 194, 128));
        musc.setText("Musculação");

        pila.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(pila);
        pila.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pila.setForeground(new java.awt.Color(50, 194, 128));
        pila.setText("Pilates");

        livre.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(livre);
        livre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        livre.setForeground(new java.awt.Color(50, 194, 128));
        livre.setText("Livre");

        todos.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(todos);
        todos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        todos.setForeground(new java.awt.Color(50, 194, 128));
        todos.setText("Todos");

        codigo.setFont(new java.awt.Font("Tahoma", 0, 3)); // NOI18N
        codigo.setForeground(new java.awt.Color(240, 240, 240));
        codigo.setText("jLabel11");

        yoga.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(yoga);
        yoga.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        yoga.setForeground(new java.awt.Color(50, 194, 128));
        yoga.setText("Yoga");

        func.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(func);
        func.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        func.setForeground(new java.awt.Color(50, 194, 128));
        func.setText("Funcional");

        conv.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(conv);
        conv.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        conv.setForeground(new java.awt.Color(50, 194, 128));
        conv.setText("Conv. Bem Estar");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sesi_Logo.png"))); // NOI18N
        jLabel15.setText("jLabel15");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(musc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addComponent(pila)
                                .addGap(4, 4, 4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(func)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(conv)
                                .addGap(48, 48, 48)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yoga)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(livre)))
                        .addGap(3, 3, 3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(112, 112, 112)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(codigo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(todos))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(procura)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(procura))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 42, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yoga)
                            .addComponent(todos)
                            .addComponent(conv)
                            .addComponent(func))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pila)
                                .addComponent(livre))
                            .addComponent(musc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.PopularJTable("select a.cpf, a.nomcli, a.celular, b.nomcat from cliente a, categoria b where a.codcat=b.codcat;");
        
    }//GEN-LAST:event_formWindowOpened

    private void procuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procuraActionPerformed
        if (musc.isSelected()) {
            this.PopularJTable("select a.cpf, a.nomcli, a.celular, b.nomcat from cliente a, categoria b where a.codcat=b.codcat and b.nomcat ilike '%Musculacao%'");
                    }
         if (pila.isSelected()) {
            this.PopularJTable("select a.cpf, a.nomcli, a.celular, b.nomcat from cliente a, categoria b where a.codcat=b.codcat and b.nomcat ilike '%Pilates%'");
                    }
         if (livre.isSelected()) {
            this.PopularJTable("select a.cpf, a.nomcli, a.celular, b.nomcat from cliente a, categoria b where a.codcat=b.codcat and b.nomcat ilike '%Livre%'");
                    }
         if (func.isSelected()) {
            this.PopularJTable("select a.cpf, a.nomcli, a.celular, b.nomcat from cliente a, categoria b where a.codcat=b.codcat and b.nomcat ilike '%Funcional%'");
                    }
         if (yoga.isSelected()) {
            this.PopularJTable("select a.cpf, a.nomcli, a.celular, b.nomcat from cliente a, categoria b where a.codcat=b.codcat and b.nomcat ilike '%Yoga%'");
                    }
         if (conv.isSelected()) {
            this.PopularJTable("select a.cpf, a.nomcli, a.celular, b.nomcat from cliente a, categoria b where a.codcat=b.codcat and b.nomcat ilike '%Conv. Bem Estar%'");
                    }
         
         if (todos.isSelected()) {
            this.PopularJTable("select a.cpf, a.nomcli, a.celular, b.nomcat from cliente a, categoria b where a.codcat=b.codcat");
                    }
         
    }//GEN-LAST:event_procuraActionPerformed

    private void jDialog1WindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog1WindowOpened
      
    }//GEN-LAST:event_jDialog1WindowOpened

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        int selectedRow = tabela.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
       
        cod = model.getValueAt(selectedRow, 0).toString();
        
        jDialog1.setVisible(true);  
        conexao.PesquisaCliente();
        System.out.println(cod);
    }//GEN-LAST:event_tabelaMouseClicked

    private void tabelaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaMouseEntered

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
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JLabel categoria;
    public static javax.swing.JLabel cidade;
    public static javax.swing.JLabel classi;
    public static javax.swing.JLabel cliente;
    public static javax.swing.JLabel clientede;
    public static javax.swing.JLabel codigo;
    private javax.swing.JRadioButton conv;
    public static javax.swing.JLabel cpf;
    public static javax.swing.JLabel datnas;
    public static javax.swing.JLabel email;
    public static javax.swing.JLabel endereco;
    public static javax.swing.JLabel estado;
    private javax.swing.JRadioButton func;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton livre;
    private javax.swing.JRadioButton musc;
    private javax.swing.JRadioButton pila;
    private javax.swing.JButton procura;
    private javax.swing.JTable tabela;
    public static javax.swing.JLabel telefone;
    public static javax.swing.JLabel tipo;
    private javax.swing.JRadioButton todos;
    private javax.swing.JRadioButton yoga;
    // End of variables declaration//GEN-END:variables
}
