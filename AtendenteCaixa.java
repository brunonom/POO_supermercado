public class AtendenteCaixa extends Funcionario{
	private int numeroCaixa;

	public AtendenteCaixa(String nome, String rg, String cpf, int idade double salario, int numeroCaixa){
		super(nome, rg, cpf, salario);
		this.numeroCaixa = numeroCaixa;
	}

	public String getInfo(){
		String dados = "";
		dados = dados + "Nome: " + super.getNome() + "\n";
		dados = dados + "RG: " + super.getRG() + "\n";
		dados = dados + "CPF: " + super.getCPF() + "\n";
		dados = dados + "Idade: " + super.getIdade() + "\n";
		dados = dados + "Salário: " + calculaSalario() + "\n";
		dados = dados + "Número do caixa: " + numeroCaixa + "\n";
		return dados;
	}

	public double calculaSalario(){
		return super.getSalario();
	}
}