package Questao3;
import java.util.Scanner;
import java.text.DecimalFormat;

public class App {
    public App() {
        Pessoa p = new Pessoa();
        
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.0");

        for(int i = 0; i < 3; i++) {
            System.out.print("Por favor, informe sua altura(em metros): ");
            p.altura = entrada.nextDouble();
            System.out.print("Por favor, informe o seu peso(em kg): ");
            p.peso = entrada.nextDouble();

            System.out.println("IMC de (pessoa" + i + "): " + df.format(p.calcularImc()));
        }
        entrada.close();
    }
    public static void main(String[] args) {
        new App();
    }
}
