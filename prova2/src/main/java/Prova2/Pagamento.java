package prova2;

/**
 *
 * @author Gustavo
 */
public class Pagamento extends Comanda {

    public Pagamento(TipoBuffet tipoBuffet) {
        super(tipoBuffet);
    }
    
    public float calcularTotalComanda(float valorTotalComanda) {
        for (Item item: itens) {
            valorTotalComanda += item.getValor();
        }
        return valorTotalComanda;
    }
     
    public void pagar(float valorPago, float valor) throws IllegalArgumentException {
        boolean compraConcluida = false;
        if (valorPago < valor) {
            throw new IllegalArgumentException("Valor pago não é o suficiente");
        } 
        compraConcluida = true;
    }
    
    public float calcularDesconto(float valor, float valorDesconto) {
        if (valor <= 50) {
            return valorDesconto = (valor * 0.05f);
        }
       return valor;
    }
}
