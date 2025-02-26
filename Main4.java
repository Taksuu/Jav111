import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Tarefa {
    private String nome;
    private String descricao;
    private Date prazo;
    private boolean concluida;

    public Tarefa(String nome, String descricao, Date prazo) {
        this.nome = nome;
        this.descricao = descricao;
        this.prazo = prazo;
        this.concluida = false; // Inicialmente a tarefa é pendente
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", prazo=" + prazo +
                ", concluida=" + (concluida ? "Sim" : "Não") +
                '}';
    }
}

class GerenciadorDeTarefas {
    private List<Tarefa> tarefas;

    public GerenciadorDeTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }

    public void concluirTarefa(String nome) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getNome().equalsIgnoreCase(nome)) {
                tarefa.concluir();
                System.out.println("Tarefa '" + nome + "' concluída com sucesso!");
                return;
            }
        }
        System.out.println("Tarefa não encontrada.");
    }
}

public class Main {
    public static void main(String[] args) {
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Concluir Tarefa");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome da tarefa: ");
                    String nome = scanner.nextLine();
                    System.out.print("Descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Prazo (formato: yyyy-MM-dd): ");
                    String dataString = scanner.nextLine();
                    Date prazo = java.sql.Date.valueOf(dataString); // Converte a string para Date
                    Tarefa novaTarefa = new Tarefa(nome, descricao, prazo);
                    gerenciador.adicionarTarefa(novaTarefa);
                    break;
                case 2:
                    gerenciador.listarTarefas();
                    break;
                case 3:
                    System.out.print("Nome da tarefa a ser concluída: ");
                    String nomeTarefa = scanner.nextLine();
                    gerenciador.concluirTarefa(nomeTarefa);
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}