/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista10B;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Programador extends Funcionario {

    private ArrayList<String> linguagens;

    public Programador(String nome, double salarioBase) {
        super(nome, salarioBase); //super é sempre a primeira linha do construtor
        linguagens = new ArrayList();   
    }

    public ArrayList<String> getLinguagens() {
        return linguagens;
    }

    public void inserirLinguagem(String linguagem) throws IllegalArgumentException {
        if (linguagem.isBlank()) {
            throw new IllegalArgumentException("Deve ser informada uma linguagem de programação");
        }
        if (buscar(linguagem) != null) {
            throw new IllegalArgumentException("Linguagem já informada");
        }
        linguagens.add(linguagem);
    }

    private String buscar(String linguagem) {
        for (String linguagemProgramacao : linguagens) {
            if (linguagemProgramacao.equalsIgnoreCase(linguagem)) {
                return linguagemProgramacao;
            }
        }
        return null;
    }

    public void removerLinguagem(String linguagem) throws IllegalArgumentException {
        String removerLinguagem = buscar(linguagem);
        if (removerLinguagem == null) {
            throw new IllegalArgumentException("Linguagem deve ser informada");
        }
        linguagens.remove(removerLinguagem);
    }

    @Override
    public double calcularSalario() {
        if (buscar("Java") != null) {
            return super.getSalarioBase() + (super.getSalarioBase() * 0.2);
        }
        return super.getSalarioBase();
    }
}
