package Questao4;
import java.util.Scanner;
import java.text.DecimalFormat;

public class App {
    public App() {
        Pessoa[] pessoas = new Pessoa[3];
        Scanner entrada = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
        Pessoa p = new Pessoa();
        System.out.println("Olá, por favor informar o seu nome, sua altura(em metros) e seu peso(em kg), respectivamente. ");
        p.nome = entrada.next();
        p.altura = entrada.nextDouble();
        p.peso = entrada.nextDouble();
        pessoas[i] = p;
    }
        for(int i = 2; i >= 0; i--) {
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println("Nome: " + pessoas[i].nome);
        System.out.println("Altura: " + pessoas[i].altura);
        System.out.println("Peso: " + pessoas[i].peso);
        System.out.println("IMC: " + df.format(pessoas[i].calcularImc()));
    }
        entrada.close();
    }
    public static void main(String[] args) {
        new App();
    }
}
