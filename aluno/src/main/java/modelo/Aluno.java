/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class Aluno {
    
    private String nome;
    private Date dataNascimento;
    private int matricula;

    public Aluno(String nome, Date dataNascimento, int matricula) throws IllegalArgumentException {
        setNome(nome);
        setDataNascimento(dataNascimento);
        setMatricula(matricula);
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public void setDataNascimento(Date dataNascimento) throws IllegalArgumentException {
        Date dataLimite = new Date(); //inicia com a data de hoje
        if (dataNascimento.after(dataLimite) || dataNascimento == null) {
            throw new IllegalArgumentException("Data deve ser menor que a data atual");
        }
        this.dataNascimento = dataNascimento;
    }

    public void setMatricula(int matricula) throws IllegalArgumentException {
        if (matricula >= 0) {
            throw new IllegalArgumentException("Matrícula deve ser maior que zero");
        }
        this.matricula = matricula;
    }
    
    
}
