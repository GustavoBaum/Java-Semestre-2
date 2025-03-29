package Questao3;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*Com base na lista 2 exercício 2, faça:

Implemente na classe principal um menu com as seguintes opções:

criar conta bancária
sacar
depositar
transferir
sair
A seguir são descritas as opções:

solicitar os dados da conta e adicionar uma nova conta em um vetor
solicitar o numero da conta para sacar e o valor do saque, executar a ação
solicitar o numero da conta para depositar e o valor do depósito, executar a ação
solicitar o numero da conta para transferir, a conta de destino e o valor da transferência, executar a ação */

public class AppExtra {

    private ContaBancaria[] contas;
    private int quantidadeContas;

    public AppExtra() {
        Scanner entrada = new Scanner(System.in);
        contas = new ContaBancaria[10];

        int opcao = 0;
        do {
        String retorno = JOptionPane.showInputDialog("Digite "
        + "uma opção: \n1 - criar conta bancaria\n" + 
        "2 - sacar\n" + 
        "3 - depositar\n" + 
        "4 - transferir\n" + 
        "5 - sair");

        opcao = Integer.parseInt(retorno);

        switch(opcao) { 
            case 1: criarConta();
                break;

            case 2: sacar();
                break;

            case 3: depositar();
                break;

            case 4: transferir();
                break;

            case 5: System.out.println("Encerrando programa....");
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opção inválida");
        }


        entrada.close();
        } while (opcao != 5);
    }
    private void transferir() {
        String numeroContaOrigem = JOptionPane.showInputDialog("Numero da conta: ");
        ContaBancaria contaOrigem = buscar(numeroContaOrigem);
        if (contaOrigem != null) {
            String numeroContaDestino = JOptionPane.showInputDialog("Numero da conta destino: ");
            ContaBancaria contaDestino = buscar(numeroContaDestino);
            if (contaDestino != null) {
            float valor = Float.parseFloat(JOptionPane.showInputDialog("Valor a transferir: "));
            contaOrigem.transferir(contaDestino, valor);
            JOptionPane.showMessageDialog(null, "Saldo da conta origem: R$" + contaOrigem.getSaldo());
            JOptionPane.showMessageDialog(null, "Saldo da conta destino: R$" + contaDestino.getSaldo());
        } else {
            JOptionPane.showMessageDialog(null, "Conta não existe");
        }
    }
        
    }
    private void depositar() {
        String numeroConta = JOptionPane.showInputDialog("Numero da conta: ");
        ContaBancaria conta = buscar(numeroConta);
        if (conta != null) {
            float valor = Float.parseFloat(JOptionPane.showInputDialog("Valor a depositar: "));
            conta.depositar(valor);
            JOptionPane.showMessageDialog(null, "Saldo R$" + conta.getSaldo());
        } else {
            JOptionPane.showMessageDialog(null, "Conta não existe");
        }
        
    }
    private void sacar() {
        String numeroConta = JOptionPane.showInputDialog("Numero da conta: ");
        ContaBancaria conta = buscar(numeroConta);
        if (conta != null) {
            boolean deuErro = true;
            do {
            float valor = Float.parseFloat(JOptionPane.showInputDialog("Valor a sacar: "));
            
            try {
                conta.sacar(valor);
                JOptionPane.showMessageDialog(null, "Saldo R$" + conta.getSaldo());
                deuErro = false;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (deuErro && (conta.getSaldo() > 0));
            
        } else {
            JOptionPane.showMessageDialog(null, "Conta não existe");
        }
        
    }
    private void criarConta() {
        String numeroConta = JOptionPane.showInputDialog("Numero da conta: ");

        if (buscar(numeroConta) == null && quantidadeContas < contas.length) {
            ContaBancaria conta = new ContaBancaria();
            conta.setNumero(numeroConta);
            String titular = JOptionPane.showInputDialog("Titular: ");
            conta.setTitular(titular);
            contas[quantidadeContas] = conta;
            quantidadeContas++;

            JOptionPane.showMessageDialog(null, "Conta criada");
        } else {
            JOptionPane.showMessageDialog(null, "Cona já existe ou já está cheio");
        }
    }
    private ContaBancaria buscar(String numeroConta) {
        /*for (int i =0; i < contas.length; i++) {
         * ContaBancaria c = contas[i];
         *      if (c.getNumero == numeroConta) {
         *      return i;
         *      }
        } */    
        for (ContaBancaria c: contas) {
            if (c != null && c.getNumero().trim().equalsIgnoreCase(numeroConta)) {
                return c;
            } 
        }
        return null;
    }
    public static void main(String[] args) {
        new AppExtra();
    }
}

