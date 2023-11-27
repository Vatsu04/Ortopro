/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ddpg;

/**
 *
 * @author 62127512022.3
 */
public class Prontuario {

    /**
     * @return the Id_Consulta
     */
    public int getId_Consulta() {
        return Id_Consulta;
    }

    /**
     * @param Id_Consulta the Id_Consulta to set
     */
    public void setId_Consulta(int Id_Consulta) {
        this.Id_Consulta = Id_Consulta;
    }

    /**
     * @return the Id_Prontuario
     */
    public int getId_Prontuario() {
        return Id_Prontuario;
    }

    /**
     * @param Id_Prontuario the Id_Prontuario to set
     */
    public void setId_Prontuario(int Id_Prontuario) {
        this.Id_Prontuario = Id_Prontuario;
    }

    /**
     * @return the Id_Paciente
     */
    public int getId_Paciente() {
        return Id_Paciente;
    }

    /**
     * @param Id_Paciente the Id_Paciente to set
     */
    public void setId_Paciente(int Id_Paciente) {
        this.Id_Paciente = Id_Paciente;
    }

    /**
     * @return the Diagnostico
     */
    public String getDiagnostico() {
        return Diagnostico;
    }

    /**
     * @param Diagnostico the Diagnostico to set
     */
    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    /**
     * @return the Retorno
     */
    public String getRetorno() {
        return Retorno;
    }

    /**
     * @param Retorno the Retorno to set
     */
    public void setRetorno(String Retorno) {
        this.Retorno = Retorno;
    }

    /**
     * @return the Remedios_Prescritos
     */
    public String getRemedios_Prescritos() {
        return Remedios_Prescritos;
    }

    /**
     * @param Remedios_Prescritos the Remedios_Prescritos to set
     */
    public void setRemedios_Prescritos(String Remedios_Prescritos) {
        this.Remedios_Prescritos = Remedios_Prescritos;
    }
    private int Id_Prontuario;
    private int Id_Paciente;
    private String Diagnostico;
    private String Retorno;
    private String Remedios_Prescritos;
    private int Id_Consulta;
}
