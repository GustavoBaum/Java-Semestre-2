package Lista09A;

/**
 *
 * @author gusta
 */
public class ContaEspecial extends ContaBancaria {
    private double limiteCredito;

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) throws IllegalArgumentException {
        if (limiteCredito <= 0) {
            throw new IllegalArgumentException("Limite de crédito deve ser maior ou igual a zero");
        }
        this.limiteCredito = limiteCredito;
    }
    
    public void sacar(double valor) throws IllegalArgumentException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor a sacar deve ser maior que zero");
        }
        if (valor > getSaldo()) {
            throw new IllegalArgumentException("Sem limite para este saque. Saldo: R$" + getSaldo());
        }
        if (valor > limiteCredito) {
            throw new IllegalArgumentException("Valor de crédito a sacar deve ser menor ou igual ao limite");
        }
        setSaldo(getSaldo() - valor);
    }
}
