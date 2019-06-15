import java.util.ArrayList;

public class Caixa{
	private static int geradorNumero = 0;
	private int numero;
	private Cliente clienteAtual;
	private boolean possuiAtendente;
	private boolean possuiCliente;


	public Caixa(){
		setNumero();
		possuiCliente = false;
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
	public void setPossuiAtendente(boolean possuiAtendente){
		this.possuiAtendente = possuiAtendente;
	}
	public void setPossuiAtendente(){
		this.possuiAtendente = true;
	}
	public boolean getPossuiAtendente(){
		return possuiAtendente;
	}
	public boolean getPossuiCliente(){
		return possuiCliente;
	}

	public void atendeCliente(Cliente cliente){
		clienteAtual = cliente;
		possuiCliente = true;
	}

	public void adicionaItem(Item item){
		clienteAtual.adicionaItem(item);
	}

	public String getDadosCompra(){
		return clienteAtual.getDadosCompra();
	}

	public void realizaCompra(){
		clienteAtual.realizaCompra();
		possuiCliente = false;
	}
}