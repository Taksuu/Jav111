import java.util.Scanner;

class Veiculo {
    private String modelo;
    private double valorDiario;

    public Veiculo(String modelo, double valorDiario) {
        this.modelo = modelo;
        this.valorDiario = valorDiario;
    }

    public String getModelo() {
        return modelo;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public double calcularValorTotal(int dias) {
        return valorDiario * dias;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();

        System.out.print("Digite o valor diário de aluguel: ");
        double valorDiario = scanner.nextDouble();

        Veiculo veiculo = new Veiculo(modelo, valorDiario);

        System.out.print("Digite o número de dias que o veículo será alugado: ");
        int dias = scanner.nextInt();

        double valorTotal = veiculo.calcularValorTotal(dias);

        System.out.printf("O valor total do aluguel do veículo %s por %d dias é: R$ %.2f%n", 
                          veiculo.getModelo(), dias, valorTotal);

        scanner.close();
    }
}