package prova2;

/**
 *
 * @author Gustavo
 */
public class Dinheiro extends Pagamento {
    
    private float valorPago;

    public Dinheiro(float valorPago, TipoBuffet tipoBuffet) {
        super(tipoBuffet);
        this.valorPago = valorPago;
    }
    
    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) throws IllegalArgumentException {
        if (valorPago <= 0) {
            throw new IllegalArgumentException("Valor a ser pago deve ser maior que zero");
        }
        this.valorPago = valorPago;
    }
    
    public float calcularTotalComanda(float valorTotalComanda) {
        for (Item f: itens) {
            valorTotalComanda += f.getValor();
        }
        return valorTotalComanda;
    }
    
    public void pagar(float valor, float valorPago) throws IllegalArgumentException {
        boolean compraConcluida = false;
         if (valorPago < valor) {
             throw new IllegalArgumentException("O valor pago não cobriu o valor total");
         }
         compraConcluida = true;
    }   
    
    public float calcularDesconto(float valorTotal, float valorDesconto) {
         return valorDesconto = (valorTotal * 0.10f);
    }
    
    public void calcularTroco(float valor, float valorPago) {
         float troco = 0;
         if (valorPago > valor) {
             troco = valorPago - valor;
         }
    }
}
