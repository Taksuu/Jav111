import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Hospede {
    private String nome;
    private LocalDate dataCheckIn;

    public Hospede(String nome, LocalDate dataCheckIn) {
        this.nome = nome;
        this.dataCheckIn = dataCheckIn;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }
}

class Reserva {
    private Hospede hospede;
    private int numeroDiarias;
    private double valorDiaria;

    public Reserva(Hospede hospede, int numeroDiarias, double valorDiaria) {
        this.hospede = hospede;
        this.numeroDiarias = numeroDiarias;
        this.valorDiaria = valorDiaria;
    }

    public double calcularValorTotal() {
        return numeroDiarias * valorDiaria;
    }

    public void exibirDetalhesReserva() {
        System.out.println("Hóspede: " + hospede.getNome());
        System.out.println("Data de Check-in: " + hospede.getDataCheckIn());
        System.out.println("Número de Diárias: " + numeroDiarias);
        System.out.println("Valor da Diária: R$ " + valorDiaria);
        System.out.println("Valor Total da Estadia: R$ " + calcularValorTotal());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do hóspede: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a data de check-in (YYYY-MM-DD): ");
        String dataCheckInStr = scanner.nextLine();
        LocalDate dataCheckIn = LocalDate.parse(dataCheckInStr);

        System.out.print("Digite o número de diárias: ");
        int numeroDiarias = scanner.nextInt();

        System.out.print("Digite o valor da diária: R$ ");
        double valorDiaria = scanner.nextDouble();

        Hospede hospede = new Hospede(nome, dataCheckIn);
        Reserva reserva = new Reserva(hospede, numeroDiarias, valorDiaria);

        reserva.exibirDetalhesReserva();

        scanner.close();
    }
}