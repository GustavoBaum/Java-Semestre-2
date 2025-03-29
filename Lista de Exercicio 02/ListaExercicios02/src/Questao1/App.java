package Questao1;
import java.util.Scanner;
import java.text.DecimalFormat;
public class App {

    public App() {
        Scanner s = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.0");
        
        int n = 10;
        somar(n);
        System.out.println(n);
        
        
        Pessoa[] pessoas = new Pessoa[3];
        populaVetor(s, pessoas);
        
        
        
        for (int i = 2; i >= 0; i-- ) {
            System.out.println("Nome: " + pessoas[i].getNome());
            System.out.println("Peso: " + pessoas[i].getPeso());
            System.out.println("Altura: " + pessoas[i].getAltura());
            System.out.println("IMC = "+ df.format(pessoas[i].calcularImc()));
        }
        s.close();
    }

    public void somar(int n) {
        n += 5;
        System.out.println("Novo n = " + n);
    }
    
    public void populaVetor(Scanner s, Pessoa pessoas[]) {
        for (int i = 0; i < 3; i++) {
            Pessoa p = new Pessoa();
            System.out.print("Digite o nome: ");
            p.setNome(s.next());
            System.out.print("Digite a altura: ");
            p.setAltura(s.nextDouble());
            System.out.print("Digite o peso: ");
            p.setPeso(s.nextDouble());
           
            pessoas[i] = p;
        }
    }
    public static void main(String[] args) {
        new App();
    }
}