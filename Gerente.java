public class Gerente extends Funcionario{
	private Setor setor;
	private double bonus; //%

	public Gerente(String nome, double salario, Setor setor){
		super(nome, salario);
		this.setor = setor;
	}

	public String getInfo(){
		String dados = "";
		dados = dados + "Nome: " + super.getNome() + "\n";
		dados = dados + "RG: " + super.getRG() + "\n";
		dados = dados + "CPF: " + super.getCPF() + "\n";
		dados = dados + "Idade: " + super.getIdade() + "\n";
		dados = dados + "Salário: " + calculaSalario() + "\n";
		dados = dados + "Setor: " + setor.getNome() + "\n";
		return dados;
	}

	public void calculaSalario(){
		return super.getSalario() + super.getSalario()*bonus;
	}
}