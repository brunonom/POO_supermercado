import java.util.Scanner;

public class AplicacaoSupermercado{
	private static Supermercado mercado = new Supermercado();
	private static Scanner scan =  new Scanner(System.in);

	public static void main(String[] args){
		int opcao = -1;
		while(mercado.getExecutando()){
			switch(mercado.getMenu()){
				case 0:
					opcao = escolhaMenuPrincipal();
					break;
				case 1:
					opcao = escolhaMenuSetores();
					break;
				case 2:
					opcao = escolhaMenuPessoas();
					break;
				case 3:
					opcao = escolhaMenuCaixas();
					break;
			}
			System.out.printf("\n");
			executaOpcao(opcao);
			System.out.printf("\n");
		}
	}

	public static int escolhaMenuPrincipal(){
		int escolha = -1;
		while(escolha<0 || escolha>3){
			System.out.printf("[0] sair\n");
			System.out.printf("[1] menu de setores\n");
			System.out.printf("[2] menu de pessoas\n");
			System.out.printf("[3] menu de caixas\n");
			System.out.printf("Escolha: ");
			escolha = scan.nextInt();
			scan.nextLine();
		}
		return escolha;
	}
	public static int escolhaMenuSetores(){
		int escolha = -1;
		while(escolha<0 || escolha>2){
			System.out.printf("[0] voltar\n");
			System.out.printf("[1] adicionar setor\n");
			System.out.printf("[2] adicionar produto\n");
			System.out.printf("Escolha: ");
			escolha = scan.nextInt();
			scan.nextLine();
		}
		return escolha;
	}
	public static int escolhaMenuPessoas(){
		int escolha = -1;
		while(escolha<0 || escolha>4){
			System.out.printf("[0] voltar\n");
			System.out.printf("[1] adicionar funcionario generico\n");
			System.out.printf("[2] adicionar atendente de caixa\n");
			System.out.printf("[3] adicionar gerente\n");
			System.out.printf("[4] adicionar cliente\n");
			System.out.printf("Escolha: ");
			escolha = scan.nextInt();
			scan.nextLine();
		}
		return escolha;
	}
	public static int escolhaMenuCaixas(){
		int escolha = -1;
		while(escolha<0 || escolha>3){
			System.out.printf("[0] voltar\n");
			System.out.printf("[1] adicionar caixa\n");
			System.out.printf("[2] adicionar cliente ao caixa\n");
			System.out.printf("[3] atender cliente no caixa\n");
			System.out.printf("Escolha: ");
			escolha = scan.nextInt();
			scan.nextLine();
		}
		return escolha;
	}

	public static void executaOpcao(int escolha){
		switch(mercado.getMenu()){
			case 0: //menu principal
				switch(escolha){
					case 0:
						mercado.setExecutando(false);
						System.out.printf("\n\nadeus\n\n");
						return;
					case 1:
						mercado.setMenu(1);
						return;
					case 2:
						mercado.setMenu(2);
						return;
					case 3:
						mercado.setMenu(3);
						return;
				}
			case 1: //menu setores
				switch(escolha){
					case 0:
						mercado.setMenu(0);
						return;
					case 1:
						// adicionarSetor();
						return;
					case 2:
						// adicionarProduto();
						return;
				}
			case 2: //menu pessoas
				switch(escolha){
					case 0:
						mercado.setMenu(0);
						return;
					case 1:
						// adicionarFuncionario();
						return;
					case 2:
						// adicionarAtendenteCaixa();
						return;
					case 3:
						// adicionarGerente();
						return;
					case 4:
						// adicionarCliente();
						return;
				}
			case 3: //menu caixas
				switch(escolha){
					case 0:
						mercado.setMenu(0);
						return;
					case 1:
						// adicionarCaixa();
						return;
					case 2:
						// adicionarClienteCaixa();
						return;
					case 3:
						// atenderClienteCaixa();
						return;
				}
		}
	}
}