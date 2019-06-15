// import java.util.ArrayList;

// public class CaixaRapido extends Caixa{
// 	private ArrayList<Caixa> caixasRapidos;

// 	public CaixaRapido(int qtdCaixas){
// 		super();
// 		caixasRapidos = new ArrayList<Caixa>();
// 	}

// 	public int getQtdCaixas(){
// 		return qtdCaixas;
// 	}

// 	@Override
// 	public void recebeCliente(Cliente cliente){
// 		for(int i=0; i<qtdCaixas; i++){
// 			if(caixasLivres[i]){
// 				caixasRapidos[i].recebeCliente(cliente);
// 				caixasLivres[i] = false;
// 				break;
// 			}
// 		}
// 	}

// 	public void atendeCliente(int numeroCaixa){
// 		caixasRapidos[numeroCaixa].atendeCliente();
// 		caixasLivres[numeroCaixa] = true;
// 	}
// }