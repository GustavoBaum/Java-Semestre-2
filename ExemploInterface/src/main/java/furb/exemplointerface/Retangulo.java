package furb.exemplointerface;

/**
 *
 * @author gusta
 */
public class Retangulo implements FormaGeometrica {
    
    private float altura;
    private float comprimento;
    
    public Retangulo(float altura, float comprimento) {
        setAltura(altura);
        setComprimento(comprimento);
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) throws IllegalArgumentException {
        if (altura <= 0) {
            throw new IllegalArgumentException("Altura deve ser maior que 0");
        }
        this.altura = altura;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) throws IllegalArgumentException {
        if (comprimento <= 0) {
            throw new IllegalArgumentException("Comprimeno deve ser maior que 0");
        }
        this.comprimento = comprimento;
    }
    
    @Override
    public float area() {
        return (float) altura*comprimento;
    }

    @Override
    public float perimetro(){
        return (float) (2*altura) + (2*comprimento);
    }

}
