public class Gerente extends Funcionario{
	private Setor setor;
	private double bonus; //%

	public Gerente(String nome, String rg, String cpf, int idade, double salario, Setor setor){
		super(nome, rg, cpf, idade, salario);
		this.setor = setor;
	}

	public String getInfo(){
		String dados = "";
		super.getInfo();
		dados = dados + "Setor: " + setor.getNome() + "\n";
		dados = dados + "Bônus(%): " + bonus*100 + "\n";
		return dados;
	}

	@Override
	public double calculaSalario(){
		return super.getSalario() + super.getSalario()*bonus;
	}
}