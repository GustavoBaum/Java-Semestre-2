package Lista10A;

/**
 *
 * @author gusta
 */
public class Circulo extends Figura {
    
    private int raio;
    
    public Circulo(int raio) {
        setRaio(raio);
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) throws IllegalArgumentException {
        if (raio < 0) {
            throw new IllegalArgumentException("Raio deve ser maior que 0");
        }
        this.raio = raio;
    }
    
    @Override
    public double calcularArea() {
        return (double) Math.PI * Math.pow(raio, 2);
    }

}
