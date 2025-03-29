package Lista07;

/**
 *
 * @author gusta
 */
public class Imovel {

    private String endereco;
    private int area;
    private Bairro bairro;
    private Finalidade finalidade;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws IllegalArgumentException {
        if (endereco == null) {
            throw new IllegalArgumentException("Endereco deve ser informado");
        }
        this.endereco = endereco;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) throws IllegalArgumentException {
        if (area <= 0) {
            throw new IllegalArgumentException("Area deve ser maior que zero");
        }
        this.area = area;
    }
    
    public Bairro getBairro(Bairro bairro) {
        return bairro;
    }
    
    public void setBairro(Bairro bairro) {
        if (bairro.nome == null || bairro.coeficienteIptu <= 0) {
            throw new IllegalArgumentException("Deve ser informado corretamente o nome e o coeficiente de Iptu corretamente");
        }
        this.bairro = bairro;
    }
    
    public Finalidade getFinalidade(Finalidade finalidade) {
        return finalidade;
    }
    
    public void setFinalidade(Finalidade finalidade) {
        if (finalidade != finalidade.RESIDENCIAL || finalidade != finalidade.COMERCIAL || finalidade != finalidade.INDUSTRIAL) {
            throw new IllegalArgumentException("A finalidade deve ser informada corretamente");
        }
        this.finalidade = finalidade;
    }
    
    public double calcularIptu(Finalidade f, Bairro b) throws IllegalArgumentException {
        if (b.getNome().isBlank()) {
            throw new IllegalArgumentException("Deve ser informado o nome do bairro");
        }
        if (b.getCoeficienteIptu() <= 0) {
            throw new IllegalArgumentException("O coeficiente de Iptu deve ser positivo");
        }
        if (f == null) {
            throw new IllegalArgumentException("Deve ser informado a finalidade do imovel");
        }
        double valorCobrar = 0;
        if (finalidade == f.RESIDENCIAL) {
            valorCobrar = area;
            if (b.coeficienteIptu <= 1) {
                return valorCobrar = area;
            } else {
                return valorCobrar*b.coeficienteIptu;
            }
        }
        if (finalidade == f.COMERCIAL) {
            if (area <= 100) {
                valorCobrar = 500.00;
            } else if (area >= 100 && area <= 400) {
                valorCobrar = 1000.00;
            } else {
                valorCobrar = area*2.55;
            }
            if (b.coeficienteIptu <= 1) {
                return valorCobrar;
            } else {
                return valorCobrar*b.coeficienteIptu;
            }
        }
        if (finalidade == f.INDUSTRIAL) {
            if (area <= 2000.00) {
                valorCobrar = 1000.00;
            } else {
                valorCobrar = area*0.55;
            } 
            if (b.coeficienteIptu <= 1) {
                return valorCobrar;
            } else {
                return valorCobrar*b.coeficienteIptu;
            }
        }
        return valorCobrar;
    }
}
