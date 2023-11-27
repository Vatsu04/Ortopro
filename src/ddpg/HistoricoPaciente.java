/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ddpg;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 62127512022.3
 */
public class HistoricoPaciente extends javax.swing.JFrame {
public static String pacienteSelecionado;
    
  
    public HistoricoPaciente() {
        initComponents();
        if (Login.role.equals("ORTOPEDISTA")) {
            pacienteSelecionado = EditarPacientes.cliente;
        }
        else if (Login.role.equals("SECRETARIA")) {
            pacienteSelecionado = EditarPacientesSecretaria.cliente;
        } else {
            JOptionPane.showMessageDialog(null, "Função inválida, destruindo a sessão...");
            this.dispose();
        }
        ID.setText(pacienteSelecionado);
        
        listarConsultas();
        listarProntuario();
    }


    
    
    /*
    new PesquisarHistoricoCliente().setVisible(true);
    this.dispose();
    */

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Voltar = new javax.swing.JButton();
        ID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaConsultas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaProntuario = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Voltar.setContentAreaFilled(false);
        Voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });
        getContentPane().add(Voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 260, 40));

        ID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 150, 30));

        TabelaConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Consulta", "ID Paciente", "Horario", "Data"
            }
        ));
        jScrollPane1.setViewportView(TabelaConsultas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 740, 240));

        TabelaProntuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Prontuário", "ID Consulta", "Diagnóstico", "Remedios", "Retorno", "ID Paciente"
            }
        ));
        jScrollPane2.setViewportView(TabelaProntuario);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 740, 240));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Prototipos/9.png"))); // NOI18N
        jLabel2.setText("jLabel1");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(HistoricoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoricoPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTable TabelaConsultas;
    private javax.swing.JTable TabelaProntuario;
    private javax.swing.JButton Voltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

private void listarConsultas() { //Declaração do método listarValores(). Esse método é provavelmente parte de uma classe e é responsável por preencher uma tabela ou lista com valores obtidos de algum lugar, como um banco de dados.
        try {
            ConsultasDAO objConsultasDAO = new ConsultasDAO();
            DefaultTableModel model = (DefaultTableModel) TabelaConsultas.getModel();
            model.setNumRows(0);

            ArrayList<Consultas> lista = objConsultasDAO.PesquisarConsultasPorId(pacienteSelecionado);

            for (int num = 0; num < lista.size(); num++) {
                model.addRow(new Object[]{
                    lista.get(num).getId_Consulta(),
                     lista.get(num).getId_Paciente(),
                   lista.get(num).getHorario(),
                    lista.get(num).getData_Consulta()
                });

            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Listar Valores :" + erro);
        }
    }

private void listarProntuario() { //Declaração do método listarValores(). Esse método é provavelmente parte de uma classe e é responsável por preencher uma tabela ou lista com valores obtidos de algum lugar, como um banco de dados.
        try {
            ProntuarioDAO objProntuarioDAO = new ProntuarioDAO();
            DefaultTableModel model = (DefaultTableModel) TabelaProntuario.getModel();
            model.setNumRows(0);

            ArrayList<Prontuario> lista = objProntuarioDAO.PesquisarProntuarioPorId(pacienteSelecionado);

            for (int num = 0; num < lista.size(); num++) {
                model.addRow(new Object[]{
                    lista.get(num).getId_Prontuario(),
                     lista.get(num).getId_Prontuario(),
                   lista.get(num).getDiagnostico(),
                    lista.get(num).getRetorno(),
                    lista.get(num).getRemedios_Prescritos()
                  
                });

            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Listar Valores :" + erro);
        }
    }

}
