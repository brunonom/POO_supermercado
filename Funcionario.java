public abstract class Funcionario extends Pessoa{
	private double salario;

	public Funcionario(String nome, String rg, String cpf, int idade double salario){
		super(nome, rg, cpf, idade);
		this.salario = salario;
	}

	public double getSalario(){
		return salario;
	}

	public double calculaSalario();
}