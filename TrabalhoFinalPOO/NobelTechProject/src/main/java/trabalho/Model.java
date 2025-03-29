/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho;

import javax.swing.text.AttributeSet;

/**
 *
 * @author adriel, gustavo e guilherme
 */
public class Model {
    private String text;
    private AttributeSet[] atributos;
    private int posicaoText;

    /**
     * Método setter do texto
     * 
     * @param text 
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Método getter do texto
     * 
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Método setter do atributo
     * 
     * @param atributos 
     */
    public void setAtributos(AttributeSet[] atributos) {
        this.atributos = atributos;
    }

    /**
     * Método getter do atributo
     * 
     * @return atributos
     */
    public AttributeSet[] getAtributos() {
        return atributos;
    }

    /**
     * Método setter do posicaoText
     * 
     * @param posicaoText 
     */
    public void setPosicaoText(int posicaoText) {
        this.posicaoText = posicaoText;
    }

    /**
     * Método getter do posiçaoText
     * 
     * @return posicaoText 
     */
    public int getPosicaoText() {
        return posicaoText;
    }
}
