package Lista11;

/**
 *
 * @author gusta
 */
public abstract class Investimento {
    
    double saldo;

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) throws IllegalArgumentException {
        if (saldo <= 0) {
            throw new IllegalArgumentException("Saldo deve ser maior que zero");
        }
        this.saldo = saldo;
    }
    
}
