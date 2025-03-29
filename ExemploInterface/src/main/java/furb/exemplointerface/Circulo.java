package furb.exemplointerface;

/**
 *
 * @author gusta
 */
public class Circulo implements FormaGeometrica {
    
    private float raio;
    
    public Circulo(float raio) {
        setRaio(raio);
    }    

    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) throws IllegalArgumentException {
        if (raio <= 0) {
            throw new IllegalArgumentException("Raio deve ser maior que 0");
        }
        this.raio = raio;
    }

    @Override
    public float area() {
        return (float) (Math.PI * Math.pow(2, raio));
    }
    
    @Override
    public float perimetro() {
        return (float) (2*Math.PI) * raio;
    }

}
