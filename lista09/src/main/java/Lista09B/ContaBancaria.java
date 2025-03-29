package Lista09B;

import java.util.ArrayList;

/**
 *
 * @author gusta
 */
public class ContaBancaria {
    private String numero;
    private double saldo;
    private Cliente titular;
    private ArrayList<Movimento> listaMovimento;

    public ContaBancaria(String numero, double saldo, Cliente titular, ArrayList<Movimento> tipoMovimento) {
        listaMovimento = new ArrayList<Movimento>();
        setNumero(numero);
        setSaldo(saldo);
        setTitular(titular);
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws IllegalArgumentException {
        if (numero == null) {
            throw new IllegalArgumentException("Numero deve ser informado");
        }
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) throws IllegalArgumentException {
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo deve ser maior ou igual a zero");
        }
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) throws IllegalArgumentException {
        if (titular == null) {
            throw new IllegalArgumentException("Titular deve possuir nome e endereco válidos");
        }
        this.titular = titular;
    }
    
    public void depositar(double valor) throws IllegalArgumentException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor a depositar deve ser maior que zero");
        }
        this.saldo += valor;
    }
    
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor a sacar deve ser maior que zero");
        }
        if (valor > this.saldo) {
            throw new IllegalArgumentException("Valor a sacar deve ser menor que o valor total do saldo");
        }
        this.saldo -= valor;
    }
    
    public void transferir(ContaBancaria contaDestino, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor a transferir deve ser maior que zero");
        }
        if (contaDestino == null) {
            throw new IllegalArgumentException("Conta destino deve ser válida");
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
    
    public ArrayList<Movimento> getListaMovimento() {
        return listaMovimento;
    }
    
    public void incluirMovimento(Movimento x) throws IllegalArgumentException {
        if (x == null) {
            throw new IllegalArgumentException("Movimento deve ser informado");
        } 
        listaMovimento.add(x);
        
    }
}
