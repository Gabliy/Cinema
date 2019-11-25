package model;


public class Sessao {
	int idSessao;
	String horario,data;
	
	public Sessao(String horario, String data) {
		super();
		this.horario = horario;
		this.data = data;
	}
	
	public int getIdSessao() {
		return idSessao;
	}
	public String getHorario() {
		return horario;
	}
	public String getData() {
		return data;
	}
	
	
}
