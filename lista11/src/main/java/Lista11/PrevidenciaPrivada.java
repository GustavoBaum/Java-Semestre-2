
package Lista11;

/**
 *
 * @author gusta
 */
public class PrevidenciaPrivada extends Investimento {

    private double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) throws IllegalArgumentException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        this.valor = valor;
    }
    
    public double calcularValorPagar() {
        return saldo;
    }
    
    public void investir(double valor, double saldo) {
        this.saldo += valor;
    }
    
}
