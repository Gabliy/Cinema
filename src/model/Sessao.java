package model;


public class Sessao {
	private int idSessao,numSala;
	private float preco;
	private String horario,data,nome_filme;
	public Sessao(float preco, String horario, String data, String nome_filme, int numSala) {
		super();
		this.preco = preco;
		this.horario = horario;
		this.data = data;
		this.nome_filme = nome_filme;
		this.numSala = numSala;
	}
	public int getIdSessao() {
		return idSessao;
	}
	public float getPreco() {
		return preco;
	}
	public String getHorario() {
		return horario;
	}
	public String getData() {
		return data;
	}
	public String getNome_filme() {
		return nome_filme;
	}
	public int getNumSala() {
		return numSala;
	}
	
	
}
