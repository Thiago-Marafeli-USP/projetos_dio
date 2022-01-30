import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void adicionarConta(Conta conta){
        this.contas.add(conta);
    }

    public boolean removerConta(Conta conta){
        if (this.contas.isEmpty()){
            System.out.println("Não ha contas cadastradas neste banco!");
            return false;
        }
        else {
            if (this.contas.remove(conta)){
                System.out.println("Não foi possivel realizar a operacao!");
                return false;
            }
            else {
                System.out.println("Conta retirada com sucesso!");
                return true;
            }
        }
    }
}
