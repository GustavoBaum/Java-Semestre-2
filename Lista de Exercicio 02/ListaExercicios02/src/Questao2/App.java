package Questao2;
import java.util.Scanner;
public class App {
    public App() {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Digite o numero da conta: ");
        String numero = entrada.nextLine();
        System.out.print("Digite o titular da conta: ");  
        String titular = entrada.nextLine();

        ContaBancaria c1 = new ContaBancaria();
        c1.setNumero(numero);
        c1.setTitular(titular);

        System.out.print("Digite o numero da conta: ");
        numero = entrada.nextLine();
        System.out.print("Digite o titular da conta: ");
        titular = entrada.nextLine();

        ContaBancaria c2 = new ContaBancaria();
        c2.setNumero(numero);
        c2.setTitular(titular);
        
        //a)
        c1.depositar(1000.000);
        System.out.println("Seu saldo é: R$" + c1.getSaldo() + ",00");
        c1.depositar(700.00);
        System.out.println("Seu saldo é: R$" + c1.getSaldo() + ",00");

        //b)
        c2.depositar(5000.00);
        System.out.println("Seu saldo é: R$" + c2.getSaldo() + ",00");

        //c)
        c2.sacar(3000.00);
        System.out.println("Seu saldo é: R$" + c2.getSaldo() + ",00");

        //d)
        c2.transferir(c1, 1800.00);

        //e)
        System.out.println("Número: " + c1.getNumero() + ", titular: " + c1.getTitular() + ", saldo da conta: R$" + c1.getSaldo() + ",00");
        System.out.println("Número: " + c2.getNumero() + ", titular: " + c2.getTitular() + ", saldo da conta: R$" + c2.getSaldo() + ",00");

        entrada.close();
        }
        public static void main(String[] args) {
            new App();
        }
    }
