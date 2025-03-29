package Questao2;
import java.util.Scanner;
import java.text.DecimalFormat;

public class App {
    public App() {
        Pessoa p2 = new Pessoa();
        
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.0");

        System.out.print("Por favor, informe sua altura(em metros): ");
        p2.altura = entrada.nextDouble();
        System.out.print("Por favor, informe o seu peso(em kg): ");
        p2.peso = entrada.nextDouble();

        entrada.close();

        System.out.println("IMC p2: " + df.format(p2.calcularImc()));
    }
    public static void main(String[] args) {
        new App();
    }
}
