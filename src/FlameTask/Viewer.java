/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlameTask;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author David
 */
public class Viewer extends Canvas implements Runnable{
    private BufferedImage imagenfondo;
    private String imgfile;
    private String aux = "'";
    Flame flame;
    
    

    //Constructor Viewer
    public Viewer (Flame flame){
      
        //
        try{
        System.out.println(imgfile);    
        imagenfondo = ImageIO.read(new File(aux+imgfile+aux));
        }catch(IOException e){
        System.out.println("Error al cargar la Imagen");
        }
        
        this.flame = flame;
        Thread fuego = new Thread (flame);
        fuego.start();
        
    }
    
    //Setter Imgfile
    
    public void setImgfile(String imgfile){
        this.imgfile = imgfile;
    } 

    //Creamos el método Paint
    public void paint() {
        BufferStrategy bs = this.getBufferStrategy();
        Graphics g = bs.getDrawGraphics();
        if (bs==null){
            return;
        }
        if (g==null){
            return;
        }
        //System.out.println("Se pinta la chimenea");
        g.drawImage(imagenfondo,0,0,null);
        //System.out.println("Pintamos el fugo");
        //g.drawImage(fl,130,194,213,175,null);
        g.drawImage(flame,0,0,this.getWidth(),this.getHeight(),null);
        bs.show();
        g.dispose();
    } 

    @Override
    public void run() {
        
        FlamePalette paleta = new FlamePalette();
//        Indicamos los colores que queremos
        TargetColor c1 = new TargetColor(new Color(0,0,0,255),0);//FondoNegro
        TargetColor c2 = new TargetColor (new Color (20,20,20,255),50);//Gris
        TargetColor c3 = new TargetColor (new Color (40,40,40,255),80);//GrisOscuro
        TargetColor c4 = new TargetColor (new Color (255,0,0,255),110);//Rojo
        TargetColor c5 = new TargetColor (new Color (255,255,0,255),130);//Amarillo
        TargetColor c6 = new TargetColor(new Color(255,255,255,255),255);//Sparks Blancas
        
        paleta.addTargetColor(c1);
        paleta.addTargetColor(c2);
        paleta.addTargetColor(c3);
        paleta.addTargetColor(c4);
        paleta.addTargetColor(c5);
        paleta.addTargetColor(c6);
        
        paleta.createPalette();
        
        this.flame.setFlamePalette(paleta);
        //Creamos el BufferStrategy para que la imagen de la chimenea no aparezca.
        createBufferStrategy(2);

        while (true){

            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        this.paint();        

        }
    }
}

