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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
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
    JSlider sliderSparks, sliderCools, sliderSpeed;
    JCheckBox cb;
    JFileChooser chooser;
    newEvents e = new newEvents ();
    String ruta;

    public ControlPanel(MyFlame myflame, Viewer viewer){
        this.viewer = viewer;
        this.myflame = myflame;
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createLineBorder(Color.white));
        this.setLayout(null);
        initComponents();
    }
    
    private void initComponents (){
        addLabels();
        addButtons();
        addCheckbox();
        addSliders();
    }
    
    private void addLabels(){
        titulo = new JLabel("Control Panel");
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(95, 0, 300, 80);
        titulo.setFont(new Font ("arial",1, 24));
        this.add(titulo);
        
        sparks = new JLabel("Value of Sparks");
        sparks.setForeground(Color.WHITE);
        sparks.setBounds(5, 200, 100, 80);
        sparks.setFont(new Font ("arial",3, 12));
        this.add(sparks);
        
        cool = new JLabel("Value of Cool");
        cool.setForeground(Color.WHITE);
        cool.setBounds(95, 200, 100, 80);
        cool.setFont(new Font ("arial",3, 12));
        this.add(cool);
        
        speed = new JLabel("Fire Speed");
        speed.setForeground(Color.WHITE);
        speed.setBounds(5, 550, 75, 50);
        speed.setFont(new Font ("arial",2, 12));
        this.add(speed);
    }
    private void addButtons(){
        btn1 = new JButton ();
        btn1.setBounds(5, 100, 90, 90);
        btn1.setBackground(Color.DARK_GRAY);
        ImageIcon play = new ImageIcon ("src/Images/play.png");
        btn1.setIcon(new ImageIcon(play.getImage().getScaledInstance(btn1.
                getWidth(),btn1.getHeight(), Image.SCALE_SMOOTH)));
        btn1.setActionCommand("btn1");
        btn1.addActionListener(e);
        this.add(btn1);
        
        btn2 = new JButton ();
        btn2.setBounds(98, 100, 100, 90);
        btn2.setBackground(Color.DARK_GRAY);
        ImageIcon pause = new ImageIcon ("src/Images/pause.png");
        btn2.setIcon(new ImageIcon(pause.getImage().getScaledInstance(btn2.
                getWidth(),btn2.getHeight(), Image.SCALE_SMOOTH)));
        btn2.setActionCommand("btn2");
        btn2.addActionListener(e);
        this.add(btn2);
        
        btn3 = new JButton ();
        btn3.setBounds(5, 550, 150, 50);
        btn3.setActionCommand("btn3");
        btn3.setText("Cambiar Fondo");
        btn3.addActionListener(e);
        this.add(btn3);

        btn4 = new JButton ();
        btn4.setBounds(98, 100, 100, 90);
        btn4.setBackground(Color.DARK_GRAY);
        btn4.setActionCommand("btn2");
        btn4.addActionListener(e);
        this.add(btn4);
        
    }
    
    private void addCheckbox(){
        cb = new JCheckBox ("Viento");
        cb.setBounds(5, 450, 75, 50);
        cb.setForeground(Color.WHITE);
        cb.setBackground(Color.DARK_GRAY);
        cb.addItemListener(e);
        this.add(cb);
    }
    
    private void addSliders(){
        sliderSparks = new JSlider (JSlider.VERTICAL, 0, 200, myflame.getSPARKS());
        sliderSparks.setBounds(5, 250, 65, 150);
        sliderSparks.setInverted(false);
        sliderSparks.setMinorTickSpacing(10);
        sliderSparks.setMajorTickSpacing(25);
        sliderSparks.setPaintTicks(true);
        sliderSparks.setPaintLabels(true);
        sliderSparks.addChangeListener(e);
        this.add(sliderSparks);
        
        sliderCools = new JSlider (JSlider.VERTICAL, 0, 100, myflame.getCOOL());
        sliderCools.setBounds(95, 250, 60, 150);
        sliderCools.setInverted(false);
        sliderCools.setMinorTickSpacing(10);
        sliderCools.setMajorTickSpacing(25);
        sliderCools.setPaintTicks(true);
        sliderCools.setPaintLabels(true);
        sliderCools.addChangeListener(e);
        this.add(sliderCools);
        
        sliderSpeed = new JSlider (JSlider.HORIZONTAL, 0, 100, (int) myflame.getSpeed());
        sliderSpeed.setBounds(5, 550, 400, 50);
        sliderSpeed.setInverted(true);
        sliderSpeed.setMinorTickSpacing(10);
        sliderSpeed.setMajorTickSpacing(25);
        sliderSpeed.setPaintTicks(true);
        sliderSpeed.setPaintLabels(true);
        sliderSpeed.addChangeListener(e);
        this.add(sliderSpeed);
    }
    
    private void FileChooser(){
        chooser = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("jpg","png","gif","jfif","jpeg");
        chooser.setFileFilter(filtrado);
        
        int respuesta = chooser.showOpenDialog(this);
        
        if (respuesta == JFileChooser.APPROVE_OPTION){
            ruta = chooser.getSelectedFile().getPath();
            viewer.setImgfile(ruta);
        }
    }
    
    //Revisar Eventos están generados a partir de Statics
    private class newEvents implements ChangeListener, ActionListener, ItemListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            myflame.setSPARKS(sliderSparks.getValue());
            myflame.setCOOL(sliderCools.getValue());
            myflame.setSpeed(sliderSpeed.getValue());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            switch (e.getActionCommand()){
                case "btn1":
                    myflame.resume();
                    break;
                case "btn2":
                    myflame.paused();
                    break;
                case "btn3":
                    FileChooser();
                    System.out.println("Cambiamos imagen");
                    break;
                case "btn4":
                    myflame.blizzard();
                    break;
            }          
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (cb.isSelected()){
                myflame.blizzard();
            } else if (!cb.isSelected()){
                myflame.notBlizzard();
            }
        }
    }
}