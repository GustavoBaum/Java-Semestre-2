package Lista14;

/**
 *
 * @author gusta
 */
public class Cidade {
    private int codigoIBGE;
    private String cidade;
    private String estado;
    private int populacao;

    public Cidade(int codigoIBGE, String cidade, String estado, int populacao) {
        setCodigoIBGE(codigoIBGE);
        setCidade(cidade);
        setEstado(estado);
        setPopulacao(populacao);
    }
    
    public int getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(int codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }
}
