public class AtendenteCaixa extends Funcionario{
	private int numeroCaixa;

	public AtendenteCaixa(String nome, String rg, String cpf, int idade, double salario, int numeroCaixa){
		super(nome, rg, cpf, idade, salario);
		this.numeroCaixa = numeroCaixa;
	}

	public String getInfo(){
		String dados = "";
		dados = super.getInfo();
		dados = dados + "Número do caixa: " + numeroCaixa + "\n";
		return dados;
	}
}