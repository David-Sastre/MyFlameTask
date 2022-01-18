/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlameTask;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;



/**
 *
 * @author David
 */
public class MyFlame extends JFrame{
    private String filepath;
    Viewer viewer;
    Thread thread;
    Flame flame;
    ControlPanel controlPanel;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MyFlame app = new MyFlame();
        
    }
    
    public MyFlame (){
        //Indicamos el nombre de la ventana
        super("Fuego");
        flame = new Flame (700,700,2);
        crearEstructura();
        //Iniciamos el hilo.
        thread = new Thread(viewer);
        thread.start();
        //Al cerrar el JFrame salimos de la aplicación.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void crearEstructura() {
        //creamos el layout de la ventana
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        //creamos el control panel
        controlPanel = new ControlPanel(this, viewer);
        //añadimos la altura y ancho minimo
        controlPanel.setMinimumSize(new Dimension(400,100));
        controlPanel.setPreferredSize(new Dimension(400,100));
        controlPanel.setMaximumSize(new Dimension(400, 100));
        controlPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
        //y lo añadimos al layout
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1f;
        gbc.weightx = 0.0f;
        this.add(controlPanel, gbc);
        
        //creamos el viewer
        viewer = new Viewer(flame);
        //Añadimos el Viewer al JFrame
        gbc.gridx = 1;
        gbc.weightx = 0.8f;
        gbc.weighty = 1f;
        this.add(viewer, gbc);
        
        //Indicamos las medidas del JFrame
        this.setSize(1100,800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //Hacemos visible el JFrame
        this.setVisible(true);
        
    }
    public void setSPARKS(int sparks){
        flame.setSPARKS(sparks);
    }
    
    public int getSPARKS(){
        return flame.getSPARKS();
    }
    
    public void setCOOL(int cool){
        flame.setCOOL(cool);
    }
    
    public int getCOOL(){
        return flame.getCOOL();
    }
    
    public void paused (){
        flame.setIsRunning(false);
    }
    public void resume (){
        flame.setIsRunning(true);
    }
    
    public void blizzard (){
        flame.setIsBlizzard(true);
    }
    
    public void notBlizzard (){
        flame.setIsBlizzard(false);
    }
    
    public void setSpeed(long speed){
        flame.setSpeed(speed);
    }
    
    public long getSpeed(){
        return flame.getSpeed();
    }
    
    public void setFilepath(String filepath){
        this.viewer.setFilepath(filepath);
    }
}

