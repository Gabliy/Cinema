package model;

public class Venda {
	private int idVenda;
	private float preco;
	private boolean estudante;
	private String ingressoData,compraData;
	
	public Venda(float preco, boolean estudante, String ingressoData, String compraData) {
		super();
		this.preco = preco;
		this.estudante = estudante;
		this.ingressoData = ingressoData;
		this.compraData = compraData;
	}
	public int getIdVenda() {
		return idVenda;
	}
	public float getPreco() {
		return preco;
	}
	public boolean isEstudante() {
		return estudante;
	}
	public String getIngressoData() {
		return ingressoData;
	}
	public String getCompraData() {
		return compraData;
	}
	
}
