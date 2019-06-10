import java.util.ArrayList;

public class Caixa {
	private static int geradorNumero = 0;
	private int numero;
	private ArrayList<Cliente> fila;

	public Caixa(){
		setNumero();
		fila = new ArrayList<Cliente>();
	}

	public void setNumero(){
		this.numero = ++geradorNumero;
	}

	public void addCliente(Cliente cliente){
		fila.add(cliente);
	}

	public void atenteCliente(){
		fila.get(0).realizaCompra();
		fila.remove(0);
	}
}