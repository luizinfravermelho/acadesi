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

    public static void CidadeComboBoxCliente() {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        String a = (String) CadastroCliente.estado.getSelectedItem();
        String sql = "select nomcid from cidade where codest = (select codest from estado where nomest like '" + a + "') order by nomcid";
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
        String sql = "select nomcat from categoria where codcat != 5 order by nomcat";
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
                CadastroCliente.estado.addItem(resultado.getString(1));
                CadastroCliente.estado.updateUI();

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

            String nome = CadastroCliente.nome.getText();
            String cpf = CadastroCliente.cpf.getText();
            String email = CadastroCliente.email.getText();
            String cep = CadastroCliente.cep.getText();
            String rua = CadastroCliente.rua.getText();
            String bairro = CadastroCliente.bairro.getText();
            String numero = CadastroCliente.numero.getText();
            String telefone = CadastroCliente.telefone.getText();
            String complemento = CadastroCliente.complemento.getText();
            String bla = (String) CadastroCliente.senha.getText();
            String dia = (String) CadastroCliente.dia.getSelectedItem();
            String mes = (String) CadastroCliente.mes.getSelectedItem();
            String ano = (String) CadastroCliente.ano.getSelectedItem();
            String genero = (String) CadastroCliente.genero.getSelectedItem();
            String empresa = (String) CadastroCliente.empresa.getSelectedItem();
            String cidade = (String) CadastroCliente.cidade.getSelectedItem();
            String tipo = (String) CadastroCliente.tipo.getSelectedItem();
            String categoria = (String) CadastroCliente.categoria.getSelectedItem();
            String classificacao = (String) CadastroCliente.classificacao.getSelectedItem();

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

            String cnpj = CadastroCliente.cnpjemp.getText();
            String nome = CadastroCliente.empresaemp.getText();
            String telefone = CadastroCliente.telemp.getText();

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
                CadastroCliente.empresa.addItem(resultado.getString(1));
                CadastroCliente.empresa.updateUI();

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

            String categoria = (String) CadastroTreinos.jComboBox3.getSelectedItem();
            Date dia = CadastroTreinos.dia.getDate();

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

            String categoria = (String) CadastroTreinos.jComboBox3.getSelectedItem();
            Date dia = CadastroTreinos.dia.getDate();

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

            String categoria = (String) CadastroTreinos.jComboBoxDialogHorario.getSelectedItem();

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
                    String Update = "update horariomc set horariomcini = '" + HorIni + "', horariomcfim ='" + HorFim + "' where horariomcini = '" + CadastroTreinos.HorIniUpd + "' and horariomcfim ='" + CadastroTreinos.HorFimUpd + "'";
                    System.out.println(Update);
                    stmt.executeUpdate(Update);
                } else {
                    String Update = "update horariomf set horariomfini = '" + HorIni + "', horariomffim ='" + HorFim + "' where horariomfini = '" + CadastroTreinos.HorIniUpd + "' and horariomffim ='" + CadastroTreinos.HorFimUpd + "'";
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

            String categoria = AgendaTreinos.JDcat.getText();

            if (op == 1) {
                if (categoria == "Musculação") {
                    String Insert = "insert into agendacliente values((select codcli from cliente where cpf like '" + cpf + "'), \n"
                            + "'" + dia + "',(select codagemc from agendamentomc where dia = '" + dia + "' and hormc like '" + hor + "'),null);";
                    stmt.executeUpdate(Insert);

                } else {
                    String Insert = "insert into agendacliente values((select codcli from cliente where cpf like '" + cpf + "'), \n"
                            + "'" + dia + "',null,(select codagemf from agendamentomf where dia = '" + dia + "' and hormf like '" + hor + "'));";
                    stmt.executeUpdate(Insert);

                }

            } else if (op == 2) {

                String Delete = "delete from agendacliente where codcli= (select codcli from cliente where cpf like '" + cpf + "') \n"
                        + "and dia='" + dia+ "';" ;
                System.out.println(Delete);
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
