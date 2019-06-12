import java.util.Scanner;

public interface CRUD{
	Scanner leitor = new Scanner(System.in);
	Object criaInstancia();
	Object removeInstancia();
	Object editaInstancia();
	Object consultaInstancia();
}