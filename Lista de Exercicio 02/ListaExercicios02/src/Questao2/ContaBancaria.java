package Questao2;
public class ContaBancaria {
    
    private String numero;
    private String titular;
    private double saldo;
    private ContaBancaria contaDestino;

    /**
     * Permite ler o atributo numero.
     * 
     * @return numero
     */
    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNumero(String numero) {
        if (numero == null || numero.trim().equals("")) {
            throw new IllegalArgumentException("Numero da conta, " + numero + ", não deve ser vazio.");
        }   
        this.numero = numero;
    }

    public void setTitular(String titular) {
        if (titular == null || titular.trim().equals("")) {
            throw new IllegalArgumentException("Titular da conta, " + titular + ", não deve ser vazio;");
        }
        this.titular = titular;
    }

    void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor R$" + valor + ",00 a se depositar deve ser positivo");
        }
        saldo += valor;
    }

    void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor R$" + valor + ",00 a se sacar deve ser positivo");
        }
        if (valor > this.saldo) {
            throw new IllegalArgumentException("O valor R$" + valor + ",00 negativará a sua conta, considere revoga-lá");
        }
        saldo -= valor;
    }

    void transferir(ContaBancaria contaDestinho, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor R$" + valor + ",00 a se transferir deve ser positivo");
        }
        if (contaDestinho == null) {
            throw new IllegalArgumentException("Conta de destino, " + contaDestino + ", é inválida");
        }
            this.sacar(valor);
            contaDestino.depositar(valor);
        } 
    }
