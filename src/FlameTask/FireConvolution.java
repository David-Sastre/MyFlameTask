///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package FlameTask;
//
//import java.awt.Color;
//import java.awt.image.BufferedImage;
//
///**
// *
// * @author David
// */
//public class FireConvolution extends BufferedImage implements Runnable{
//    
//    private MyFlame myflame;
//    private BufferedImage imageConvolution;
//    private int [][] matriz;
//    private float brightness = 0.0f;
//    private int width;
//    private int height;
//    
//   
//
//    //Métodos
//    public FireConvolution(int width, int height, int imageType, MyFlame myflame) {
//        super(width, height, imageType);
//        this.myflame = myflame;
//    }
//
//    public void setImagencopia(BufferedImage imageConvolution) {
//        this.width = imageConvolution.getWidth();
//        this.height = imageConvolution.getHeight();
//        this.imageConvolution = imageConvolution;
//        createSparksConvoluted();
//    }
//
//    
//    public void createSparksConvoluted() {
//        System.out.println("buscamos pixels");
//        matriz = new int [this.width][this.height];
//        System.out.println(matriz);
//        int red = 0;
//        int green = 0;
//        int blue = 0;
//        for (int i = 1; i < this.getWidth()-1; i++) {
//            System.out.println("entramos bucle");
//            for (int j = 1; j < this.getHeight() - 1; j++) {
//                red = new Color(imageConvolution.getRGB(i, j)).getRed();
//                green = new Color(imageConvolution.getRGB(i, j)).getGreen();
//                blue = new Color(imageConvolution.getRGB(i, j)).getBlue();
//                brightness = (red * 0.2116f + green * 0.7152f + blue * 0.0722f) / 255;
//                System.out.println(brightness);
//                if (brightness > 0.2) {
//                    System.out.println("pintara pixel");
//                    matriz[i][j]=255;
//
//                } else {
//                    matriz[i][j] = 0;
//                }
//            }       
//        }
//        System.out.println(red);
//        System.out.println(green);
//        System.out.println(blue);
//    }
//    public void createCoolConv() {
//        for (int i = 0; i < matriz.length; i++) {
//            int aux = (int) (Math.random() * 400);
//            if (aux <= myflame.getCOOL()) {
//                matriz[i][matriz.length - 1] = 0;
//            }
//        }
//    }
//    
//
//    
////}
////    public void EvolveTemperatureConvoluted() {
////        if (!isBlizzard) {
//////            System.out.println("Evolución del fuego");
////            for (int j = matriz[0].length - 2; j >= 0; j++) {
////                for (int i = 1; i < matriz.length - 1; i++) {
////                    matriz[i][j] = (int) (((matriz[i][j + 1] + matriz[i + 1][j + 1]
////                            + matriz[i - 1][j + 1] + matriz[i - 1][j] + matriz[i + 1][j]
////                            + matriz[i][j]) / 6) + increment);
////                }
////            }
////        } else {
////            for (int i = 1; i < matriz.length - 1; i++) {
////                for (int j = matriz[0].length - 2; j >= 0; j--) {
////                    matriz[i][j] = (int) ((matriz[i][j + 1] + matriz[i + 1][j + 1] + matriz[i - 1][j + 1] + matriz[i - 1][j] + matriz[i][j]) / 5 - increment);
////                }
////            }
////        }
////    }
////    
////    
////   public void createCoolConv() {
////        for (int i = 0; i < matriz.length; i++) {
////            int aux = (int) (Math.random() * 400);
////            if (aux <= this.getCOOL()) {
////                matriz[i][matriz.length - 1] = 0;
////            }
////        }
////    }
////    
////    public void createFlameImageConvoluted() {
//////        System.out.println("Creamos las llamas");
////        for (int i = 0; i < matriz.length; i++) {
////            for (int j = 0; j < matriz[i].length; j++) {
////                int p = this.getFlamePalette().getColor(matriz[i][j]);
////                this.setRGB(i, j, p);
////            }
////        }
////    }
//    
//    
//
//    @Override
//    public void run() {
//        while (true) {
//            System.out.println("iniciamos thread convolucion");
//            try {
//                Thread.sleep(70);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//                //findSparks
//                this.createSparksConvoluted();
//                //CreateCool
//                this.createCoolConv();
////                //EvolveTemperature
////                this.EvolveTemperatureConvoluted();
////                //CreateFlameImage
////                this.createFlameImageConvoluted();        
//        }
//    }
//}
//   
