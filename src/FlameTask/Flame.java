/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlameTask;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Flame extends BufferedImage{
    
    private MyFlame myflame;
    private Convolution convolution;
    int[][] matriz;
    private int [][] matrizConv;
    private FlamePalette flamePalette;
    boolean isBlizzard = false;
    int SPARKS = 50;
    int COOL = 55;
    double increment = 0.9;
    private float lum;
    private int imageType;
    private float pixelspint = 150f;
    private float brightness = pixelspint;
    private boolean convoluted;

//Getters & Setters


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

    public float getBrightness() {
        return brightness;
    }

    public void setBrightness(float brightness) {
        this.brightness = brightness;
    }
    
    public boolean isConvoluted() {
        return convoluted;
    }

    public void setConvoluted(boolean convoluted) {
        this.convoluted = convoluted;
       
    }

    public void setMatrizConv(int[][] matrizConv) {
        this.matrizConv = matrizConv;
    }
    
    //Getter Setter de FlamePalette
    public FlamePalette getFlamePalette() {
        return flamePalette;
    }

    public void setFlamePalette(FlamePalette flamePalette) {
        this.flamePalette = flamePalette;
    }
    
    //Métodos
    public Flame(int width, int height, int imageType, MyFlame myflame, Convolution convolution) {
        super(width, height, imageType);
        this.imageType = imageType;
        this.myflame = myflame;
        this.convolution = convolution;
        matriz = new int[width][height];
        
    }


    //Creamos las Sparks
    public void createSparks() {
        //        System.out.println("Se crean las chispas");
        for (int i = 0; i < matriz.length; i++) {
            int aux = (int) (Math.random() * 99);
            if (aux <= SPARKS) {
                matriz[i][matriz.length - 1] = 255;
            }
        }
    }
    
    public void createConvsSparks(int i, int j) {
        int aux = (int) (Math.random() * 99);
            if (aux <= SPARKS) {
                matrizConv[i][j] = 255;
        }
    }
    
    public void findSparksConvoluted() {
        matrizConv = new int [myflame.viewer.getImagencopia().getWidth()][myflame.viewer.getImagencopia().getHeight()];
        int red = 0;
        int green = 0;
        int blue = 0;
        for (int i = 1; i < myflame.viewer.convolution.getCopia().getWidth() - 1; i++) {
            for  (int j = 1; j < myflame.viewer.convolution.getCopia().getHeight()-1; j++){
                red = new Color(myflame.viewer.convolution.getCopia().getRGB(i, j)).getRed();
                green = new Color(myflame.viewer.convolution.getCopia().getRGB(i, j)).getGreen();
                blue = new Color(myflame.viewer.convolution.getCopia().getRGB(i, j)).getBlue();
                lum = (red * 0.2116f + green * 0.7152f + blue * 0.0722f);
                if (lum > brightness) {
                    createConvsSparks(i,j);
                    createCoolConv(i,j);
                }
            }       
        }
    }

    //Creamos los puntos fríos
    public void createCool() {
        for (int i = 0; i < matriz.length; i++) {
            int aux = (int) (Math.random() * 99);
            if (aux <= COOL) {
                matriz[i][matriz.length - 1] = 0;
            }
        }
    }
    
    public void createCoolConv (int i, int j){
//        System.out.println("creamos ountos frios");
        int aux = (int) (Math.random() * 99);
                if (aux <= COOL) {
                    matrizConv[i][j] = 0;
                }
    }

    //EvolveTemperature
    public void EvolveTemperature() {
        if (!isBlizzard) {
//            System.out.println("Evolución del fuego");
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
    
     public void EvolveTemperatureConv() {
        if (!isBlizzard) {
//           System.out.println("Evolución del fuego");
             for (int j = matrizConv[0].length - 2; j >= 1; j--) {
                for (int i = 1; i < matrizConv.length-1; i++) {
//                    System.out.println("b");
//                    System.out.print(matrizConv[i][j] + " - ");
                    matrizConv[i][j] = (int) (((
                              (matrizConv[i][j + 1]    )
                            + (matrizConv[i][j]        )
                            + (matrizConv[i][j - 1]    )
                            + (matrizConv[i+1][j]      )
                            + (matrizConv[i-1][j]      )
                            + (matrizConv[i+1][j+1]    )
                            + (matrizConv[i+1][j-1]    )
                            + (matrizConv[i-1][j+1]    )
                            + (matrizConv[i-1][j-1]    )
                            )/3.75) * increment
                    );
                     if (matrizConv [i][j]> 255){
                        matrizConv [i][j] = 255;
                    }
                }
            }
        } else {
            for (int i = 1; i < matrizConv.length - 1; i++) {
                for (int j = matrizConv[0].length - 2; j >= 0; j--) {
//                         System.out.println("a");
                    matrizConv[i][j] = (int) ((matrizConv[i][j + 1] 
                    + matrizConv[i + 1][j + 1] + matrizConv[i - 1][j + 1]
                    + matrizConv[i - 1][j] + matrizConv[i][j]) / 3.25);
                    if (matrizConv [i][j]> 255){
                        matrizConv [i][j] = 255;
                    }
                }
            }
        }
    }

    //CreateFlameImage
    public void createFlameImage() {
//        System.out.println("Creamos las llamas");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                int p = this.getFlamePalette().getColor(matriz[i][j]);
                this.setRGB(i, j, p);
            }
        }
    }
    
    public void createFlameImageConv() {
        BufferedImage comodin = new BufferedImage (400,400,BufferedImage.TYPE_INT_ARGB);
//        System.out.println("Creamos las llamas");
        for (int i = 0; i < matrizConv.length; i++) {
            for (int j = 0; j < matrizConv[0].length; j++) {
                int p = this.getFlamePalette().getColor(matrizConv[i][j]);
                this.setRGB(i, j, p);
                
            }
        }
        this.getGraphics().drawImage(comodin, 0, 0, null);
    }
    
    public void cleanFlame(){
        if (convoluted){
            for (int i = 0; i < matrizConv.length; i++) {
                for (int j = 0; j < matrizConv[0].length; j++) {
                    matrizConv[i][j]=0;
                }
            }
        }else {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    matriz[i][j]=0;
                }
            }
        }
    }
    
    
   
    public void actualizar() {
        
        if (convoluted){
            //Sparks
            this.findSparksConvoluted();
            //EvolveTemperature
            this.EvolveTemperatureConv();
            //CreateFlameImage
            this.createFlameImageConv();
        } else {
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
