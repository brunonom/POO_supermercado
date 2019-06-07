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

	public double getPreco(){
		return produto.getPreco()*quantidade;
	}

	public Produto getProduto(){
		return produto;
	}
	public int getQuantidade(){
		return quantidade;
	}

	public void realizaCompra(){
		produto.modificarEstoque(-quantidade);
	}
}