public abstract class Pessoa{
	private String nome;
	private String rg;
	private String cpf;
	private int idade;

	public Pessoa(String nome, String rg, String cpf, int idade){
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.idade = idade;
	}

	public String getNome(){
		return nome;
	}
	public String getRG(){
		return rg;
	}
	public String getCPF(){
		return cpf;
	}
	public int getIdade(){
		return idade;
	}

	public abstract String getInfo();
}