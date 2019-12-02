package model;

public class Ingresso {
	private int IdIngresso,qtdIngresso, numSala,idCliente_fk;
	private float preco;
	private boolean estudante;
	private String colfil,filme,sessao,ingressoData,compraData,pagamento;
	public Ingresso(float preco, boolean estudante, String colfil, String filme, String sessao, String ingressoData,
			String compraData ,int numSala,int qtdIngresso, int idCliente_fk, String pagamento) {
		super();
		this.pagamento = pagamento;
		this.idCliente_fk = idCliente_fk;
		this.numSala = numSala;
		this.qtdIngresso = qtdIngresso;
		this.preco = preco;
		this.estudante = estudante;
		this.colfil = colfil;
		this.filme = filme;
		this.sessao = sessao;
		this.ingressoData = ingressoData;
		this.compraData = compraData;
	}
	public int getIdIngresso() {
		return IdIngresso;
	}
	public float getPreco() {
		return preco;
	}
	public boolean isEstudante() {
		return estudante;
	}
	public String getColfil() {
		return colfil;
	}
	public String getFilme() {
		return filme;
	}
	public String getSessao() {
		return sessao;
	}
	public String getIngressoData() {
		return ingressoData;
	}
	public String getCompraData() {
		return compraData;
	}
	public int getQtdIngresso() {
		return qtdIngresso;
	}
	public int getNumSala() {
		return numSala;
	}
	public int getIdCliente_fk() {
		return idCliente_fk;
	}
	public String getPagamento() {
		return pagamento;
	}	
	
}
