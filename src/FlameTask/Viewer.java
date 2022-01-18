/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlameTask;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 *
 * @author David
 */
public class Viewer extends Canvas implements Runnable {

    private BufferedImage imagenfondo;
    Graphics g;
    FlamePalette paleta;
    private String filepath = "";
    private boolean paletaVerde = false;
    private boolean paletaRoja = true;
    private boolean paletaAzul = false;
    private boolean paletaLila = false;
    Flame flame;

    //Constructor Viewer
    public Viewer(Flame flame) {

        //
        try {
            imagenfondo = ImageIO.read(new File(this.getFilepath()));
        } catch (IOException e) {
            System.out.println("Error al cargar la Imagen");
        }

        this.flame = flame;
        Thread fuego = new Thread(flame);
        fuego.start();

    }

    //Setters y Getters
    public void setPaletaVerde(boolean paletaVerde) {
        System.out.println("Cambiamos variable");
        this.paletaVerde = paletaVerde;
    }

    public boolean isPaletaVerde() {
        return paletaVerde;
    }

    public boolean isPaletaRoja() {
        return paletaRoja;
    }

    public void setPaletaRoja(boolean paletaRoja) {
        this.paletaRoja = paletaRoja;
    }

    public boolean isPaletaAzul() {
        return paletaAzul;
    }

    public void setPaletaAzul(boolean paletaAzul) {
        this.paletaAzul = paletaAzul;
    }

    public boolean isPaletaLila() {
        return paletaLila;
    }

    public void setPaletaLila(boolean paletaLila) {
        this.paletaLila = paletaLila;
    }

    //
    public void backgroundImage() {
        try {
            imagenfondo = ImageIO.read(new File(this.getFilepath()));
        } catch (IOException e) {
            System.out.println("Error al cargar la Imagen");
        }
    }

    //Creamos el método Paint
    public void paint() {
        BufferStrategy bs = this.getBufferStrategy();
        g = bs.getDrawGraphics();
        if (bs == null) {
            return;
        }
        if (g == null) {
            return;
        }
        //System.out.println("Se pinta la chimenea");
        this.backgroundImage();
        g.drawImage(imagenfondo, 0, 0, this.getWidth(), this.getHeight(), null);
        //System.out.println("Pintamos el fugo");
        //g.drawImage(fl,130,194,213,175,null);
        g.drawImage(flame, 0, 0, this.getWidth(), this.getHeight(), null);

        bs.show();
        g.dispose();
    }

    public void setFlamePalette() {
        paletaVerde = false;
        paletaAzul = false;
        paletaLila = false;

        paleta = new FlamePalette();
        //        Indicamos los colores que queremos
        TargetColor c1 = new TargetColor(new Color(0, 0, 0, 0), 0);//FondoTransparente
        TargetColor c2 = new TargetColor(new Color(20, 20, 20, 255), 50);//GrisOscuro
        TargetColor c3 = new TargetColor(new Color(40, 40, 40, 255), 80);//Gris
        TargetColor c4 = new TargetColor(new Color(255, 0, 0, 255), 110);//Rojo
        TargetColor c5 = new TargetColor(new Color(255, 255, 0, 255), 130);//Amarillo
        TargetColor c6 = new TargetColor(new Color(255, 255, 255, 255), 255);//Sparks Blancas

        paleta.addTargetColor(c1);
        paleta.addTargetColor(c2);
        paleta.addTargetColor(c3);
        paleta.addTargetColor(c4);
        paleta.addTargetColor(c5);
        paleta.addTargetColor(c6);

        paleta.createPalette();

        this.flame.setFlamePalette(paleta);
    }

    public void setFlamePaletteBlue() {
        paletaVerde = false;
        paletaRoja = false;
        paletaLila = false;
        paleta = new FlamePalette();
        //        Indicamos los colores que queremos
        TargetColor c1 = new TargetColor(new Color(0, 0, 0, 0), 0);//FondoTransparente
        TargetColor c2 = new TargetColor(new Color(20, 20, 20, 255), 50);//GrisOscuro
        TargetColor c3 = new TargetColor(new Color(40, 40, 40, 255), 80);//Gris
        TargetColor c4 = new TargetColor(new Color(0, 190, 255, 255), 110);//Depskyblue
        TargetColor c5 = new TargetColor(new Color(30, 145, 255, 255), 130);//DodgerBlue
        TargetColor c6 = new TargetColor(new Color(0, 0, 255, 255), 255);//Sparks Blue

        paleta.addTargetColor(c1);
        paleta.addTargetColor(c2);
        paleta.addTargetColor(c3);
        paleta.addTargetColor(c4);
        paleta.addTargetColor(c5);
        paleta.addTargetColor(c6);

        paleta.createPalette();

        this.flame.setFlamePalette(paleta);
    }

    public void setFlamePaletteGreen() {
        paleta = new FlamePalette();
        TargetColor c1 = new TargetColor(new Color(0, 0, 0, 0), 0);//FondoTransparente
        TargetColor c2 = new TargetColor(new Color(20, 20, 20, 255), 50);//GrisOscuro
        TargetColor c3 = new TargetColor(new Color(40, 40, 40, 255), 80);//Gris
        TargetColor c4 = new TargetColor(new Color(0, 128, 0, 255), 110);//Green
        TargetColor c5 = new TargetColor(new Color(0, 255, 30, 255), 130);//Green light
        TargetColor c6 = new TargetColor(new Color(100, 250, 150, 255), 255);//Sparks Green

        paleta.addTargetColor(c1);
        paleta.addTargetColor(c2);
        paleta.addTargetColor(c3);
        paleta.addTargetColor(c4);
        paleta.addTargetColor(c5);
        paleta.addTargetColor(c6);

        paleta.createPalette();

        this.flame.setFlamePalette(paleta);
    }

    public void setFlamePalettePurple() {
        paleta = new FlamePalette();
        TargetColor c1 = new TargetColor(new Color(0, 0, 0, 0), 0);//FondoTransparente
        TargetColor c2 = new TargetColor(new Color(20, 20, 20, 255), 50);//GrisOscuro
        TargetColor c3 = new TargetColor(new Color(40, 40, 40, 255), 80);//Lilac
        TargetColor c4 = new TargetColor(new Color(210, 85, 255), 110);//Tulip
        TargetColor c5 = new TargetColor(new Color(145, 0, 200, 255), 130);//Nightshade
        TargetColor c6 = new TargetColor(new Color(70, 0, 100, 255), 255);//Sparks Raisin

        paleta.addTargetColor(c1);
        paleta.addTargetColor(c2);
        paleta.addTargetColor(c3);
        paleta.addTargetColor(c4);
        paleta.addTargetColor(c5);
        paleta.addTargetColor(c6);

        paleta.createPalette();

        this.flame.setFlamePalette(paleta);
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void run() {
        this.setFlamePalette();
        //Creamos el BufferStrategy para que la imagen de la chimenea no aparezca.
        createBufferStrategy(2);

        while (true) {

            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (paletaVerde) {
                this.setFlamePaletteGreen();

            } else if (paletaAzul) {
                this.setFlamePaletteBlue();

            } else if (paletaLila) {
                this.setFlamePalettePurple();

            } else if (paletaRoja) {
                this.setFlamePalette();
            }
            
            this.paint();

        }
    }
}
