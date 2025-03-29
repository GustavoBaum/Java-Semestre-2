package trabalho;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;

/**
 *
 * @author adriel, gustavo e guilherme
 */
public class ArquivoBinario {

    private final Model m;

    /**
     * Inicializa o seguinte parâmetro:
     *
     * @param m
     */
    public ArquivoBinario(Model m) {
        this.m = m;
    }

    /**
     * Salva e serializa o texto e estilo de texto no arquivo desejado
     *
     * @param file
     */
    public void saveFile(File file) {
        try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream o = new ObjectOutputStream(fos)) {
            o.writeObject(m.getText());
            o.writeObject(m.getAtributos());
            o.writeObject(m.getPosicaoText());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lê e desserializa o texto e o estilo de texto para utilizá-los
     *
     * @param documento
     */
    public void openFile(File documento) {
        try (FileInputStream fis = new FileInputStream(documento); ObjectInputStream ois = new ObjectInputStream(fis)) {
            m.setText((String) ois.readObject());
            m.setAtributos((AttributeSet[]) ois.readObject());
            m.setPosicaoText((int) ois.readObject());
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado!", "AVISO!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Arquivo Aberto com Sucesso!");
    }
}
