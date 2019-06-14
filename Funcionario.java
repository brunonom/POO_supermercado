public class Funcionario extends Pessoa{
	private double salario;

	public Funcionario(String nome, String rg, String cpf, int idade, double salario){
		super(nome, rg, cpf, idade);
		this.salario = salario;
	}

	public double getSalario(){
		return salario;
	}

	public String getInfo(){
		String dados = "";
		dados = dados + "Nome: " + super.getNome() + "\n";
		dados = dados + "RG: " + super.getRG() + "\n";
		dados = dados + "CPF: " + super.getCPF() + "\n";
		dados = dados + "Idade: " + super.getIdade() + "\n";
		dados = dados + "Salário: " + calculaSalario() + "\n";
		return dados;
	}

	public double calculaSalario(){
		return salario;
	}

	/*
	public static Object criaInstancia(){
		Object instancia = null;

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

		double salario = -1;
		while(salario < 0){
			System.out.printf("salario: ");
			salario = leitor.nextDouble();
			leitor.nextLine();
		}

		instancia = new Funcionario(nome, rg, cpf, idade, salario);

		return instancia;
	}
	*/
}