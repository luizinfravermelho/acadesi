
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
//bom dia
//boa noite, Pachequitos

public class conexao {

    public static void CidadeComboBoxCliente() {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        String a = (String) TelaCadastroCliente.estado.getSelectedItem();
        String sql = "select nomcid from cidade where codest = (select codest from estado where nomest like '" + a + "') order by nomcid";
        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {
                TelaCadastroCliente.cidade.addItem(resultado.getString(1));
                TelaCadastroCliente.cidade.updateUI();

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
        String sql = "select nomcat from categoria where codcat != 5 order by nomcat";
        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {
                TelaCadastroCliente.categoria.addItem(resultado.getString(1));
                TelaCadastroCliente.categoria.updateUI();

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
        String cod = (String) ConsultaCliente.cod;
        String sql = "select a.nomcli, a.cpf, b.nomcid, c.nomest, a.endereco, a.datnas, a.email, a.celular, d.nomcat, e.nomemp, a.tipo, a.classificacao, a.cep from cliente a, cidade b, estado c, categoria d, empresa e where a.codcat=d.codcat and b.codcid=a.codcid and b.codest=c.codest and a.codemp = e.codemp and a.codcli = (select codcli from cliente where cpf like '" + cod + "');";

        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {
                ConsultaCliente.estado.setText(resultado.getString(4));
                ConsultaCliente.estado.updateUI();
                ConsultaCliente.cpf.setText(resultado.getString(2));
                ConsultaCliente.cpf.updateUI();
                ConsultaCliente.cliente.setText(resultado.getString(1));
                ConsultaCliente.cliente.updateUI();
                ConsultaCliente.cidade.setText(resultado.getString(3));
                ConsultaCliente.cidade.updateUI();
                ConsultaCliente.endereco.setText(resultado.getString(5));
                ConsultaCliente.endereco.updateUI();
                ConsultaCliente.datnas.setText(resultado.getString(6));
                ConsultaCliente.datnas.updateUI();
                ConsultaCliente.email.setText(resultado.getString(7));
                ConsultaCliente.email.updateUI();
                ConsultaCliente.telefone.setText(resultado.getString(8));
                ConsultaCliente.telefone.updateUI();
                ConsultaCliente.categoria.setText(resultado.getString(9));
                ConsultaCliente.categoria.updateUI();
                ConsultaCliente.tipo.setText(resultado.getString(11));
                ConsultaCliente.tipo.updateUI();
                ConsultaCliente.empresa.setText(resultado.getString(10));
                ConsultaCliente.empresa.updateUI();
                ConsultaCliente.classi.setText(resultado.getString(12));
                ConsultaCliente.classi.updateUI();
                ConsultaCliente.CEP.setText(resultado.getString(12));
                ConsultaCliente.CEP.updateUI();
            }
            banco.close();

            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }

    public static void nomcliLabel() {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        String a = (String) AlteracaoSenha.cpf.getText();
        String sql = "select nomcli from cliente where cpf like '" + a + "';";

        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {

                AlteracaoSenha.nome.setText(resultado.getString(1));
                AlteracaoSenha.nome.updateUI();

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

            String cpf = AlteracaoSenha.cpf.getText();
            String sen = AlteracaoSenha.senha.getText();

            String Insert = "update cliente set senha =" + sen + " where codcli =( select codcli from cliente where cpf like '" + cpf + "');";

            stmt.executeUpdate(Insert);

            con.close();

        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
    }//OK

    public static void EstadoComboBoxCliente() {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        String sql = "select nomest from estado order by nomest";
        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {
                TelaCadastroCliente.estado.addItem(resultado.getString(1));
                TelaCadastroCliente.estado.updateUI();

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

            String nome = TelaCadastroCliente.nome.getText();
            String cpf = TelaCadastroCliente.cpf.getText();
            String email = TelaCadastroCliente.email.getText();
            String cep = TelaCadastroCliente.cep.getText();
            String rua = TelaCadastroCliente.rua.getText();
            String bairro = TelaCadastroCliente.bairro.getText();
            String numero = TelaCadastroCliente.numero.getText();
            String telefone = TelaCadastroCliente.telefone.getText();
            String complemento = TelaCadastroCliente.complemento.getText();
            String bla = (String) TelaCadastroCliente.senha.getText();
            String dia = (String) TelaCadastroCliente.dia.getSelectedItem();
            String mes = (String) TelaCadastroCliente.mes.getSelectedItem();
            String ano = (String) TelaCadastroCliente.ano.getSelectedItem();
            String genero = (String) TelaCadastroCliente.genero.getSelectedItem();
            String empresa = (String) TelaCadastroCliente.empresa.getSelectedItem();
            String cidade = (String) TelaCadastroCliente.cidade.getSelectedItem();
            String tipo = (String) TelaCadastroCliente.tipo.getSelectedItem();
            String categoria = (String) TelaCadastroCliente.categoria.getSelectedItem();
            String classificacao = (String) TelaCadastroCliente.classificacao.getSelectedItem();

            String Insert = "insert into cliente values ((select coalesce (max(codcli),0)+1 from cliente),(select codcid from cidade where nomcid like'" + cidade + "'),(select codcat from categoria where nomcat like '" + categoria + "'),(select codemp from empresa where nomemp like '" + empresa + "'),'" + cpf + "','" + tipo + "','" + nome + "','" + dia + "/" + mes + "/" + ano + "','" + genero + "','" + classificacao + "','" + email + "','" + telefone + "'," + bla + ",'" + cep + "','" + rua + ", " + bairro + ", " + numero + ", " + complemento + "');";

            stmt.executeUpdate(Insert);
            JOptionPane.showMessageDialog(null, "Dados inseridos!");

            con.close();

        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
    }

    public static void InsertEmpresaNova() {
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

            String cnpj = TelaCadastroCliente.cnpjemp.getText();
            String nome = TelaCadastroCliente.empresaemp.getText();
            String telefone = TelaCadastroCliente.telemp.getText();

            String Insert2 = "insert into empresa values ((select coalesce (max(codemp),0)+1 from empresa), '" + nome + "', '" + telefone + "', '" + cnpj + "')";

            stmt.executeUpdate(Insert2);

            JOptionPane.showMessageDialog(null, "Dados inseridos!");

            con.close();

        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
    }

    public static void EmpresaComboBoxCliente() {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        String sql = "select nomemp from empresa order by nomemp";
        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {
                TelaCadastroCliente.empresa.addItem(resultado.getString(1));
                TelaCadastroCliente.empresa.updateUI();

            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }

    public static void CadastroTreinosInsert(String Hor) {
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

            String categoria = (String) TelaCadastroTreinos.jComboBox3.getSelectedItem();
            Date dia = TelaCadastroTreinos.dia.getDate();

            if (dia == null) {
                JOptionPane.showMessageDialog(null, "Selecione um dia!");

            } else {

                if (categoria == "Musculação") {
                    String Insert = "insert into agendamentomc values ((select coalesce (max(codagemc),0)+1 from agendamentomc), \n"
                            + "'" + Hor + "',1,1,'" + dia + "',15);";
                    stmt.executeUpdate(Insert);
                } else {
                    String Insert = "insert into agendamentomf values ((select coalesce (max(codagemf),0)+1 from agendamentomf), \n"
                            + "'" + Hor + "',(select codcat from categoria where nomcat ilike '" + categoria + "'),1,'" + dia + "',15);";
                    stmt.executeUpdate(Insert);
                }
            }

            //JOptionPane.showMessageDialog(null, "Dados inseridos!");
            con.close();

        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
    }

    public static void CadastroTreinosDelete(String Hor) {
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

            String categoria = (String) TelaCadastroTreinos.jComboBox3.getSelectedItem();
            Date dia = TelaCadastroTreinos.dia.getDate();

            if (dia == null) {
                JOptionPane.showMessageDialog(null, "Selecione um dia!");

            } else {

                if (categoria == "Musculação") {
                    String Delete = "delete from agendamentomc where hormc= '" + Hor + "' and dia ='" + dia + "'";
                    stmt.executeUpdate(Delete);
                } else {
                    String Delete = "delete from agendamentomf where hormf ='" + Hor + "' and dia='" + dia + "'";
                    stmt.executeUpdate(Delete);
                }
            }

            //JOptionPane.showMessageDialog(null, "Dados inseridos!");
            con.close();

        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
    }

    public static void CadastroHorariosIDA(String HorIni, String HorFim, Integer op) {
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

            String categoria = (String) TelaCadastroTreinos.jComboBoxDialogHorario.getSelectedItem();

            if (op == 1) {
                if (categoria == "Musculação") {
                    String Insert = "insert into horariomc values((select coalesce (max(codhormc),0)+1 from horariomc),'" + HorIni + "','" + HorFim + "')";
                    stmt.executeUpdate(Insert);

                } else {
                    String Insert = "insert into horariomf values((select coalesce (max(codhormf),0)+1 from horariomf),'" + HorIni + "','" + HorFim + "')";
                    stmt.executeUpdate(Insert);

                }

            } else if (op == 2) {
                if (categoria == "Musculação") {
                    String Delete = "delete from horariomc where horariomcini = '" + HorIni + "' and horariomcfim ='" + HorFim + "'";
                    stmt.executeUpdate(Delete);
                } else {
                    String Delete = "delete from horariomf where horariomfini = '" + HorIni + "' and horariomffim ='" + HorFim + "'";
                    stmt.executeUpdate(Delete);
                }
            } else if (op == 3) {
                if (categoria == "Musculação") {
                    String Update = "update horariomc set horariomcini = '" + HorIni + "', horariomcfim ='" + HorFim + "' where horariomcini = '" + TelaCadastroTreinos.HorIniUpd + "' and horariomcfim ='" + TelaCadastroTreinos.HorFimUpd + "'";
                    System.out.println(Update);
                    stmt.executeUpdate(Update);
                } else {
                    String Update = "update horariomf set horariomfini = '" + HorIni + "', horariomffim ='" + HorFim + "' where horariomfini = '" + TelaCadastroTreinos.HorIniUpd + "' and horariomffim ='" + TelaCadastroTreinos.HorFimUpd + "'";
                    stmt.executeUpdate(Update);
                }
            }

            con.close();

        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
    }

    public static void AgendaAlunosIDA(String cpf, String dia, String hor, Integer op) {
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

            String categoria = TelaAgendaTreinos.JDcat.getText();

            if (op == 1) {
                if (categoria == "Musculação") {
                    String Insert = "insert into agendacliente values((select codcli from cliente where cpf like '" + cpf + "'), \n"
                            + "'" + dia + "',(select codagemc from agendamentomc where dia = '" + dia + "' and hormc like '" + hor + "'),null);";
                    System.out.println(Insert);
                    stmt.executeUpdate(Insert);
                    
                } else {
                    String Insert = "insert into agendacliente values((select codcli from cliente where cpf like '" + cpf + "'), \n"
                            + "'" + dia + "',null,(select codagemf from agendamentomf where dia = '" + dia + "' and hormf like '" + hor + "'));";
                    stmt.executeUpdate(Insert);
                    System.out.println(Insert);
                }

            } else if (op == 2) {

                String Delete = "delete from agendacliente where codcli= (select codcli from cliente where cpf like '" + cpf + "') \n"
                        + "and dia='" + dia+ "';" ;
                
                stmt.executeUpdate(Delete);
            }

            con.close();

        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Já existe um cadastro nesse dia para o aluno!");
            System.err.print(e.getMessage());
        }
    }
    

}
