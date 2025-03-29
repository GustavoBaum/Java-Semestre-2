package Lista09A;

/**
 *
 * @author gusta
 */
public class ContaBancaria {
    private String numero;
    private double saldo;
    private Cliente titular;

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

    protected void setSaldo(double saldo) throws IllegalArgumentException {
        if (saldo <= 0) {
            throw new IllegalArgumentException("Saldo deve ser informado");
        }
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) throws IllegalArgumentException {
        if (titular == null) {
            throw new IllegalArgumentException("Cliente deve possuir nome e endereco");
        }
        this.titular = titular;
    }
    
    public void depositar(double valor) throws IllegalArgumentException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior do que zero");
        }
        this.saldo += valor;
    }
    
    public void sacar(double valor) throws IllegalArgumentException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve serf maior do que zero");
        }
        if (valor > this.saldo) {
            throw new IllegalArgumentException("Valor deve ser maior que o valor total do saldo");
        }
        this.saldo -= valor;
    }
    
    public void transferir(ContaBancaria contaDestino, double valor) throws IllegalArgumentException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        if (contaDestino == null) {
            throw new IllegalArgumentException("Conta destino: " + contaDestino + " não existe");
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
}
