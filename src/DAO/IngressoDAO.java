package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Ingresso;

public class IngressoDAO {
	private Connection conexao;

	public IngressoDAO() {
		Conexao con = new Conexao();
		this.conexao = con.getConexao();
	}

	//MÉTODO PARA ADICIONAR NOVO Ingresso
	public void adicionar(Ingresso Ingresso) {

		String sql = "insert into Ingressos " +
				"(preco, estudante, colfil, filme, sessao, ingressoData, compraData, numSala, qtdIngresso, idCliente_fk, pagamento)" +
				" values (?,?,?,?,?,?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// seta os valoresw
			stmt.setFloat(1,Ingresso.getPreco());
			stmt.setBoolean(2,Ingresso.isEstudante());
			stmt.setString(3,Ingresso.getColfil());
			stmt.setString(4,Ingresso.getFilme());
			stmt.setString(5,Ingresso.getSessao());
			stmt.setString(6,Ingresso.getIngressoData());
			stmt.setString(7,Ingresso.getCompraData());
			stmt.setInt(8,Ingresso.getNumSala());
			stmt.setInt(9,Ingresso.getQtdIngresso());
			stmt.setInt(10, Ingresso.getIdCliente_fk());
			stmt.setString(11, Ingresso.getPagamento());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA ALTERAR Ingresso
	public void altera(Ingresso Ingresso) {
		System.out.println("ID: "+Ingresso.getIdIngresso());

		String sql = "update Ingressos set preco=?, estudante=?, colfil=?, filme=?, sessao=?, ingressoData=?, compraData=? " +
				"where idIngresso=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setFloat(1,Ingresso.getPreco());
			stmt.setBoolean(2,Ingresso.isEstudante());
			stmt.setString(3,Ingresso.getColfil());
			stmt.setString(4,Ingresso.getFilme());
			stmt.setString(5,Ingresso.getSessao());
			stmt.setString(6,Ingresso.getIngressoData());
			stmt.setString(7,Ingresso.getCompraData());
			stmt.setInt(8, Ingresso.getIdIngresso());

			System.out.println(stmt);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA EXCLUIR
	public void remove(Ingresso Ingresso) {
		try {
			PreparedStatement stmt = conexao.prepareStatement("delete " +
					"from Ingressos where idIngresso=?");
			stmt.setInt(1, Ingresso.getIdIngresso());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MÉTODO PARA EXIBIR TODOS
	public void consultarTodos() {
		String sql = "select * from Ingressos";

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

		String sql = "select * from Ingressos where nome like ?";

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
