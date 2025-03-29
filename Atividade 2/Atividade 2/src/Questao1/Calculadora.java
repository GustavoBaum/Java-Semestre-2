package Questao1;

public class Calculadora {
    
    private int num1;
    private int num2;
    private int resultado;

    public int somar() {
        return num1 + num2;
    }

    public void subtrair(int n1, int n2) {
        resultado = n1 - n2;
    }

    public int dividir() {
        return num1 / num2;
    }

    public void multiplicar(int n1, int n2) {
        resultado = n1 * n2;
    }

    public void setNum1(int num1) {
        int setNum1 = num1;
    }

    public void setNum2(int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Numero2 não pode ser 0");
        }
        int setNum2 = num2;
    }

    public int getSetNum1(int num1) {
         return num1;
    }

    public int getNum2(int num2) {
         return num2;
    }

    public int getResultado(int resultado) { 
        return resultado;
    }
}