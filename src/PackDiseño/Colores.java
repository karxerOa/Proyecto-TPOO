/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackDiseño;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author apnil
 */
public class Colores {

    public Colores() {
    }
    
    public static Color generarColorAleatorio(){
        Random random = new Random();
        int Rojo = random.nextInt(256);
        int Verde = random.nextInt(256);
        int Azul = random.nextInt(256);
        return new Color(Rojo, Verde, Azul);
    }
}
