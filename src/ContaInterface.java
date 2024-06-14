
public interface ContaInterface {

	void sacar(double valor);

	void depositar(double valor);

	void transferir(double valor, Conta contaOrigem, Conta contaDestino) throws TranferenciaException;

	void imprimirExtrato();
	
}
