public class Circulo {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double calcularArea() {
        return Math.PI * Math.pow(raio, 2);
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public static void main(String[] args) {
  
        Circulo meuCirculo = new Circulo(5.0);

        System.out.println("Raio: " + meuCirculo.getRaio());
        System.out.println("Área: " + meuCirculo.calcularArea());
        System.out.println("Perímetro: " + meuCirculo.calcularPerimetro());
    }
}