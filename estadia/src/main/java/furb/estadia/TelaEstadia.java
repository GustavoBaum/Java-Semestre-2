/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package furb.estadia;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
/**
 *
 * @author Gustavo
 */
public class TelaEstadia extends javax.swing.JFrame {

    /**
     * Creates new form TelaEstadia
     */
    public TelaEstadia() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtPeriodo = new javax.swing.JTextField();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonCalcularDiaria = new javax.swing.JButton();
        txtQuantidadeDias = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonLimpar = new javax.swing.JButton();
        jrbMEDIA = new javax.swing.JRadioButton();
        jrbBAIXA = new javax.swing.JRadioButton();
        jrbALTA = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        txtPeriodo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeriodoActionPerformed(evt);
            }
        });

        jRadioButton5.setText("jRadioButton3");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        buttonCalcularDiaria.setText("Calcular Diária");
        buttonCalcularDiaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCalcularDiariaActionPerformed(evt);
            }
        });

        txtQuantidadeDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeDiasActionPerformed(evt);
            }
        });

        jLabel1.setText("Quantidade de Dias de Estadia: ");

        jLabel2.setText("Período do ano:");

        buttonLimpar.setText("Limpar");
        buttonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimparActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbMEDIA);
        jrbMEDIA.setText("Media Temporada");

        buttonGroup1.add(jrbBAIXA);
        jrbBAIXA.setText("Baixa Temporada");
        jrbBAIXA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbBAIXAActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbALTA);
        jrbALTA.setText("Alta Temporada");
        jrbALTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbALTAActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 153));
        jLabel3.setText("HOTEL DE CARPAZINHA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantidadeDias, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 27, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonCalcularDiaria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonLimpar))))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbBAIXA)
                            .addComponent(jrbMEDIA)
                            .addComponent(jrbALTA))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbALTA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbMEDIA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbBAIXA)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtQuantidadeDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCalcularDiaria)
                    .addComponent(buttonLimpar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        /**
         * Método do buttonCalcularDiaria que calcula o valor da diária com base nos valores atribuidos ao atributos quantidadeDias e período 
         * @param evt quando buttonCalcularDiaria é pressionado, o valor daS diarias é calculado e retornado ao usuário
         */
    private void buttonCalcularDiariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCalcularDiariaActionPerformed
        int quantidadeDias = Integer.parseInt(txtQuantidadeDias.getText());
        Periodo periodo;
        if (jrbALTA.isSelected()) {
            periodo = Periodo.ALTA_TEMPORADA;
        } else if (jrbMEDIA.isSelected()) {
            periodo = Periodo.MEDIA_TEMPORADA;
        } else {
            periodo = Periodo.BAIXA_TEMPORADA;
        }
        
        Estadia e = new Estadia();
        e.setQuantidadeDias(quantidadeDias);
        
        float valorPagar = e.precoPagar(periodo, quantidadeDias);
        DecimalFormat df = new DecimalFormat("0.00");
        JOptionPane.showMessageDialog(this, "O valor a pagar pelas diárias é R$" + df.format(valorPagar));
    }//GEN-LAST:event_buttonCalcularDiariaActionPerformed

    private void txtQuantidadeDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeDiasActionPerformed
        
    }//GEN-LAST:event_txtQuantidadeDiasActionPerformed

    /**
     * Método que limpa os campos de texto de txtQuantidadeDias e txtPeriodo
     * @param evt quando buttonLimpar é pressionado, este atribuí valores null ao espaços de texto txtQuantidadeDias e txtPeriodo
     */
    private void buttonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimparActionPerformed
        txtQuantidadeDias.setText("");
        jrbALTA.setSelected(false);
        jrbMEDIA.setSelected(false);
        jrbBAIXA.setSelected(false);
    }//GEN-LAST:event_buttonLimparActionPerformed

    private void txtPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeriodoActionPerformed
       
    }//GEN-LAST:event_txtPeriodoActionPerformed

    private void jrbALTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbALTAActionPerformed
        
    }//GEN-LAST:event_jrbALTAActionPerformed

    private void jrbBAIXAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBAIXAActionPerformed
        
    }//GEN-LAST:event_jrbBAIXAActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaEstadia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEstadia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEstadia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEstadia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEstadia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCalcularDiaria;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jrbALTA;
    private javax.swing.JRadioButton jrbBAIXA;
    private javax.swing.JRadioButton jrbMEDIA;
    private javax.swing.JTextField txtPeriodo;
    private javax.swing.JTextField txtQuantidadeDias;
    // End of variables declaration//GEN-END:variables
}
