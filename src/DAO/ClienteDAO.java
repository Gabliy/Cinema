package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;

public class ClienteDAO {
	private Connection conexao;

	public ClienteDAO() {
		Conexao con = new Conexao();
		this.conexao = con.getConexao();
	}

	//MÉTODO PARA ADICIONAR NOVO Cliente
	public void adicionar(Cliente Cliente) {

		String sql = "insert into Clientes " +
				"(cpf,nome,endereco,telefone)" +
				" values (?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// seta os valoresw
			stmt.setString(1,Cliente.getCpf());
			stmt.setString(2,Cliente.getNome());
			stmt.setString(3, Cliente.getEndereco());
			stmt.setString(4, Cliente.getTelefone());
			

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA ALTERAR Cliente
	public void altera(Cliente Cliente) {
		System.out.println("ID: "+Cliente.getIdCliente());

		String sql = "update Clientes set cpf=?, nome=?, endereco=?, telefone=? " +
				"where id=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, Cliente.getCpf());
			stmt.setString(2, Cliente.getNome());
			stmt.setString(3, Cliente.getEndereco());
			stmt.setString(4, Cliente.getTelefone());
			stmt.setInt(5, Cliente.getIdCliente());

			System.out.println(stmt);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA EXCLUIR
	public void remove(Cliente Cliente) {
		try {
			PreparedStatement stmt = conexao.prepareStatement("delete " +
					"from Clientes where id=?");
			stmt.setInt(1, Cliente.getIdCliente());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA EXIBIR TODOS
	public void consultarTodos() {
		String sql = "select * from Clientes";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery(); //executa uma consulta
			while(resultado.next()) {
				System.out.println(resultado.getInt("idCliente")
						+" "+resultado.getString("cpf")
						+" - "+resultado.getString("nome")
						+" - "+resultado.getString("endereco")
						+" - "+resultado.getString("telefone"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	//MÉTODO PARA BUSCAR POR NOME
	public ResultSet buscarPorNome(String nome) {

		String sql = "select * from Clientes where nome like ?";

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
	public void criarTabelaClientes() {
		String sql = "create table if not exists Clientes(" + 
				"        idCliente SERIAL NOT NULL," + 
				"        cpf VARCHAR(255)," +
				"        nome VARCHAR(255)," +
				"        endereco VARCHAR(255)," +
				"        telefone VARCHAR(255)," +
				"        primary key (idCliente)" + 
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
