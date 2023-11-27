
package ddpg;

import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tasca
 */
public class CadastroPaciente extends javax.swing.JFrame {

    /**
     * Creates new form CadastroConsulta
     */
    public CadastroPaciente() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        Alergias = new javax.swing.JTextField();
        Nome = new javax.swing.JTextField();
        CPF = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Telefone = new javax.swing.JTextField();
        Cidade = new javax.swing.JTextField();
        DDN = new javax.swing.JTextField();
        Voltar = new javax.swing.JButton();
        Fînalizar = new javax.swing.JButton();
        HM = new javax.swing.JTextField();
        HC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Alergias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(Alergias, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 560, 280, 30));

        Nome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 112, 280, 30));

        CPF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(CPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 280, 30));

        Email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 280, 30));

        Telefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(Telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 280, 30));

        Cidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(Cidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, 280, 30));

        DDN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(DDN, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 280, 30));

        Voltar.setContentAreaFilled(false);
        Voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });
        getContentPane().add(Voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 120, 40));

        Fînalizar.setContentAreaFilled(false);
        Fînalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Fînalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FînalizarActionPerformed(evt);
            }
        });
        getContentPane().add(Fînalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 650, 280, 50));

        HM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(HM, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, 280, 30));

        HC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(HC, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, 280, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Prototipos/3.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private String formatCPF(String cpf) {
    // Remove non-numeric characters from the input
    String numericCPF = cpf.replaceAll("[^0-9]", "");

    
    if (numericCPF.length() == 11) {
        // Format CPF with a mask
        return String.format("%s.%s.%s-%s",
                numericCPF.substring(0, 3),
                numericCPF.substring(3, 6),
                numericCPF.substring(6, 9),
                numericCPF.substring(9));
    } else {
        // If the CPF is not valid, return the original input
        return cpf;
    }
}

private String formatDataNascimento(String dataNascimento) {
    // Remove non-numeric characters from the input
    String numericDataNascimento = dataNascimento.replaceAll("[^0-9]", "");

    // Check if the dataNascimento is already formatted
    if (numericDataNascimento.length() == 8) {
        // Format dataNascimento with a mask
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = inputFormat.parse(numericDataNascimento);
            return outputFormat.format(date);
        } catch (ParseException e) {
            // If there is an error parsing the date, return the original input
            return dataNascimento;
        }
    } else {
        // If the dataNascimento is not valid, return the original input
        return dataNascimento;
    }
}


// Format telefone with a mask (e.g., "(##) #####-####")
private String formatTelefone(String telefone) {
    // Remove non-numeric characters from the input
    String numericTelefone = telefone.replaceAll("[^0-9]", "");

    // Check if the telefone is already formatted
    if (numericTelefone.length() == 11 || numericTelefone.length() == 10) {
        // Format telefone with a mask
        if (numericTelefone.length() == 11) {
            return String.format("(%s) %s-%s",
                    numericTelefone.substring(0, 2),
                    numericTelefone.substring(2, 7),
                    numericTelefone.substring(7));
        } else {
            return String.format("(%s) %s-%s",
                    numericTelefone.substring(0, 2),
                    numericTelefone.substring(2, 6),
                    numericTelefone.substring(6));
        }
    } else {
        // If the telefone is not valid, return the original input
        return telefone;
    }
}


    private void FînalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FînalizarActionPerformed
        // TODO add your handling code here:
          Paciente pacientes = new Paciente();
            
           pacientes.setNome_Completo(Nome.getText());
           pacientes.setData_Nascimento(formatDataNascimento(DDN.getText()));
           pacientes.setEmail(Email.getText());
           pacientes.setTelefone(formatTelefone(Telefone.getText()));
           pacientes.setAlergias(Alergias.getText());
           pacientes.setCPF(formatCPF(CPF.getText()));
           pacientes.setCidade(Cidade.getText());
           pacientes.setHistorico_Cirurgico(HC.getText());
           pacientes.setHistorico_Medico(HM.getText());
           
           
            
          
            
             if (
                    (CPF.getText().isEmpty()) ||
                    (Telefone.getText().isEmpty()) ||
                    (Email.getText().isEmpty()) ||
                    (DDN.getText().isEmpty()) ||
                    (Alergias.getText().isEmpty()) ||
                     (Cidade.getText().isEmpty()) ||
                     (HM.getText().isEmpty()) ||
                     (HC.getText().isEmpty()) ||
                     
                    (Nome.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
                
            }  else if (CPF.getText().length() > 15){
        JOptionPane.showMessageDialog(null, "CPF inválido");
    } else if(Telefone.getText().length() >14){
        JOptionPane.showMessageDialog(null, "Telefone inválido");
    }
            
            else {
           
            
            
            PacienteDAO dao = new PacienteDAO();
             dao.adiciona(pacientes);
            JOptionPane.showMessageDialog(null, " Paciente "+Nome.getText()+" Inserido(a) com sucesso! ");
            
         
            
          

           
                   }
    
             
             /*
             pacientes.setNome_Completo(Nome.getText());
           pacientes.setData_Nascimento(DDN.getText());
           pacientes.setEmail(Email.getText());
           pacientes.setTelefone(Telefone.getText());
           pacientes.setAlergias(Alergias.getText());
           pacientes.setCPF(CPF.getText());
           pacientes.setCidade(Cidade.getText());
           pacientes.setHistorico_Cirurgico(HC.getText());
           pacientes.setHistorico_Medico(HM.getText());
             */
    Nome.setText("");
    DDN.setText("");
    Email.setText("");
    Alergias.setText("");
    HC.setText("");
    HM.setText("");
    CPF.setText("");
    Telefone.setText("");
    Cidade.setText("");
  
    
    
    }//GEN-LAST:event_FînalizarActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        // TODO add your handling code here:
         if (Login.role.equals("ORTOPEDISTA")) {
            new EditarPacientes().setVisible(true);
            this.dispose();
        }
        else if (Login.role.equals("SECRETARIA")) {
            new EditarPacientesSecretaria().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Função inválida, destruindo a sessão...");
            this.dispose();
        }
    }//GEN-LAST:event_VoltarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Alergias;
    private javax.swing.JTextField CPF;
    private javax.swing.JTextField Cidade;
    private javax.swing.JTextField DDN;
    private javax.swing.JTextField Email;
    private javax.swing.JButton Fînalizar;
    private javax.swing.JTextField HC;
    private javax.swing.JTextField HM;
    private javax.swing.JTextField Nome;
    private javax.swing.JTextField Telefone;
    private javax.swing.JButton Voltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    // End of variables declaration//GEN-END:variables



}
