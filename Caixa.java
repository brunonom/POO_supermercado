import java.util.ArrayList;

public class Caixa{
	private static int geradorNumero = 0;
	private int numero;
	private Cliente clienteAtual;
	// private boolean disponivel;

	public Caixa(){
		setNumero();
		clienteAtual = new Cliente();
		// disponivel = true;
	}

	public void setNumero(){
		this.numero = ++geradorNumero;
	}
	public int getNumero(){
		return numero;
	}
	public Cliente getCliente(){
		return clienteAtual;
	}
	// public boolean getDisponivel(){
	// 	return disponivel;
	// }

	public void recebeCliente(Cliente cliente){
		clienteAtual = cliente;
		// disponivel = false;
	}

	public void atendeCliente(){
		clienteAtual.realizaCompra();
		// disponivel = true;
	}
}