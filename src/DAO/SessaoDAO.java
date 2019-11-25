package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Sessao;

public class SessaoDAO {
	private Connection conexao;

	public SessaoDAO() {
		Conexao con = new Conexao();
		this.conexao = con.getConexao();
	}

	//MÉTODO PARA ADICIONAR NOVO Sessao
	public void adicionar(Sessao Sessao) {

		String sql = "insert into Sessaos " +
				"(horario,data)" +
				" values (?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// seta os valoresw
			stmt.setString(1,Sessao.getHorario());
			stmt.setString(2,Sessao.getData());


			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA ALTERAR Sessao
	public void altera(Sessao Sessao) {
		System.out.println("ID: "+Sessao.getIdSessao());

		String sql = "update Sessaos set horario=?, data=? " +
				"where id=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,Sessao.getHorario());
			stmt.setString(2,Sessao.getData());
			stmt.setInt(3, Sessao.getIdSessao());

			System.out.println(stmt);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA EXCLUIR
	public void remove(Sessao Sessao) {
		try {
			PreparedStatement stmt = conexao.prepareStatement("delete " +
					"from Sessaos where id=?");
			stmt.setInt(1, Sessao.getIdSessao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA EXIBIR TODOS
	public void consultarTodos() {
		String sql = "select * from Sessaos";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery(); //executa uma consulta
			while(resultado.next()) {
				System.out.println(resultado.getInt("idSessao")
						+" "+resultado.getString("horario")
						+" - "+resultado.getString("data"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	//MÉTODO PARA BUSCAR POR NOME
	public ResultSet buscarPorNome(String nome) {

		String sql = "select * from Sessaos where data like ?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,'%'+nome+'%');

			ResultSet resultado = stmt.executeQuery(); //executa uma consulta
			return resultado;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}


	//MÉTODO PARA BUSCAR QUALQUER CONSULTA
	public ResultSet consultar(String sql) {

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery(); //executa uma consulta
			return resultado;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	//MÉTODO PARA FECHAR CONEXÃO
	public void encerrar() {
		try {
			this.conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//MÉTODO PARA CRIAR TABELA
	public void criarTabelaSessaos() {
		String sql = "create table if not exists Sessaos(" + 
				"        idSessao SERIAL NOT NULL," + 
				"        horario VARCHAR(255)," +
				"        data VARCHAR(255)," +
				"        primary key (idSessao)" + 
				"    );";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);


			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}


	}
}
