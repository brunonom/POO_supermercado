import java.util.ArrayList;

public class CaixaRapido extends Caixa{
	private int qtdCaixas;
	private Caixa[] caixasRapidos;
	private boolean[] caixasLivres;

	public CaixaRapido(int qtdCaixas){
		super();
		this.qtdCaixas = qtdCaixas;
		caixasRapidos = new Caixa[qtdCaixas];
		caixasLivres = new boolean[qtdCaixas];
		for(int i=0; i<qtdCaixas; i++){
			caixasLivres[i] = true;
		}
	}

	@Override
	public void recebeCliente(Cliente cliente){
		for(int i=0; i<qtdCaixas; i++){
			if(caixasLivres[i]){
				caixasRapidos[i].recebeCliente(cliente);
				caixasLivres[i] = false;
				break;
			}
		}
	}

	public void atendeCliente(int numeroCaixa){
		caixasRapidos[numeroCaixa].atendeCliente();
		caixasLivres[numeroCaixa] = true;
	}
}