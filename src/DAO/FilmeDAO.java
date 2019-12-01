package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Filme;



public class FilmeDAO {
	private Connection conexao;

	public FilmeDAO() {
		Conexao con = new Conexao();
		this.conexao = con.getConexao();
	}

	//MÉTODO PARA ADICIONAR NOVO Filme
	public void adicionar(Filme Filme) {

		String sql = "insert into Filmes " +
				"(refe, titulo, duracao)" +
				" values (?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// seta os valoresw
			stmt.setString(1,Filme.getRef());
			stmt.setString(2,Filme.getTitulo());
			stmt.setString(3,Filme.getDuracao());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA ALTERAR Filme
	public void altera(Filme Filme) {
		System.out.println("ID: "+Filme.getIdFilme());

		String sql = "update Filmes set titulo=?, duracao=? " +
				"where id=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,Filme.getTitulo());
			stmt.setString(2,Filme.getDuracao());
			stmt.setInt(3, Filme.getIdFilme());

			System.out.println(stmt);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA EXCLUIR
	public void remove(Filme Filme) {
		try {
			PreparedStatement stmt = conexao.prepareStatement("delete " +
					"from Filmes where id=?");
			stmt.setInt(1, Filme.getIdFilme());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA EXIBIR TODOS
	public void consultarTodos() {
		String sql = "select * from Filmes";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery(); //executa uma consulta
			while(resultado.next()) {
				System.out.println(resultado.getInt("idFilme")
						+" "+resultado.getString("titulo")
						+" - "+resultado.getString("duracao"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	//MÉTODO PARA BUSCAR POR NOME
	public ResultSet buscarPorNome(String nome) {

		String sql = "select * from Filmes where titulo like ?";

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
	public void criarTabelaFilmes() {
		String sql = "create table if not exists Filmes(" + 
				"        idFilme SERIAL NOT NULL," + 
				"        titulo VARCHAR(255)," +
				"        duracao VARCHAR(255)," +
				"        primary key (idFilme)" + 
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
