package Lista07;

/**
 *
 * @author gusta
 */
public class Bairro {
    
    protected String nome;
    protected double coeficienteIptu;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null) {
            throw new IllegalArgumentException("Nome deve ser informado");
        }
        this.nome = nome;
    }

    public double getCoeficienteIptu() {
        return coeficienteIptu;
    }

    public void setCoeficienteIptu(double coeficienteIptu) throws IllegalArgumentException {
        if (coeficienteIptu <= 0) {
            throw new IllegalArgumentException("Coeficiente de Iptu deve ser maior que zero ");
        }
        this.coeficienteIptu = coeficienteIptu;
    }
    
    
}
