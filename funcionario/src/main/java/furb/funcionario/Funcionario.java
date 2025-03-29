 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package furb.funcionario;

/**
 *
 * @author Gustavo
*/

public class Funcionario {

    private double salario;
    
    /**
     * Construtor da classe Funcionario
     * @param salario valor a ser atribuido no atributo salario
     */
    public Funcionario(double salario) {
        setSalario(salario);
    }

    /**
     * Método que captura o valor atribuido ao salario
     * @return salario
     */
    public double getSalario() {
        return salario;
    }


    /**
     * Método que atribui um valor ao atributo salario
     * @param salario 
     * @throws IllegalArgumentException se salario for menor que 0
     */
    public void setSalario(double salario) throws IllegalArgumentException {
        if (salario < 0) {
            throw new IllegalArgumentException("Salário deve ser maior que Zero");
        }
        this.salario = salario;
    }

    /**
     * Método responsavel pelo calculo do imposto IRPF
     * @param salario valor atribuido no atributo salario
     * @param imposto valor atribuido no atributo imposto
     * @return valor calculado do imposto 
     */
    public double calcularIrpf(double salario, double imposto) {
        if (salario <= 1903.98) {
            System.out.print("Isento de IRPF");
        }
        if (salario > 1903.98 && salario <= 2826.65) {
            return imposto = (2826.65 - 1903.98) * 0.075;
        }
        if (salario > 2826.65 && salario <= 3751.05) {
            return imposto = ((salario - 2826.65) * 0.15) + (2826.65 - 1903.98) * 0.075;
        }
        if (salario > 3751.05 && salario <= 4664.68) {
            return imposto = (4664.68 - 3751.05) * 0.225 + (((salario - 2826.65) * 0.15) + (2826.65 - 1903.98) * 0.075);
        }
        if (salario > 4664.68) {
            return imposto = (salario - 4664.68) * 0.275 + (4664.68 - 3751.05) * 0.225 + ((salario - 2826.65) * 0.15) + (2826.65 - 1903.98) * 0.075;
        }
        return imposto;
    }

    double calcularIrpf() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Enumera a faixa de Irpf em suas diferentes faixas
     */
    public enum FaixaIrpf{
        PRIMEIRA, SEGUNDA, TERCEIRA, QUARTA, QUINTA
    }
    
    /**
     * Método que verifica em qual faixa se encontra o IRPF
     * @return a enumeração correspondente a faixa
     */
    public FaixaIrpf identificarFaixaIrpf() {
        if (salario <= 1903.98) {
            return FaixaIrpf.PRIMEIRA;
        }
        if (salario >= 1903.98 && salario < 2826.65) {
            return FaixaIrpf.SEGUNDA;
        }
        if (salario >= 2826.65 && salario < 3751.05) {
            return FaixaIrpf.TERCEIRA;
        }
        if (salario >= 3751.05 && salario < 4664.68) {
            return FaixaIrpf.QUARTA;
        }
        return FaixaIrpf.QUINTA;
    }
}
