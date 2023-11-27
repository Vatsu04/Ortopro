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
import ddpg.Consultas;
import com.mysql.jdbc.Driver;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author 62127512022.3
 */
public class ConsultasDAO {
    private Connection connection;
     ArrayList<Consultas> lista = new ArrayList<>(); 
     int Id_Consulta;
     String Id_Paciente;
     String Horario;
     String Data_Consulta;
     public ConsultasDAO(){
        this.connection = (Connection) new ConnectionProject().getConnection();
    }
     public void adiciona(Consultas consultas){
        String sql = "INSERT INTO consultas(Id_Paciente, Horario, Data_Consulta) VALUES (?, ?, ?)";
 // Comando para inserir os dados no banco de dados
        try{
            PreparedStatement stmt = connection.prepareStatement(sql); // Essa linha da o valor para o placeholder do comando (?), o numero é necessario para pegar a index do placenholder, e o valor é variavel é definida
            stmt.setInt(1, consultas.getId_Paciente()); 
            stmt.setString(2, consultas.getHorario());
            
            
            stmt.setString(3, consultas.getData_Consulta());
      
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }
}
   public ArrayList<Consultas> PesquisarConsulta() {
        this.connection = (Connection) new ConnectionProject().getConnection(); // Obtém a conexão com o banco de dados
        String sql = "SELECT * from consultas";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs;
            rs = stmt.executeQuery(); // Executa a consulta SQL e armazena o resultado no ResultSet

            while (rs.next()) {
                Consultas objConsultas = new Consultas();
                objConsultas.setId_Consulta(rs.getInt("Id_Consulta"));  // Obtém o ID do usuário do resultado da consulta
                 objConsultas.setId_Paciente(rs.getInt("Id_Paciente"));  
                objConsultas.setHorario(rs.getString("Horario")); // Obtém o nome do usuário do resultado da consulta
                objConsultas.setData_Consulta(rs.getString("Data_Consulta")); // Obtém o telefone do usuár
           
                
                
                lista.add(objConsultas); // Adiciona o usuário à lista
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ConsultaDAO Pesquisar :" + erro);
        }
        return lista; // Retorna a lista de usuários

    }  
     public void AlterarConsultas(Consultas objConsultas) {
                   boolean isPacienteExistente = verificarPacienteExistente(objConsultas.getId_Paciente());


    if (!isPacienteExistente) {
        JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
        return; // Stop further execution if the client doesn't exist
    }
         
        String sql = ("update consultas set Id_Paciente  = ?, Horario = ?, Data_Consulta = ? where Id_Consulta = ?");
        this.connection = (Connection) new ConnectionProject().getConnection(); // Obtém a conexão com o banco de dados

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, objConsultas.getId_Paciente()); // Define o novo nome do usuário no comando SQL
            stmt.setString(2, objConsultas.getHorario()); // Define o novo telefone do usuário no comando SQL
           // Define o novo email do usuário no comandstmt.setString(3, objConsultas.getEndereco()); // Define o novo telefone do usuário no comando SQL
         // Deo SQL
            stmt.setString(3, objConsultas.getData_Consulta()); 
            
// Define o ID do usuário no comando SQL
   stmt.setInt(4, objConsultas.getId_Consulta()); // Define o ID do usuário no comando SQL
            stmt.execute(); // Executa o comando SQL
            stmt.close(); // Fecha o PreparedStatement

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Clientes Alterar :" + erro);
        }
    }
      public void ExcluirConsultas(Consultas objConsultas) {
        String sql = ("Delete from consultas where Id_Consulta = ?");
        this.connection = (Connection) new ConnectionProject().getConnection(); // Obtém a conexão com o banco de dados
        
        try {

            PreparedStatement stmt = connection.prepareStatement(sql); // Define o ID do usuário no comando SQL
            stmt.setInt(1, objConsultas.getId_Consulta());

            stmt.execute(); // Executa o comando SQL
            stmt.close(); // Fecha o PreparedStatement

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Usuarios Excluir :" + erro);
        }
    }
      
   
        public ArrayList<Consultas> PesquisarConsultasPorId(String Paciente_Selecionado) {
        this.connection = (Connection) new ConnectionProject().getConnection(); // Obtém a conexão com o banco de dados
        String sql = "Select * from consultas where Id_Paciente = " + Paciente_Selecionado;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs;
            rs = stmt.executeQuery(); // Executa a consulta SQL e armazena o resultado no ResultSet

            while (rs.next()) {
                Consultas objConsultas = new Consultas();
                objConsultas.setId_Consulta(rs.getInt("Id_Consulta"));  // Obtém o ID do usuário do resultado da consulta
               
           
                 objConsultas.setHorario(rs.getString("Horario"));
                objConsultas.setData_Consulta(rs.getString("Data_Consulta")); // Obtém o telefone do usuár
                
        
               
              

                lista.add(objConsultas); // Adiciona o usuário à lista
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ConsultasDAO Pesquisar :" + erro);
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
}
