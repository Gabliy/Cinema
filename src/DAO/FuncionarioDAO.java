package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Funcionario;

public class FuncionarioDAO {

    // a conexão com o banco de dados
    private Connection conexao;

    public FuncionarioDAO() {
    	Conexao con = new Conexao();
        this.conexao = con.getConexao();
    }
    
    //MÉTODO PARA ADICIONAR NOVO Funcionario
    public void adicionar(Funcionario Funcionario) {
    	
        String sql = "insert into Funcionarios " +
                "(nome,endereco,telefone)" +
                " values (?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = conexao.prepareStatement(sql);

            // seta os valores
            stmt.setString(1,Funcionario.getNome());
            stmt.setString(2,Funcionario.getEndereco());
            stmt.setString(3,Funcionario.getTelefone());
           
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //MÉTODO PARA ALTERAR Funcionario
    public void altera(Funcionario Funcionario) {
    	System.out.println("ID: "+Funcionario.getIdMat());
    	
        String sql = "update Funcionarios set nome=?, endereco=?, telefone=? " +
                "where id=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, Funcionario.getNome());
            stmt.setString(2, Funcionario.getEndereco());
            stmt.setString(3, Funcionario.getTelefone());
            stmt.setInt(4, Funcionario.getIdMat());
            
            System.out.println(stmt);
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //MÉTODO PARA EXCLUIR
    public void remove(Funcionario Funcionario) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("delete " +
                    "from Funcionarios where id=?");
            stmt.setInt(1, Funcionario.getIdMat());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    //MÉTODO PARA EXIBIR TODOS
    public void consultarTodos() {
    	 String sql = "select * from Funcionarios";

		try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery(); //executa uma consulta
            while(resultado.next()) {
            	System.out.println(resultado.getInt("id")
            			+" "+resultado.getString("nome")
            			+" - "+resultado.getString("email")
            			+" - "+resultado.getString("endereco"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    //MÉTODO PARA BUSCAR POR NOME
    public ResultSet buscarPorNome(String nome) {

   	 String sql = "select * from Funcionarios where nome like ?";

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
    public void criarTabelaFuncionarios() {
		String sql = "create table if not exists Funcionarios(" + 
				"        id SERIAL NOT NULL," + 
				"        nome VARCHAR(255)," + 
				"        endereco VARCHAR(255)," + 
				"        telefone VARCHAR(255)," + 
				"        primary key (id)" + 
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