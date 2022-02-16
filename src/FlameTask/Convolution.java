/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlameTask;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author David
 */
public class Convolution {

    private BufferedImage copia;
    int[][] R;
    int[][] G;
    int[][] B;
    int[][] conv;
    int pixel;
    int num1, num2, num3, num4, num5, num6, num7, num8, num9;
    
    private int [][] kernelInicial = {
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0}  
    };
    private int[][] repujado = {
        {-2, -1, 0},
        {-1,  1, 1},
        {0,  1, 2}                               
    };
    private int[][] bordes = {
        {0,  1, 0},
        {1, -4, 1},
        {0,  1, 0}
    };
    
    private int [][] bordesVerticales = {
        {1, 0, -1},
        {1, 0, -1},
        {1, 0, -1} 
    };
    
    private int [][] nitidez ={
        {-1, -1, -1},
        {-1, 9, -1},
        {-1, -1, -1} 
    };
    
    private int [][] enfoque ={
        {0, -1, 0},
        {-1, 5, -1},
        {0, -1, 0}
    };
    
    private int [][] desenfoque = {
        {1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}  
    };
    
    private int [][] personalizado = {
        {0,  0, 0},
        {0,  0, 0},
        {0,  0, 0},
    };
    
    private int [][] kernelSelected = kernelInicial;
    
    private int divisor = sumKernel();
    
    
    //Constructor vacio
    public Convolution() {
      
    }

    // Getters Setter
    public BufferedImage getCopia() {
        return copia;
    }

    public void setCopia(BufferedImage copia) {
        this.copia = copia;
    }

    public int[][] getConv() {
        return conv;
    }

    public int[][] getKernelSelected() {
        return kernelSelected;
    }

    public void setKernelSelected(int[][] kernelSelected) {
        this.kernelSelected = kernelSelected;
    }

    public int[][] getKernelInicial() {
        return kernelInicial;
    }

    public void setKernelInicial(int[][] kernelInicial) {
        this.kernelInicial = kernelInicial;
    }

    public int[][] getBordes() {
        return bordes;
    }

    
    public int[][] getNitidez() {
        return nitidez;
    }
    
     public int[][] getRepujado() {
        return repujado;
    }

    public int[][] getBordesVerticales() {
        return bordesVerticales;
    }

    public int[][] getEnfoque() {
        return enfoque;
    }

    public int[][] getDesenfoque() {
        return desenfoque;
    }

    public int[][] getPersonalizado() {
        return personalizado;
    }

    public void setPersonalizado(int[][] personalizado) {
        this.personalizado = personalizado;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }
    
    

    //Métodos
    private int[][] imageToArray() {
        int width = copia.getWidth();
        int height = copia.getHeight();
        R = new int[width][height];
        G = new int[width][height];
        B = new int[width][height];
        int[][] conv = new int[width][height];
        //Recorremos cada posición de la imagen.
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = new Color(copia.getRGB(x, y));
                R[x][y] = color.getRed();
                G[x][y] = color.getGreen();
                B[x][y] = color.getBlue();
     

                int pixel = ((R[x][y] + G[x][y] + B[x][y])/3);
                conv[x][y] = pixel;
            }
        }
        return conv;
    }
    
    private int sumKernel() {
        int suma = 0;
        for (int i = 0; i < kernelSelected.length; i++) {
            for (int j = 0; j < kernelSelected.length; j++) {

                suma += kernelSelected[i][j];
            }

        }
        if (suma <= 0) {
            suma = 1;
        }
        divisor = suma;
        return divisor;
    }

    public void calculoPixel() {
        int[][] matriz = imageToArray();
        int rgb = 0;
        int reds = 0;
        int greens = 0;
        int blues = 0;
        for (int x = 1; x < matriz.length - 1; x++) {
            for (int y = 1; y < matriz[0].length - 1; y++) {
                
                reds = ((R[x-1][y-1] * (kernelSelected[0][0]))
                        + (R[x][y - 1] * (kernelSelected[1][0]))
                        + (R[x + 1][y - 1] * (kernelSelected[2][0]))
                        + (R[x - 1][y] * (kernelSelected[0][1]))
                        + (R[x][y] * (kernelSelected[1][1]))
                        + (R[x + 1][y] * (kernelSelected[2][1]))
                        + (R[x - 1][y + 1] * (kernelSelected[0][2]))
                        + (R[x][y + 1] * (kernelSelected[1][2]))
                        + (R[x + 1][y + 1] * (kernelSelected[2][2])));
                greens = ((G[x - 1][y - 1] * (kernelSelected[0][0]))
                        + (G[x][y - 1] * (kernelSelected[1][0]))
                        + (G[x + 1][y - 1] * (kernelSelected[2][0]))
                        + (G[x - 1][y] * (kernelSelected[0][1]))
                        + (G[x][y] * (kernelSelected[1][1]))
                        + (G[x + 1][y] * (kernelSelected[2][1]))
                        + (G[x - 1][y + 1] * (kernelSelected[0][2]))
                        + (G[x][y + 1] * (kernelSelected[1][2]))
                        + (G[x + 1][y + 1] * (kernelSelected[2][2])));
                blues = ((B[x - 1][y - 1] * (kernelSelected[0][0]))
                        + (B[x][y - 1] * (kernelSelected[1][0]))
                        + (B[x + 1][y - 1] * (kernelSelected[2][0]))
                        + (B[x - 1][y] * (kernelSelected[0][1]))
                        + (B[x][y] * (kernelSelected[1][1]))
                        + (B[x + 1][y] * (kernelSelected[2][1]))
                        + (B[x - 1][y + 1] * (kernelSelected[0][2]))
                        + (B[x][y + 1] * (kernelSelected[1][2]))
                        + (B[x + 1][y + 1] * (kernelSelected[2][2])));
                reds = (int) (reds / divisor);
                greens = (int) (greens / divisor);
                blues = (int) (blues / divisor);
               
                if (reds < 0) {
                    reds = 0;
                } else if (reds > 255) {
                    reds = 255;
                }
                if (greens < 0) {
                    greens = 0;
                } else if (greens > 255) {
                    greens = 255;
                }
                if (blues < 0) {
                    blues = 0;
                } else if (blues > 255) {
                    blues = 255;
                }
                rgb = reds << 16 | greens << 8 | blues;
                copia.setRGB(x, y, new Color(rgb).getRGB());
            }
        }
    }  
}
