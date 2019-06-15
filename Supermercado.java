import java.util.ArrayList;

public class Supermercado{
	private ArrayList<Setor> setores;
	private ArrayList<Pessoa> pessoas;
	private ArrayList<Caixa> caixas;
	private boolean executando;
	private int menu; //0=principal; 1=setores, 2=pessoas, 3=caixas

	public Supermercado(){
		this.setores = new ArrayList<Setor>();
		this.pessoas = new ArrayList<Pessoa>();
		this.caixas = new ArrayList<Caixa>();
		this.executando = true;
		this.menu = 0;
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
	public boolean getExecutando(){
		return executando;
	}
	public void setExecutando(boolean executando){
		this.executando = executando;
	}
	public int getMenu(){
		return menu;
	}
	public void setMenu(int menu){
		this.menu=menu;
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
}