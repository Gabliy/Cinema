package model;

public class Sala {
	private int idSala, numSala,qtdCadeira;

	public Sala(int numSala, int qtdCadeira) {
		super();
		this.numSala = numSala;
		this.qtdCadeira = qtdCadeira;
	}

	public int getIdSala() {
		return idSala;
	}

	public int getNumSala() {
		return numSala;
	}

	public int getQtdCadeira() {
		return qtdCadeira;
	}
	
	
}
