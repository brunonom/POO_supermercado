import java.util.ArrayList;

public class CaixaRapido extends Caixa{
	private ArrayList<Caixa> caixasRapidos;
	private ArrayLIst<Boolean> caixasLivres;

	public CaixaRapido(int qtdCaixasRapidos){
		super();
		caixasRapidos = new ArrayList<Caixa>(qtdCaixasRapidos);
		caixasLivres = new ArrayList<Boolean>(qtdCaixasRapidos);
		for(int i=0; i<caixasLivres.size(); i++){
			caixasLivres.get(i) = new Boolean(true);
		}
	}

	@Override
	public void addCliente(Cliente cliente){
		for(int i=0; i<caixasLivres.size(); i++){
			if(caixasLivres.get(i).booleanValue()){
				caixasRapidos.get(i).addCliente(cliente);
				caixasLivres.get(i) = new Boolean(false);
				break;
			}
		}
	}

	@Override
	public void atendeCliente(int numeroCaixa){
		caixasRapidos.get(numeroCaixa).atendeCliente(cliente);
		caixasLivres.get(numeroCaixa) = new Boolean(true);
	}
}