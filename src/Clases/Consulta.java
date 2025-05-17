/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author USUARIO
 */
public class Consulta 
{
    private int prioridad;
    private Persona paciente;

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Persona getPaciente() {
        return paciente;
    }

    public void setPaciente(Persona paciente) {
        this.paciente = paciente;
    }
    public void Prioridad()
    { 
      if (prioridad < 1 || prioridad > 3)
      {
         System.out.println("La prioridad debe estar entre 1 y 3.");
      }            
    }          
}
