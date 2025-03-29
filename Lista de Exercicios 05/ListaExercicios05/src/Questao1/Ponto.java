
package Questao1;

/**
 * 
 * @author Gustavo
 */

public class Ponto {
    /**
     * Valor do eixo X
     */
    private int x;
    /**
     * Valor do eixo Y
     */
    private int y;

    /**
     * Construtor da classe Ponto, que deixa pré-definido o ponto x e y como 0
     */

    public Ponto() {
        this.x = 0;
        this.y = 0;
    }
    
    /**
     * Construtor da classe Ponto, que deixa os valores do eixo x e y serem decididos pelo usuário
     */
    public Ponto(int x, int y) {
        setX(x);
        setY(y);
    }
    
    /**
     * 
     * @return o valor atribuido a x
     */
    public int getX() {
        return x;
    }

    /**
     * 
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }   

    /**
     * 
     * @return o valor atribuido a y
     */
    public int getY() {
        return y;
    }

    
    public void setY(int y) {
        this.y = y; 
    }

    public enum Quadrante{ 
        NENHUM, PRIMEIRO, SEGUNDO, TERCEIRO, QUARTO
    }

    public Quadrante identificarQuadrante() {
        if (x > 0 && y > 0) {
            return Quadrante.PRIMEIRO;
        } else if (x < 0 && y > 0) {
            return Quadrante.SEGUNDO;
        } else if (x < 0 && y < 0) {
            return Quadrante.TERCEIRO;
        } else if (x > 0 && y < 0) {
            return Quadrante.QUARTO;
        } else {
            return Quadrante.NENHUM;
        }
    }
    /**
     * 
     * @return true se x for igual a 0, e false se x não for igual a 0;
     */
    public boolean estaIncidindoSobreX() {
     if (this.y == 0) {
     return true;
      }
      return false;
    }
    
    
    public boolean estaIncidindoSobreY() {
        if (this.x == 0) {
        return true;
        }
        return false;
    }

    public double calcularDistancia(Ponto outroPonto) {
        return Math.sqrt(Math.pow(outroPonto.x - this.x, 2) + Math.pow(outroPonto.y - this.y, 2) + 2);
    }

    public double calcularDistancia(Ponto p1, Ponto p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2) + 2);
    }
}
