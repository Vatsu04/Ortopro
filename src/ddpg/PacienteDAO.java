

package ddpg;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement; 
import ddpg.Paciente;
import com.mysql.jdbc.Driver;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 62127512022.3
 */
public class PacienteDAO {
     private Connection connection;
     ArrayList<Paciente> lista = new ArrayList<>(); 
     int Id_Paciente;
     String Nome_Completo;
     String CPF;
     String Email;
     String Telefone;
     String Cidade;
     String Naturalidade;
     String Data_Nascimento;
     String Historico_Medico;
     String Historico_Cirurgico;
     String Alergias;
      public PacienteDAO(){
        this.connection = (Connection) new ConnectionProject().getConnection();
    }
       public void adiciona(Paciente paciente){
        String sql = "INSERT INTO pacientes(Nome_Completo, CPF, Email, Telefone, Cidade,  Data_Nascimento, Historico_Medico, Historico_Cirurgico, Alergias) VALUES (?, ?, ?, ?, ?,?, ?, ?, ? )";
 // Comando para inserir os dados no banco de dados
        try{
            PreparedStatement stmt = connection.prepareStatement(sql); // Essa linha da o valor para o placeholder do comando (?), o numero é necessario para pegar a index do placenholder, e o valor é variavel é definida
            stmt.setString(1, paciente.getNome_Completo()); 
            stmt.setString(2, paciente.getCPF());
            stmt.setString(3, paciente.getEmail());
            stmt.setString(4, paciente.getTelefone());
            stmt.setString(5, paciente.getCidade());
            stmt.setString(6, paciente.getData_Nascimento());
            stmt.setString(7, paciente.getHistorico_Medico());
            stmt.setString(8, paciente.getHistorico_Cirurgico());
            stmt.setString(9, paciente.getAlergias());
         
            
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }
}
      public ArrayList<Paciente> PesquisarPaciente() {
        this.connection = (Connection) new ConnectionProject().getConnection(); // Obtém a conexão com o banco de dados
        String sql = "Select * from pacientes";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs;
            rs = stmt.executeQuery(); // Executa a consulta SQL e armazena o resultado no ResultSet

            while (rs.next()) {
                Paciente objPaciente = new Paciente();
                objPaciente.setId_Paciente(rs.getInt("Id_Paciente"));  // Obtém o ID do usuário do resultado da consulta
                objPaciente.setNome_Completo(rs.getString("Nome_Completo")); 
                 objPaciente.setCPF(rs.getString("CPF"));
                  objPaciente.setEmail(rs.getString("Email")); 
                objPaciente.setTelefone(rs.getString("Telefone"));
                objPaciente.setCidade(rs.getString("Cidade")); //// Obtém o telefone do usuár
                
                objPaciente.setData_Nascimento(rs.getString("Data_Nascimento")); // Obtém o email do usuário do resultado da consulta
                objPaciente.setHistorico_Medico(rs.getString("Historico_Medico")); // Obtém a senha do usuário do resultado da consulta
                 objPaciente.setHistorico_Cirurgico(rs.getString("Historico_Cirurgico"));
                  objPaciente.setAlergias(rs.getString("Alergias"));
                lista.add(objPaciente); // Adiciona o usuário à lista
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "PacienteDAO Pesquisar :" + erro);
        }
        return lista; // Retorna a lista de usuários

    }

    public void AlterarPaciente(Paciente objPaciente) {
      String sql = "update pacientes set "
        + "Nome_Completo = ?, "
        + "CPF = ?, "
        + "Email = ?, "
        + "Telefone = ?, "
        + "Cidade = ?, "            
        + "Data_Nascimento = ?, "
        + "Historico_Medico = ?, "
        + "Historico_Cirurgico = ?, "
        + "Alergias = ? "
        + "where Id_Paciente = ?";

        this.connection = (Connection) new ConnectionProject().getConnection(); // Obtém a conexão com o banco de dados

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, objPaciente.getNome_Completo()); // Define o novo nome do usuário no comando SQL
            stmt.setString(2, objPaciente.getCPF()); // Define o novo telefone do usuário no comando SQL
            stmt.setString(3, objPaciente.getEmail()); // Define o novo telefone do usuário no comando SQL
            stmt.setString(4, objPaciente.getTelefone()); // Define o novo email do usuário no comando SQL
            stmt.setString(5, objPaciente.getCidade());

            stmt.setString(6, objPaciente.getData_Nascimento());
            stmt.setString(7, objPaciente.getHistorico_Medico());
            stmt.setString(8, objPaciente.getHistorico_Cirurgico());//
            stmt.setString(9, objPaciente.getAlergias());
            stmt.setInt(10, objPaciente.getId_Paciente()); // Define o ID do usuário no comando SQL
            stmt.execute(); // Executa o comando SQL
            stmt.close(); // Fecha o PreparedStatement

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Paciente Alterar :" + erro);
        }
    }

    public void ExcluirPaciente(Paciente objPaciente) {
        String sql = ("Delete from pacientes where Id_Paciente = ?");
        this.connection = (Connection) new ConnectionProject().getConnection(); // Obtém a conexão com o banco de dados
        
        try {

            PreparedStatement stmt = connection.prepareStatement(sql); // Define o ID do usuário no comando SQL
            stmt.setInt(1, objPaciente.getId_Paciente());

            stmt.execute(); // Executa o comando SQL
            stmt.close(); // Fecha o PreparedStatement

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Usuarios Excluir :" + erro);
        }
    }

      
}
