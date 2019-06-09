public class AtendenteCaixa extends Funcionario{
	private Caixa caixa;

	public AtendenteCaixa(String nome, String rg, String cpf, int idade, double salario, Caixa caixa){
		super(nome, rg, cpf, idade, salario);
		this.caixa = caixa;
	}

	public String getInfo(){
		String dados = "";
		dados = super.getInfo();
		dados = dados + "Número do caixa: " + caixa + "\n";
		return dados;
	}
}