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
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getRG(){
		return rg;
	}
	public void setRG(String rg){
		this.rg = rg;
	}
	public String getCPF(){
		return cpf;
	}
	public void setCPF(String cpf){
		this.cpf = cpf;
	}
	public int getIdade(){
		return idade;
	}
	public void setIdade(int idade){
		this.idade = idade;
	}

	public abstract String getInfo();

	public void alteraInfo(String nome, String rg, String cpf, int idade){
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.idade = idade;
	}
}