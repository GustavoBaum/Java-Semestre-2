/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package furb.estadia;

/**
 *
 * @author Gustavo
 */
public class Estadia {

    private Periodo periodo;
    private int quantidadeDias;
    
    /**
     * Construtor da classe Estadia
     * @param periodo valor atribuido ao atributo periodo  
     * @param quantidadeDias valor atribuido ao atributo quantidadeDias
     */
    public void Estadia(Periodo periodo, int quantidadeDias) {
        setPeriodo(periodo);
        setQuantidadeDias(quantidadeDias);
    }

    /**
     * Método responsável pela atribuição do valor ao período, seguindo as opções do enumerador
     * @param periodo valor a ser atribuido no atributo período
     * @throws IllegalArgumentException 
     */
    public void setPeriodo(Periodo periodo) throws IllegalArgumentException {
        if (periodo != periodo.ALTA_TEMPORADA || periodo != periodo.MEDIA_TEMPORADA || periodo != periodo.BAIXA_TEMPORADA) {
            throw new IllegalArgumentException("Período não pode ser vazio");
        }
        this.periodo = periodo;
    }
    
    /**
     * Método responsável pela atribuição do valor ao atributo quantidadeDias
     * @param quantidadeDias valor a ser atribuidp no atributo quantidadeDias
     * @throws IllegalArgumentException se quantidadeDias for menor que 0 em todos os casos e se quantidadeDias for menor que 5, se periodo for igual a ALTA_TEMPORADA 
     */
    public void setQuantidadeDias(int quantidadeDias) throws IllegalArgumentException {
        if (periodo == periodo.ALTA_TEMPORADA) {
            if (quantidadeDias < 5) {
                throw new IllegalArgumentException("Em períodods de alta temporada, o tempo mínimo de estadia é de 5 dias");
            }
            if (quantidadeDias <= 0) {
                throw new IllegalArgumentException("A quantidade de diarias deve ser maior que 0");
            }
            this.quantidadeDias = quantidadeDias;
        }
        if (quantidadeDias <= 0) {
            throw new IllegalArgumentException("A quantidade de diarias deve ser maior que 0");
        }
        this.quantidadeDias = quantidadeDias;
    }

    /**
     * Método que retorna o valor atribuido ao periodo
     * @return periodo
     */
    public Periodo getPeriodo() {
        return this.periodo;
    }

    /**
     * Método que retorna o valor atribuido a quantidadeDias
     * @return quantidadeDias
     */
    public int getQuantidadeDias() {
        return this.quantidadeDias;
    }

    /**
     * Método responsável pelo cálculo do valor a se pegar tendo em base os valores atribuidos aos atributos: quantidadeDias , periodo
     * @return valorPagar
     */
    public float precoPagar(Periodo periodo, int quantidadeDias) {
        int diaria = 150;
        float valorPagar = 0;
        if (periodo == periodo.ALTA_TEMPORADA) {
            diaria += 30;
            if (quantidadeDias > 7) {
                valorPagar = (diaria * quantidadeDias) - ((diaria * quantidadeDias) * 0.02f);
                return valorPagar;
            }
            if (quantidadeDias == 1) {
                valorPagar = (diaria * quantidadeDias) + ((diaria * quantidadeDias) * 0.05f);
                return valorPagar;
            }
            valorPagar = diaria * quantidadeDias;
            return valorPagar;
        }
        if (periodo == periodo.MEDIA_TEMPORADA) {
            diaria = 150;
            if (quantidadeDias == 1) {
                valorPagar = (diaria * quantidadeDias) + ((diaria * quantidadeDias) * 0.05f);
                return valorPagar;
            }
            valorPagar = diaria * quantidadeDias;
            return valorPagar;
        }
        if (periodo == periodo.BAIXA_TEMPORADA) {
            diaria -= 45;
            if (quantidadeDias == 1) {
                valorPagar = (diaria * quantidadeDias) + ((diaria * quantidadeDias) * 0.05f);
                return valorPagar;
            }
            valorPagar = diaria * quantidadeDias;
            return valorPagar;
        }
        return valorPagar;
    }
}
