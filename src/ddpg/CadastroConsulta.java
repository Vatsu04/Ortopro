/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ddpg;
import javax.swing.JOptionPane;
/**
 *
 * @author tasca
 */
public class CadastroConsulta extends javax.swing.JFrame {

    /**
     * Creates new form CadastroPaciente
     */
    public CadastroConsulta() {
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

        Voltar = new javax.swing.JButton();
        Data = new javax.swing.JTextField();
        Id_Paciente = new javax.swing.JTextField();
        Horario = new javax.swing.JTextField();
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
        getContentPane().add(Data, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 300, -1));
        getContentPane().add(Id_Paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 300, -1));
        getContentPane().add(Horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 300, -1));

        Finalizar.setContentAreaFilled(false);
        Finalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(Finalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 650, 270, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Prototipos/Cadastrar Consulta.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        // TODO add your handling code here:
        new EditarConsultas().setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_VoltarActionPerformed

    private void FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarActionPerformed
        // TODO add your handling code here:
        Consultas consultas = new Consultas();
            consultas.setHorario(Horario.getText());
         
        
            consultas.setData_Consulta(Data.getText());
            
            
            String idPacienteText = Id_Paciente.getText();
          
            if (
                    (Id_Paciente.getText().isEmpty()) ||
                  
                (Data.getText().isEmpty()) ||
              
                    (Horario.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
                
            }
            else{
                 int idPaciente = Integer.parseInt(idPacienteText);
                 
                   ConsultasDAO dao = new ConsultasDAO();
                 
                  boolean clienteExiste = dao.verificarPacienteExistente(idPaciente);
                 
                  
                  if (!clienteExiste ) {
            JOptionPane.showMessageDialog(null, "ID do paciente inválido");
            new CadastroProntuario().setVisible(true);
            this.dispose();
            return;
        }
                  
            consultas.setId_Paciente(idPaciente);
           
            dao.adiciona(consultas);
            JOptionPane.showMessageDialog(null, "Consulta marcada com sucesso! ");
    }
    
    Id_Paciente.setText("");
    
    Horario.setText("");
    
    Data.setText("");
    }//GEN-LAST:event_FinalizarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Data;
    private javax.swing.JButton Finalizar;
    private javax.swing.JTextField Horario;
    private javax.swing.JTextField Id_Paciente;
    private javax.swing.JButton Voltar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    /*
  Paciente consultas = new Paciente();
            consultas.setHorario_Completo(Horario.getText());
            consultas.setCPF(Cpf.getText());
            consultas.setTelefone(Telephone.getText());
            consultas.setCidade(cidade.getText());
            consultas.setData_Nascimento(Data.getText());
            consultas.setHistorico_Medico(Medico.getText());
            consultas.setHistorico_Cirurgico(Cirurgico.getText());
            
            
            consultas.setAlergias(alergias.getText());
            
            
          
            if (
                    (Cpf.getText().isEmpty()) ||
                    (Telephone.getText().isEmpty()) ||
                    (Email.getText().isEmpty()) ||
                      (Cidade.getText().isEmpty()) ||
                 (Medico.getText().isEmpty()) ||
                (Data.getText().isEmpty()) ||
                (Cirurgico.getText().isEmpty()) ||
                (Alergias.getText().isEmpty()) ||
                    (Horario.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
                
            }
            else{
            PacienteDAO dao = new PacienteDAO();
            dao.adiciona(consultas);
            JOptionPane.showMessageDialog(null, " Paciente "+Horario.getText()+" Inserido(a) com sucesso! ");
    }
    
    Cpf.setText("");
    Telephone.setText("");
    Email.setText("");
    Horario.setText("");
    Cidade.setText("");
    Medico.setText("");
    Cirurgico.setText("");
    Alergias.setText("");
    Data.setText("");
    
    
*/
}