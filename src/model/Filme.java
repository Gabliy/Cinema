package model;

public class Filme {
	private int idFilme;
	private String titulo,duracao,ref;
	public Filme(String ref, String titulo, String duracao) {
		super();
		this.ref = ref;
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
	public String getRef() {
		return ref;
	}
	
}
