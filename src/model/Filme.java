package model;

public class Filme {
	int idFilme;
	String titulo,duracao;
	public Filme(String titulo, String duracao) {
		super();
		this.titulo = titulo;
		this.duracao = duracao;
	}
	public int getIdFilme() {
		return idFilme;
	}
	public void setId(int id) {
		this.idFilme = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
}
