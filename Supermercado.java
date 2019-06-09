import java.util.ArrayList;
import java.util.Scanner;

public class Supermercado{
	private ArrayList<Setor> setores;
	private ArrayList<Pessoa> pessoas;
	private boolean executando;
	private Scanner scan;

	public Supermercado(){
		this.setores = new ArrayList<Setor>();
		this.pessoas = new ArrayList<Pessoa>();
		this.executando = true;
		this.scan = new Scanner(System.in);
	}

	public boolean getExecutando(){
		return executando;
	}
	public void setExecutando(boolean executando){
		this.executando = executando;
	}

	public static void main(String[] args){
		Supermercado mercado = new Supermercado();
		int opcao;
		while(mercado.getExecutando()){
			opcao = mercado.escolheOpcao();
			mercado.executaOpcao(opcao);
		}
	}

	public int escolheOpcao(){
		int escolha = -1;
		while(escolha<0 || escolha>2){
			System.out.printf("[0] Sair\n" );
			System.out.printf("[1] opcao\n" );
			System.out.printf("[2] opcao\n" );
			escolha = scan.nextInt();
			scan.nextLine();
			System.out.printf("\n");
		}
		return escolha;
	}

	public void executaOpcao(int escolha){
		switch(escolha){
			case 0:
				setExecutando(false);
				System.out.printf("\n\n\nAdeus\n\n\n");
				break;
			case 1:
				break;
			case 2:
				break;
		}
	}
}