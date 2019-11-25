package model;

public class Cinema {
	private int id,capacidade;
	private String localizacao;
	
	public Cinema(int capacidade, String localizacao) {
		super();
		this.capacidade = capacidade;
		this.localizacao = localizacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
}
