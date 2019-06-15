import java.util.Scanner;

public class AplicacaoSupermercado{
	private static Supermercado mercado = new Supermercado();
	private static Scanner scan = new Scanner(System.in);
	private static Caixa caixaAcessado;

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
				case 4:
					opcao = escolhaMenuCaixaEspecifico();
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
			while(escolha<0 || escolha>mercado.getCaixas().size()+1){
				System.out.printf("[0] voltar\n");
				System.out.printf("[1] adicionar caixa\n");
				for(int i=0; i<mercado.getCaixas().size(); i++){
					System.out.printf("[%d] acessar caixa %d\n", i+2, mercado.getCaixas().get(i).getNumero());
				}
				System.out.printf("escolha: ");
				escolha = scan.nextInt();
				scan.nextLine();
			}
			return escolha;
		}
		public static int escolhaMenuCaixaEspecifico(){
			int escolha = -1;
			while(escolha<0 || escolha>2){
				System.out.printf("[0] voltar\n");
				System.out.printf("[1] atender cliente\n");
				System.out.printf("[2] adicionar item\n");
				System.out.printf("[3] ver dados da compra\n");
				System.out.printf("[4] realizar compra\n");
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
					default:
						caixaAcessado = mercado.getCaixas().get(escolha-2);
						mercado.setMenu(4);
						return;
				}
			case 4: //menu caixa especifico
				switch(escolha){
					case 0:
						mercado.setMenu(3);
						caixaAcessado = null;
						return;
					case 1:
						atenderCliente();
						return;
					case 2:
						adicionarItem();
						return;
					case 3:
						getDadosCompra();
						return;
					case 4:
						realizarCompra();
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

	//menu caixa especifico
		public static void atenderCliente(){
			if(!caixaAcessado.getPossuiAtendente()){
				System.out.printf("este caixa nao possui atendente\n");
			}
			else{
				if(caixaAcessado.getPossuiCliente()){
					System.out.printf("este caixa ja esta ocupado\n");
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
						caixaAcessado.atendeCliente(clienteAdicionado);
						System.out.printf("cliente adicionado\n");
					}
				}
			}
		}
		public static void adicionarItem(){
			if(!caixaAcessado.getPossuiCliente()){
				System.out.printf("este caixa nao possui cliente\n");	
			}
			else{
				if(mercado.contaProdutos() == 0){
					System.out.printf("nao existem produtos disponiveis\n");	
				}
				else{
					int escolha = -1;
					while(escolha<0 || escolha>mercado.getSetores().size()-1){
						System.out.printf("setor:\n");
						for(int i=0; i<mercado.getSetores().size(); i++){
							Setor setorAtual = mercado.getSetores().get(i);
							System.out.printf("[%d] nome: %s\n", setorAtual.getNome());
						}
						System.out.printf("escolha: ");
						escolha = scan.nextInt();
						scan.nextLine();
					}
					Setor setorDoProduto = mercado.getSetores().get(escolha);

					escolha = -1;
					while(escolha<0 || escolha>setorDoProduto.getProdutos().size()-1){
						System.out.printf("produto:\n");
						for(int i=0; i<setorDoProduto.getProdutos().size(); i++){
							Produto produtoAtual = setorDoProduto.getProdutos().get(i);
							System.out.printf("[%d] nome: %s", produtoAtual.getNome());
						}
						System.out.printf("escolha: ");
						escolha = scan.nextInt();
						scan.nextLine();
					}
					Produto produtoItem = setorDoProduto.getProdutos().get(escolha);

					int quantidadeItem = -1;
					while(quantidadeItem<0 || quantidadeItem>produtoItem.getEstoque()){
						System.out.printf("quantidade (max %d): ", produtoItem.getEstoque());
						quantidadeItem = scan.nextInt();
						scan.nextLine();
					}

					Item novoItem = new Item(produtoItem, quantidadeItem);
					caixaAcessado.adicionaItem(novoItem);

					System.out.printf("item adicionado\n");
				}
			}
		}
		public static void getDadosCompra(){
			if(!caixaAcessado.getPossuiCliente()){
				System.out.printf("este caixa nao possui cliente\n");	
			}
			else{
				caixaAcessado.getDadosCompra();
			}
		}
		public static void realizarCompra(){

		}
}