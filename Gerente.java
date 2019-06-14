public class Gerente extends Funcionario{
	private static double bonus = 10; //%

	public Gerente(String nome, String rg, String cpf, int idade, double salario){
		super(nome, rg, cpf, idade, salario);
	}

	public String getInfo(){
		String dados = "";
		super.getInfo();
		dados = dados + "Bônus(%): " + bonus*100 + "\n";
		return dados;
	}

	@Override
	public double calculaSalario(){
		return super.getSalario() + super.getSalario()*bonus;
	}
}