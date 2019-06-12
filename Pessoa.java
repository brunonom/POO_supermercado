public abstract class Pessoa implements CRUD{
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

	public Object criaInstancia(){
		this.nome = ""
		while(this.nome.equals("")){
			System.out.printf("nome: ");
			this.nome = leitor.nextLine();
		}

		this.rg = ""
		while(this.rg.equals("")){
			System.out.printf("rg: ");
			this.rg = leitor.nextLine();
		}

		this.cpf = ""
		while(this.cpf.equals("")){
			System.out.printf("cpf: ");
			this.cpf = leitor.nextLine();
		}

		this.idade = ""
		while(this.idade < 0){
			System.out.printf("idade: ");
			this.idade = leitor.nextInt();
			leitor.nextLine();
		}
	} 

	public abstract String getInfo();
}