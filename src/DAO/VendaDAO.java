package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Venda;

public class VendaDAO {
	private Connection conexao;

	public VendaDAO() {
		Conexao con = new Conexao();
		this.conexao = con.getConexao();
	}

	//MÉTODO PARA ADICIONAR NOVO Venda
	public void adicionar(Venda Venda) {

		String sql = "insert into Vendas " +
				"(preco, estudante, ingressoData, compraData)" +
				" values (?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// seta os valoresw
			stmt.setFloat(1,Venda.getPreco());
			stmt.setBoolean(2,Venda.isEstudante());
			stmt.setString(3,Venda.getIngressoData());
			stmt.setString(4,Venda.getCompraData());
			

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA ALTERAR Venda
	public void altera(Venda Venda) {
		System.out.println("ID: "+Venda.getIdVenda());

		String sql = "update Vendas set preco=?, estudante=?, colfil=?, filme=?, sessao=?, VendaData=?, compraData=? " +
				"where idVenda=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setFloat(1,Venda.getPreco());
			stmt.setBoolean(2,Venda.isEstudante());
			stmt.setString(3,Venda.getIngressoData());
			stmt.setString(4,Venda.getCompraData());
			stmt.setInt(5, Venda.getIdVenda());

			System.out.println(stmt);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA EXCLUIR
	public void remove(Venda Venda) {
		try {
			PreparedStatement stmt = conexao.prepareStatement("delete " +
					"from Vendas where idVenda=?");
			stmt.setInt(1, Venda.getIdVenda());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA EXIBIR TODOS
	public void consultarTodos() {
		String sql = "select * from Vendas";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery(); //executa uma consulta
			while(resultado.next()) {
				System.out.println(resultado.getInt("id")
						+" "+resultado.getString("capacidade")
						+" - "+resultado.getString("localizacao"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	//MÉTODO PARA BUSCAR POR NOME
	public ResultSet buscarPorNome(String nome) {

		String sql = "select * from Vendas where nome like ?";

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
