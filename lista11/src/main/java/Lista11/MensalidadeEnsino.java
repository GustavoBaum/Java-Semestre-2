package Lista11;

/**
 *
 * @author gusta
 */
public class MensalidadeEnsino {
    
    private int nrCredito;
    private double precoCredito;

    public MensalidadeEnsino(int nrCredito, double precoCredito) {
        setNrCredito(nrCredito);
        setPrecoCredito(precoCredito);
    }

    public int getNrCredito() {
        return nrCredito;
    }

    public void setNrCredito(int nrCredito) throws IllegalArgumentException {
        if (nrCredito <= 0) {
            throw new IllegalArgumentException("Numero de crétido deve ser maior que zero");
        }
        this.nrCredito = nrCredito;
    }

    public double getPrecoCredito() {
        return precoCredito;
    }

    public void setPrecoCredito(double precoCredito) throws IllegalArgumentException {
        if (precoCredito <= 0) {
            throw new IllegalArgumentException("Preco de credito deve ser maior que zero");
        }
        this.precoCredito = precoCredito;
    }
    
    public double calcularValorPagar() {
        return nrCredito*precoCredito;
    }
    
}
