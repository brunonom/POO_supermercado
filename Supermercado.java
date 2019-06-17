import java.util.ArrayList;

public class Supermercado implements Informacoes{
	private String nome;
	private ArrayList<Setor> setores;
	private ArrayList<Pessoa> pessoas;
	private ArrayList<Caixa> caixas;
	
	public Supermercado(String nome){
		this.nome = nome;
		this.setores = new ArrayList<Setor>();
		this.pessoas = new ArrayList<Pessoa>();
		this.caixas = new ArrayList<Caixa>();
	}

	public ArrayList<Setor> getSetores(){
		return setores;
	}
	public ArrayList<Pessoa> getPessoas(){
		return pessoas;
	}
	public ArrayList<Caixa> getCaixas(){
		return caixas;
	}

	public void adicionarSetor(Setor setor){
		setores.add(setor);
	}
	public void adicionarPessoa(Pessoa pessoa){
		pessoas.add(pessoa);
	}
	public void adicionarCaixa(Caixa caixa){
		caixas.add(caixa);
	}

	public int contaClientes(){
		int contador = 0;
		for(int i=0; i<pessoas.size(); i++){
			if(pessoas.get(i) instanceof Cliente){
				contador++;
			}
		}
		return contador;
	}
	public int contaProdutos(){
		int contador = 0;
		for(int i=0; i<setores.size(); i++){
			contador += setores.get(i).getProdutos().size();
		}
		return contador;
	}
	public int contaCaixasSemAtendente(){
		int contador = 0;
		for(int i=0; i<caixas.size(); i++){
			if(!caixas.get(i).getPossuiAtendente()){
				contador++;
			}
		}
		return contador;
	}

	public String getInfo(){
		String dados = "";
		dados = dados + "nome: " + nome + "\n";
		dados = dados + "\n";
		dados = dados + "setores:\n";
		for(int i=0; i<setores.size(); i++){
			dados = dados + setores.get(i).getInfo() + "\n";
		}
		dados = dados + "\n";
		dados = dados + "pessoas:\n";
		for(int i=0; i<pessoas.size(); i++){
			dados = dados + pessoas.get(i).getInfo() + "\n";
		}
		dados = dados + "\n";
		dados = dados + "possui " + caixas.size() + " caixas\n";
		dados = dados + "\n";
		return dados;
	}
}