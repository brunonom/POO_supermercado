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

	//escolhas dos menus
		public static int escolhaMenuPrincipal(){
			int escolha = -1;
			while(escolha<0 || escolha>3){
				System.out.printf("[0] sair\n");
				System.out.printf("[1] menu de setores\n");
				System.out.printf("[2] menu de pessoas\n");
				System.out.printf("[3] menu de caixas\n");
				System.out.printf("escolha: ");
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
				System.out.printf("escolha: ");
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
				System.out.printf("escolha: ");
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
				System.out.printf("escolha: ");
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
						adicionarSetor();
						return;
					case 2:
						adicionarProduto();
						return;
				}
			case 2: //menu pessoas
				switch(escolha){
					case 0:
						mercado.setMenu(0);
						return;
					case 1:
						adicionarFuncionario();
						return;
					case 2:
						adicionarAtendenteCaixa();
						return;
					case 3:
						adicionarGerente();
						return;
					case 4:
						adicionarCliente();
						return;
				}
			case 3: //menu caixas
				switch(escolha){
					case 0:
						mercado.setMenu(0);
						return;
					case 1:
						adicionarCaixa();
						return;
					case 2:
						adicionarClienteCaixa();
						return;
					case 3:
						atenderClienteCaixa();
						return;
				}
		}
	}

	//menu setores
		public static void adicionarSetor(){
			String nome = "";
			while(nome.equals("")){
				System.out.printf("nome: ");
				nome = scan.nextLine();
			}

			Setor novoSetor = new Setor(nome);
			mercado.adicionarSetor(novoSetor);

			System.out.printf("setor adicionado\n");
		}
		public static void adicionarProduto(){
			if(mercado.getSetores().size() == 0){
				System.out.printf("nao existem setores disponiveis\n");
			}
			else{	
				String nome = "";
				while(nome.equals("")){
					System.out.printf("nome: ");
					nome = scan.nextLine();
				}

				double preco = -1;
				while(preco < 0){
					System.out.printf("preco: ");
					preco = scan.nextDouble();
					scan.nextLine();
				}

				int estoque = -1;
				while(estoque < 0){
					System.out.printf("estoque: ");
					estoque = scan.nextInt();
					scan.nextLine();
				}
				Produto novoProduto = new Produto(nome, preco, estoque);
				
				System.out.printf("setor:\n");
				int escolha = -1;
				while(escolha<0 || escolha>mercado.getSetores().size()-1){
					for(int i=0; i<mercado.getSetores().size(); i++){
						System.out.printf("[%d] setor: %s\n", i, mercado.getSetores().get(i).getNome());
					}
					System.out.printf("escolha: ");
					escolha = scan.nextInt();
					scan.nextLine();
				}
				mercado.getSetores().get(escolha).adicionarProduto(novoProduto);

				System.out.printf("produto adicionado\n");
			}
		}

	//menu pessoas
		public static void adicionarFuncionario(){
			String nome = "";
			while(nome.equals("")){
				System.out.printf("nome: ");
				nome = scan.nextLine();
			}

			String rg = "";
			while(rg.equals("")){
				System.out.printf("rg: ");
				rg = scan.nextLine();
			}

			String cpf = "";
			while(cpf.equals("")){
				System.out.printf("cpf: ");
				cpf = scan.nextLine();
			}

			int idade = -1;
			while(idade < 0){
				System.out.printf("idade: ");
				idade = scan.nextInt();
				scan.nextLine();
			}

			double salario = -1;
			while(salario < 0){
				System.out.printf("salario: ");
				salario = scan.nextDouble();
				scan.nextLine();
			}

			Pessoa novaPessoa = new Funcionario(nome, rg, cpf, idade, salario);
			mercado.adicionarPessoa(novaPessoa);

			System.out.printf("funcionario adicionado\n");
		}
		public static void adicionarAtendenteCaixa(){
			if(mercado.getCaixas().size() == 0){
				System.out.printf("nao existem caixas disponiveis\n");
			}
			else{	
				String nome = "";
				while(nome.equals("")){
					System.out.printf("nome: ");
					nome = scan.nextLine();
				}

				String rg = "";
				while(rg.equals("")){
					System.out.printf("rg: ");
					rg = scan.nextLine();
				}

				String cpf = "";
				while(cpf.equals("")){
					System.out.printf("cpf: ");
					cpf = scan.nextLine();
				}

				int idade = -1;
				while(idade < 0){
					System.out.printf("idade: ");
					idade = scan.nextInt();
					scan.nextLine();
				}

				double salario = -1;
				while(salario < 0){
					System.out.printf("salario: ");
					salario = scan.nextDouble();
					scan.nextLine();
				}

				System.out.printf("caixa:\n");
				int escolha = -1;
				while(escolha<0 || escolha>mercado.getCaixas().size()-1){
					for(int i=0; i<mercado.getCaixas().size(); i++){
						System.out.printf("[%d] caixa: %d\n", i, mercado.getCaixas().get(i).getNumero());
					}
					System.out.printf("escolha: ");
					escolha = scan.nextInt();
					scan.nextLine();
				}
				Caixa caixa = mercado.getCaixas().get(escolha);

				Pessoa novaPessoa = new AtendenteCaixa(nome, rg, cpf, idade, salario, caixa);
				mercado.adicionarPessoa(novaPessoa);

				System.out.printf("atendente adicionado\n");
			}
		}
		public static void adicionarGerente(){
			String nome = "";
			while(nome.equals("")){
				System.out.printf("nome: ");
				nome = scan.nextLine();
			}

			String rg = "";
			while(rg.equals("")){
				System.out.printf("rg: ");
				rg = scan.nextLine();
			}

			String cpf = "";
			while(cpf.equals("")){
				System.out.printf("cpf: ");
				cpf = scan.nextLine();
			}

			int idade = -1;
			while(idade < 0){
				System.out.printf("idade: ");
				idade = scan.nextInt();
				scan.nextLine();
			}

			double salario = -1;
			while(salario < 0){
				System.out.printf("salario: ");
				salario = scan.nextDouble();
				scan.nextLine();
			}

			Pessoa novaPessoa = new Gerente(nome, rg, cpf, idade, salario);
			mercado.adicionarPessoa(novaPessoa);

			System.out.printf("gerente adicionado\n");
		}
		public static void adicionarCliente(){
			String nome = "";
			while(nome.equals("")){
				System.out.printf("nome: ");
				nome = scan.nextLine();
			}

			String rg = "";
			while(rg.equals("")){
				System.out.printf("rg: ");
				rg = scan.nextLine();
			}

			String cpf = "";
			while(cpf.equals("")){
				System.out.printf("cpf: ");
				cpf = scan.nextLine();
			}

			int idade = -1;
			while(idade < 0){
				System.out.printf("idade: ");
				idade = scan.nextInt();
				scan.nextLine();
			}

			String email = "";
			while(email.equals("")){
				System.out.printf("email: ");
				email = scan.nextLine();
			}

			Pessoa novaPessoa = new Cliente(nome, rg, cpf, idade, email);
			mercado.adicionarPessoa(novaPessoa);

			System.out.printf("cliente adicionado\n");
		}

	//menu caixas
		public static void adicionarCaixa(){

			// System.out.printf("tipo: ");
			// int escolha = -1;
			// while(escolha<0 || escolha>1){
			// 	System.out.printf("[0] caixa comum\n");
			// 	System.out.printf("[1] caixa rapido\n");
			// 	System.out.printf("escolha: ");
			// 	escolha = scan.nextInt();
			// 	scan.nextLine();
			// }

			// if(escolha == 0){
				Caixa novoCaixa = new Caixa();
				mercado.adicionarCaixa(novoCaixa);
			// }
			// else{
			// 	int qtdCaixas = -1;
			// 	while(qtdCaixas < 1){
			// 		System.out.printf("qtdCaixas: ");
			// 		qtdCaixas = scan.nextInt();
			// 		scan.nextLine();
			// 	}

			// 	Caixa novoCaixa = new CaixaRapido(qtdCaixas);
			// 	mercado.adicionarCaixa(novoCaixa);
			// }

			System.out.printf("caixa adicionado\n");
		}
		public static void adicionarClienteCaixa(){
			if(mercado.getCaixas().size() == 0){
				System.out.printf("nao existem caixas dsponiveis\n");
			}
			else{
				System.out.printf("tipo: ");
				int escolha = -1;
				while(escolha<0 || escolha>1){
					System.out.printf("[0] cliente comum\n");
					System.out.printf("[1] cliente cadastrado\n");
					System.out.printf("escolha: ");
					escolha = scan.nextInt();
					scan.nextLine();
				}

				Cliente clienteAdicionado = null;
				if(escolha == 0){
					clienteAdicionado = new Cliente();
				}
				else{
					if(mercado.contaClientes() == 0){
						System.out.printf("nao existem clientes cadastrados\n");
					}
					else{
						System.out.printf("cliente:\n");
						escolha = -1;
						while(clienteAdicionado == null){
							for(int i=0; i<mercado.getPessoas().size(); i++){
								if(mercado.getPessoas().get(i) instanceof Cliente){
									System.out.printf("[%d] nome: %s\n", i, mercado.getPessoas().get(i).getNome());
								}
							}
							System.out.printf("escolha: ");
							escolha = scan.nextInt();
							scan.nextLine();
							if(mercado.getPessoas().get(escolha) instanceof Cliente){
								clienteAdicionado = (Cliente)mercado.getPessoas().get(escolha);
							}
						}
					}
				}

				if(clienteAdicionado == null){
					System.out.printf("nao foi possivel adicionar o cliente\n");
				}
				else{
					System.out.printf("caixa:\n");
					escolha = -1;
					while(escolha<0 || escolha>mercado.getCaixas().size()-1){
						for(int i=0; i<mercado.getCaixas().size(); i++){
							System.out.printf("[%d] caixa: %d\n", i, mercado.getCaixas().get(i).getNumero());
						}
						System.out.printf("escolha: ");
						escolha = scan.nextInt();
						scan.nextLine();
					}
					Caixa caixa = mercado.getCaixas().get(escolha);

					// if(caixa instanceof CaixaRapido){
					// 	System.out.printf("caixa rapido:\n");
					// 	int escolha = -1;
					// 	while(escolha<0 || escolha>caixa.getQtdCaixas()-1){
					// 		for(int i=0; i<caixa.getQtdCaixas(); i++){
					// 			System.out.printf("[%d] caixa rapido: %d\n", i, i+1);
					// 		}
					// 		escolha = scan.nextInt();
					// 		scan.nextLine();
					// 	}
					// 	/*foi aqui que percebi que nao quero lidar com caixa rapido
					// 	ta confuso e chato, e provavelmente errado, tira?*/
					// }
					// else{

					// }

					caixa.recebeCliente(clienteAdicionado);

					System.out.printf("cliente adicionado");
				}
			}
		}
		public static void atenderClienteCaixa(){
			if(mercado.getCaixas().size() == 0){
				System.out.printf("nao existem caixas disponiveis\n");
			}
			else{
				System.out.printf("caixa:\n");
				int escolha = -1;
				while(escolha<0 || escolha>mercado.getCaixas().size()-1){
					for(int i=0; i<mercado.getCaixas().size(); i++){
						System.out.printf("[%d] caixa: %d\n", i, mercado.getCaixas().get(i).getNumero());
					}
					System.out.printf("escolha: ");
					escolha = scan.nextInt();
					scan.nextLine();
				}
				Caixa caixa = mercado.getCaixas().get(escolha);

				caixa.atendeCliente();

				System.out.printf("cliente atendido\n");
			}
		}
}