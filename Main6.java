import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String email;
    private String telefone;
    private List<Double> compras;

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.compras = new ArrayList<>();
    }

    public void adicionarCompra(double valor) {
        compras.add(valor);
    }

    public double getValorTotalCompras() {
        double total = 0;
        for (double valor : compras) {
            total += valor;
        }
        return total;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public static void main(String[] args) {
        
        Cliente cliente = new Cliente("João Silva", "joao@example.com", "123456789");
        cliente.adicionarCompra(100.50);
        cliente.adicionarCompra(200.75);
        
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Total de Compras: " + cliente.getValorTotalCompras());
    }
}