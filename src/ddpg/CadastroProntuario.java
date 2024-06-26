package ddpg;

import javax.swing.JOptionPane;


public class CadastroProntuario extends javax.swing.JFrame {

    
    public CadastroProntuario() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Voltar = new javax.swing.JButton();
        Id_Consulta = new javax.swing.JTextField();
        Id_Paciente = new javax.swing.JTextField();
        Diagnostico = new javax.swing.JTextField();
        Retorno = new javax.swing.JTextField();
        Remedios = new javax.swing.JTextField();
        Finalizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Voltar.setContentAreaFilled(false);
        Voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });
        getContentPane().add(Voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 120, 40));
        getContentPane().add(Id_Consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 270, -1));
        getContentPane().add(Id_Paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 270, -1));
        getContentPane().add(Diagnostico, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, 270, -1));
        getContentPane().add(Retorno, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 270, -1));
        getContentPane().add(Remedios, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 360, 270, -1));

        Finalizar.setContentAreaFilled(false);
        Finalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(Finalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 630, 280, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Prototipos/2.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 999, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        // TODO add your handling code here:
        new EditarProntuario().setVisible(true);

        this.dispose();
    }//GEN-LAST:event_VoltarActionPerformed

    private void FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarActionPerformed

        // TODO add your handling code here:
        Prontuario prontuarios = new Prontuario();
        String idPacienteText = Id_Paciente.getText();
        prontuarios.setDiagnostico(Diagnostico.getText());
        prontuarios.setRetorno(Retorno.getText());
        prontuarios.setRemedios_Prescritos(Remedios.getText());
        String idConsultaText = Id_Consulta.getText();

        if (Id_Paciente.getText().isEmpty() || Id_Consulta.getText().isEmpty() || Diagnostico.getText().isEmpty()
                || Retorno.getText().isEmpty() || Remedios.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
        } else {

            int idPaciente = Integer.parseInt(idPacienteText);
            int idConsulta = Integer.parseInt(idConsultaText);

            ProntuarioDAO dao = new ProntuarioDAO();

            boolean clienteExiste = dao.verificarPacienteExistente(idPaciente);
            boolean consultaExiste = dao.verificarConsultaExistente(idConsulta);
            boolean clienteConsulta = dao.verificarPacienteConsulta(idConsulta, idPaciente);

            if (!clienteExiste || !consultaExiste || !clienteConsulta) {
                JOptionPane.showMessageDialog(null, "ID do cliente/consulta inválido");
                new CadastroProntuario().setVisible(true);
                this.dispose();
                return;

               
            }

            prontuarios.setId_Paciente(idPaciente);
            prontuarios.setId_Consulta(idConsulta);

            dao.adiciona(prontuarios);

            JOptionPane.showMessageDialog(null, "Prontuario cadastrado com sucesso");
        }
        Id_Paciente.setText("");
        Retorno.setText("");
        Remedios.setText("");
        Diagnostico.setText("");
        Id_Consulta.setText("");


    }//GEN-LAST:event_FinalizarActionPerformed

    private void emptyAll() {

    }

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
            java.util.logging.Logger.getLogger(CadastroProntuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProntuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProntuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProntuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProntuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Diagnostico;
    private javax.swing.JButton Finalizar;
    private javax.swing.JTextField Id_Consulta;
    private javax.swing.JTextField Id_Paciente;
    private javax.swing.JTextField Remedios;
    private javax.swing.JTextField Retorno;
    private javax.swing.JButton Voltar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
 /*
   
     */

}
