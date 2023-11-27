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
import ddpg.Funcionario;
import com.mysql.jdbc.Driver;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author 62127512022.3
 */
public class FuncionarioDAO {
    private Connection connection;
     ArrayList<Funcionario> lista = new ArrayList<>(); 
    int Id_Funcionario;
    String Nome;
    String Cargo;
    String CPF;
    String Senha;
    String Email;
    String Telefone;
    String Endereco;
     public FuncionarioDAO(){
        this.connection = (Connection) new ConnectionProject().getConnection();
    }
     public void adiciona(Funcionario funcionarios){
        String sql = "INSERT INTO funcionario(Nome, Cargo, CPF, Senha, Email, Telefone, Endereco) VALUES (?, ?, ?, ?, ?, ?, ?)";
 // Comando para inserir os dados no banco de dados
        try{
            PreparedStatement stmt = connection.prepareStatement(sql); // Essa linha da o valor para o placeholder do comando (?), o numero é necessario para pegar a index do placenholder, e o valor é variavel é definida
            stmt.setString(1, funcionarios.getNome()); 
            stmt.setString(2, funcionarios.getCargo());
            
            
            stmt.setString(3, funcionarios.getSenha());
            stmt.setString(4, funcionarios.getEmail());
            stmt.setString(5, funcionarios.getTelefone());
            stmt.setString(6, funcionarios.getEndereco());
          
            
            
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }
}
      public ArrayList<Funcionario> PesquisarFuncionario() {
        this.connection = (Connection) new ConnectionProject().getConnection(); // Obtém a conexão com o banco de dados
        String sql = "SELECT * from funcionario";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs;
            rs = stmt.executeQuery(); // Executa a consulta SQL e armazena o resultado no ResultSet

            while (rs.next()) {
                Funcionario objFuncionario = new Funcionario();
                objFuncionario.setId_Funcionario(rs.getInt("Id_Consulta"));  // Obtém o ID do usuário do resultado da consulta
               
                objFuncionario.setNome(rs.getString("Nome")); // Obtém o nome do usuário do resultado da consulta
                objFuncionario.setCargo(rs.getString("Cargo")); // Obtém o telefone do usuár
           objFuncionario.setCPF(rs.getString("CPF"));
                objFuncionario.setSenha(rs.getString("Senha"));
                objFuncionario.setEmail(rs.getString("Email"));
                objFuncionario.setTelefone(rs.getString("Telefone"));
                objFuncionario.setEndereco(rs.getString("Endereco"));
                lista.add(objFuncionario); // Adiciona o usuário à lista
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ConsultaDAO Pesquisar :" + erro);
        }
        return lista; // Retorna a lista de usuários

    } 
      /*
     public void AlterarFuncionario(Funcionario objFuncionario) {
        String sql = ("update funcionario set Nome  = ?, Cargo, CPF = ?, Senha = ?, Email = ?, Telefone = ?, Endereco = ?  where Id_Consulta = ?");
        this.connection = (Connection) new ConnectionProject().getConnection(); // Obtém a conexão com o banco de dados

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, objFuncionario.getId_Paciente()); // Define o novo nome do usuário no comando SQL
            stmt.setString(2, objFuncionario.getHorario()); // Define o novo telefone do usuário no comando SQL
           // Define o novo email do usuário no comandstmt.setString(3, objFuncionario.getEndereco()); // Define o novo telefone do usuário no comando SQL
         // Deo SQL
            stmt.setString(3, objFuncionario.getData_Consulta()); 
            
// Define o ID do usuário no comando SQL
   stmt.setInt(4, objFuncionario.getId_Consulta()); // Define o ID do usuário no comando SQL
            stmt.execute(); // Executa o comando SQL
            stmt.close(); // Fecha o PreparedStatement

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Clientes Alterar :" + erro);
        }
    }
      public void ExcluirFuncionario(Funcionario objFuncionario) {
        String sql = ("Delete from consultas where Id_Consulta = ?");
        this.connection = (Connection) new ConnectionProject().getConnection(); // Obtém a conexão com o banco de dados
        
        try {

            PreparedStatement stmt = connection.prepareStatement(sql); // Define o ID do usuário no comando SQL
            stmt.setInt(1, objFuncionario.getId_Consulta());

            stmt.execute(); // Executa o comando SQL
            stmt.close(); // Fecha o PreparedStatement

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Usuarios Excluir :" + erro);
        }
    }
      */
}
