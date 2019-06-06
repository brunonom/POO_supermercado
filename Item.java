public class Item{
	private Produto produto;
	private int quantidade;

	public Item(Produto produto, int quantidade){
		this.produto = produto;
		this.quantidade = quantidade;
	}
	public Item(Produto produto){
		this(produto, 1);
	}

	public double calculaValor(){
		return produto.getPreco()*quantidade;
	}

	public void realizaCompra(){
		produto.modificarEstoque(-quantidade);
	}
}