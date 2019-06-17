public class AtendenteCaixa extends Funcionario{
	private Caixa caixa;

	public AtendenteCaixa(String nome, String rg, String cpf, int idade, double salario, Caixa caixa){
		super(nome, rg, cpf, idade, salario);
		this.caixa = caixa;
		caixa.setPossuiAtendente();
	}

	public Caixa getCaixa(){
		return caixa;
	}

	@Override
	public String getInfo(){
		String dados = "";
		dados = super.getInfo();
		dados = dados + "numero do caixa: " + caixa.getNumero() + "\n";
		return dados;
	}

	public void alteraInfo(String nome, String rg, String cpf, int idade, double salario, Caixa caixa){
		super.alteraInfo(nome, rg, cpf, idade, salario);
		this.caixa.setPossuiAtendente(false);
		this.caixa = caixa;
		this.caixa.setPossuiAtendente(true);
	}
}