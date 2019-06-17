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

	public ArrayList<Item> getCompras(){
		return compras;
	}
	public boolean getPossuiCadastro(){
		return possuiCadastro;
	}

	public void adicionaItem(Item item){
		compras.add(item);
	}

	//clientes com cadastro recebem 10% de desconto nas compras
	public double calculaTotal(){
		double total = 0;
		for(int i=0; i<compras.size(); i++){
			total += compras.get(i).getPreco();
		}
		if(possuiCadastro){
			total -= total*10/100;
		}
		return total;
	}

	public void realizaCompra(){
		for(int i=0; i<compras.size(); i++){
			compras.get(i).realizaCompra();
		}
		compras.clear();
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

	public void alteraInfo(String nome, String rg, String cpf, int idade, String email){
		super.alteraInfo(nome, rg, cpf, idade);
		this.email = email;
		this.possuiCadastro = true;
	}

	public String getDadosCompra(){
		double somatorio = 0;
		String dados = "";
		dados = dados + "compras:\tproduto\t\tquantidade\t\tpreco\n";
		for(int i=0; i<compras.size(); i++){
			dados = dados + "\t\t" + compras.get(i).getProduto().getNome();
			dados = dados + "\t\t" + compras.get(i).getQuantidade();
			dados = dados + "\t\t\t" + compras.get(i).getPreco() + "\n";
			somatorio += compras.get(i).getPreco();
		}
		dados = dados + "total: " + somatorio + "\n";
		if(possuiCadastro){
			dados = dados + "desconto: 10%\n";
		}
		else{
			dados = dados + "desconto: 0%\n";
		}
		dados = dados + "preco final: " + calculaTotal() + "\n";
		return dados;
	}
}