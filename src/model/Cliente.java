package model;

public class Cliente {
	private int idCliente;
	private String cpf,nome,endereco,telefone;
	public Cliente(String cpf, String nome, String endereco, String telefone) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	public int getIdCliente() {
		return idCliente;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	

}
