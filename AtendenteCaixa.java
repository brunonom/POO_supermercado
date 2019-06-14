public class AtendenteCaixa extends Funcionario{
	private Caixa caixa;

	public AtendenteCaixa(String nome, String rg, String cpf, int idade, double salario, Caixa caixa){
		super(nome, rg, cpf, idade, salario);
		this.caixa = caixa;
	}

	public String getInfo(){
		String dados = "";
		dados = super.getInfo();
		dados = dados + "Número do caixa: " + caixa + "\n";
		return dados;
	}

	/*
	public static Object criaInstancia(Supermercado mercado){
		Object instancia = null;

		if(mercado.getCaixas().size() != 0){		
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

			Caixa caixa = null;
			int escolha = -1;
			while(escolha<0 || escolha>mercado.getCaixas().size()-1){
				System.out.printf("numero do caixa (1 à %d): ", mercado.getCaixas().size())
				escolha = leitor.nextInt();
				leitor.nextLine();
			}
			caixa = mercado.getCaixas().get(escolha-1);

			instancia = new Funcionario(nome, rg, cpf, idade, salario);
		}

		return instancia;
	}
	*/
}