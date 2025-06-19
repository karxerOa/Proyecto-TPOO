/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author apnil
 */
public class Receta {
    private Paciente paciente;
    private Doctor doctor;
    private String medicamentosDosis;
    private String recomendaciones;
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) throws Exception {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) throws Exception {
        this.doctor = doctor;
    }

    public String getMedicamentosDosis() {
        return medicamentosDosis;
    }

    public void setMedicamentosDosis(String medicamentosDosis) throws Exception {
        if (medicamentosDosis == null || medicamentosDosis.isBlank()) {
            throw new Exception("Debe especificar los medicamentos y dosis.");
        }
        this.medicamentosDosis = medicamentosDosis;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) throws Exception {
        if (recomendaciones == null || recomendaciones.isBlank()) {
            throw new Exception("Debe especificar las recomendaciones.");
        }
        this.recomendaciones = recomendaciones;
    }

    // === Método útil adicional ===
    public String mostrarInfo() {
        return "Receta médica:\n" +
               "Paciente: " + paciente.verNombreCompleto() + "\n" +
               "Doctor: " + doctor.verNombreCompleto() + "\n" +
               "Medicamentos y dosis: " + medicamentosDosis + "\n" +
               "Recomendaciones: " + recomendaciones;
    }
}
