import java.util.ArrayList;

public class CaixaRapido extends Caixa{
	private Caixa[] caixasRapidos;
	private boolean[] caixasLivres;
	private ArrayList<Cliente> fila;

	public CaixaRapido(int qtdCaixasRapidos){
		super();
		caixasRapidos = Caixa[qtdCaixasRapidos];
		caixasLivres = new boolean[qtdCaixasRapidos];
		for(int i=0; i<caixasLivres.size(); i++){
			caixasLivres.get(i) = new Boolean(true);
		}
		fila = new ArrayList<Cliente>();
	}

	public void addCliente(Cliente cliente){
		fila.add(cliente);
	}

	@Override
	public void recebeCliente(){
		for(int i=0; i<caixasLivres.size(); i++){
			if(caixasLivres[i]){
				caixasRapidos[i].recebeCliente(fila.get(0));
				caixasLivres[i] = false;
				fila.remove(0);
				break;
			}
		}
	}

	@Override
	public void atendeCliente(int numeroCaixa){
		caixasRapidos[numeroCaixa].atendeCliente(cliente);
		caixasLivres[numeroCaixa] = true;
	}
}