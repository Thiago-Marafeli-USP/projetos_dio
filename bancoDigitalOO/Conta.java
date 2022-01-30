public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo = 0.00d;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public boolean sacar(double valor) {
        double temp = this.saldo;
        if ((temp - valor) < 0.00){
            System.out.println(this.cliente.getNome() +
                    " nao tem dinheiro suficiente na conta para retirar!");
            return false;
        }
        else {
            this.saldo -= valor;
            return true;
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public boolean transferir(double valor, Conta contaDestino) {
        if(this.sacar(valor)){
            contaDestino.depositar(valor);
            return true;
        }
        else{
            System.out.println("Nao foi possivel realizar a transferencia");
            return false;
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
