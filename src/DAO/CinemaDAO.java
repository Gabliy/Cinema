package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cinema;

public class CinemaDAO {

	// a conexão com o banco de dados
	private Connection conexao;

	public CinemaDAO() {
		Conexao con = new Conexao();
		this.conexao = con.getConexao();
	}

	//MÉTODO PARA ADICIONAR NOVO Cinema
	public void adicionar(Cinema Cinema) {

		String sql = "insert into Cinemas " +
				"(capacidade,localizacao)" +
				" values (?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// seta os valoresw
			stmt.setInt(1,Cinema.getCapacidade());
			stmt.setString(2,Cinema.getLocalizacao());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA ALTERAR Cinema
	public void altera(Cinema Cinema) {
		System.out.println("ID: "+Cinema.getId());

		String sql = "update Cinemas set capacidade=?, localizacao=? " +
				"where idCinema=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, Cinema.getCapacidade());
			stmt.setString(2, Cinema.getLocalizacao());
			stmt.setInt(3, Cinema.getId());

			System.out.println(stmt);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA EXCLUIR
	public void remove(Cinema Cinema) {
		try {
			PreparedStatement stmt = conexao.prepareStatement("delete " +
					"from Cinemas where idCinema=?");
			stmt.setInt(1, Cinema.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA EXIBIR TODOS
	public void consultarTodos() {
		String sql = "select * from Cinemas";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery(); //executa uma consulta
			while(resultado.next()) {
				System.out.println(resultado.getInt("idCinema")
						+" "+resultado.getString("capacidade")
						+" - "+resultado.getString("localizacao"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	//MÉTODO PARA BUSCAR POR NOME
	public ResultSet buscarPorNome(String nome) {

		String sql = "select * from Cinemas where nome like ?";

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

}
