import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}

class ContaBancaria {
    private Cliente cliente;
    private double saldo;

    public ContaBancaria(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0.0; // Saldo inicial
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }

    public void transferir(ContaBancaria contaDestino, double valor) {
        if (valor > 0 && valor <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso para " + contaDestino.getCliente().getNome() + "!");
        } else {
            System.out.println("Valor de transferência inválido ou saldo insuficiente.");
        }
    }
}

class Banco {
    private List<Cliente> clientes;
    private Map<String, ContaBancaria> contas;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.contas = new HashMap<>();
    }

    public void cadastrarCliente(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void abrirConta(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                ContaBancaria conta = new ContaBancaria(cliente);
                contas.put(cpf, conta);
                System.out.println("Conta aberta com sucesso para " + cliente.getNome() + "!");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    public ContaBancaria buscarConta(String cpf) {
        return contas.get(cpf);
    }
}

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Abrir Conta");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    banco.cadastrarCliente(nome, cpf);
                    break;
                case 2:
                    System.out.print("CPF do cliente para abrir conta: ");
                    String cpfConta = scanner.nextLine();
                    banco.abrirConta(cpfConta);
                    break;
                case 3:
                    System.out.print("CPF da conta para depósito: ");
                    String cpfDeposito = scanner.nextLine();
                    ContaBancaria contaDeposito = banco.buscarConta(cpfDeposito);
                    if (contaDeposito != null) {
                        System.out.print("Valor a depositar: ");
                        double valorDeposito = scanner.nextDouble();
                        contaDeposito.depositar(valorDeposito);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("CPF da conta para saque: ");
                    String cpfSaque = scanner.nextLine();
                    ContaBancaria contaSaque = banco.buscarConta(cpfSaque);
                    if (contaSaque != null) {
                        System.out.print("Valor a sacar: ");
                        double valorSaque = scanner.nextDouble();
                        contaSaque.sacar(valorSaque);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("CPF da conta de origem: ");
                    String cpfOrigem = scanner.nextLine();
                    ContaBancaria contaOrigem = banco.buscarConta(cpfOrigem);
                    if (contaOrigem != null) {
                        System.out.print("CPF da conta de destino: ");
                        String cpfDestino = scanner.nextLine();
                        ContaBancaria contaDestino = banco.buscarConta(cpfDestino);
                        if (contaDestino != null) {
                            System.out.print("Valor a transferir: ");
                            double valorTransferencia = scanner.nextDouble();
                            contaOrigem.transferir(contaDestino, valorTransferencia);
                        } else {
                            System.out.println("Conta de destino não encontrada.");
                        }
                    } else {
                        System.out.println("Conta de origem não encontrada.");
                    }
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}