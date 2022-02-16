/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlameTask;

/**
 *
 * @author David
 */
public class FlameBase extends Flame{

    public FlameBase(int width, int height, int imageType, MyFlame myflame, Convolution convolution) {
        super(width, height, imageType, myflame, convolution);
    }
    
    /**
     * Metodos de Flame que se sobreescribe.
     */
    @Override
    public void createSparks() {
        //        System.out.println("Se crean las chispas");
        for (int i = 0; i < matriz.length; i++) {
            int aux = (int) (Math.random() * 99);
            if (aux <= SPARKS) {
                matriz[i][matriz.length - 1] = 255;
            }
        }
    }
    
    /**
     *
     */
    @Override
    public void createCool() {
        for (int i = 0; i < matriz.length; i++) {
            int aux = (int) (Math.random() * 99);
            if (aux <= COOL) {
                matriz[i][matriz.length - 1] = 0;
            }
        }
    }
    
    @Override
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
    
    /**
     *
     */
    @Override
    public void createFlameImage() {
//        System.out.println("Creamos las llamas");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                int p = this.getFlamePalette().getColor(matriz[i][j]);
                this.setRGB(i, j, p);
            }
        }
    }
    public void actualizar() {
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

