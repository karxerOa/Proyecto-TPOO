/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import Clases.Usuario;
import java.time.LocalDate;

/**
 *
 * @author apnil
 */
public class Recepcionista extends Persona{
    private int IdRecepcionista;
    private Usuario user;


    public Recepcionista() {
    }
        

    public int getIdRecepcionista() {
        return IdRecepcionista;
    }

    public void setIdRecepcionista(int IdRecepcionista) {
        this.IdRecepcionista = IdRecepcionista;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
