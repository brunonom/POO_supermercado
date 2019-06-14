import java.util.ArrayList;

public class Setor{
	private String nome;
	private ArrayList<Produto> produtos;

	public Setor(String nome){
		this.nome = nome;
		produtos = new ArrayList<Produto>();
	}

	public String getNome(){
		return nome;
	}

	public void addProduto(Produto produto){
		produtos.add(produto);
	}

	public String getInfo(){
		String dados = "";
		dados = dados + "Nome: " + nome + "\n";
		dados = dados + "Produtos:\n";
		for(int i=0; i<produtos.size(); i++){
			dados = dados + "\t" + produtos.get(i).getNome() + "\n"; 
		}
		return dados;
	}
}