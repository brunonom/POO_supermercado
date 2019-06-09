import java.util.ArrayList;

public class Caixa {
	private int numero;
	private ArrayList<Cliente> fila;

	public Caixa(int numero){
		this.numero = numero;
		fila = new ArrayList<Cliente>();
	}

	public void addCliente(Cliente cliente){
		fila.add(cliente);
	}

	public void atenteCliente(){
		fila.get(0).realizaCompra();
		fila.remove(0);
	}
}