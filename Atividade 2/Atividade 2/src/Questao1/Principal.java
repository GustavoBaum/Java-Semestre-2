package Questao1;
import java.util.Scanner;

public class Principal {
    public Principal() {
        
        Calculadora c = new Calculadora();
        Scanner entrada = new Scanner(System.in);

        int contador = 0;

        do {
            System.out.print("Digite o comando: ");
            contador = entrada.nextInt();
        switch(contador) {

            //Somar
            case 1: System.out.print("Numero1 = ");
                    c.setNum1(entrada.nextInt());
                    System.out.print("Numero2 = ");
                    c.setNum2(entrada.nextInt());

                    System.out.println("Soma = " + c.somar());
                break;

            //Subtrair
            case 2: System.out.print("Numero1 = ");
                    c.setNum1(entrada.nextInt());
                    System.out.print("Numero2 = ");
                    c.setNum2(entrada.nextInt());

                    System.out.println("Subtração = " + c.getResultado(contador));
                break;

            //Dividir
            case 3: System.out.print("Numero1 = ");
                    c.setNum1(entrada.nextInt());
                    System.out.print("Numero2 = ");
                    c.setNum2(entrada.nextInt());

                    System.out.println("Divisão = " + c.dividir());
                break;
            
            //Multiplicar
            case 4: System.out.print("Numero1 = ");
                    c.setNum1(entrada.nextInt());
                    System.out.print("Numero2 = ");
                    c.setNum2(entrada.nextInt());

                    System.out.println("Multiplicação = " + c.getResultado(contador));
                break;

            //Sair
            case 5: System.out.println("Saindo....");
                break;

            default: System.out.println("Número inválido, por favor tente novamente");
                break;
        }
    } while(contador > 0 && contador < 6);
        entrada.close();
    }
        public static void main(String[] args) {
            new Principal();
    }
}
