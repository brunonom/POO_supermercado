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
		dados = dados + "nome: " + super.getNome() + "\n";
		dados = dados + "rg: " + super.getRG() + "\n";
		dados = dados + "cpf: " + super.getCPF() + "\n";
		dados = dados + "idade: " + super.getIdade() + "\n";
		dados = dados + "salario: " + calculaSalario() + "\n";
		return dados;
	}

	public void alteraInfo(String nome, String rg, String cpf, int idade, double salario){
		super.alteraInfo(nome, rg, cpf, idade);
		this.salario = salario;
	}

	public double calculaSalario(){
		return salario;
	}
}