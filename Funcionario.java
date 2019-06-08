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
}