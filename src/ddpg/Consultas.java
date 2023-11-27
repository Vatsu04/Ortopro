/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ddpg;

/**
 *
 * @author 62127512022.3
 */
public class Consultas {

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
     * @return the Horario
     */
    public String getHorario() {
        return Horario;
    }

    /**
     * @param Horario the Horario to set
     */
    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    /**
     * @return the Data_Consulta
     */
    public String getData_Consulta() {
        return Data_Consulta;
    }

    /**
     * @param Data_Consulta the Data_Consulta to set
     */
    public void setData_Consulta(String Data_Consulta) {
        this.Data_Consulta = Data_Consulta;
    }
    private int Id_Consulta;
    private int Id_Paciente;
    private String Horario;
    private String Data_Consulta;
}
