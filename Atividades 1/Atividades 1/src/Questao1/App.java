package Questao1;
import java.text.DecimalFormat;

public class App {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        
        DecimalFormat df = new DecimalFormat("0.0");

        p1.altura = 1.75;
        p1.peso = 78;

        System.out.println("IMC p1: " + df.format(p1.calcularImc()));
    }
}
