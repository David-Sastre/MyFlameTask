/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlameTask;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author David
 */
public class Flame extends BufferedImage implements Runnable {

    BufferedImage imagen = null;
    private String imgfile;
    private int[][] matriz;
    private FlamePalette flamePalette;
    private boolean isRunning = true;
    private boolean isBlizzard = false;
    private int SPARKS = 50;
    private int COOL = 55;
    private double increment = 0.9;
    private long speed = 70;
    private int imageType;
    
//Getters & Setters

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public boolean isIsBlizzard() {
        return isBlizzard;
    }

    public void setIsBlizzard(boolean isBlizzard) {
        this.isBlizzard = isBlizzard;
    }

    public int getSPARKS() {
        return SPARKS;
    }

    public void setSPARKS(int SPARKS) {
        this.SPARKS = SPARKS;
    }

    public int getCOOL() {
        return COOL;
    }

    public void setCOOL(int COOL) {
        this.COOL = COOL;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }
    
    //Métodos
    public Flame(int width, int height, int imageType) {
        super(width, height, imageType);
        this.imageType = imageType;
        matriz = new int[width][height];
    }

    //Getter Setter de FlamePalette
    public FlamePalette getFlamePalette() {
        return flamePalette;
    }

    public void setFlamePalette(FlamePalette flamePalette) {
        this.flamePalette = flamePalette;
    }

    //Creamos las Sparks
    public void createSparks() {
        System.out.println("Se crean las chispas");
        for (int i = 0; i < matriz.length; i++) {
            int aux = (int) (Math.random() * 300);
            if (aux <= SPARKS) {
                matriz[i][matriz[0].length - 1] = 255;
            }
        }
    }

    //Creamos los puntos fríos
    public void createCool() {
        System.out.println("Se crean los puntos frios");
        if (!isBlizzard) {
            for (int i = 0; i < matriz.length; i++) {
                int aux = (int) (Math.random() * 300);
                if (aux <= COOL) {
                    matriz[i][matriz[0].length - 1] = 0;
                }
            }
        } else {
            for (int j = 0; j < matriz[0].length - 2; j++) {
                int aux = (int) (Math.random() * 800);
                if (aux <= COOL) {
                    matriz[j][matriz[0].length - 1] = 0;
                }
            }
        }
    }

    //EvolveTemperature
    public void EvolveTemperature() {
        if (!isBlizzard) {
            System.out.println("Evolución del fuego");
            for (int j = matriz[0].length - 2; j >= 0; j--) {
                for (int i = 1; i < matriz.length - 1; i++) {
                    matriz[i][j] = (int) (((matriz[i][j + 1] + matriz[i + 1][j + 1]
                            + matriz[i - 1][j + 1] + matriz[i - 1][j] + matriz[i + 1][j]
                            + matriz[i][j]) / 6) + increment);
                }
            }
        } else {
            for (int i = 1; i < matriz.length - 1; i++) {
                for (int j = matriz[0].length - 2; j >= 0; j--) {
                    matriz[i][j] = (int) ((matriz[i][j + 1] + matriz[i + 1][j + 1] + matriz[i - 1][j + 1] + matriz[i - 1][j] + matriz[i][j]) / 5 - increment);
                }
            }
        }
    }

    //CreateFlameImage
    public void createFlameImage() {
        System.out.println("Creamos las llamas");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int p = this.getFlamePalette().getColor(matriz[i][j]);
                this.setRGB(i, j, p);

            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isRunning) {
                //Sparks
                this.createSparks();
                //CreateCool
                this.createCool();
                //EvolveTemperature
                this.EvolveTemperature();
                //CreateFlameImage
                this.createFlameImage();
            }
        }
    }
}
