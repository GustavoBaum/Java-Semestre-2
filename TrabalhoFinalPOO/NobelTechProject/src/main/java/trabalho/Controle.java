/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho;

import java.awt.Color;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author adriel, gustavo e guilherme
 */
public class Controle {

    private final JTextPane tpEscrita;
    private final SimpleAttributeSet letrasGeral;
    private final TelaPrincipal t;
    private final ArquivoBinario ab;
    private final Model m;

    JFileChooser fcAbrirArquivo;
    JFileChooser fcSalvarComo;

    StyledDocument doc;

    AttributeSet[] atributos;

    private File documento;

    int posicaoCursor;
    int auxPosicaoCursor;
    int inicioSelecao;
    int fimSelecao;

    Color corTexto;
    Color corMarcador;

    boolean checkN;
    boolean checkI;
    boolean checkU;

    /**
     * Inicializa os seguintes parâmetros:
     *
     * @param t
     * @param letrasGeral
     * @param tpEscrita
     * @param fcAbrirArquivo
     * @param fcSalvarComo
     */
    public Controle(TelaPrincipal t, SimpleAttributeSet letrasGeral, JTextPane tpEscrita, JFileChooser fcAbrirArquivo, JFileChooser fcSalvarComo) {
        this.tpEscrita = tpEscrita;
        this.letrasGeral = letrasGeral;
        this.t = t;
        this.fcAbrirArquivo = fcAbrirArquivo;
        this.fcSalvarComo = fcSalvarComo;

        m = new Model();
        ab = new ArquivoBinario(m);

        corTexto = Color.black;
        corMarcador = Color.white;

        checkN = true;
        checkI = true;
        checkU = true;
    }

    /**
     * A cada tecla pressionada, o texto é atualizado com o estilo selecionado
     */
    public void textKeyUpdate() {
        posicaoCursor = tpEscrita.getCaretPosition();

        doc = tpEscrita.getStyledDocument();

        if (auxPosicaoCursor < posicaoCursor - 1) {
            int distancia = posicaoCursor - auxPosicaoCursor;

            if (distancia > 0) {
                doc.setCharacterAttributes(auxPosicaoCursor, distancia, letrasGeral, false);
            }
        }

        if (posicaoCursor >= auxPosicaoCursor) {
            doc.setCharacterAttributes(posicaoCursor - 1, 1, letrasGeral, false);
        }
        auxPosicaoCursor = posicaoCursor;
    }

