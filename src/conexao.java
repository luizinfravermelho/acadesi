import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
 //bom dia
//boa noite, Pachequitos

public class conexao {

    public static void insertAgendamento() {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";

        try {
            Class.forName(driver);
            System.out.println("Driver carregado");
            Connection con = null;
            con = DriverManager.getConnection(url, user, senha);
            System.out.println("Conexão realizada com sucesso.");
            java.sql.Statement stmt = con.createStatement();

            String codcli = Agendamento.USU.getText();
            String dia = Agendamento.dia.getText();
            String hor = Agendamento.hor.getText();
            String cat = Agendamento.cat.getText();
            String codage = "select a.codage from agendamento a, horario b, categoria c where a.codhor = b.codhor and a.codcat = c.codcat and a.codhor = (select codhor from horario where horario like '" + hor + "') and a.codcat =  (select codcat from categoria where nomcat like '" + cat + "') and a.dia = '" + dia + "'";

            String Insert = "insert into agendacliente values (" + codcli + ", '" + dia + "', (" + codage + "))";
            System.out.println(Insert);
            String Insert2 = "update agendamento set qtdpes = qtdpes-1 where codage = (" + codage + ")";

            stmt.executeUpdate(Insert);
            stmt.executeUpdate(Insert2);
            //System.out.println(Insert);
            //System.out.println(Insert2);
            JOptionPane.showMessageDialog(null, "Agendamento feito com Sucesso!"); //Mensagem de confirmação para o usuário
            con.close();

        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Já há agendamentos para o dia selecionado");
        }
    }

    public static void dataComboBoxAgendamento() {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        String sql = "select dia from agendamento where dia >= CURRENT_DATE and dia < CURRENT_DATE+7 group by dia order by dia asc";

        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {

                Agendamento.jComboBox1.addItem(resultado.getString(1));
                Agendamento.jComboBox1.updateUI();

            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }

    public static void categoriaCliente() {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        String cod = Agendamento.USU.getText();
        String sql = "select codcat from cliente where codcli = " + cod;

        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {

                Agendamento.categoria.setText(resultado.getString(1));
                Agendamento.categoria.updateUI();

            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }

    public static void InsertCliente() {
        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";

        try {
            Class.forName(driver);
            System.out.println("Driver carregado");
            Connection con = null;
            con = DriverManager.getConnection(url, user, senha);
            System.out.println("Conexão realizada com sucesso.");

            Statement stmt = con.createStatement();

            String codcli = CadastroCliente.codcli.getText();
            String cpf = CadastroCliente.cpfcli.getText();
            String nome = CadastroCliente.nomcli.getText();
            String cidade = (String) CadastroCliente.cidade.getSelectedItem();
            String endereco = CadastroCliente.endcli.getText();
            String nascli = CadastroCliente.nascli.getText();
            String email = CadastroCliente.emacli.getText();
            String telefone = CadastroCliente.telcli.getText();
            String sencli = CadastroCliente.sencli.getText();
            String categoria = (String) CadastroCliente.categoria.getSelectedItem();

            String Insert = "insert into cliente values(" + codcli + ", '" + cpf + "', '" + nome + "',(select codcid from cidade where nomcid like'" + cidade + "'), '" + endereco + "', '" + nascli + "', '" + email + "', '" + telefone + "', " + sencli + ", (select codcat from categoria where nomcat like'" + categoria + "'));";

            System.out.println(Insert);
            stmt.executeUpdate(Insert);
            JOptionPane.showMessageDialog(null, "Dados inseridos!");

            CadastroCliente.codcli.setText("");
            CadastroCliente.cpfcli.setText("");
            CadastroCliente.nomcli.setText("");
            CadastroCliente.cidade.setSelectedItem(null);
            CadastroCliente.endcli.setText("");
            CadastroCliente.nascli.setText("");
            CadastroCliente.emacli.setText("");
            CadastroCliente.telcli.setText("");
            CadastroCliente.sencli.setText("");
            CadastroCliente.categoria.setSelectedItem(null);

            con.close();

        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }

    }

    public static void CidadeComboBoxCliente() {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        String sql = "select nomcid from cidade order by nomcid";
        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {
                CadastroCliente.cidade.addItem(resultado.getString(1));
                CadastroCliente.cidade.updateUI();

            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }

    public static void CategoriaComboBoxCliente() {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        String sql = "select nomcat from categoria order by nomcat";
        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {
                CadastroCliente.categoria.addItem(resultado.getString(1));
                CadastroCliente.categoria.updateUI();

            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }

    public static void PesquisaCliente() {

        //String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        String cod = (String) ConsultaCliente.codigo.getText();
        String sql = "select a.*, b.nomcid, c.nomcat from cliente a, cidade b, categoria c  where a.codcid = b.codcid and a.codcat = c.codcat and a.codcli =" + cod + "";

        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {
                ConsultaCliente.matricula.setText(resultado.getString(1));
                ConsultaCliente.matricula.updateUI();
                ConsultaCliente.cpf.setText(resultado.getString(2));
                ConsultaCliente.cpf.updateUI();
                ConsultaCliente.cliente.setText(resultado.getString(3));
                ConsultaCliente.cliente.updateUI();
                ConsultaCliente.cidade.setText(resultado.getString(11));
                ConsultaCliente.cidade.updateUI();
                ConsultaCliente.endereco.setText(resultado.getString(5));
                ConsultaCliente.endereco.updateUI();
                ConsultaCliente.datnas.setText(resultado.getString(6));
                ConsultaCliente.datnas.updateUI();
                ConsultaCliente.email.setText(resultado.getString(7));
                ConsultaCliente.email.updateUI();
                ConsultaCliente.telefone.setText(resultado.getString(8));
                ConsultaCliente.telefone.updateUI();
                ConsultaCliente.categoria.setText(resultado.getString(12));
                ConsultaCliente.categoria.updateUI();

            }
            banco.close();

            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }

    public static void nomeClienteComboBox() {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        String sql = "select nomcli from cliente;";

        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {

                AlteracaoSenha.nome.addItem(resultado.getString(1));
                AlteracaoSenha.nome.updateUI();

            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }

    public static void codigoClienteAlteracaoSenha() {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        String a = (String) AlteracaoSenha.nome.getSelectedItem();
        String sql = "select codcli from cliente where nomcli like '" + a + "';";

        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {

                AlteracaoSenha.codigo.setText(resultado.getString(1));
                AlteracaoSenha.codigo.updateUI();

            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }
    
     public static void updateSenha() {
        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";

        try {
            Class.forName(driver);
            System.out.println("Driver carregado");
            Connection con = null;
            con = DriverManager.getConnection(url, user, senha);
            System.out.println("Conexão realizada com sucesso.");

            Statement stmt = con.createStatement();

            String codigo = AlteracaoSenha.codigo.getText();
            String bla = AlteracaoSenha.senha.getText();
        

            String Insert = "update cliente set senha ="+bla+" where codcli ="+codigo+";";

            stmt.executeUpdate(Insert);

            con.close();

        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
    }//OK


}
