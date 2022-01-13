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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author David
 */
public class ControlPanel extends JPanel {
    MyFlame myflame;
    JLabel titulo, sparks, cool;
    JButton btn1, btn2, btn3;
    JSlider sliderSparks, sliderCools;
    JCheckBox cb;
    newEvents e = new newEvents ();
    ActionListener bp, bpause;
    
    public ControlPanel(MyFlame myflame) {
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
        titulo.setBounds(75, 0, 300, 80);
        titulo.setFont(new Font ("arial",1, 24));
        this.add(titulo);
        
        sparks = new JLabel("Value of Sparks");
        sparks.setForeground(Color.WHITE);
        sparks.setBounds(5, 200, 100, 80);
        sparks.setFont(new Font ("arial",2, 12));
        this.add(sparks);
        
        cool = new JLabel("Value of Cool");
        cool.setForeground(Color.WHITE);
        cool.setBounds(155, 200, 100, 80);
        cool.setFont(new Font ("arial",2, 12));
        this.add(cool);
    }
    private void addButtons(){
        btn1 = new JButton ();
        btn1.setBounds(5, 100, 90, 90);
        btn1.setBackground(Color.DARK_GRAY);
        ImageIcon play = new ImageIcon ("src/Images/play.png");
        btn1.setIcon(new ImageIcon(play.getImage().getScaledInstance(btn1.
                getWidth(),btn1.getHeight(), Image.SCALE_DEFAULT)));
        btn1.setActionCommand("btn1");
        btn1.addActionListener(e);
        this.add(btn1);
        
        btn2 = new JButton ();
        btn2.setBounds(98, 100, 100, 90);
        btn2.setBackground(Color.DARK_GRAY);
        ImageIcon pause = new ImageIcon ("src/Images/pause.png");
        btn2.setIcon(new ImageIcon(pause.getImage().getScaledInstance(btn2.
                getWidth(),btn2.getHeight(), Image.SCALE_DEFAULT)));
        btn2.setActionCommand("btn2");
        btn2.addActionListener(e);
        this.add(btn2);
    }
    
    private void addCheckbox(){
        cb = new JCheckBox ("Viento");
        cb.setBounds(5, 450, 75, 50);
        cb.setForeground(Color.WHITE);
        cb.setBackground(Color.DARK_GRAY);
        cb.addActionListener(e);
        this.add(cb);
    }
    
    private void addSliders(){
        sliderSparks = new JSlider (JSlider.VERTICAL, 0, 200, myflame.getSPARKS());
        sliderSparks.setBounds(5, 250, 100, 150);
        sliderSparks.setInverted(false);
        sliderSparks.setMinorTickSpacing(10);
        sliderSparks.setMajorTickSpacing(25);
        sliderSparks.setPaintTicks(true);
        sliderSparks.setPaintLabels(true);
        sliderSparks.addChangeListener(e);
        this.add(sliderSparks);
        
        sliderCools = new JSlider (JSlider.VERTICAL, 0, 200, myflame.getCOOL());
        sliderCools.setBounds(155, 250, 100, 150);
        sliderCools.setInverted(false);
        sliderCools.setMinorTickSpacing(10);
        sliderCools.setMajorTickSpacing(25);
        sliderCools.setPaintTicks(true);
        sliderCools.setPaintLabels(true);
        sliderCools.addChangeListener(e);
        this.add(sliderCools);
    }
    //Revisar Eventos están generados a partir de Statics
    private class newEvents implements ChangeListener, ActionListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            myflame.setSPARKS(sliderSparks.getValue());
            myflame.setCOOL(sliderCools.getValue());
            
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
            }
            if (cb.isSelected()){
                myflame.blizzard();
            }            
        }
    }
}