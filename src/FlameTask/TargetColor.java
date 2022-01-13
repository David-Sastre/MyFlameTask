/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlameTask;

import java.awt.Color;

/**
 *
 * @author David
 */
public class TargetColor {
    //Atributos
    private int temperatura;
    private Color color;
    
    //Constructor
    public TargetColor(Color c, int temp) {
        color = c;
        temperatura = temp;
    }
    
    //Getters y Setters
    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
