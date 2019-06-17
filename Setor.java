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
	public ArrayList<Produto> getProdutos(){
		return produtos;
	}

	public void adicionaProduto(Produto produto){
		produtos.add(produto);
	}

	public String getInfo(){
		String dados = "";
		dados = dados + "nome: " + nome + "\n";
		dados = dados + "produtos:\n";
		dados = dados + "\tnome\tpreco\testoque\n";
		for(int i=0; i<produtos.size(); i++){
			dados = dados + "\t" + produtos.get(i).getNome();
			dados = dados + "\t" + produtos.get(i).getPreco();
			dados = dados + "\t" + produtos.get(i).getEstoque() + "\n";
		}
		return dados;
	}
}