/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlameTask;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author David
 */
public class ControlPanel extends JPanel {

    MyFlame myflame;
    Viewer viewer;
    JLabel titulo, sparks, cool, speed;
    JButton btn1, btn2, btn3, btn4;
    JSlider sliderSparks, sliderCools, sliderSpeed, colorRed;
    JFileChooser chooser;
    JToggleButton blizzard;
    JRadioButton rVerde, rRojo, rAzul, rLila;
    newEvents e = new newEvents();
    String ruta, filepath;;
    

    public ControlPanel(MyFlame myflame, Viewer viewer) {
        this.myflame = myflame;
        this.viewer = viewer;
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createLineBorder(Color.white));
        this.setLayout(null);
        initComponents();
    }

    private void initComponents() {
        addLabels();
        addButtons();
        addSliders();
        addToggleButton();
        addRadioButtons();
    }

    private void addLabels() {
        titulo = new JLabel("Control Panel");
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(95, 0, 300, 80);
        titulo.setFont(new Font("arial", 1, 24));
        this.add(titulo);

        sparks = new JLabel("Value of Sparks");
        sparks.setForeground(Color.WHITE);
        sparks.setBounds(5, 200, 100, 80);
        sparks.setFont(new Font("arial", 3, 12));
        this.add(sparks);

        cool = new JLabel("Value of Cool");
        cool.setForeground(Color.WHITE);
        cool.setBounds(105, 200, 100, 80);
        cool.setFont(new Font("arial", 3, 12));
        this.add(cool);

        speed = new JLabel("Fire Pause");
        speed.setForeground(Color.WHITE);
        speed.setBounds(5, 410, 75, 50);
        speed.setFont(new Font("arial", 3, 12));
        this.add(speed);
    }

    private void addButtons() {
        btn1 = new JButton();
        btn1.setBounds(35, 100, 80, 80);
        btn1.setBorder(null);
        btn1.setBackground(Color.DARK_GRAY);
        ImageIcon play = new ImageIcon("src/Images/play.png");
        btn1.setIcon(new ImageIcon(play.getImage().getScaledInstance(btn1.
                getWidth(), btn1.getHeight(), Image.SCALE_SMOOTH)));
        btn1.setActionCommand("btn1");
        btn1.addActionListener(e);
        this.add(btn1);

        btn2 = new JButton();
        btn2.setBounds(125, 100, 80, 80);
        btn2.setBorder(null);
        btn2.setBackground(Color.DARK_GRAY);
        ImageIcon pause = new ImageIcon("src/Images/pause.png");
        btn2.setIcon(new ImageIcon(pause.getImage().getScaledInstance(btn2.
                getWidth(), btn2.getHeight(), Image.SCALE_SMOOTH)));
        btn2.setActionCommand("btn2");
        btn2.addActionListener(e);
        this.add(btn2);

        btn3 = new JButton();
        btn3.setBounds(205, 550, 150, 50);
        btn3.setBorder(null);
        btn3.setActionCommand("btn3");
        btn3.setText("Cambiar Fondo");
        btn3.addActionListener(e);
        this.add(btn3);
    }
    
    private void addToggleButton(){
        blizzard = new JToggleButton("Viento");
        blizzard.setBounds(215, 100, 80, 80);
        blizzard.setBorder(null);
        blizzard.setBackground(Color.DARK_GRAY);
        ImageIcon blizzar = new ImageIcon("src/Images/viento.png");
        blizzard.setIcon(new ImageIcon(blizzar.getImage().getScaledInstance(blizzard.
                getWidth(), blizzard.getHeight(), Image.SCALE_SMOOTH)));
        blizzard.setActionCommand("blizzard");
        blizzard.addActionListener(e);
        this.add(blizzard);
    }

    private void addSliders() {
        sliderSparks = new JSlider(JSlider.VERTICAL, 0, 100, myflame.getSPARKS());
        sliderSparks.setBounds(10, 250, 65, 150);
        sliderSparks.setInverted(false);
        sliderSparks.setMinorTickSpacing(10);
        sliderSparks.setMajorTickSpacing(25);
        sliderSparks.setPaintTicks(true);
        sliderSparks.setPaintLabels(true);
        sliderSparks.addChangeListener(e);
        sliderSparks.setName("Sparks");
        this.add(sliderSparks);

        sliderCools = new JSlider(JSlider.VERTICAL, 0, 100, myflame.getCOOL());
        sliderCools.setBounds(105, 250, 60, 150);
        sliderCools.setInverted(false);
        sliderCools.setMinorTickSpacing(10);
        sliderCools.setMajorTickSpacing(25);
        sliderCools.setPaintTicks(true);
        sliderCools.setPaintLabels(true);
        sliderCools.addChangeListener(e);
        this.add(sliderCools);

        sliderSpeed = new JSlider(JSlider.HORIZONTAL, 0, 100, (int) myflame.getSpeed());
        sliderSpeed.setBounds(5, 450, 350, 50);
        sliderSpeed.setInverted(false);
        sliderSpeed.setMinorTickSpacing(10);
        sliderSpeed.setMajorTickSpacing(25);
        sliderSpeed.setPaintTicks(true);
        sliderSpeed.setPaintLabels(true);
        sliderSpeed.addChangeListener(e);
        this.add(sliderSpeed);
        
        colorRed = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        
        colorRed.setInverted(false);
        colorRed.setMinorTickSpacing(10);
        colorRed.setMajorTickSpacing(25);
        colorRed.setPaintTicks(true);
        colorRed.setPaintLabels(true);
        colorRed.addChangeListener(e);
        this.add(colorRed);
        
        
    }

    private void FileChooser() {
        filepath="";
        chooser = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("jpg", "gif", "jfif", "jpeg");
        chooser.setFileFilter(filtrado);

        int respuesta = chooser.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            filepath = chooser.getSelectedFile().getPath();
            System.out.println("PATH = "+ filepath);
            myflame.viewer.setFilepath(filepath);
        }
    }
    
    private void addRadioButtons(){
        rVerde = new JRadioButton("Green");
        rVerde.setBounds(5, 600, 90, 90);
        rVerde.setForeground(Color.GREEN);
        rVerde.setBackground(Color.DARK_GRAY);
        rVerde.addActionListener(e);
        ImageIcon green = new ImageIcon("src/Images.fondoVerde.png");
        rVerde.setIcon(new ImageIcon(green.getImage().getScaledInstance(rVerde.
                getWidth(), rVerde.getHeight(), Image.SCALE_SMOOTH)));
        
        
        rRojo = new JRadioButton ("Red");
        rRojo.setBounds(105,600,90,90);
        rRojo.setForeground(Color.RED);
        rRojo.setBackground(Color.DARK_GRAY);
        rRojo.setSelected(true);
        rRojo.addActionListener(e);
        ImageIcon red = new ImageIcon("src/Images/fuegofondo.jpg");
        rRojo.setIcon(new ImageIcon(red.getImage().getScaledInstance(rRojo.
                getWidth(), rRojo.getHeight(), Image.SCALE_SMOOTH)));
        
        rAzul = new JRadioButton ("Blue");
        rAzul.setBounds(205,600,90,90);
        rAzul.setForeground(Color.BLUE);
        rAzul.setBackground(Color.DARK_GRAY);
        rAzul.addActionListener(e);
        ImageIcon blue = new ImageIcon("src/Images/fuegoAzul.png");
        rAzul.setIcon(new ImageIcon(blue.getImage().getScaledInstance(rAzul.
                getWidth(), rAzul.getHeight(), Image.SCALE_SMOOTH)));
        
        rLila = new JRadioButton ("Purple");
        rLila.setBounds(300,600,90,90);
        rLila.setForeground(Color.BLUE);
        rLila.setBackground(Color.DARK_GRAY);
        rLila.addActionListener(e);
        ImageIcon lila = new ImageIcon("src/Images/fondoLila.png");
        rLila.setIcon(new ImageIcon(lila.getImage().getScaledInstance(rLila.
                getWidth(), rLila.getHeight(), Image.SCALE_SMOOTH)));
        
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rVerde);
        bg.add(rRojo);
        bg.add(rAzul);
        bg.add(rLila);
        
        this.add(rVerde);
        this.add(rRojo);
        this.add(rAzul);
        this.add(rLila);
    }

    //Revisar Eventos están generados a partir de Statics
    private class newEvents implements ChangeListener, ActionListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            myflame.setSPARKS(sliderSparks.getValue());
            myflame.setCOOL(sliderCools.getValue());
            myflame.setSpeed(sliderSpeed.getValue());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            switch (e.getActionCommand()) {
                case "btn1":
                    myflame.resume();
                    break;
                case "btn2":
                    myflame.paused();
                    break;
                case "btn3":
                    FileChooser();
                    break;
                case "blizzard":
                    if (blizzard.isSelected()) {
                        myflame.blizzard();
                    } else{
                        myflame.notBlizzard();
                }
                    break;
            }
            if (rVerde.isSelected()){
                myflame.viewer.setPaletaAzul(false);
                myflame.viewer.setPaletaRoja(false);
                myflame.viewer.setPaletaLila(false);
                myflame.viewer.setPaletaVerde(true);
                
            } else if (rAzul.isSelected()){
                myflame.viewer.setPaletaRoja(false);
                myflame.viewer.setPaletaVerde(false);
                myflame.viewer.setPaletaLila(false);
                myflame.viewer.setPaletaAzul(true);
            }else if (rLila.isSelected()){
                myflame.viewer.setPaletaRoja(false);
                myflame.viewer.setPaletaVerde(false);
                myflame.viewer.setPaletaAzul(false);
                myflame.viewer.setPaletaLila(true);
            } else{
                myflame.viewer.setPaletaAzul(false);
                myflame.viewer.setPaletaVerde(false);
                myflame.viewer.setPaletaLila(false);
                myflame.viewer.setPaletaRoja(true);
            }
        }
    }        
}
