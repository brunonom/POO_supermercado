public class Produto{
	private String nome;
	private double preco;
	private int estoque;

	public Produto(String nome, double preco, int estoque){
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
	}
	public Produto(String nome, double preco){
		this(nome, preco, 0);
	}

	public String getNome(){
		return nome;
	}
	public double getPreco(){
		return preco;
	}
	public int getEstoque(){
		return estoque;
	}

	public void modificarEstoque(int unidades){
		estoque+=unidades;
	}

}