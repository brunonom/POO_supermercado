public class Produto implements Informacoes{
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

	public String getInfo(){
		String dados = "";
		dados = dados + "nome: " + nome + "\n";
		dados = dados + "preco: " + preco + "\n";
		dados = dados + "quantidade em estoque: " + estoque + "\n";
		return dados;
	}

	public void alteraInfo(String nome, double preco, int estoque){
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
	}
}