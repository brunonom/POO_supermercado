public class AtendenteCaixa extends Funcionario{
	private int numeroCaixa;

	public AtendenteCaixa(String nome, double salario, int numeroCaixa){
		super(nome, salario);
		this.numeroCaixa = numeroCaixa;
	}

	public String display(){
		String dados = "";
		dados = dados + "Nome: " + super.getNome() + "\n";
		dados = dados + "Salario: " + super.getSalario() + "\n";
		dados = dados + "numeroCaixa: " + numeroCaixa + "\n";
		return dados;
	}
}