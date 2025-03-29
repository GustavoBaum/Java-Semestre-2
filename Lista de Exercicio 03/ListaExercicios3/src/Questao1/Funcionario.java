package Questao1;

public class Funcionario {

    private String nome;
    private double salario;

    public void setNome(String nome)  {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public double calcularIrpf(double salario) {
        if (salario <= 1903.98) {
            System.out.print("Isento de IRPF");
        }
        if (salario > 1903.98 && salario <= 2826.65) {
            return salario = (2826.65 - 1903.98) * 0.075;
        }
        if (salario > 2826.65 && salario <= 3751.05) {
            return salario = ((salario - 2826.65) * 0.15) + (2826.65 - 1903.98) * 0.075;
        }
        if (salario > 3751.05 && salario <= 4664.68) {
            return salario = (4664.68 - 3751.05) * 0.225 + (((salario - 2826.65) * 0.15) + (2826.65 - 1903.98) * 0.075);
        }
        if (salario > 4664.68) {
            return salario = (salario - 4664.68) * 0.275 + (4664.68 - 3751.05) * 0.225 + ((salario - 2826.65) * 0.15) + (2826.65 - 1903.98) * 0.075;
        }
        return this.salario;
    }
}