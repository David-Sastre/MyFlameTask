/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlameTask;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class FlamePalette {
    private int tempColor = 256;
    private Color[] palette = new Color [tempColor];
//    Array que contiene los colores de la paleta.
    private ArrayList<TargetColor> tc = new ArrayList<TargetColor>();
    
//    Constructor vacío
    public FlamePalette() {
        
    
    }

    public int getTempColor() {
        return tempColor;
    }

    public void setTempColor(int tempColor) {
        this.tempColor = tempColor;
    }
    

    public Color[] getPalette() {
        return palette;
    }

    public void setPalette(Color[] colores) {
        this.palette = colores;
    }
    
    public void setTargetColor (ArrayList<TargetColor> tc){
        this.tc = tc;
    }
    
    public void addTargetColor (TargetColor targcol){
        tc.add(targcol);
    }
    
    
    public int getColor(int temp) {
        if (temp >= 0 && temp <= 256){
            int aux;
            aux = ( palette[temp].getAlpha()<<24
                   | palette[temp].getRed()<<16
                   | palette[temp].getGreen()<<8
                   | palette[temp].getBlue());
            return aux;       
        }else{
        return 0;
        }
    }
       
    
    public void createPalette(){
        for (int i = 0 ; i < tc.size() ; i++) {
            if (i == tc.size()-1) {
                palette[tc.get(i).getTemperatura()] = tc.get(i).getColor();
            } else {
                interpolateColors(tc.get(i), tc.get(i+1));
            }
        } 
    }
    
    private void interpolateColors(TargetColor tgFrom, TargetColor tgTo) {
      //Debemos establecer el primer y el último color.
        float tgFromR = tgFrom.getColor().getRed(); 
        float tgFromG = tgFrom.getColor().getGreen();
        float tgFromB = tgFrom.getColor().getBlue(); 
        float tgFromA = tgFrom.getColor().getAlpha();
      
        float tgToR = tgTo.getColor().getRed(); 
        float tgToG = tgTo.getColor().getGreen();
        float tgToB = tgTo.getColor().getBlue(); 
        float tgToA = tgTo.getColor().getAlpha();
        
        //Obtenemos los pasos restando el inicial por el final.
        int pasos = tgTo.getTemperatura() - tgFrom.getTemperatura();
        
        //Obtenemos el incremento total de cada color.
        float incrementoR = tgToR - tgFromR;
        float incrementoG = tgToG - tgFromG;
        float incrementoB = tgToB - tgFromB;
        float incrementoA = tgToA - tgFromA;
        
        palette[tgFrom.getTemperatura()]= tgFrom.getColor();
        
        //Incremento de los pasos obtenidos.
        float incPasosR = incrementoR / pasos;
        float incPasosG = incrementoG / pasos;
        float incPasosB = incrementoB / pasos;
        float incPasosA = incrementoA / pasos;
        
        for (int i=1; i < pasos; i++) {
            int r = Math.round(tgFromR+incPasosR*i);
            int g = Math.round(tgFromG+incPasosG*i);
            int b = Math.round(tgFromB+incPasosB*i);
            int a = Math.round(tgFromA+incPasosA*i);
            Color colAux = new Color(r,g,b,a);
            palette[tgFrom.getTemperatura()+i] = colAux;
        }
        
        palette[tgTo.getTemperatura()] = tgTo.getColor();
               
    }

}
