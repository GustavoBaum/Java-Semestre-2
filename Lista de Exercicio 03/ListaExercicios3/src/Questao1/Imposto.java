package Questao1;
import java.util.Scanner;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Imposto {

    private Funcionario[] funcionarios;
    private int quantidadeFuncionarios;

    public Imposto() {
        Scanner entrada = new Scanner(System.in);
        funcionarios = new Funcionario[5];

        int comando = 0;
        do {
            String retorno = JOptionPane.showInputDialog("Digite o comando para calcular o seu IRPF(imposto de renda): " + 
            " \n1 - Nome\n" + 
            "2 - Salario\n" + 
            "3 - Encerrar programa");

            comando = Integer.parseInt(retorno);

            switch(comando) {
                case 1: criarNome();
                    break;

                case 2: calcularImposto();
                    break;

                case 3: System.out.println("Encerrando programa.....");
                    break;

                default: JOptionPane.showMessageDialog(null, "Opção de ação inválida");
                    break;
            }

            entrada.close(); 

        } while (comando != 3);  
    }
    private void calcularImposto() {
        String nomeFuncionario = JOptionPane.showInputDialog("Informe o seu nome: ");
        Funcionario funcionario = buscar(nomeFuncionario);

        DecimalFormat df = new DecimalFormat("0.00");

        if (funcionario != null) {
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do seu salario: "));
        funcionario.setSalario(salario);
        JOptionPane.showMessageDialog(null, "Imposto: " + df.format(funcionario.calcularIrpf(salario)));
        } else {
            JOptionPane.showMessageDialog(null, "Nome de funcionario não existe");
        }
    }

    private void criarNome() {
        String nomeFuncionario = JOptionPane.showInputDialog("Insira o seu nome: ");

        if (buscar(nomeFuncionario) == null && quantidadeFuncionarios < funcionarios.length) {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(nomeFuncionario);
            funcionarios[quantidadeFuncionarios] = funcionario;
            quantidadeFuncionarios++; 
        }
    }

    private Funcionario buscar(String nomeFuncionario) {
        for (Funcionario c: funcionarios) {
            if (c != null && c.getNome().trim().equalsIgnoreCase(nomeFuncionario)) {
                return c;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        new Imposto();
    }
}
