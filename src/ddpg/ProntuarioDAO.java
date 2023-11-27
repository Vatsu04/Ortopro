/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ddpg;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement; 
import ddpg.Prontuario;
import com.mysql.jdbc.Driver;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author 62127512022.3
 */
public class ProntuarioDAO {
    private Connection connection;
     ArrayList<Prontuario> lista = new ArrayList<>();
     int Id_Prontuario;
     int Id_Paciente;
     String Diagnostico;
     String Retorno;
     String Remedios_Prescritos;
     int Id_Consulta;
     public ProntuarioDAO(){
        this.connection = (Connection) new ConnectionProject().getConnection();
    }
     public void adiciona(Prontuario prontuario){
        String sql = "INSERT INTO prontuario(Id_Paciente, Diagnostico, Retorno, Remedios_Prescritos, Id_Consulta ) VALUES (?, ?, ?, ?, ?)";
 // Comando para inserir os dados no banco de dados
        try{
            PreparedStatement stmt = connection.prepareStatement(sql); // Essa linha da o valor para o placeholder do comando (?), o numero é necessario para pegar a index do placenholder, e o valor é variavel é definida
            stmt.setInt(1, prontuario.getId_Paciente()); 
            stmt.setString(2, prontuario.getDiagnostico());
            
            
            stmt.setString(3, prontuario.getRetorno());
      stmt.setString(4, prontuario.getRemedios_Prescritos());
      stmt.setInt(5, prontuario.getId_Consulta());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }
}
   public ArrayList<Prontuario> PesquisarProntuario() {
        this.connection = (Connection) new ConnectionProject().getConnection(); // Obtém a conexão com o banco de dados
        String sql = "SELECT * from prontuario";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs;
            rs = stmt.executeQuery(); // Executa a consulta SQL e armazena o resultado no ResultSet

            while (rs.next()) {
                Prontuario objProntuario = new Prontuario();
                objProntuario.setId_Prontuario(rs.getInt("Id_Prontuario"));  // Obtém o ID do usuário do resultado da consulta
                 objProntuario.setId_Paciente(rs.getInt("Id_Paciente"));  
                objProntuario.setDiagnostico(rs.getString("Diagnostico")); 
                 objProntuario.setRetorno(rs.getString("Retorno")); // Obtém o nome do usuário do resultado da consulta
                objProntuario.setRemedios_Prescritos(rs.getString("Remedios_Prescritos")); // Obtém o telefone do usuár
                objProntuario.setId_Consulta(rs.getInt("Id_Consulta"));
                
                lista.add(objProntuario); // Adiciona o usuário à lista
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ConsultaDAO Pesquisar :" + erro);
        }
        return lista; // Retorna a lista de usuários

    }  
     public void AlterarProntuario(Prontuario objProntuario) {
         
          boolean isPacienteExistente = verificarPacienteExistente(objProntuario.getId_Paciente());
    boolean isConsultaExistente = verificarConsultaExistente(objProntuario.getId_Consulta());

    if (!isPacienteExistente) {
        JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
        return; // Stop further execution if the client doesn't exist
    }

    if (!isConsultaExistente) {
        JOptionPane.showMessageDialog(null, "Consulta não encontrada.");
        return; // Stop further execution if the product doesn't exist
    }
         
        String sql = ("update prontuario set Id_Paciente  = ?, Diagnostico = ?, Retorno = ?, Remedios_Prescritos = ?, Id_Consulta = ? where Id_Prontuario = ?");
        this.connection = (Connection) new ConnectionProject().getConnection(); // Obtém a conexão com o banco de dados

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, objProntuario.getId_Paciente()); // Define o novo nome do usuário no comando SQL
            stmt.setString(2, objProntuario.getDiagnostico()); // Define o novo telefone do usuário no comando SQL
           // Define o novo email do usuário no comandstmt.setString(3, objProntuario.getEndereco()); // Define o novo telefone do usuário no comando SQL
         // Deo SQL
            stmt.setString(3, objProntuario.getRetorno()); 
            stmt.setString(4, objProntuario.getRemedios_Prescritos()); 
            stmt.setInt(5, objProntuario.getId_Consulta()); 
// Define o ID do usuário no comando SQL
   stmt.setInt(6, objProntuario.getId_Prontuario()); // Define o ID do usuário no comando SQL
            stmt.execute(); // Executa o comando SQL
            stmt.close(); // Fecha o PreparedStatement

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Clientes Alterar :" + erro);
        }
    }
      public void ExcluirProntuario(Prontuario objProntuario) {
        String sql = ("Delete from prontuario where Id_Prontuario = ?");
        this.connection = (Connection) new ConnectionProject().getConnection(); // Obtém a conexão com o banco de dados
        
        try {

            PreparedStatement stmt = connection.prepareStatement(sql); // Define o ID do usuário no comando SQL
            stmt.setInt(1, objProntuario.getId_Prontuario());

            stmt.execute(); // Executa o comando SQL
            stmt.close(); // Fecha o PreparedStatement

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Usuarios Excluir :" + erro);
        }
    }
      
   
        public ArrayList<Prontuario> PesquisarProntuarioPorId(String Paciente_Selecionado) {
        this.connection = (Connection) new ConnectionProject().getConnection(); // Obtém a conexão com o banco de dados
        String sql = "Select * from prontuario where Id_Paciente = " + Paciente_Selecionado;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs;
            rs = stmt.executeQuery(); // Executa a consulta SQL e armazena o resultado no ResultSet

            while (rs.next()) {
                Prontuario objProntuario = new Prontuario();
                objProntuario.setId_Prontuario(rs.getInt("Id_Prontuario"));  // Obtém o ID do usuário do resultado da consulta
               
           
                 objProntuario.setDiagnostico(rs.getString("Diagnostico"));
                objProntuario.setRetorno (rs.getString("Retorno")); // Obtém o telefone do usuár
                objProntuario.setRetorno (rs.getString("Remedios_Prescritos")); 
                objProntuario.setRetorno(rs.getString("Id_Consulta"));
               
              

                lista.add(objProntuario); // Adiciona o usuário à lista
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ProntuarioDAO Pesquisar :" + erro);
        }
        return lista; // Retorna a lista de usuários

    }
        public boolean verificarPacienteExistente(int idPaciente) {
        String sql = "SELECT Id_Paciente FROM pacientes WHERE Id_Paciente = ?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idPaciente);
            ResultSet rs = stmt.executeQuery();
               
             
            boolean clienteExiste = rs.next();
            
            rs.close();
            stmt.close();
            
            return clienteExiste;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        
        public boolean verificarConsultaExistente(int idConsulta) {
        String sql = "SELECT Id_Consulta FROM consultas WHERE Id_Consulta = ?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idConsulta);
            ResultSet rs = stmt.executeQuery();
               
             
            boolean consultaExiste = rs.next();
            
            rs.close();
            stmt.close();
            
            return consultaExiste;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
