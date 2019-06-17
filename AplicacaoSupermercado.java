import java.util.Scanner;

public class AplicacaoSupermercado{
	private static Supermercado mercado = new Supermercado();
	private static Scanner scan = new Scanner(System.in);
	private static Setor setorAcessado;
	private static Pessoa pessoaAcessada;
	private static Caixa caixaAcessado;
	private static Produto produtoAcessado;
	private static boolean executando;
	private static int menu;
	//0=principal; 1=setores, 2=pessoas, 3=caixas, 4=setor especifico
	//5=pessoa especifica, 6=caixa especifico, 7=produto especifico

	public static void main(String[] args){
		executando = true;
		menu = 0;
		int opcao = -1;
		while(executando){
			switch(menu){
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
					opcao = escolhaMenuSetorEspecifico();
					break;
				case 5:
					opcao = escolhaMenuPessoaEspecifica();
					break;
				case 6:
					opcao = escolhaMenuCaixaEspecifico();
					break;
				case 7:
					opcao = escolhaMenuProdutoEspecifico();
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
			while(escolha<0 ||  escolha>mercado.getSetores().size()+1){
				System.out.printf("[0] voltar\n");
				System.out.printf("[1] adicionar setor\n");
				for(int i=0; i<mercado.getSetores().size(); i++){
					Setor setorX = mercado.getSetores().get(i);
					System.out.printf("[%d] acessar setor: %s\n", i+2, setorX.getNome());
				}
				System.out.printf("escolha: ");
				escolha = scan.nextInt();
				scan.nextLine();
			}
			return escolha;
		}
		public static int escolhaMenuPessoas(){
			int escolha = -1;
			while(escolha<0 || escolha>mercado.getPessoas().size()+4){
				System.out.printf("[0] voltar\n");
				System.out.printf("[1] adicionar funcionario generico\n");
				System.out.printf("[2] adicionar atendente de caixa\n");
				System.out.printf("[3] adicionar gerente\n");
				System.out.printf("[4] adicionar cliente\n");
				for(int i=0; i<mercado.getPessoas().size(); i++){
					Pessoa pessoaX = mercado.getPessoas().get(i);
					System.out.printf("[%d] acessar pessoa: %s ", i+5, pessoaX.getNome());
					if(pessoaX instanceof AtendenteCaixa){
						System.out.printf("(atendente de caixa)\n");
					}
					else if(pessoaX instanceof Gerente){
						System.out.printf("(gerente)\n");
					}
					else if(pessoaX instanceof Funcionario){
						System.out.printf("(funcionario generico)\n");
					}
					else if(pessoaX instanceof Cliente){
						System.out.printf("(cliente)\n");
					}
					else{
						System.out.printf("\n");
					}
				}
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
					Caixa caixaX = mercado.getCaixas().get(i);
					System.out.printf("[%d] acessar caixa numero %d\n", i+2, caixaX.getNumero());
				}
				System.out.printf("escolha: ");
				escolha = scan.nextInt();
				scan.nextLine();
			}
			return escolha;
		}
		public static int escolhaMenuSetorEspecifico(){
			int escolha = -1;
			while(escolha<0 || escolha>setorAcessado.getProdutos().size()+3){
				System.out.printf("[0] voltar\n");
				System.out.printf("[1] adicionar produto\n");
				System.out.printf("[2] ver dados do setor\n");
				System.out.printf("[3] remover setor\n");
				for(int i=0; i<setorAcessado.getProdutos().size(); i++){
					Produto produtoX = setorAcessado.getProdutos().get(i);
					System.out.printf("[%d] acessar produto: %s\n", i+4, produtoX.getNome());
				}
				System.out.printf("escolha: ");
				escolha = scan.nextInt();
				scan.nextLine();
			}
			return escolha;
		}
		public static int escolhaMenuPessoaEspecifica(){
			int escolha = -1;
			while(escolha<0 || escolha>3){
				System.out.printf("[0] voltar\n");
				System.out.printf("[1] ver dados da pessoa\n");
				System.out.printf("[2] alterar dados da pessoa\n");
				System.out.printf("[3] remover pessoa\n");
				System.out.printf("escolha: ");
				escolha = scan.nextInt();
				scan.nextLine();
			}
			return escolha;
		}
		public static int escolhaMenuCaixaEspecifico(){
			int escolha = -1;
			while(escolha<0 || escolha>5){
				System.out.printf("[0] voltar\n");
				System.out.printf("[1] atender cliente\n");
				System.out.printf("[2] adicionar item\n");
				System.out.printf("[3] ver dados da compra\n");
				System.out.printf("[4] realizar compra\n");
				System.out.printf("[5] remover caixa\n");
				System.out.printf("escolha: ");
				escolha = scan.nextInt();
				scan.nextLine();
			}
			return escolha;
		}
		public static int escolhaMenuProdutoEspecifico(){
			int escolha = -1;
			while(escolha<0 || escolha>3){
				System.out.printf("[0] voltar\n");
				System.out.printf("[1] ver dados do produto\n");
				System.out.printf("[2] alterar dados do produto\n");
				System.out.printf("[3] remover produto\n");
				System.out.printf("escolha: ");
				escolha = scan.nextInt();
				scan.nextLine();
			}
			return escolha;
		}

	public static void executaOpcao(int escolha){
		switch(menu){
			case 0: //menu principal
				switch(escolha){
					case 0: //sair
						executando = false;
						System.out.printf("\n\nadeus\n\n");
						return;
					case 1: //ir menu setores
						menu = 1;
						return;
					case 2: //ir menu pessoas
						menu = 2;
						return;
					case 3: //ir menu caixas
						menu = 3;
						return;
				}
			case 1: //menu setores
				switch(escolha){
					case 0: //voltar menu principal
						menu = 0;
						return;
					case 1: //adicionar setor
						adicionarSetor();
						return;
					default: //ir menu setor especifico
						setorAcessado = mercado.getSetores().get(escolha - 2);
						menu = 4;
						return;
				}
			case 2: //menu pessoas
				switch(escolha){
					case 0: //voltar menu principal
						menu = 0;
						return;
					case 1: //adicionar funcionario
						adicionarFuncionario();
						return;
					case 2: //adicionar atendente caixa
						adicionarAtendenteCaixa();
						return;
					case 3: //adicionar gerente
						adicionarGerente();
						return;
					case 4: //adicionar cliente
						adicionarCliente();
						return;
					default: //ir pessoa especifica
						pessoaAcessada = mercado.getPessoas().get(escolha - 5);
						menu = 5;
						return;
				}
			case 3: //menu caixas
				switch(escolha){
					case 0: //voltar menu principal
						menu = 0;
						return;
					case 1: //adicionar caixa
						adicionarCaixa();
						return;
					default: //ir caixa especifico
						caixaAcessado = mercado.getCaixas().get(escolha - 2);
						menu = 6;
						return;
				}
			case 4: //menu setor especifico
				switch(escolha){
					case 0: //voltar menu setores
						menu = 1;
						setorAcessado = null;
						return;
					case 1: //adicionar produto
						adicionaProduto();
						return;
					case 2: //ver dados do setor
						System.out.printf("%s\n", setorAcessado.getInfo());
						return;
					case 3: //remover setor
						removeSetor();
						return;
					default: //acessar produto especifico
						produtoAcessado = setorAcessado.getProdutos().get(escolha - 4);
						menu = 7;
						return;
				}
			case 5: //menu pessoa especifica
				switch(escolha){
					case 0: //voltar menu pessoas
						menu = 2;
						pessoaAcessada = null;
						return;
					case 1: //ver dados pessoa
						System.out.printf("%s\n", pessoaAcessada.getInfo());
						return;
					case 2: //alterar dados pessoa
						alteraInfoPessoa();
						return;
					case 3: //remover pessoa
						removePessoa();	
						return;
				}
			case 6: //menu caixa especifico
				switch(escolha){
					case 0: //voltar menu caixas
						menu = 3;
						caixaAcessado = null;
						return;
					case 1: //atender cliente
						atendeCliente();
						return;
					case 2: //adicionar item compra
						adicionaItem();
						return;
					case 3: //ver dados compra
						getDadosCompra();
						return;
					case 4: //realizar compra
						realizaCompra();
						return;
					case 5: //remover caixa
						removeCaixa();
						return;
				}
			case 7: //menu produto especifico
				switch(escolha){
					case 0: //voltar menu setor especifico
						menu = 4;
						produtoAcessado = null;
						return;
					case 1: //ver dados do produto
						System.out.printf("%s\n", produtoAcessado.getInfo());
						return;
					case 2: //alterar dados do produto
						alteraInfoProduto();
						return;
					case 3: //remover produto
						removeProduto();
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
			if(mercado.getCaixas().size() == 0 || mercado.contaCaixasSemAtendente() == 0){
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

				Caixa caixa = null;
				System.out.printf("caixa:\n");
				while(caixa == null){
					
					int escolha = -1;
					while(escolha<0 || escolha>mercado.getCaixas().size()-1){
						for(int i=0; i<mercado.getCaixas().size(); i++){
							Caixa caixaX = mercado.getCaixas().get(i);
							if(!caixaX.getPossuiAtendente()){
								System.out.printf("[%d] atender caixa %d\n", i, caixaX.getNumero());
							}
						}
						System.out.printf("escolha: ");
						escolha = scan.nextInt();
						scan.nextLine();
					}

					if(!mercado.getCaixas().get(escolha).getPossuiAtendente()){
						caixa = mercado.getCaixas().get(escolha);
					}
				}

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
			Caixa novoCaixa = new Caixa();
			mercado.adicionarCaixa(novoCaixa);

			System.out.printf("caixa adicionado\n");
		}

	//menu setor especifico
		public static void adicionaProduto(){	
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
			
			setorAcessado.adicionaProduto(novoProduto);

			System.out.printf("produto adicionado\n");
		}
		public static void removeSetor(){
			for(int i=0; i<mercado.getSetores().size(); i++){
				Setor setorX = mercado.getSetores().get(i);
				for(int j=0; j<setorX.getProdutos().size(); j++){
					Produto produtoX = setorX.getProdutos().get(j);
					for(int k=0; k<mercado.getCaixas().size(); k++){
						Caixa caixaX = mercado.getCaixas().get(k);
						Cliente clienteX = caixaX.getClienteAtual();
						if(clienteX != null){
							for(int l=0; l<clienteX.getCompras().size(); l++){
								Item itemX = clienteX.getCompras().get(l);
								if(produtoX == itemX.getProduto()){
									System.out.printf("produtos no setor estao sendo comprados\n");
									System.out.printf("setor nao removido\n");
									return;
								}
							}
						}
					}	
				}
			}

			mercado.getSetores().remove(setorAcessado);
			menu = 1;
			setorAcessado = null;
			System.out.printf("setor removido\n");
		}

	//menu pessoa especifica
		public static void alteraInfoPessoa(){
			if(pessoaAcessada instanceof AtendenteCaixa){
				AtendenteCaixa atendenteCaixaX = (AtendenteCaixa)pessoaAcessada;
				if(mercado.getCaixas().size() == 0 || mercado.contaCaixasSemAtendente() == 0){
					System.out.printf("nao existem caixas disponiveis\n");
					System.out.printf("dados nao alterados\n");
					return;
				}
				else{
					if(atendenteCaixaX.getCaixa().getPossuiCliente()){
						System.out.printf("possui cliente em atendimento\n");
						System.out.printf("dados nao alterados\n");
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

						Caixa caixa = null;
						System.out.printf("caixa:\n");
						while(caixa == null){
							
							int escolha = -1;
							while(escolha<0 || escolha>mercado.getCaixas().size()-1){
								for(int i=0; i<mercado.getCaixas().size(); i++){
									Caixa caixaX = mercado.getCaixas().get(i);
									if(!caixaX.getPossuiAtendente()){
										System.out.printf("[%d] atender caixa %d\n", i, caixaX.getNumero());
									}
								}
								System.out.printf("escolha: ");
								escolha = scan.nextInt();
								scan.nextLine();
							}

							if(!mercado.getCaixas().get(escolha).getPossuiAtendente()){
								caixa = mercado.getCaixas().get(escolha);
							}
						}

						atendenteCaixaX.alteraInfo(nome, rg, cpf, idade, salario, caixa);
						System.out.printf("dados alterados\n");
					}	
				}
			}
			else if(pessoaAcessada instanceof Funcionario){
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

				Funcionario funcionarioX = (Funcionario)pessoaAcessada;
				funcionarioX.alteraInfo(nome, rg, cpf, idade, salario);
				System.out.printf("dados alterados\n");
			}
			else if(pessoaAcessada instanceof Cliente){
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

				Cliente clienteX = (Cliente)pessoaAcessada;
				clienteX.alteraInfo(nome, rg, cpf, idade, email);
				System.out.printf("dados alterados\n");
			}
			else{
				System.out.printf("dados nao alterados\n");
			}
		}
		public static void removePessoa(){
			if(pessoaAcessada instanceof AtendenteCaixa){
				AtendenteCaixa atendenteCaixaX = (AtendenteCaixa)pessoaAcessada;
				for(int i=0; i<mercado.getCaixas().size(); i++){
					Caixa caixaX = mercado.getCaixas().get(i);
					if(caixaX.getPossuiAtendente() && caixaX.getPossuiCliente()){
						if(atendenteCaixaX.getCaixa() == caixaX){
							System.out.printf("atendente esta atendendo um cliente\n");
							System.out.printf("pessoa nao removida\n");
							return;
						}
					}
				}
				atendenteCaixaX.getCaixa().setPossuiAtendente(false);
				mercado.getPessoas().remove(atendenteCaixaX);
				menu = 2;
				pessoaAcessada = null;
				System.out.printf("pessoa removida\n");
			}
			else if(pessoaAcessada instanceof Funcionario){
				mercado.getPessoas().remove(pessoaAcessada);
				menu = 2;
				pessoaAcessada = null;
				System.out.printf("pessoa removida\n");
			}
			else if(pessoaAcessada instanceof Cliente){
				Cliente clienteX = (Cliente)pessoaAcessada;
				for(int i=0; i<mercado.getCaixas().size(); i++){
					Caixa caixaX = mercado.getCaixas().get(i);
					if(clienteX == caixaX.getClienteAtual()){
						System.out.printf("cliente esta realizando compras\n");
						System.out.printf("pessoa nao removida\n");
						return;
					}
				}
				mercado.getPessoas().remove(clienteX);
				menu = 2;
				pessoaAcessada = null;
				System.out.printf("pessoa removida\n");
			}
			else{
				System.out.printf("pessoa nao removida\n");
				return;
			}
		}

	//menu caixa especifico
		public static void atendeCliente(){
			if(!caixaAcessado.getPossuiAtendente()){
				System.out.printf("este caixa nao possui atendente\n");
			}
			else{
				if(caixaAcessado.getPossuiCliente()){
					System.out.printf("este caixa ja esta ocupado\n");
				}
				else{
					System.out.printf("tipo:\n");
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
							while(clienteAdicionado == null){
								escolha = -1;
								while(escolha<0 || escolha>mercado.getPessoas().size()-1){
									for(int i=0; i<mercado.getPessoas().size(); i++){
										if(mercado.getPessoas().get(i) instanceof Cliente){
											Cliente clienteX = (Cliente)mercado.getPessoas().get(i);
											boolean clienteXNaoAtendido = true;
											for(int j=0; j<mercado.getCaixas().size(); j++){
												Caixa caixaX = mercado.getCaixas().get(j);
												if(caixaX.getClienteAtual() == clienteX){
													clienteXNaoAtendido = false;
												}
											}
											if(clienteXNaoAtendido){
												System.out.printf("[%d] nome: %s\n", i, clienteX.getNome());
											}
										}
									}
									System.out.printf("escolha: ");
									escolha = scan.nextInt();
									scan.nextLine();
								}

								if(mercado.getPessoas().get(escolha) instanceof Cliente){
									clienteAdicionado = (Cliente)mercado.getPessoas().get(escolha);
									for(int j=0; j<mercado.getCaixas().size(); j++){
										Caixa caixaX = mercado.getCaixas().get(j);
										if(caixaX.getClienteAtual() == clienteAdicionado){
											clienteAdicionado = null;
										}
									}	
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
		public static void adicionaItem(){
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
							Setor setorX = mercado.getSetores().get(i);
							System.out.printf("[%d] nome: %s\n", i, setorX.getNome());
						}
						System.out.printf("escolha: ");
						escolha = scan.nextInt();
						scan.nextLine();
					}
					Setor setorDoProduto = mercado.getSetores().get(escolha);

					Produto produtoItem = null;
					while(produtoItem == null){
						escolha = -1;
						while(escolha<0 || escolha>setorDoProduto.getProdutos().size()-1){
							System.out.printf("produto:\n");
							for(int i=0; i<setorDoProduto.getProdutos().size(); i++){
								Produto produtoX = setorDoProduto.getProdutos().get(i);
								Cliente clienteX = caixaAcessado.getClienteAtual();
								boolean produtoJaAdicionado = false;
								if(clienteX != null){
									for(int j=0; j<clienteX.getCompras().size(); j++){
										Item itemX = clienteX.getCompras().get(j);
										if(itemX.getProduto() == produtoX){
											produtoJaAdicionado = true;
										}
									}
								}
								if(!produtoJaAdicionado){
									System.out.printf("[%d] nome: %s\n", i, produtoX.getNome());
								}
							}
							System.out.printf("escolha: ");
							escolha = scan.nextInt();
							scan.nextLine();
						}

						produtoItem = setorDoProduto.getProdutos().get(escolha);
						Cliente clienteX = caixaAcessado.getClienteAtual();
						if(clienteX != null){
							for(int j=0; j<clienteX.getCompras().size(); j++){
								Item itemX = clienteX.getCompras().get(j);
								if(itemX.getProduto() == produtoItem){
									produtoItem = null;
								}
							}
						}
					}

					int quantidadeItem = 0;
					if(produtoItem.getEstoque()>0){
						quantidadeItem = -1;
						while(quantidadeItem<0 || quantidadeItem>produtoItem.getEstoque()){
							System.out.printf("quantidade (max %d): ", produtoItem.getEstoque());
							quantidadeItem = scan.nextInt();
							scan.nextLine();
						}
					}
					else{
						System.out.printf("produto em falta\n");
						System.out.printf("item nao adicionado\n");
						return;
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
				System.out.printf("%s\n", caixaAcessado.getDadosCompra());
			}
		}
		public static void realizaCompra(){
			if(!caixaAcessado.getPossuiCliente()){
				System.out.printf("este caixa nao possui cliente\n");	
			}
			else{
				System.out.printf("%s\n", caixaAcessado.getDadosCompra());
				caixaAcessado.realizaCompra();
				System.out.printf("compra realizada\n");
			}
		}
		public static void removeCaixa(){
			if(caixaAcessado.getPossuiCliente()){
				System.out.printf("caixa esta ocupado por cliente\n");
				System.out.printf("caixa nao removido\n");
				return;
			}
			if(caixaAcessado.getPossuiAtendente()){
				System.out.printf("caixa possui atendente designado\n");
				System.out.printf("caixa nao removido\n");
				return;
			}

			mercado.getCaixas().remove(caixaAcessado);
			menu = 3;
			caixaAcessado = null;
			System.out.printf("caixa removido\n");
		}

	//menu produto especifico
		public static void alteraInfoProduto(){
			for(int i=0; i<mercado.getCaixas().size(); i++){
				Caixa caixaX = mercado.getCaixas().get(i);
				Cliente clienteX = caixaX.getClienteAtual();
				if(clienteX != null){
					for(int j=0; j<clienteX.getCompras().size(); j++){
						Item itemX = clienteX.getCompras().get(j);
						if(produtoAcessado == itemX.getProduto()){
							System.out.printf("produto esta sendo comprado\n");
							System.out.printf("dados nao alterados\n");
							return;
						}
					}
				} 
			}

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
			
			produtoAcessado.alteraInfo(nome, preco, estoque);

			System.out.printf("dados alterados\n");
		}
		public static void removeProduto(){
			for(int i=0; i<mercado.getCaixas().size(); i++){
				Caixa caixaX = mercado.getCaixas().get(i);
				Cliente clienteX = caixaX.getClienteAtual();
				if(clienteX != null){
					for(int j=0; j<clienteX.getCompras().size(); j++){
						Item itemX = clienteX.getCompras().get(j);
						if(produtoAcessado == itemX.getProduto()){
							System.out.printf("produto esta sendo comprado\n");
							System.out.printf("produto nao removido\n");
							return;
						}
					}
				}
			}	

			setorAcessado.getProdutos().remove(produtoAcessado);
			menu = 4;
			produtoAcessado = null;
			System.out.printf("produto removido\n");
		}
}