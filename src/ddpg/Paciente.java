/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ddpg;

/**
 *
 * @author 62127512022.3
 */
public class Paciente {

    
    public int getId_Paciente() {
        return Id_Paciente;
    }

    
    public void setId_Paciente(int Id_Paciente) {
        this.Id_Paciente = Id_Paciente;
    }

  
    public String getNome_Completo() {
        return Nome_Completo;
    }

    public void setNome_Completo(String Nome_Completo) {
        this.Nome_Completo = Nome_Completo;
    }

    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    
    public String getEmail() {
        return Email;
    }

    
    public void setEmail(String Email) {
        this.Email = Email;
    }

    
    public String getTelefone() {
        return Telefone;
    }

    
    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    
    public String getCidade() {
        return Cidade;
    }
    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

   
    
    public String getNaturalidade() {
        return Naturalidade;
    }

   
    public void setNaturalidade(String Naturalidade) {
        this.Naturalidade = Naturalidade;
    }

    /**
     * @return the Data_Nascimento
     */
    public String getData_Nascimento() {
        return Data_Nascimento;
    }

    /**
     * @param Data_Nascimento the Data_Nascimento to set
     */
    public void setData_Nascimento(String Data_Nascimento) {
        this.Data_Nascimento = Data_Nascimento;
    }

    /**
     * @return the Historico_Medico
     */
    public String getHistorico_Medico() {
        return Historico_Medico;
    }

    /**
     * @param Historico_Medico the Historico_Medico to set
     */
    public void setHistorico_Medico(String Historico_Medico) {
        this.Historico_Medico = Historico_Medico;
    }

    /**
     * @return the Historico_Cirurgico
     */
    public String getHistorico_Cirurgico() {
        return Historico_Cirurgico;
    }

    /**
     * @param Historico_Cirurgico the Historico_Cirurgico to set
     */
    public void setHistorico_Cirurgico(String Historico_Cirurgico) {
        this.Historico_Cirurgico = Historico_Cirurgico;
    }

    /**
     * @return the Alergias
     */
    public String getAlergias() {
        return Alergias;
    }

    /**
     * @param Alergias the Alergias to set
     */
    public void setAlergias(String Alergias) {
        this.Alergias = Alergias;
    }
    private int Id_Paciente;
    private String Nome_Completo;
    private String CPF;
    private String Email;
    private String Telefone;
    private String Cidade;
    private String Naturalidade;
    private String Data_Nascimento;
    private String Historico_Medico;
    private String Historico_Cirurgico;
    private String Alergias;
}
