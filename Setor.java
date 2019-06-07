public class Setor{
	private String nome;
	private int codigo;
	private static int geradorCodigo = 0;
	private ArrayList<Produto> produtos;

	public Setor(String nome){
		this.nome = nome;
		setCodigo();
	}

	public String getNome(){
		return nome;
	}
	public int getCodigo(){
		return codigo;
	}
	public void setCodigo(){
		codigo = ++geradorCodigo;
	}

	public void addProduto(Produto produto){
		produtos.add(produto);
	}

	public String getInfo(){
		String dados = "";
		dados = dados + "Nome: " + nome + "\n";
		dados = dados + "Código: " + codigo + "\n";
		dados = dados + "Produtos:\n";
		for(int i=0; i<produtos.size(); i++){
			dados = dados + "\t" + produtos.get(i).getNome() + "\n"; 
		}
		return dados;
	}
}