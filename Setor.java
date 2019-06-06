public class Setor{
	private String nome;
	private int codigo;
	private static int geradorCodigo = 0;

	public Setor(String nome){
		this.nome = nome;
		setCodigo();
	}

	public String getNome(){
		return nome;
	}
	public int getCodigo(){
		return codigo;
	}
	public void setCodigo(){
		codigo = ++geradorCodigo;
	}

	public String display(){
		String dados = "";
		dados = dados + "Nome: " + nome + "\n";
		dados = dados + "Código: " + codigo + "\n";
		return dados;
	}
}