
public abstract class Conta implements ContaInterface {

	protected static final int AGENCIA_PADRAO = 1;
	protected static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		this.saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}

	@Override
	/*
	 * O método recebe a conta de origem e a conta destino Classe Conta, a qual sera
	 * feita a tranferencia de valor
	 */
	public void transferir(double valor, Conta contaOrigem, Conta contaDestino) throws TranferenciaException {
		if (contaDestino.equals(contaOrigem)) {
			/*
			 * Lançando uma exception para o caso de tentar transferir um valor para a mesma
			 * conta
			 */
			throw new TranferenciaException();
		}
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Conta: %s",
				(this.cliente instanceof PessoaFisica) ? "Pessoa Física" : "Pessoa jurídica"));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Conta: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

}
