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

  
    public int getId_Consulta() {
        return Id_Consulta;
    }

    public void setId_Consulta(int Id_Consulta) {
        this.Id_Consulta = Id_Consulta;
    }

    public int getId_Paciente() {
        return Id_Paciente;
    }


    public void setId_Paciente(int Id_Paciente) {
        this.Id_Paciente = Id_Paciente;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public String getData_Consulta() {
        return Data_Consulta;
    }

    public void setData_Consulta(String Data_Consulta) {
        this.Data_Consulta = Data_Consulta;
    }
    private int Id_Consulta;
    private int Id_Paciente;
    private String Horario;
    private String Data_Consulta;
}
