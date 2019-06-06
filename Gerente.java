public class Gerente extends Funcionario{
	private Setor setor;

	public Gerente(String nome, double salario, Setor setor){
		super(nome, salario);
		this.setor = setor;
	}

	public String display(){
		String dados = "";
		dados = dados + "Nome: " + super.getNome() + "\n";
		dados = dados + "Salario: " + super.getSalario() + "\n";
		dados = dados + "Setor: " + setor.getNome() + "\n";
		return dados;
	}
}