    /**
     * Abre um arquivo através do FileChooser
     *
     * @param fileX
     *
     * Pode lançar as seguintes exceções:
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void abrirArquivo(int fileX) throws IOException, ClassNotFoundException {
        File arquivo = null;

        int erro = 0;

        do {
            erro = 0;
            arquivo = null;

            if (fileX != 2) {
                int retorno = fcAbrirArquivo.showOpenDialog(t);
                if (retorno == JFileChooser.APPROVE_OPTION) {
                    arquivo = fcAbrirArquivo.getSelectedFile();
                }
            }

            if (arquivo.getName().toLowerCase().endsWith(".poo")) {
                ab.openFile(arquivo);
                
                switch (m.getPosicaoText()) {
                    case 3 -> alinharDireita();
                    case 2 -> centralizar();
                    default -> alinharEsquerda();
                }

                tpEscrita.setText(m.getText());

                atributos = m.getAtributos();

                for (int i = 0; i < atributos.length; i++) {
                    doc.setCharacterAttributes(i, 1, atributos[i], false);
                }

                documento = arquivo;

                t.mudaNomeDoc();
            } else {
                JOptionPane.showMessageDialog(null, "Arquivo Inválido");
                erro = 1;
            }
        } while (erro != 0);

    }

    /**
     * Cria um arquivo utilizando o FileChooser
     *
     * Pode lançar as seguintes exceções:
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void novoArquivo() throws IOException, ClassNotFoundException {
        int retorno = fcSalvarComo.showSaveDialog(t);

        if (retorno == JFileChooser.APPROVE_OPTION) {
            File file = fcSalvarComo.getSelectedFile();

            if (!file.getName().toLowerCase().endsWith(".poo")) {
                file = new File(file.getAbsolutePath() + ".poo");
            }

            if (file.exists()) {
                int resposta = JOptionPane.showConfirmDialog(t,
                        "O arquivo já existe. Deseja abri-lo?",
                        "Abrir arquivo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if (resposta == JOptionPane.NO_OPTION) {
                    novoArquivo();
                    return;
                } else {
                    documento = file;
                    abrirArquivo(2);
                    return;
                }
            }

            JOptionPane.showMessageDialog(t, "Arquivo criado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
            tpEscrita.setText("");
            alinharEsquerda();

            documento = file;

            t.mudaNomeDoc();
        }
    }

    /**
     * Pega o último documento utilizado e o salva
     *
     * Pode lançar as seguintes exceções:
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void salvarArquivo() throws FileNotFoundException, IOException {
        m.setText(tpEscrita.getText());

        atributos = new AttributeSet[tpEscrita.getText().length()];

        for (int i = 0; i < atributos.length; i++) {
            Element elemento = doc.getCharacterElement(i);
            atributos[i] = elemento.getAttributes();
        }

        m.setAtributos(atributos);

        try (FileOutputStream fos = new FileOutputStream(documento); ObjectOutputStream o = new ObjectOutputStream(fos)) {
            o.writeObject(m.getText());
            o.writeObject(m.getAtributos());
            o.writeObject(m.getPosicaoText());
        }

        JOptionPane.showMessageDialog(null, "Arquivo Salvo com Sucesso!");
    }

    /**
     * Salva o arquivo com o nome desejado, utilizando o FileChooser
     *
     * Pode lançar as seguintes exceções:
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public void salvarArquivoComo() throws IOException, FileNotFoundException, ClassNotFoundException {
        int retorno = fcSalvarComo.showSaveDialog(t);

        if (retorno == JFileChooser.APPROVE_OPTION) {
            File file = fcSalvarComo.getSelectedFile();

            if (!file.getName().toLowerCase().endsWith(".poo")) {
                file = new File(file.getAbsolutePath() + ".poo");
            }

            if (file.exists()) {
                int resposta = JOptionPane.showConfirmDialog(t,
                        "O arquivo já existe. Deseja substituir?",
                        "Substituir arquivo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if (resposta == JOptionPane.NO_OPTION) {
                    return;
                }
            }

            m.setText(tpEscrita.getText());

            atributos = new AttributeSet[tpEscrita.getText().length()];

            for (int i = 0; i < atributos.length; i++) {
                Element elemento = doc.getCharacterElement(i);
                atributos[i] = elemento.getAttributes();
            }

            m.setAtributos(atributos);

            ab.saveFile(file);

            JOptionPane.showMessageDialog(null, "Arquivo Salvo com Sucesso!");

            documento = file;

            t.mudaNomeDoc();
        }
    }

    /**
     * Com base na escolha(choice), o método verifica e atualiza os estilos de
     * texto
     *
     * @param choice
     */
    public void trataTipoTexto(String choice) {
        switch (choice) {
            case "Italico" -> {
                StyleConstants.setItalic(letrasGeral, checkI);
                checkI = !checkI;
            }
            case "Negrito" -> {
                StyleConstants.setBold(letrasGeral, checkN);
                checkN = !checkN;
            }
            case "UnderLine" -> {
                StyleConstants.setUnderline(letrasGeral, checkU);
                checkU = !checkU;
            }
            case "Fonte" -> {
                int error = 0;
                int tamanhoFonte = 15;

                do {
                    error = 0;
                    try {
                        tamanhoFonte = Integer.parseInt(JOptionPane.showInputDialog("Tamanho da fonte"));
                    } catch (HeadlessException | NumberFormatException e) {
                        JOptionPane.showMessageDialog(t, "Valor informado deve ser um NÚMERO INTEIRO", "CUIDADO!", JOptionPane.INFORMATION_MESSAGE);
                    }

                    if (tamanhoFonte < 10) {
                        JOptionPane.showMessageDialog(t, "Tamanho muito pequeno", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                        error = 1;
                    } else if (tamanhoFonte > 70) {
                        JOptionPane.showMessageDialog(t, "Tamanho muito grande", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                        error = 1;
                    }

                } while (error != 0);

                StyleConstants.setFontSize(letrasGeral, tamanhoFonte);
            }
            case "Normal" -> {
                checkI = false;
                checkN = false;
                checkU = false;
                StyleConstants.setItalic(letrasGeral, checkI);
                StyleConstants.setBold(letrasGeral, checkN);
                StyleConstants.setUnderline(letrasGeral, checkU);
                StyleConstants.setFontSize(letrasGeral, 15);
                checkI = !checkI;
                checkN = !checkN;
                checkU = !checkU;
            }
        }
    }

    /**
     * Com base na escolha(choice), o método verifica e atualiza os estilos de
     * texto no local escolhido com a utilização de um Popup
     *
     * @param choice
     */
    public void trataTipoTextoPopup(String choice) {
        inicioSelecao = tpEscrita.getSelectionStart();
        fimSelecao = tpEscrita.getSelectionEnd();

        if (inicioSelecao != fimSelecao) {
            AttributeSet aux = doc.getCharacterElement(inicioSelecao).getAttributes();

            switch (choice) {
                case "Italico" -> {
                    checkI = !StyleConstants.isItalic(aux);
                    StyleConstants.setItalic(letrasGeral, checkI);
                }
                case "Negrito" -> {
                    checkN = !StyleConstants.isBold(aux);
                    StyleConstants.setBold(letrasGeral, checkN);
                }
                case "UnderLine" -> {
                    checkU = !StyleConstants.isUnderline(aux);
                    StyleConstants.setUnderline(letrasGeral, checkU);
                }
                case "Fonte" -> {
                    int error = 0;
                    int tamanhoFonte = 15;

                    do {
                        error = 0;
                        try {
                            tamanhoFonte = Integer.parseInt(JOptionPane.showInputDialog("Tamanho da fonte"));
                        } catch (HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog(t, "Valor informado deve ser um NÚMERO INTEIRO", "CUIDADO!", JOptionPane.INFORMATION_MESSAGE);
                        }

                        if (tamanhoFonte < 10) {
                            JOptionPane.showMessageDialog(t, "Tamanho muito pequeno", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                            error = 1;
                        } else if (tamanhoFonte > 70) {
                            JOptionPane.showMessageDialog(t, "Tamanho muito grande", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                            error = 1;
                        }

                    } while (error != 0);

                    StyleConstants.setFontSize(letrasGeral, tamanhoFonte);
                }
                case "Normal" -> {
                    checkI = false;
                    checkN = false;
                    checkU = false;
                    StyleConstants.setItalic(letrasGeral, checkI);
                    StyleConstants.setBold(letrasGeral, checkN);
                    StyleConstants.setUnderline(letrasGeral, checkU);
                    StyleConstants.setFontSize(letrasGeral, 15);
                    checkI = !checkI;
                    checkN = !checkN;
                    checkU = !checkU;
                }
            }

            doc.setCharacterAttributes(inicioSelecao, (fimSelecao - inicioSelecao), letrasGeral, false);
        } else {
            trataTipoTexto(choice);
        }
    }

    /**
     * De acordo com a cor desejada, o método faz verificações das cores e
     * atualiza a cor do texto
     *
     * @param cor
     */
    public void trataCorTexto(Color cor) {
        StyleConstants.setBackground(letrasGeral, corMarcador);
        StyleConstants.setForeground(letrasGeral, corTexto);

        if (corTexto != cor) {
            StyleConstants.setForeground(letrasGeral, cor);
            corTexto = cor;

            if (corMarcador == corTexto) {
                if (cor == Color.white) {
                    StyleConstants.setBackground(letrasGeral, Color.black);
                    corMarcador = Color.black;
                    StyleConstants.setForeground(letrasGeral, Color.white);
                    corTexto = Color.white;
                } else {
                    StyleConstants.setBackground(letrasGeral, Color.white);
                    corMarcador = Color.white;
                }
            }
        } else {
            if (corMarcador == Color.black) {
                StyleConstants.setBackground(letrasGeral, Color.white);
                corMarcador = Color.white;
            }
            StyleConstants.setForeground(letrasGeral, Color.black);
            corTexto = Color.black;
        }
        t.atualizaCor();
    }

    /**
     * De acordo com a cor desejada, o método faz verificações das cores e
     * atualiza a cor do fundo do texto como uma forma de destaque
     *
     * @param cor
     */
    public void trataCorMarcador(Color cor) {
        StyleConstants.setBackground(letrasGeral, corMarcador);
        StyleConstants.setForeground(letrasGeral, corTexto);

        if (corMarcador != cor) {
            StyleConstants.setBackground(letrasGeral, cor);
            corMarcador = cor;

            if (corTexto == corMarcador) {
                if (cor == Color.black) {
                    StyleConstants.setBackground(letrasGeral, Color.black);
                    corMarcador = Color.black;
                    StyleConstants.setForeground(letrasGeral, Color.white);
                    corTexto = Color.white;
                } else {
                    StyleConstants.setForeground(letrasGeral, Color.white);
                    corTexto = Color.white;
                }
            }
        } else {
            if (corTexto == Color.white) {
                StyleConstants.setForeground(letrasGeral, Color.black);
                corTexto = Color.black;
            }
            StyleConstants.setBackground(letrasGeral, Color.white);
            corMarcador = Color.white;

        }
        t.atualizaCor();
    }

    /**
     * De acordo com a cor desejada, o método faz verificações das cores e
     * atualiza a cor do texto no local selecionado com a utilização de um Popup
     *
     * @param cor
     */
    public void trataCorTextoPopup(Color cor) {
        inicioSelecao = tpEscrita.getSelectionStart();
        fimSelecao = tpEscrita.getSelectionEnd();

        if (inicioSelecao != fimSelecao) {
            AttributeSet aux = doc.getCharacterElement(inicioSelecao + 1).getAttributes();
            Color xcorTexto = StyleConstants.getForeground(aux);
            Color xcorMarcador = StyleConstants.getBackground(aux);
            corMarcador = xcorMarcador;
            corTexto = xcorTexto;
            trataCorTexto(cor);
            doc.setCharacterAttributes(inicioSelecao, (fimSelecao - inicioSelecao), letrasGeral, false);
        } else {
            trataCorTexto(cor);
        }
    }

    /**
     * De acordo com a cor desejada, o método faz verificações das cores e
     * atualiza a cor do fundo no local selecionado com a utilização de um Popup
     *
     * @param cor
     */
    public void trataCorMarcadorPopup(Color cor) {
        inicioSelecao = tpEscrita.getSelectionStart();
        fimSelecao = tpEscrita.getSelectionEnd();

        if (inicioSelecao != fimSelecao) {
            AttributeSet aux = doc.getCharacterElement(inicioSelecao).getAttributes();
            Color xcorTexto = StyleConstants.getForeground(aux);
            Color xcorMarcador = StyleConstants.getBackground(aux);
            corTexto = xcorTexto;
            corMarcador = xcorMarcador;
            trataCorMarcador(cor);
            doc.setCharacterAttributes(inicioSelecao, (fimSelecao - inicioSelecao), letrasGeral, false);
        } else {
            trataCorMarcador(cor);
        }
    }

    /**
     * O método gera uma pequena atualização do texto para o inicializar
     *
     * Pode lançar a seguinte exceção:
     *
     * @throws BadLocationException
     */
    public void inicializacaoTexto() throws BadLocationException {
        tpEscrita.setText("aa");
        textKeyUpdate();
        doc.remove(posicaoCursor - 1, 1);
        textKeyUpdate();
        doc.remove(posicaoCursor - 1, 1);
        textKeyUpdate();
    }

    /**
     * Método getter do documento
     *
     * @return documento
     */
    public String getDocumento() {
        return documento.getName();
    }
    
    /**
     * Método que alinha o texto à direita
     */
    public void alinharDireita(){
        StyleConstants.setAlignment(letrasGeral, StyleConstants.ALIGN_RIGHT);
        doc.setParagraphAttributes(0, doc.getLength(), letrasGeral, false);
        m.setPosicaoText(3);
    }
    /**
     * Método que centraliza o texto
     */
    public void centralizar(){
        StyleConstants.setAlignment(letrasGeral, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), letrasGeral, false);
        m.setPosicaoText(2);
    }
    /**
     * Método que alinha o texto à esquerda
     */
    public void alinharEsquerda(){
        StyleConstants.setAlignment(letrasGeral, StyleConstants.ALIGN_LEFT);
        doc.setParagraphAttributes(0, doc.getLength(), letrasGeral, false);
        m.setPosicaoText(1);
    }
}
