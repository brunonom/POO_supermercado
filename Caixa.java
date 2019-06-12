import java.util.ArrayList;

public class Caixa {
	private static int geradorNumero = 0;
	private int numero;
	private Cliente clienteAtual;

	public Caixa(){
		setNumero();
	}

	public void setNumero(){
		this.numero = ++geradorNumero;
	}

	public void recebeCliente(Cliente cliente){
		clienteAtual = cliente;
	}

	public void atenteCliente(){
		cliente.realizaCompra();
	}
}