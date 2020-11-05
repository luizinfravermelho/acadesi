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
        String sql = "select nomcat from categoria ";
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
        String cod = (String) TelaConsultaCliente.cod;
        String sql = "select to_char (a.ana, 'DD/MM/YYYY') as ana, to_char (a.datnas, 'DD/MM/YYYY') as datnas,  a.nomcli, a.cpf, b.nomcid, c.nomest, a.endereco, a.email, a.celular, d.nomcat, e.nomemp, a.tipo, a.classificacao, a.cep,  a.obs, a.genero from cliente a, cidade b, estado c, categoria d, empresa e where a.codcat=d.codcat and b.codcid=a.codcid and b.codest=c.codest and a.codemp = e.codemp and a.codcli = (select codcli from cliente where cpf like '"+cod+"');";

        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {
                AlteracaoCliente.estado.setSelectedItem(resultado.getString(6));
                AlteracaoCliente.estado.updateUI();
                AlteracaoCliente.cpf.setText(resultado.getString(4));
                AlteracaoCliente.cpf.updateUI();
                AlteracaoCliente.nome.setText(resultado.getString(3));//ok
                AlteracaoCliente.nome.updateUI();
                AlteracaoCliente.cidade.setSelectedItem(resultado.getString(5));
                AlteracaoCliente.cidade.updateUI();
                AlteracaoCliente.end.setText(resultado.getString(7));
                AlteracaoCliente.end.updateUI();
                AlteracaoCliente.datnas.setText(resultado.getString(2));//ok
                AlteracaoCliente.datnas.updateUI();//ok
                AlteracaoCliente.email.setText(resultado.getString(8));
                AlteracaoCliente.email.updateUI();
                AlteracaoCliente.tel.setText(resultado.getString(9));
                AlteracaoCliente.tel.updateUI();
                AlteracaoCliente.cate.setSelectedItem(resultado.getString(10));
                AlteracaoCliente.cate.updateUI();
                AlteracaoCliente.tipo.setSelectedItem(resultado.getString(12));
                AlteracaoCliente.tipo.updateUI();
                AlteracaoCliente.emp.setSelectedItem(resultado.getString(11));
                AlteracaoCliente.emp.updateUI();
                AlteracaoCliente.cla.setSelectedItem(resultado.getString(13));
                AlteracaoCliente.cla.updateUI();
                AlteracaoCliente.cep.setText(resultado.getString(14));
                AlteracaoCliente.cep.updateUI();
                AlteracaoCliente.ana.setText(resultado.getString(1));//ok
                AlteracaoCliente.ana.updateUI();//ok
                AlteracaoCliente.obs.setText(resultado.getString(15));
                AlteracaoCliente.obs.updateUI();
                AlteracaoCliente.gen.setSelectedItem(resultado.getString(16));
                AlteracaoCliente.gen.updateUI();

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
        String a = (String) TelaAlteracaoSenha.cpf.getText();
        String sql = "select nomcli from cliente where cpf like '" + a + "';";

        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {

                TelaAlteracaoSenha.nome.setText(resultado.getString(1));
                TelaAlteracaoSenha.nome.updateUI();

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

            String cpf = TelaAlteracaoSenha.cpf.getText();
            String sen = TelaAlteracaoSenha.senha.getText();

            String Insert = "update cliente set senha =" + sen + " where codcli =( select codcli from cliente where cpf like '" + cpf + "');";

            stmt.executeUpdate(Insert);

            con.close();

        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
    }

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
            String ana = TelaCadastroCliente.ana.getText();
            String obs = TelaCadastroCliente.obs.getText();

            String Insert = "insert into cliente values ((select coalesce (max(codcli),0)+1 from cliente),(select codcid from cidade where nomcid like'" + cidade + "'),(select codcat from categoria where nomcat like '" + categoria + "'),(select codemp from empresa where nomemp like '" + empresa + "'),'" + cpf + "','" + tipo + "','" + nome + "','" + dia + "/" + mes + "/" + ano + "','" + genero + "','" + classificacao + "','" + email + "','" + telefone + "'," + bla + ",'" + cep + "','" + rua + "," + bairro + "," + numero + "," + complemento + "','" + ana + "','" + obs + "');";
            System.out.println(Insert);

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
                            + "'" + dia + "',(select codagemc from agendamentomc where dia = '" + dia + "' and hormc like '" + hor + "'),null, 0);";
                    System.out.println(Insert);
                    stmt.executeUpdate(Insert);

                } else {
                    String Insert = "insert into agendacliente values((select codcli from cliente where cpf like '" + cpf + "'), \n"
                            + "'" + dia + "',null,(select codagemf from agendamentomf where dia = '" + dia + "' and hormf like '" + hor + "',0));";
                    stmt.executeUpdate(Insert);
                    System.out.println(Insert);
                }

            } else if (op == 2) {

                String Delete = "delete from agendacliente where codcli= (select codcli from cliente where cpf like '" + cpf + "') \n"
                        + "and dia='" + dia + "';";

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

    public static void CidadeComboBoxConsultaCliente() {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        String a = (String) AlteracaoCliente.estado.getSelectedItem();
        String sql = "select nomcid from cidade where codest = (select codest from estado where nomest like '" + a + "') order by nomcid";
        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {
                AlteracaoCliente.cidade.addItem(resultado.getString(1));
                AlteracaoCliente.cidade.updateUI();

            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }

    public static void CategoriaComboBoxConsultaCliente() {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "senai";
        String url = "jdbc:postgresql://localhost:5432/sesiacademia";
        String sql = "select nomcat from categoria ";
        try {
            Connection con = DriverManager.getConnection(url, user, senha);
            PreparedStatement banco = (PreparedStatement) con.prepareStatement(sql);
            banco.execute(); // cria o vetor

            ResultSet resultado = banco.executeQuery();

            while (resultado.next()) {
                AlteracaoCliente.cate.addItem(resultado.getString(1));
                AlteracaoCliente.cate.updateUI();

            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }

    public static void EmpresaComboBoxConsultaCliente() {

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
                AlteracaoCliente.emp.addItem(resultado.getString(1));
                AlteracaoCliente.emp.updateUI();

            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }

    public static void EstadoComboBoxConsultaCliente() {

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
                AlteracaoCliente.estado.addItem(resultado.getString(1));
                AlteracaoCliente.estado.updateUI();

            }
            banco.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }

    public static void updateClientes() {
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

            String nome = AlteracaoCliente.nome.getText();
            String cpf = AlteracaoCliente.cpf.getText();
            String cep = AlteracaoCliente.cep.getText();
            String datnas = AlteracaoCliente.datnas.getText();

            String cidade = (String) AlteracaoCliente.cidade.getSelectedItem();
            String tel = AlteracaoCliente.tel.getText();
            String ana = AlteracaoCliente.ana.getText();
            String end = AlteracaoCliente.end.getText();
            String email = AlteracaoCliente.email.getText();
            String tipo = (String) AlteracaoCliente.tipo.getSelectedItem();
            String emp = (String) AlteracaoCliente.emp.getSelectedItem();
            String cat = (String) AlteracaoCliente.cate.getSelectedItem();
            String cla = (String) AlteracaoCliente.cla.getSelectedItem();
            String obs = AlteracaoCliente.obs.getText();
            String genero = (String) AlteracaoCliente.gen.getSelectedItem();

            String Insert = "update cliente set nomcli = '" + nome + "', tipo = '" + tipo + "', email = '" + email + "', genero = '" + genero + "', classificacao = '" + cla + "', datnas = '" + datnas + "', celular = '" + tel + "', cep = '" + cep + "', endereco = '" + end + "', ana = '" + ana + "', obs = '" + obs + "', codcid = (select codcid from cidade where nomcid ilike '%" + cidade + "%'), codcat = (select codcat from categoria where nomcat ilike '%" + cat + "%'), codemp = (select codemp from empresa where nomemp ilike '" + emp + "') where codcli = (select codcli from cliente where cpf like '" + cpf + "');";
            stmt.executeUpdate(Insert);

            con.close();

        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
    }

    public static void InsertEmpresaNovaConsulta() {
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

            String cnpj = AlteracaoCliente.cnpj.getText();
            String nome = AlteracaoCliente.nomemp.getText();
            String telefone = AlteracaoCliente.telemp.getText();

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
}
