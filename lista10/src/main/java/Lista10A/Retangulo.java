package Lista10A;

/**
 *
 * @author gusta
 */
public class Retangulo extends Figura {
    protected int largura;
    private int altura;
    
    public Retangulo(int largura, int altura) {
        setLargura(largura);
        setAltura(altura);
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) throws IllegalArgumentException {
        if (largura <= 0) {
            throw new IllegalArgumentException("Largura deve ser maior que 0");
        }
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) throws IllegalArgumentException {
        if (altura <= 0) {
            throw new IllegalArgumentException("Altura deve ser maior que 0");
        }
        this.altura = altura;
    }
    
    @Override
    public double calcularArea() {
        return (double) largura*altura;
    }
}
