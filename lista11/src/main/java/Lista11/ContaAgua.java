package Lista11;

/**
 *
 * @author gusta
 */
public class ContaAgua {
   
    private int metrosCubicos;
    private double precoMetroCubico;

    public ContaAgua(int metrosCubicos, double precoMetroCubico) {
        setMetrosCubicos(metrosCubicos);
        setPrecoMetroCubico(precoMetroCubico);
    }
    
    public int getMetrosCubicos() {
        return metrosCubicos;
    }

    public void setMetrosCubicos(int metrosCubicos) throws IllegalArgumentException {
        if (metrosCubicos <= 0) {
            throw new IllegalArgumentException("Metros cubicos deve ser maior que zero");
        }
        this.metrosCubicos = metrosCubicos;
    }

    public double getPrecoMetroCubico() {
        return precoMetroCubico;
    }

    public void setPrecoMetroCubico(double precoMetroCubico) throws IllegalArgumentException {
        if (precoMetroCubico <= 0) {
            throw new IllegalArgumentException("O preco do metro cubico deve ser maior que zero");
        }
        this.precoMetroCubico = precoMetroCubico;
    }
    
    public double calcularValorPagar() {
        return metrosCubicos*precoMetroCubico;
    }
    
}
