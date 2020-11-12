
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class AgendaCliente extends javax.swing.JInternalFrame {

    private void pegarResolucao() {
        //Faz a tela pegar o tamanho inteiro 
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension dimensao = t.getScreenSize();
        this.setSize((dimensao.width), (dimensao.height));

        //Elimina as bordas do Frame Interno
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null); //retirar o painel superior janela.setBorder(null);//retirar bordas

        //Define a cor verde para os padrões
        UIManager.put("nimbusSelectionBackground", new Color(9, 82, 82));//define a cor dos menus da CB
        UIManager.put("nimbusFocus", new Color(9, 82, 82)); //Define a cor das seleções
        UIManager.put("nimbusSelection", new Color(9, 82, 82)); //Define a cor das seleções
        UIManager.put("nimbusInfoBlue", new Color(9, 82, 82)); //Define a cor das seleções
    }

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

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setNumRows(0);

            while (resultado.next()) {
                model.addRow(new Object[]{
                    //retorna os dados da tabela do BD, cada campo e um coluna.
                    resultado.getString("nomcli"),
                    resultado.getString("cpf"),
                    resultado.getString("horario"),
                    resultado.getString("dia"),
                    resultado.getString("nomcat")

                });
            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }

    public AgendaCliente() {
        initComponents();
        pegarResolucao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabelCategoria = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelCategoria1 = new javax.swing.JLabel();
        jLabelCategoria2 = new javax.swing.JLabel();
        data1 = new javax.swing.JFormattedTextField();
        data2 = new javax.swing.JFormattedTextField();
        teste = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        nome = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_sesi_topo2.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(9, 82, 82));
        jLabel1.setText("Agenda do Cliente");

        jButton3.setBackground(new java.awt.Color(9, 82, 82));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Buscar");
        jButton3.setNextFocusableComponent(nome);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton3KeyReleased(evt);
            }
        });

        jLabelCategoria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCategoria.setForeground(new java.awt.Color(9, 82, 82));
        jLabelCategoria.setText("Nome do Cliente:");

        jLabelCategoria1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCategoria1.setForeground(new java.awt.Color(9, 82, 82));
        jLabelCategoria1.setText("De:");

        jLabelCategoria2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCategoria2.setForeground(new java.awt.Color(9, 82, 82));
        jLabelCategoria2.setText("Até:");

        try {
            data1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        data1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        data1.setNextFocusableComponent(data2);

        try {
            data2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        data2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        data2.setNextFocusableComponent(jButton3);

        teste.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "CPF", "Horario", "Dia", "Treino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
        }

        nome.setEditable(true);
        nome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(teste, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1039, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabelCategoria)
                .addGap(18, 18, 18)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabelCategoria1)
                .addGap(18, 18, 18)
                .addComponent(data1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabelCategoria2)
                .addGap(18, 18, 18)
                .addComponent(data2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teste, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCategoria2)
                    .addComponent(data2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCategoria))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (data2.getText().equals("  /  /    ")) { //Verifica se o campo de Data Final (data2) está vazio e procura no banco só a data1
            this.PopularJTable("(select a.nomcli,a.cpf, b.hormf as horario,  to_char (c.dia, 'DD/MM/YYYY') dia, d.nomcat\n"
                    + "from cliente a, agendamentomf b, agendacliente c, categoria d\n"
                    + "where a.codcli = c.codcli\n"
                    + "and b.codagemf = c.codagemf\n"
                    + "and b.codcat = d.codcat\n"
                    + "and c.dia between '" + data1.getText() + "' and '" + data1.getText() + "'\n"
                    + "and a.nomcli ilike '%" + nome.getSelectedItem() + "%')\n"
                    + "union all\n"
                    + "(select a.nomcli,a.cpf, b.hormc as horario, to_char (c.dia, 'DD/MM/YYYY')dia, d.nomcat\n"
                    + "from cliente a, agendamentomc b, agendacliente c, categoria d\n"
                    + "where a.codcli = c.codcli\n"
                    + "and b.codagemc = c.codagemc\n"
                    + "and b.codcat = d.codcat\n"
                    + "and c.dia between '" + data1.getText() + "' and '" + data1.getText() + "'\n"
                    + "and a.nomcli ilike '%" + nome.getSelectedItem() + "%')\n"
                    + "order by dia\n"
                    + ";");
        } else {
            this.PopularJTable("(select a.nomcli,a.cpf, b.hormf as horario,  to_char (c.dia, 'DD/MM/YYYY') dia, d.nomcat\n"
                    + "from cliente a, agendamentomf b, agendacliente c, categoria d\n"
                    + "where a.codcli = c.codcli\n"
                    + "and b.codagemf = c.codagemf\n"
                    + "and b.codcat = d.codcat\n"
                    + "and c.dia between '" + data1.getText() + "' and '" + data2.getText() + "'\n"
                    + "and a.nomcli ilike '%" + nome.getSelectedItem() + "%')\n"
                    + "union all\n"
                    + "(select a.nomcli,a.cpf, b.hormc as horario, to_char (c.dia, 'DD/MM/YYYY')dia, d.nomcat\n"
                    + "from cliente a, agendamentomc b, agendacliente c, categoria d\n"
                    + "where a.codcli = c.codcli\n"
                    + "and b.codagemc = c.codagemc\n"
                    + "and b.codcat = d.codcat\n"
                    + "and c.dia between '" + data1.getText() + "' and '" + data2.getText() + "'\n"
                    + "and a.nomcli ilike '%" + nome.getSelectedItem() + "%')\n"
                    + "order by dia\n"
                    + ";");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (data2.getText().equals("  /  /    ")) {
                this.PopularJTable("(select a.nomcli,a.cpf, b.hormf as horario,  to_char (c.dia, 'DD/MM/YYYY') dia, d.nomcat\n"
                        + "from cliente a, agendamentomf b, agendacliente c, categoria d\n"
                        + "where a.codcli = c.codcli\n"
                        + "and b.codagemf = c.codagemf\n"
                        + "and b.codcat = d.codcat\n"
                        + "and c.dia between '" + data1.getText() + "' and '" + data1.getText() + "'\n"
                        + "and a.nomcli ilike '%" + nome.getSelectedItem() + "%')\n"
                        + "union all\n"
                        + "(select a.nomcli,a.cpf, b.hormc as horario, to_char (c.dia, 'DD/MM/YYYY')dia, d.nomcat\n"
                        + "from cliente a, agendamentomc b, agendacliente c, categoria d\n"
                        + "where a.codcli = c.codcli\n"
                        + "and b.codagemc = c.codagemc\n"
                        + "and b.codcat = d.codcat\n"
                        + "and c.dia between '" + data1.getText() + "' and '" + data1.getText() + "'\n"
                        + "and a.nomcli ilike '%" + nome.getSelectedItem() + "%')\n"
                        + "order by dia\n"
                        + ";");
            } else {
                this.PopularJTable("(select a.nomcli,a.cpf, b.hormf as horario,  to_char (c.dia, 'DD/MM/YYYY') dia, d.nomcat\n"
                        + "from cliente a, agendamentomf b, agendacliente c, categoria d\n"
                        + "where a.codcli = c.codcli\n"
                        + "and b.codagemf = c.codagemf\n"
                        + "and b.codcat = d.codcat\n"
                        + "and c.dia between '" + data1.getText() + "' and '" + data2.getText() + "'\n"
                        + "and a.nomcli ilike '%" + nome.getSelectedItem() + "%')\n"
                        + "union all\n"
                        + "(select a.nomcli,a.cpf, b.hormc as horario, to_char (c.dia, 'DD/MM/YYYY')dia, d.nomcat\n"
                        + "from cliente a, agendamentomc b, agendacliente c, categoria d\n"
                        + "where a.codcli = c.codcli\n"
                        + "and b.codagemc = c.codagemc\n"
                        + "and b.codcat = d.codcat\n"
                        + "and c.dia between '" + data1.getText() + "' and '" + data2.getText() + "'\n"
                        + "and a.nomcli ilike '%" + nome.getSelectedItem() + "%')\n"
                        + "order by dia\n"
                        + ";");
            }
        }
    }//GEN-LAST:event_jButton3KeyReleased

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        conexao.AgendaClienteComboBox();
    }//GEN-LAST:event_nomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField data1;
    private javax.swing.JFormattedTextField data2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelCategoria1;
    private javax.swing.JLabel jLabelCategoria2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    public static javax.swing.JComboBox<String> nome;
    public static javax.swing.JLabel teste;
    // End of variables declaration//GEN-END:variables
}
