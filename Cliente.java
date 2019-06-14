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

	public String getNotaFiscal(){
		String dados = "";
		dados = dados + "Compras:\tProduto\t\tQuantidade\n";
		for(int i=0; i<compras.size(); i++){
			dados = dados + "\t\t" + compras.get(i).getProduto().getNome();
			dados = dados + "\t\t" + compras.get(i).getQuantidade() + "\n";
		}
		return dados;
	}

	/*
	public static Object criaInstancia(){
		Object instancia = null;
		
		int escolha = -1;
		while(escolha<0 || escolha>1){
			System.out.printf("[0] realizar cadastro\n");
			System.out.printf("[1] nao realizar cadastro\n");
			escolha = leitor.nextInt();
			leitor.nextLine();
			System.out.printf("\n");
		}

		if(escolha == 0){
			String nome = "";
			while(nome.equals("")){
				System.out.printf("nome: ");
				nome = leitor.nextLine();
			}

			String rg = "";
			while(rg.equals("")){
				System.out.printf("rg: ");
				rg = leitor.nextLine();
			}

			String cpf = "";
			while(cpf.equals("")){
				System.out.printf("cpf: ");
				cpf = leitor.nextLine();
			}

			int idade = -1;
			while(idade < 0){
				System.out.printf("idade: ");
				idade = leitor.nextInt();
				leitor.nextLine();
			}

			String email = "";
			while(email.equals("")){
				System.out.printf("email: ");
				email = leitor.nextLine();
			}

			instancia = new Cliente(nome, rg, cpf, idade, email);
		}
		else{
			instancia = new Cliente();
		}

		return instancia;
	}
	*/
}