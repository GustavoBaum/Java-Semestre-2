/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package furb.retangulo;

/**
 *
 * @author gusta
 */
public class Retangulo {
    
    private int altura;
    private int comprimento;

    public Retangulo() {
        this.altura = 0;
        this.comprimento = 0;
    }

    public Retangulo(int comprimento, int altura) {
        setAltura(altura);
        setComprimento(comprimento);
    }

    public void setAltura(int altura) throws IllegalArgumentException {
        if (altura <= 0) {
            throw new IllegalArgumentException("Valor incorreto para altura: " + altura);
        }
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) throws IllegalArgumentException {
        if (comprimento <= 0) {
            throw new IllegalArgumentException("Valor incorreto para comprimento: " + comprimento);
        }
        this.comprimento = comprimento;
    }

    public int calcularPerimetro(int altura, int comprimento) {
        return (2*comprimento) + (2*altura);
    }   

    public int calcularArea(int altura, int comprimento) {
        return comprimento*altura;
    }
}

