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
public class Empresa {

    private String nome;
    private ArrayList<Funcionario> funcionarios;

    public Empresa(String nome) throws IllegalArgumentException {
        setNome(nome);
        funcionarios = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome.isBlank()) {
            throw new IllegalArgumentException("Nome da empresa não pode ser vazio");
        }
        this.nome = nome;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void incluirFuncionario(Funcionario f) throws IllegalArgumentException {
        if (f == null) {
            throw new IllegalArgumentException("Venda inválida");
        }
        if (buscar(f.getNome()) != null) {
            throw new IllegalArgumentException("Funcionário já existe");
        }
        funcionarios.add(f);
    }

    private Funcionario buscar(String nome) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                return f;
            }
        } 
         return null;
    }
    
    public void removerFuncionario(String nome /*Funcionario f*/) {
        /*for (Funcionario funcionario: funcionarios) {
            if(funcionario.getNome().equalsIgnoreCase(f.getNome())) {
                funcionarios.remove(funcionario);
                break;
            }
        }*/
        
        Funcionario removerFuncionario = buscar(nome);
        if (removerFuncionario == null) {
            throw new IllegalArgumentException("Funcionário deve ser informado");
        }
        funcionarios.remove(removerFuncionario);
    }

    public double calcularCustosSalarios() {
        double salarioTotal = 0;
        for (Funcionario f: funcionarios) {
            salarioTotal += f.calcularSalario();
        }
        return salarioTotal;
    }

}
