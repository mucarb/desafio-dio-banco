
public class Main {

	public static void main(String[] args) {
		Cliente clienteFisico = new PessoaFisica("Murilo", "Rua Nova 000", "18910101011", "78564312431");
		Cliente clienteJuridico = new PessoaJuridica("Marcio", "Rua Nova 111", "18912222222", "Empresa Ltda.", "44444444444444");

		Conta cc = new ContaCorrente(clienteFisico);
		Conta cp = new ContaPoupanca(clienteJuridico);

		cc.depositar(100.0);
		
		try {
			cc.transferir(100.0, cc, cp);
		} catch (TranferenciaException e) {
			System.err.println("Ação na efetuada: a transferencia esta sendo feita a mesma conta!");
		}

		cc.imprimirExtrato();
		cp.imprimirExtrato();
	}

}
