import java.util.List;

public class Main {
    private static void listarContas(Banco banco){
        List<Conta> contas = banco.getContas();

        System.out.println("=== Lista de contas do banco \"" + banco.getNome() + "\" ===");

        int count = 0;
        for (Conta conta : contas) {
            count++;
            System.out.println(count + ": " + conta.getCliente().getNome());
        }

        if (count == 0) System.out.println("Nao ha clientes cadastrados neste banco!");

        System.out.println("=== FIM ===");
    }

    public static void main(String[] args) {
        Banco banco = new Banco("Banco brasileiro");

        Conta c1 = new ContaCorrente(new Cliente("Amanda"));
        Conta c2 = new ContaPoupanca(new Cliente("Beto"));
        Conta c3 = new ContaCorrente(new Cliente("Charlie"));

        banco.adicionarConta(c1);
        banco.adicionarConta(c2);
        banco.adicionarConta(c3);

        listarContas(banco);

        c1.imprimirExtrato();
        c2.imprimirExtrato();
        c3.imprimirExtrato();

        c1.depositar(150.00);
        c2.sacar(10.00);
        c2.depositar(50.00);
        c2.sacar(20.00);
        c1.transferir(110.00, c3);
        c3.transferir(200.00, c1);

        c1.imprimirExtrato();
        c2.imprimirExtrato();
        c3.imprimirExtrato();

        banco.removerConta(c2);

        listarContas(banco);
    }
}
