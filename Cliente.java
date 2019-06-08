import java.util.ArrayList;

public class Cliente extends Pessoa{
	private boolean possuiCadastro;
	private String email;
	private ArrayList<Item> compras;

	public Cliente(String nome, String rg, String cpf, int idade, String email){
		super(nome, rg, cpf, idade);
		this.email = email;
		this.possuiCadastro = true;
		compras = new ArrayList<Item>();
	}

	public Cliente(){
		super("", "", "", -1);
		this.email = "";
		this.possuiCadastro = false;
		compras = new ArrayList<Item>();
	}

	public void addItem(Item item){
		compras.add(item);
	}

	//clientes com cadastro recebem 10% de desconto nas compras
	public double calculaTotal(){
		double total = 0;
		for(int i=0; i<compras.size(); i++){
			total += compras.get(i).getPreco();
		}
		if(possuiCadastro){
			total -= total*0.10;
		}
		return total;
	}

	public void realizaCompra(){
		for(int i=0; i<compras.size(); i++){
			compras.get(i).realizaCompra();
		}
		compras.clear();
		/*
		if(!possuiCadastro){
			deletar essa instancia de cliente
		}
		*/
	}

	public String getInfo(){
		String dados = "";
		if(possuiCadastro){
			dados = dados + "Nome: " + super.getNome() + "\n";
			dados = dados + "RG: " + super.getRG() + "\n";
			dados = dados + "CPF: " + super.getCPF() + "\n";
			dados = dados + "Idade: " + super.getIdade() + "\n";
			dados = dados + "E-mail: " + email + "\n";
			
		}
		return dados;
	}

	public String getNotaFiscal(){
		String dados = "";
		dados = dados + "Compras:\tProduto\t\tQuantidade\n";
		for(int i=0; i<compras.size(); i++){
			dados = dados + "\t\t" + compras.get(i).getProduto().getNome();
			dados = dados + "\t\t" + compras.get(i).getQuantidade() + "\n";
		}
		return dados;
	}
}